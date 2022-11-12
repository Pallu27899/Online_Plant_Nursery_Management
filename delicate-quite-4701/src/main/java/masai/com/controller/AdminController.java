package masai.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import masai.com.service.OrderService;
import masai.com.service.PlantServices;
import masai.com.service.PlanterService;
import masai.com.service.SeedServices;
import masai.com.service.SignUpService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private SignUpService signupservice;
	@Autowired
	private SeedServices seedservice;
	@Autowired
	private OrderService orderservice;
	
	
	@Autowired
	private PlantServices plantServices;
	
	@Autowired
	private PlanterService planterService;
}
