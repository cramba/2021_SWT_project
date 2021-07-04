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
        Package p;
        //wenn Paketliste (1. ebene) leer ist
        if (packageList.size() == 0) {
            newPackage.setPositionY(positionY - newPackage.getHeight());
            packageList.add(newPackage);
            newPackage.setShelfFloorID(shelfFloorID);
            return;
        }
        //wenn das bewegende Paket sich bereits im Regalboden befindet, wird das bereits vorhandene genommen
        else if ((p = availableInPackageList(packageList, newPackage)) != null) {
            //p.setPositionY(positionY - p.getHeight());
            p.setPositionX(newPackage.getPositionX());
            p.setPositionY(newPackage.getPositionY());
            newPackage = p;
        }
        if(!lowerPackageAvailable(newPackage)){
            newPackage.setPositionY(positionY - newPackage.getHeight());
            if(availableInPackageList(packageList, newPackage) == null){
                packageList.add(newPackage);
            }
            return;
        }else if (lowerPackageAvailable(newPackage)) {
            for (int i = 0; i < packageList.size(); i++) {
                Package lowPck = packageList.get(i);
                if (newPackage.getPositionX() + newPackage.getWidth() > lowPck.getPositionX() && newPackage.getPositionX() < lowPck.getPositionX() + lowPck.getWidth()) {
                    putPackageOnPackage(lowPck, newPackage);
                    return;
                }
            }
        }
//        newPackage.setPositionY(positionY - newPackage.getHeight());
//        packageList.add(newPackage);
    }

    public Package availableInPackageList(List<Package> pckList, Package pck) {
//        for (Package p: pckList) {
//            if (p.getPackageID() == pck.getPackageID()) {
//                return p;
//            }
//        }
        Package pckFound = null;
        if(pckList.size() != 0){
            for (Package p : pckList) {
                if (p.getPackageID() == pck.getPackageID()) {
                    return p;
                }
            }

            for(Package p: pckList){
                if((pckFound = availableInPackageList(p.getPackagesAbove(), pck)) != null){
                    return pckFound;
                }
            }
        }
        return null;
    }

    public boolean lowerPackageAvailable(Package newPackage) {
        for (int i = 0; i < packageList.size(); i++) {
            Package lowerPack = packageList.get(i);
            if(lowerPack.getPackageID() != newPackage.getPackageID()){
                if (newPackage.getPositionX() < lowerPack.getPositionX() + lowerPack.getWidth()
                        && newPackage.getPositionX() + newPackage.getWidth() > lowerPack.getPositionX()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void putPackageOnPackage(Package lowerPck, Package newPackage) {
        List<Package> pckList = lowerPck.getPackagesAbove();

        if (pckList.size() == 0 /*|| !lowerPackageAvailable(newPackage)*/) {
            newPackage.setPositionY(lowerPck.getPositionY() - newPackage.getHeight());
            pckList.add(newPackage);
            newPackage.setShelfFloorID(shelfFloorID);
            System.out.println("Paket wird gestapelt");
            return;
        } /*else if (lowerPck == newPackage) {
            lowerPck.setPositionY(lowerPck.getPositionY() - newPackage.getHeight());
            newPackage.setShelfFloorID(shelfFloorID);
            return;
        }*/ else {
            for (int i = 0; i < pckList.size(); i++) {
                Package lowPck = pckList.get(i);
                if(lowPck.getPackageID() != newPackage.getPackageID()){
                    if (newPackage.getPositionX() + newPackage.getWidth() > lowPck.getPositionX() && newPackage.getPositionX() < lowPck.getPositionX() + lowPck.getWidth()) {
                        putPackageOnPackage(lowPck, newPackage);
                        return;
                    }
                }
            }
        }
    }

    public void removePackage(List<Package> pckList, int pckID) {
        for (int i = 0; i < pckList.size(); i++) {
            if (pckList.get(i).getPackageID() == pckID) {
                pckList.remove(pckList.get(i));
                System.out.println("Paket wurde aus dem alten Boden entfernt");
                return;
            } else {
                removePackage(pckList.get(i).getPackagesAbove(), pckID);
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

