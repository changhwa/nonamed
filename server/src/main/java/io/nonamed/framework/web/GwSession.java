package io.nonamed.framework.web;

import io.nonamed.department.domain.Department;

import java.io.Serializable;
import java.util.List;

public interface GwSession extends Serializable{

    public String getEmail();

    public String getName();

    public String getPosition();

    public String getOffice();

    public String getSecurityGrade();

    public String getAuthKey();

    public Department getDepartment();
}
