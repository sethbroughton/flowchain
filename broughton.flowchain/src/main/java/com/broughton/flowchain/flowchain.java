package com.broughton.flowchain;

import java.util.ArrayList;
import com.google.gson.*;

public class flowchain {

	public static ArrayList<Block> blockchain = new ArrayList<Block>();

	public static void main(String[] args) {

		blockchain.add(new Block("The first block", "0"));
		blockchain.add(new Block("The second block", blockchain.get(blockchain.size() - 1).hash));
		blockchain.add(new Block("The third block", blockchain.get(blockchain.size() - 1).hash));

		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.print(blockchainJson);
	}

	public static boolean isValid() {
		Block previousBlock;
		Block currentBlock;

		for (int i = 1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);

			if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
				return false;
			}
			if(!previousBlock.hash.equals(currentBlock.previousHash)) {
				return false;	
			}
		}
		return true;
	}
}
