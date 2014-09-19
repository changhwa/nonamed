package io.nonamed.department.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.HashSet;
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
        if(getChildDept().contains(parentDept)){
            getChildDept().add(department);
        }
    }
}