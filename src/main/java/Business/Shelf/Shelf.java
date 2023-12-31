package Business.Shelf;

import java.util.ArrayList;
import java.util.List;

import Business.Package.Package;

public class Shelf {
    private List<ShelfSupport> shelfSupports;
    private List<ShelfFloor> shelfFloors;
    private List<Package> allPackages;
    
 

	public Shelf(){
        this.shelfSupports = new ArrayList<ShelfSupport>();
        this.shelfFloors = new ArrayList<ShelfFloor>();
        this.allPackages = new ArrayList<Package>();
    }

    public ShelfSupport getShelfSupportByID(int id){
        for(ShelfSupport support: shelfSupports){
            if(support.getShelfSupportID() == id){
                return support;
            }
        }
        return null;
    }

    public ShelfFloor getShelfFloorByID(int id){
        for(ShelfFloor floor: shelfFloors){
            if(floor.getShelfFloorID() == id){
                return floor;
            }
        }
        return null;
    }

    public void setShelfSupports(List<ShelfSupport> shelfSupports) {
        this.shelfSupports = shelfSupports;
    }

    public void setShelfFloors(List<ShelfFloor> shelfFloors) {
        this.shelfFloors = shelfFloors;
    }

    public void addShelfFloor(ShelfFloor newShelfFloor){
        shelfFloors.add(newShelfFloor);
    }
    
    public void addShelfSupport(ShelfSupport newShelfSupport){
        shelfSupports.add(newShelfSupport);
    }
    
    public void addPackage(Package pack) {
    	
    	allPackages.add(pack);
    	
    }
    
    public void removeShelfSupport(int i) {
    	shelfSupports.remove(i);
    }

    public void removeShelfFloor(int i) {
    	shelfFloors.remove(i);
    }
    public void removePackage(int i) {
    	
    	allPackages.remove(i);
    }
    
    public void setNewShelfFloorPos(int shelfFloorID, int positionX, int positionY){
        int i=0;
        while(shelfFloors.get(i).getShelfFloorID() != shelfFloorID){
            i++;
        }
        shelfFloors.get(i).setPositionX(positionX);
        shelfFloors.get(i).setPositionY(positionY);
    }

    public ArrayList<ShelfSupport> getShelfSupports(){
        return (ArrayList<ShelfSupport>) shelfSupports;
    }

    public ArrayList<ShelfFloor> getShelfFloors(){
        return (ArrayList<ShelfFloor>) shelfFloors;
    }
    public ArrayList<Package> getAllPackages() {
 		return (ArrayList<Package>) allPackages;
 	}

    public int getLastPackageID(){
        if(allPackages.size() == 0){
            return 0;
        }
        return allPackages.get(allPackages.size()-1).getPackageID();
    }

}
