package com.stdcMis.Test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dbEntity.DemandCollect;
import com.stdcMis.DaoImpl.DemcDaoImpl;
import com.stdcMis.DaoImpl.OpogDaoImpl;

public class DemandAddandSave {

	private DemcDaoImpl dd;
	private OpogDaoImpl od;
	private DemandCollect deco;
	private HibernateTemplate hibernateTemplate;
	private ApplicationContext ac = new FileSystemXmlApplicationContext("src/applicationContext.xml");
	
	@Before
	public void setUp() throws Exception {
		dd = new DemcDaoImpl();
		od = new OpogDaoImpl();
		hibernateTemplate = (HibernateTemplate) ac.getBean("hibernateTemplate");
		dd.setHibernateTemplate(hibernateTemplate);
		od.setHibernateTemplate(hibernateTemplate);
		deco = new DemandCollect();
		this.setDemc();
	}

	@Test
	public void testGet()
	{
		//由之前对注册模块的测试数据获取
		String oLperson = "测试李";
		
		assertEquals(oLperson,od.get("这是一个测试").getOLperson());
	}
	@Test
	public void testSetID() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
		String Time = df.format(new Date());
		String id = Time + "0001";
		assertEquals(id,dd.setID());
	}
	
	@Test
	public void testSave() {
		assertEquals(true,dd.save(deco));
	}
	
	public void setDemc()
	{
		deco.setDemandId(dd.setID());
		deco.setLock(0);					  			     //需求表加锁状态为未加锁
		deco.setOperatingOrganization(od.get("这是个测试"));//设置关联关系
		deco.setFormIdea("");
		deco.setDepartIdea("");
		deco.setManageDepart("");
		deco.setDName("测试需求表");		  			    //保存需求表单名称
		deco.setStartTime("2017");			    //保存需求开始日期
		deco.setEndTime("2020");					//保存需求表结束时间
		deco.setTheme("测试");					    //保存需求表主要问题
		deco.setTechKey("测试");				    //保存需求表技术关键
		deco.setExpectTarget("测试");			    //保存需求表预期目标
		deco.setDKey("测试");				//保存需求表关键字
		deco.setPlanInvestment("13");	    //保存需求表拟投入资金
		deco.setDSolution("独立开发");				    //保存技术需求合作模式
		deco.setCooIntention("测试2");		    //保存合作意向单位
		deco.setTechType("");				    //保存科技活动类型
		deco.setSubjects("");		//保存学科分类码
		deco.setDServics("");			    //保存技术需求所属领域
		deco.setDAppIndustry("");	//保存技术需求应用行业
	}

}
