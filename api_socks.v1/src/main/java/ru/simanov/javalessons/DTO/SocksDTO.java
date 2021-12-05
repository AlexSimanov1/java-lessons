package ru.simanov.javalessons.DTO;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
public class SocksDTO {
	@NotEmpty(message = "Color required")
	private String color;
	
	@Min(value = 0, message = "cottonPart should be greater than 0")
	@Max(value = 100, message = "cottonPart should be less or equal than 100")
	private int cottonPart;
	
	@Min(value = 0, message = "quantity should be greater than 0")
	private int quantity;
	
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
}
