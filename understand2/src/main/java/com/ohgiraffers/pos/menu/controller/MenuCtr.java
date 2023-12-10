package com.ohgiraffers.pos.menu.controller;

import com.ohgiraffers.pos.menu.dto.MenuDTO;
import com.ohgiraffers.pos.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/menu/*")
public class MenuCtr {
    @Autowired
    private MenuService menuService;

    @GetMapping("allMenus")
    public ModelAndView selectAll(ModelAndView mv){
        List<MenuDTO> allMenu = menuService.selectAll();

        mv.addObject("allMenu",allMenu);
        mv.setViewName("menu/allMenus");

        return mv;
    }


}
