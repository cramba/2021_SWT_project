package Business.ShelfManager;

import Business.Package.Colour;
import Business.Package.Package;
import Business.Shelf.Shelf;
import Business.Shelf.ShelfFloor;
import Business.Shelf.ShelfSupport;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class ShelfManager {

    Shelf shelf;
    Object tray;
    ArrayList<Package> packageTemplate;
    SimpleObjectProperty<ShelfSupport> shelfSupportProp;
    SimpleObjectProperty<ShelfFloor> shelfFloorProp;
    SimpleObjectProperty<Package> packageProp;
    private SimpleBooleanProperty newTemplateProp;
    private int shelfSupportId = 0;
    private int shelfFloorId = 0;

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

    public ShelfManager() {

        shelf = new Shelf();
        tray = new Object();
        packageTemplate = new ArrayList<Package>();
        shelfSupportProp = new SimpleObjectProperty<ShelfSupport>();
        shelfFloorProp = new SimpleObjectProperty<ShelfFloor>();
        packageProp = new SimpleObjectProperty<Package>();
        newTemplateProp = new SimpleBooleanProperty(false);
        packageTemplate.add(new Package("Testpaket", 40, 40, 3.5f, Color.BLACK, 6.7f));
        //packageTemplate.add(new Package("Kleines Paket", 20, 10, 1.5f));
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


        //int random = (int) ((Math.random()) * 1000 + 1);


        shelfSupportId = shelfSupportId + 1;
        ShelfSupport shelfSupport = new ShelfSupport(shelfSupportId, length, positionX, 0); //position noch unklar


        shelf.addShelfSupport(shelfSupport);
        shelfSupportProp.setValue(shelfSupport);


    }

    public void deleteShelfSupport(int index) {

        shelf.removeShelfSupport(index);


    }

    public void addShelfFloor(float loadCapacity) {

        shelfFloorId = shelfFloorId + 1;
        ShelfFloor shelfFloor = new ShelfFloor(shelfFloorId, 100, loadCapacity, 0, 0); //obligatorische Werte
        shelf.addShelfFloor(shelfFloor);
        shelfFloorProp.setValue(shelfFloor);

    }

    public void deleteShelfFloor(int index) {

        shelf.removeShelfFloor(index);

    }

    public void checkShelfSupports(ShelfFloor shelfFloor, int viewHeight) {
        ArrayList<ShelfSupport> sortedShelfSupports = new ArrayList<>(shelf.getShelfSupports());
        Collections.sort(sortedShelfSupports);
        if (shelfFloor.getPositionX() < sortedShelfSupports.get(0).getPositionX()) {
            System.out.println("Regalboden links von der ersten Stuetze, d.h. außerhalb des Regals");
            return;
        }else if(shelfFloor.getPositionX() > sortedShelfSupports.get(sortedShelfSupports.size()-1).getPositionX()){
            System.out.println("Regalboden rechts von der letzten Stuetze, d.h. ausserhalb des Regals");
            return;
        }
        for (int i = 1; i < sortedShelfSupports.size(); i++) {
            if (shelfFloor.getPositionX() < sortedShelfSupports.get(i).getPositionX()) {
                ShelfSupport support_left = shelf.getShelfSupportByID(sortedShelfSupports.get(i - 1).getShelfSupportID());
                ShelfSupport support_right = shelf.getShelfSupportByID(sortedShelfSupports.get(i).getShelfSupportID());
                shelfFloor.setPositionX(support_left.getPositionX());
                //eventuell posY aendern
                shelfFloor.setWidth(support_right.getPositionX() - support_left.getPositionX());

                if (shelfFloor.getPositionY() < viewHeight - support_left.getLength() || shelfFloor.getPositionY() < viewHeight - support_right.getLength()) {
                    if (support_left.getLength() <= support_right.getLength()) {
                        shelfFloor.setPositionY(viewHeight - support_left.getLength());
                    }else{
                        shelfFloor.setPositionY(viewHeight - support_right.getLength());
                    }
                }
                System.out.println("sollte einrasten");
                return;
            }
        }
    }

    public void addPackageTemplate(Package pck) {
        packageTemplate.add(pck);
//    	for(Package p : packageTemplate) {
//    		System.out.println(p);
//    	}
    }
    
    public void removePackageTemplate(Package pck) {
    	packageTemplate.remove(pck);
    }

    public ArrayList<Package> getTemplateList() {
        return packageTemplate;
    }

    public SimpleObjectProperty<ShelfSupport> getShelfSupportProp() {
        return shelfSupportProp;
    }

    public SimpleObjectProperty<ShelfFloor> getShelfFloorProp() {
        return shelfFloorProp;
    }

    public SimpleBooleanProperty newTemplateProp() {
        return newTemplateProp;
    }

    public SimpleObjectProperty<Package> packageProp() {
        return packageProp;
    }

    public Shelf getShelf() {
        return shelf;
    }

}

