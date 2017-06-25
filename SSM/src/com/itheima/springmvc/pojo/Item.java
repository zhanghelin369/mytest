package com.itheima.springmvc.pojo;

import java.util.Date;

public class Item {
	// 商品id
	private Integer id; 
	// 商品名称
	private String name;
	// 商品价格
	private Float price;
	// 商品创建时间
	private Date createtime;
	// 商品描述
	private String detail;
	
	//图片
	private String pic ;
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", createtime=" + createtime + ", detail="
				+ detail + "]";
	}

	public Item() {
		super();
	}
	
	
	
}
