package masai.com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import masai.com.exception.LogInException;
import masai.com.model.LogInData;
import masai.com.service.LogInService;

@RestController
public class LoginController {
	

	@Autowired
	private LogInService loginService;
	
	@PostMapping("/login")
	public String loginHandler( @Valid @RequestBody LogInData loginData) throws LogInException {
		return loginService.logInAccount(loginData);
	}
	
	@PatchMapping("/logout")
	public String logOutFromAccount(@RequestParam String key) throws LogInException
	{
		return loginService.logOutFromAccount(key);
	}
	//done

}
