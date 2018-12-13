package com.zjyx.right.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
		try{
			PageInfoDto<SysRole> roles = roleservice.getList(bean);
			ModelAndView mv = new ModelAndView("views/role-list");
			mv.addObject("bean", bean);
			mv.addObject("list", roles);
			return mv;
		}catch(Exception e){
			return BaseViewHelper.get500ModelAndView();
		}
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public BaseView save(SysRole bean){
		try {
			return roleservice.save(bean);
		} catch (Exception e) {
			return BaseViewHelper.getFailBaseView("2001",e.getMessage());
		}
	}
	
	@RequestMapping("/del")
	@ResponseBody
	public BaseView del(SysRole bean){
		try {
			if(StringUtils.isEmptyOrWhitespaceOnly(bean.getRoleId())){
				return BaseViewHelper.getFailBaseView("2002","请选择删除行");
			}
			return roleservice.del(bean);
		} catch (Exception e) {
			return BaseViewHelper.getFailBaseView("2001",e.getMessage());
		}
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public BaseView update(SysRole bean){
		try{
			if(StringUtils.isEmptyOrWhitespaceOnly(bean.getRoleId())){
				return BaseViewHelper.getFailBaseView("2002", "角色ID不能为空");
			}
			return roleservice.update(bean);
		}catch (Exception e) {
			return BaseViewHelper.getFailBaseView("2001",e.getMessage());
		}
	}
	
	@RequestMapping("/edit")
	public ModelAndView detail(String roleId){
		try{
			ModelAndView model = new ModelAndView("views/role-edit");
			if(StringUtils.isEmptyOrWhitespaceOnly(roleId)){
				model.addObject("model", BaseViewHelper.getFailBaseView("201", "参数不能为空"));
				return model;
			}
			SysRole role = roleservice.findByRoleId(roleId);
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
