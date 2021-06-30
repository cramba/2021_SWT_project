package Business.ShelfManager;

import Business.Package.Colour;
import Business.Package.Package;
import Business.Shelf.Shelf;
import Business.Shelf.ShelfFloor;
import Business.Shelf.ShelfSupport;
import javafx.beans.property.SimpleObjectProperty;

import java.util.List;
import java.util.ArrayList;

public class ShelfManager {

    Shelf shelf;
    Object tray;
    ArrayList<Package> packageTemplate;
	SimpleObjectProperty<ShelfSupport> shelfSupportProp;

    public ShelfManager() {

        shelf = new Shelf();
        tray = new Object();
        packageTemplate = new ArrayList<Package>();
        shelfSupportProp = new SimpleObjectProperty<ShelfSupport>() ;
        
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

    public void addShelfSupport(int length, int positionX) {
    	
    	
    	int random = (int)((Math.random()) * 1000 + 1) ; 
    	ShelfSupport shelfSupport = new ShelfSupport(random, length, positionX,0); //position noch unklar
    	
    	
    	shelf.addShelfSupport(shelfSupport);
    	shelfSupportProp.setValue(shelfSupport);
    

    }

    public void deleteShelfSupport(int index) {
    	
    	shelf.removeShelfSupport(index);
    	

    }

    public void addShelfFloor(float loadCapacity) {

    }

    public void deleteShelfFloor(ShelfFloor shelFloor) {

    }
    
    public ArrayList<Package> getTemplateList(){
    	return packageTemplate;
    }
    
    public SimpleObjectProperty<ShelfSupport> getShelfSupportProp() {
		return shelfSupportProp;
	}

}

