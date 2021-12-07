package ru.simanov.javalessons.models;

public class SocksForm {
	//TODO: @Jsonproperty(name = "color")
	private String color;
	private int cottonPart;
	private int quantity;
	
	public SocksForm() {
	}
	
	public SocksForm(String color, int cottonPart, int quantity) {
		this.color = color;
		this.cottonPart = cottonPart;
		this.quantity = quantity;
	}
	
	//Getters
	public String getColor() {return color;}
	public int getCottonPart() {return cottonPart;}
	public int getQuantity() {return quantity;}
	
	//Setters
	public void setColor(String color) {this.color = color;}
	public void setCottonPart(int cottonPart) {this.cottonPart = cottonPart;}
	public void setQuantity(int quantity) {this.quantity = quantity;}
	
	public String ToString() {
		return "color: " + color + "\n" +
			   "cottonPart: " + cottonPart + "\n" +
			   "quantity: " + quantity;
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
}
