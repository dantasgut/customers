package br.com.lab.customers.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lab.customers.api.dtos.CustomerDTO;
import br.com.lab.customers.repositories.entities.Customer;
import br.com.lab.customers.repositories.interfaces.CustomerRepository;
import br.com.lab.customers.services.interfaces.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	<S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
	    return source
	      .stream()
	      .map(element -> modelMapper.map(element, targetClass))
	      .collect(Collectors.toList());
	}
	
	public List<CustomerDTO> findAll() {
		
		List<Customer> customers =  customerRepository.findAll();
		return mapList(customers, CustomerDTO.class);
	}

	public CustomerDTO findById(CustomerDTO customerDTO) {
		Customer customer = customerRepository.findById(customerDTO.getId()).orElse(new Customer());
		return modelMapper.map(customer, CustomerDTO.class);
	}

	public void save(CustomerDTO customerDTO) {
		Customer customer = modelMapper.map(customerDTO, Customer.class);
		customerRepository.save(customer);		
	}

	public void delete(CustomerDTO customerDTO) {
		Customer customer = modelMapper.map(customerDTO, Customer.class);
		customerRepository.delete(customer);
	}

}
