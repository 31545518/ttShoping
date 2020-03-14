package com.tt.frontend.portal.controller;

import com.tt.frontend.portal.service.CategoryService;
import com.tt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: blackcat
 * @Date: 2020-02-25
 * @Description: com.tt.frontend.portal.controller
 * @version:
 */
@RestController
@RequestMapping("/frontend/content")
@RefreshScope
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/selectFrontendContentByAD")
    public Result selectFrontendContentByAD(){
        try{
            return categoryService.selectFrontendContentByAD();
        }catch (Exception e){
            e.printStackTrace();
        }

        return Result.build(500,"ERROR");
    }
}
