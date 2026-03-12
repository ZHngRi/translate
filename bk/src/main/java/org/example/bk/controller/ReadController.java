package org.example.bk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReadController {
    @RequestMapping("/hello")
    //  *   匹配任意多的字符    /hello*  ==> /hello1sds23
    //  **  匹配任意多的路径    /hello**  ==> /hello/a  /hello/a/b      双星不能放中间
    //  ?   匹配一个字符       /hello?  ==> /helloa
    //  优先级：        完全匹配  >  ?   >   *   > **
    public String hello(){
        return "Hello Spring MVC!";
    }


}
