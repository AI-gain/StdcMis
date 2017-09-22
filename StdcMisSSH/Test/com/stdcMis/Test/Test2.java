package com.stdcMis.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.stdcMis.DaoImpl.OpogDaoImpl;

public class Test2 {

	private OpogDaoImpl od;
	private HibernateTemplate hibernateTemplate;
	private ApplicationContext ac = new FileSystemXmlApplicationContext("src/applicationContext.xml");
	
	@Before
	public void setUp() throws Exception {
		hibernateTemplate = (HibernateTemplate) ac.getBean("hibernateTemplate");
		od = new OpogDaoImpl();
		od.setHibernateTemplate(hibernateTemplate);
	}

	@Test
	public void testGet() {
		String role = "部门审核员";
		assertEquals(role,od.get("办公室2").getRole());
	}

}
