package com.unicom.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName：TemplatesController
 * @Author：kuangzy
 * @Time：2019/5/6 9:13
 * @Discription:discription
 */
@Controller
public class TemplatesController {
    // 这里写成根目录，就会覆盖掉原来静态页面下index的跳转，如果写成其他路径，那根目录就依然可以跳静态页面
    @RequestMapping("/")
    String test(HttpServletRequest request){
        request.setAttribute("key","hello world");
        return "/index";
    }
}
