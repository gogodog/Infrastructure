package com.zjyx.right.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.StringUtils;
import com.zjyx.right.helper.BaseViewHelper;
import com.zjyx.right.model.PageInfoDto;
import com.zjyx.right.model.controllerbean.SysUserBean;
import com.zjyx.right.model.controllerview.BaseView;
import com.zjyx.right.model.persistence.SysUser;
import com.zjyx.right.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userservice;
	
	@RequestMapping("/list")
	public ModelAndView list(SysUserBean bean){
		try{
			PageInfoDto<SysUser> roles = userservice.getList(bean);
			ModelAndView mv = new ModelAndView("views/user-list");
			mv.addObject("bean", bean);
			mv.addObject("list", roles);
			return mv;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return BaseViewHelper.get500ModelAndView();
		}
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public BaseView save(SysUser bean){
		try {
			return userservice.save(bean);
		} catch (Exception e) {
			return BaseViewHelper.getFailBaseView("2001",e.getMessage());
		}
	}
	
	@RequestMapping("/del")
	@ResponseBody
	public BaseView del(SysUser bean){
		try {
			if(StringUtils.isEmptyOrWhitespaceOnly(bean.getUserId())){
				return BaseViewHelper.getFailBaseView("2002","请选择删除行");
			}
			return userservice.del(bean);
		} catch (Exception e) {
			return BaseViewHelper.getFailBaseView("2001",e.getMessage());
		}
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public BaseView update(SysUser bean){
		try{
			if(StringUtils.isEmptyOrWhitespaceOnly(bean.getUserId())){
				return BaseViewHelper.getFailBaseView("2002", "角色ID不能为空");
			}
			return userservice.update(bean);
		}catch (Exception e) {
			return BaseViewHelper.getFailBaseView("2001",e.getMessage());
		}
	}
	
	@RequestMapping("/edit")
	public ModelAndView detail(String userId){
		try{
			ModelAndView model = new ModelAndView("views/user-edit");
			if(StringUtils.isEmptyOrWhitespaceOnly(userId)){
				model.addObject("model", BaseViewHelper.getFailBaseView("201", "参数不能为空"));
				return model;
			}
			SysUser role = userservice.findByUserId(userId);
			if(role == null){
				model.addObject("model", BaseViewHelper.getFailBaseView("202", "无此记录"));
			}
			model.addObject("model", role);
			return model;
		}catch(Exception e){
			return BaseViewHelper.get500ModelAndView();
		}
	}
}
