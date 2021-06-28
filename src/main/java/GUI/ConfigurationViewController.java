package GUI;

import Business.ShelfManager.ShelfManager;
import javafx.scene.layout.Pane;

public class ConfigurationViewController extends ViewController{
	
	Pane view;

    public ConfigurationViewController(ShelfManager shelfManager){
    	super(shelfManager);
    	view = new ConfigurationView() ;
    	root = view  ;
    	
        initialize();
    }
    public void initialize(){

    }
}
