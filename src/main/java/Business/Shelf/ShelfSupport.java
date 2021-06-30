package Business.Shelf;

public class ShelfSupport {


	private int shelfSupportID;
    private int length;
    private int positionX;
    private int positionY;
    
    public ShelfSupport(int shelfSupportID, int length, int positionX, int positionY) {
        this.shelfSupportID = shelfSupportID;
        this.length = length;
        this.positionX = positionX;
        this.positionY = positionY;
    }
    
    public int getShelfSupportID() {
		return shelfSupportID;
	}

	public int getLength() {
		return length;
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}
}
