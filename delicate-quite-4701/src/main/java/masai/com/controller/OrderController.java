package masai.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import masai.com.exception.OrderException;
import masai.com.model.OrderDTO2;
import masai.com.model.Orders;
import masai.com.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	
	@Autowired
	private OrderService oService;
	
	
	@PostMapping("/addorders")
	public ResponseEntity<OrderDTO2> addOrder(@RequestBody Orders order) throws OrderException{
		
		OrderDTO2 odto2 = oService.addOrder(order);
		
		return new ResponseEntity<OrderDTO2>(odto2, HttpStatus.CREATED);
		
	}
}
