package model;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {
	
	
	private Account account ;
	
	private Statement statement ;
	
	
	@Before
	public void setUp() {
		statement = new Statement() ;
		account = new Account(statement);
	}

	@Test
	public void should_add_deposit_transaction_in_statement() {		
		String TODAY = "21/09/2017";
		Amount _100 = Amount.of(100) ;
		Transaction expectedTransaction = new Transaction(100, LocalDate.now(), OPTYPE.DEPOSIT);
		account.deposit(_100) ;		
		Assertions.assertThat(statement.getLastLines().optype()).isEqualTo(expectedTransaction.optype());
		Assertions.assertThat(statement.getLastLines().value()).isEqualTo(expectedTransaction.value());
		Assertions.assertThat(statement.getLastLines().dateStringyfy("dd/MM/yyyy")).isEqualTo(TODAY);

	}
	
	@Test
	public void should_have_100_as_balance_after_make_deposit() {
		Amount _100 = Amount.of(100) ;		
		account.deposit(_100) ;		
		Assertions.assertThat(account.currentBalance().value()).isEqualTo(_100.value());
	}
	
	@Test
	public void should_add_withdraw_transaction_in_statement() {
		String TODAY = "21/09/2017";
		Amount _100 = Amount.of(100) ;
		Transaction expectedTransaction = new Transaction(100, LocalDate.now(), OPTYPE.WITHDRAW);
		account.withDraw(_100) ;		
		Assertions.assertThat(statement.getLastLines().optype()).isEqualTo(expectedTransaction.optype());
		Assertions.assertThat(statement.getLastLines().value()).isEqualTo(expectedTransaction.value());
		Assertions.assertThat(statement.getLastLines().dateStringyfy("dd/MM/yyyy")).isEqualTo(TODAY);
		
	}
	
	@Test
	public void should_have_100_as_balance_after_make_withdraw() {
		Amount _100 = Amount.of(100) ;
		Amount _200 = Amount.of(200) ;		
		account.deposit(_200) ;	
		account.withDraw(_100);
		Assertions.assertThat(account.currentBalance().value()).isEqualTo(_100.value());
	}
	
	
	@Test
	public void should_have_2_transactions_in_statement() {
		Amount _200 = Amount.of(200) ;
		Amount _100 = Amount.of(100) ;
		account.deposit(_200) ;	
		account.withDraw(_100);
		Assertions.assertThat(statement.getLines().size()).isEqualTo(2);		
		
	}
	
	@Test
	public void should_print_all_transaction_in_statement() {
		String TODAY = "21/09/2017";
		StringBuilder sb = new StringBuilder();
		sb.append("|").append("100").append("|").append(TODAY).append("|").append("WITHDRAW").append("\n");
		sb.append("|").append("200").append("|").append(TODAY).append("|").append("DEPOSIT").append("\n");
		sb.append("CURRENT BALANCE : ").append("100").append("\n");

		//Given
		Amount _200 = Amount.of(200) ;
		Amount _100 = Amount.of(100) ;
		account.deposit(_200) ;	
		account.withDraw(_100);
		
		//When
		//Then
		Assertions.assertThat(account.printTransactions()).isEqualTo(sb.toString());
	}
	

}
