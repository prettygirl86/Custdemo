package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.CustomerRepository;
import com.example.model.Account;
import com.example.model.Customer;

@RestController
public class CustomerController {

	@Autowired
	CustomerRepository customerrepository;

	@Autowired
	Account account;

	@Autowired
	Customer customer;

	/*
	 * @RequestMapping("\findAll") List<Customer> findAll() {
	 * System.out.println("########FindAll####"); return
	 * customerrepository.findAll(); }
	 */

	@RequestMapping("/register")
	public String registerCustomer() {
		customer.setCid("4");
		customer.setName("Rakhi");
		customer.setRole("Doctor");
		account.setAccTypeId("4");
		account.setAccTypeName("Loan");
		customer.setAccount(account);
		customerrepository.save(customer);
		for (Customer cust : customerrepository.findAll()) {
			System.out.println("Customer id: " + cust.getCid() + " Customer Name: " + cust.getName() + " Role: "
					+ cust.getRole() + " Account Type: " + cust.getAccount().toString());
		}
		return "Customer registered!!!";

	}

	@RequestMapping("/{cid}")
	List<Customer> findByCid(@PathVariable String cid) {
		return (List<Customer>) customerrepository.findOne(cid);
	}

}
