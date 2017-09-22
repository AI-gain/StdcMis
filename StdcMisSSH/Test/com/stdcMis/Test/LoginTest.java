package com.stdcMis.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dbEntity.OperatingOrganization;
import com.dbEntity.Permission;
import com.stdcMis.Dao.PermissionDao;
import com.stdcMis.DaoImpl.OpogDaoImpl;
import com.stdcMis.DaoImpl.PermissionDaoImpl;
import com.stdcMis.Service.userImpl.LoginManagerImpl;
import com.stdcMis.Service.userImpl.RegisterManagerImpl;

public class LoginTest {
	
	private LoginManagerImpl lm;
	private OperatingOrganization opog = new OperatingOrganization();
	private OpogDaoImpl opogDao;
	private PermissionDaoImpl perDao;
	private HibernateTemplate hibernateTemplate;
	ApplicationContext ac = new FileSystemXmlApplicationContext("src/applicationContext.xml");

	@Before
	public void setUp() throws Exception {
		lm = new LoginManagerImpl();
		hibernateTemplate = (HibernateTemplate) ac.getBean("hibernateTemplate");
		opogDao = new OpogDaoImpl();
		opogDao.setHibernateTemplate(hibernateTemplate);
		perDao = new PermissionDaoImpl();
		perDao.setHibernateTemplate(hibernateTemplate);
		lm.setOpogDao(opogDao);
		lm.setPerDao(perDao);
		this.setOpog();
	}

	@Test
	public void testIsUser() {
		try {
			assertEquals(true,lm.isUser(opog));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetPermissionOperatingOrganization() {
		assertEquals(true,lm.getPermission(opog).getAddDemand());
	}

	@Test
	public void testExecute() {
		try {
			assertEquals("success",lm.execute(opog));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setOpog()
	{
		opog = opogDao.get("这是一个测试");
		System.out.println(opog.getOName());
	}

}
