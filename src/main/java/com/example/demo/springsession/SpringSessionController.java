package com.example.demo.springsession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * zhangyuxiao
 * 2020/9/7 09:37
 */
@RestController
public class SpringSessionController {
    @RequestMapping("/putSession")
    public String putSession(HttpServletRequest httpRequest){
        httpRequest.getSession().setAttribute("name","zhangsan");
        return "success";
    }

    @RequestMapping("/getSession")
    public String getSession(HttpServletRequest httpRequest){
        Object name = httpRequest.getSession().getAttribute("name");
        return name.toString();
    }
}
