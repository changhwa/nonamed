package io.nonamed.user.repository;

import io.nonamed.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, String> {

    public Users findByEmailAndPasswd(String email, String passwd);

    @Query(value = "SELECT * FROM USERS WHERE department_deptCode= ?1", nativeQuery = true)
    public List<Users> findByDeptCode(String deptCode);

}
