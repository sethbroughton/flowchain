package com.broughton.flowchain;

import java.util.ArrayList;
import com.google.gson.*;

public class flowchain {

	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	public static int difficulty = 5;

	public static void main(String[] args) {

		blockchain.add(new Block("The first block", "0"));
		System.out.println("Trying to mine block 1...");
		blockchain.get(0).mineBlock(difficulty);
		
		
		blockchain.add(new Block("The second block", blockchain.get(blockchain.size() - 1).hash));
		System.out.println("Trying to mine block 2...");
		blockchain.get(1).mineBlock(difficulty);
		
		blockchain.add(new Block("The third block", blockchain.get(blockchain.size() - 1).hash));
		System.out.println("Trying to mine block 3...");
		blockchain.get(2).mineBlock(difficulty);

		System.out.println("\nBlockchain is Valid: " + isValid());
		
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.print(blockchainJson);
	}

	public static boolean isValid() {
		Block previousBlock;
		Block currentBlock;
		
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');

		for (int i = 1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);

			if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
				return false;
			}
			if(!previousBlock.hash.equals(currentBlock.previousHash)) {
				return false;	
			}
			
			if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) {
				System.out.println("This block hasn't been mined");
				return false;
			}
		}
		return true;
	}
}
