package webInterface.client.EventHandlers;
import java.util.Arrays;

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

import javafx.scene.control.ListCell;
import webInterface.shared.AnsatDTO;






public class ListUsersClickHandler implements ClickHandler {
	
		
	@Override
	public void onClick(ClickEvent event) { //TODO: Show users when clicked
		RootPanel panel = RootPanel.get("contents");
		panel.clear();
		CellTable<AnsatDTO> vPanel = new CellTable<AnsatDTO>();
		
		TextColumn<AnsatDTO> CPRColumn = new TextColumn<AnsatDTO>()
				{
					@Override
					public String getValue(AnsatDTO user) {
						return user.getCpr();
					}
				};
		//CPRColumn.setSortable(true);
				EditTextCell nameCell = new EditTextCell();
				Column<AnsatDTO, String> nameColumn = new Column<AnsatDTO, String>(nameCell)
						{
							@Override
							public String getValue(AnsatDTO user) {
								return user.getOprNavn();
							}
						};

		//nameColumn.setSortable(true);
				TextColumn<AnsatDTO> iniColumn = new TextColumn<AnsatDTO>()
				{
					@Override
					public String getValue(AnsatDTO user) {
						return user.getIni();
					}
				};
		//nameColumn.setSortable(true);
				final String[] ranks = new String[] {"Operatør", "Værkfører", "Farmaceut", "Administrator"};
				SelectionCell rankCell = new SelectionCell(Arrays.asList(ranks));
				Column<AnsatDTO, String> rankColumn = new Column<AnsatDTO, String>(rankCell)
						{
							@Override
			                public String getValue(AnsatDTO object) {
			                    return ranks[object.getTitel()];  //pass integer as i here at runtime
			                }
						};
				
		//nameColumn.setSortable(true);
				ButtonCell saveButton = new ButtonCell();
				Column<AnsatDTO, String> saveColumn = new Column<AnsatDTO, String>(saveButton)
						{
							@Override
							public String getValue(AnsatDTO user)
							{
								return "Save";
							}
						};
				ButtonCell removeButton = new ButtonCell();
				Column<AnsatDTO, String> removeColumn = new Column<AnsatDTO, String>(removeButton)
				{
					@Override
					public String getValue(AnsatDTO user)
						{
							return "Delete";
						}
				};
		vPanel.addColumn(CPRColumn, "CPR");
		vPanel.addColumn(nameColumn, "Name");
		vPanel.addColumn(iniColumn, "Ini");
		vPanel.addColumn(rankColumn, "Rank");
		vPanel.addColumn(saveColumn, "");
		vPanel.addColumn(removeColumn, "");
		
		ListDataProvider<AnsatDTO> userList = new ListDataProvider<AnsatDTO>();
		userList.addDataDisplay(vPanel);
		userList.getList().add(new AnsatDTO("000001", "Test", "22","123", 2));		
		panel.add(vPanel);


	}

}
