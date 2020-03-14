package com.tt.utils;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: blackcat
 * @Date: 2020-02-24
 * @Description: com.tt.utils
 * @version:
 */
public class CatResult implements Serializable {

    private List<?>data;

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
