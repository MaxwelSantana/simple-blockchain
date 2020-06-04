package block;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class BlockChainTests {

	@Test
	void isChainValid() {
		List<Block> blockchainList = new ArrayList<Block>();

		blockchainList.add(new Block(new BlockData("Hi im the first block"), "0"));
		blockchainList.add(new Block(new BlockData("Yo im the second block"), 
				blockchainList.get(blockchainList.size() - 1).hash));
		
		BlockChain blockChain = new BlockChain(blockchainList);
		
		assertTrue(blockChain.isChainValid());
	}
	
	@Test
	void isChainInvalid() {
		List<Block> blockchainList = new ArrayList<Block>();
		blockchainList.add(new Block(new BlockData("Hi im the first block"), "0"));
		Block blockOutOfChain = new Block(new BlockData("Yo im the second block"), 
				blockchainList.get(blockchainList.size() - 1).hash);
		blockchainList.add(new Block(new BlockData("Yo im the second block"), blockOutOfChain.hash));
		
		BlockChain blockChain = new BlockChain(blockchainList);
		
		assertFalse(blockChain.isChainValid());
	}
}
