package com.zjyx.right.mapper;

import java.util.List;

import com.zjyx.right.model.persistence.AdminUser;
import com.zjyx.right.model.persistence.condition.AdminUserCondition;
import com.zjyx.right.model.persistence.result.AdminUserResult;

public interface AdminUserMapper {

	public int batchSave(List<AdminUser> list);
	
	public int save(AdminUser adminUser);
	
	public AdminUser selectById(Integer id);
	
	public int update(AdminUser adminUser);
	
	public List<AdminUserResult> list(AdminUserCondition condition);
	
	public int count(AdminUserCondition condition);
	
	public List<Integer> getListIds(AdminUserCondition condition);
	
	public AdminUser getByUserCode(String userCode);
	
	public AdminUser getByUnionId(String unionId);
}
