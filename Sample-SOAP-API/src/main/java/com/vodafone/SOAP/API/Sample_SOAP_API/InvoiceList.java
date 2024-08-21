package com.vodafone.SOAP.API.Sample_SOAP_API;

public class InvoiceList {
	private int accountID;
	private int amount;
	private String name;
	private String description;
	
	public InvoiceList(int accountID, int amount, String name, String description) {
		super();
		this.accountID = accountID;
		this.amount = amount;
		this.name = name;
		this.description = description;
	}
	
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return String.format("Invoice [accountID=%s, amount=%s, name=%s, description=%s]", accountID, amount, name,
				description);
	}

	
	
}
