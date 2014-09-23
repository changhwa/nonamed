package io.nonamed.department.controller;

import io.nonamed.department.domain.Department;
import io.nonamed.department.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/orgtest")
    public @ResponseBody String orgTree(Department department) throws Exception {
        return deptService.getOrgTree(department);
    }
}
