package com.itheima.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.springmvc.mapper.ItemMapper;
import com.itheima.springmvc.pojo.Item;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper itemMapper;
	
	public List<Item> findItemList() {
		return itemMapper.findItemList();
	}

	@Override
	public Item findItemById(Integer id) {
		return itemMapper.findItemById(id);
	}

	@Override
	public void updateItemById(Item item) {
		 itemMapper.updateItemById(item);
	}
	
}
