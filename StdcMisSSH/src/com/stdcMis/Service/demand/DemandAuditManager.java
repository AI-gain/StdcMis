package com.stdcMis.Service.demand;

public interface DemandAuditManager {
	/**
	 * 保存审核结果
	 * @param status 需求表单状态
	 * @param form 网络审核结果
	 * @param idea 审核意见
	 * @param department 审核部门
	 * @param depart 部门审核结果
	 * @param id 需求表单号
	 * @return 操作结果
	 */
	public abstract String execute(String status,String form,String idea,String department,String depart,String id);
}
