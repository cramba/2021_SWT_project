package Business.Shelf;
import Business.Package.Package;
import java.util.ArrayList;
import java.util.List;

public class ShelfFloor {
    private int shelfFloorID;
    private int width;
    private float loadCapacity;
    private int positionX;
    private int positionY;
    List<Package> packageList;
    private int height;

    private int id_nr = 0;



    public ShelfFloor(int width, float loadCapacity, int posX, int posY){
        this.shelfFloorID = id_nr;
        this.width = width;
        this.loadCapacity = loadCapacity;
        this.positionX = posX;
        this. positionY = posY;
        this.packageList = new ArrayList<>();
        id_nr++;
    }

    public void addPackage(Package newPackage){
        packageList.add(newPackage);
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY){
        this.positionY = positionY;
    }

    public int getShelfFloorID() {
        return shelfFloorID;
    }

    public int getWidth() {
        return width;
    }

    public float getLoadCapacity() {
        return loadCapacity;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public List<Package> getPackageList() {
        return packageList;
    }

    public int getHeight() {
        return height;
    }
}
