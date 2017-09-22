package com.stdcMis.Service.userImpl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;
import com.dbEntity.OperatingOrganization;
import com.dbEntity.Permission;
import com.stdcMis.Dao.OpogDao;
import com.stdcMis.Dao.PermissionDao;
import com.stdcMis.Service.user.LoginManager;

@Component("loginManager")
public class LoginManagerImpl implements LoginManager{

	private OpogDao opogDao;
	private PermissionDao perDao;
	private HttpServletRequest request;
	
	
	@Override
	/*
	 * (non-Javadoc)
	 * @see com.stdcMis.Service.user.LoginManager#isUser(com.dbEntity.OperatingOrganization)
	 */
	public boolean isUser(OperatingOrganization opog) throws Exception {
		// TODO Auto-generated method stub
		return opogDao.checkUserAndPwd(opog);
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see com.stdcMis.Service.user.LoginManager#getPermission()
	 */
	public Permission getPermission(OperatingOrganization opog) {
		// TODO Auto-generated method stub
		Permission permission = new Permission();
		permission = perDao.get(opogDao.getRole(opog.getOName()));
		//以下代码测试时需要注解
		request = ServletActionContext.getRequest();
		request.getSession().setAttribute("user",opog.getOName());
		request.getSession().setAttribute("manage", permission.getManage());
		request.getSession().setAttribute("addDemand", permission.getAddDemand());
		request.getSession().setAttribute("demandManage",permission.getDemandManage());
		request.getSession().setAttribute("formManage",permission.getFormManage());
		request.getSession().setAttribute("departManage",permission.getDepartManage());
		request.getSession().setAttribute("SqMangae",permission.getSqMangae());
		request.getSession().setAttribute("PmManage",permission.getPmManage());
		//以上代码测试时需要注解
		return permission;
	}
	
	
	@Override
	public String execute(OperatingOrganization opog) throws Exception {
		// TODO Auto-generated method stub
		if(isUser(opog))
		{
			this.getPermission(opog);
			return "success";
		}
		return "error";
	}

	public OpogDao getOpogDao() {
		return opogDao;
	}

	@Resource(name="opogDao")
	public void setOpogDao(OpogDao opogDao) {
		this.opogDao = opogDao;
	}

	public PermissionDao getPerDao() {
		return perDao;
	}

	@Resource(name="perDao")
	public void setPerDao(PermissionDao perDao) {
		this.perDao = perDao;
	}


}
