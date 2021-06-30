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
    	
    	view.getDoneButton().setOnAction((e) -> {
        	
        	int length = Integer.parseInt(view.getLengthInput().getText());
        	int distance = Integer.parseInt(view.getDistanceInput().getText());
        	
        	Platform.runLater(() -> {    
        		shelfManager.addShelfSupport(length,distance);
        	
        	});
        	
        	
        
        });
    	
    	view.getShelfItemSelection().getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				
				if(newValue.equals("Regalstütze")) {
					
						
					view.getChildren().remove(1, view.getChildren().size()  );

					view.getChildren().addAll(view.getHBox(),view.getHBox2(),view.getDoneButton());
					
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