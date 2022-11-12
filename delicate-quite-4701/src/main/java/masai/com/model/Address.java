package masai.com.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Address {
	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	*/

	@NotBlank(message = "House Number can't be null")
	private String houseNo;

	@NotBlank(message = "Colony can't be null")
	private String colony;

	@NotBlank(message = "City can't be null")
	private String city;

	@NotBlank(message = "State can't be null")
	private String State;

	@Min(value = 1, message = "Pincode can't be zero")
	private Integer pincode;

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getColony() {
		return colony;
	}

	public void setColony(String colony) {
		this.colony = colony;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", colony=" + colony + ", city=" + city
				+ ", State=" + State + ", pincode=" + pincode + "]";
	}

	public Address(Integer addressId, @NotBlank(message = "House Number can't be null") String houseNo,
			@NotBlank(message = "Colony can't be null") String colony,
			@NotBlank(message = "City can't be null") String city,
			@NotBlank(message = "State can't be null") String state,
			@Min(value = 1, message = "Pincode can't be zero") Integer pincode) {
		super();
	
		this.houseNo = houseNo;
		this.colony = colony;
		this.city = city;
		State = state;
		this.pincode = pincode;
	}
	
	public Address()
	{
		
	}
   
	
}

