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





	public ShelfView(){
    	shelfSupports = new ArrayList<Rectangle>();
    	shelfFloors = new ArrayList<Rectangle>();

    	
    	
    	this.setBorder(new Border(new BorderStroke(Color.BLACK, 
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    	
    	
    	

    }
	
    public ArrayList<Rectangle> getShelfSupports() {
		return shelfSupports;
	}
	
    public ArrayList<Rectangle> getShelfFloors() {
		return shelfFloors;
	}
}
