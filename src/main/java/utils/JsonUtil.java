package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by peng on 2017/3/20.
 */
public class JsonUtil {

    public static String objToJSON(Object obj){

        ObjectMapper mapper = new ObjectMapper();
        String str = null;

        try {
            str = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return str;
    }

//    public static Object jsonToObj(String str, Class<?> clazz ){
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            Object object = mapper.readValue(str, clazz);
//            return object;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
