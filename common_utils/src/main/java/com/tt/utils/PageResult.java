package com.tt.utils;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: blackcat
 * @Date: 2020-01-15
 * @Description: com.tt.utils
 * @version:
 * 分页模型
 */
public class PageResult implements Serializable {

    private Integer pageIndex; //当前页
    private Long totalPage; // 总页数
    private List result; // 返回结果集

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }
}
