package entity;

import java.util.List;

public class Page {
    /**
     * 当前页数
     */
    private int currentPage;

    /**
     * 每页的行数
     */
    private int rows;

    /**
     * 从第几条开始
     */
    private int start;

    /**
     * 总共多少页
     */
    private int totalCount;

    /**
     * 总共多少条数据
     */
    private int count;

    /**
     * 返回的User对象集合
     */
    private List<library> list;

    public Page() {
    }

    public Page(int currentPage, int rows, int start, int totalCount, int count, List<library> list) {
        this.currentPage = currentPage;
        this.rows = rows;
        this.start = start;
        this.totalCount = totalCount;
        this.count = count;
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<library> getList() {
        return list;
    }

    public void setList(List<library> list) {
        this.list = list;
    }
}
