package com.broughton.flowchain;
import java.util.Date;


public class Block {
	
	public String hash;
	public String previousHash;
	private String data;
	private long timeStamp;
	
	//Constructor
	public Block(String data, String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash();
	}
	
	//Methods
	public String calculateHash() {
		String input = previousHash + Long.toString(timeStamp) + data;
		String calculatedHash = StringUtil.applySha256(input);
		return calculatedHash;
	}

}
