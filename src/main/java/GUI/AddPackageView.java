package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class AddPackageView extends ScrollPane {
    VBox vbox;

    HBox name;
    Label nameLabel;
    TextField nameInput;

    HBox colour;
    Label colourLabel;
    VBox colourInput;
    ToggleGroup colourGroup;
    ToggleButton redButton;
    ToggleButton greenButton;
    ToggleButton yellowButton;
    ToggleButton blueButton;

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
    VBox incompatibilityColors;
    ToggleButton incompRed;
    ToggleButton incompGreen;
    ToggleButton incompYellow;
    ToggleButton incompBlue;
    //Button addIncompatibilityColourButton;

    HBox maxLoadCapacity;
    Label maxLoadCapacityLabel;
    TextField maxLoadCapacityInput;
    HBox packageadded;

    Label errorMessage;

    HBox buttons;
    Button closeButton;
    HBox label;
    Button doneButton;
    Button newTemplateButton;

    public AddPackageView() {
        vbox = new VBox();

        nameLabel = new Label("Name:");
        nameInput = new TextField();
        
        colourLabel = new Label("Farbe:");
        greenButton = new ToggleButton("gruen");
        greenButton.setUserData(Color.GREEN);
        greenButton.setStyle("-fx-base: green");
        redButton = new ToggleButton("rot");
        redButton.setUserData(Color.RED);
        redButton.setStyle("-fx-base: red");
        yellowButton = new ToggleButton("gelb");
        yellowButton.setUserData(Color.YELLOW);
        yellowButton.setStyle("-fx-base: orange");
        blueButton = new ToggleButton("blau");
        blueButton.setUserData(Color.BLUE);
        blueButton.setStyle("-fx-base: blue");
        colourInput = new VBox();
        HBox selColors1 = new HBox();
        selColors1.getChildren().addAll(greenButton, redButton);
        selColors1.setSpacing(5);
        colourInput.setSpacing(5);
        HBox selColors2 = new HBox();
        selColors2.getChildren().addAll(yellowButton, blueButton);
        selColors2.setSpacing(5);
        colourInput.getChildren().addAll(selColors1, selColors2);
        colourGroup = new ToggleGroup();
        greenButton.setToggleGroup(colourGroup);
        redButton.setToggleGroup(colourGroup);
        yellowButton.setToggleGroup(colourGroup);
        blueButton.setToggleGroup(colourGroup);

        widthLabel = new Label("Breite:");
        widthInput = new TextField();

        heightLabel = new Label("Hoehe:");
        heightInput = new TextField();

        weightLabel = new Label("Gewicht:");
        weightInput = new TextField();

        incompatibilityLabel = new Label("Unvertraeglichkeit:");
        incompatibilityColors = new VBox();
        incompRed = new ToggleButton("rot");
        incompRed.setUserData(Color.RED);
        incompRed.setStyle("-fx-base: red");
        incompGreen = new ToggleButton("gruen");
        incompGreen.setUserData(Color.GREEN);
        incompGreen.setStyle("-fx-base: green");
        incompYellow = new ToggleButton("gelb");
        incompYellow.setUserData(Color.YELLOW);
        incompYellow.setStyle("-fx-base: orange");
        incompBlue = new ToggleButton("blau");
        incompBlue.setUserData(Color.BLUE);
        incompBlue.setStyle("-fx-base: blue");
        HBox colors1 = new HBox();
        colors1.getChildren().addAll(incompGreen, incompRed);
        colors1.setSpacing(5);
        HBox colors2 = new HBox();
        colors2.getChildren().addAll(incompYellow, incompBlue);
        colors2.setSpacing(5);
        incompatibilityColors.setSpacing(5);
        incompatibilityColors.getChildren().addAll(colors1, colors2);

        maxLoadCapacityLabel = new Label("max. Traglast:");
        maxLoadCapacityInput = new TextField();

        //addIncompatibilityColourButton = new Button("+");
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
        incompatibility.getChildren().addAll(incompatibilityLabel, incompatibilityColors);
        incompatibility.setSpacing(9);

        maxLoadCapacity = new HBox();
        maxLoadCapacity.getChildren().addAll(maxLoadCapacityLabel, maxLoadCapacityInput);
        maxLoadCapacity.setSpacing(18);
        
        errorMessage = new Label("");
        errorMessage.setTextFill(Color.RED);

        buttons = new HBox(doneButton, newTemplateButton);
        buttons.setSpacing(12);
        buttons.setPadding(new Insets(30,0,128,0));
        
        packageadded = new HBox(new Label("Paket hinzufuegen"));
        closeButton = new Button("x");
        label = new HBox();
        label.getChildren().addAll(packageadded, closeButton);
        packageadded.setPadding(new Insets(5, 130, 5, 2));
        label.setSpacing(10);

        vbox.getChildren().addAll(label, name, colour, width, height, weight, incompatibility, maxLoadCapacity, errorMessage);
        vbox.getChildren().addAll(buttons);

        vbox.getStyleClass().addAll("background");

        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.setSpacing(12);
        
        closeButton.setId("rot");
        doneButton.setId("green");
        newTemplateButton.setId("gelb");
        packageadded.setId("grau");

        this.setContent(vbox);
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

    public ToggleButton getIncompRed() {
        return incompRed;
    }

    public ToggleButton getIncompGreen() {
        return incompGreen;
    }

    public ToggleButton getIncompYellow() {
        return incompYellow;
    }

    public ToggleButton getIncompBlue() {
        return incompBlue;
    }

    public HBox getColour() {
        return colour;
    }

    public Label getColourLabel() {
        return colourLabel;
    }

    public VBox getColourInput() {
        return colourInput;
    }

    public ToggleGroup getColourGroup(){
        return colourGroup;
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

    public VBox getIncompatibilityColors() {
        return incompatibilityColors;
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

    public Label getErrorMessageLabel() {
    	return errorMessage;
    }

    public Button getCloseButton() {
        return closeButton;
    }

    public Button getDoneButton() {
        return doneButton;
    }

    public Button getNewTemplateButton() {
        return newTemplateButton;
    }

    public VBox getVbox(){
        return vbox;
    }

    public VBox getIncompatibilityColours(){
        return incompatibilityColors;
    }
}