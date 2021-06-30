package GUI;

import Business.ShelfManager.ShelfManager;
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
    	
    	
    	
        
    }
    
    public EditShelfView getView() {
    	return view  ; //root ? 
    }
}