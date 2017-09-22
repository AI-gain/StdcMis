package com.stdcMis.Service.system;

import java.util.List;

import com.dbEntity.Permission;

public interface AuthorityManager {

	/**
	 * 获取所有角色信息
	 * @return 返回角色信息
	 */
	public abstract List listAllRole();
	
	/**
	 * 通过角色名获取角色信息
	 * @param role 角色名
	 * @return 返回角色信息
	 */
	public abstract Permission getRole(String role);
	
	/**
	 * 检查角色是否已经存在
	 * @param role 角色名称
	 * @return 返回检查结果（true=存在，false=不存在）
	 */
	public abstract boolean checkRoleExsits(String role);
	
	/**
	 * 通过角色名删除角色
	 * @param roles 保存要删除的角色名称
	 * @return 返回操作结果
	 */
	public abstract boolean deleteRoles(String[] roles);
	
	/**
	 * 添加新角色
	 * @param permission 权限实体类
	 * @return 返回操作结果
	 */
	public abstract boolean addRole(Permission permission);
	
	/**
	 * 执行添加角色的业务逻辑
	 * @param permission 权限实体类
	 * @return 返回执行结果
	 */
	public abstract String execute(Permission permission);
	
	/**
	 * 执行删除角色的业务逻辑
	 * @param roles 角色名称
	 * @return 返回执行结果
	 */
	public abstract String execute(String[] roles);
	
}
