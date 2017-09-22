package com.stdcMis.Service.demand;

import com.dbEntity.DemandCollect;

public interface UpdateDemandManager {

	/**
	 * 通过需求表单号获取需求表单实体
	 * @param id 需求表单号
	 * @return 返回需求表单实体
	 */
	public abstract DemandCollect getDemandCollect(String id);
	
	/**
	 * 整合用户输入的同类型多种内容的信息
	 * @param str保存要整合的数组信息
	 * @return 返回整合后的信息
	 */
	public abstract String collectMessage(String[] str);
	
	/**
	 * 初始化表单状态
	 * @param demc 需求表单实体
	 * @param add 修改状态信息
	 */
	public abstract void initStatus(DemandCollect demc,String add);
	
	/**
	 * 更改需求表单信息
	 * @param demc 需求表单实体类
	 * @return 返回保存结果
	 */
	public abstract boolean update(DemandCollect demc);
	
	/**
	 * 执行业务逻辑
	 * @param demc 需求表单实体类
	 * @return 返回执行结果
	 */
	public abstract String execute(DemandCollect demc);
}
