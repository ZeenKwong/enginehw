package com.unicom.springboot.service.impl;

import com.unicom.springboot.entity.Items;
import com.unicom.springboot.entity.ItemsExample;
import com.unicom.springboot.mapper.ItemsMapper;
import com.unicom.springboot.service.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName：ItemsServiceImpl
 * @Author：kuangzy
 * @Time：2019/5/9 23:47
 * @Discription:discription
 */
@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    ItemsMapper itemsMapper;
    @Override
    public int addItem(Items items) {
        return itemsMapper.insert(items);
    }

    @Override
    public int delItem(int itemId) {
        return itemsMapper.deleteByPrimaryKey(itemId);
    }

    @Override
    public List<Items> findItem(int itemId) {
        ItemsExample itemsExample = new ItemsExample();
        if(itemId != 0){
            ItemsExample.Criteria criteria = itemsExample.createCriteria();
            criteria.andItemIdEqualTo(itemId);
        }
        return itemsMapper.selectByExample(itemsExample);
    }

    @Override
    public int updateItem(Items items) {
        return itemsMapper.updateByPrimaryKeySelective(items);
    }
}
