package webInterface.client;

import webInterface.client.EventHandlers.ListUsersClickHandler;
import webInterface.client.EventHandlers.NewUserClickhandler;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RootPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CDIO3_D2_WebInterface implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() 
	{
		RootPanel container = RootPanel.get("options");
		String[] buttons = {"List users", "Create new user"};
		ClickHandler[] clickers = {new ListUsersClickHandler(), new NewUserClickhandler()};
		for(int i=0;i<buttons.length;++i)
		{
			PushButton t = new PushButton(buttons[i]);
			t.addClickHandler(clickers[i]);
			container.add(t);
		}
	}
}
