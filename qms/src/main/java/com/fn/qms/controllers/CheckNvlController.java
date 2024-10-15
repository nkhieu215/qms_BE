package com.fn.qms.controllers;

import com.fn.qms.models.PqcBomErrorDetail;
import com.fn.qms.models.PqcBomQuantity;
import com.fn.qms.services.CheckNvlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping("/check-nvl-new")
public class CheckNvlController {
    @Autowired
    CheckNvlService checkNvlService;
    // * Thêm mới/ cập nhật thông tin nhập
    @PostMapping("update-bom-quantity")
    public Integer updateBomQuantity(@RequestBody PqcBomQuantity request){
        Integer id = this.checkNvlService.updateBomQuantity(request);
        return id;
    }
    // * Lấy danh sách nhập theo pqc-bom-work-order
    @GetMapping("get-lst-quantity/{id}")
    public List<PqcBomQuantity> getListBomQuantityByBomWo(@PathVariable Integer id){
        List<PqcBomQuantity> list = this.checkNvlService.getListBomQuantityByBomWo(id);
        return list;
    }
    // * Lấy danh sách lỗi theo pqc work-order-id
    @GetMapping("get-lst-one/{id}")
    public List<PqcBomErrorDetail> getListErrorByWo(@PathVariable Integer id){
        List<PqcBomErrorDetail> list = this.checkNvlService.getListErrorByWo(id);
        return list;
    }
    // * Lấy danh sách lỗi theo pqc bom-work-order-id
    @GetMapping("get-lst-two/{id}")
    public List<PqcBomErrorDetail> getListErrorByBomWo(@PathVariable Integer id){
        List<PqcBomErrorDetail> list = this.checkNvlService.getListErrorByBomWo(id);
        return list;
    }
    // * Lấy danh sách lỗi theo pqc bom-quantity-id
    @GetMapping("get-lst-three/{id}")
    public List<PqcBomErrorDetail> getListErrorByBomQuantityWo(@PathVariable Integer id){
        List<PqcBomErrorDetail> list = this.checkNvlService.getListErrorByBomQuantityWo(id);
        return list;
    }
    // * Thêm mới / cập nhật danh sách lỗi
    @PostMapping("update-errors")
    public void updateBomError(@RequestBody List<PqcBomErrorDetail> listRequest){
        this.checkNvlService.updateBomError(listRequest);
    }
    // * xóa thông tin nhập
    @DeleteMapping("delete-bom-quantity/{id}")
    public void deleteBomQuantity(@PathVariable Integer id){
        this.checkNvlService.deleteBomQuantity(id);
    }
    // * xóa thông tin lỗi
    @DeleteMapping("delete-bom-error/{id}")
    public void deleteBomError(@PathVariable Integer id){
        this.checkNvlService.deleteBomError(id);
    }
}
