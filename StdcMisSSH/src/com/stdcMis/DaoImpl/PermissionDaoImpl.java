package com.stdcMis.DaoImpl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import com.dbEntity.Permission;
import com.stdcMis.Dao.PermissionDao;
import com.stdcMis.Util.Page;
import com.stdcMis.Util.PagingUtil;

@Component("perDao")
public class PermissionDaoImpl extends SuperDao implements PermissionDao {

	//测试使用
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	//定义日志实例
	private static final Logger log = LoggerFactory
			.getLogger(OpogDaoImpl.class);
		
	
	@Override
	public Permission get(String role) {
		// TODO Auto-generated method stub
		return (Permission) getHibernateTemplate().get(Permission.class,role);
	}

	@Override
	public boolean save(Permission permission) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<Permission> searchByPropertys(String model,
			String[] propertyName, Object[] value, boolean rigor) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int countNum()
	{
		return countAllNum("Permission");
	}
	
	@Override
	public List<Permission> searchByPage(final Page page) {
		// TODO Auto-generated method stu
		final String hql = "from Permission";
		List<Permission> list1 = getHibernateTemplate().executeFind(new HibernateCallback(){
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				List<Permission> list2 = (List<Permission>) PagingUtil.getList(session, hql,page.getBeginIndex(),page.getEveryPage());
				return list2;
			}
			
		});
		return list1;
	}


}
