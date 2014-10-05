package io.nonamed.department.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.nonamed.user.domain.Users;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.*;


@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long deptCode;
    public String deptName;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonManagedReference
    public Department parentDept;


    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    @JsonBackReference
    private Set<Department> childDept = new HashSet<Department>();

    private int level;
    private String useYn;

    @ManyToMany(mappedBy="departments", fetch = FetchType.EAGER)
    private Set<Users> users;


    public Department() {
        users = new HashSet<Users>();
    }

    public void setLevel(int level) {
        if(level == 0){
            level = 1;
        }
        this.level = level;
    }

    public void setUseYn(String useYn) {
        if(useYn == null){
            useYn = "N";
        }
        this.useYn = useYn;
    }

    public Long getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(Long deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Department getParentDept() {
        return parentDept;
    }

    public void setParentDept(Department parentDept) {
        this.parentDept = parentDept;
    }

    public Set<Department> getChildDept() {
        return childDept;
    }

    public void setChildDept(Set<Department> childDept) {
        this.childDept = childDept;
    }

    public int getLevel() {
        return level;
    }

    public String getUseYn() {
        return useYn;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

    public void childDeptAdd(Department department){
        Assert.notNull(department);
        if(!getChildDept().contains(parentDept)){
            getChildDept().add(department);
        }
    }

    public void addUser(Users user) {
        if (!getUsers().contains(user)) {
            getUsers().add(user);
        }
        if (!user.getDepartments().contains(this)) {
            user.getDepartments().add(this);
        }
    }
}