package com.zjyx.right.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.zjyx.right.mapper.AdminUserMapper;
import com.zjyx.right.model.persistence.AdminUser;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = "classpath:spring-*.xml") 
public class EsBaseTest {
		
	 @Autowired
	 AdminUserMapper admin;
	 
	 @Test
	 public void testSave(){
		 AdminUser user = admin.selectById(1);
		 System.out.println(JSONObject.toJSONString(user));
	 }
}