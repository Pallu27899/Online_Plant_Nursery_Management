package masai.com.exception;

import java.time.LocalDateTime;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {
	
	
	@ExceptionHandler(LogInException.class)
	public ResponseEntity<ErrorDetails> loginexceptionhandler(LogInException lie,WebRequest req){
		
		ErrorDetails ed=new ErrorDetails();
		ed.setTimestamp(LocalDateTime.now());
		ed.setMessage(lie.getMessage());
		ed.setDetails(req.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(PlantException.class)
	public ResponseEntity<ErrorDetails> plantExceptionHandler(PlantException se,WebRequest req){
		
		ErrorDetails err = new ErrorDetails();
		
		
		err.setTimestamp(LocalDateTime.now());
      
		err.setMessage(se.getMessage());
		
		err.setDetails(req.getDescription(false));
		
		
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(SeedException.class)
	public ResponseEntity<ErrorDetails> seedsExceptionHandler(SeedException se,WebRequest req){
		
		ErrorDetails err = new ErrorDetails();
		
		
		err.setTimestamp(LocalDateTime.now());
      
		err.setMessage(se.getMessage());
		
		err.setDetails(req.getDescription(false));
		
		
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ErrorDetails> customerExceptionHandler(CustomerException ce,WebRequest req){
		
		ErrorDetails err = new ErrorDetails();
		
		
		err.setTimestamp(LocalDateTime.now());
      
		err.setMessage(ce.getMessage());
		
		err.setDetails(req.getDescription(false));
		
		
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> MANVExceptionHandler(MethodArgumentNotValidException me) {
		
		ErrorDetails err = new ErrorDetails();
		
		err.setTimestamp(LocalDateTime.now());
		err.setMessage("Validation Error");
		err.setDetails(me.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> notFoundExceptionHandler(NoHandlerFoundException nfe, WebRequest req ){
		
		ErrorDetails err = new ErrorDetails();
		
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(nfe.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class) 
	public ResponseEntity<ErrorDetails> otherExceptionHandler(Exception e, WebRequest req) {
		
		ErrorDetails err = new ErrorDetails();
		
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	

}
