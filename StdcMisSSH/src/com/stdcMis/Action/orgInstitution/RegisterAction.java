package com.stdcMis.Action.orgInstitution;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.dbEntity.OperatingOrganization;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.stdcMis.Dao.OpogDao;
import com.stdcMis.Service.user.RegisterManager;
import com.stdcMis.Vo.UserInfo;

public class RegisterAction extends ActionSupport implements ModelDriven {


	private String role = "普通用户";
	private String message = ERROR;
	private OperatingOrganization opog = new OperatingOrganization();
	private UserInfo info = new UserInfo();
	private RegisterManager registerManager;
	
	
	@Override
	public String execute() throws Exception {
		opog.setOName(info.getUsername());
		opog.setOCode(info.getCode());
		opog.setPwd(info.getPassword());
		opog.setOAddress(info.getAddress());
		opog.setOArea(info.getArea());
		opog.setOUrl(info.getUrl());
		opog.setOEmail(info.getEmail());
		opog.setOLperson(info.getLperson());
		opog.setOPostcode(info.getPostcode());
		opog.setOContacts(info.getContacts());
		opog.setOPlPhone(info.getPlphone());
		opog.setOMbPhone(info.getMbphone());
		opog.setOFax(info.getFax());
		opog.setOAttribute(info.getAttribute());
		opog.setOTmd(info.getTmd());
		opog.setOOverView(info.getOverView());
		opog.setRole(role);
		opog.setDemandCollects(null);
		message = registerManager.execute(opog);
		System.out.print(message);
		return message;
	}

	
	public UserInfo getInfo() {
		return info;
	}

	public void setInfo(UserInfo info) {
		this.info = info;
	}


	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return info;
	}


	public RegisterManager getRegisterManager() {
		return registerManager;
	}

	@Resource
	public void setRegisterManager(RegisterManager registerManager) {
		this.registerManager = registerManager;
	}
	
	
	
}
