package io.nonamed.department.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.nonamed.department.domain.Department;
import io.nonamed.department.repository.DeptRepository;
import io.nonamed.user.domain.Users;
import io.nonamed.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@Service
public class DeptService {

    @Autowired
    private DeptRepository deptRepository;

    @Autowired
    private UserService userService;

    private Logger log = LoggerFactory.getLogger(DeptService.class);

    @Transactional
    public Department saveDept(Department dept){

        if(dept.getParentDept() == null){
            //자신이 부모.
            deptRepository.save(dept);
        } else {
            Department parentDept = getDept(dept.getParentDept());
            dept.setParentDept(parentDept);
            dept.setLevel(parentDept.getLevel()+1);
            dept = deptRepository.save(dept);

            parentDept.childDeptAdd(dept);
            deptRepository.save(parentDept);
        }

        return dept;
    }

    public String getDept() throws Exception {
        List<Department> departments = deptRepository.findAll();

        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(departments);
    }



    public Department getDept(Department department){
        return deptRepository.findOne(department.getDeptCode());
    }

    public Set<Department> getChildDeptByParentId(Long parentId){
        return deptRepository.findByParentId(parentId);
    }


    public Department addUserDept(Department department, Users user) throws IOException {
        Department dept = deptRepository.findOne(department.getDeptCode());
        dept.addUser(user);
        user = userService.findByEmail(user.getEmail());
        user.setDepartment(dept);
        userService.save(user);
        return dept;
    }


}
