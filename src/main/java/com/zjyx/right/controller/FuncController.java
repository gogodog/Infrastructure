package com.zjyx.right.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.StringUtils;
import com.zjyx.right.helper.BaseViewHelper;
import com.zjyx.right.model.PageInfoDto;
import com.zjyx.right.model.controllerbean.SysFuncBean;
import com.zjyx.right.model.controllerview.BaseView;
import com.zjyx.right.model.persistence.SysFunc;
import com.zjyx.right.service.FuncService;

@Controller
@RequestMapping("/func")
public class FuncController {

	@Autowired
	FuncService funcservice;
	
	@RequestMapping("/list")
	public ModelAndView list(SysFuncBean bean){
		try{
			PageInfoDto<SysFunc> roles = funcservice.getList(bean);
			ModelAndView mv = new ModelAndView("views/func-list");
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
	public BaseView save(SysFunc bean){
		try {
			return funcservice.save(bean);
		} catch (Exception e) {
			return BaseViewHelper.getFailBaseView("2001",e.getMessage());
		}
	}
	
	@RequestMapping("/del")
	@ResponseBody
	public BaseView del(SysFunc bean){
		try {
			if(StringUtils.isEmptyOrWhitespaceOnly(bean.getId())){
				return BaseViewHelper.getFailBaseView("2002","请选择删除行");
			}
			return funcservice.del(bean);
		} catch (Exception e) {
			return BaseViewHelper.getFailBaseView("2001",e.getMessage());
		}
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public BaseView update(SysFunc bean){
		try{
			if(StringUtils.isEmptyOrWhitespaceOnly(bean.getId())){
				return BaseViewHelper.getFailBaseView("2002", "角色ID不能为空");
			}
			return funcservice.update(bean);
		}catch (Exception e) {
			return BaseViewHelper.getFailBaseView("2001",e.getMessage());
		}
	}
	
	@RequestMapping("/edit")
	public ModelAndView detail(String id){
		try{
			ModelAndView model = new ModelAndView("views/func-edit");
			if(StringUtils.isEmptyOrWhitespaceOnly(id)){
				model.addObject("model", BaseViewHelper.getFailBaseView("201", "参数不能为空"));
				return model;
			}
			SysFunc role = funcservice.findById(id);
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
