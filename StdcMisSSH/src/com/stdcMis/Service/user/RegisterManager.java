package com.stdcMis.Service.user;

import com.dbEntity.OperatingOrganization;

public interface RegisterManager {
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	public boolean isUserExists(String username);

	/**
	 * 新用户注册
	 * @param opog 组织机构实体类
	 * @return 操作结果
	 */
	public boolean register(OperatingOrganization opog);
	/**
	 * 执行业务逻辑
	 * @param opog 组织机构实体类
	 * @return 返回执行结果
	 */
	public String execute(OperatingOrganization opog);
}
