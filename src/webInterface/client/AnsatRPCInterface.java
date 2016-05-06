package webInterface.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import webInterface.shared.AnsatDTO;

public interface AnsatRPCInterface extends RemoteService{
	AnsatDTO getAnsat(String cpr);
	List<AnsatDTO> getAnsatList();
	void createAnsat(AnsatDTO ans);
	void updateAnsat(AnsatDTO ans);
	void deleteAnsat(AnsatDTO ans);
}
