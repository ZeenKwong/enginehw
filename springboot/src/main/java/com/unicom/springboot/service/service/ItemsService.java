package com.unicom.springboot.service.service;

import com.unicom.springboot.entity.Items;

import java.util.List;

/**
 * @ClassName：ItemsService
 * @Author：kuangzy
 * @Time：2019/5/9 23:44
 * @Discription:discription
 */
public interface ItemsService {
    int addItem(Items items);
    int delItem(int itemId);
    List<Items> findItem(int itemId);
    int updateItem(Items items);
}
