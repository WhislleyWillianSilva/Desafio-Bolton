package com.whislley.bolton.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "invoices")
public class Invoice {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "access_key", unique = true)
	private String accessKey;
	@Column(name = "amount")
	private double amount;
	
	public Invoice() {
		
	}
	
	public Invoice (long id, String accessKey, double amount) {
		this.id = id;
		this.accessKey = accessKey;
		this.amount = amount;
	}
	
}
