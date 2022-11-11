package masai.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import masai.com.exception.PlanterException;
import masai.com.model.Planter;
import masai.com.repository.PlanterDao;

@Service
public class PlanterServiceImpl implements PlanterService {

	@Autowired
	PlanterDao pDao;

	
//	-----------------------------------Add Planter-------------------------------------------
	@Override
	public Planter addPlanter(Planter planter) throws PlanterException {
		
		Planter servicePlanter = pDao.save(planter);
		
		if(servicePlanter == null) {
			throw new PlanterException("Planter details are Empty fill the details.......");
		}
		else
		{
			return planter;
		}
	}

	
	
//	-----------------------------------Update Planter-------------------------------------------
	@Override
	public Planter updatePlanter(Planter planter) throws PlanterException {
		
		Optional<Planter> serviceOptional = pDao.findById(planter.getPlanterId());
		
		if(serviceOptional.isPresent())
		{
			Planter pl = pDao.save(planter);
			return pl;
		}
		else
		{
			throw new PlanterException("Planter Not found with the given Id " +planter.getPlanterId());
		}
	}

	
	
//	-----------------------------------Delete Planter-------------------------------------------
	@Override
	public Planter deletePlanter(Planter planter) throws PlanterException {
		
		Optional<Planter> serviceOptional = pDao.findById(planter.getPlanterId());
		
		if(serviceOptional.isPresent())
		{
			    pDao.delete(serviceOptional.get());
				return planter; 
		}
	   else 
	   {
        throw new PlanterException("This Planter is not present for delete the planterId "+ planter.getPlanterId());
	   }
	}

	
//	----------------------------View Planter by with Help of planterId-------------------------------------------
	@Override
	public Planter viewPlanter(Integer planterId) throws PlanterException {
		
		Optional<Planter> serviceOptional = pDao.findById(planterId);
		
		if(serviceOptional.isPresent())
		{
			Planter planter=serviceOptional.get();
			return planter;
		}
		else {
        throw new PlanterException("This Planter with given id +"+planterId+" is not present ........");
        }
		
	}

	
//	-----------------------------View Planter by with Help of planterShape-------------------------------------------
	@Override
	public Planter viewPlantByPlanterShape(String planterShape) throws PlanterException {
		
		Planter servicePlanter =  pDao.viewPlanterByPlanterShape(planterShape);
		
		if(servicePlanter == null) {
			throw new PlanterException("Planter is not available for this planter Shape "+ planterShape);
		}
		else
		{
			return servicePlanter;
		}
		
	}

	
//	-----------------------------View All Planter-------------------------------------------	
	@Override
	public List<Planter> viewAllPlanters() throws PlanterException {
		
		List<Planter> servicePlanterList = pDao.findAll();
		
		if(servicePlanterList.isEmpty())
		{
			throw new PlanterException("Planter list is not available !!");
			
		}
		else {
			return servicePlanterList;
       
        }
	}

	
//	--------------------------View Planter List by with MinMaxCost--------------------------------------
	@Override
	public List<Planter> viewAllPlantersByCost(double minCost, double maxCost) throws PlanterException {
		
		List<Planter> servicePlanterList = pDao.viewAllPlantersByCost(minCost, maxCost);
		
		if(servicePlanterList.isEmpty())
		{
			throw new PlanterException("Planter list is not available in Minmun Planter cost "+minCost+" And Maximum Cost "+maxCost);
			
		}
		else {
			return servicePlanterList;
       
        }
		
	}

}
