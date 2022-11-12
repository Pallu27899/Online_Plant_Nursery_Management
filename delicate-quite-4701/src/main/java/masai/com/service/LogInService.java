package masai.com.service;

import masai.com.exception.LogInException;
import masai.com.model.LogInData;

public interface LogInService {
	
	

	public String logInAccount(LogInData loginData)throws LogInException ;
	public String logOutFromAccount(String key) throws LogInException;


}
