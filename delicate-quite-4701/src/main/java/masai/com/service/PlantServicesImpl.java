package masai.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import masai.com.exception.PlantException;
import masai.com.model.Plant;
import masai.com.repository.PlantDao;


@Service
public class PlantServicesImpl implements PlantServices{

	@Autowired
	private PlantDao pDao;
	
	
//	-----------------------------------Add Plant-------------------------------------------
	@Override
	public Plant addPlant(Plant plant) throws PlantException {
		
		Plant servicePlant = pDao.save(plant);
		
		if(servicePlant == null) {
			throw new PlantException("Plant details are Empty fill the details.......");
		}
		else
		{
			return plant;
		}
	}

	
//	-----------------------------------Update Plant-------------------------------------------	
	@Override
	public Plant updatePlant(Plant plant) throws PlantException {
		
		Optional<Plant> serviceOptional = pDao.findById(plant.getPlantId());
		
		if(serviceOptional.isPresent())
		{
			Plant pl = pDao.save(plant);
			return pl;
		}
		else
		{
			throw new PlantException("Plant Not found with the given Id "+ plant.getPlantId());
		}
	}

	
//	-----------------------------------delete Plant-------------------------------------------
	@Override
	public Plant deletePlant(Plant plant) throws PlantException {
		
		Optional<Plant> serviceOptional = pDao.findById(plant.getPlantId());
			
			if(serviceOptional.isPresent())
			{
				    pDao.delete(serviceOptional.get());
					return plant; 
			}
		   else 
		   {
	        throw new PlantException("This Plant is not present with plant Id "+plant.getPlantId());
		   }
	}

	
//	----------------------------View Plant by with Help of plantId-------------------------------------------
	@Override
	public Plant viewPlant(Integer plantId) throws PlantException {
		
		Optional<Plant> serviceOptional = pDao.findById(plantId);
			
			if(serviceOptional.isPresent())
			{
				Plant plant=serviceOptional.get();
				return plant;
			}
			else {
	        throw new PlantException("This Plant with given id is not present ........");
	        }
	}

	
//	-----------------------------View Plant by with Help of commonName-------------------------------------------
	@Override
	public Plant viewPlantByCommonName(String commonName) throws PlantException {
		
		Plant servicePlant =  pDao.viewPlantBycommonName(commonName);
		
		if(servicePlant == null) {
			throw new PlantException("Plant list is not available for this common name "+ commonName);
		}
		else
		{
			return servicePlant;
		}
		
	}

	
//	-----------------------------View All Plant List-------------------------------------------	
	@Override
	public List<Plant> viewAllPlants() throws PlantException {
		
		List<Plant> servicePlantList = pDao.findAll();
		
		if(servicePlantList.isEmpty())
		{
			throw new PlantException("Plant list is not available !!");
			
		}
		else {
			return servicePlantList;
       
        }
		
		
	}

	
//	--------------------------View All Plant List by with typeOfPlant-------------------------------------------
	@Override
	public List<Plant> viewAllPlantsByTypeOfPlant(String typeOfPlant) throws PlantException {
		
		List<Plant> servicePlantList = pDao.viewPlantBytypeOfPlant(typeOfPlant);
		
		if(servicePlantList.isEmpty())
		{
			throw new PlantException("Plant list is not available for the "+ typeOfPlant+ " plant");
			
		}
		else {
			return servicePlantList;
       
        }
		
	}
	
	

}
