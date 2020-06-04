package block;

import java.util.ArrayList;
import java.util.List;

public class BlockChain {
	private List<Block> blockChain = new ArrayList<Block>();

	public BlockChain(List<Block> blockChainList) {
		this.blockChain = blockChainList;
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
}
