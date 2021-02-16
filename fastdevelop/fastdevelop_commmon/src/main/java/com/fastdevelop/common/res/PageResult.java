package com.fastdevelop.common.res;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
public class PageResult<T> implements Serializable {

    /**
     * 页码
     */
    private int pageNum;
    /**
     * 每页结果数
     */
    private int pageSize;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 总数
     */
    private long total;


    private List<T> list;

    public PageResult() {
    }

    public PageResult(int pageNum, int pageSize, int totalPage, long total, List<T> list) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.total = total;
        this.list = list;
    }

}
