package org.jxgm.health.dao;

import org.apache.ibatis.annotations.Param;
import org.jxgm.health.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author luo
 * @date 2020/11/10 11:56
 * @description
 */
@Repository
public interface UserDao {

    /*
    * 查询用户
    * */
    User checkUser(@Param("username") String username,@Param("password") String password);

    /*
     * 获取所有用户数据
     * */
    List<User> listUser(@Param("username") String username, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

    /*
    * 获取总记录数
    * */
    int getUserCount(@Param("username") String username);

    /*
    * 修改用户状态
    * */
    int updateState(Integer id,boolean state);

    /*
    * 添加用户
    * */
    int addUser(User user);

    /*
    * 删除用户
    * */
    int deleteUser(Integer id);

    /*
    * 根据id查询用户
    * */
    User getUpdateUser(Integer id);

    /*
    * 修改用户
    * */
    int updateUser(User user);
}
