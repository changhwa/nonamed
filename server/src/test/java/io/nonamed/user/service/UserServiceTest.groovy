package io.nonamed.user.service

import com.fasterxml.jackson.databind.ObjectMapper
import io.nonamed.App
import io.nonamed.framework.common.ResultVo
import io.nonamed.user.domain.Users
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Shared
import spock.lang.Specification

@ContextConfiguration(classes = App)
class UserServiceTest extends Specification {

    @Autowired
    UserService userService

    @Shared
    Users user = new Users()

    @Shared
    ObjectMapper om

    def setup(){
        user.email = "test3@nonamed.co.kr"
        user.name = "test3"
        user.passwd = "1234"

        om = new ObjectMapper()
    }

    void "test3 사용자가 가입을 신청한다"() {

        given:

        when:
        String result = userService.join(user)

        then:
        println result
        ObjectMapper om = new ObjectMapper()
        ResultVo vo = om.readValue(result, ResultVo.class)
        vo.code == "200"
    }

    void "동일한 사용자가 가입을 신청한다"(){
        given:

        when:
        String result = userService.join(user)
        result = userService.join(user)

        then:
        println result

        ResultVo vo = om.readValue(result, ResultVo.class)
        vo.code == "400"

    }
}
