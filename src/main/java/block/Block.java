package block;
import java.util.Date;

import crypto.CryptographicAlgorithm;
import crypto.Sha256;

public class Block {
	public String hash;
	public String previousHash;
	private BlockData data;
	private long timeStamp;
	private int nonce;
	
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
				Long.toString(timeStamp) +
				Integer.toString(nonce) + 
				data.toString()
				);
		return calculatedhash;
	}
	
	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with (difficulty * "0") 
		while (!hash.substring(0, difficulty).equals(target)) {
			nonce++;
			hash = calculateHash();
		}
		System.out.println("Block Mined!!! : " + hash);
	}
	
	public BlockData getData() {
		return data;
	}
	
	public String getHash() {
		return hash;
	}
}
