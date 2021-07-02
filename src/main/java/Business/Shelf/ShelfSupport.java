package Business.Shelf;

import java.util.Comparator;

public class ShelfSupport implements Comparable<ShelfSupport> {
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

    public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public void setPositionY(int positionY) {
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


    @Override
    public int compareTo(ShelfSupport o) {
        if(o.getPositionX() > this.positionX) {
            return -1;
        }else {
            return 1;
        }
    }





}
