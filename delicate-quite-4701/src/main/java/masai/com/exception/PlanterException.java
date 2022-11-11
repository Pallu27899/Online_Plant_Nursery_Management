package masai.com.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PlanterException extends Exception {
	
	public PlanterException(String message) {
		super(message);
		
	}

}
