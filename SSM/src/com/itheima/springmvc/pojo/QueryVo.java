package com.itheima.springmvc.pojo;

import java.util.List;


public class QueryVo {
	
	//List
	private List<Integer> idsList;
	
	//array
	private Integer[] ids;//1 10 29

	public List<Integer> getIdsList() {
		return idsList;
	}

	public void setIdsList(List<Integer> idsList) {
		this.idsList = idsList;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	
}
