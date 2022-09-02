package org.example.jenkins;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;

public class JsonUtils {
    private static ObjectMapper objectMapper;

    static
    {
        objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"));
    }

    private JsonUtils()
    {}

    public static ObjectMapper getInstance()
    {
        return objectMapper;
    }

    public static void setDefault()
    {
        objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"));
    }

    public static String convertJsonStringNonException(Object value) throws JsonProcessingException {
        String result = "";

        result = objectMapper.writeValueAsString(value);


        return result;
    }
}
