package GUI;


import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



public class TrayView extends StackPane{
	
	Rectangle r,rectTarget ; 
	StackPane group;
	Button button;
    public TrayView(){
    	
    	 r = new Rectangle(50,50,100,100);
    	 //rectTarget = new Rectangle(150, 150, 100, 100);
    	 button = new Button();
    	
    	r.setFill(Color.RED);
    	
    	this.setPrefHeight(200);
    	this.setPrefWidth(200);
    	this.setBorder(new Border(new BorderStroke(Color.BLACK, 
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    	
    	
    	this.getChildren().addAll(r);
       	
        
    }
    
    public Rectangle getRectangle() {
    	return r;
    }
    public Rectangle getRectTarget() {
    	return rectTarget;
    }
    public Button getButton() {
    	return button;
    }
}
