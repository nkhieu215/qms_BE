package com.fn.qms.services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import com.fn.planing.r2.ScanQRCheckNVLResponse;
import com.fn.planing.rest.DnlNvlResponse;
import com.fn.qms.constant.Constant;
import com.fn.qms.dto.DrawNvlImageDTO;
import com.fn.qms.dto.PqcDrawNvlTestDTO;
import com.fn.qms.models.PqcNvlImage;
import com.fn.qms.models.PqcWorkOrder;
import com.fn.qms.repository.PqcImageNvlRepository;
import com.fn.qms.repository.PqcWorkOrderRepository;
import com.fn.qms.rest.PqcWorkOrderResponse;
import com.fn.qms.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.dto.DrawTestNvlDTO;
import com.fn.qms.dto.NvlCreateDTO;
import com.fn.qms.models.PqcDrawNvl;
import com.fn.qms.models.PqcDrawTestNvl;
import com.fn.qms.planning.model.Feeder;
import com.fn.qms.planning.model.PartNumber;
import com.fn.qms.planning.model.PartNumberDetail;
import com.fn.qms.planning.service.ProfileService;
import com.fn.qms.repository.PqcDrawNVLCheckRepository;
import com.fn.qms.repository.PqcDrawNvlRepository;
import com.fn.qms.rest.NvlResponse;
import com.fn.qms.rest.ProfileResponse;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
public class NVLService {
	@Autowired
	PqcWorkOrderRepository pqcWorkOrderRepository;

	@Autowired
	PqcDrawNvlRepository pqcDrawNvlRepository;
	@Autowired
	PqcImageNvlRepository pqcImageNvlRepository;

	@Autowired
	PqcDrawNVLCheckRepository drawNvlTest;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	StorageService storageService;

	public NvlResponse createNvlCheck(NvlCreateDTO dto) {
		Validator.Result result = Validator.Result.OK;
		NvlResponse response = new NvlResponse();
		PqcDrawNvl draw = modelMapper.map(dto, PqcDrawNvl.class);
		if(draw.getId() != null){
			PqcDrawNvl checkDraw  = pqcDrawNvlRepository.findAllById(draw.getId());
			draw.setCreatedAt(checkDraw.getCreatedAt());
			draw.setUpdatedAt(new Date());
		}
		pqcDrawNvlRepository.save(draw);

		if (dto.getLstPqcDrawNvl() != null && !dto.getLstPqcDrawNvl().isEmpty()) {
			for (PqcDrawTestNvl drawTestNvl : draw.getLstPqcDrawNvl()) {
				drawTestNvl.setPqcDrawNvlId(draw.getId());
				drawTestNvl.setWorkOrderId(dto.getWorkOrderId());
				drawNvlTest.save(drawTestNvl);
			}
		}

		PqcWorkOrder pqcWorkOrder =pqcWorkOrderRepository.findById(dto.getWorkOrderId()).get();
		Utils.buildPqcWarning(Constant.NVL,draw.getCheckPerson(),pqcWorkOrder, draw.getConclude(), draw.getNote());

		response.setId(draw.getId());
		response.setResult(result);
		return response;
	}

	public NvlResponse removeById(Long id) {
		Validator.Result result = Validator.Result.OK;
		NvlResponse response = new NvlResponse();
		PqcDrawNvl drawNvl = pqcDrawNvlRepository.getOne(id);

		if (drawNvl != null) {
			pqcDrawNvlRepository.deleteByIdNVL(drawNvl.getId());
			drawNvlTest.deleteFromDrawId(id);
		}
		response.setResult(result);
		return response;
	}

	public NvlResponse getLstCheckByOrderId(Long id) {
		Validator.Result result = Validator.Result.OK;
		NvlResponse response = new NvlResponse();
		List<PqcDrawTestNvl> lstnvl =  drawNvlTest.getLstCheckByOrderId(id);		 
		List<PqcDrawNvlTestDTO> lstDraw = Arrays.asList(modelMapper.map(lstnvl, PqcDrawNvlTestDTO[].class));
		response.setLstDraw(lstDraw);
		return response;
	}

	public NvlResponse uploadImage(Long id ,Long woId, MultipartFile[] files) {
		Validator.Result result = Validator.Result.OK;
		NvlResponse response = new NvlResponse();

		List<String> lstImage  = storageService.store(files, Constant.FOLDER_NVL);
		if(!lstImage.isEmpty()){
			PqcNvlImage img;
			for (String imgPath:lstImage) {
				 img = new PqcNvlImage();
				 img.setPqcDrawNvlId(id);
				 img.setUrlPath(imgPath);
				 img.setWoId(woId);
				pqcImageNvlRepository.save(img);
			}
		}
		response.setResult(result);
		return response;
	}

	public NvlResponse getLstImgByDrawNvl(Long id) {
		Validator.Result result = Validator.Result.OK;
		NvlResponse response = new NvlResponse();
		List<PqcNvlImage> lstnvl =  pqcImageNvlRepository.getImgByDrawNvl(id);
		List<DrawNvlImageDTO> lstDraw = Arrays.asList(modelMapper.map(lstnvl, DrawNvlImageDTO[].class));

		Resource resource;
		InputStream inputStream;
		for (DrawNvlImageDTO item: lstDraw) {
			 resource = storageService.loadFile(item.getUrlPath());
			try
			{
				inputStream = resource.getInputStream();
				byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
				String data = Base64.getEncoder().encodeToString(bdata);
				item.setContentFile(data);
			}
			catch (IOException e)
			{

			}
		}

		response.setLstImg(lstDraw);
		response.setResult(result);
		return response;
	}

	/**
	 * danh sach partnumber theo feeder
	 * @param profileId
	 * @return
	 */
	public ScanQRCheckNVLResponse getProfileDetail(String profileId) {
		Validator.Result result = Validator.Result.OK;
		ScanQRCheckNVLResponse response = ProfileService.getInstall().getProfile(profileId);
		response.setResult(result);
		return response;
	}
}
