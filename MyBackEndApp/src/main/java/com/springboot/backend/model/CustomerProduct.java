package com.springboot.backend.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.springboot.backend.enums.CouponCode;

@Entity
@Table(name="customer_product")
public class CustomerProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Customer1 customer1;
	
	@OneToOne
	private Product product;
	
	private LocalDate dateOfPurchase;
	
	private boolean couponUsed;
	@Enumerated(EnumType.STRING)
	private CouponCode couponCode;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer1 getCustomer1() {
		return customer1;
	}

	public void setCustomer1(Customer1 customer1) {
		this.customer1 = customer1;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public LocalDate getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(LocalDate dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public boolean isCouponUsed() {
		return couponUsed;
	}

	public void setCouponUsed(boolean couponUsed) {
		this.couponUsed = couponUsed;
	}

	public CustomerProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerProduct(Long id, Customer1 customer1, Product product, LocalDate dateOfPurchase, boolean couponUsed,
			CouponCode couponCode) {
		super();
		this.id = id;
		this.customer1 = customer1;
		this.product = product;
		this.dateOfPurchase = dateOfPurchase;
		this.couponUsed = couponUsed;
		this.couponCode = couponCode;
	}

	public CouponCode getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(CouponCode couponCode) {
		this.couponCode = couponCode;
	}

	@Override
	public String toString() {
		return "CustomerProduct [id=" + id + ", customer1=" + customer1 + ", product=" + product + ", dateOfPurchase="
				+ dateOfPurchase + ", couponUsed=" + couponUsed + ", couponCode=" + couponCode + "]";
	}

	

}
