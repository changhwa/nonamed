package io.nonamed.department.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.nonamed.user.domain.Users;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter @Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long deptCode;
    public String deptName;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonManagedReference
    public Department parentDept;


    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER) //TODO : LAZY가 맞을텐데 확인 필요
    @JoinColumn(name = "parent_id")
    @JsonBackReference
    private Set<Department> childDept = new HashSet<Department>();

    private int level;
    private String useYn;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "department")
    @JsonManagedReference
    //TODO : 현재는 겸직은 고려되지 않은 상태
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

    public void childDeptAdd(Department department){
        Assert.notNull(department);
        if(!getChildDept().contains(parentDept)){
            getChildDept().add(department);
        }
    }

    public void addUser(Users user){
        Assert.notNull(user);
        if(!getUsers().contains(user)){
            getUsers().add(user);
        }
        user.setDepartment(this);
    }
}