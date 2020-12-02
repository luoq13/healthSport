package org.jxgm.health.dao;

import org.jxgm.health.entity.MainMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author luo
 * @date 2020/11/10 17:28
 * @description
 */
@Repository
public interface MenuDao {

    List<MainMenu> listMenu();

}
