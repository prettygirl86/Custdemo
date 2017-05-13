package com.example;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.stereotype.Component;


/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
@Component
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String cid;

	private String name;

	private String role;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="ACC_TYPE")
	private Account account;

	public Customer() {
	}

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}