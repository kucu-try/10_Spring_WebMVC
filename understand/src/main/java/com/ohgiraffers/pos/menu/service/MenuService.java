package com.ohgiraffers.pos.menu.service;

import com.ohgiraffers.pos.menu.dto.MenuDTO;
import com.ohgiraffers.pos.menu.model.MenuDAO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Objects;

@Service
//비즈니스 로직을 수행하고, 트랜잭션 관리, 예외 처리한다.
public class MenuService {

    private MenuDAO menuDAO;

    public MenuService(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }

    public List<MenuDTO> selectAllMenu() {
       List<MenuDTO> menus = menuDAO.selectAllMenu();

       if (Objects.isNull(menus)){
           System.out.println("exception menus가 없네요");
       }

       return menus;
    }


    public int regist(MenuDTO menuDTO) {
        int menus = menuDAO.regist(menuDTO);
        if(menus==0){
            System.out.println("exception regist 발생");
        }

        return menus;
    }
}
