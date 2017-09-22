package com.stdcMis.Test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dbEntity.DemandCollect;
import com.stdcMis.DaoImpl.DemcDaoImpl;

public class SearchDemandTest {

	private DemcDaoImpl dd;
	private HibernateTemplate hibernateTemplate;
	private DemandCollect deco;
	private String[] condition = new String[18];
	private String[] value = new String[18];
	private Map<String,Boolean> rigor = new HashMap();
	private String[] symbol = new String[18];
	private ApplicationContext ac = new FileSystemXmlApplicationContext("src/applicationContext.xml");
	
	@Before
	public void setUp() throws Exception {
		dd = new DemcDaoImpl();
		hibernateTemplate = (HibernateTemplate) ac.getBean("hibernateTemplate");
		dd.setHibernateTemplate(hibernateTemplate);
	}

	@Test
	public void testSearchByConditions() {
		String dname="测试需求表";
		assertEquals(dname,dd.searchByConditions(condition, value, rigor, symbol).get(0).getDname());
	}

	@Test
	public void testQuery() {
		String sql = "select new com.dbEntity.SearchResult(t.demandId,u.OName,t.DName,t.startTime,t.endTime,t.DStatus) from OperatingOrganization u ,DemandCollect t where (t.startTime between '0000' and '9999' and t.endTime between '0000' and '9999' and u.OName = '这是一个测试') and u.OName=t.operatingOrganization";
		String dname="测试需求表";
		assertEquals(dname,dd.query(sql).get(0).getDname());
	}
	
	public void setConditions()
	{
		condition[0] = "o.OName";
		value[0] ="这是一个测试";
		rigor.put("o.OName", true);
		symbol[0] = "=";
	}

}
