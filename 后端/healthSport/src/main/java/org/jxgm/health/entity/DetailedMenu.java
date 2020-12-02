package org.jxgm.health.entity;

/**
 * @author luo
 * @date 2020/11/10 17:19
 * @description
 */
public class DetailedMenu {
    private Integer id;
    private String title;
    private String path;

    public DetailedMenu(Integer id, String title, String path) {
        this.id = id;
        this.title = title;
        this.path = path;
    }

    public DetailedMenu(String title, String path) {
        this.title = title;
        this.path = path;
    }

    public DetailedMenu() {
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

    @Override
    public String toString() {
        return "DetailedMenu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
