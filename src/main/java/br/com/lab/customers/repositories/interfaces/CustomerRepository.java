package br.com.lab.customers.repositories.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.lab.customers.repositories.entities.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
	public List<Customer> findAll();
}
