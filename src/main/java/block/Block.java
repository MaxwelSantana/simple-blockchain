package block;
import java.util.Date;

import crypto.CryptographicAlgorithm;
import crypto.Sha256;

public class Block {
	public String hash;
	public String previousHash;
	private BlockData data;
	private long timeStamp;
	private CryptographicAlgorithm crypt = new Sha256();
	
	public Block(BlockData data, String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash();
	}
	
	public String calculateHash() {
		String calculatedhash = crypt.apply(
				previousHash + 
				String.valueOf(timeStamp) +
				data.toString()
				);
		return calculatedhash;
	}
	
}
