package com.sdd.zk1.viewmodel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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



public class MemployeeVm {

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
//				row.getChildren().add(new Label(data.getDob() != null ? dateFormatter.format(data.getDob()) : ""));s
				row.getChildren().add(new Label(data.getAddress()));

				Button btnDelete = new Button("DELETE");
				btnDelete.addEventListener(Events.ON_CLICK, new EventListener<Event>() {

					@Override
					public void onEvent(Event event) throws Exception {
//						listEmployee.remove(data);
//						grid.setModel(new ListModelList<>(listEmployee));
//						System.out.println("total data setelah dihapus : " + listEmployee.size());
						oDao.delete(data);
						doRefresh();
						
					}
				});

				Button btnUpdate = new Button("EDIT");
				btnUpdate.addEventListener(Events.ON_CLICK, new EventListener<Event>() {

					@Override
					public void onEvent(Event event) throws Exception {
						employeename.setValue(data.getEmployeename());
						npp.setValue(data.getNpp());
						address.setValue(data.getAddress());
						dob.setValue(data.getDob());
						isUpdate = true;
						objEmployee = data;
					}

				});

				Div div = new Div();
				div.appendChild(btnUpdate);
				div.appendChild(btnDelete);

				row.getChildren().add(div);

			}
		});

	}

	@Command
	@NotifyChange("*")
	public void doSave() {
//		if (isUpdate) {
//			System.out.println("ini update");
//			listEmployee.remove(objEmployee);
//		} else {
//			System.out.println("ini insert");
//		}

//		objEmployee.setEmployeename(employeename.getValue());
//		objEmployee.setNpp(npp.getValue());
//		objEmployee.setDob(dob.getValue());
//		objEmployee.setAddress(address.getValue());
//		listEmployee.add(objEmployee);
		oDao.save(objEmployee);

		if (!isUpdate) 
			Messagebox.show("Data Berhasil Disimpan", "Notifikasi", Messagebox.OK, Messagebox.INFORMATION);
		else 
			Messagebox.show("Data Berhasil Diupdate", "Notifikasi", Messagebox.OK, Messagebox.INFORMATION);
		
		doRefresh();
//		grid.setModel(new ListModelList<>(listEmployee));
		objEmployee = new Memployee();
		System.out.println("total data saat ini : " + listEmployee.size());

		employeename.setValue(null);
		npp.setValue(null);
		address.setValue(null);
		dob.setValue(null);
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
}
