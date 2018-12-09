package com.zjyx.right.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zjyx.right.plugin.es.BaseEsMapping;
import com.zjyx.right.test.model.Person;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = "classpath:spring-*.xml") 
public class EsBaseTest {
	
	 final String index = "helloworld_index";
	 final String type = "helloworld_type";
		
	 @Autowired
	 BaseEsMapping baseEsMapping;
	 
	 @Test
	 public void testSave(){
		 Person p = new Person();
		 p.setAge(29);
		 p.setName("joyance");
		 p.setWork("software engineer");
		 Date time = new Date();
//		 p.setCtime(time);
		 String id = baseEsMapping.save(index, type, p);
		 System.out.println(id);
	 }
}
