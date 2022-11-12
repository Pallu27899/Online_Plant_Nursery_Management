package masai.com.service;


import masai.com.exception.LogInException;
import masai.com.model.CurrentUserSession;
import masai.com.model.SignUpData;

public interface CurrentUserSessionService {
	
	

	
		
		public CurrentUserSession getCurrentUserSession(String key) throws LogInException;;
		public Integer getCurrentUserSessionId(String key) throws LogInException;
		
		public SignUpData getSignUpDetails(String key) throws LogInException;
		

	

}