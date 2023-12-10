package com.ohgiraffers.pos.menu.Controller;

import com.ohgiraffers.pos.menu.dto.MenuDTO;
import com.ohgiraffers.pos.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/menu/*")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("all")
    public ModelAndView selectAll(ModelAndView mv){

        List<MenuDTO> allMenu = menuService.selectAll();

        if (Objects.isNull(allMenu)){
            System.out.println("exception");
        }

        mv.addObject("allMenu" , allMenu);
        mv.setViewName("menu/all");

        return mv;
    }

    @GetMapping("regist")
    public void regist(){}


    @PostMapping("regist")
    public ModelAndView registMenu(ModelAndView mv, MenuDTO menuDTO){
        int regist = menuService.registMenu(menuDTO);

        if(regist==0){
            System.out.println("asd");
        }
        mv.setViewName("/menu/print");

        return mv;
    }

    @PostMapping("insert")
    public String insert1(){
        return "/menu/regist";
    }


    @GetMapping("update")
    public void update(){}

    @PostMapping("update")
    public ModelAndView updateMenu(ModelAndView mv, MenuDTO menuDTO){
        int update = menuService.updateMenu(menuDTO);

        if(update==0){
            System.out.println("exception");
        }
        mv.setViewName("/menu/print");

        return mv;
    }
    
    @PostMapping("change")
    public String change(){
        return "/menu/update";
    }


    @GetMapping("delete")
    public void delete(){}

    @PostMapping("delete")
    public ModelAndView deleteMenu(ModelAndView mv, MenuDTO menuDTO){
        int delete= menuService.deleteMenu(menuDTO);

        if(delete==0){
            System.out.println("erere");
        }
        mv.setViewName("/menu/print");

        return mv;
    }

    @PostMapping("destroy")
    public String destroy() {
        return "/menu/delete";
    }

}
