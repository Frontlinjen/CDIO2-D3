package webInterface.client;


import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import webInterface.shared.AnsatDTO;

@RemoteServiceRelativePath("Ansatte")
public interface AnsatRPCInterface extends RemoteService{
	AnsatDTO getAnsat(String cpr);
	AnsatDTO[] getAnsatList();
	Integer createAnsat(AnsatDTO ans);
	Integer updateAnsat(AnsatDTO ans);
	Integer deleteAnsat(AnsatDTO ans);
}
