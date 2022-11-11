package masai.com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import masai.com.exception.PlanterException;
import masai.com.model.Planter;
import masai.com.service.PlanterService;

@RestController
public class PlanterController {
	
	@Autowired
	private PlanterService planterService;
	
	
		@GetMapping("/showplanter/{id}")               
		public ResponseEntity<Planter> viewPlanterHandler(@Valid @PathVariable("id") int planterId) throws PlanterException {
			
			Planter obtainedPlanter = planterService.viewPlanter(planterId);
					
			return new ResponseEntity<Planter>(obtainedPlanter, HttpStatus.OK);
		}
		
		
		@GetMapping("/getplanters/{shape}")              
		public ResponseEntity<Planter> viewPlanterByShape(@Valid @PathVariable("shape") String planterShape) throws PlanterException {
			
			Planter planter = planterService.viewPlantByPlanterShape(planterShape);
					
			return new ResponseEntity<Planter>(planter, HttpStatus.OK);
		}
		
		
		@GetMapping("/showplanters")              
		public ResponseEntity<List<Planter>> findAllPlanters() throws PlanterException {
			
			List<Planter> planterList = planterService.viewAllPlanters();
					
			return new ResponseEntity<List<Planter>>(planterList, HttpStatus.OK);
		}
		

		@GetMapping("/showplanters/{minCost}/{maxCost}")   
		public ResponseEntity<List<Planter>> viewPlantersByCostRange(@Valid @PathVariable("minCost") Integer minCost, @PathVariable("maxCost") Integer maxCost) throws PlanterException {
			
			List<Planter> planterList = planterService.viewAllPlantersByCost(minCost, maxCost);
			
			return new ResponseEntity<List<Planter>>(planterList, HttpStatus.OK);
		}
		

}

