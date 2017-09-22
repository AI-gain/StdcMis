package com.stdcMis.Dao;

import java.util.List;
import java.util.Map;

import com.dbEntity.DemandCollect;
import com.dbEntity.DrawData;
import com.dbEntity.OperatingOrganization;
import com.dbEntity.SearchResult;

public interface DemcDao {

	/**
	 * @参数model指定要获取的数据实体名称(如com.x.y.Entityname)
	 * @参数key指定需要加载的实体类的主键值
	 * @return返回加载的数据实体
	 */
	Object get(String model,Object key);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	DemandCollect get(String id);
	
	/**
	 *@参数model指定要查询的数据实体的名称
	 *@return返回查询结果集
	 */
	List<Object> findAllObject(String model);
	
	/**
	 *@参数object指定要保存的实体对象
	 *@参数model指定要保存的数据实体的名称
	 */
	boolean save(Object object);
	
	/**
	 *@参数object指定要删除的实体对象
	 *@参数model指定要删除的数据实体的名称 
	 */
	boolean delete(Object object);
	
	/**
	 *@参数object指定要修改的实体对象
	 *@参数model指定要修改的数据实体的名称
	 */
	boolean update(Object object);
	/**
	 * 根据条件查找DemandCollect
	 * @参数model为所查询的数据模型即表 ，property[]为查询类型，value[]为所查类型的key值,rigor为精确查询或模糊查询的标识,为true时表示精确查询
	 * @return 返回对应的全部DemandCollect
	 */
	
	String setID();
	
	/**
	 * 根据sql语句查询返回结果集
	 * @param sql
	 * @return
	 */
	List<SearchResult> query(String sql);
	
	List<DrawData> querydata(String sql);
	
	List<DemandCollect> searchByPropertys(String model,String[]propertyName,Object[] value,boolean rigor);

	/**
	 * 
	 * @param condition 保存查询类型
	 * @param value 保存查询类型所对应的值
	 * @param rigor 是否进行模糊查询 默认为是
	 * @param symbol 保存查询条件（取=,>,<）;
	 * @return
	 */
	List<SearchResult> searchByConditions(String[] condition,Object[] value,Map<String,Boolean> rigor,String[] symbol);
	
	List<DemandCollect> searchUpdateList(String name);
	
	
}
