package com.fn.qms.repository;

import com.fn.qms.models.TestingCriticalGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestingCriticalGroupRepository extends JpaRepository<TestingCriticalGroup,Integer> {
    @Query(value = "select count(*) from `testing_critical_group`" +
            "where testing_critical_group like ?1 " +
            "            and username like ?2 " +
            "            and status like ?3 ;",nativeQuery = true)
    public Integer getTotalItem(String testingCriticalGroup,
                                String username,
                                String status);
    @Query(value = "SELECT * FROM `testing_critical_group`\n" +
            "where testing_critical_group like ?1\n" +
            "and username like ?2 \n" +
            "and status like ?3\n" +
            "order by status asc ,update_at desc\n" +
            "limit ?4\n" +
            "offset ?5 ;",nativeQuery = true)
    public List<TestingCriticalGroup> getItemPanigation(String testingCriticalGroup,
                                                        String username,
                                                        String status,
                                                        Integer itemPerPage,
                                                        Integer offSet);

}
