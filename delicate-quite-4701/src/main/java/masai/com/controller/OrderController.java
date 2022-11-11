package masai.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import masai.com.exception.OrderException;
import masai.com.model.OrderDTO;
import masai.com.model.OrderDTO2;
import masai.com.model.Orders;
import masai.com.model.SignUpData;
import masai.com.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	
	@Autowired
	private OrderService oService;
	
	
	@PostMapping("/addorders")
	public ResponseEntity<OrderDTO2> addOrder(@RequestBody OrderDTO order) throws OrderException{		
		return new ResponseEntity<OrderDTO2>(oService.addOrder(order), HttpStatus.CREATED);
	}
	
	
	@PutMapping("/updateorder")
	public ResponseEntity<Orders> updateOrder(@RequestBody Orders order) throws OrderException{
		return new ResponseEntity<Orders>( oService.updateOrder(order), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteorder/{orderId}")
	public ResponseEntity<Orders> deleteOrder(@PathVariable("orderId") Integer orderId) throws OrderException{
		return new ResponseEntity<Orders>(oService.deleteOrder(orderId),HttpStatus.OK);
	}
	@GetMapping("/vieworder/{customerId}")
	public ResponseEntity<List<Orders>> getOrdersByUserId(@PathVariable("customerId") Integer customerId) throws OrderException{
		return new ResponseEntity<List<Orders>>(oService.getOrdersByUserId(customerId),HttpStatus.OK);
	}
	
	@GetMapping("/viewcustomer/{orderId}")
	public ResponseEntity<SignUpData> showCustomerByOrderId(@PathVariable("orderId") Integer orderId) throws OrderException{
		return new ResponseEntity<SignUpData>(oService.viewcustomer(orderId),HttpStatus.OK);
	}
}
