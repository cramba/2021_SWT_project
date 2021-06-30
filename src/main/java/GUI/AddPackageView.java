package GUI;

import Business.Package.Colour;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class AddPackageView extends VBox {
    HBox name;
    Label nameLabel;
    TextField nameInput;

    HBox colour;
    Label colourLabel;
    ComboBox<Color> colourInput;

    HBox width;
    Label widthLabel;
    TextField widthInput;

    HBox height;
    Label heightLabel;
    TextField heightInput;

    HBox weight;
    Label weightLabel;
    TextField weightInput;

    HBox incompatibility;
    Label incompatibilityLabel;
    HBox incompatibilityInput;
    Button addIncompatibilityColourButton;

    HBox maxLoadCapacity;
    Label maxLoadCapacityLabel;
    TextField maxLoadCapacityInput;
    HBox packageadded;

    HBox buttons;
    Button closeButton;
    HBox label;
    Button doneButton;
    Button newTemplateButton;

    public AddPackageView() {

        nameLabel = new Label("Name:");
        nameInput = new TextField();
        
        colourLabel = new Label("Farbe:");
        colourInput = new ComboBox<>();
        colourInput.getItems().addAll(Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN);

        widthLabel = new Label("Breite:");
        widthInput = new TextField();

        heightLabel = new Label("Hoehe:");
        heightInput = new TextField();

        weightLabel = new Label("Gewicht:");
        weightInput = new TextField();

        incompatibilityLabel = new Label("Unvertraeglichkeit:");
        addIncompatibilityColourButton = new Button("+");
        incompatibilityInput = new HBox();

        maxLoadCapacityLabel = new Label("max. Traglast:");
        maxLoadCapacityInput = new TextField();

        addIncompatibilityColourButton = new Button("+");
        doneButton = new Button("Fertig");
        newTemplateButton = new Button("neue Vorlage");

        name = new HBox();
        name.getChildren().addAll(nameLabel, nameInput);
        name.setSpacing(63);
       
        colour = new HBox();
        colour.getChildren().addAll(colourLabel, colourInput);
        colour.setSpacing(65);

        width = new HBox();
        width.getChildren().addAll(widthLabel, widthInput);
        width.setSpacing(65);

        height = new HBox();
        height.getChildren().addAll(heightLabel, heightInput);
        height.setSpacing(60);

        weight = new HBox();
        weight.getChildren().addAll(weightLabel, weightInput);
        weight.setSpacing(51);

        incompatibility = new HBox();
        incompatibility.getChildren().addAll(incompatibilityLabel, incompatibilityInput, addIncompatibilityColourButton);
        incompatibility.setSpacing(9);

        maxLoadCapacity = new HBox();
        maxLoadCapacity.getChildren().addAll(maxLoadCapacityLabel, maxLoadCapacityInput);
        maxLoadCapacity.setSpacing(20);
        
        buttons = new HBox(doneButton, newTemplateButton);
        buttons.setSpacing(12);
        buttons.setPadding(new Insets(20,0,0,0));
        
        packageadded = new HBox(new Label("Paket hinzufuegen"));
        closeButton = new Button("x");
        label = new HBox();
        label.getChildren().addAll(packageadded, closeButton);
        packageadded.setPadding(new Insets(5, 130, 5, 1));
        closeButton.setAlignment(Pos.BASELINE_LEFT);
        label.setSpacing(12);

        this.getChildren().addAll(label, name, colour, width, height, weight, incompatibility, maxLoadCapacity);
        this.getChildren().addAll(buttons);
        
        this.getStyleClass().addAll("background");
        
        this.setPadding(new Insets(60, 20, 20, 20));
        this.setSpacing(12);
        
        closeButton.setId("rot");
        doneButton.setId("green");
        newTemplateButton.setId("gelb");
        packageadded.setId("grau");
    }

    public HBox getName() {
        return name;
    }

    public Label getNameLabel() {
        return nameLabel;
    }

    public TextField getNameInput() {
        return nameInput;
    }

    public HBox getColour() {
        return colour;
    }

    public Label getColourLabel() {
        return colourLabel;
    }

    public ComboBox<Color> getColourInput() {
        return colourInput;
    }

    public Label getWidthLabel() {
        return widthLabel;
    }

    public TextField getWidthInput() {
        return widthInput;
    }

    public Label getHeightLabel() {
        return heightLabel;
    }

    public TextField getHeightInput() {
        return heightInput;
    }

    public HBox getWeight() {
        return weight;
    }

    public Label getWeightLabel() {
        return weightLabel;
    }

    public TextField getWeightInput() {
        return weightInput;
    }

    public HBox getIncompatibility() {
        return incompatibility;
    }

    public Label getIncompatibilityLabel() {
        return incompatibilityLabel;
    }

    public HBox getIncompatibilityInput() {
        return incompatibilityInput;
    }

    public HBox getMaxLoadCapacity() {
        return maxLoadCapacity;
    }

    public Label getMaxLoadCapacityLabel() {
        return maxLoadCapacityLabel;
    }

    public TextField getMaxLoadCapacityInput() {
        return maxLoadCapacityInput;
    }

    public Button getCloseButton() {
        return closeButton;
    }

    public Button getAddIncompatibilityColourButton() {
        return addIncompatibilityColourButton;
    }

    public Button getDoneButton() {
        return doneButton;
    }

    public Button getNewTemplateButton() {
        return newTemplateButton;
    }

}