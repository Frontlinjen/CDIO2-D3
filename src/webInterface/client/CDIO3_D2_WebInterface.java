package webInterface.client;

import webInterface.client.EventHandlers.ListUsersClickHandler;
import com.google.gwt.core.client.EntryPoint;
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
		String[] buttons = {"List users"};
		for(String s : buttons)
		{
			PushButton t = new PushButton(s);
			t.addClickHandler(new ListUsersClickHandler());
			container.add(t);
		}
	}
}
