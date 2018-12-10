package com.zjyx.right.service;

import com.zjyx.right.model.PageInfoDto;
import com.zjyx.right.model.controllerbean.SysRoleBean;
import com.zjyx.right.model.controllerview.BaseView;
import com.zjyx.right.model.persistence.SysRole;

public interface RoleService{

	PageInfoDto<SysRole> getList(SysRoleBean condition);

	BaseView save(SysRole bean);

	SysRole findByRoleId(String roleId);

}
