package com.tt.content.feign;

import com.tt.pojo.TbContent;
import com.tt.pojo.TbContentCategory;
import com.tt.utils.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @Auther: blackcat
 * @Date: 2020-02-19
 * @Description: com.tt.content.feign
 * @version:
 */
@FeignClient(value = "common-content")
public interface CommonContentFeignClient {

    //-----------------------------------
    @PostMapping("/service/contentCategory/selectContentCategoryByParentId")
    List<TbContentCategory> selectContentCategoryByParentId(@RequestParam("parentId") Long parentId);

    @PostMapping("/service/contentCategory/insertContentCategory")
    Integer insertContentCategory(@RequestBody TbContentCategory tbContentCategory);

    @PostMapping("/service/contentCategory/deleteContentCategoryById")
    Integer deleteContentCategoryById(@RequestParam("categoryId") Long categoryId);

    @PostMapping("/service/contentCategory/updateContentCategory")
    Integer updateContentCategory(@RequestBody TbContentCategory tbContentCategory);

    //--------------------------------
    @PostMapping("/service/content/selectTbContentAllByCategoryId")
    PageResult selectTbContentAllByCategoryId(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows , @RequestParam("categoryId") Long categoryId);

    @PostMapping("/service/content/insertTbContent")
    Integer insertTbContent(@RequestBody TbContent tbContent);

    @PostMapping("/service/content/deleteContentByIds")
    Integer deleteContentByIds(@RequestParam("id") Long id);

    @PostMapping("/service/content/selectFrontendContentByAD")
    List<Map> selectFrontendContentByAD();
}
