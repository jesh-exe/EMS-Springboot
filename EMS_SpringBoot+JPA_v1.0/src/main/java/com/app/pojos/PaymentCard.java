package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class PaymentCard {
	
	@Column(name = "card_number",length = 10,nullable = false)
	private String cardnumber;
	@Enumerated(EnumType.STRING)
	@Column(name = "card_type",length = 20,nullable = false)
	private CardType cardType;
	@Column(name = "cvv",length = 3,nullable = false)
	private String cvvNumber;
	@Column(nullable = false)
	private LocalDate expiryDate;
	
	public PaymentCard() {
		// TODO Auto-generated constructor stub
	}
	
	public PaymentCard(String cardnumber, String cardType, String cvvNumber, String expiryDate) {
		super();
		this.cardnumber = cardnumber;
		this.cardType = CardType.valueOf(cardType.toUpperCase());
		this.cvvNumber = cvvNumber;
		this.expiryDate = LocalDate.parse(expiryDate);
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	public String getCvvNumber() {
		return cvvNumber;
	}

	public void setCvvNumber(String cvvNumber) {
		this.cvvNumber = cvvNumber;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "PaymentCard [cardnumber=" + cardnumber + ", cardType=" + cardType.name() + ", cvvNumber=" + cvvNumber
				+ ", expiryDate=" + expiryDate + "]";
	}
	
	
	
}
