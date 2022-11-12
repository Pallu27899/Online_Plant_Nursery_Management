package masai.com.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

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
}
