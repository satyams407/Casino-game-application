package com.nagarro.dao;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="CustomerData")
public class Customer {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name="userId", unique = true)
	private String userId;

	@Column(name="name")
	@NotNull
	private String name;

	@Column(name="DOB")
	@NotNull
	private LocalDate dateOfBirth;

	@Column(name="contactnumber")
	@NotNull
	private Integer contactNumber;

	@Column(name="email")
	@NotNull
	private String email;

	@Column(name="balance")
	private Double accountBalance;

	@Column(name="blockedamount")
	private Double blockedAmount;

	@Lob
	@Column(name = "photo")
	@NotNull
	private byte[] photo;

	public Customer() {
		this.accountBalance = 500d;
		this.blockedAmount = 0d;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public Double getBlockedAmount() {
		return blockedAmount;
	}

	public Integer getContactNumber() {
		return contactNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public String getUserId() {
		return userId;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public void setBlockedAmount(Double blockedAmount) {
		this.blockedAmount = blockedAmount;
	}

	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
