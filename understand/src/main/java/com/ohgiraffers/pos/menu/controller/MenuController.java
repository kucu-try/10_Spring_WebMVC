package com.ohgiraffers.pos.menu.controller;

import com.ohgiraffers.pos.menu.dto.MenuDTO;
import com.ohgiraffers.pos.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;


@Controller
@RequestMapping("/menus/*")
public class MenuController {

    @Autowired
    private MenuService menuService;
    // 생성자를 만들지 않고 다른 빈에서 쓸 수 있다.

    @GetMapping("allMenus")
    //  url - allMenus 에대한 겟 요청을 처리하는 메서드를 selectAllmenu라고 정의해준다.
    public ModelAndView selectAllMenu(ModelAndView mv){
    // 템플릿/메뉴/allMenus 와 연결하기 위해 GetMapping 해주기
    // 모델에 데이터를 추가하고 뷰를 보여주기위해 selectAllMenu 메소드 만들기
        List<MenuDTO> menus = menuService.selectAllMenu();
        // DTO를 리스트에 담는 menus 변수 만들고 menuService 참조 selectAllMenu메소드를 menus 에 담는다.
        if (Objects.isNull(menus)){
            //최상위 objects에서 꺼내온 isnull을 사용해 menus가 null이면
            System.out.println("exception으로 대체한다");
            // exception으로 대체한다를 출력한다
        }
        // 아니면 넘어가고 ModelAndview 변수인 mv에 있는 addObject 를 이용해 menus를 추가한다.
        mv.addObject("menus",menus);
        // 보여지는 이름은 menu 디렉토리 안의 allMenus에서 쓸 수 있게 한다. 보여준다.
        mv.setViewName("menus/allMenus");

        // mv를 반환한다.
        return mv;
    }


    @GetMapping("regist")
    public void insert(){};

    @PostMapping("regist")
    public ModelAndView insertMenu(ModelAndView mv, MenuDTO menuDTO){
        int regist = menuService.regist(menuDTO);
//localhost:8080/menu/regist
        if(regist >= 0 ){
            System.out.println("exception");
        }
        mv.setViewName("/menus/messagePrint");

        return mv;
    }

}
