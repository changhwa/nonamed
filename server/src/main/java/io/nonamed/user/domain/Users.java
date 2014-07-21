package io.nonamed.user.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Entity
public class Users {

    @Id
    public String email;
    public String passwd;
    public String name;

}
