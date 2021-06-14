package GUI;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ConfigurationView {
    
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
