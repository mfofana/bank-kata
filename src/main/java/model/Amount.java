package model;

import java.text.DecimalFormat;

public class Amount {
	
	private DecimalFormat decimalFormat = new DecimalFormat("#.00");	
	
	private int value;

	public Amount(int value) {
		this.value = value;
	}
	
	public static Amount of(int value) {
		
		return new Amount(value);
	}
	
	public int value() {
		return this.value;
	}
	
	public   Amount add(Amount anotherAmount) {
		return new Amount(this.value + anotherAmount.value);
	}

	
	public String moneyRepresentation() {
		return decimalFormat.format(value);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Amount other = (Amount) obj;
		if (value != other.value)
			return false;
		return true;
	}

	public Amount minus(Amount anotherAmount) {
		// TODO Auto-generated method stub
		return new Amount(this.value - anotherAmount.value);
	}
	
	
}
