package io.nonamed.department.service;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import java.util.*;

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

    public String getOrgTree(Department department) throws Exception {

        Set<Department> departments = new HashSet<>();

        if(department.getDeptCode() == null){
            departments = getDept(0);
        } else {
            departments = getChildDeptByParentId(department.getDeptCode());
        }

        List<Users> users = userService.findByDeptCode(department.getDeptCode()+"");

        String deptTree = makeTree(departments);

        ObjectMapper om = new ObjectMapper();
        String userTree = om.writeValueAsString(users);

        Map<String, String> treeMap = new HashMap<>();
        treeMap.put("dept", deptTree);
        treeMap.put("user", userTree);

        om = new ObjectMapper();
        log.debug(" tree >> : " + om.writeValueAsString(treeMap));
        return om.writeValueAsString(treeMap);

    }

    public Set<Department> getDept(int level){
        return deptRepository.findByLevel(level);
    }

    public String makeTree(Set<Department> departments) throws Exception {

        List<HashMap<String, String>> depts = new ArrayList<>();

        for(Department dept : departments){
            HashMap<String, String> deptMap = new HashMap<>();
            deptMap.put("code", String.valueOf(dept.getDeptCode()));
            deptMap.put("name", dept.getDeptName());
            depts.add(deptMap);
        }

        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(depts);
    }

}
