package com.fn.qms.services;

import com.fn.qms.dto.ErrorListDTO;
import com.fn.qms.dto.TestingCriticalDTO;
import com.fn.qms.dto.TestingCriticalGroupDTO;
import com.fn.qms.models.*;
import com.fn.qms.models.Error;
import com.fn.qms.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestingCriticalService {
    @Autowired
    TestingCriticalGroupRepository testingCriticalGroupRepository;
    @Autowired
    TestingCriticalRepository testingCriticalRepository;
    @Autowired
    IqcExaminationItemRepository iqcExaminationItemRepository;
    @Autowired
    ExaminationRepository examinationRepository;
    @Autowired
    IqcAuditResultItemRepository iqcAuditResultItemRepository;
    @Autowired
    IqcElectCompErrRepository iqcElectCompErrRepository;
    @Autowired
    ErrorRepository errorRepository;
    @Autowired
    ErrorGroupRepository errorGroupRepository;
    @Autowired
    ErrorLstGrRepository errorLstGrRepository;
    @Autowired
    QrFeederRepositoty qrFeederRepositoty;
    @Autowired
    QrFeederHistoryRepository qrFeederHistoryRepository;
    // * ---------------------------------- Testing critical Group -----------------------------------
    public List<TestingCriticalGroup> getAllTestingCriticalGroups(){
        List<TestingCriticalGroup> list = this.testingCriticalGroupRepository.findAll();
        return  list;
    }
    //☺ Lấy dữ liệu phân trang
    public List<TestingCriticalGroup> getAllTestingCriticalGroupsPg(TestingCriticalGroupDTO request){
        List<TestingCriticalGroup> list = this.testingCriticalGroupRepository.getItemPanigation(
                "%" +request.getTestingCriticalGroup() + "%",
                "%"+request.getUsername()+"%",
                "%"+request.getStatus()+"%",
                request.getItemPerPage(),
                request.getOffSet());
        return list;
    }
    //☺ get total item
    public Integer getTotalItem (TestingCriticalGroupDTO request){
        Integer total = this.testingCriticalGroupRepository.getTotalItem("%" +request.getTestingCriticalGroup() + "%",
                "%"+request.getUsername()+"%",
                "%"+request.getStatus()+"%");
        return total;
    }
    //☺ update/insert
    public void updateTestingGroup(TestingCriticalGroup request){
        this.testingCriticalGroupRepository.save(request);
    }
    //☺ delete item testing group
    //☺ get list group by type
    public List<TestingCriticalResponse> getListGroupByType(TestingCriticalDTO request){
        List<TestingCriticalResponse> list = this.testingCriticalRepository.getDataGroupList("%"+request.getType()+"%");
        return list;
    }
    public void deleteTestingGroup(Integer id){
        this.testingCriticalGroupRepository.deleteById(id);
    }
    // * ------------------------ testing critical ------------------------------
    //☺ get data
    public List<TestingCritical> getTestingCriticalList(){
        List<TestingCritical> list = this.testingCriticalRepository.findAll();
        return list;
    }
    //☺ get data panigation
    public List<TestingCriticalResponse> getTestingCriticalListPg(TestingCriticalDTO request){
        List<TestingCriticalResponse> list = this.testingCriticalRepository.getTestingCriticalListPg(
          "%"+ request.getTestingCriticalGroup()+"%",
          "%"+request.getTestingName()+"%",
          "%"+request.getUsername()+"%",
          "%"+request.getStatus()+"%",
                request.getItemPerPage(),
                request.getOffSet()
        );
        return list;
    }
    //☺ Get total data in testing critical
    public Integer getTotalItemTestingCritical(TestingCriticalDTO request){
        Integer total = this.testingCriticalRepository.getTotalItem(
                "%"+ request.getTestingCriticalGroup()+"%",
                "%"+request.getTestingName()+"%",
                "%"+request.getUsername()+"%",
                "%"+request.getStatus()+"%",
                request.getItemPerPage(),
                request.getOffSet()
        );
        return total;
    }
    //☺ get list testing guide
    public List<TestingCriticalResponse>getDataGuideList(TestingCriticalDTO request){
        List<TestingCriticalResponse> list = this.testingCriticalRepository.getDataGuideList(
                "%"+ request.getTestingCriticalGroup()+"%",
                "%"+request.getType()+"%"
        );
        return list;
    }
    //☺ get group name by testing name
    public TestingCriticalResponse getGroupNameByTestingName(TestingCriticalDTO request){
        TestingCriticalResponse list = this.testingCriticalRepository.getGroupNameByTestingName(
                "%"+request.getTestingName()+"%"
        );
        return list;
    }
    //☺ update
    public void updateTesting(TestingCritical request){
        this.testingCriticalRepository.save(request);
    }
    //☺ insert
    public void insertTesting(List<TestingCritical> requests){
        for (TestingCritical request:requests){
            this.testingCriticalRepository.save(request);
        }
    }
    //☺ check dublicated
    public Integer checkDublicate(TestingCriticalDTO request){
        TestingCritical response = this.testingCriticalRepository.findAllByTestingName(request.getTestingName());
        Integer result = 1;
        if (response != null){
            result = 0;
        }
        return result;
    }
    // * ----------------------------------------- examination ------------------------------------------
    //☺ get  data list of item by iqc exam id
    public List<IqcExaminationItem> getListItem(Integer id){
        List<IqcExaminationItem> list = this.iqcExaminationItemRepository.findAllByIqcExamId(id);
        return list;
    }
    //☺ update/ insert item
    public IqcExaminationItem submitItem(IqcExaminationItem request){
        this.iqcExaminationItemRepository.save(request);
        return request;
    }
    //☺ insert items
    public void submitItems( List<IqcExaminationItem> requests){
        for (IqcExaminationItem request:requests){
            IqcExaminationItem response =  this.iqcExaminationItemRepository.save(request);
        }
    }
    //☺ delete by id
    public void deleteItem(Integer id){
        this.iqcExaminationItemRepository.deleteById(id);
    }
    //☺ check dublicate by code
    public List<IqcExaminationType> checkDubByCode(IqcExaminationType request){
        List<IqcExaminationType>list = this.examinationRepository.findAllByCodeAndType(request.getCode(),request.getType());
        return list;
    }
    //☺ check dublicate by name
    public List<IqcExaminationType> checkDubByName(IqcExaminationType request){
        List<IqcExaminationType>list = this.examinationRepository.findAllByNameAndType(request.getName(),request.getType());
        return list;
    }
    // * ---------------------------------------- iqc audit result item --------------------------------
    //☺ find all by iqc lect comp id
    public List<IqcAuditResultItem> getAllByIqcElecCompId(Integer id){
        List<IqcAuditResultItem> list = this.iqcAuditResultItemRepository.findAllByIqcElecCompId(id);
        return list;
    }
    // ☺ insert/update
    public List<IqcAuditResultItem> submitIqcResultItem(List<IqcAuditResultItem> request){
        List<IqcAuditResultItem> list = new ArrayList<>();
        for (IqcAuditResultItem item:request){
            this.iqcAuditResultItemRepository.save(item);
            list.add(item);
        }
        return list;
    }
    //☺ delete by id
    public void deleteByIqcResultId(Integer id){
        this.iqcAuditResultItemRepository.deleteById(id);
    }
    // * ------------------------------------ iqc-elect-com-err ------------------------------------------
    public List<IqcElectCompErrResponse> getListErrByElectCompId(Long id){
        List<IqcElectCompErrResponse> list = this.iqcElectCompErrRepository.getListErrByElectCompId(id);
        return list;
    }
    public List<IqcElectCompErrResponse> getListErrByAuditResultItemId(Integer id){
        List<IqcElectCompErrResponse> list = this.iqcElectCompErrRepository.getListErrByAuditResultItemId(id);
        return list;
    }
    public List<IqcElectCompErr> submitErrors(List<IqcElectCompErr> requests){
        List<IqcElectCompErr> list = new ArrayList<>();
        for (IqcElectCompErr response : requests){
            this.iqcElectCompErrRepository.save(response);
            list.add(response);
        }
        return list;
    }
    public void deleteErrors(Long id){
        this.iqcElectCompErrRepository.deleteById(id);
    }
    public List<IqcElectCompErrResponse>findInListErrors(ErrorListDTO request){
        List<IqcElectCompErrResponse> list = this.iqcElectCompErrRepository.findInListErrors(
                "%"+request.getErrGroup()+"%",
                "%"+request.getErrCode()+"%",
                "%"+request.getErrName()+"%",
                "%"+request.getItemCode()+"%",
                request.getElectCompId()
        );
        return list;
    }
    public List<IqcElectCompErrResponse> getListErrorGroup(){
        List<IqcElectCompErrResponse> list = this.errorGroupRepository.getAll();
        return list;
    }
    public List<IqcElectCompErrResponse> getListErrorsById(Integer id){
        List<IqcElectCompErrResponse> list = this.errorLstGrRepository.getByErrorId(id);
        return list;
    }
    public List<IqcElectCompErrResponse> getListErrorsByNull(){
        List<IqcElectCompErrResponse> list = this.errorLstGrRepository.getByErrorNull();
        return list;
    }
    public List<IqcElectCompErrResponse> getAllListError(){
        List<IqcElectCompErrResponse> list = this.errorRepository.getAll();
        return list;
    }
    public List<IqcElectCompErr> getListErrors(Long id){
        List<IqcElectCompErr> list = this.iqcElectCompErrRepository.findAllByElectCompId(id);
        return list;
    }
    // * ------------------------------------ qr feeder history ------------------------------------------
    public List<QrFeederHistory> getAllByMachineCode(List<String> request){
        List<QrFeederHistory> list = new ArrayList<>();
        for (String machineCode:request){
            list.addAll(this.qrFeederHistoryRepository.findAllByMachineCodeOrderByTimeUpdateDesc(machineCode));
        }
        return list;
    }
    public List<QrFeederHistory> getAllByMachineCodeAndMainQrFeeder(QrFeederHistory request){
        List<QrFeederHistory> list = this.qrFeederHistoryRepository.searchByMachineCodeAndMainQrFeederOrderByTimeUpdateDesc(
                "%"+request.getMachineCode()+"%",
                "%"+request.getMainQrFeeder()+"%");
        return list;
    }
    public List<QrFeederResponse> getAllByFeederGroupIdAndStatus(Integer id){
        List<QrFeederResponse> list = this.qrFeederRepositoty.getAllByFeederGroupIdAndStatus(id);
        return list;
    }
    public void saveFeederHistory(List<QrFeederHistory> requests){
        for (QrFeederHistory qrFeederHistory:requests){
            this.qrFeederHistoryRepository.save(qrFeederHistory);
        }
    }
}
