package Business.Package;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Package {
	
	private int packageID;

	private String name;
    private int height;
    private int width;
    private float weight;
    private Color colour;
    private SimpleIntegerProperty positionX;
    private SimpleIntegerProperty positionY;
    private float loadCapacity;
    private List<Color> incompatibility;
    private List<Package> packagesAbove;
    private int shelfFloorID;

    public void setColour(Color colour) {
        this.colour = colour;
    }

    public void setPositionX(int positionX) {
        this.positionX.setValue(positionX);
    }

    public void setPositionY(int positionY) {
        this.positionY.setValue(positionY);
    }

    public void setIncompatibility(List<Color> incompatibility) {
        this.incompatibility = incompatibility;
    }

    public void setPackagesAbove(List<Package> packagesAbove) {
        this.packagesAbove = packagesAbove;
    }

    public Package(String name, int height, int width, float weight, Color colour, float loadCapacity, int packageID){
    	//List<Color> incompatibility
        this.name = name;
        this.height = height;
        this.width = width;
        this.weight = weight;
        this.colour = colour;
        this.loadCapacity = loadCapacity;
        positionX = new SimpleIntegerProperty(0);
        positionY = new SimpleIntegerProperty(0);
        this.incompatibility = new ArrayList<>();
        this.packagesAbove = new ArrayList<>();
        this.packageID = packageID;
        
    }

    public String getName() {
    	return name;
    }
    
    public String getSpecification() {
    	String spec = "(" + height + " x " + width + ", " + weight + "kg)";
    	return spec;
    }
    
    public List<Color> getIncompatibility(){
        return incompatibility;
    }

    public Color getColour(){
        return colour;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return width;
    }

    public List<Package> getPackagesAbove() {
        return packagesAbove;
    }

    public float getWeight(){
        return weight;
    }
    
    public float getLoadCapacity() {
    	return loadCapacity;
    }
    
    public int getPositionX() {
        return positionX.getValue();
    }
    
    public int getPositionY() {
        return positionY.getValue();
    }

    public SimpleIntegerProperty getPositionXProp(){
        return positionX;
    }

    public SimpleIntegerProperty getPositionYProp(){
        return positionY;
    }

    public int getPackageID() {
 		return packageID;
 	}

     public void setPackageID(int newID){
         packageID = newID;
     }

     public int getShelfFloorID(){
         return shelfFloorID;
     }

     public void setShelfFloorID(int floorID){
         shelfFloorID = floorID;
     }
}
