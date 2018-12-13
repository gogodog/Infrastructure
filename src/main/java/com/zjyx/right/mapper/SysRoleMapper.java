package com.zjyx.right.mapper;

import java.util.List;

import com.zjyx.right.model.controllerbean.SysRoleBean;
import com.zjyx.right.model.persistence.SysRole;

public interface SysRoleMapper {
    int insert(SysRole record) throws Exception;

    int insertSelective(SysRole record) throws Exception;

	int getListCount(SysRoleBean condition) throws Exception;

	List<SysRole> getListPage(SysRoleBean condition) throws Exception;

	int delete(SysRole bean) throws Exception;

	int update(SysRole bean) throws Exception;
}