package com.zjyx.right.mapper;

import java.util.List;

import com.zjyx.right.model.controllerbean.SysFuncBean;
import com.zjyx.right.model.persistence.SysFunc;

public interface SysFuncMapper {
    int insert(SysFunc record);

    int insertSelective(SysFunc record);
    
    int getListCount(SysFuncBean condition) throws Exception;

	List<SysFunc> getListPage(SysFuncBean condition) throws Exception;

	int delete(SysFunc bean) throws Exception;

	int update(SysFunc bean) throws Exception;
}