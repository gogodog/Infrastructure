package com.zjyx.right.mapper;

import com.zjyx.right.model.persistence.SysUserRole;

public interface SysUserRoleMapper {
    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);
}