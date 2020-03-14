package com.tt.search.config;

import com.netflix.discovery.converters.Auto;
import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;

/**
 * SolrTemplate配置
 * @Auther: blackcat
 * @Date: 2020-02-27
 * @Description: com.tt.search.config
 * @version:
 */
@Configuration
public class SolrConfig {

    @Autowired
    private SolrClient solrClient;

    @Bean
    public SolrTemplate getSolrTemplate(){
        return new SolrTemplate(solrClient);
    }


}
