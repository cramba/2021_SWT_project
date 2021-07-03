package GUI;

import Business.Package.Package;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
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



public class TrayView extends AnchorPane{
	
	Rectangle r,rectTarget ; 
	StackPane group;
	Button button;
	private Package trayPackage;
	
    public TrayView(){
    	//breite x hÃ¶he
    	 r = new Rectangle();
    	 
    	 rectTarget = new Rectangle(150, 150, 100, 100);
    	 button = new Button("Packet hinzufügen");
    	
    	 AnchorPane.setBottomAnchor(button, 0.0);
    	 
    	r.setFill(Color.RED);
    	
    	this.setPrefHeight(200);
    	this.setPrefWidth(200);
    	this.setBorder(new Border(new BorderStroke(Color.BLACK, 
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    	
    	this.getChildren().addAll(button);

        
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
    
    public void setTrayPackage(Package pack) {
    	
    		trayPackage = pack;
    		//if(trayPackage == null ) {
    		int width = trayPackage.getWidth();
        	int height = trayPackage.getHeight();
        	int posWidth = (width/2)*(-1);
        	int posHeight = (height/2)*(-1);
        	r.setX(0);
        	r.setY(0);
        	r.setWidth(width);
        	r.setHeight(height);
        	r.setFill(trayPackage.getColour());
        	this.getChildren().addAll(r);
    	//}else {
    		//System.out.println("Es befindet sich bereits ein Paket in der Ablage");
    	//}
    	
    }
    public void removeTrayPackage(){
    	
    	this.getChildren().remove(r);
    	
    }
}
