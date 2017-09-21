package model;

import java.time.LocalDate;

public class Account {
	
	private Statement statement ;
	
	private Amount balance = Amount.of(0);
	
	public Account(Statement statement) {
		
		this.statement = statement;
	}
	
	public Amount currentBalance() {
		return balance ;
	}
	
	
	public void deposit(Amount amount) {		
		depositUpdateBalance(amount);		
		Transaction deposit = new Transaction(amount.value(), LocalDate.now(),OPTYPE.DEPOSIT);
		statement.getLines().add(0,deposit);		
		
	}

	private void depositUpdateBalance(Amount amount) {
		balance=balance.add(amount);
	}

	public void withDraw(Amount amount) {
		withDrawUpdateBalance(amount);		
		Transaction withDraw = new Transaction(amount.value(), LocalDate.now(),OPTYPE.WITHDRAW);
		statement.getLines().add(0,withDraw);		

		
	}

	private void withDrawUpdateBalance(Amount amount) {
		this.balance = balance.minus(amount);

	}

	public String printTransactions() {
		StringBuilder sb = new StringBuilder() ;
		this.statement.getLines().stream().forEach(transaction -> sb.append("|")
			  .append(transaction.value()).append("|")
			  .append(transaction.dateStringyfy("dd/MM/yyyy"))
			  .append("|")
			  .append(transaction.optype()).append("\n"));
		
		sb.append("CURRENT BALANCE : ").append(this.currentBalance().value()).append("\n");
		return sb.toString();
	}

}
