package com.example;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.util.List;


/**
 * The persistent class for the ACCOUNT database table.
 * 
 */
@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
@Component
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String acctypid;

	private String acctype;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="account")
	private List<Customer> customers;

	public Account() {
	}

	public String getAcctypid() {
		return this.acctypid;
	}

	public void setAcctypid(String acctypid) {
		this.acctypid = acctypid;
	}

	public String getAcctype() {
		return this.acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setAccount(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setAccount(null);

		return customer;
	}

}