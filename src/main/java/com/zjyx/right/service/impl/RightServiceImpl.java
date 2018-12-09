package com.zjyx.right.service.impl;

import org.springframework.stereotype.Service;

import com.zjyx.right.service.IRightService;

@Service
public class RightServiceImpl extends EsServiceImpl implements IRightService {
	
	String index="right_index";
	String type="right";

	@Override
	public <T> String save(T t) {
		return super.save(t, index, type);
	}

}
