package Business.Package;

import java.util.ArrayList;
import java.util.List;

public class Package {
    private String name;
    private int height;
    private int width;
    private float weight;
    private Colour colour;
    private int positionX;
    private int positionY;
    private List<Colour> incompatibility;

    public Package(String name, int height, int width, float weight, Colour colour, int positionX, int positionY, List<Colour> incompatibility){
        this.name = name;
        this.height = height;
        this.width = width;
        this.weight = weight;
        this.colour = colour;
        this.positionX = positionX;
        this.positionY = positionY;
        this.incompatibility = incompatibility;
    }

    public List<Colour> getIncompatibility(){
        return incompatibility;
    }

    public Colour getColour(){
        return colour;
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
