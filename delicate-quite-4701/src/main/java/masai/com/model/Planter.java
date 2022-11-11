package masai.com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Planter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer planterId;
	
	@Min(value = 1, message = "Planter's Height can't be 0")
	private Float planterheight;
	
	@Min(value = 1, message = "Planter's Capacity can't be 0")
	private Integer planterCapacity;
	
	@Min(value = 1, message = "Planter's Drinage Hole can't be 0")
	private Integer drinageHoles;
	
	@NotBlank(message = "Planter's color can't be blank")
	private String planterColor;
	
	@NotBlank(message = "Planter's shape can't be blank")
	private String planterShape;
	
	@Min(value = 0, message = "Planter's stock can't be negative")
	private Integer planterStock;
	
	@Min(value = 1, message = "Planter's cost can't be 0")
	private Integer planterCost;
	
	
	// Assuming that each Planter object is mapped to One Plant object

	@OneToMany(cascade = CascadeType.ALL)
	 private List<Plant> plants;   
//	
//	// Assuming that each Planter object is mapped to One Seed object
	@OneToMany(cascade = CascadeType.ALL)
	 private List<Seed> seeds;

}
 
