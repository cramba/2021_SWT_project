package Business.ShelfManager;

import Business.Package.Colour;
import Business.Package.Package;
import Business.Shelf.Shelf;
import Business.Shelf.ShelfFloor;
import Business.Shelf.ShelfSupport;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.paint.Color;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class ShelfManager {

    Shelf shelf;
    Package trayPackage;
    ArrayList<Package> packageTemplate;
    SimpleObjectProperty<ShelfSupport> shelfSupportProp;
    SimpleObjectProperty<ShelfFloor> shelfFloorProp;
    SimpleObjectProperty<Package> packageTrayProp;
    SimpleObjectProperty<Package> packageProp;
    private SimpleBooleanProperty newTemplateProp;
    private int shelfSupportId = 0;
    private int shelfFloorId = 0;
    private int lastPosX = 0;
    private int lastPosY = 0;
    private SimpleStringProperty errorMessage;

    SimpleStringProperty packageInformationProp;


    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

    public ShelfManager() {

        shelf = new Shelf();

        packageTemplate = new ArrayList<Package>();
        shelfSupportProp = new SimpleObjectProperty<ShelfSupport>();
        shelfFloorProp = new SimpleObjectProperty<ShelfFloor>();
        packageTrayProp = new SimpleObjectProperty<Package>();
        packageProp = new SimpleObjectProperty<Package>();
        packageInformationProp = new SimpleStringProperty();
        newTemplateProp = new SimpleBooleanProperty(false);
        packageTemplate.add(new Package("Testpaket", 80, 120, 3.5f, Color.BLUE, 6.7f, 9999));
        packageTemplate.add(new Package("Testpaket2", 60, 100, 3.5f, Color.RED, 6.7f, 9998));
        packageTemplate.add(new Package("Testpaket3", 90, 90, 3.5f, Color.RED, 6.7f, 9997));
        //packageTemplate.add(new Package("Kleines Paket", 20, 10, 1.5f));
        errorMessage = new SimpleStringProperty();
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

    public void deletePackage(int index) {

        shelf.removePackage(index);

    }

    public void addShelfSupport(int length) {


        //int random = (int) ((Math.random()) * 1000 + 1);


        shelfSupportId = shelfSupportId + 1;
        ShelfSupport shelfSupport = new ShelfSupport(shelfSupportId, length, 0, 0); //position noch unklar


        shelf.addShelfSupport(shelfSupport);
        shelfSupportProp.setValue(shelfSupport);


    }

    public void deleteShelfSupport(int index) {

        shelf.removeShelfSupport(index);


    }

    public String getPackageInformationProp() {
        return packageInformationProp.get();
    }

    public SimpleStringProperty packageInformationPropProperty() {
        return packageInformationProp;
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

    public void addPackageToList(Package pack) {
        shelf.addPackage(pack);
        packageProp.setValue(pack);

    }

    public void checkShelfSupports(ShelfFloor shelfFloor, int viewHeight) {
        ArrayList<ShelfSupport> sortedShelfSupports = new ArrayList<>(shelf.getShelfSupports());
        Collections.sort(sortedShelfSupports);
        if (shelfFloor.getPositionX() < sortedShelfSupports.get(0).getPositionX()) {
            System.out.println("Regalboden links von der ersten Stuetze, d.h. außerhalb des Regals");
            return;
        } else if (shelfFloor.getPositionX() > sortedShelfSupports.get(sortedShelfSupports.size() - 1).getPositionX()) {
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
                    } else {
                        shelfFloor.setPositionY(viewHeight - support_right.getLength());
                    }
                }
              
                return;
            }
        }
    }

    public ShelfFloor addPackageToShelfFloor(Package pck) {

        if (pck.getPositionX() != lastPosX && pck.getPositionY() != lastPosY) {

            int pckX = pck.getPositionX();
            int pckY = pck.getPositionY();
            ArrayList<ShelfFloor> sortedShelfFloors = new ArrayList<>(shelf.getShelfFloors());
            Collections.sort(sortedShelfFloors);
            for (int i = 0; i < sortedShelfFloors.size(); i++) {
                if (pckY <= sortedShelfFloors.get(i).getPositionY()) {
                    if (pckX >= sortedShelfFloors.get(i).getPositionX() &&
                            pckX <= sortedShelfFloors.get(i).getPositionX() + sortedShelfFloors.get(i).getWidth() - pck.getWidth()) {
                        int oldFloor = pck.getShelfFloorID();
                        lastPosX = pck.getPositionX();
                        lastPosY = pck.getPositionY();
                        shelf.getShelfFloorByID(sortedShelfFloors.get(i).getShelfFloorID()).addPackage(pck);
                        try {
                            Validator.checkLoadCapacityOld((ArrayList<Package>) shelf.getShelfFloorByID(sortedShelfFloors.get(i).getShelfFloorID()).getPackageList(), shelf.getShelfFloorByID(sortedShelfFloors.get(i).getShelfFloorID()).getLoadCapacity());
                            Validator.checkCompatibility((ArrayList<Package>) shelf.getShelfFloorByID(sortedShelfFloors.get(i).getShelfFloorID()).getPackageList());
                            for(Package p: shelf.getShelfFloorByID(sortedShelfFloors.get(i).getShelfFloorID()).getPackageList()){
                                Validator.checkPackageCapacity(p);
                            }

                        } catch (LoadCapacityException e) {
                            //Nachricht setzen
                            errorMessage.setValue(e.getError());


                        } catch(CheckCompatibilityException e){
                            errorMessage.setValue(e.getError());


                        } catch (PackageCapacityException e) {
                            errorMessage.setValue(e.getError());
                        }


                        if (pck.getShelfFloorID() != oldFloor && oldFloor != 0) {
                            shelf.getShelfFloorByID(oldFloor).removePackage(shelf.getShelfFloorByID(oldFloor).getPackageList(), pck.getPackageID());
                        }
                        return shelf.getShelfFloorByID(sortedShelfFloors.get(i).getShelfFloorID());
                    }
                }
            }
            //return null, wenn kein passender Regalboen fÃ¼r das Paket gefunden wurde, wo das Paket abgesetzt werden kann

        }
        return null;
    }


    public void addPackageTemplate(Package pck) {
        packageTemplate.add(pck);
//    	for(Package p : packageTemplate) {
//    		System.out.println(p);
//    	}
    }

    public void setTrayPackage(Package pck) {
        pck.setPackageID(shelf.getLastPackageID() + 1);
        trayPackage = pck;
        packageTrayProp.setValue(trayPackage);

    }

    public void removeTrayPackage() {

        trayPackage = null;
        packageTrayProp.setValue(trayPackage);
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

    public SimpleObjectProperty<Package> packageTrayProp() {
        return packageTrayProp;
    }

    public SimpleObjectProperty<Package> packageProp() {
        return packageProp;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public String getInformationByID(int id) {
    	for(Package curPck : shelf.getAllPackages()) {
    		if(curPck.getPackageID() == id) {
    			return " " + curPck.getName() + " " + curPck.getSpecification() + " Traglast: " + String.valueOf(curPck.getLoadCapacity());
    		}
    	}
    	return null;
    }

    public SimpleStringProperty packageInformationProp() {
    	return packageInformationProp;
    }

    public SimpleStringProperty errorMesageProp(){
        return errorMessage;
    }

}

