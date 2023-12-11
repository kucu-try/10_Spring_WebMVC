package com.ohgiraffers.thymeleaf.controller;

import com.ohgiraffers.thymeleaf.model.dto.Member;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("lecture")
public class LectureController {

    @GetMapping("expression")
    public ModelAndView expression(ModelAndView mv){
        mv.addObject("member", new Member("홍길동",20,'남',"서울"));

        mv.addObject("hello","hello!<h3>thymleaf</h3>");
        mv.setViewName("/lecture/expression");
        return mv;
    }
}
