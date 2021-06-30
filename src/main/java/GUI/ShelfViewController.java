package GUI;

import java.util.ArrayList;

import Business.Shelf.ShelfSupport;
import Business.ShelfManager.ShelfManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class ShelfViewController extends ViewController{
	ShelfView view;
	
	private ArrayList<Rectangle> shelfSupports;
	
	int lastdistanceX = 0;

	
	  


    public ShelfViewController(ShelfManager shelfManager){
    	super(shelfManager);
    	view = new ShelfView();
    	
    	
    	shelfSupports = new ArrayList<Rectangle>();
    	
    	
    	root = view;
         initialize();
    }
    public void initialize(){
    	
    	
    	shelfManager.getShelfSupportProp().addListener(new ChangeListener<ShelfSupport>() {

			@Override
			public void changed(ObservableValue<? extends ShelfSupport> observable, ShelfSupport oldValue, ShelfSupport newValue) {
				
				int aktdistanceX = shelfManager.getShelfSupportProp().getValue().getPositionX();
				int finaldistanceX ;

				Rectangle shelfSupportRectangle = new Rectangle(0,0,10,shelfManager.getShelfSupportProp().getValue().getLength());
				
				finaldistanceX = aktdistanceX + lastdistanceX;
				
				lastdistanceX = finaldistanceX ;
				
				//distanceX = 100 * shelfSupports.size();
				
				shelfSupportRectangle.setLayoutX(finaldistanceX);
			
				AnchorPane.setBottomAnchor(shelfSupportRectangle, 0.0);
		
				view.getChildren().addAll(shelfSupportRectangle);
				
				shelfSupports.add(shelfSupportRectangle);
				
			}

			

		
		});

    }
}
