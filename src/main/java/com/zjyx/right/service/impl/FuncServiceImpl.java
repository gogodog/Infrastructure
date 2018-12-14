package com.zjyx.right.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.StringUtils;
import com.zjyx.right.helper.BaseViewHelper;
import com.zjyx.right.mapper.SysFuncMapper;
import com.zjyx.right.model.PageInfoDto;
import com.zjyx.right.model.controllerbean.SysFuncBean;
import com.zjyx.right.model.controllerview.BaseView;
import com.zjyx.right.model.persistence.SysFunc;
import com.zjyx.right.service.FuncService;

@Service
public class FuncServiceImpl implements FuncService{
	
	@Autowired
	SysFuncMapper funcmapper;

	@Override
	public PageInfoDto<SysFunc> getList(SysFuncBean condition) throws Exception{
		int count = funcmapper.getListCount(condition);
		condition.setTotalResults(count);
		List<SysFunc> list = funcmapper.getListPage(condition);
		return PageInfoDto.getPageInfo(condition.getCurrentPage(), condition.getOnePageSize(), count, list);
		
	}

	@Override
	public BaseView save(SysFunc bean) throws Exception {
		if(StringUtils.isEmptyOrWhitespaceOnly(bean.getName())){
			return BaseViewHelper.getFailBaseView("201", "角色名称不能为空");
		}
		int count = funcmapper.insert(bean);
		if(count == 1){
			return BaseViewHelper.getSuccessBaseView();
		}
		return BaseViewHelper.getFailBaseView("202", "添加失败："+count);
	}

	@Override
	public SysFunc findById(String id) throws Exception {
		SysFuncBean condition = new SysFuncBean();
		condition.setOnePageSize(2);
		condition.setId(id);
		condition.setCurrentPage(0);
		List<SysFunc> list = funcmapper.getListPage(condition);
		if(list == null || list.size() != 1){
			return null;
		}
		return list.get(0);
	}

	@Override
	public BaseView del(SysFunc bean) throws Exception {
		int count = funcmapper.delete(bean);
		if(count == 1){
			return BaseViewHelper.getSuccessBaseView();
		}
		return BaseViewHelper.getFailBaseView("202", "删除失败："+count);
	}

	@Override
	public BaseView update(SysFunc bean) throws Exception {
		int count = funcmapper.update(bean);
		if(count == 1){
			return BaseViewHelper.getSuccessBaseView();
		}
		return BaseViewHelper.getFailBaseView("202", "警告：更新了"+count+"条数据");
	}
}
