package Business.ShelfManager;

import Business.Package.Colour;
import Business.Shelf.Shelf;
import Business.Shelf.ShelfFloor;
import Business.Shelf.ShelfSupport;

import java.util.List;
import java.util.ArrayList;

public class ShelfManager {

    Shelf shelf;
    Object tray;
    List<Package> packageTemplate;

    public ShelfManager() {

        shelf = new Shelf();
        tray = new Object();
        packageTemplate = new ArrayList<Package>();
    }

    public void movePackage(Package pck, int positionX, int positionY) {


    }

    public void moveShelfSupport(ShelfSupport shelfsupport, int positionX, int positionY) {

    }

    public void moveShelfFloor(ShelfFloor shelffloor, int positionX, int positionY) {

        shelf.setNewShelfFloorPos(shelffloor.getShelfFloorID(), positionX, positionY);

    }

    public void createPackage(String name, int weight, int loadCapacity, int length, int width, Colour colour, List<Colour> incompatibility) {

    }

    public void addPackageTemplate(String name, int weight, int loadCapacity, int length, int width, Colour colour, List<Colour> incompatibility) {

    }

    public void deletePackage(Package pck) {

    }

    public void addShelfSupport(int length) {

    }

    public void deleteShelfSupport(ShelfSupport shelfSupport) {

    }

    public void addShelfFloor(float loadCapacity) {

    }

    public void deleteShelfFloor(ShelfFloor shelFloor) {

    }

}

