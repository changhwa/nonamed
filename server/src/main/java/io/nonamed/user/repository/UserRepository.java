package io.nonamed.user.repository;

import io.nonamed.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface UserRepository extends JpaRepository<Users, String> {

    public Users findByEmailAndPasswd(String email, String passwd);
    //SELECT e FROM Employee e JOIN e.address a WHERE a.city = :city
    //select b.fname, b.lname from Users b JOIN b.groups c where c.groupName = :groupName

    //TODO : 쿼리 작성법 알기전까지는 임시적으로 user_dept 에서 user_id를 가져와서 다시 조회
    @Query(value = "SELECT u FROM user_dept ud join ud.user_id u WHERE ud.dept_id = :deptCode", nativeQuery = true)
    public Set<Users> findByDeptCode(@Param("deptCode") Long deptCode);

}
