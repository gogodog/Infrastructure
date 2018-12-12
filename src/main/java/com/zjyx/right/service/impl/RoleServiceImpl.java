package com.zjyx.right.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.StringUtils;
import com.zjyx.right.helper.BaseViewHelper;
import com.zjyx.right.mapper.SysRoleMapper;
import com.zjyx.right.model.PageInfoDto;
import com.zjyx.right.model.controllerbean.SysRoleBean;
import com.zjyx.right.model.controllerview.BaseView;
import com.zjyx.right.model.persistence.SysRole;
import com.zjyx.right.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	SysRoleMapper rolemapper;

	@Override
	public PageInfoDto<SysRole> getList(SysRoleBean condition) {
		int count = rolemapper.getListCount(condition);
		condition.setTotalResults(count);
		List<SysRole> list = rolemapper.getListPage(condition);
		return PageInfoDto.getPageInfo(condition.getCurrentPage(), condition.getOnePageSize(), count, list);
	}

	@Override
	public BaseView save(SysRole bean) {
		if(StringUtils.isEmptyOrWhitespaceOnly(bean.getRoleName())){
			return BaseViewHelper.getBaseView(false, "201", "角色名称不能为空");
		}
		int count = rolemapper.insert(bean);
		if(count == 1){
			return BaseViewHelper.getSuccessBaseView();
		}
		return BaseViewHelper.getBaseView(false, "202", "添加失败："+count);
	}

	@Override
	public SysRole findByRoleId(String roleId) {
		SysRoleBean condition = new SysRoleBean();
		condition.setOnePageSize(2);
		condition.setRoleId(roleId);
		condition.setCurrentPage(0);
		List<SysRole> list = rolemapper.getListPage(condition);
		if(list == null || list.size() != 1){
			return null;
		}
		return list.get(0);
	}
}
