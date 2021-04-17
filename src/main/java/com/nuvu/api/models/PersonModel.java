package com.nuvu.api.models;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PersonModel {

	private int id;

	@NotNull
	private String name;

	@NotNull
	@NotEmpty
	private String identification;

	@NotNull
	@Email
	@NotEmpty
	private String email;

	@NotNull
	private String phone;

	@NotEmpty
	private List<CreditCardModel> creditCards;

	public PersonModel() {
	}

	public PersonModel(int id, @NotNull String name, @NotNull @NotEmpty String identification,
			@NotNull @Email @NotEmpty String email, @NotNull String phone,
			@NotEmpty List<CreditCardModel> creditCards) {
		this.id = id;
		this.name = name;
		this.identification = identification;
		this.email = email;
		this.phone = phone;
		this.creditCards = creditCards;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdetification() {
		return identification;
	}

	public void setIdetification(String identification) {
		this.identification = identification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<CreditCardModel> getCreditCards() {
		if (this.creditCards == null) {
			this.creditCards = new ArrayList<>();
		}
		return this.creditCards;
	}

	public void setCreditCards(List<CreditCardModel> creditCards) {
		this.creditCards = creditCards;
	}

}
