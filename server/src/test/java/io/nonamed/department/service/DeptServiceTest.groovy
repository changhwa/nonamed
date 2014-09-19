package io.nonamed.department.service

import io.nonamed.App
import io.nonamed.department.domain.Department
import io.nonamed.department.repository.DeptRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Shared
import spock.lang.Specification

@ContextConfiguration(classes = App)
class DeptServiceTest extends Specification {

    @Autowired
    private DeptService deptService

    @Autowired
    private DeptRepository deptRepository

    @Shared
    Department dept1 = new Department()
    @Shared
    Department dept2 = new Department()
    @Shared
    Department dept3 = new Department()
    @Shared
    Department dept4 = new Department()
    @Shared
    Department dept5 = new Department()


    def "전체부서를 조회한다"(){

        given:
        setDefaultDeptTestData()

        when:
        String result = deptService.getDept()

        then:
        println result
        result != null && result != ''
    }


    def "부서를 저장한다"() {

        given:

        Department parentDept = new Department()
        parentDept.deptName = "부모부서1"

        when:
        parentDept = deptService.saveDept(parentDept)

        then:
        println  parentDept
        parentDept.deptName == '부모부서1'

    }

    def "하위부서를 저장한다"(){

        given:
        Department childDept = new Department()
        childDept.deptName = "자식부서1"
        childDept.parentDept = dept1

        when:
        childDept = deptService.saveDept(childDept)

        then:
        childDept.getParentDept().getDeptName() == "테스트부서1"
    }

    def "특정부서의 하위부서들을 가져온다"(){

        given:
        Department parentDept = new Department()
        parentDept.deptCode = 1L

        when:
        Set<Department> child = deptService.getChildDeptByParentId(parentDept.getDeptCode())

        then:
        child.size() > 0
    }

    def setDefaultDeptTestData(){

        dept1.deptName = "테스트부서1"
        dept1 = deptService.saveDept(dept1)

        dept2.deptName = "테스트부서1_하위1"
        dept2.parentDept = dept1
        dept2 = deptService.saveDept(dept2)

        dept3.deptName = "테스트부서1_하위2"
        dept3.parentDept = dept1
        dept3 = deptService.saveDept(dept3)

        dept4.deptName = "테스트부서2"
        dept4 = deptService.saveDept(dept4)

        dept5.deptName = "테스트부서1_하위2_하위1"
        dept5.parentDept = dept3
        dept5 = deptService.saveDept(dept5)
    }

}
