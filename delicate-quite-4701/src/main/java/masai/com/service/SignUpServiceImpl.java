package masai.com.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import masai.com.exception.CustomerException;
import masai.com.exception.LogInException;
import masai.com.model.SignUpData;
import masai.com.repository.SignUpDao;

@Service
public class SignUpServiceImpl implements SignUpService {


	@Autowired
	private SignUpDao signUpDAO;
	
	@Autowired
	private CurrentUserSessionService getCurrentLoginUserSession;
	
	
	
	@Override
	public SignUpData createNewSignUp(SignUpData newSignUp) throws LogInException  {
		System.out.println(newSignUp);
		
		Optional<SignUpData> opt = signUpDAO.findByUserName(newSignUp.getUserName());
		if(opt.isPresent())
		{
			throw new LogInException("User Already Exist!");
		}
		
		
		return signUpDAO.save(newSignUp);
		
	}

	@Override
	public SignUpData updateSignUpDetails(SignUpData signUp, String key) throws LogInException  {
		
		SignUpData signUpDetails = getCurrentLoginUserSession.getSignUpDetails(key);
		
		if(signUpDetails == null)
		{
			throw new LogInException("UnAuthorized!!! No User Found....Try To login first!");
		}
		
		if(signUpDetails.getUserId() == signUp.getUserId())
			{
			signUpDAO.save(signUp);
			return signUp;
			}
		else
			throw new LogInException("Can't change UserId!!");
	}

	@Override
	public List<SignUpData> showallcustomers() throws CustomerException {
		// TODO Auto-generated method stub
		List<SignUpData> customers=signUpDAO.findAll();
		if(customers.size()==0) {
			throw new CustomerException("no customer available");
		}
		return customers; 
		
	}

	@Override
	public SignUpData deletecustomer(Integer userId) throws CustomerException {
		// TODO Auto-generated method stub
		
		Optional<SignUpData> opt= signUpDAO.findById(userId);
		
		if(opt.isPresent()) {
			SignUpData existcustomer = opt.get();
			signUpDAO.delete(existcustomer);
			return existcustomer;
		}
		else
			throw new CustomerException("no customer found");
		
		
	}

}