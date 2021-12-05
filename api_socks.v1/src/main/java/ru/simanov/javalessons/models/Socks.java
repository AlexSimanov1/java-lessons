package ru.simanov.javalessons.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "socks")
public class Socks {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "cotton_part")
	private int cottonPart;
	
	@Column(name = "quantity")
	private int quantity;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getCottonPart() {
		return cottonPart;
	}
	
	public void setCottonPart(int cottonPart) {
		this.cottonPart = cottonPart;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void hundleValidate() throws Exception {
		
		if (color == null)
			throw new Exception("Color required");
		
		if (cottonPart < 0)
			throw new Exception("cottonPart should be greater than 0");
		
		if (cottonPart > 100)
			throw new Exception("cottonPart should be less or equal than 100");
		
		if (quantity < 0)
			throw new Exception("quantity should be greater than 0");
	}
	
	@Override
	public String toString() {
		return "color: " + color + "\n" +
				"cottonPart: " + cottonPart + "\n" +
				"quantity: " + quantity;
	}
}
