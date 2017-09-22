package com.stdcMis.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dbEntity.DemandCollect;
import com.dbEntity.Permission;
import com.stdcMis.DaoImpl.DemcDaoImpl;
import com.stdcMis.DaoImpl.PermissionDaoImpl;

public class PermissionManageTest {

	private PermissionDaoImpl pd;
	private HibernateTemplate hibernateTemplate;
	private Permission per;
	private ApplicationContext ac = new FileSystemXmlApplicationContext("src/applicationContext.xml");
	
	@Before
	public void setUp() throws Exception {
		pd = new PermissionDaoImpl();
		hibernateTemplate = (HibernateTemplate) ac.getBean("hibernateTemplate");
		pd.setHibernateTemplate(hibernateTemplate);
		per = new Permission();
		this.setPermission();
	}

	@Test
	public void testGet() {
		assertEquals(false,pd.get("普通用户").getFormManage());
	}

	@Test
	public void testSave() {
		assertEquals(true,pd.save(per));
	}

	public void setPermission()
	{
		per.setAddDemand(true);
		per.setDemandManage(true);
		per.setDepartManage(true);
		per.setFormManage(true);
		per.setManage(false);
		per.setPmManage(true);
		per.setSqMangae(true);
		per.setRole("副管理");
	}
}
