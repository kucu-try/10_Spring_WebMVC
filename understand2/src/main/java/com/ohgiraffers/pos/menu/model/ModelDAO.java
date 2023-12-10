package com.ohgiraffers.pos.menu.model;

import com.ohgiraffers.pos.menu.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ModelDAO {

    List<MenuDTO> selectAll();

    MenuDTO searchMenu(int code);

}
