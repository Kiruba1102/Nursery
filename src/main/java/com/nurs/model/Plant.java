package com.nurs.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Component
@Entity
public class Plant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String species;
	private String variety;
	private int quantity;
	private double price;
	@Lob
	@Column(name = "image", length = 100000)
	private byte[] image;
	
//	@ManyToOne
//	@JoinColumn(name = "admin_id")
//	private Admin admin;
//	
	
	
	
	public int getPid() {
		return pid;
	}
	public Plant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Plant(int pid, String species, String variety, int quantity, double price, byte[] image) {
	super();
	this.pid = pid;
	this.species = species;
	this.variety = variety;
	this.quantity = quantity;
	this.price = price;
	this.image = image;
}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getVariety() {
		return variety;
	}
	public void setVariety(String variety) {
		this.variety = variety;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
}
//	public Admin getAdmin() {
//		return admin;
//	}
//	public void setAdmin(Admin admin) {
//		this.admin = admin;
//	}
//}
