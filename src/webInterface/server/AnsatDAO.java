package webInterface.server;

import java.util.List;

import webInterface.shared.AnsatDTO;

public interface AnsatDAO {
	AnsatDTO getAnsat(String cpr) throws DALException;
	List<AnsatDTO> getAnsatList() throws DALException;
	void createAnsat(AnsatDTO ans) throws DALException;
	void updateAnsat(AnsatDTO ans) throws DALException;
	void deleteAnsat(AnsatDTO ans) throws DALException;
}
