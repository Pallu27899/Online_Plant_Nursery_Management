package masai.com.service;

import java.util.List;

import masai.com.exception.OrderException;
import masai.com.model.OrderDTO;
import masai.com.model.OrderDTO2;
import masai.com.model.Orders;
import masai.com.model.SignUpData;

public interface OrderService {
	
	public OrderDTO2 addOrder(OrderDTO order) throws OrderException;
	public Orders updateOrder(Orders order) throws OrderException;
	public Orders deleteOrder(Integer orderId) throws OrderException;
	public Orders viewOrder(Integer orderId) throws OrderException;
	public List<Orders>viewAllOrders() throws OrderException;
	public SignUpData viewcustomer(Integer orderid) throws OrderException;
	
	public List<Orders> getOrdersByUserId(Integer userid)throws OrderException;

}
