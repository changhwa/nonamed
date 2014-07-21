package io.nonamed.user.service;

import io.nonamed.framework.common.ResultVo;
import io.nonamed.user.domain.Users;
import io.nonamed.user.repository.UserRepository;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String userLogin(Users user) throws IOException {
        Users resultUser = userRepository.findOne(user.email);
        ResultVo resultVo = new ResultVo();
        if(resultUser != null){
            resultVo.setCode("200");
        } else {
            resultVo.setCode("400");
        }
        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(resultVo);
    }

}
