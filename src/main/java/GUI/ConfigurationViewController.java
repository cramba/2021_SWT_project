package GUI;

import Business.ShelfManager.ShelfManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class ConfigurationViewController extends ViewController{

	ConfigurationView view;
	Button loadConfigurationButton;
	Button saveConfigurationButton;
    Label informationLabel;

    public ConfigurationViewController(ShelfManager shelfManager){
    	super(shelfManager);
    	view = new ConfigurationView() ;
    	loadConfigurationButton = view.getLoadConfigurationButton();
    	saveConfigurationButton = view.getSafeConfigurationButton();
        informationLabel = view.getPaketOutput();
    	

    	root = view;
    	
        initialize();
    }
    public void initialize(){

        shelfManager.packageInformationProp().addListener(new ChangeListener<String>() {

    		@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    			informationLabel.setText(newValue);
    		}
    	});
    }
    
    
    
    public ConfigurationView getView(){
        return view;
    }
}
