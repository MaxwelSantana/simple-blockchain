package block;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BlockChainTests {
	
	@Test
	void Shoud_True_When_ThereIsACorrectChain() {
		BlockChain blockChain = new BlockChain();
		
		blockChain.mineAndAdd(new Block(new BlockData("Hi im the First block"), 
				blockChain.previousHash()));
		blockChain.mineAndAdd(new Block(new BlockData("Hi im the Second block"), 
				blockChain.previousHash()));
		
		assertTrue(blockChain.isChainValid());
	}
	
	@Test
	void Should_False_When_AnyBlockInBlockChainChanges() {
		BlockChain blockChain = new BlockChain();
		Block firstBlock = new Block(new BlockData("Hi im the First block"), 
				blockChain.previousHash());
		
		blockChain.mineAndAdd(firstBlock);
		blockChain.mineAndAdd(new Block(new BlockData("Hi im the Second block"), 
				blockChain.previousHash()));
		
		firstBlock.hash = new Block(new BlockData("Other hash"), "05").hash;
		
		assertFalse(blockChain.isChainValid());
	}
}
