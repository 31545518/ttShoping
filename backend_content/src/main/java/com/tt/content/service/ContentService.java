package com.tt.content.service;

import com.tt.pojo.TbContent;
import com.tt.utils.Result;

/**
 * @Auther: blackcat
 * @Date: 2020-02-22
 * @Description: com.tt.content.service
 * @version:
 */
public interface ContentService {
    Result selectTbContentAllByCategoryId(Integer page, Integer rows, Long categoryId);

    Result insertTbContent(TbContent tbContent);

    Result deleteContentByIds(Long ids);
}
