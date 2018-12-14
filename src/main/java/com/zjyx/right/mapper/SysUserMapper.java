package com.zjyx.right.mapper;

import java.util.List;

import com.zjyx.right.model.controllerbean.SysUserBean;
import com.zjyx.right.model.persistence.SysUser;

public interface SysUserMapper {
    int insert(SysUser record);

    int insertSelective(SysUser record);
    
    int getListCount(SysUserBean condition) throws Exception;

	List<SysUser> getListPage(SysUserBean condition) throws Exception;

	int delete(SysUser bean) throws Exception;

	int update(SysUser bean) throws Exception;
}