package com.zjyx.right.mapper;

import java.util.List;

import com.zjyx.right.model.controllerbean.SysRoleBean;
import com.zjyx.right.model.persistence.SysRole;

public interface SysRoleMapper {
    int insert(SysRole record);

    int insertSelective(SysRole record);

	int getListCount(SysRoleBean condition);

	List<SysRole> getListPage(SysRoleBean condition);
}