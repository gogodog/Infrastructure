package com.zjyx.right.service;

import com.zjyx.right.model.PageInfoDto;
import com.zjyx.right.model.controllerbean.SysFuncBean;
import com.zjyx.right.model.controllerview.BaseView;
import com.zjyx.right.model.persistence.SysFunc;

public interface FuncService{

	PageInfoDto<SysFunc> getList(SysFuncBean condition) throws Exception;

	BaseView save(SysFunc bean) throws Exception;

	SysFunc findById(String id) throws Exception;

	BaseView del(SysFunc bean) throws Exception;

	BaseView update(SysFunc bean) throws Exception;

}
