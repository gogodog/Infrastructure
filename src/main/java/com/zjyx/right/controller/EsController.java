package com.zjyx.right.controller;


import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjyx.right.model.BaseObject;
import com.zjyx.right.service.IRightService;


@Controller
@RequestMapping("/es")
public class EsController {
	
	@Resource
	IRightService rightService;

	@ResponseBody
	@RequestMapping("/save")
	public <T extends BaseObject> String save(T t){
		t.setCtime(new Date());
		return rightService.save(t);
	}
	
}
