package Business.Shelf;

import Business.Package.Package;

import java.util.ArrayList;
import java.util.List;

public class ShelfFloor implements Comparable<ShelfFloor> {
    private int shelfFloorID;
    private int width;
    private float loadCapacity;
    private int positionX;
    private int positionY;
    List<Package> packageList;
    private int height;


    public ShelfFloor(int id_nr, int width, float loadCapacity, int posX, int posY) {
        this.shelfFloorID = id_nr;
        this.width = width;
        this.loadCapacity = loadCapacity;
        this.positionX = posX;
        this.positionY = posY;
        this.packageList = new ArrayList<>();

    }

    public void addPackage(Package newPackage) {
        if (packageList.size() == 0 || !lowerPackageAvailable(newPackage)) {
            newPackage.setPositionY(positionY);
            packageList.add(newPackage);
            return;
        } else {
            for (int i = 0; i < packageList.size(); i++) {
                Package lowPck = packageList.get(i);
                if (newPackage.getPositionX() + newPackage.getWidth() > lowPck.getPositionX() && newPackage.getPositionX() < lowPck.getPositionX() + lowPck.getWidth()) {

                    putPackageOnPackage(lowPck, newPackage);

                    return;
                }
            }
        }
        newPackage.setPositionY(positionY - newPackage.getHeight());
        packageList.add(newPackage);
    }

    public boolean availableInPackageList(Package pck) {
        for (Package p : packageList) {
            if (p == pck) {
                return true;
            }
        }
        return false;
    }

    public boolean lowerPackageAvailable(Package newPackage) {
        for (int i = 0; i < packageList.size(); i++) {
            Package lowerPack = packageList.get(i);
            if (newPackage.getPositionX() > lowerPack.getPositionX() + lowerPack.getWidth()
                    && newPackage.getPositionX() + newPackage.getWidth() < lowerPack.getPositionX()) {
                return false;
            }
        }
        return true;
    }


    public void putPackageOnPackage(Package lowerPck, Package newPackage) {
        List<Package> pckList = lowerPck.getPackagesAbove();
        if(lowerPck != newPackage){
            if (pckList.size() == 0) {
                newPackage.setPositionY(lowerPck.getPositionY() + newPackage.getHeight());
                pckList.add(newPackage);
            } else {
                for (int i = 0; i < pckList.size(); i++) {
                    if (newPackage.getPositionX() + newPackage.getWidth() > pckList.get(i).getPositionX() && newPackage.getPositionX() < pckList.get(i).getPositionX() + pckList.get(i).getWidth()) {
                        System.out.println("i: " + i + " Size: " + pckList.size());
                        putPackageOnPackage(pckList.get(i), newPackage);
                        return;
                    }
                }
            }
        }
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;

    }

    public void setPositionY(int positionY) {
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

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int compareTo(ShelfFloor o) {
        if (this.getPositionY() < o.getPositionY()) {
            return -1;
        } else if (this.getPositionY() == o.getPositionY() && this.positionX <= o.getPositionX()) {
            return -1;
        } else {
            return 1;
        }
    }
}

