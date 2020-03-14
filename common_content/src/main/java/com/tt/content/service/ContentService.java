package com.tt.content.service;

import com.tt.pojo.TbContent;
import com.tt.utils.PageResult;
import com.tt.utils.Result;

import java.util.List;
import java.util.Map;

/**
 * @Auther: blackcat
 * @Date: 2020-02-22
 * @Description: com.tt.content.service
 * @version:
 */
public interface ContentService {
    PageResult selectTbContentAllByCategoryId(Integer page, Integer rows, Long categoryId);

    Integer insertTbContent(TbContent tbContent);

    Integer deleteContentByIds(Long id);

    List<Map> selectFrontendContentByAD();
}
