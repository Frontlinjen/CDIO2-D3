package webInterface.server;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import webInterface.client.AnsatRPCInterface;
import webInterface.shared.AnsatDTO;

public class AnsatRPCServlet extends RemoteServiceServlet implements AnsatRPCInterface {

	@Override
	public AnsatDTO getAnsat(String cpr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AnsatDTO> getAnsatList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createAnsat(AnsatDTO ans) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAnsat(AnsatDTO ans) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAnsat(AnsatDTO ans) {
		// TODO Auto-generated method stub
		
	}
	
}
