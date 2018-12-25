package com.zjyx.right.mapper;

import java.util.List;

import com.zjyx.right.model.persistence.SysRole;
import com.zjyx.right.model.persistence.SysUserRole;

public interface SysUserRoleMapper {
	
    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);
    
    List<SysRole> getByRoleId(String userId);
}