package GUI;

import java.util.ArrayList;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ShelfView extends AnchorPane {
	
	private ArrayList<Rectangle> shelfSupports;
	private ArrayList<Rectangle> shelfFloors;
	private ArrayList<Rectangle> allPackages;

	public ShelfView(){
    	shelfSupports = new ArrayList<Rectangle>();
    	shelfFloors = new ArrayList<Rectangle>();
    	allPackages = new ArrayList<Rectangle>();

    	this.setMinSize(900, 620);
    	this.setMaxSize(900, 620);
    	
    	this.setBorder(new Border(new BorderStroke(Color.BLACK, 
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

    }
	
    public ArrayList<Rectangle> getShelfSupports() {
		return shelfSupports;
	}
	
    public ArrayList<Rectangle> getShelfFloors() {
		return shelfFloors;
	}
    
    public ArrayList<Rectangle> getAllPackages() {
 		return allPackages;
 	}
}
