package webInterface.client.EventHandlers;
import java.util.Arrays;
import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;

import webInterface.server.Database.AnsatDAO;
import webInterface.server.Database.DALException;
import webInterface.server.Database.MySQLAnsatDAO;
import webInterface.shared.AnsatDTO;






public class ListUsersClickHandler implements ClickHandler {
		
	
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

	private Column<AnsatDTO, String> getButtonColumn(String value) {
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
		List<AnsatDTO> gui = getLayoutList(event);
		List<AnsatDTO> ops = getOperators();
			gui.addAll(ops);
	}
	
	private List<AnsatDTO> getOperators(){
		AnsatDAO ansat = new MySQLAnsatDAO();
		try {
			 return ansat.getAnsatList();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
