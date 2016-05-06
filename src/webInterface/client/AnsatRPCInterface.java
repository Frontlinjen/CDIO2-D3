package webInterface.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import webInterface.shared.AnsatDTO;

@RemoteServiceRelativePath("")
public interface AnsatRPCInterface extends RemoteService{
	AnsatDTO getAnsat(String cpr);
	List<AnsatDTO> getAnsatList();
	Integer createAnsat(AnsatDTO ans);
	Integer updateAnsat(AnsatDTO ans);
	Integer deleteAnsat(AnsatDTO ans);
}
