package com.stdcMis.Service.demand;

import java.util.List;
import java.util.Map;

import com.dbEntity.DemandCollect;
import com.dbEntity.DrawData;
import com.dbEntity.SearchResult;

public interface ShowDemandManager {

	/**
	 * 根据组织机构名称获取所有需求表单列表
	 * @param name 组织机构名称
	 * @return 需求表单列表
	 */
	public abstract List<DemandCollect> listAllDemand(String name);
	
	/**
	 * 根据组织机构名称获取所有用户可修改需求表单列表
	 * @param name 组织机构名称
	 * @return 可修改需求表单列表
	 */
	public abstract List<DemandCollect> listUpdateList(String name);
	
	/**
	 * 获取所有已提交需求表单
	 * @return 返回所有已提交需求表单
	 */
	public abstract List<DemandCollect> listSubmitDemand();
	
	/**
	 * 获取所有经过技术审核的需求表单
	 * @return 返回所有已通过技术审核的需求表单
	 */
	public abstract List<DemandCollect> listFormedDemand();
	
	/**
	 * 初始化查询信息条件
	 * @param map 保存用户选择的所有查询条件
	 */
	public abstract void initParameter(Map<String,Object> map);
	
	/**
	 * 通过查询条件获取查询结果
	 * @return 返回查询结果
	 */
	public abstract List<SearchResult> listDemandByCondition();
	
	/**
	 * 通过sql语句插叙 返回结果
	 * @param sql
	 * @return
	 */
	public abstract List<SearchResult> query(String sql);
	
	public abstract List<DrawData> querydata(String sql);
	
	/**
	 * 通过需求表单号获取需求表单实体
	 * @param id 需求表单号
	 * @return 需求表单实体
	 */
	public abstract DemandCollect getDemandCollect(String id);
	
	/**
	 * 通过条件返回需求表单列表
	 * @param type 需求表单状态
	 * @param name 组织机构名称
	 * @return 返回需求表单列表
	 */
	public abstract List<DemandCollect> execute(String type,String name);
	
}
