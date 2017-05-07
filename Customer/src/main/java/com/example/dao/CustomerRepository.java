package com.example.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Account;
import com.example.model.Customer;

public interface CustomerRepository extends CrudRepository <Customer, String> {
	
	List<Customer> findByCid(String cid);
	
	/*List<Customer> findByName(String name);
	
	List<Customer> findByRole(String role);
	
	List<Customer> findByAccount(Account account);
	
	List<Customer> findAll();*/
	
	
	

}
