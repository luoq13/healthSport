package org.jxgm.health.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jxgm.health.entity.MainMenu;
import org.jxgm.health.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luo
 * @date 2020/11/11 11:49
 * @description
 */
@RestController
public class MenuController {

    @Autowired
    MenuService menuService;

    @RequestMapping("/menus")
    public String getMenus(){
        String flag = "error";
        Map<String,Object> map = new HashMap<>();
        List<MainMenu> menus = menuService.getMenus();
        if (menus != null){
            flag = "ok";
        }
        map.put("menus",menus);
        map.put("flag",flag);
        ObjectMapper mapper = new ObjectMapper();
        String s = null;
        try {
            s = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return s;
    }
}
