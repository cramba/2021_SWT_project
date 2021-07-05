package GUI;

import Business.ShelfManager.ShelfManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class ConfigurationViewController extends ViewController{

	ConfigurationView view;
	//Button loadConfigurationButton;
	//Button saveConfigurationButton;
    Label informationLabel;
    Label errorMessageLabel;

    public ConfigurationViewController(ShelfManager shelfManager){
    	super(shelfManager);
    	view = new ConfigurationView() ;
    	//loadConfigurationButton = view.getLoadConfigurationButton();
    	//saveConfigurationButton = view.getSafeConfigurationButton();
        informationLabel = view.getPaketOutput();
    	errorMessageLabel = view.getFehleroutput();
        errorMessageLabel.setTextFill(Color.RED);

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


		shelfManager.errorMesageProp().addListener(new ChangeListener<String>(){

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                errorMessageLabel.setText(newValue);

            }

		});
    }
    
    
    
    public ConfigurationView getView(){
        return view;
    }
}
