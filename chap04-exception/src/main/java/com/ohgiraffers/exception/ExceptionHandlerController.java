package com.ohgiraffers.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionHandlerController {

    @GetMapping("controller-null")
    public String nullPointerExceptionTest(Model model) {
        String str = null;

        System.out.println(str.charAt(0));

        return "/main";
    }

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException e){
        System.out.println("controller 레벨의 Exception 처리");
        return "error/nullPointer";
    }

    @GetMapping("controller-user")
    public String userException() throws MembeerRegistException{
        boolean check = true;
        if(check){
            throw new MembeerRegistException("입사가 불가능합니다");
        }
        return "/";
    }
    @ExceptionHandler(MembeerRegistException.class)
    public String userException(MembeerRegistException e){
        System.out.println("controller 렙 exception 발생함");
        return "error/memberRegist";
    }

}
