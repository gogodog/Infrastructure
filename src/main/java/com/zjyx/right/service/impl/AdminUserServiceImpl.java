package com.zjyx.right.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjyx.right.mapper.AdminUserMapper;
import com.zjyx.right.model.persistence.AdminUser;
import com.zjyx.right.service.AdminUserService;

@Service
public class AdminUserServiceImpl implements AdminUserService{
	
	@Autowired
	AdminUserMapper adminUserMapper;
	
	public AdminUser getAdminUser(Integer id){
		return adminUserMapper.selectById(id);
	}

	@Override	
	public int updateAdminUser(AdminUser adminUser){
		return adminUserMapper.update(adminUser);
	}
}
