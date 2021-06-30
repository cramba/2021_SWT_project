package GUI;

import Business.Package.Colour;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
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

    HBox buttons;
    Button closeButton;
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

        closeButton = new Button("x");
        addIncompatibilityColourButton = new Button("+");
        doneButton = new Button("Fertig");
        newTemplateButton = new Button("neue Vorlage");

        name = new HBox();
        name.getChildren().addAll(nameLabel, nameInput);


        colour = new HBox();
        colour.getChildren().addAll(colourLabel, colourInput);

        width = new HBox();
        width.getChildren().addAll(widthLabel, widthInput);

        height = new HBox();
        height.getChildren().addAll(heightLabel, heightInput);

        weight = new HBox();
        weight.getChildren().addAll(weightLabel, weightInput);

        incompatibility = new HBox();
        incompatibility.getChildren().addAll(incompatibilityLabel, incompatibilityInput, addIncompatibilityColourButton);

        maxLoadCapacity = new HBox();
        maxLoadCapacity.getChildren().addAll(maxLoadCapacityLabel, maxLoadCapacityInput);
        
        buttons = new HBox(doneButton, newTemplateButton);

        this.getChildren().addAll(closeButton, new Label("Paket hinzufuegen"), name, colour, width, height, weight, incompatibility, maxLoadCapacity);
        this.getChildren().addAll(buttons);
        this.getStyleClass().addAll("background");
        
        this.setPadding(new Insets(30, 30, 20, 20));
        this.setSpacing(12);
        buttons.setSpacing(12);
        buttons.setPadding(new Insets(20,0,0,0));
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