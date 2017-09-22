package com.stdcMis.Service.user;

import com.dbEntity.OperatingOrganization;
import com.dbEntity.Permission;

public interface LoginManager {
	
	/*
	 * 判断用户名密码是否正确
	 */
	public abstract boolean isUser(OperatingOrganization opog) throws Exception;
	
	/*
	 * 获取用户权限
	 */
	public abstract Permission getPermission(OperatingOrganization opog) throws Exception;
	
	/*
	 * 添加新用户
	 */
	public abstract String execute(OperatingOrganization opog) throws Exception;
}
