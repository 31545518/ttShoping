package com.tt.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @Auther: blackcat
 * @Date: 2020-02-24
 * @Description: com.tt.utils
 * @version:
 */
public class CatNode {

    @JsonProperty("n")
    private String name;
    @JsonProperty("i")
    private List<?> item;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<?> getItem() {
        return item;
    }

    public void setItem(List<?> item) {
        this.item = item;
    }
}
