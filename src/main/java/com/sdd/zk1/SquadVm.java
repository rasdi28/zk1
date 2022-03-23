package com.sdd.zk1;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Textbox;

import com.sdd.zk1.domain.Msquad;

public class SquadVm {

	private List<Msquad> objListsquad;
	
	private Msquad obj;
	
	private int count;
	private int indexseleccted;
	private String squadname;
	private String squadmail;
	
	
	@Wire
	private Listbox listbox;
	
	@Wire
	private Textbox tbSquadname, tbSquademail;
	
	@Wire
	private Combobox cbUnit;
	
	@AfterCompose
	@NotifyChange("*")
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		objListsquad = new ArrayList<Msquad>();
		doReset();
		
		listbox.setItemRenderer(new ListitemRenderer<Msquad>() {

			@Override
			public void render(Listitem item, Msquad data, int index) throws Exception {
				// TODO Auto-generated method stub
				Listcell cell = new Listcell(String.valueOf(index+1));
				item.appendChild(cell);
				
				cell = new Listcell(data.getSquadname());
				item.appendChild(cell);
				
				cell = new Listcell(data.getSquademail());
				item.appendChild(cell);
				
				cell = new Listcell(data.getRole());
				
			}
			
			
		});
		
		listbox.addEventListener(Events.ON_CLICK, new EventListener<Event>() {

			@Override
			public void onEvent(Event event) throws Exception {
				// TODO Auto-generated method stub
				cbUnit.setValue(obj.getMunit().getUnitcode());
				
			}
		
		});
		
	}
	
	
	
	
	
	
}
