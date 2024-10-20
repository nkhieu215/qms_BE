package com.fn.qms.services;

import com.fn.qms.models.PqcBomErrorDetail;
import com.fn.qms.models.PqcBomErrorDetailResponse;
import com.fn.qms.models.PqcBomQuantity;
import com.fn.qms.repository.PqcBomErrorDetailRepository;
import com.fn.qms.repository.PqcBomQuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CheckNvlService {
    @Autowired
    PqcBomQuantityRepository pqcBomQuantityRepository;
    @Autowired
    PqcBomErrorDetailRepository pqcBomErrorDetailRepository;
    // * Thêm mới/ cập nhật thông tin nhập
    public Integer updateBomQuantity(PqcBomQuantity request){
        Integer id = null;
        if(request.getId() == null){
            this.pqcBomQuantityRepository.save(request);
            id = request.getId();
        }else {
            PqcBomQuantity response =  this.pqcBomQuantityRepository.findById(request.getId()).orElse(null);
            response.setQuantity(request.getQuantity());
            response.setTotalError(request.getTotalError());
            this.pqcBomQuantityRepository.save(response);
            id = request.getId();
        }
        return id;
    }
    // * Lấy danh sách lỗi theo pqc work-order-id
    public List<PqcBomErrorDetailResponse> getListErrorByWo(Integer id){
        List<PqcBomErrorDetailResponse> list = this.pqcBomErrorDetailRepository.getAllByPqcWorkOrderId(id);
        return list;
    }
    // * Lấy danh sách lỗi theo pqc bom-work-order-id
    public List<PqcBomErrorDetailResponse> getListErrorByBomWo(Integer id){
        List<PqcBomErrorDetailResponse> list = this.pqcBomErrorDetailRepository.getAllByPqcBomWorkOrderId(id);
        return list;
    }
    // * Lấy danh sách lỗi theo pqc bom-quantity-id
    public List<PqcBomErrorDetailResponse> getListErrorByBomQuantityWo(Integer id){
        List<PqcBomErrorDetailResponse> list = this.pqcBomErrorDetailRepository.getAllByPqcBomQuantityId(id);
        return list;
    }
    // * Lấy danh sách nhập theo pqc-bom-work-order
    public List<PqcBomQuantity> getListBomQuantityByBomWo(Integer id){
        List<PqcBomQuantity> list = this.pqcBomQuantityRepository.findAllByPqcBomWorkOrderId(id);
        return list;
    }

    // * Thêm mới / cập nhật danh sách lỗi
    public void updateBomError(List<PqcBomErrorDetail> listRequest){
        for (PqcBomErrorDetail request:listRequest){
            if (request.getId() != null){
                PqcBomErrorDetail response = this.pqcBomErrorDetailRepository.getById(request.getId());
                response.setErrorCode(request.getErrorCode());
                response.setErrorName(request.getErrorName());
                response.setQuantity(request.getQuantity());
                response.setNote(request.getNote());
                this.pqcBomErrorDetailRepository.save(response);
            }else {
                this.pqcBomErrorDetailRepository.save(request);
            }
        }
    }
    // * xóa thông tin nhập
    public void deleteBomQuantity(Integer id){
        this.pqcBomErrorDetailRepository.deletedByPqcBomQuantityId(id);
        this.pqcBomQuantityRepository.deleteById(id);
    }
    // * xóa thông tin lỗi
    public void deleteBomError(Integer id){
        this.pqcBomErrorDetailRepository.deleteById(id);
    }
}
