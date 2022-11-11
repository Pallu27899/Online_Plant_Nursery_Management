package masai.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import masai.com.model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{
	
	public List<Orders> findByCustomerId(Integer customerId);

}
