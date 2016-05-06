package webInterface.client.EventHandlers;
import java.util.Arrays;
import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException;
import com.google.gwt.user.client.rpc.InvocationException;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.view.client.ListDataProvider;

import webInterface.client.AnsatRPCInterface;
import webInterface.client.AnsatRPCInterfaceAsync;
import webInterface.shared.AnsatDTO;






public class ListUsersClickHandler implements ClickHandler, AsyncCallback<AnsatDTO[]> {
	
	AnsatRPCInterfaceAsync database = (AnsatRPCInterfaceAsync)GWT.create(AnsatRPCInterface.class);
	List<AnsatDTO> gui;
	
	public List<AnsatDTO> getLayoutList(ClickEvent event) { //TODO: Show users when clicked
		RootPanel panel = RootPanel.get("contents");
		panel.clear();
		CellTable<AnsatDTO> vPanel = new CellTable<AnsatDTO>();
		
				TextColumn<AnsatDTO> CPRColumn = getCPRColumn();
		//CPRColumn.setSortable(true);
				Column<AnsatDTO, String> nameColumn = getNameColumn();
		//nameColumn.setSortable(true);
				TextColumn<AnsatDTO> iniColumn = getIniColumn();
		//nameColumn.setSortable(true);
				Column<AnsatDTO, String> rankColumn = getRankColumn();
		//nameColumn.setSortable(true);
				Column<AnsatDTO, String> saveColumn = getButtonColumn("save");
				Column<AnsatDTO, String> removeColumn = getButtonColumn("remove");
				
		vPanel.addColumn(CPRColumn, "CPR");
		vPanel.addColumn(nameColumn, "Name");
		vPanel.addColumn(iniColumn, "Ini");
		vPanel.addColumn(rankColumn, "Rank");
		vPanel.addColumn(saveColumn, "");
		vPanel.addColumn(removeColumn, "");
		
		ListDataProvider<AnsatDTO> userList = new ListDataProvider<AnsatDTO>();
		
		
		
		userList.addDataDisplay(vPanel);		
		panel.add(vPanel);
		
		return userList.getList();
	}

	private Column<AnsatDTO, String> getButtonColumn(final String value) {
		ButtonCell button = new ButtonCell();
		Column<AnsatDTO, String> buttonColumn = new Column<AnsatDTO, String>(button)
				{
					@Override
					public String getValue(AnsatDTO user)
					{
						return value;
					}
				};
		return buttonColumn;
	}

	private Column<AnsatDTO, String> getRankColumn() {
		final String[] ranks = new String[] {"Operatør", "Værkfører", "Farmaceut", "Administrator"};
		SelectionCell rankCell = new SelectionCell(Arrays.asList(ranks));
		Column<AnsatDTO, String> rankColumn = new Column<AnsatDTO, String>(rankCell)
				{
					@Override
		            public String getValue(AnsatDTO object) {
		                return ranks[object.getTitel()];  //pass integer as i here at runtime
		            }
				};
		return rankColumn;
	}

	private TextColumn<AnsatDTO> getIniColumn() {
		TextColumn<AnsatDTO> iniColumn = new TextColumn<AnsatDTO>()
		{
			@Override
			public String getValue(AnsatDTO user) {
				return user.getIni();
			}
		};
		return iniColumn;
	}

	private TextColumn<AnsatDTO> getCPRColumn() {
		TextColumn<AnsatDTO> CPRColumn = new TextColumn<AnsatDTO>()
				{

					@Override
					public String getValue(AnsatDTO user) {
						return user.getCpr();
					}
					
				};
		return CPRColumn;
	}

	private Column<AnsatDTO, String> getNameColumn() {
		EditTextCell nameCell = new EditTextCell();
		Column<AnsatDTO, String> nameColumn = new Column<AnsatDTO, String>(nameCell)
				{
					@Override
					public String getValue(AnsatDTO user) {
						return user.getOprNavn();
					}
				};
		return nameColumn;
	}

	@Override
	public void onClick(ClickEvent event) {
		if(gui==null)
			gui = getLayoutList(event);
		database.getAnsatList(this);
	}

	@Override
	public void onFailure(Throwable caught) {
		 try {
		       throw caught;
		     } catch (IncompatibleRemoteServiceException e) {
		       Window.alert("Incompatible");
		     } catch (InvocationException e) {
		       Window.alert("Failed to invoke\n" + e.getMessage());
		     } catch (Throwable e) {
		       // last resort -- a very unexpected exception
		    	 Window.alert("We're fucked");
		     }
	}
	@Override
	public void onSuccess(AnsatDTO[] result) {
		if(result==null)
		{
			Window.alert("No data recieved.");
		}
		else
		{
			Window.alert("Data updated");
		}
		for (AnsatDTO ansatDTO : result) {
			gui.add(ansatDTO);
		}
	}
	


}
