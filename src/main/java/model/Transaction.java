package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
	

	private int value ;
		
	private LocalDate transDate;
	
	private  OPTYPE optyp ;
	
	

	public Transaction( int value, LocalDate transDate, OPTYPE optyp) {
		super();
		this.value = value;
		this.transDate = transDate;
		this.optyp = optyp;
	}


	public String dateStringyfy(String format) {
		
		return transDate.format(DateTimeFormatter.ofPattern(format));
	}
	
	public int value() {
		return this.value ;
	}
	
	public OPTYPE optype() {
		return optyp;
	}
	
	
}