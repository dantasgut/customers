package br.com.lab.customers.services.interfaces;

import java.util.List;

import br.com.lab.customers.api.dtos.CustomerDTO;

public interface CustomerService {

	public List<CustomerDTO> findAll();
	public CustomerDTO findById(CustomerDTO customerDTO);
	public void save(CustomerDTO customerDTO);
	public void delete(CustomerDTO customerDTO);
}
