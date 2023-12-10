package com.ohgiraffers.pos.menu.model;

import com.ohgiraffers.pos.menu.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
//resource/mapper/mapper.xml과 매핑시켜준다.
@Mapper
public interface MenuDAO {


   List<MenuDTO> selectAll();

   int registMenu(MenuDTO menuDTO);

   int update(MenuDTO menuDTO);

   int delete(MenuDTO menuDTO);
}
