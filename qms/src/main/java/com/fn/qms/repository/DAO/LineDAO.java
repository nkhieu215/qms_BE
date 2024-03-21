package com.fn.qms.repository.DAO;

import com.fn.qms.dto.SettingLineDTO;
import com.fn.qms.models.PqcCriteriaQuality;
import com.fn.qms.models.SettingLine;
import com.fn.qms.repository.SettingLineRepository;
import com.fn.qms.rest.LineRequest;
import com.fn.qms.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LineDAO {

    @Autowired
    SettingLineRepository settingLineRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void createUpdate(SettingLineDTO dto) {
        SettingLine check = modelMapper.map(dto, SettingLine.class);
        settingLineRepository.save(check);
    }

    public Page<SettingLine> getListByPage(int page, int size, LineRequest dataRequest) {
        page = page - 1;
        String name = Utils.isNull(dataRequest.getName()) ? null : dataRequest.getName().trim();
        String code = Utils.isNull(dataRequest.getCode()) ? null : dataRequest.getCode().trim();

        Page<SettingLine> lstPage = settingLineRepository.getListByPage(name, code, PageRequest.of(page, size));
        return lstPage;
    }
}
