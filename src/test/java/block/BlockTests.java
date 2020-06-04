package block;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.google.gson.GsonBuilder;

public class BlockTests {

	@Test
	void createBlocks() {
		List<Block> blockchain = new ArrayList<Block>();
		
		blockchain.add(new Block(new BlockData("Hi im the first block"), "0"));
		blockchain.add(new Block(new BlockData("Yo im the second block"),
				blockchain.get(blockchain.size()-1).hash));
		blockchain.add(new Block(new BlockData("Hey im the third block"),
				blockchain.get(blockchain.size()-1).hash));
		
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);		
		System.out.println(blockchainJson);
	}
}
