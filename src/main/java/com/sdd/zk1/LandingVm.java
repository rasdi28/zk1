package com.sdd.zk1;

import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;

public class LandingVm {

	@Command
	public void doLogin()
	{
		Executions.sendRedirect("view/login.zul");
	}
	
}
