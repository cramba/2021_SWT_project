package GUI;

import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddPackageView extends VBox {
    HBox name;
    Label nameLabel;
    TextField nameInput;

    HBox colour;
    Label colourLabel;
    ColorPicker colourInput;

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

    HBox maxLoadCapacity;
    Label maxLoadCapacityLabel;
    TextField maxLoadCapacityInput;


    Button closeButton;
    Button addIncompatibilityColour;
    Button doneButton;
    Button newTemplateButton;

    public AddPackageView() {
        nameLabel = new Label("Name:");
        nameInput = new TextField();
        colourLabel = new Label("Farbe:");
        colourInput = new ColorPicker();
        widthLabel = new Label("Breite:");
        widthInput = new TextField();
        heightLabel = new Label("Höhe:");
        heightInput = new TextField();
        weightLabel = new Label("Gewicht:");
        weightInput = new TextField();
        incompatibilityLabel = new Label("Unverträglicchkeit:");
        incompatibilityInput = new HBox();
        maxLoadCapacityLabel = new Label("max. Traglast:");
        maxLoadCapacityInput = new TextField();

        closeButton = new Button("x");
        addIncompatibilityColour = new Button("+");
        doneButton = new Button("Fertig");
        newTemplateButton = new Button("neue Vorlage");

        name = new HBox();
        name.getChildren().addAll(nameLabel, nameLabel);

        colour = new HBox();
        colour.getChildren().addAll(colourLabel, colourInput);

        width = new HBox();
        width.getChildren().addAll(widthLabel, widthInput);

        height = new HBox();
        height.getChildren().addAll(heightLabel, heightInput);

        weight = new HBox();
        weight.getChildren().addAll(weightLabel, weightInput);

        incompatibility = new HBox();
        incompatibility.getChildren().addAll(incompatibilityLabel, new ColorPicker(), incompatibilityInput);

        maxLoadCapacity = new HBox();
        maxLoadCapacity.getChildren().addAll(maxLoadCapacityLabel, maxLoadCapacityInput);

        this.getChildren().addAll(closeButton, new Label("Paket hinzufügen"), name, colour, width, height, weight, incompatibility, maxLoadCapacity, new HBox(doneButton, newTemplateButton));
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

    public ColorPicker getColourInput() {
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

    public Button getAddIncompatibilityColour() {
        return addIncompatibilityColour;
    }

    public Button getDoneButton() {
        return doneButton;
    }

    public Button getNewTemplateButton() {
        return newTemplateButton;
    }

}