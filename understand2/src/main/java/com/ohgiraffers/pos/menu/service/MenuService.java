package com.ohgiraffers.pos.menu.service;

import com.ohgiraffers.pos.menu.dto.MenuDTO;
import com.ohgiraffers.pos.menu.model.ModelDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MenuService {
    @Autowired
    private ModelDAO modelDAO;
    public List<MenuDTO> selectAll() {
        List<MenuDTO> allMenus= modelDAO.selectAll();

        return allMenus;
    }


}
