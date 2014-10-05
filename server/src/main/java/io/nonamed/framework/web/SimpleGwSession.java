package io.nonamed.framework.web;

import io.nonamed.department.domain.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleGwSession implements GwSession{

    /* 사용자 이메일 */
    private String email;

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

    /* 사용자 소속 부서 */
    private Department department;
}
