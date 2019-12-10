package com.example.demo.dto;

public class QueryParam {
    private String keyword;
    private String orderBy;
    private String sortRule;
    
    /**
     * 
     * @param keyword
     */
    public void setKeyword(final String keyword){
        this.keyword = keyword;
    }
    
    public String getKeyword(){
        return keyword;
    }

    /**
     * 
     * @param orderBy
     */
    public void setOrderBy(final String orderBy){
        this.orderBy = orderBy;
    }
    
    public String getOrderBy(){
        return orderBy;
    }
    
    /**
     * 
     * @param sortRule
     */
    public void setSortRule(final String sortRule){
        this.sortRule = sortRule;
    }

    public String getSortRule(){
        return sortRule;
    }
}