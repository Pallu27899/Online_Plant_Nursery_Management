package masai.com.service;

import java.util.List;

import masai.com.exception.PlanterException;
import masai.com.model.Planter;

public interface PlanterService {
	
    public Planter addPlanter(Planter planter) throws PlanterException;
	
	public Planter updatePlanter(Planter planter) throws PlanterException;
	
	public Planter deletePlanter(Planter planter) throws PlanterException;
	
	public Planter viewPlanter(Integer planterId) throws PlanterException;
	
	public Planter viewPlantByPlanterShape(String planterShape) throws PlanterException;
	
	public List<Planter> viewAllPlanters() throws PlanterException;
	
	public List<Planter> viewAllPlantersByCost(double minCost, double maxCost) throws PlanterException;
	

}
