package com.sdd.zk1;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.sdd.zk1.domain.Mcustomergroup;

public class CustomerVm {

	private String customers;
	
	private Mcustomergroup objcust;
	
	@Wire
	private Grid gridcust;
	
	private int number;
	
	private List<Mcustomergroup> objcustList;
	
	
	@AfterCompose
	public void afterCompose (@ContextParam(ContextType.VIEW)Component view) {
		Selectors.wireComponents(view, this, false);
		doReset();
		objcustList = new ArrayList<Mcustomergroup>();
		gridcust.setRowRenderer(new RowRenderer<Mcustomergroup>() {
			//implement method tinggal klik
			@Override
			public void render(Row row, Mcustomergroup datacust, int index) throws Exception {
				// TODO Auto-generated method stub
				row.appendChild(new Label(String.valueOf(++index)));
				row.appendChild(new Label(datacust.getCustomername()));
				row.appendChild(new Label(datacust.getCustomercontact()));
				row.appendChild(new Label(datacust.getCustomermitra()));
				
				
			
			}
			
		
		});
		
	}
	
	@Command
	@NotifyChange("objcust") //ngasih tau ke zul harus kosong
	public void doCreate() {
		//list
		objcustList.add(objcust);
		doReset();
		
		
	}
	
	public void doReset()
	{
		objcust = new Mcustomergroup();// buat baru list sehingga tidak duplicate
		
	}
	
	@Command
	public void doRender() {
		//nampilin list
		gridcust.setModel(new ListModelList <Mcustomergroup>(objcustList));
		
		
	}
	


	public String getCustomers() {
		return customers;
	}


	public void setCustomers(String customers) {
		this.customers = customers;
	}

	public Mcustomergroup getObjcust() {
		return objcust;
	}

	public void setObjcust(Mcustomergroup objcust) {
		this.objcust = objcust;
	}
	
	
}
