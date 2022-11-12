package masai.com.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
	
	@Min(value = 1 , message = "Minimum Quantity should be 1")
	private Integer quantity;
	
	@Min(value = 1 , message = "Minimum cost should be 1")
	private Integer totalCost;
	
	@NotNull(message = "Transaction mode cannot be null")
	private String transactionMode;
	
	private LocalDate orderDate;
	
	@NotNull(message = "Customer Id cannot be null")
	private Integer customerId;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private @Valid List<Seed> seeds;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private @Valid List<Plant> plants;
	
	@OneToMany(cascade = CascadeType.ALL)
	private @Valid List<Planter> planters; 

}
