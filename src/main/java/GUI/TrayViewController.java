package GUI;

import java.util.ArrayList;

import Business.Package.Package;
import Business.ShelfManager.ShelfManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.Node;


public class TrayViewController extends ViewController{
	TrayView view;
	Rectangle r ;
	double xPos;
	double yPos;
	Rectangle rectTarget;
	private ArrayList<Rectangle> nodes;
	private Button button;
	private Package trayPackage; 


    public TrayViewController(ShelfManager shelfManager){
    	super(shelfManager);
    	view = new TrayView();
    	button = view.getButton();
    	r = view.getRectangle();
    	rectTarget = view.getRectTarget();
    	
        nodes = new ArrayList<Rectangle>();
        nodes.add(r);
        nodes.add(rectTarget);
    	
    	r.setCursor(Cursor.HAND);
    	root = view  ;
    	

   

        
    	initialize();
    }
    public void initialize(){
    	
    	 //r.setOnMouseDragged(event -> drag(event));

    	 shelfManager.packageTrayProp().addListener(new ChangeListener<Package>() {

    			@Override
    			public void changed(ObservableValue<? extends Package> observable, Package oldValue, Package newValue) {
    				// TODO Auto-generated method stub
    				
    				if(newValue !=(null)) {
    					
    					trayPackage = newValue ; 
        				view.setTrayPackage(newValue);

    					
    				}
    			

    			}
    			
    		});
    	 
    	 button.setOnAction((e) -> {
    		 
    			 
    		 view.removeTrayPackage();
    		 shelfManager.addPackageToList(trayPackage);
    		 shelfManager.removeTrayPackage();    		 
    		 
    		 
    		 
    	
    	 });
    	 


    }
    public void drag(MouseEvent event) {
    	  Node n = (Node)event.getSource();
    	  n.setTranslateX(n.getTranslateX() + event.getX());
    	  n.setTranslateY(n.getTranslateY() + event.getY());
    	  System.out.println(n.getTranslateX());
    	  System.out.println(n.getTranslateY());
    	 }
    
//    private void checkBounds(Shape block) {
//    	boolean collisionDetected = false;
//    	 for (Shape static_bloc : nodes) {
//    		 if (static_bloc != block) {
//    		      static_bloc.setFill(Color.YELLOW); 
//    		      
//    		      if (block.getBoundsInParent().intersects(static_bloc.getBoundsInParent())) {
//    			        collisionDetected = true;
//    			      }
//    		    }
//   	  		}
//   	  if (collisionDetected) {
//  	    block.setFill(Color.GREEN);
//  	  } else {
//  	    block.setFill(Color.BLUE);
//  	  }
//    }

    
    

    public void setPackageinTray(Package p){
    	
        //Rectangle packet = new Rectangle();

        
    }
    
    public TrayView getView() {
    	return view ; 
    }
}
