package masai.com.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import masai.com.exception.LogInException;
import masai.com.model.SignUpData;
import masai.com.service.SignUpService;

@RestController
public class SignUpController {
	
	@Autowired
	private SignUpService signUpService;
	
	@PostMapping("/signUp")
	public ResponseEntity<SignUpData> createNewSignUpHandler(@Valid @RequestBody SignUpData newSignUp) throws LogInException {
		
		SignUpData newSignedUp =signUpService.createNewSignUp(newSignUp);
		return new ResponseEntity<SignUpData>(newSignedUp,HttpStatus.CREATED);

	}
	
	@PutMapping("/updateSignUp")
	public ResponseEntity<SignUpData> updateSignUpDetailsHandler(@RequestBody SignUpData signUp, @RequestParam String key) throws LogInException
	{
		SignUpData newUpdatedSignUp = signUpService.updateSignUpDetails(signUp,key);
		
		return new ResponseEntity<SignUpData>(newUpdatedSignUp,HttpStatus.ACCEPTED);
		
	
	}
	

}
