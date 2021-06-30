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
    	
    	//Fertig Button - erstellt eine Regalstütze
    	view.getDoneButton().setOnAction((e) -> {
        	
    		//Textfelder für länge und Distance werden ausgelesen
        	int length = Integer.parseInt(view.getLengthInput().getText());
        	int distance = Integer.parseInt(view.getDistanceInput().getText());
        	
        	
        	//Informationen wernden an Logic geschickt und ShelfSupport wird erstellt
        	Platform.runLater(() -> {    
        		shelfManager.addShelfSupport(length,distance);
        	
        	});
        	
        	
        
        });
    	
    	//Listener auf ComboBox wo man auswählen kann zwischen Regalstützen und Regalböden 
    	view.getShelfItemSelection().getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				
				//Wenn du Regalstütze auswähltst werden die GUI-Elemente .. für die Regalstütze angezeigt
				if(newValue.equals("Regalstütze")) {
					
					//Alte	GUI-Elemente.. werden gelöscht außer der erste da das die Kombobox ist
					view.getChildren().remove(1, view.getChildren().size()  );

					view.getChildren().addAll(view.getHBox(),view.getHBox2(),view.getDoneButton());
					
					//Wenn du Regalboden auswähltst werden die GUI-Elemente .. für den Regalboden angezeigt

				}else if(newValue.equals("Regalboden")) {
					
					view.getChildren().remove(1, view.getChildren().size()   );
				}
				
				
				
			}
     
    	});
    	
        
    }
    
    public EditShelfView getView() {
    	return view  ; //root ? 
    }
}