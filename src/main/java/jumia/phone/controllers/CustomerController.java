package jumia.phone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {	
	@GetMapping("/customersView")
	public ModelAndView customerView(){
		return new ModelAndView("customersView");
	}
}