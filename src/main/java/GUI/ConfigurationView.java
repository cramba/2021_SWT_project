package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ConfigurationView extends BorderPane {
    
    Button shelfEditButton;
    Button addPackageButton;
    Label errorMessageLabel;
    Label packetInformationLabel;
    Button deleteButton; 
    Button loadConfigurationButton;
    Button safeConfigurationButton;
    HBox hBox1, hBox2, hBox3;
    VBox vBox1, vBox2;
    
    

    
    public ConfigurationView(){

        shelfEditButton = new Button("Regal bearbeiten");
        addPackageButton = new Button("Paket hinzufuegen");
        hBox1 = new HBox();
        errorMessageLabel = new Label("Fehlermeldung:");
        hBox2 = new HBox();
        packetInformationLabel = new Label("Paket:");
        deleteButton = new Button ("löschen");
        hBox3 = new HBox();
        
        loadConfigurationButton = new Button("Konfiguration laden");
        safeConfigurationButton = new Button("Konfiguration speichern");
        
        vBox1 = new VBox();
        vBox2 = new VBox();
        
        hBox1.getChildren().addAll(shelfEditButton,addPackageButton);
        hBox2.getChildren().addAll(errorMessageLabel);
        hBox3.getChildren().addAll(packetInformationLabel,deleteButton);
        
        vBox1.getChildren().addAll(hBox1,hBox2,hBox3);
        
        vBox2.getChildren().addAll(loadConfigurationButton,safeConfigurationButton);
        
        this.setLeft(vBox1);
        this.setRight(vBox2);
        
        
        
        

    }
}
