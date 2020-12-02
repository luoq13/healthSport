package org.jxgm.health.entity;

/**
 * @author luo
 * @date 2020/11/18 16:30
 * @description
 */
public class PageInfo {

    private String info; //查询信息
    private Integer pageNum; //当前页
    private Integer pageSize; //每页数量

    public PageInfo() {

    }

    public PageInfo(String info, Integer pageNum, Integer pageSize) {
        this.info = info;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "info='" + info + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
