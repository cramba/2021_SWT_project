package Business.Shelf;

import Business.Package.Package;
import Business.ShelfManager.LoadCapacityException;
import Business.ShelfManager.Validator;

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
        Package p, currentP;
        //wenn Paketliste (1. ebene) leer ist
        if (packageList.size() == 0) {
            newPackage.setPositionY(positionY - newPackage.getHeight());
            packageList.add(newPackage);
            newPackage.setShelfFloorID(shelfFloorID);


            return;
        }
        //wenn das bewegende Paket sich bereits im Regalboden befindet, wird das bereits vorhandene genommen
        else {
            p = availableInPackageList(packageList, newPackage);
        }
        //deletePackageFromStaple(p.getPackageID());
//            int oldPosX = p.getPositionX();
//            int oldPosY = p.getPositionY();
//            p.setPositionX(newPackage.getPositionX());
//            p.setPositionY(newPackage.getPositionY());
//            //p = newPackage;
//            if (p.getPackagesAbove().size() != 0) {
//                Package upperPackage = p;
//                while (upperPackage.getPackagesAbove().size() != 0) {
//                    upperPackage.getPackagesAbove().get(0).setPositionX(upperPackage.getPackagesAbove().get(0).getPositionX() + (p.getPositionX() - oldPosX));
//                    //System.out.println("x: "+upperPackage.getPackagesAbove().get(0).getPositionX()+(p.getPositionX() - oldPosX));
//                    upperPackage.getPackagesAbove().get(0).setPositionY(upperPackage.getPackagesAbove().get(0).getPositionY() + (p.getPositionY() - oldPosY));
//                    upperPackage = upperPackage.getPackagesAbove().get(0);
//                }
//            }
        if (p != null) {
            currentP = p;
            //mit dem vorhandenem Paket arbeiten:
            if (!lowerPackageAvailable(currentP)) {
                int oldX, oldY, translationX, translationY;
                oldX = currentP.getPositionX();
                oldY = currentP.getPositionY();
                currentP.setPositionY(positionY - currentP.getHeight());
                translationX = currentP.getPositionX() - oldX;
                translationY = currentP.getPositionY() - oldY;
                System.out.println("transX: " + translationX + ", transY: " + translationY);
                if (currentP.getPackagesAbove().size() != 0) {
                    for (Package pck : currentP.getPackagesAbove()) {
                        pck.setPositionX(pck.getPositionX() + translationX);
                        pck.setPositionY(pck.getPositionY() + translationY);

                        while (pck.getPackagesAbove().size() != 0) {
                            Package currentPck = pck.getPackagesAbove().get(0);
                            currentPck.setPositionX(currentPck.getPositionX() + translationX);
                            currentPck.setPositionY(currentPck.getPositionY() + translationY);
                            pck = pck.getPackagesAbove().get(0);
                        }
                    }
                }
            } else {
                //Paket aus der aktuellen Position nehmen
                deletePackageReference(currentP.getPackageID());
                // an neuer Position plazieren
                for (int i = 0; i < packageList.size(); i++) {
                    Package lowPck = packageList.get(i);
                    if (currentP.getPositionX() + currentP.getWidth() > lowPck.getPositionX() && currentP.getPositionX() < lowPck.getPositionX() + lowPck.getWidth()) {
                        putPackageOnPackage(lowPck, currentP);
                    }
                }
            }
        } else {
            currentP = newPackage;
            if (!lowerPackageAvailable(currentP)) {
                currentP.setPositionY(positionY - currentP.getHeight());
                packageList.add(currentP);
            } else {
                for (int i = 0; i < packageList.size(); i++) {
                    Package lowPck = packageList.get(i);
                    if (currentP.getPositionX() + currentP.getWidth() > lowPck.getPositionX() && currentP.getPositionX() < lowPck.getPositionX() + lowPck.getWidth()) {
                        putPackageOnPackage(lowPck, currentP);
                        return;
                    }
                }
            }
        }

//        if (!lowerPackageAvailable(currentP)) {
//            currentP.setPositionY(positionY - currentP.getHeight());
//            if (availableInPackageList(packageList, currentP) == null) {
//                packageList.add(currentP);
//            }
//            return;
//        } else if (lowerPackageAvailable(currentP)) {
//            p = availableInPackageList(packageList, currentP);
//            if (p != null) {
//                packageList.remove(p);
//                deletePackageFromStaple(p.getPackageID());
//            }
//            for (int i = 0; i < packageList.size(); i++) {
//                Package lowPck = packageList.get(i);
//                if (currentP.getPositionX() + currentP.getWidth() > lowPck.getPositionX() && currentP.getPositionX() < lowPck.getPositionX() + lowPck.getWidth()) {
//                    if ((p = availableInPackageList(lowPck.getPackagesAbove(), currentP)) != null) {
//                        //lowPck.getPackagesAbove().remove(p);
//                        putPackageOnPackage(lowPck, p);
//                    } else {
//                        putPackageOnPackage(lowPck, currentP);
//                    }
//                    return;
//                }
//            }
    }
//        newPackage.setPositionY(positionY - newPackage.getHeight());
//        packageList.add(newPackage);
//    }

    public void deletePackageReference(int pckID) {
        List<Package> list;
        list = packageList;
        Package currentPck;
        for (Package pck : list) {
            if (pck.getPackageID() == pckID) {
                list.remove(pck);
                return;
            }
            while (pck.getPackagesAbove().size() != 0) {
                currentPck = pck.getPackagesAbove().get(0);
                if (currentPck.getPackageID() == pckID) {
                    pck.getPackagesAbove().remove(currentPck);
                    return;
                }
                pck = pck.getPackagesAbove().get(0);
            }
        }
    }

    public Package availableInPackageList(List<Package> pckList, Package pck) {

        Package pckFound = null;
        if (pckList.size() != 0) {
            for (Package p : pckList) {
                if (p.getPackageID() == pck.getPackageID()) {
                    return p;
                }
            }
            for (Package p : pckList) {
                if ((pckFound = availableInPackageList(p.getPackagesAbove(), pck)) != null) {
                    return pckFound;
                }
            }
        }
        return null;
    }

    public boolean lowerPackageAvailable(Package newPackage) {
        for (int i = 0; i < packageList.size(); i++) {
            Package lowerPack = packageList.get(i);
            if (lowerPack.getPackageID() != newPackage.getPackageID()) {
                if (newPackage.getPositionX() < lowerPack.getPositionX() + lowerPack.getWidth()
                        && newPackage.getPositionX() + newPackage.getWidth() > lowerPack.getPositionX()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void putPackageOnPackage2(Package lowerPck, Package newPackage) {
        //2. Durchgang: lower - blau, newPackage - rot,
        // im zweiten Durchgang: Blau - Liste: pckList (size: 1)
        List<Package> pckList = lowerPck.getPackagesAbove();

        if (pckList.size() == 0 && lowerPck.getPackageID() != newPackage.getPackageID()) {
            newPackage.setPositionY(lowerPck.getPositionY() - newPackage.getHeight());
            pckList.add(newPackage);
            newPackage.setShelfFloorID(shelfFloorID);
            System.out.println("Paket wird gestapelt");
            return;
        } else {
            for (int i = 0; i < pckList.size(); i++) { //2. Durchgang: pckList[1. Stelle] = rotes Paket == newPackage
                Package lowPck = pckList.get(i);
                if (lowPck.getPackageID() != newPackage.getPackageID()) {
                    if (newPackage.getPositionX() + newPackage.getWidth() > lowPck.getPositionX() && newPackage.getPositionX() < lowPck.getPositionX() + lowPck.getWidth()) {
                        putPackageOnPackage(lowPck, newPackage);
                        return;
                    }
                } else {
                    lowPck.setPositionY(lowerPck.getPositionY() - lowPck.getHeight());
                    return;
                }
            }
        }
    }

    public void putPackageOnPackage(Package lowerPck, Package newPackage) {
        int oldPosX = newPackage.getPositionX();
        int oldPosY = newPackage.getPositionY();
        if (lowerPck.getPackageID() == newPackage.getPackageID()) {
            return;
        }
        if (lowerPck.getPackagesAbove().size() != 0) {
            while (lowerPck.getPackagesAbove().size() != 0) {
                lowerPck = lowerPck.getPackagesAbove().get(0);
            }
        }
        newPackage.setPositionY(lowerPck.getPositionY() - newPackage.getHeight());
        int translationX = newPackage.getPositionX() - oldPosX;
        int translationY = newPackage.getPositionY() - oldPosY;

        if (newPackage.getPackagesAbove().size() != 0) {
            for (Package p : newPackage.getPackagesAbove()) {
                p.setPositionX(p.getPositionX() + translationX);
                p.setPositionY(p.getPositionY() + translationY);

                while (p.getPackagesAbove().size() != 0) {
                    Package currentPck = p.getPackagesAbove().get(0);
                    currentPck.setPositionX(p.getPositionX() + translationX);
                    currentPck.setPositionY(p.getPositionY() + translationY);
                    p = p.getPackagesAbove().get(0);
                }
            }
        }


        try {
            lowerPck.getPackagesAbove().add(newPackage);
            Validator.checkLoadCapacityOld((ArrayList<Package>) lowerPck.getPackagesAbove(), this.getLoadCapacity());
        } catch (LoadCapacityException e) {
            e.printStackTrace();
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

    public void deletePackageFromStaple(int id) {
        //äüßerste Schleife durchläuft alle untersten Pakete
        for (Package pck : packageList) {
            Package curPck = pck;
            while (curPck.getPackagesAbove().size() != 0) {
                //falls das unterste Paket gelöscht wird
                if (curPck.getPackageID() == id) {
                    packageList.add(curPck.getPackagesAbove().get(0));
                    packageList.remove(curPck);
                    return;
                } else if (curPck.getPackagesAbove().get(0).getPackageID() == id) {
                    //remove Package
                    //falls das zu löschende Paket das oberste war muss kein neues eingetragen werden
                    if (curPck.getPackagesAbove().get(0).getPackagesAbove().size() == 0) {
                        curPck.getPackagesAbove().remove(0);
                    } else {
                        //falls das zu löschende Paket ein zwischenpaket war muss die Referenz auf das PackageAbove
                        //vom zu löschenden Paket gesetzt werden
                        Package newReferenz = curPck.getPackagesAbove().get(0).getPackagesAbove().get(0);
                        curPck.getPackagesAbove().remove(0);
                        curPck.getPackagesAbove().add(newReferenz);

                        return;
                    }
                    return;
                }
                curPck = curPck.getPackagesAbove().get(0);
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

