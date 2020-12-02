package org.jxgm.health.service.impl;

import org.jxgm.health.dao.MenuDao;
import org.jxgm.health.entity.MainMenu;
import org.jxgm.health.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luo
 * @date 2020/11/10 17:46
 * @description
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuDao menuDao;

    @Override
    public List<MainMenu> getMenus() {
        return menuDao.listMenu();
    }

}
