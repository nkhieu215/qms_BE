package com.fn.qms.controllers;

import com.fn.qms.dto.ErrorListDTO;
import com.fn.qms.dto.TestingCriticalDTO;
import com.fn.qms.dto.TestingCriticalGroupDTO;
import com.fn.qms.models.*;
import com.fn.qms.models.Error;
import com.fn.qms.services.TestingCriticalService;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/testing-critical")
public class TestingCriticalController {
    @Autowired
    TestingCriticalService testingCriticalService;
    // * ---------------------------------- Testing critical Group -----------------------------------
    //☺ lấy danh sách nhóm tiêu chí
    @GetMapping("/group/get-all")
    public List<TestingCriticalGroup> getAllTestingCriticalGroups(){
        List<TestingCriticalGroup> list = this.testingCriticalService.getAllTestingCriticalGroups();
        return list;
    }
    //☺ Lấy dữ liệu phân trang
    @PostMapping("/group/get-all")
    public List<TestingCriticalGroup> getAllTestingCriticalGroupsPg(@RequestBody TestingCriticalGroupDTO request){
        List<TestingCriticalGroup> list = this.testingCriticalService.getAllTestingCriticalGroupsPg(request);
        return list;
    }
    //☺ get total item
    @PostMapping("/group/get-total")
    public Integer getTotalItem (@RequestBody TestingCriticalGroupDTO request){
        Integer total = this.testingCriticalService.getTotalItem(request);
        return total;
    }
    //☺ update/insert
    @PostMapping("/group/submit")
    public void updateTestingGroup( @RequestBody TestingCriticalGroup request){
        this.testingCriticalService.updateTestingGroup(request);
    }
    @PostMapping("/group/delete/{id}")
    public void deleteTestingGroup(@PathVariable Integer id){
        this.testingCriticalService.deleteTestingGroup(id);
    }
    //☺ get list group by type
    @PostMapping("/group/type/get-all")
    public List<TestingCriticalResponse> getListGroupByType(@RequestBody TestingCriticalDTO request){
        List<TestingCriticalResponse> list = this.testingCriticalService.getListGroupByType(request);
        return list;
    }
    // * -------------------- Testing critical --------------------------------
    //☺ get data panigation
    @PostMapping("/get-all")
    public List<TestingCriticalResponse> getTestingCriticalListPg(@RequestBody TestingCriticalDTO request){
        List<TestingCriticalResponse> list = this.testingCriticalService.getTestingCriticalListPg(request);
        return list;
    }
    //☺ get data
    @GetMapping("/get-all")
    public List<TestingCritical> getTestingCriticalList(){
        List<TestingCritical> list = this.testingCriticalService.getTestingCriticalList();
        return list;
    }
    //☺ Get total data in testing critical
    @PostMapping("/get-total")
    public Integer getTotalItemTestingCritical(@RequestBody TestingCriticalDTO request){
        Integer total = this.testingCriticalService.getTotalItemTestingCritical(request);
        return total;
    }
    //☺ update
    @PostMapping("/update")
    public void updateTesting(@RequestBody TestingCritical request){
        this.testingCriticalService.updateTesting(request);
    }
    //☺ insert
    @PostMapping("/insert")
    public void insertTesting(@RequestBody List<TestingCritical> requests){
            this.testingCriticalService.insertTesting(requests);
    }
    //☺ check dublicated
    @PostMapping("/check-dublicate")
    public Integer checkDublicate(@RequestBody TestingCriticalDTO request){
        Integer result = this.testingCriticalService.checkDublicate(request);
        return result;
    }
    //☺ get list testing guide
    @PostMapping("/get-list-guide")
    public List<TestingCriticalResponse>getDataGuideList(@RequestBody TestingCriticalDTO request){
        List<TestingCriticalResponse> list = this.testingCriticalService.getDataGuideList(request);
        return list;
    }
    //☺ get group name by testing name
    @PostMapping("/get-group-name")
    public TestingCriticalResponse getGroupNameByTestingName(@RequestBody TestingCriticalDTO request){
        TestingCriticalResponse list = this.testingCriticalService.getGroupNameByTestingName(request);
        return list;
    }
    // * -----------------------------examination ------------------------------
    //☺ get list item by id
    @GetMapping("/examinations/get-all/{id}")
    public List<IqcExaminationItem> getListItem(@PathVariable Integer id){
        List<IqcExaminationItem> list = this.testingCriticalService.getListItem(id);
        return list;
    }
    //☺ update/ insert item
    @PostMapping("/examinations/submit")
    public IqcExaminationItem submitItem(@RequestBody IqcExaminationItem request){
        IqcExaminationItem response =  this.testingCriticalService.submitItem(request);
        return response;
    }
    //☺ insert items
    @PostMapping("/examinations/submits")
    public void submitItems(@RequestBody List<IqcExaminationItem> requests){
              this.testingCriticalService.submitItems(requests);
    }
    @DeleteMapping("/examinations/delete/{id}")
    public void submitItem(@PathVariable Integer id){
         this.testingCriticalService.deleteItem(id);
    }
    //☺ check dublicate by code
    @PostMapping("/examinations/check/code")
    public List<IqcExaminationType> checkDubByCode(@RequestBody IqcExaminationType request){
        List<IqcExaminationType>list = this.testingCriticalService.checkDubByCode(request);
        return list;
    }
    //☺ check dublicate by name
    @PostMapping("/examinations/check/name")
    public List<IqcExaminationType> checkDubByName(@RequestBody IqcExaminationType request){
        List<IqcExaminationType>list = this.testingCriticalService.checkDubByName(request);
        return list;
    }
    // * ---------------------------------------- iqc audit result item --------------------------------
    //☺ find all by iqc lect comp id
    @GetMapping("/iqc/get-all/{id}")
    public List<IqcAuditResultItem> getAllByIqcElecCompId(@PathVariable Integer id){
        List<IqcAuditResultItem> list = this.testingCriticalService.getAllByIqcElecCompId(id);
        return list;
    }
    // ☺ insert/update
    @PostMapping("/iqc/submit")
    public List<IqcAuditResultItem> submitIqcResultItem(@RequestBody List<IqcAuditResultItem> request){
        List<IqcAuditResultItem> list = this.testingCriticalService.submitIqcResultItem(request);
        return list;
    }
    //☺ delete by id
    @DeleteMapping("/iqc/delete/{id}")
    public void deleteByIqcResultId(@PathVariable Integer id){
        this.testingCriticalService.deleteByIqcResultId(id);
    }
    // * ------------------------------------ iqc-elect-com-err ------------------------------------------
    @GetMapping("/errors/elect-comp-id/{id}")
    public List<IqcElectCompErrResponse> getListErrByElectCompId(@PathVariable Long id){
        List<IqcElectCompErrResponse> list = this.testingCriticalService.getListErrByElectCompId(id);
        return list;
    }
    @GetMapping("/errors/audit-result-item-id/{id}")
    public List<IqcElectCompErrResponse> getListErrByAuditResultItemId(@PathVariable Integer id){
        List<IqcElectCompErrResponse> list = this.testingCriticalService.getListErrByAuditResultItemId(id);
        return list;
    }
    @PostMapping("error/submit")
    public List<IqcElectCompErr> submitErrors(@RequestBody List<IqcElectCompErr> requests){
        List<IqcElectCompErr> list = this.testingCriticalService.submitErrors(requests);
        return list;
    }
    @DeleteMapping("errors/delete/{id}")
    public void deleteErrors(@PathVariable Long id){
        this.testingCriticalService.deleteErrors(id);
    }
    @PostMapping("errors/search")
    public List<IqcElectCompErrResponse>findInListErrors(@RequestBody ErrorListDTO request){
        List<IqcElectCompErrResponse> list = this.testingCriticalService.findInListErrors(request);
        return list;
    }
    @GetMapping("/errors/group/get-all")
    public List<IqcElectCompErrResponse> getListErrorGroup(){
        List<IqcElectCompErrResponse> list = this.testingCriticalService.getListErrorGroup();
        return list;
    }
    @GetMapping("/errors/group/get-all/{id}")
    public List<IqcElectCompErrResponse> getListErrorsById(@PathVariable Integer id){
        List<IqcElectCompErrResponse> list = this.testingCriticalService.getListErrorsById(id);
        return list;
    }
    @GetMapping("/errors/get-all")
    public List<IqcElectCompErrResponse> getAllListError(){
        List<IqcElectCompErrResponse> list = this.testingCriticalService.getAllListError();
        return list;
    }
    @GetMapping("/errors/group/get-all/null")
    public List<IqcElectCompErrResponse> getListErrorsByNull(){
        List<IqcElectCompErrResponse> list = this.testingCriticalService.getListErrorsByNull();
        return list;
    }
    @GetMapping("/errors/get-list")
    public List<IqcElectCompErr> getListErrors(@PathVariable Long id){
        List<IqcElectCompErr> list = this.testingCriticalService.getListErrors(id);
        return list;
    }
    // * ------------------------------------ qr feeder history ------------------------------------------
    @PostMapping("/check-100/feeder-history")
    public List<QrFeederHistory> getAllByMachineCode(@RequestBody List<String> request){
        List<QrFeederHistory> list = this.testingCriticalService.getAllByMachineCode(request);
        return list;
    }
    @PostMapping("/check-100/feeder-history/search")
    public List<QrFeederHistory> getAllByMachineCodeAndMainQrFeeder(@RequestBody QrFeederHistory request){
        List<QrFeederHistory> list = this.testingCriticalService.getAllByMachineCodeAndMainQrFeeder(request);
        return list;
    }
    @GetMapping("/check-100/sub-feeder/{id}")
    public List<QrFeederResponse> getAllByFeederGroupIdAndStatus(@PathVariable Integer id){
        List<QrFeederResponse> list = this.testingCriticalService.getAllByFeederGroupIdAndStatus(id);
        return list;
    }
    @PostMapping("/check-100/feeder-history/save")
    public void saveFeederHistory(@RequestBody List<QrFeederHistory> requests){
        this.testingCriticalService.saveFeederHistory(requests);
    }
}
