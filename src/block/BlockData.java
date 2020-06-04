package block;

public class BlockData {
	private String message;

	public BlockData(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return this.message;
	}
}
