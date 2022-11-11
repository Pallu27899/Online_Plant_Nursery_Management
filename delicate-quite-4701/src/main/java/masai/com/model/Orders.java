package masai.com.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	
	private Integer quantity;
	
	private Integer totalCost;
	
	private String transactionMode;
	
	private LocalDateTime orderDate;
	
	private Integer customerId;
	
	private List<Seed> seeds;
	
	private List<Plant> plants;
	
	private List<Planter> planters; 

}
