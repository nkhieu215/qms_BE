package com.fn.qms.repository.DAO;

import com.fn.qms.dto.SettingLineDTO;
import com.fn.qms.dto.SettingMachineDTO;
import com.fn.qms.models.SettingMachine;
import com.fn.qms.repository.SettingMachineRepository;
import com.fn.qms.rest.MachineRequest;
import com.fn.qms.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MachineDAO {

    @Autowired
    SettingMachineRepository settingMachineRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void createUpdate(SettingMachineDTO dto) {
        SettingMachine check = modelMapper.map(dto, SettingMachine.class);
        settingMachineRepository.save(check);
    }

    public Page<SettingMachine> getListByPage(int page, int size, MachineRequest dataRequest) {
        page = page - 1;
        String name = Utils.isNull(dataRequest.getName()) ? null : dataRequest.getName().trim();
        String code = Utils.isNull(dataRequest.getCode()) ? null : dataRequest.getCode().trim();

        Page<SettingMachine> lstPage = settingMachineRepository.getListByPage(name, code, PageRequest.of(page, size));
        return lstPage;
    }
}
