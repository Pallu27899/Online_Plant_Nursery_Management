package masai.com.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class LogInData {
	
	@Id
	@NotNull
	private Integer userId;
	@NotNull(message="username shouldn't be empty")
	private String userName;
	@NotNull(message="password shouldn't be empty")
	private String password;
	
}
