package com.ohgiraffers.pos.menu.service;

import com.ohgiraffers.pos.menu.dto.MenuDTO;
import com.ohgiraffers.pos.menu.model.MenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Objects;

@Service
public class MenuService {


    @Autowired
    private MenuDAO menuDAO;

    public List<MenuDTO> selectAll(){
        List<MenuDTO> allMenu = menuDAO.selectAll();

        if (Objects.isNull(allMenu)){
            System.out.println("exception");
        }

        return allMenu;
    }

    public int registMenu(MenuDTO menuDTO)  {
        int menu = menuDAO.registMenu(menuDTO);
        if(menu==0){
            System.out.println("exception regist 발생");
        }
        return menu;
    }


    public int updateMenu(MenuDTO menuDTO) {
        int menu = menuDAO.update(menuDTO);
        if(menu==0){
            System.out.println("exception  발생");
        }
        return menu;
    }

    public int deleteMenu(MenuDTO menuDTO){
        int menu = menuDAO.delete(menuDTO);

        if(menu==0){
            System.out.println("exception 발");
        }
        return  menu;
    }
}
