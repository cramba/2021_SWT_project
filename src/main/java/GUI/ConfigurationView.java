package GUI;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ConfigurationView extends HBox {
    
    Button shelfEditButton;
    Button addPackageButton;
    Label errorMessageLabel;
    Label packetInformationLabel;
    Button deleteButton; 
    Button loadConfigurationButton;
    Button safeConfigurationButton;

    
    public ConfigurationView(){

        shelfEditButton = new Button("Regal bearbeiten");
        addPackageButton = new Button("Paket hinzufügen");
        errorMessageLabel = new Label();
        packetInformationLabel = new Label();
        deleteButton = new Button ();
        loadConfigurationButton = new Button();
        safeConfigurationButton = new Button();
    }
}
