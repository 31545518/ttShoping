package com.tt.search.service;

import com.tt.utils.Result;
import com.tt.utils.SolrDocument;

import java.util.List;

/**
 * @Auther: blackcat
 * @Date: 2020-02-28
 * @Description: com.tt.search.service
 * @version:
 */
public interface SolrService {

    Result importAll();


    List<SolrDocument> selectByQ(String q, Long page, Integer rows);
}
