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


    public Button getShelfEditButton() {
        return shelfEditButton;
    }

    public Button getAddPackageButton() {
        return addPackageButton;
    }

    public Label getErrorMessageLabel() {
        return errorMessageLabel;
    }

    public Label getPacketInformationLabel() {
        return packetInformationLabel;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public Button getLoadConfigurationButton() {
        return loadConfigurationButton;
    }

    public Button getSafeConfigurationButton() {
        return safeConfigurationButton;
    }

    public ConfigurationView(){

        shelfEditButton = new Button("Regal bearbeiten");
        addPackageButton = new Button("Paket hinzufuegen");
        hBox1 = new HBox();
        errorMessageLabel = new Label("Fehlermeldung:");
        hBox2 = new HBox();
        packetInformationLabel = new Label("Paket:");
        deleteButton = new Button ("loeschen");
        hBox3 = new HBox();
        
        loadConfigurationButton = new Button("Konfiguration laden");
        safeConfigurationButton = new Button("Konfiguration speichern");
        
        vBox1 = new VBox();
        vBox2 = new VBox();
        
        hBox1.getChildren().addAll(shelfEditButton,addPackageButton);
        hBox2.getChildren().addAll(errorMessageLabel);
        hBox3.getChildren().addAll(packetInformationLabel,deleteButton);
        
        hBox1.setSpacing(10);
        hBox2.setSpacing(10);
        hBox3.setSpacing(10);
        
        vBox1.getChildren().addAll(hBox1,hBox2,hBox3);
        
        vBox2.getChildren().addAll(loadConfigurationButton,safeConfigurationButton);
        
        loadConfigurationButton.setId("grau");
        safeConfigurationButton.setId("grau");
        packetInformationLabel.setId("grau");
        errorMessageLabel.setId("grau");
        deleteButton.setId("rot");
        shelfEditButton.setId("orange");
        addPackageButton.setId("green");
        
        packetInformationLabel.setPadding(new Insets(05, 10, 05, 10));
        errorMessageLabel.setPadding(new Insets(05, 10, 05, 10));
        
        vBox1.setSpacing(10);
        vBox2.setSpacing(10);
        vBox1.setAlignment(Pos.BASELINE_RIGHT);
        vBox2.setAlignment(Pos.CENTER);
        vBox1.setPadding(new Insets(30, 30, 20, 20));
        vBox2.setPadding(new Insets(15, 30, 20, 25));
        
        this.setLeft(vBox1);
        this.setRight(vBox2);
        this.getStyleClass().addAll("background");

    }
}
