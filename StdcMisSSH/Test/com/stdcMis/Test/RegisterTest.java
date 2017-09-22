package com.stdcMis.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dbEntity.OperatingOrganization;
import com.stdcMis.Dao.OpogDao;
import com.stdcMis.DaoImpl.OpogDaoImpl;
import com.stdcMis.DaoImpl.SuperDao;
import com.stdcMis.Service.userImpl.RegisterManagerImpl;

public class RegisterTest {

	private RegisterManagerImpl rm;
	private OperatingOrganization opog;
	private OpogDaoImpl opogDao;
	private HibernateTemplate hibernateTemplate;
	ApplicationContext ac = new FileSystemXmlApplicationContext("src/applicationContext.xml");
	
	@Before
	public void setUp() throws Exception {
		rm = new RegisterManagerImpl();
		hibernateTemplate = (HibernateTemplate) ac.getBean("hibernateTemplate");
		opogDao = new OpogDaoImpl();
		opogDao.setHibernateTemplate(hibernateTemplate);
		rm.setOpogDao(opogDao);
	}

	@Test
	public void testIsUserExists() {
		assertEquals(true,rm.isUserExists("石家庄铁道大学"));
	}
	
	@Test
	public void testRegister()
	{
		this.setOpog();
		System.out.println(opog.getOArea());
		assertEquals(true,rm.register(opog));
	}
	
	public void setOpog()
	{
		opog = new OperatingOrganization();
		opog.setOName("这是一个测试");
		opog.setPwd("cs123456");
		opog.setOAddress("石家庄市北二环东路17号");
		opog.setOArea("石家庄市-桥东区");
		opog.setOLperson("测试张");
		opog.setOCode("1141414");
		opog.setOUrl("http://www.ceshi.com");
		opog.setOEmail("ceshi.@163.com");
		opog.setOPostcode("123000");
		opog.setOContacts("测试李");
		opog.setOPlPhone("12345678");
		opog.setOMbPhone("12345678910");
		opog.setOFax("12345678");
		opog.setOAttribute("高等院校");
		opog.setOTmd("软件工程系");
		opog.setOOverView("xsaaascacaca");
		opog.setRole("普通用户");
		opog.setDemandCollects(null);
	}

}
