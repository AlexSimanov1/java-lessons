package ru.simanov.javalessons.model;

public class SendMoneyForm {
	private Long fromAccountId;
	private Long toAccountId;
	private double amount;
	
	public SendMoneyForm() {
	}
	
	public SendMoneyForm(Long fromAccountId, Long toAccountId, double amount) {
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
		this.amount = amount;
	}
	
	//Getters and Setters
    public Long getFromAccountId() {
        return fromAccountId;
    }
    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }
    public Long getToAccountId() {
        return toAccountId;
    }
    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    public String toString() {
    	return "fromAccId: " + this.fromAccountId + "\n" +
    		   "toAccId: " + this.toAccountId + "\n" +
    		   "amount: " + this.amount;
    }

}
