package com.zjyx.right.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.StringUtils;
import com.zjyx.right.helper.BaseViewHelper;
import com.zjyx.right.model.controllerview.BaseView;
import com.zjyx.right.model.enums.UpDown_Status;
import com.zjyx.right.model.persistence.AdminUser;
import com.zjyx.right.service.AdminUserService;


@Controller
@RequestMapping("/system")
public class LoginController {
	
	@Resource
	AdminUserService adminUserService;

	@ResponseBody
	@RequestMapping("/login")
	public BaseView select(String name, String pass){
		if(StringUtils.isEmptyOrWhitespaceOnly(name)){
			return BaseViewHelper.getFailBaseView("10001", "用户名不能为空");
		}
		if(StringUtils.isEmptyOrWhitespaceOnly(pass)){
			return BaseViewHelper.getFailBaseView("10002", "密码不能为空");
		}
		AdminUser user = adminUserService.getAdminUser(name, pass);
		if(user == null || StringUtils.isEmptyOrWhitespaceOnly(user.getUsername())){
			return BaseViewHelper.getFailBaseView("20001", "密码错误");
		}
		if(UpDown_Status.DOWN == user.getStatus()){
			return BaseViewHelper.getFailBaseView("20002", "无效用户");
		}
		return BaseViewHelper.getSuccessBaseView();
	}
	
	@RequestMapping("/adminlogin")
	public ModelAndView adminlogin(){
		ModelAndView mv = new ModelAndView("views/login");
		return mv;
	}
	
}
