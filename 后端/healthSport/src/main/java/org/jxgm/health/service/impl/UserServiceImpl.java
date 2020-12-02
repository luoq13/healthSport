package org.jxgm.health.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jxgm.health.dao.UserDao;
import org.jxgm.health.entity.PageInfo;
import org.jxgm.health.entity.User;
import org.jxgm.health.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luo
 * @date 2020/11/10 11:47
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User checkUser(User user){
        return userDao.checkUser(user.getUsername(),user.getPassword());
    }


    @Override
    public Map<String,Object> listUser(PageInfo pageInfo) {
        int pages = userDao.getUserCount("%" + pageInfo.getInfo() + "%");
        int pageStart = (pageInfo.getPageNum() - 1) * pageInfo.getPageSize();
        List<User> users = userDao.listUser("%" + pageInfo.getInfo() + "%", pageStart, pageInfo.getPageSize());
        Map<String,Object> map = new HashMap<>();
        map.put("users",users);
        map.put("pages",pages);
        return map;
    }

    @Override
    public int updateState(Integer id, boolean state) {
        return userDao.updateState(id,state);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public String deleteUser(Integer id) {
        if(userDao.deleteUser(id) > 0) {
            return "ok";
        }else {
            return "error";
        }
    }

    @Override
    public String getUpdateUser(Integer id) {
        User user = userDao.getUpdateUser(id);
        ObjectMapper mapper = new ObjectMapper();
        String result = null;
        try {
            result = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String updateUser(User user) {
       return userDao.updateUser(user) > 0? "ok":"error";
    }
}
