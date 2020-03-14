package com.tt.content.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tt.content.service.ContentService;
import com.tt.mapper.TbContentMapper;
import com.tt.pojo.TbContent;
import com.tt.pojo.TbContentExample;
import com.tt.utils.PageResult;
import com.tt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Auther: blackcat
 * @Date: 2020-02-22
 * @Description: com.tt.content.service.impl
 * @version:
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private TbContentMapper tbContentMapper;
    @Value("${frontend.AD}")
    private Long AD;

    @Override
    public PageResult selectTbContentAllByCategoryId(Integer page, Integer rows, Long categoryId) {
        PageHelper.startPage(page,rows);
        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        List<TbContent> list = this.tbContentMapper.selectByExample(example);
        PageInfo<TbContent> pageInfo = new PageInfo<>(list);
        PageResult result = new PageResult();
        result.setPageIndex(page);
        result.setTotalPage(pageInfo.getTotal());
        result.setResult(pageInfo.getList());

        return result;
    }

    @Override
    @LcnTransaction
    public Integer insertTbContent(TbContent tbContent) {
        tbContent.setCreated(new Date());
        tbContent.setUpdated(new Date());
        return this.tbContentMapper.insertSelective(tbContent);
    }

    /**
     * 删除分类内容
     * @param id
     * @return
     */
    @Override
    @LcnTransaction
    public Integer deleteContentByIds(Long id) {
        return this.tbContentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map> selectFrontendContentByAD() {
        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(this.AD);
        List<TbContent>list = this.tbContentMapper.selectByExample(example);
        List <Map> result = new ArrayList<>();
        // 模型转换
        for (TbContent content : list){
            Map map = new HashMap();
            map.put("heightB",240);
            map.put("src",content.getPic());
            map.put("width",670);
            map.put("alt",content.getSubTitle());
            map.put("srcB",null);
            map.put("widthB",550);
            map.put("href",content.getUrl());
            map.put("height",240);
            result.add(map);
        }
        return result;
    }
}
