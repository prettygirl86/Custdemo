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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ACC_TYPE_ID")
	private String accTypeId;

	@Column(name="ACC_TYPE_NAME")
	private String accTypeName;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="account")
	private List<Customer> customers;

	public Account() {
	}

	public String getAccTypeId() {
		return this.accTypeId;
	}

	public void setAccTypeId(String accTypeId) {
		this.accTypeId = accTypeId;
	}

	public String getAccTypeName() {
		return this.accTypeName;
	}

	public void setAccTypeName(String accTypeName) {
		this.accTypeName = accTypeName;
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