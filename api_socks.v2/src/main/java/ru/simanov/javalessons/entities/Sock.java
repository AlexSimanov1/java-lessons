package ru.simanov.javalessons.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "socks")
public class Sock {
	
	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private long id;
	
	@Column(name = "color", nullable = false)
	private String color;
	
	@Column(name = "cotton_part", nullable = false)
	private int cottonPart;

	@Column(name = "quantity", nullable = false)
	private int quantity;
	
	public Sock() {
	}
	
	public Sock(long id, String color, int cottonPart, int quantity) {
		this.id = id;
		this.color = color;
		this.cottonPart = cottonPart;
		this.quantity = quantity;
	}
	
	public Sock(String color, int cottonPart, int quantity) {
		this.color = color;
		this.cottonPart = cottonPart;
		this.quantity = quantity;
	}
	
	//Getters
	public long getId() {return id;}
	public String getColor() {return color;}
	public int getCottonPart() {return cottonPart;}
	public int getQuantity() {return quantity;}
	
	//Setters
	public void setId(long id) {this.id = id;}
	public void setColor(String color) {this.color = color;}
	public void setCottonPart(int cottonPart) {this.cottonPart = cottonPart;}
	public void setQuantity(int quantity) {this.quantity = quantity;}
}
