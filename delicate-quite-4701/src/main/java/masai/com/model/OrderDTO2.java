package masai.com.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDTO2 {
	
	private Integer orderId;
	private Integer quantity;
	private Integer totalPrice;
	private LocalDate orderDate;

}
