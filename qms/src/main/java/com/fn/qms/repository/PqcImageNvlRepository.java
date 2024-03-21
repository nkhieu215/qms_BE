package com.fn.qms.repository;

import com.fn.qms.models.PqcDrawNvl;
import com.fn.qms.models.PqcNvlImage;
import com.fn.qms.models.PqcQualityCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PqcImageNvlRepository extends JpaRepository<PqcNvlImage, Long> {
    @Query("from PqcNvlImage t where t.pqcDrawNvlId= :pqcDrawNvlId")
    List<PqcNvlImage> getImgByDrawNvl(@Param("pqcDrawNvlId") Long pqcDrawNvlId);
}
