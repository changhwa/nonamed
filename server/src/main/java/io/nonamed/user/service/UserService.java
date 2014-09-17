package io.nonamed.user.service;

import io.nonamed.framework.common.ResultVo;
import io.nonamed.user.domain.Users;
import io.nonamed.user.repository.UserRepository;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String userLogin(Users user) throws IOException {
        Users resultUser = userRepository.findOne(user.email);
        return requestComment(resultUser);
    }


    public String join(Users user) throws IOException {

        if(isUserExist(user)){
            return requestComment(null);
        }

        Users resultUser = userRepository.save(user);
        return requestComment(resultUser);
    }

    public Users findByEmail(String email){
        return userRepository.findOne(email);
    }


    private boolean isUserExist(Users user){
        user = findByEmail(user.getEmail());
        if(user != null){
            return true;
        }
        return false;
    }


    //TODO : 차후 공통화
    private String requestComment(Users resultUser) throws IOException {
        ResultVo resultVo = new ResultVo();
        ObjectMapper om = new ObjectMapper();

        if(resultUser != null){
            resultVo.setCode("200");
            resultVo.setData(om.writeValueAsString(resultUser));
        } else {
            resultVo.setCode("400");
        }

        return om.writeValueAsString(resultVo);
    }

}
