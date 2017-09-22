package com.stdcMis.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dbEntity.DemandCollect;
import com.stdcMis.DaoImpl.DemcDaoImpl;
import com.stdcMis.DaoImpl.OpogDaoImpl;

public class DemandManageTest {

	private DemcDaoImpl dd;
	private HibernateTemplate hibernateTemplate;
	private DemandCollect deco;
	private ApplicationContext ac = new FileSystemXmlApplicationContext("src/applicationContext.xml");
	
	@Before
	public void setUp() throws Exception {
		dd = new DemcDaoImpl();
		deco = new DemandCollect();
		hibernateTemplate = (HibernateTemplate) ac.getBean("hibernateTemplate");
		dd.setHibernateTemplate(hibernateTemplate);
	}

	@Test
	public void testSearchUpdateList() {
		String demandName = "测试需求表";
		assertEquals(demandName,dd.searchUpdateList("这是一个测试").get(0).getDName());
	}

	@Test
	public void testUpdate() {
		deco = dd.get("201706110001");
		deco.setDName("测试需求表2");
		assertEquals(true,dd.update(deco));
	}
	
	@Test
	public void testDelete() {
		deco = dd.get("201706110001");
		assertEquals(true,dd.delete(deco));
	}
}
