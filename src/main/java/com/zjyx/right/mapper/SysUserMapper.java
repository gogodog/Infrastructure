package com.zjyx.right.mapper;

import com.zjyx.right.model.persistence.SysUser;

public interface SysUserMapper {
	
    int insert(SysUser record);

    int insertSelective(SysUser record);
    
    SysUser selectByUserName(String userName);
}