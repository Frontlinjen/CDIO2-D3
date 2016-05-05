package webInterface.shared;

import java.util.List;

public interface AnsatDAO {
	AnsatDTO getAnsat(String cpr) throws DALException;
	List<AnsatDTO> getAnsatList() throws DALException;
	void createAnsat(AnsatDTO ans) throws DALException;
	void updateAnsat(AnsatDTO ans) throws DALException;
	void deleteAnsat(AnsatDTO ans) throws DALException;
}
