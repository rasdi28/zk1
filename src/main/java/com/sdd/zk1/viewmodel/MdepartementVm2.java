package com.sdd.zk1.viewmodel;

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
import org.zkoss.zul.Grid;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.Textbox;

import com.sdd.zk1.dao.MdepartementDAO;
import com.sdd.zk1.domain.Mdepartement;


public class MdepartementVm2 {
	
	private Mdepartement objDept;
	private List<Mdepartement> listDept = new ArrayList<Mdepartement>();
	private MdepartementDAO oDao = new MdepartementDAO();
	
	@Wire
	private Grid grid;
	
	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
				
		doReset();
		grid.setRowRenderer(new RowRenderer<Mdepartement>() {

			@Override
			public void render(Row row, Mdepartement data, int index) throws Exception {
				row.getChildren().add(new Label(String.valueOf(index + 1)));
				row.getChildren().add(new Label(data.getDeptname()));
				row.getChildren().add(new Label(data.getDeptcode()));
				
				Button btndel = new Button("DELETE");
				btndel.addEventListener(Events.ON_CLICK, new EventListener<Event>() {

					@Override
					public void onEvent(Event event) throws Exception {
						Messagebox.show("apakah anda ingin menghapus", "konfirmasi", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new EventListener<Event>() {

							@Override
							public void onEvent(Event event) throws Exception {
								if(event.getName().equals("onOK")) {
									oDao.delete(data);
									doReset();
								}
								
							}
						});
						
						
						
					}
				});
				
				Button btnEdit = new Button("Edit");
				btnEdit.addEventListener(Events.ON_CLICK, new EventListener<Event>() {

					@Override
					public void onEvent(Event event) throws Exception {
			
						objDept = data;
						BindUtils.postNotifyChange(null, null, MdepartementVm2.this, "objDept");
						
					}
				});
				
				Hlayout hlayout = new Hlayout();
				hlayout.appendChild(btnEdit);
				hlayout.appendChild(btndel);
				row.appendChild(hlayout);
				
			}
			
		});
		
	}
	
	@Command
	public void doReset() {
		objDept = new Mdepartement();
		doRefresh();
	}
	
	@Command
	public void doRefresh() {
		String orderno = "mdepartementpk";
		objDept = new Mdepartement();
		grid.setModel(new ListModelList<>(oDao.listAll(orderno)));
	}
	
	@Command
	@NotifyChange("*")
	public void doSave() {
		
		oDao.save(objDept);
		doRefresh();
		
	}

	public Mdepartement getObjDept() {
		return objDept;
	}

	public void setObjDept(Mdepartement objDept) {
		this.objDept = objDept;
	}
	
}
