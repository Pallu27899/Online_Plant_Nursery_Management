package masai.com.service;



import java.util.List;

import masai.com.exception.CustomerException;
import masai.com.exception.LogInException;
import masai.com.model.SignUpData;

public interface SignUpService {
	
public SignUpData createNewSignUp(SignUpData signUp) throws LogInException;
	
	public SignUpData updateSignUpDetails(SignUpData signUp,String key) throws LogInException;
	
	public List<SignUpData> showallcustomers()throws CustomerException;
	
	public SignUpData deletecustomer(Integer userId)throws CustomerException;
	
	
	

}

