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
	
	
	
	private LocalDate orderDate;
	
	private Integer customerId;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Seed> seeds;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Plant> plants;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Planter> planters; 

}
