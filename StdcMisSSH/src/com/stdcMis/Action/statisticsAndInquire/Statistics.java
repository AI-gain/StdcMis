package com.stdcMis.Action.statisticsAndInquire;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;

import com.dbEntity.DrawData;
import com.opensymphony.xwork2.ActionSupport;
import com.stdcMis.Service.demand.ShowDemandManager;

public class Statistics extends ActionSupport implements RequestAware {

	private Map<String,Object> map = new HashMap();
	
	private String StatisticsType;
	private ShowDemandManager show;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		List<DrawData> list = show.querydata(this.getSql());
		map.put("data", list);
		this.setMap(map);
		return "success";
	}

	public String getSql()
	{
		String sql="select o."+this.getStatisticsType()+",count(*) from OperatingOrganization as o group by o."+this.getStatisticsType();
		return sql;
	}
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		map = arg0;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public String getStatisticsType() {
		return StatisticsType;
	}

	public void setStatisticsType(String statisticsType) {
		StatisticsType = statisticsType;
	}

	public ShowDemandManager getShow() {
		return show;
	}

	@Resource
	public void setShow(ShowDemandManager show) {
		this.show = show;
	}
}
