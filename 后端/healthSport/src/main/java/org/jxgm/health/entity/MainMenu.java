package org.jxgm.health.entity;

import java.util.List;

/**
 * @author luo
 * @date 2020/11/10 17:25
 * @description
 */
public class MainMenu {

    private Integer id;
    private String title;
    private String path;
    private List<DetailedMenu> menuLists;

    public MainMenu(Integer id, String title, String path, List<DetailedMenu> menuLists) {
        this.id = id;
        this.title = title;
        this.path = path;
        this.menuLists = menuLists;
    }

    public MainMenu(String title, String path, List<DetailedMenu> menuLists) {
        this.title = title;
        this.path = path;
        this.menuLists = menuLists;
    }

    public MainMenu() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<DetailedMenu> getMenuList() {
        return menuLists;
    }

    public void setMenuList(List<DetailedMenu> menuList) {
        this.menuLists = menuList;
    }

    @Override
    public String toString() {
        return "MainMenu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", path='" + path + '\'' +
                ", menuList=" + menuLists +
                '}';
    }
}
