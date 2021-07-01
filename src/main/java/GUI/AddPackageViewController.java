package GUI;

import Business.Package.Package;
import Business.ShelfManager.ShelfManager;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
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
    

    ComboBox<Color> colorComboBox;

    TrayViewController trayViewController;

    public AddPackageViewController(ShelfManager shelfManager, TrayViewController trayViewController) {
        super(shelfManager);
        this.trayViewController = trayViewController;
        view = new AddPackageView();

        closeButton = view.getCloseButton();
        addIncompatibilityColourButton = view.getAddIncompatibilityColourButton();
        doneButton = view.getDoneButton();
        errorMessage = view.getErrorMessageLabel();

        colorComboBox = view.getColourInput();

        root = view;
        initialize();

    }

    public void initialize() {
        colorComboBox.setCellFactory(new Callback<ListView<Color>, ListCell<Color>>() {
            @Override public ListCell<Color> call(ListView<Color> p) {
                return new ListCell<Color>() {
                    private final Rectangle rectangle;
                    {
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                        rectangle = new Rectangle(10, 10);
                    }

                    @Override protected void updateItem(Color item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setGraphic(null);
                        } else {
                            rectangle.setFill(item);
                            setGraphic(rectangle);
                        }
                    }
                };
            }
        });

        addIncompatibilityColourButton.setOnAction((e) -> {
            ComboBox<Color> comboBox = new ComboBox<>();
            view.getIncompatibilityInput().getChildren().add(comboBox);
        });

        addIncompatibilityColourButton.setOnAction((e) -> {
            ColorPicker newColor = new ColorPicker();
            view.getIncompatibilityInput().getChildren().add(newColor);
        });
        
        closeButton.setOnAction((e) -> {
            view.setVisible(false);
        });
        


        doneButton.setOnAction((e) -> {
            if(validInput()) {
            	 shelfManager.addPackageTemplate(newPackage());
            }
        });
    }
    //überptüft alle Eingabefelder auf Richtigkeit
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
    	
    	//Farbe
    	if(view.getColourInput().getValue() == null) {
    		errorMessage.setText("Bitte wähle eine Farbe aus");
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
    	 String name = view.getNameLabel().getText();
         int height = Integer.parseInt(view.getHeightInput().getText());
         int width = Integer.parseInt(view.getWidthInput().getText());
         float weight = Float.parseFloat(view.getWeightInput().getText());
         Color colour = view.getColourInput().getValue();
         /*List<Color> incompatibilityColors = new ArrayList<>();
         for (Node node : view.getIncompatibility().getChildren()) {
             if (node instanceof ColorPicker) {
                 incompatibilityColors.add(((ColorPicker) node).getValue());
             }
         }*/
         float loadCapacity = Float.parseFloat(view.getMaxLoadCapacityInput().getText());
         Package newPck = new Package(name, height, width, weight, colour, loadCapacity);
         return newPck;
    }

    public AddPackageView getView() {
        return view;
    }
}
