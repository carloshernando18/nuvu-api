package com.nuvu.api.models;

import javax.validation.constraints.NotNull;

public class CreditCardModel {

	@NotNull
	private String name;

	@NotNull
	private String number;

	@NotNull
	private String expiredDate;
	
	@NotNull
	private String securityCode;
	
	public CreditCardModel() {
	}

	public CreditCardModel(String name, String number,
			String expiredDate, String securityCode) {
		this.name = name;
		this.number = number;
		this.expiredDate = expiredDate;
		this.securityCode = securityCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumero(String number) {
		this.number = number;
	}

	public String getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	

}
