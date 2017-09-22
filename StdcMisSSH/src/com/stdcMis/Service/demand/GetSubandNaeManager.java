package com.stdcMis.Service.demand;

import java.util.List;

public interface GetSubandNaeManager {
	
	/**
	 * 获取一级学科
	 * @return返回一级学科
	 */
	public abstract List getFirstSubject();
	
	/**
	 * 获取一级国民经济行业
	 * @return返回一级国民经济行业
	 */
	public abstract List getFirstIndustry();
	
	/**
	 * 执行业务操作
	 * @return 返回操作结果
	 */
	public abstract String execute();
}
