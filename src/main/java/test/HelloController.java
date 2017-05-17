package test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by peng on 2017/3/6.
 */

@Controller
public class HelloController {

    @RequestMapping({"/hello", "/"})
    public String hello(){
        System.out.println("hello");
        return "hello";
    }


//    @RequestMapping(value="/json", method = {RequestMethod.POST})
//    @ResponseBody
//    public Map<String, String> testJson(@RequestBody Map<String, Object> params){
//        System.out.println("testJson");
//        System.out.println("map: " + params.get("client"));
////        System.out.println(request.getRequestURL());
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("test1", "map");
//        map.put("test2", "tree");
//        return map;
//    }

    @RequestMapping(value="/json", method = {RequestMethod.POST})
    public @ResponseBody Map<String, String> testJson(HttpServletRequest request){
        System.out.println("testJson");
//        System.out.println("map: " + params.get("client"));
        System.out.println(request.getRequestURL());
        Map<String, String> map = new HashMap<String, String>();
        map.put("test1", "map111");
        map.put("test2", "tree");
//        String jsonStr = "{\"test1\":\"map\"}";
        return map;
    }

    @RequestMapping("/test")
    public String testHtml(){
        System.out.println("enter test");
        return "test";
    }

    @RequestMapping("/test2")
    public String testHtml2(){
        System.out.println("enter test");
        return "test2";
    }



    @RequestMapping("/rest/{id}/{rest_id}")
    public String testRestful(@PathVariable("id") String id1, @PathVariable("rest_id") Integer restId2){
        System.out.println("id: " + id1 + ", rest_id: " + restId2);
        return "hello";
    }
}
