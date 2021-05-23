package br.com.lab.customers.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.lab.customers.api.dtos.CustomerDTO;
import br.com.lab.customers.services.interfaces.CustomerService;

@Controller
@RequestMapping(path="/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	@ResponseBody
	public List<CustomerDTO> findAll(){
		return customerService.findAll();
	}
}
