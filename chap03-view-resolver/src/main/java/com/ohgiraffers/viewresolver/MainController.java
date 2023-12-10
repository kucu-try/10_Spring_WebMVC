package com.ohgiraffers.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping(value = {"/","/main"})  //localhost8080 이 "/" 이거다
    public String main(){return "main";}
}
