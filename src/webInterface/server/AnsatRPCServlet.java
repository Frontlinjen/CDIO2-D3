package webInterface.server;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import webInterface.client.AnsatRPCInterface;
import webInterface.server.Database.DALException;
import webInterface.server.Database.MySQLAnsatDAO;
import webInterface.shared.AnsatDTO;

public class AnsatRPCServlet extends RemoteServiceServlet implements AnsatRPCInterface {

	MySQLAnsatDAO database = new MySQLAnsatDAO();
	
	
	@Override
	public AnsatDTO getAnsat(String cpr) {
		try {
			return database.getAnsat(cpr);
		} catch (DALException e) {
			System.out.println("Failed at getAnsat");
		}
		return null;
	}

	@Override
	public List<AnsatDTO> getAnsatList() {
		try{
			return database.getAnsatList();
		} catch (DALException e){
			System.out.println("Failed at getAnsatList");
		}
		return null;
	}

	@Override
	public int createAnsat(AnsatDTO ans) {
		try {
		return database.createAnsat(ans);
		} catch (DALException e){
			System.out.println("Failed at createAnsat");
		}
		return 0;
	}

	@Override
	public int updateAnsat(AnsatDTO ans) {
		try {
			return database.updateAnsat(ans);
			} catch (DALException e){
				System.out.println("Failed at updateAnsat");
			}
			return 0;
		
	}

	@Override
	public int deleteAnsat(AnsatDTO ans) {
		try {
			return database.deleteAnsat(ans);
			} catch (DALException e){
				System.out.println("Failed at deleteAnsat");
			}
			return 0;
		
	}
	
}
