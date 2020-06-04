package block;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import builder.BlockBuilder;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BlockChainTests {

	private final BlockBuilder builder = new BlockBuilder();
	
	@Test
	void Shoud_True_When_ThereIsACorrectChain() {
		List<Block> blockchainList = builder
				.newBlock()
				.newBlock()
				.buildAll();
		
		BlockChain blockChain = new BlockChain(blockchainList);
		assertTrue(blockChain.isChainValid());
	}
	
	@Test
	void Should_False_When_PreviousHashIsOutOfChain() {
		List<Block> blockchainList = builder
				.newBlock()
				.buildAll();
		
		Block blockOutOfChain = new Block(new BlockData("Yo im the second block"), 
				blockchainList.get(blockchainList.size() - 1).hash);
		blockchainList.add(new Block(new BlockData("Yo im the second block"), blockOutOfChain.hash));
		
		BlockChain blockChain = new BlockChain(blockchainList);
		assertFalse(blockChain.isChainValid());
	}
	
	@Test
	void Should_False_When_AnyBlockInBlockChainChanges() {
		List<Block> blockchainList = builder
				.newBlock()
				.newBlock()
				.buildAll();
		
		BlockChain blockChain = new BlockChain(blockchainList);
		blockchainList.get(0).hash = new Block(new BlockData("Other hash"), "0").hash;
		
		assertFalse(blockChain.isChainValid());
	}
}
