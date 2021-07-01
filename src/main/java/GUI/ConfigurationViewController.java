package GUI;

import Business.ShelfManager.ShelfManager;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class ConfigurationViewController extends ViewController{

	ConfigurationView view;
	Button loadConfigurationButton;
	Button saveConfigurationButton;

    public ConfigurationViewController(ShelfManager shelfManager){
    	super(shelfManager);
    	view = new ConfigurationView() ;
    	loadConfigurationButton = view.getLoadConfigurationButton();
    	saveConfigurationButton = view.getSafeConfigurationButton();

    	root = view;
    	
        initialize();
    }
    public void initialize(){

    }
    
    public ConfigurationView getView(){
        return view;
    }
}
