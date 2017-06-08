package com.zjyx.right.service;

import com.zjyx.right.model.persistence.AdminUser;

public interface AdminUserService {
	
	public AdminUser getAdminUser(Integer id);
	
	public int updateAdminUser(AdminUser adminUser);

}
