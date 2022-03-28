package com.sdd.zk1;

import java.text.NumberFormat;
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
import org.zkoss.zul.Button;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.Separator;

import com.sdd.zk1.dao.ProductDAO;
import com.sdd.zk1.domain.Mproduct;
import com.sdd.zk1.domain.Musergroup;

public class ProductVm {

	private List<Mproduct> objList;
	
	private Grid grid;
	private Mproduct objproduct;
	
	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		doReset();
		objList = new ArrayList<Mproduct>();
		grid.setRowRenderer(new RowRenderer<Mproduct>() {
			@Override
			public void render(Row row, final Mproduct data, int index) throws Exception {

				row.appendChild(new Label(String.valueOf(++index)));
				row.appendChild(new Label(data.getProductname()));
				row.appendChild(new Label(NumberFormat.getInstance().format(data.getProductprice())));
				row.appendChild(new Label(NumberFormat.getInstance().format(data.getProductstock())));
				
			}
		});
	}
	
	@Command
	@NotifyChange("*")
	public void doReset() {
		objproduct = new Mproduct();
		doRefresh();
	}
	
	@Command
	@NotifyChange("*")
	public void doRefresh()
	{
		objList = new ProductDAO().listAll();
		grid.setModel(new ListModelList<Mproduct>(objList));
	}

	public List<Mproduct> getObjList() {
		return objList;
	}

	public void setObjList(List<Mproduct> objList) {
		this.objList = objList;
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public Mproduct getObjproduct() {
		return objproduct;
	}

	public void setObjproduct(Mproduct objproduct) {
		this.objproduct = objproduct;
	}
	
	
	
}
