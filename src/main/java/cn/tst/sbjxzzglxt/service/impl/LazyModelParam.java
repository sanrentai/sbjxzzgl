package cn.tst.sbjxzzglxt.service.impl;

import java.util.Map;

/**
 * 延迟加载查询的参数
 * 
 * @author 
 */
public class LazyModelParam {
    private String dbName = null;
    /**
     * 起始位置
     */
    private int startPos;
    
    /**
     * 一页显示的项目数
     */
    private int pageSize;
    
    /**
     * 总项目数
     */
    private long recordCount;
    
    /**
     * 需要进行排序的列
     */
    private String sortField;
    
    /**
     * 是否升序
     */
    private boolean ascending;
    
    /**
     * 过滤字段
     */
    private Map<String, Object> filterMap;
    
    /**
     * sql文参数
     */
    private Map<String, Object> conditionMap;

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRecordCount() {
        return (int) recordCount;
    }

    public void setRecordCount(long recordCount) {
        this.recordCount = recordCount;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public boolean isAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }

    public Map<String, Object> getFilterMap() {
        return filterMap;
    }

    public void setFilterMap(Map<String, Object> filterMap) {
        this.filterMap = filterMap;
    }

    public Map<String, Object> getConditionMap() {
        return conditionMap;
    }

    public void setConditionMap(Map<String, Object> conditionMap) {
        this.conditionMap = conditionMap;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
}
