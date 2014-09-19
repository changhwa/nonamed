package io.nonamed.department.repository;

import io.nonamed.department.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;
import java.util.Set;

public interface DeptRepository extends JpaRepository<Department, Long> {

    @Query(value = "SELECT * FROM DEPARTMENT WHERE PARENT_ID= ?1", nativeQuery = true)
    Set<Department> findByParentId(Long parentId);
}
