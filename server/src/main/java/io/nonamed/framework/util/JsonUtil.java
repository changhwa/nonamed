package io.nonamed.framework.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.Assert;

public class JsonUtil {

    public static String objToJsonStr(Object object) throws JsonProcessingException {
        Assert.notNull(object);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

}
