package com.sdd.zk1.viewmodel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.Textbox;

import com.sdd.zk1.dao.MdepartementDAO;
import com.sdd.zk1.dao.MemployeeDAO;
import com.sdd.zk1.domain.Mdepartement;
import com.sdd.zk1.domain.Memployee;



public class MemployeeVm2 {

	private Memployee objEmployee;
	private Mdepartement objDepartement;
	private MemployeeDAO oDao = new MemployeeDAO();
	private List<Memployee> listEmployee = new ArrayList<Memployee>();
	private Boolean isUpdate;
	private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");

	@Wire
	private Grid grid;

	@Wire
	private Textbox employeename, npp, address;

	@Wire
	private Datebox dob;
	
	@Wire
	private Combobox cbdepartement;

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		objEmployee = new Memployee();
		isUpdate = false;
		doRefresh();
		grid.setRowRenderer(new RowRenderer<Memployee>() {

			@Override
			public void render(Row row, Memployee data, int index) throws Exception {
				row.getChildren().add(new Label(String.valueOf(index + 1)));
				row.getChildren().add(new Label(data.getEmployeename()));
				row.getChildren().add(new Label(data.getNpp()));
				row.getChildren().add(new Label(data.getDob() != null ? dateFormatter.format(data.getDob()) : ""));
				row.getChildren().add(new Label(data.getAddress()));
				row.getChildren().add(new Label(data.getMdepartement().getDeptname()));

				

			}
		});

	}

	@Command
	@NotifyChange("*")
	public void doSave() {
		oDao.save(objEmployee);


		doRefresh();


	}

	public void doRefresh() {
		String orderno = "memployeepk";
		grid.setModel(new ListModelList<Memployee>(oDao.listAll(orderno)));
	}

	
	public ListModelList<Mdepartement> getMdepartementmodel() {
		ListModelList<Mdepartement> lm = null;
		try {
			lm = new ListModelList<Mdepartement>(getMdepartement());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lm;
	}
	
	
	public static List<Mdepartement> getMdepartement() throws Exception {
		List<Mdepartement> list = new ArrayList<Mdepartement>();
		list = new MdepartementDAO().listAll("deptname");
		return list;
	}
	
	public Memployee getObjEmployee() {
		return objEmployee;
	}

	public void setObjEmployee(Memployee objEmployee) {
		this.objEmployee = objEmployee;
	}

	public Mdepartement getObjDepartement() {
		return objDepartement;
	}

	public void setObjDepartement(Mdepartement objDepartement) {
		this.objDepartement = objDepartement;
	}
	
	public ListModelList<Mdepartement> getMdepartementModel(){
		String orderno = "deptname";
		return new ListModelList<>(new MdepartementDAO().listAll(orderno));
	}
	
	
}
