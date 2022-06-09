package br.com.lab.customers.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.lab.customers.api.dtos.CustomerDTO;
import br.com.lab.customers.services.interfaces.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public List<CustomerDTO> findAll(){
		return customerService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public CustomerDTO getById(@PathVariable("id") Integer id) {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setId(id);
		return customerService.findById(customerDTO);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody CustomerDTO customerDTO) {
		customerService.save(customerDTO);
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable Integer id, @RequestBody CustomerDTO customerDTO) {
		customerDTO.setId(id);
		customerService.save(customerDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable Integer id) {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setId(id);
		customerService.delete(customerDTO);
	}
}
