package com.zjyx.right.service;

import com.zjyx.right.model.PageInfoDto;
import com.zjyx.right.model.controllerbean.SysRoleBean;
import com.zjyx.right.model.controllerview.BaseView;
import com.zjyx.right.model.persistence.SysRole;

public interface RoleService{

	PageInfoDto<SysRole> getList(SysRoleBean condition) throws Exception;

	BaseView save(SysRole bean) throws Exception;

	SysRole findByRoleId(String roleId) throws Exception;

	BaseView del(SysRole bean) throws Exception;

	BaseView update(SysRole bean) throws Exception;

}
