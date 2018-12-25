package com.zjyx.right.mapper;

import java.util.List;

import com.zjyx.right.model.persistence.SysFuncRole;

public interface SysFuncRoleMapper {
	
    int insert(SysFuncRole record);

    int insertSelective(SysFuncRole record);
    
    List<String> selectFuncCode(List<String> list);
}