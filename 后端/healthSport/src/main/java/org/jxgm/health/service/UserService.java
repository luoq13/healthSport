package org.jxgm.health.service;

import org.jxgm.health.entity.PageInfo;
import org.jxgm.health.entity.User;

import java.util.Map;

/**
 * @author luo
 * @date 2020/11/10 11:47
 * @description
 */
public interface UserService {

    User checkUser(User user);

    Map<String, Object> listUser(PageInfo pageInfo);

    int updateState(Integer id,boolean state);

    int addUser(User user);

    String deleteUser(Integer id);

    String getUpdateUser(Integer id);

    String updateUser(User user);
}
