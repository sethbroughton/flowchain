package com.broughton.flowchain;

import org.junit.*;

public class BlockTest {
	
	@Test
	public void calculate_Hash_Test() {
		Block block = new Block("First", "0");
		Assert.assertEquals(block.hash, block.calculateHash());		
	}
	
	@Test
	public void calculate_previous_hash_Test() {
		Block block = new Block("First", "0");
		Block nextBlock = new Block("Second",block.hash);
		Assert.assertEquals(block.hash, nextBlock.previousHash);
	}
	

}
