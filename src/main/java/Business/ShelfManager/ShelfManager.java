package Business.ShelfManager;

import Business.Package.Colour;
import Business.Package.Package;
import Business.Shelf.Shelf;
import Business.Shelf.ShelfFloor;
import Business.Shelf.ShelfSupport;

import java.util.List;
import java.util.ArrayList;

public class ShelfManager {

    Shelf shelf;
    Object tray;
    ArrayList<Package> packageTemplate;

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

    public ShelfManager() {

        shelf = new Shelf();
        tray = new Object();
        packageTemplate = new ArrayList<Package>();
        
        packageTemplate.add(new Package("Testpaket", 40, 40, 3.5f));
        packageTemplate.add(new Package("Kleines Paket", 20, 10, 1.5f));
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

    public Shelf getShelf() {
        return shelf;
    }

    public Object getTray() {
        return tray;
    }

    public ArrayList<Package> getPackageTemplate() {
        return packageTemplate;
    }

    public void addShelfSupport(int length) {
    	
    	int random = (int)((Math.random()) * 1000 + 1) ; 
    	ShelfSupport shelfSupport = new ShelfSupport(random, length, 0,0); //position noch unklar
    	
    	
    	shelf.addShelfSupport(shelfSupport);

    }

    public void deleteShelfSupport(ShelfSupport shelfSupport) {

    }

    public void addShelfFloor(float loadCapacity) {

    }

    public void deleteShelfFloor(ShelfFloor shelFloor) {

    }
    
    public ArrayList<Package> getTemplateList(){
    	return packageTemplate;
    }

}

