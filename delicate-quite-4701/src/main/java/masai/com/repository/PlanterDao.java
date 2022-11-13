package masai.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import masai.com.model.Planter;

@Repository
public interface PlanterDao extends JpaRepository<Planter, Integer> {
	
	@Query("select p from Planter p where p.planterShape = ?1")
	public Planter viewPlanterByPlanterShape(String planterShape);
	
	@Query("select p from Planter p where p.planterCost BETWEEN ?1 AND ?2")
     public List<Planter> viewAllPlantersByCost(Integer minCost, Integer maxCost);
	

}
