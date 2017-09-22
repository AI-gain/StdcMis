package com.stdcMis.Service.systemImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONSerializer;

import org.springframework.stereotype.Component;
import com.dbEntity.Permission;
import com.stdcMis.Dao.DemcDao;
import com.stdcMis.Dao.PermissionDao;
import com.stdcMis.Service.system.AuthorityManager;
import com.stdcMis.Util.Page;
import com.stdcMis.Util.PageUtil;

@Component("authorityManager")
public class AuthorityManagerImpl implements AuthorityManager {

	private DemcDao dbDao;
	private PermissionDao perDao;
	
	/*
	 * (non-Javadoc)
	 * @see com.stdcMis.Service.system.AuthorityManager#listAllRole()
	 */
	@Override
	public List listAllRole() {
		// TODO Auto-generated method stub
		Page page = new Page();
		PageUtil pageUtil = new PageUtil();
		page = pageUtil.createPage(3,perDao.countNum(),1);
		return perDao.searchByPage(page);
		//return dbDao.findAllObject("Permission");
	}

	/*
	 * (non-Javadoc)
	 * @see com.stdcMis.Service.system.AuthorityManager#checkRoleExsits(java.lang.String)
	 */
	@Override
	public boolean checkRoleExsits(String role) {
		// TODO Auto-generated method stub
		if(dbDao.get("com.dbEntity.Permission",role)==null)
		{
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see com.stdcMis.Service.system.AuthorityManager#addRole(com.dbEntity.Permission)
	 */
	@Override
	public boolean addRole(Permission permission) {
		// TODO Auto-generated method stub
		return dbDao.save(permission);
	}

	/*
	 * (non-Javadoc)
	 * @see com.stdcMis.Service.system.AuthorityManager#execute(java.lang.String, com.dbEntity.Permission)
	 */
	@Override
	public String execute(Permission permission) {
		// TODO Auto-generated method stub
		if(!this.checkRoleExsits(permission.getRole()))
		{
			if(this.addRole(permission))
			{
				return "success";
			}
			return "error";
		}
		return "error";
	}

	@Override
	public boolean deleteRoles(String[] roles) {
		// TODO Auto-generated method stub
		boolean isdelete = false;
		for(int i=0;i<roles.length;i++)
		{
			isdelete=false;
			if(roles[i]==null || roles[i].equals(""))
			{
				continue;
			}
			if(dbDao.delete(dbDao.get("com.dbEntity.Permission", roles[i])))
			{
				isdelete=true;
			}
		}
		return isdelete;
	}
	
	
	@Override
	public String execute(String[] roles) {
		// TODO Auto-generated method stub
		if(this.deleteRoles(roles))
		{
			return "success";
		}
		return "error";
	}
	
	@Override
	public Permission getRole(String role) {
		// TODO Auto-generated method stub
		return (Permission) dbDao.get("com.dbEntity.Permission", role);
	}

	
	public DemcDao getDbDao() {
		return dbDao;
	}

	@Resource
	public void setDbDao(DemcDao dbDao) {
		this.dbDao = dbDao;
	}

	public PermissionDao getPerDao() {
		return perDao;
	}

	@Resource
	public void setPerDao(PermissionDao perDao) {
		this.perDao = perDao;
	}

}
