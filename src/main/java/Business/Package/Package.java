package Business.Package;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Package {
    private String name;
    private int height;
    private int width;
    private float weight;
    private Color colour;
    private int positionX;
    private int positionY;
    private float loadCapacity;
    private List<Color> incompatibility;
    private List<Package> packagesAbove;

    public void setColour(Color colour) {
        this.colour = colour;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setIncompatibility(List<Color> incompatibility) {
        this.incompatibility = incompatibility;
    }

    public void setPackagesAbove(List<Package> packagesAbove) {
        this.packagesAbove = packagesAbove;
    }

    public Package(String name, int height, int width, float weight, Color colour, float loadCapacity){
    	//List<Color> incompatibility
        this.name = name;
        this.height = height;
        this.width = width;
        this.weight = weight;
        this.colour = colour;
        this.loadCapacity = loadCapacity;
        this.positionX = 0;
        this.positionY = 0;
        this.incompatibility = new ArrayList<>();
        this.packagesAbove = new ArrayList<>();
    }

    public String getName() {
    	return name;
    }
    
    public String getSpecification() {
    	String spec = height + " x " + width + "  " + weight + "kg";
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
    
    public int getPositionX() {
        return positionX;
    }
    
    public int getPositionY() {
        return positionY;
    }
}
