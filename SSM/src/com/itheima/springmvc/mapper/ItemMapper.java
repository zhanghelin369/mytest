package com.itheima.springmvc.mapper;

import java.util.List;

import com.itheima.springmvc.pojo.Item;

public interface ItemMapper {
	// 查询 所有数据
	public List<Item> findItemList();

	// 根据id获取数据
	public Item findItemById(Integer id);

	// 修改 通过Id对商品信息进行修改
	public void updateItemById(Item item);
}
