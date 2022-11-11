package masai.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import masai.com.exception.OrderException;
import masai.com.model.OrderDTO;
import masai.com.model.OrderDTO2;
import masai.com.model.Orders;
import masai.com.model.SignUpData;
import masai.com.repository.OrderRepository;


@Service
public class OrderServiceImpl implements OrderService {
	
	
	@Autowired
	private OrderRepository orderRepo;
	

	@Override
	public OrderDTO2 addOrder(Orders order) throws OrderException {
		// TODO Auto-generated method stub
		
		Orders savedOrder = orderRepo.save(order);
		
		if(savedOrder == null) throw new OrderException("Unable to save order");
		else {
			OrderDTO2 oDto2 = new OrderDTO2(order.getOrderId(), order.getQuantity(), order.getTotalCost(), order.getOrderDate());
			return oDto2;
		}
		
	}

	@Override
	public Orders updateOrder(Orders order) throws OrderException {
		// TODO Auto-generated method stub
		
		Optional<Orders> opt = orderRepo.findById(order.getOrderId());
		
		if(!opt.isPresent()) throw new OrderException("No such order found");
		else {
			return orderRepo.save(opt.get());
		}
	}

	@Override
	public Orders deleteOrder(Integer orderId) throws OrderException {
		
		 return orderRepo.findById(orderId).orElseThrow(()-> new OrderException("No order found with Order Id "+ orderId));		
		
		
	}

	@Override
	public Orders viewOrder(Integer orderId) throws OrderException {
		
		return orderRepo.findById(orderId).orElseThrow(()-> new OrderException("No order found with this order Id"));
		
	}

	@Override
	public List<Orders> viewAllOrders() throws OrderException {
		
		List<Orders> list = orderRepo.findAll();
		
		if(list.isEmpty()) throw new OrderException("No orders found.");
		else return list;
	}

	@Override
	public SignUpData viewcustomer(Integer orderid) throws OrderException {
		
		Optional<Orders> opt = orderRepo.findById(orderid);
		
		if(!opt.isPresent()) {
			throw new OrderException("No order found with this order Id");
		}else {
			
		}
		
		return null;
	}

	@Override
	public List<Orders> viewordersbyuserid(Integer userid) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

}
