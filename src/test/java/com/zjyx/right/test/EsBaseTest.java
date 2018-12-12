package com.zjyx.right.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.zjyx.right.model.PageInfoDto;
import com.zjyx.right.model.controllerbean.SysRoleBean;
import com.zjyx.right.model.persistence.SysRole;
import com.zjyx.right.service.RoleService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = "classpath:spring-*.xml") 
public class EsBaseTest {
	 @Autowired
	 RoleService role;
	 
	 @Test
	 public void testSave(){
		 SysRoleBean bean = new SysRoleBean();
		 bean.setOnePageSize(10);
		 bean.setRoleName("21");
		 bean.setCurrentPage(0);
		 PageInfoDto<SysRole> result = role.getList(bean);
		 System.out.println(JSONObject.toJSONString(result));
	 }
}