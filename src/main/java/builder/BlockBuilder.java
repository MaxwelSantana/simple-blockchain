package builder;

import java.util.ArrayList;
import java.util.List;

import block.Block;
import block.BlockData;

public class BlockBuilder {

	private List<Block> blockList = new ArrayList<Block>();

	public BlockBuilder newBlock() {
		if (blockList.isEmpty()) {
			newBlock(new BlockData("Hi im the 0 block"), "0");
		}
		Block previous = blockList.get(blockList.size() - 1);
		newBlock(new BlockData(String.format("Yo im the {0} block", blockList.size())), previous.hash);
		return this;
	}

	public BlockBuilder newBlock(BlockData blockData, String hash) {
		blockList.add(new Block(blockData, hash));
		return this;
	}

	public Block buildOne() {
		Block block = this.blockList.get(0);
		this.blockList = new ArrayList<Block>();
		return block;
	}

	public List<Block> buildAll() {
		List<Block> blockList = this.blockList;// Collections.unmodifiableList(blockList);
		this.blockList = new ArrayList<Block>();
		return blockList;
	}
}
