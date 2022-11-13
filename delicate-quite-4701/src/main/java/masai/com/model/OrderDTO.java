package masai.com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDTO {
	
	private Integer planterId;
	private Integer plantId;
	private Integer seedId;
	
	private Integer customerId;

}
