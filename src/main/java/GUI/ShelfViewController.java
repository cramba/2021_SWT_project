package GUI;

import java.util.ArrayList;

import Business.Shelf.ShelfFloor;
import Business.Shelf.ShelfSupport;
import Business.ShelfManager.ShelfManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ShelfViewController extends ViewController{
	
	ShelfView view;
	private ArrayList<Rectangle> shelfSupports;
	private ArrayList<Rectangle> oldshelfSupportsList;
	private ArrayList<Rectangle> oldshelfFloorsList;
	int lastdistanceX = 0;
	EditShelfViewController editShelfViewController ;
	
	
	
	//innere Klasse - wird aufgerufen wenn ShelfSupport angeklickt wird
	private class ShelfSupportHandler implements EventHandler<MouseEvent>{
		
		int i ; 
		public ShelfSupportHandler(int i) {
			
			this.i = i ; 
			
		}

		@Override
		public void handle(MouseEvent t) {
			//Loeschen button erscheint... Die zeile ist so gro� da ich den Loeschen button dafuer hier rein bekommen musste um damit zu arbeiten
			
			((EditShelfView) editShelfViewController.getRoot()).getDeleteShelfSupportButton().setVisible(true);

			if(!oldshelfSupportsList.equals(((ShelfView) root).getShelfSupports())) {

			  	for(int i= 0; i< ((ShelfView) root).getShelfSupports().size(); i++) {
			  		
			  		//remove alte hanldder
			  		
			  		view.getShelfSupports().get(i).removeEventHandler(MouseEvent.MOUSE_CLICKED,  new ShelfSupportHandler(i));

			  		// add neue handler
		    		view.getShelfSupports().get(i).addEventHandler(MouseEvent.MOUSE_CLICKED,  new ShelfSupportHandler(i));   	

		    	}

		    	oldshelfSupportsList = new ArrayList<Rectangle>(((ShelfView) root).getShelfSupports());

				
			}
		
			
			//Listener fuer Loeschbutton..
			((EditShelfView) editShelfViewController.getRoot()).getDeleteShelfSupportButton().setOnAction((e) -> {
				
	
				
				view.getChildren().remove(view.getShelfSupports().get(i));
				//Loescht Shelfsupport aus der Logic
				shelfManager.deleteShelfSupport(i);
				//Loescht Shelfsupport rectangles aus der ArrayList
				((ShelfView) root).getShelfSupports().remove(i);
				//Loescht ShelfSupport rectangles aus der View 
				
			});
			
		}
	}
	
	private class ShelfSupportHandlerForDrag implements EventHandler<MouseEvent>{

		
		int i ; 
		public ShelfSupportHandlerForDrag(int i) {
			
			this.i = i ; 
			
		}

		@Override
		public void handle(MouseEvent arg0) {
			// TODO Auto-generated method stub

			

		}
		
	}
	
private class ShelfFloorHandler implements EventHandler<MouseEvent>{

		
		int i ; 
		public ShelfFloorHandler(int i) {
			
			this.i = i ; 
			
		}

		@Override
		public void handle(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
			((EditShelfView) editShelfViewController.getRoot()).getDeleteShelfFloorButton().setVisible(true);
			
			if(!oldshelfFloorsList.equals(((ShelfView) root).getShelfFloors())) {

			  	for(int i= 0; i< ((ShelfView) root).getShelfFloors().size(); i++) {
			  		
			  		//remove alte hanldder
			  		
			  		view.getShelfFloors().get(i).removeEventHandler(MouseEvent.MOUSE_CLICKED,  new ShelfFloorHandler(i));

			  		// add neue handler
		    		view.getShelfFloors().get(i).addEventHandler(MouseEvent.MOUSE_CLICKED,  new ShelfFloorHandler(i));   	

		    	}

			  	oldshelfFloorsList = new ArrayList<Rectangle>(((ShelfView) root).getShelfFloors());

				
			}
			
			
			((EditShelfView) editShelfViewController.getRoot()).getDeleteShelfFloorButton().setOnAction((e) -> {
				
	
				
				view.getChildren().remove(view.getShelfFloors().get(i));
				//Loescht Shelfsupport aus der Logic
				shelfManager.deleteShelfFloor(i);
				//Loescht Shelfsupport rectangles aus der ArrayList
				((ShelfView) root).getShelfFloors().remove(i);
				//Loescht ShelfSupport rectangles aus der View 
				
			});

			

		}
		
	}
	


    public ShelfViewController(ShelfManager shelfManager,EditShelfViewController editShelfViewController ){
    	super(shelfManager);
    	view = new ShelfView();
    	this.editShelfViewController = editShelfViewController ; 
    	
		

    	shelfSupports = new ArrayList<Rectangle>();

    	

    	
    	root = view;
         initialize();
    }
    public void initialize(){
    	
    	
    	//Zeigt Regalstuetze in GUI an wenn sie erstellt wurde
    	shelfManager.getShelfSupportProp().addListener(new ChangeListener<ShelfSupport>() {

			@Override
			public void changed(ObservableValue<? extends ShelfSupport> observable, ShelfSupport oldValue, ShelfSupport newValue) {
				
				//distance aus logic holen
				int aktdistanceX = shelfManager.getShelfSupportProp().getValue().getPositionX();
				
				//endgueltige distance
				int finaldistanceX ;

				//Regalstuetze fuer gui erstellen mit der Gewuenschten laenge - laenge wir aus der Logic geholt
				Rectangle shelfSupportRectangle = new Rectangle(0,0,10,shelfManager.getShelfSupportProp().getValue().getLength());
				
				//distance errechnen aus jetziger eingegebener Distance und den vorherigen
				finaldistanceX = aktdistanceX + lastdistanceX;
				
				// neue letzte distance setzen
				lastdistanceX = finaldistanceX ;
				shelfManager.getShelfSupportProp().getValue().setPositionX(finaldistanceX);
				
				//distanceX = 100 * shelfSupports.size();
				
				//Finale distance fuer Regalstuetze setzen
				shelfSupportRectangle.setLayoutX(finaldistanceX);
				
				//Arraylist von Shelfsupport-Rectangles = neues Rectangle hinzufuegen
				((ShelfView) root).getShelfSupports().add(shelfSupportRectangle);

				//Rectangle soll auf Boden stehen
				AnchorPane.setBottomAnchor(shelfSupportRectangle, 0.0);
				
				//ShelfSupportRectangle in View einsetzen
				((ShelfView) root).getChildren().addAll(shelfSupportRectangle);
				
				
				
				//MouseListener fuer alle -ShelfSupport-Rectangles im Programm- Wird einer Geklickt wird Innere Klasse ShelfSupportHandler(Ganz oben in dieser Klasse zu finden) aufgerufen
			  	for(int i= 0; i< ((ShelfView) root).getShelfSupports().size(); i++) {
	
		    		//view.getShelfSupports().get(i).setOnMouseClicked(new ShelfSupportHandler(i));
		    		view.getShelfSupports().get(i).addEventHandler(MouseEvent.MOUSE_CLICKED,  new ShelfSupportHandler(i));   
		    		view.getShelfSupports().get(i).addEventHandler(MouseEvent.MOUSE_DRAGGED,  new ShelfSupportHandlerForDrag(i));

		    	}
			  	
			  	
		    	oldshelfSupportsList = new ArrayList<Rectangle>(((ShelfView) root).getShelfSupports());
		    	

				

				
			}

		});
    	
    	shelfManager.getShelfFloorProp().addListener(new ChangeListener<ShelfFloor>() {

			@Override
			public void changed(ObservableValue<? extends ShelfFloor> observable, ShelfFloor oldValue, ShelfFloor newValue) {
				// TODO Auto-generated method stub
				
				Rectangle shelfFloorRectangle = new Rectangle(0,0,100,10);
				shelfFloorRectangle.setLayoutX(shelfManager.getShelfFloorProp().getValue().getPositionX());
				shelfFloorRectangle.setLayoutY(shelfManager.getShelfFloorProp().getValue().getPositionY());
			
				view.getShelfFloors().add(shelfFloorRectangle);
				
				((ShelfView) root).getChildren().addAll(shelfFloorRectangle);
				
				
				
				
				for(int i= 0; i< ((ShelfView) root).getShelfFloors().size(); i++) {
					
					view.getShelfFloors().get(i).addEventHandler(MouseEvent.MOUSE_CLICKED,  new ShelfFloorHandler(i));   
				}

		    	oldshelfFloorsList = new ArrayList<Rectangle>(((ShelfView) root).getShelfFloors());

			}
    		
    	});
    	
  
    	
//    	shelfSupports.get(0).setOnMouseClicked(new EventHandler<MouseEvent>()
//         {
//             @Override
//             public void handle(MouseEvent t) {
//            	 
//             }
//         });
    	
    	

    }
//	private void click(MouseEvent event) {
//		// TODO Auto-generated method stub
//		
//		System.out.println("halloooo");
//	}
}
