package GUI;

import Business.ShelfManager.ShelfManager;
import javafx.scene.layout.Pane;

public class ConfigurationViewController extends ViewController{
	
	ConfigurationView view;

    public ConfigurationViewController(ShelfManager shelfManager){
    	super(shelfManager);
    	view = new ConfigurationView() ;
    	root = view;
    	
        initialize();
    }
    public void initialize(){
        
    }
    
    public ConfigurationView getView(){
        return view;
    }
}
