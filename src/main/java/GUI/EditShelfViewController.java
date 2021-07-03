package GUI;

import Business.ShelfManager.ShelfManager;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.Pane;

public class EditShelfViewController extends ViewController{

	EditShelfView view;

    public EditShelfViewController(ShelfManager shelfManager){
    	
    	super(shelfManager);
    	view = new EditShelfView();
    	
    	
    	
    	
    	root = view ;
        initialize();
    }

    public void initialize(){
    	
    	//Fertig Button - erstellt eine Regalstuetze
    	view.getDoneButton().setOnAction((e) -> {
        	
    		//Textfelder fuer laenge und Distance werden ausgelesen
        	int length = Integer.parseInt(view.getLengthInput().getText());
        	int distance = Integer.parseInt(view.getDistanceInput().getText());
        	
        	
        	//Informationen wernden an Logic geschickt und ShelfSupport wird erstellt

        	shelfManager.addShelfSupport(length,distance);
        	

        	
        	
        
        });
    	//Fertig Button - erstellt ein Regalboden
    	view.getDoneButton2().setOnAction((e)->{
    		int loadCapacity = Integer.parseInt(view.getLoadCapacityTextField().getText());
    		
    		shelfManager.addShelfFloor(loadCapacity);
    	

    	});
    	
    	
    	
    	//Listener auf ComboBox wo man auswaehlen kann zwischen Regalstuetzen und Regalboeden
    	view.getShelfItemSelection().getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				
				//Wenn du Regalstuetze auswaehltst werden die GUI-Elemente .. fuer die Regalstuetze angezeigt
				if(newValue.equals("Regalstuetze")) {
					
					//Alte	GUI-Elemente.. werden geloescht ausser der erste da das die Kombobox ist
					view.getChildren().remove(1, view.getChildren().size()  );

					view.getChildren().addAll(view.getHBox(),view.getHBox2(),view.getDoneButton(),view.getDeleteShelfSupportButton());
					
					//Wenn du Regalboden auswaehltst werden die GUI-Elemente .. fuer den Regalboden angezeigt

				}else if(newValue.equals("Regalboden")) {
					
					view.getChildren().remove(1, view.getChildren().size()   );
					view.getChildren().addAll(view.getLoadCapacityLabel(),view.getLoadCapacityTextField(),view.getDoneButton2(),view.getDeleteShelfFloorButton());

				}
				
				
				
			}
     
    	});
    	
        
    }
    
    public EditShelfView getView() {
    	return view  ; //root ? 
    }
}