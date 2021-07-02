package GUI;

import Business.Package.Package;
import Business.ShelfManager.ShelfManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;


public class AddPackageViewController extends ViewController {
    AddPackageView view;

    Button closeButton;
    Button addIncompatibilityColourButton;
    Button doneButton;
    Button newTemplateButton;
    Label errorMessage;
    TextField nameInput;

    ToggleGroup colorGroup;

    //ToggleButtons
    ToggleButton greenToggle;
    ToggleButton redToggle;
    ToggleButton yellowToggle;
    ToggleButton blueToggle;

    List<Color> incompColours;

    Color packageColour;
    TrayViewController trayViewController;

    public AddPackageViewController(ShelfManager shelfManager, TrayViewController trayViewController) {
        super(shelfManager);
        this.trayViewController = trayViewController;
        view = new AddPackageView();
        colorGroup = view.getColourGroup();
        closeButton = view.getCloseButton();
        doneButton = view.getDoneButton();
        newTemplateButton = view.getNewTemplateButton();
        packageColour = Color.WHITE;
        nameInput = view.getNameInput();
        errorMessage = view.getErrorMessageLabel();

        greenToggle = view.getIncompGreen();
        redToggle = view.getIncompRed();
        yellowToggle = view.getIncompYellow();
        blueToggle = view.getIncompBlue();

        root = (Pane) view.getContent();
        initialize();

    }

    public void initialize() {

        colorGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (newValue != null) {
                    packageColour = (Color) newValue.getUserData();
                } else {
                    packageColour = Color.GREY;
                }
            }
        });
        
        closeButton.setOnAction((e) -> {
            view.setVisible(false);
        });
        

        doneButton.setOnAction((e) -> {
            if (validInput()) {
               shelfManager.packageProp().setValue(newPackage());
            }
        });
        
        newTemplateButton.setOnAction((e) -> {
            if (validInput()) {
                shelfManager.addPackageTemplate(newPackage());
                shelfManager.newTemplateProp().setValue(true);
            }
        });
        
        
    }

    /**
     * Eingaben werden auf Richtigkeit ueerprueft
     * @return
     */
    public boolean validInput() {
    	errorMessage.setText("");
    	//name Input
    	if(view.getNameInput().getText().equals("")) {
    		errorMessage.setText("Gib deinem Paket noch einen Namen");
    		return false;

    	}else if(view.getNameInput().getText().length() >= 15) {
    		errorMessage.setText("Der Name darf nicht länger als 15 Zeichen sein");
    		return false;
    	}

    	//Breite
    	if(!isInt(view.getWidthInput().getText())) {
    		errorMessage.setText("Bitte gebe eine gültige Breite ein");
    		return false;
    	}

    	//Höhe
    	if(!isInt(view.getHeightInput().getText())) {
    		errorMessage.setText("Bitte gebe eine gültige Höhe ein");
    		return false;
    	}

    	//Gewicht
    	if(!isFloat(view.getWeightInput().getText())) {
    		errorMessage.setText("Bitte gebe ein gültiges Gewicht ein");
    		return false;
    	}

    	//Traglast
    	if(!isFloat(view.getMaxLoadCapacityInput().getText())) {
    		errorMessage.setText("Bitte gebe eine gültige Traglast ein");
    		return false;
    	}
    	return true;
    }
    
    public boolean isInt(String number) {
    	if(number == null) {
    		return false;
    	}
    	try {
    		int i = Integer.parseInt(number);
    	} catch(NumberFormatException nfe) {
    		return false;
    	}
    	return true;
    }
    
    public boolean isFloat(String number) {
    	if(number == null) {
    		return false;
    	}
    	try {
    		float f = Float.parseFloat(number);
    	} catch(NumberFormatException nfe) {
    		return false;
    	}
    	return true;
    }
    
    public Package newPackage() {
        String name = view.getNameInput().getText();
        int height = Integer.parseInt(view.getHeightInput().getText());
        int width = Integer.parseInt(view.getWidthInput().getText());
        float weight = Float.parseFloat(view.getWeightInput().getText());
        Color colour = packageColour;
        float loadCapacity = Float.parseFloat(view.getMaxLoadCapacityInput().getText());
        Package newPck = new Package(name, height, width, weight, colour, loadCapacity);
        List<Color> incompColours = new ArrayList<>();
        if(blueToggle.isSelected())
            incompColours.add((Color) blueToggle.getUserData());
        if(redToggle.isSelected())
            incompColours.add((Color) redToggle.getUserData());
        if(yellowToggle.isSelected())
            incompColours.add((Color) yellowToggle.getUserData());
        if(greenToggle.isSelected())
            incompColours.add((Color) greenToggle.getUserData());
        newPck.setIncompatibility(incompColours);
        for(Color c: incompColours){
            System.out.println(c);
        }
        view.getNameInput().clear();
        view.getHeightInput().clear();
        view.getWidthInput().clear();
        view.getWeightInput().clear();
        view.getMaxLoadCapacityInput().clear();
        
        return newPck;
    }

    public AddPackageView getView() {
        return view;
    }
}
