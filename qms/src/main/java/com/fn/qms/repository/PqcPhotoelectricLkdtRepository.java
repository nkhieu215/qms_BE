package com.fn.qms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.PqcAssemblesSuccessCheck;
import com.fn.qms.models.PqcBomWorkorder;
import com.fn.qms.models.PqcDrawNvl;
import com.fn.qms.models.PqcDrawTestNvl;
import com.fn.qms.models.PqcDttdInterchangeabilityCheck;
import com.fn.qms.models.PqcDttdMountCompCheck;
import com.fn.qms.models.PqcDttdSolderCheck;
import com.fn.qms.models.PqcDttdTinCheck;
import com.fn.qms.models.PqcPhotoelectric;
import com.fn.qms.models.PqcPhotoelectricLkdt;
import com.fn.qms.models.PqcProfile;
import com.fn.qms.models.PqcWorkOrder;

@Repository
public interface PqcPhotoelectricLkdtRepository extends JpaRepository<PqcPhotoelectricLkdt, Long> {
	
}