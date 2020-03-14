package com.tt.item.service.impl;

import com.tt.item.service.ItemCategoryService;
import com.tt.mapper.TbItemCatMapper;
import com.tt.pojo.TbItemCat;
import com.tt.pojo.TbItemCatExample;
import com.tt.utils.CatNode;
import com.tt.utils.CatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: blackcat
 * @Date: 2020-01-30
 * @Description: com.tt.item.service.impl
 * @version:
 * 商品分类查询
 */
@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {
    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    /**
     * 根据分类id查询子节点
     * @param id
     * @return
     */
    @Override
    public List<TbItemCat> selectItemCategoryByParentId(Long id) {
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(id);
        criteria.andStatusEqualTo(1);
        List<TbItemCat> tbItemCats = this.tbItemCatMapper.selectByExample(example);
        return tbItemCats;
    }

    /**
     * 查询首页商品分类
     * @return
     */
    @Override
    public CatResult selectItemCategoryAll() {

        CatResult catResult = new CatResult();
        // 查询商品分类
        catResult.setData(getCatList(0L));

        return catResult;
    }

    /*
    私有方法查询商品分类
     */
    private List<?> getCatList(Long parentId) {
        // 创建查询条件
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();

        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> list = this.tbItemCatMapper.selectByExample(example);
        List resultList = new ArrayList();
        int count = 0;
        for (TbItemCat tbItemCat:list){
            // 判断是否是父节点
            if (tbItemCat.getIsParent()){
                // 父节点
                CatNode catNode = new CatNode();
                catNode.setName(tbItemCat.getName());
                catNode.setItem(getCatList(tbItemCat.getId()));
                resultList.add(catNode);
                count ++;
                if (count == 18){
                    break;
                }
            } else {
                // 叶子节点
                resultList.add(tbItemCat.getName());
            }

        }


        return resultList;
    }
}
