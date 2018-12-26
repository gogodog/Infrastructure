package com.zjyx.right.service;

import com.zjyx.right.model.PageInfoDto;
import com.zjyx.right.model.controllerbean.SysUserBean;
import com.zjyx.right.model.controllerview.BaseView;
import com.zjyx.right.model.persistence.SysUser;

public interface UserService{

	PageInfoDto<SysUser> getList(SysUserBean condition) throws Exception;

	BaseView save(SysUser bean) throws Exception;

	SysUser findByUserId(String userId) throws Exception;

	BaseView del(SysUser bean) throws Exception;

	BaseView update(SysUser bean) throws Exception;

}
