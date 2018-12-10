package com.zjyx.right.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.StringUtils;
import com.zjyx.right.helper.BaseViewHelper;
import com.zjyx.right.model.PageInfoDto;
import com.zjyx.right.model.controllerbean.SysRoleBean;
import com.zjyx.right.model.controllerview.BaseView;
import com.zjyx.right.model.persistence.SysRole;
import com.zjyx.right.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RoleService roleservice;
	
	@RequestMapping("/list")
	public ModelAndView list(SysRoleBean bean){
		bean.setCurrentPage(4);
		bean.setOnePageSize(2);
		System.out.println(JSONObject.toJSONString(bean));
		PageInfoDto<SysRole> roles = roleservice.getList(bean);
		ModelAndView mv = new ModelAndView("views/index");
		System.out.println(JSONObject.toJSONString(roles));
		return mv;
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public BaseView save(SysRole bean){
		bean.setCreateuser("prescott");
		bean.setRoleId("1");
		bean.setRoleName("天管");
		bean.setSiteId((short) 1);
		return roleservice.save(bean);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public BaseView update(String roleId){
		return BaseViewHelper.getSuccessBaseView();
	}
	
	@RequestMapping("/detail")
	public ModelAndView detail(String roleId){
		ModelAndView model = new ModelAndView("views/index");
		if(StringUtils.isEmptyOrWhitespaceOnly(roleId)){
			model.addObject("model", BaseViewHelper.getBaseView(true, "201", "参数不能为空"));
			return model;
		}
		SysRole role = roleservice.findByRoleId(roleId);
		if(role == null){
			model.addObject("model", BaseViewHelper.getBaseView(true, "202", "无此记录"));
		}
		return model;
	}
}
