package com.fn.qms.repository;

import com.fn.qms.models.TestingCritical;
import com.fn.qms.models.TestingCriticalResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestingCriticalRepository extends JpaRepository<TestingCritical,Integer> {
    @Query(value="" +
            "SELECT \n" +
            "    a.id as id,\n" +
            "    a.testing_name as testingName,\n" +
            "    a.created_at as createdAt,\n" +
            "    a.update_at as updateAt,\n" +
            "    a.username as username,\n" +
            "    a.type as type,\n" +
            "    a.status as status,\n" +
            "    a.note as note,\n" +
            "    a.testing_group_id as testingGroupId,\n" +
            "    b.testing_critical_group as testingCriticalGroup\n" +
            "FROM `testing_critical` as a\n" +
            "inner join qms2.testing_critical_group as b on b.id = a.testing_group_id \n" +
            "where b.testing_critical_group like ?1\n" +
            "and a.testing_name like ?2\n" +
            "and a.username like ?3\n" +
            "and a.status like ?4\n" +
            "order by  a.status asc , a.update_at desc \n" +
            "limit ?5 \n" +
            "offset ?6 ;",nativeQuery = true)
    public List<TestingCriticalResponse> getTestingCriticalListPg(
            String testingCriticalGroup,
            String testingName,
            String username,
            String status,
            Integer itemPerPage,
            Integer offSet
    );
    @Query(value = "select count(*) from `testing_critical`as a\n" +
            "inner join qms2.testing_critical_group as b on b.id = a.testing_group_id \n" +
            "where b.testing_critical_group like ?1\n" +
            "and a.testing_name like ?2\n" +
            "and a.username like ?3\n" +
            "and a.status like ?4\n" +
            "order by a.update_at desc , a.status asc\n" +
            "limit ?5 \n" +
            "offset ?6 ;",nativeQuery = true)
    public Integer getTotalItem(String testingCriticalGroup,
                                String testingName,
                                String username,
                                String status,
                                Integer itemPerPage,
                                Integer offSet);
    public TestingCritical findAllByTestingName(String testingName);
    @Query(value = "SELECT \n" +
            "a.testing_name as testingName,\n" +
            "b.testing_critical_group as testingCriticalGroup \n" +
            "FROM `testing_critical` as a\n" +
            "inner join qms2.testing_critical_group as b on b.id = a.testing_group_id\n" +
            "where b.testing_critical_group like ?1 and a.type like ?2 ;",nativeQuery = true)
    public List<TestingCriticalResponse> getDataGuideList(String testingCriticalGroup, String type);
    @Query(value = "SELECT \n" +
            "distinct(b.testing_critical_group) as testingCriticalGroup \n" +
            "FROM `testing_critical` as a\n" +
            "inner join qms2.testing_critical_group as b on b.id = a.testing_group_id\n" +
            "where a.type like ?1 ;",nativeQuery = true)
    public List<TestingCriticalResponse> getDataGroupList(String type);
    @Query(value = "SELECT \n" +
            "b.testing_critical_group as testingCriticalGroup \n" +
            "FROM `testing_critical` as a\n" +
            "inner join qms2.testing_critical_group as b on b.id = a.testing_group_id\n" +
            "where a.testing_name like ?1 ;",nativeQuery = true)
    public TestingCriticalResponse getGroupNameByTestingName(String testingName);
}
