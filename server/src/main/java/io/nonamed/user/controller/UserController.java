package io.nonamed.user.controller;

import io.nonamed.user.domain.Users;
import io.nonamed.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("login")
    public @ResponseBody String login(@RequestBody Users users) throws IOException {
        return userService.userLogin(users);
    }


}
