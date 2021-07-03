package GUI;

import Business.ShelfManager.ShelfManager;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class EditShelfViewController extends ViewController{

	EditShelfView view;
	private Label errorMessage;

    public EditShelfViewController(ShelfManager shelfManager){
    	
    	super(shelfManager);
    	view = new EditShelfView();
    	errorMessage = view.getErrorMessage();
    	
    	
    	
    	root = view ;
        initialize();
    }

    public void initialize(){
    	
    	//Fertig Button - erstellt eine Regalstuetze
    	view.getDoneButton().setOnAction((e) -> {
        	if(isInt(view.getLengthInput().getText()) && isInt(view.getDistanceInput().getText())) {
        		errorMessage.setText("");
        		//Textfelder fuer laenge und Distance werden ausgelesen
            	int length = Integer.parseInt(view.getLengthInput().getText());
            	int distance = Integer.parseInt(view.getDistanceInput().getText());
            	
            	
            	//Informationen wernden an Logic geschickt und ShelfSupport wird erstellt
            	shelfManager.addShelfSupport(length,distance);
        	}else {
        		errorMessage.setText("Bitte gebe eine gültige ganze Zahl ein");
        		//System.out.println("Bitte gebe eine gültige ganze Zahl ein");
        	}

        });
    	
    	
    	//Fertig Button - erstellt ein Regalboden
    	view.getDoneButton2().setOnAction((e)->{
    		if(isInt(view.getLoadCapacityTextField().getText())) {
    			errorMessage.setText("");
    			int loadCapacity = Integer.parseInt(view.getLoadCapacityTextField().getText());
        		
        		shelfManager.addShelfFloor(loadCapacity);
        		shelfManager.getShelfFloorProp().getValue().setPositionX(50);
    	    	shelfManager.getShelfFloorProp().getValue().setPositionY(50);
    		}else {
    			errorMessage.setText("Bitte gebe eine gültige ganze Zahl ein");
    			//System.out.println("Bitte gebe eine gültige ganze Zahl ein");
    		}
    	

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
					view.getChildren().addAll(view.getLoadCapacityLabel(),view.getLoadCapacityTextField(), view.getErrorMessage(), view.getDoneButton2(),view.getDeleteShelfFloorButton());

				}
				
				
				
			}
     
    	});
    	
        
    }
    
    
    public boolean isInt(String number) {
    	if(number == null) {
    		return false;
    	}
    	try {
    		int i = Integer.parseInt(number);
    	} catch(NumberFormatException nfe) {
    		return false;
    	}
    	return true;
    }
    
    public EditShelfView getView() {
    	return view  ; //root ? 
    }
}