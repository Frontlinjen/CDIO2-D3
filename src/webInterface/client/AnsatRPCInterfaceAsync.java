package webInterface.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import webInterface.shared.AnsatDTO;

public interface AnsatRPCInterfaceAsync {
	public void getAnsat(String cpr, AsyncCallback<AnsatDTO> callback);
	public void  getAnsatList(AsyncCallback<List<AnsatDTO>> callback);
	public void createAnsat(AnsatDTO user, AsyncCallback<Integer> callback);
	public void updateAnsat(AnsatDTO user, AsyncCallback<Integer> callback);
	public void deleteAnsat(AnsatDTO user, AsyncCallback<Integer> callback);

}
