package com.stdcMis.Util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class PagingUtil {

	/**
	 * 使用hql语句操作
	 * @param session   一个会话
	 * @param hql       需要执行的hql语句
	 * @param offset    设置开始的位置
	 * @param length    读取记录条数
	 * @return
	 */
	public static List<?> getList( Session session , String hql , int offset, int length){
	       Query q = session.createQuery(hql);
	       q.setFirstResult(offset);
	       q.setMaxResults(length);
	       //Log.info(hql);
	       List<?> list = q.list();
	       //Log.info("取到的每页的size"+list.size());
	       return list;
	    }
}
