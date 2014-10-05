package io.nonamed.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.nonamed.framework.common.ResultVo;
import io.nonamed.framework.util.SessionUtil;
import io.nonamed.framework.web.GwSession;
import io.nonamed.user.domain.Users;
import io.nonamed.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "login", method = RequestMethod.POST)
    public @ResponseBody String login(Users users, HttpServletRequest request) throws IOException {

        String userJson = userService.userLogin(users);

//        ObjectMapper om = new ObjectMapper();
//        ResultVo resultVo = om.readValue(userJson, ResultVo.class);
//
//        if(!"400".equals(resultVo.getCode())){
//            String userData = resultVo.getData();
//            Users user = om.readValue(userData, Users.class);
//            SessionUtil.setGwSession(request, user);
//        }

        return userJson;
    }

    @RequestMapping("join")
    public @ResponseBody String join(@RequestBody Users users) throws IOException {
        return userService.join(users);
    }


}
