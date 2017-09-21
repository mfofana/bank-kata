package model;

import java.util.LinkedList;
import java.util.List;

public class Statement {
	
	private List<Transaction> sLines = new LinkedList<Transaction> (); 
	
	
	public List<Transaction> getLines () {
		return sLines ;
	}
	
	public Transaction getLastLines() {
		return sLines.get(0);
				
	}
	
	
	
	

}
