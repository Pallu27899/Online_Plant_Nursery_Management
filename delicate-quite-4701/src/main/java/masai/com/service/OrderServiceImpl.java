package masai.com.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import masai.com.exception.OrderException;
import masai.com.model.OrderDTO;
import masai.com.model.OrderDTO2;
import masai.com.model.Orders;
import masai.com.model.Plant;
import masai.com.model.Planter;
import masai.com.model.Seed;
import masai.com.model.SignUpData;
import masai.com.repository.OrderRepository;
import masai.com.repository.PlantDao;
import masai.com.repository.PlanterDao;
import masai.com.repository.SeedDao;
import masai.com.repository.SignUpDao;


@Service
public class OrderServiceImpl implements OrderService {
	
	
	@Autowired
	private OrderRepository orderRepo;
	
	
	@Autowired
	private SignUpDao sDao;
	@Autowired
	private PlanterDao pDao;
	
	@Autowired
	private PlantDao plantDao;
	
	@Autowired
	private SeedDao seedDao;
	
	@Override
	public OrderDTO2 addOrder(OrderDTO order) throws OrderException {
		
		Orders newOrder = new Orders();
		
		newOrder.setCustomerId(order.getCustomerId());
		newOrder.setQuantity(1);
		newOrder.setOrderDate(LocalDate.now());
		
		
		Integer totalPrice = 0;
		
		if(order.getPlanterId() != null) {
			Planter planter = pDao.findById(order.getPlanterId()).orElseThrow(()-> new OrderException("No planter found"));
			
			List<Planter> planters = Arrays.asList(planter);
			newOrder.setPlanters(planters);
			totalPrice+=planter.getPlanterCost();
		}
						
		if(order.getPlantId() != null) {
			Plant plant = plantDao.findById(order.getPlantId()).orElseThrow(()-> new OrderException("No plant found"));
			
			List<Plant> plants = Arrays.asList(plant);
			newOrder.setPlants(plants);
			totalPrice+=plant.getPlantCost();
		}
				
		if(order.getSeedId() != null) {
			Seed seed = seedDao.findById(order.getSeedId()).orElseThrow(()->new OrderException("No seed found"));
			
			List<Seed> seeds = Arrays.asList(seed);
			newOrder.setSeeds(seeds);
			totalPrice+=seed.getSeedsCost();
		}
		
		newOrder.setTotalCost(totalPrice);
		Orders savedOrder = orderRepo.save(newOrder);
		
		OrderDTO2 odt2 = new OrderDTO2();
		odt2.setOrderId(savedOrder.getOrderId());
// 		odt2.setTransactionMode(savedOrder.getTransactionMode());
		odt2.setTotalPrice(savedOrder.getTotalCost());
		odt2.setOrderDate(savedOrder.getOrderDate());
		odt2.setQuantity(1);
		return odt2;
		
	}

	@Override
	public Orders updateOrder(Orders order) throws OrderException {
		
		Orders result = orderRepo.findById(order.getOrderId()).orElseThrow(()-> new OrderException("No record found"));
		
		List<Planter> planters = order.getPlanters();
		List<Plant> plants = order.getPlants();
		List<Seed> seeds = order.getSeeds();
		
		Integer totalPrice=0;
		if(planters.size()>0) {
			for(Planter p:planters) totalPrice+=p.getPlanterCost();
		}		
		if(plants.size()>0) {
			for(Plant p:plants) totalPrice+=p.getPlantCost();
		}
		if(seeds.size()>0) {
			for(Seed s:seeds) totalPrice+=s.getSeedsCost();
		}
		result.setTotalCost(totalPrice);
		return orderRepo.save(result);
		
	}

	@Override
	public Orders deleteOrder(Integer orderId) throws OrderException {
		
		// return orderRepo.findById(orderId).orElseThrow(()-> new OrderException("No order found with Order Id "+ orderId));	
		
		Optional<Orders> opt = orderRepo.findById(orderId);
		 if(!opt.isPresent()) throw new OrderException("No orders is made with this OrderId");
		 else {
			 Orders res =opt.get();
			 orderRepo.delete(res);
			 return res;
		 }
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
			Optional<SignUpData> sign = sDao.findById(opt.get().getCustomerId());
			return sign.get();
		}
	}

	@Override
	public List<Orders> getOrdersByUserId(Integer userid) throws OrderException {
		 
		List<Orders> orderList = orderRepo.findByCustomerId(userid);
		
		if(orderList.size()==0) throw new OrderException("No orders found with this customer Id ");
		else return orderList;
	}

}
