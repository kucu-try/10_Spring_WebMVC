package com.ohgiraffers.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException e){
        System.out.println("global 레벨의 exception 처리");
        return "error/nullPointer";
    }


    @ExceptionHandler(MembeerRegistException.class)
    public String userExceptionHandler(Model model, MembeerRegistException exception){
        System.out.println("Global 레벨의 exception 처리");
        model.addAttribute("exception", exception);
        return "error/memberRegist";
    }



    @ExceptionHandler(Exception.class)
    public String nullPointerExceptionHandler(Exception e){
        System.out.println("exception 발생함");
        return "error/default";
    }



}
