package com.tt.frontend.portal.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

/**
 * @Auther: blackcat
 * @Date: 2020-02-25
 * @Description: com.tt.frontend.portal.feign
 * @version:
 */
@FeignClient(value = "common-content")
public interface CommonCategoryFeignClient {

    //---------------------------
    @PostMapping("/service/content/selectFrontendContentByAD")
    List<Map> selectFrontendContentByAD();
}
