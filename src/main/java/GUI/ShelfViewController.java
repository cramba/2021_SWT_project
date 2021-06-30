package GUI;

import java.util.ArrayList;

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
			//Löschen button erscheint... Die zeile ist so groß da ich den Löschen button dafür hier rein bekommen musste um damit zu arbeiten
			editShelfViewController.getRoot().getChildren().addAll(((EditShelfView) editShelfViewController.getRoot()).getDeleteShelfSupportButton());
			
			//Listener für Löschbutton.. 
			((EditShelfView) editShelfViewController.getRoot()).getDeleteShelfSupportButton().setOnAction((e) -> {
				
				//Löscht Shelfsupport rectangles aus der ArrayList
				view.getShelfSupports().remove(i);
				//Löscht ShelfSupport rectangles aus der View 
				view.getChildren().remove(i);
				//Löscht Shelfsupport aus der Logic
				shelfManager.deleteShelfSupport(i);
			});
			
			
//			root.getChildren().clear();
//			System.out.println("halloooo");
//			((ShelfView) root).getShelfSupports().get(i).setFill(Color.RED);
						
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
    	
    	
    	//Zeigt Regalstütze in GUI an wenn sie erstellt wurde
    	shelfManager.getShelfSupportProp().addListener(new ChangeListener<ShelfSupport>() {

			@Override
			public void changed(ObservableValue<? extends ShelfSupport> observable, ShelfSupport oldValue, ShelfSupport newValue) {
				
				//distance aus logic holen
				int aktdistanceX = shelfManager.getShelfSupportProp().getValue().getPositionX();
				
				//endgültige distance
				int finaldistanceX ;

				//Regalstütze für gui erstellen mit der Gewünschten länge - länge wir aus der Logic geholt
				Rectangle shelfSupportRectangle = new Rectangle(0,0,10,shelfManager.getShelfSupportProp().getValue().getLength());
				
				//distance errechnen aus jetziger eingegebener Distance und den vorherigen
				finaldistanceX = aktdistanceX + lastdistanceX;
				
				// neue letzte distance setzen
				lastdistanceX = finaldistanceX ;
				
				//distanceX = 100 * shelfSupports.size();
				
				//Finale distance für Regalstütze setzen
				shelfSupportRectangle.setLayoutX(finaldistanceX);
				
				//Arraylist von Shelfsupport-Rectangles = neues Rectangle hinzufügen
				((ShelfView) root).getShelfSupports().add(shelfSupportRectangle);

				//Rectangle soll auf Boden stehen
				AnchorPane.setBottomAnchor(shelfSupportRectangle, 0.0);
				
				//ShelfSupportRectangle in View einsetzen
				((ShelfView) root).getChildren().addAll(shelfSupportRectangle);
				
				
				
				//MouseListener für alle -ShelfSupport-Rectangles im Programm- Wird einer Geklickt wird Innere Klasse ShelfSupportHandler(Ganz oben in dieser Klasse zu finden) aufgerufen
			  	for(int i= 0; i< ((ShelfView) root).getShelfSupports().size(); i++) {
	
		    		view.getShelfSupports().get(i).setOnMouseClicked(new ShelfSupportHandler(i));
		    	}
				

				
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
