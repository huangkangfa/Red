package com.hkf.coffee.http.base;

import com.hkf.coffee.others.json.JsonUtil;

import java.util.List;

/**
 * 请求结果
 * Created by wanglei on 16/3/29.
 */
public class Result {

    private String retCode;
    private String data;
    private String errorMsg;
    private String json;
    //分页数据
    private int pageNum;//当前页
    private int pageCount;//每页条数
    private int totalPage;//总页数
    private int totalCount;//总条数


    public boolean isSuccess() {
        return RetCode.SUCCESS.equals(retCode);
    }

    /**
     * <T> T
     */
    public <T> T getObj(Class<T> cls) {
        return JsonUtil.getObj(data, cls);
    }

    /**
     * <T> List<T>
     */
    public <T> List<T> getListObj(Class<T> cls) {
        return JsonUtil.getListObj(data, cls);
    }


    // ===================get set 方法========================

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
