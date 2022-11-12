package masai.com.service;



import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import masai.com.exception.LogInException;
import masai.com.model.CurrentUserSession;
import masai.com.model.LogInData;
import masai.com.model.SignUpData;
import masai.com.repository.CurrentUserSessionDao;
import masai.com.repository.LoginDataDao;
import masai.com.repository.SignUpDao;



@Service
public class LogInServiceImpl implements LogInService {

	@Autowired
	private SignUpDao signUpDAO;
	
	@Autowired
	private CurrentUserSessionDao currentUserSessionDAO;
	
	@Autowired
	private CurrentUserSessionService getCurrentLoginUserSession;
	
	@Autowired
	private LoginDataDao loginDataDAO;


	
	@Override
	public String logInAccount(LogInData loginData) throws LogInException  {
		
Optional<SignUpData> opt = signUpDAO.findById(loginData.getUserId());
		
		if(!opt.isPresent())
		{
			throw new LogInException("Invalid Login UserId");
		}
		
		SignUpData newSignUp = opt.get();
		
		Integer newSignUpId = newSignUp.getUserId();
		Optional<CurrentUserSession> currentUserOptional = currentUserSessionDAO.findByUserId(newSignUpId);
		
		if(currentUserOptional.isPresent()) {
			throw new LogInException("User Already login with this UserId");
		}
		
		if((newSignUp.getUserId() == loginData.getUserId()) && (newSignUp.getPassword().equals(loginData.getPassword())))
		{
			String key = RandomString.getRandomNumberString();
			
			CurrentUserSession currentUserSession = new CurrentUserSession(newSignUp.getUserId(),key,LocalDateTime.now());
			currentUserSessionDAO.save(currentUserSession);
			loginDataDAO.save(loginData);
			System.out.println(currentUserSession.toString());
			return currentUserSession.toString();
			
		}
		else
			throw new LogInException("Invalid UserName or Password!");
			
			
		
	}
	
	@Override
	public String logOutFromAccount(String key) throws LogInException  {
		
		Optional<CurrentUserSession> currentUserOptional = currentUserSessionDAO.findByUuid(key);
		if(!currentUserOptional.isPresent())
		{
			throw new LogInException("User has not logged in with this UserId");
		}
		CurrentUserSession currentUserSession = getCurrentLoginUserSession.getCurrentUserSession(key);
		
		currentUserSessionDAO.delete(currentUserSession);
		
		Optional<LogInData> loginData = loginDataDAO.findById(currentUserOptional.get().getUserId());
		System.out.println(loginData);
		loginDataDAO.delete(loginData.get());
		
		
		return "Logged Out......";
	
	}

}