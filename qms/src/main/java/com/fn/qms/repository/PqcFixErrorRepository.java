package com.fn.qms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.PqcAssemblesSuccessCheck;
import com.fn.qms.models.PqcBomWorkorder;
import com.fn.qms.models.PqcDrawNvl;
import com.fn.qms.models.PqcDrawTestNvl;
import com.fn.qms.models.PqcDttdInterchangeabilityCheck;
import com.fn.qms.models.PqcDttdMountCompCheck;
import com.fn.qms.models.PqcDttdSolderCheck;
import com.fn.qms.models.PqcDttdTinCheck;
import com.fn.qms.models.PqcFixErr;
import com.fn.qms.models.PqcPhotoelectric;
import com.fn.qms.models.PqcPhotoelectricParam;
import com.fn.qms.models.PqcPhotoelectricProduct;
import com.fn.qms.models.PqcProfile;
import com.fn.qms.models.PqcWorkOrder;

@Repository
public interface PqcFixErrorRepository extends JpaRepository<PqcFixErr, Long> {

	@Modifying
	@Query("delete from PqcFixErr t where t.id = ?1")
	void deleteById(Long id);
}