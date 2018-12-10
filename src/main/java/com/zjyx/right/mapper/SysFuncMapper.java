package com.zjyx.right.mapper;

import com.zjyx.right.model.persistence.SysFunc;

public interface SysFuncMapper {
    int insert(SysFunc record);

    int insertSelective(SysFunc record);
}