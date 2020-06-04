package block;

import java.util.ArrayList;
import java.util.List;

public class BlockChain {
	private List<Block> blockChain = new ArrayList<Block>();
	private int difficulty = 2;

	public BlockChain() {}
	
	public void mineAndAdd(Block block) {
		block.mineBlock(difficulty);
		blockChain.add(block);
	}
	
	public Boolean isChainValid() {
		Block currentBlock; 
		Block previousBlock;
		
		for(int i=1;i < blockChain.size()-1;i++) {
			currentBlock = blockChain.get(i);
			previousBlock = blockChain.get(i-1);
			
			if(!currentBlock.hash.equals(currentBlock.calculateHash())) {
				System.out.println("Current Hashes not equal");			
				return false;
			}
			
			if(!previousBlock.hash.equals(currentBlock.previousHash)) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
		}
		
		return true;
	}

	public String previousHash() {
		if(blockChain.isEmpty()) return "0";
		return blockChain.get(blockChain.size() - 1).hash;
	}
}
