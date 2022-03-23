package com.sdd.zk1;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Separator;

public class LoginVm {

//	private static final String userid = "Rasdi";
//	private static final String pass = "test123";
	
	int counter;
	
	
	private String userId, password ;
	@Wire
	private Groupbox gbMsg;
	
	@Wire
	private Button btClear;
	
	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW)Component view) {
		Selectors.wireComponents(view, this, false);
		System.out.println("Running Login Vm");
		btClear.setDisabled(true);
	
	}
	
	
	//method
	@Command
	public void doLogin()	
	{
		btClear.setDisabled(false);
		if(userId !=null && password !=null && userId.trim().length() >0 && password.trim().length() >0) {
			if (loginChecker(userId, password)) {
				Executions.sendRedirect("/view/livingroom.zul");
			}
			
			Messagebox.show("failed login");
		}else {
			counter++;
			Label msg = new Label("isi dulu");
			gbMsg.appendChild(msg);
			gbMsg.appendChild(new Separator());
			doTitle();
		}
		
		
	}
	
	@Command
	public void doClearMsg()
	{
		btClear.setDisabled(false);
		counter = 0;
		gbMsg.getChildren().clear();
		doTitle();
		btClear.setDisabled(true);
		
	}
	
	private boolean loginChecker(String id, String pw) {
		boolean isValid = false;
		if(id.equals(userId) && pass.equals(password)) {
			isValid = true;
		}
		return isValid;
	}
	
	
	@Command
	public void doRegister()
	{
		Executions.sendRedirect("/view/register.zul");
	}
	
	@Command
	
	public void doCustomer()
	{
		Executions.sendRedirect("/view/customer/customer.zul");
	}
	
	@Command 
	public void doLogin1()
	{
		Executions.sendRedirect("view/belajar/login1.zul");
	}
	
	
	
	public void doTitle() {
		gbMsg.setTitle("Message ("+ counter+")");
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
