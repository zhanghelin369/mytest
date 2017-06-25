package com.itheima.springmvc.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itheima.springmvc.exception.MyException;
import com.itheima.springmvc.pojo.Item;
import com.itheima.springmvc.pojo.QueryVo;
import com.itheima.springmvc.pojo.User;
import com.itheima.springmvc.service.ItemService;

@Controller
public class ItemController {
	
	//注入service
	@Autowired
	private ItemService itemServicel;
	
	@RequestMapping(value="test/index.action")
	public ModelAndView index() throws MyException{
		ModelAndView mav = new ModelAndView();
		List<Item> itemList = itemServicel.findItemList();
		//代码有误抛出下面的异常
		/*if (null==null) {
			throw new MyException("输入有误");
		}*/
		
		mav.addObject("itemList",itemList);
		mav.setViewName("itemList");
		return mav;
	}
	
	@RequestMapping(value="itemEdit.action")
	public ModelAndView itemEdit(Integer id){
		ModelAndView mav = new ModelAndView();
		Item item = itemServicel.findItemById(id);
		mav.addObject("item", item);
		mav.setViewName("editItem");
		return mav;
	}
	
	/*@RequestMapping(value="updateitem.action")
	public ModelAndView updateitem(Item item){
		ModelAndView mav = new ModelAndView();
		itemServicel.updateItemById(item);
		mav.setViewName("success");
		return mav;
	}*/
	
	@RequestMapping(value="updateitem.action")
	public String updateitem(Item item,MultipartFile pictureFile) throws Exception{
		itemServicel.updateItemById(item);
		//获取文件名
		String name = pictureFile.getOriginalFilename();
		//获取后缀名
		String ext = FilenameUtils.getExtension(name);
		
		String uuid = UUID.randomUUID().toString();
		//图片名称
		String picName = uuid+ "." + ext;
		//保存图片
		pictureFile.transferTo(new File("D:\\picture"+picName));
		
		//保存
		item.setPic(picName);
		//修改
		itemServicel.updateItemById(item);
		return "forward:test/index.action";
	}
	@RequestMapping(value="item/queryitem.action")
	//此处的参数类型必须和jsp页面传过来的参数类型一致,否则会接收不到
//	public String queryitem(Integer[] ids){
	public String queryitem(QueryVo vo){
		System.out.println(vo.getIds());
		return null;
	}
	
	@RequestMapping(value="item/testJson.action")
	public @ResponseBody Item testJson(@RequestBody Item item){
		
		return item;
	}
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(String username,HttpSession httpSession){
		User user = new User();
		user.setUsername(username);
		httpSession.setAttribute("USER_SESSION", user);
		return "redirect:test/index.action";
	}
	
}
