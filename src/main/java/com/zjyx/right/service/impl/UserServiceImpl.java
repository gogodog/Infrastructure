package com.zjyx.right.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.StringUtils;
import com.zjyx.right.helper.BaseViewHelper;
import com.zjyx.right.mapper.SysUserMapper;
import com.zjyx.right.model.PageInfoDto;
import com.zjyx.right.model.controllerbean.SysUserBean;
import com.zjyx.right.model.controllerview.BaseView;
import com.zjyx.right.model.persistence.SysUser;
import com.zjyx.right.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	SysUserMapper usermapper;

	@Override
	public PageInfoDto<SysUser> getList(SysUserBean condition) throws Exception{
		int count = usermapper.getListCount(condition);
		condition.setTotalResults(count);
		List<SysUser> list = usermapper.getListPage(condition);
		return PageInfoDto.getPageInfo(condition.getCurrentPage(), condition.getOnePageSize(), count, list);
		
	}

	@Override
	public BaseView save(SysUser bean) throws Exception {
		if(StringUtils.isEmptyOrWhitespaceOnly(bean.getUserId())){
			return BaseViewHelper.getFailBaseView("201", "用户ID不能为空");
		}
		int count = usermapper.insert(bean);
		if(count == 1){
			return BaseViewHelper.getSuccessBaseView();
		}
		return BaseViewHelper.getFailBaseView("202", "添加失败："+count);
	}

	@Override
	public SysUser findByUserId(String userId) throws Exception {
		SysUserBean condition = new SysUserBean();
		condition.setOnePageSize(2);
		condition.setUserId(userId);
		condition.setCurrentPage(0);
		List<SysUser> list = usermapper.getListPage(condition);
		if(list == null || list.size() != 1){
			return null;
		}
		return list.get(0);
	}

	@Override
	public BaseView del(SysUser bean) throws Exception {
		int count = usermapper.delete(bean);
		if(count == 1){
			return BaseViewHelper.getSuccessBaseView();
		}
		return BaseViewHelper.getFailBaseView("202", "删除失败："+count);
	}

	@Override
	public BaseView update(SysUser bean) throws Exception {
		int count = usermapper.update(bean);
		if(count == 1){
			return BaseViewHelper.getSuccessBaseView();
		}
		return BaseViewHelper.getFailBaseView("202", "警告：更新了"+count+"条数据");
	}
}
