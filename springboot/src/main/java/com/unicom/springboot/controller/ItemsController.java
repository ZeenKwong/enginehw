package com.unicom.springboot.controller;

import com.unicom.springboot.entity.Items;
import com.unicom.springboot.service.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @ClassName：ItemsController
 * @Author：kuangzy
 * @Time：2019/5/10 0:01
 * @Discription:discription
 */
@RestController
public class ItemsController {
    @Autowired
    ItemsService itemsService;
    @RequestMapping(value = "/addItem",method = RequestMethod.POST)
    public int addItem(@RequestBody Items items){
        Items items1 = new Items();
        items1.setCreatetime(new Date());
        items1.setItemDetail(items.getItemDetail());
        items1.setItemName(items.getItemName());
        items1.setItemPic(items.getItemPic());
        items1.setItemPrice(items.getItemPrice());
        return itemsService.addItem(items1);
    }
    @RequestMapping("/delitem/{itemId}")
    public int delItem(@PathVariable int itemId){
        return itemsService.delItem(itemId);
    }
    @RequestMapping("/finditem/{itemId}")
    public List<Items> findItem(@PathVariable int itemId){
        return itemsService.findItem(itemId);
    }
    @RequestMapping(value = "/updateItem",method = RequestMethod.POST)
    public int updateItems(@RequestBody Items items){
        Items items1 = new Items();
        items1.setItemId(items.getItemId());
        items1.setCreatetime(items.getCreatetime());
        items1.setItemDetail(items.getItemDetail());
        items1.setItemName(items.getItemName());
        items1.setItemPic(items.getItemPic());
        items1.setItemPrice(items.getItemPrice());
        return itemsService.updateItem(items1);
    }
}
