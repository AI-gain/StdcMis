package com.stdcMis.Service.user;

import com.dbEntity.OperatingOrganization;

public interface UserManager {

	/**
	 * 通过组织机构名称获取组织机构
	 * @param name 组织结构名称
	 * @return 组织机构实体类
	 */
	public abstract OperatingOrganization getOpogByName(String name);
}
