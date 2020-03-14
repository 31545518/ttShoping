package com.tt.content.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.tt.content.service.ContentCategoryService;
import com.tt.mapper.TbContentCategoryMapper;
import com.tt.pojo.TbContentCategory;
import com.tt.pojo.TbContentCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Auther: blackcat
 * @Date: 2020-02-19
 * @Description: com.tt.content.service.impl
 * @version:
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Autowired
    private TbContentCategoryMapper tbContentCategoryMapper;

    @Override
    public List<TbContentCategory> selectContentCategoryByParentId(Long parentId) {
        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbContentCategory> tbContentCategories = tbContentCategoryMapper.selectByExample(example);

        return tbContentCategories;
    }

    @Override
    @LcnTransaction
    public Integer insertContentCategory(TbContentCategory tbContentCategory) {

        tbContentCategory.setUpdated(new Date());
        tbContentCategory.setCreated(new Date());
        tbContentCategory.setIsParent(false);
        tbContentCategory.setSortOrder(1);
        tbContentCategory.setStatus(1);
        // 插入数据
        int contentCategoryNum = tbContentCategoryMapper.insert(tbContentCategory);

        // 查询当前新节点的父节点
        TbContentCategory contentCategory = this.tbContentCategoryMapper.selectByPrimaryKey(tbContentCategory.getParentId());
        // 判断当前父节点是否是叶子节点
        if (!contentCategory.getIsParent()){
            contentCategory.setIsParent(true);
            contentCategory.setUpdated(new Date());
            this.tbContentCategoryMapper.updateByPrimaryKey(contentCategory);
        }

        return contentCategoryNum;
    }

    @Override
    @LcnTransaction
    public Integer deleteContentCategoryById(Long categoryId) {
        // 查询当前节点
        TbContentCategory contentCategory = this.tbContentCategoryMapper.selectByPrimaryKey(categoryId);
        // 删除当前子节点
        Integer status = this.deleteNode(contentCategory);

        // 查询当前节点父节点
        TbContentCategory category = this.tbContentCategoryMapper.selectByPrimaryKey(contentCategory.getParentId());

        // 查看当前节点是否有兄弟节点，决定是否修改父节点状态
        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(category.getId());

        List<TbContentCategory> list = this.tbContentCategoryMapper.selectByExample(example);
        if (list.size() == 0){
            category.setIsParent(false);
            category.setUpdated(new Date());
            this.tbContentCategoryMapper.updateByPrimaryKey(category);
        }

        return 200;
    }

    /**
     * 修改内容分类
     * @param tbContentCategory
     * @return
     */
    @Override
    @LcnTransaction
    public Integer updateContentCategory(TbContentCategory tbContentCategory) {
        tbContentCategory.setUpdated(new Date());
        return tbContentCategoryMapper.updateByPrimaryKeySelective(tbContentCategory);
    }

    // 判断是否有子节点如果有就迭代删除
    private Integer deleteNode(TbContentCategory contentCategory) {
        if (contentCategory.getIsParent()){
            // 是父节点
            // 查询当前节点所有的子节点
            TbContentCategoryExample example = new TbContentCategoryExample();
            TbContentCategoryExample.Criteria criteria = example.createCriteria();
            criteria.andParentIdEqualTo(contentCategory.getId());
            List<TbContentCategory> categoryList = this.tbContentCategoryMapper.selectByExample(example);
            for (TbContentCategory children:categoryList ) {
                this.deleteNode(children);
                this.tbContentCategoryMapper.deleteByPrimaryKey(contentCategory.getId());
            }

        }else {
            // 不是父节点
            this.tbContentCategoryMapper.deleteByPrimaryKey(contentCategory.getId());
        }
        return 200;
    }
}
