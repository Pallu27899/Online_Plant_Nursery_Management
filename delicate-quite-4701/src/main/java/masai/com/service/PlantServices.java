package masai.com.service;

import java.util.List;

import masai.com.exception.PlantException;
import masai.com.model.Plant;

public interface PlantServices {
	
	public Plant addPlant(Plant plant) throws PlantException;
	
	public Plant updatePlant(Plant plant) throws PlantException;
	
	public Plant deletePlant(Plant plant) throws PlantException;
	
	public Plant viewPlant(Integer plantId) throws PlantException;
	
	public Plant viewPlantByCommonName(String commonName) throws PlantException;
	
	public List<Plant> viewAllPlants() throws PlantException;
	
	public List<Plant> viewAllPlantsByTypeOfPlant(String typeOfPlant) throws PlantException;
	
	

}
