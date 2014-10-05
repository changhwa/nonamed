package io.nonamed.user.domain;


import io.nonamed.department.domain.Department;
import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Users /*extends SimpleGwSession*/  implements java.io.Serializable{

    @Id
    /* 사용자 이메일 */
    private String email;

    /* 사용자 암호 */
    private String passwd;

    /* 사용자 이름 */
    private String name;

    /* 사용자 직책 */
    private String position;

    /* 사용자 직위 */
    private String office;

    /* 사용자 보안등급 */
    private String securityGrade;

    /* 사용자 인증키 */
    private String authKey;

    @ManyToMany
    @JoinTable(name="USER_DEPT",
            joinColumns=@JoinColumn(name="USER_ID"),
            inverseJoinColumns=@JoinColumn(name="DEPT_ID"))
    private Set<Department> departments;

    public Users(){
        departments = new HashSet<Department>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getSecurityGrade() {
        return securityGrade;
    }

    public void setSecurityGrade(String securityGrade) {
        this.securityGrade = securityGrade;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    public Collection<Department> getDepartments() {
        return departments;
    }

    public void addDepartment(Department department) {
        if (!getDepartments().contains(department)) {
            getDepartments().add(department);
        }
        if (!department.getUsers().contains(this)) {
            department.getUsers().add(this);
        }
    }


}
