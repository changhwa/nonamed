package io.nonamed.user.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.nonamed.department.domain.Department;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter @Setter
@Entity
public class Users {

    @Id
    /* 사용자 이메일 */
    public String email;

    /* 사용자 암호 */
    public String passwd;

    /* 사용자 이름 */
    public String name;

    /* 사용자 직책 */
    public String position;

    /* 사용자 직위 */
    public String office;

    /* 사용자 보안등급 */
    public String securityGrade;

    /* 사용자 인증키 */
    public String authKey;

    @ManyToOne
    @JsonBackReference
    //TODO : 현재는 겸직은 고려되지 않은 상태
    private Department department;
}
