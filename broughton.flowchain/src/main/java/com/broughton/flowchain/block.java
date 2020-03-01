package com.broughton.flowchain;
import java.util.Date;


public class block {
	
	public String hash;
	public String previousHash;
	private String data;
	private long timeStamp;
	
	//Constructor
	public block(String data, String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		
	}

}
