package masai.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Plant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer plantId;
	
	@NotNull
	private Integer plantHeight;
	
	@NotNull
	private String plantSpread;
	
	private String commonName;
	
	private String bloomTime;
	
	@NotNull
	private String medicinalOrCulinaryUse;
	
	private String difficultyLevel;
	
	private String temparature;
	
	@NotNull
	private String typeOfPlant;
	
	private String plantDescription;
	
	@NotNull
	private Integer plantStock;
	
	@NotNull
	private Integer plantCost;
	

}

