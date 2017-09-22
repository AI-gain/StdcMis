package com.stdcMis.Service.demand;

import com.dbEntity.DemandCollect;
import com.dbEntity.OperatingOrganization;

public interface AddAndSaveDemandManager {

	/**
	 * 初始化一个DemandCollect实体
	 * @param deco 实体类型
	 * @param add 表示为添加实体类
	 * @param save 表示为保存实体类
	 */
	public abstract void initStatus(DemandCollect deco,Object add,Object save);
	/**
	 * 整合用户输入的同类型多种内容的信息
	 * @param str 保存要整合的数组信息
	 * @return 返回整合后的信息
	 */
	public abstract String collectMessage(String[] str);
	/**
	 * 初始化需求表单号
	 * @return需求表单号
	 */
	public abstract String setID();
	/**
	 * 根据主键值获取组织机构信息
	 * @param name 保存主键值
	 * @return 返回组织机构实体
	 */
	public abstract OperatingOrganization getOpogByName(String name);
	/**
	 * 进行业务操作，保存需求表单信息
	 * @param deco 需求表单信息
	 * @return 返回操作结果
	 */
	public abstract String execute(DemandCollect deco);
}
