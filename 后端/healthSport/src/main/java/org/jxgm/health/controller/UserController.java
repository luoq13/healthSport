package org.jxgm.health.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jxgm.health.entity.PageInfo;
import org.jxgm.health.entity.User;
import org.jxgm.health.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luo
 * @date 2020/11/10 11:33
 * @description
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public String login(@RequestBody User user){
        String flag = "...";
        Map<String,Object> map = new HashMap<>();
        User userData = userService.checkUser(user);
        if (userData == null || userData.equals(null)){
            flag =  "error";
        }else {
            flag =  "ok";
        }
        map.put("flag",flag);
        map.put("user",userData);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = null;
        try {
            s = objectMapper.writeValueAsString(map);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return s;
    }

    @RequestMapping("users")
    public String listUser(PageInfo pageInfo){
        Map<String, Object> users = userService.listUser(pageInfo);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = null;
        try {
            s = objectMapper.writeValueAsString(users);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return s;
    }

    @PutMapping("updateState")
    public String updateState(Integer id,boolean state){
        int i = userService.updateState(id, state);
        return i > 0 ? "ok":"error";
    }

    @PostMapping("user")
    public String addUser(@RequestBody User user){
        user.setRole("普通用户");
        int i = userService.addUser(user);
        return i > 0 ? "ok":"error";
    }

    @DeleteMapping("user")
    public String deleteUser(Integer id){
       return userService.deleteUser(id);
    }

    @GetMapping("user")
    public String getUpdateUser(Integer id){
       return userService.getUpdateUser(id);
    }

    @PutMapping("user")
    public String updateUser(@RequestBody User user){
       return userService.updateUser(user);
    }
}
