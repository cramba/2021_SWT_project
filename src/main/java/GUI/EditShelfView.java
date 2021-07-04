package GUI;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class EditShelfView extends VBox {
	
	ComboBox<String> shelfItemSelection;
	
	Label lengthLabel;
	TextField lengthInput;

	HBox hBox;
	HBox hBox2;
	Button closeButton;
    Button doneButton;
    
    Label editShelfSupportLabel;
    Button deleteShelfSupportButton;
    Label moveShelfSupportLabel;
    TextField moveShelfSupportTextField;

    
    Label loadCapacityLabel;
    TextField loadCapacityTextField;
    Button doneButton2 ;
    Button deleteShelfFloorButton ; 
    
    private Label errorMessage;

    public EditShelfView(){
    	
    	//Regalstuetzen bearbeitung
    	shelfItemSelection =  new ComboBox<String>();
    	shelfItemSelection.getItems().addAll("Regalstuetze","Regalboden");
    	shelfItemSelection.setId("ShelfItemSelection");
    	shelfItemSelection.getSelectionModel().selectFirst();
    	lengthLabel = new Label("Laenge (cm):");
    	lengthInput = new TextField();
    	hBox = new HBox();
    	hBox2 = new HBox();
    	closeButton = new Button("x");
    	doneButton = new Button("Fertig"); 
    	
    	hBox.getChildren().addAll(lengthLabel, lengthInput);
    	
    	hBox.setSpacing(50);
    	//zusatz fuer Regalstuetzen loeschen :
    	//zusatz fuer Regalstuetzen loeschen :
    	
    	editShelfSupportLabel = new Label("Bearbeiten:");
    	deleteShelfSupportButton = new Button("Loeschen");
    	deleteShelfSupportButton.setVisible(false);
    	moveShelfSupportLabel = new Label("Verschieben");
    	moveShelfSupportTextField = new TextField();

    	//Regalb�den bearbeitung
    	
    	this.getStyleClass().addAll("background");
    	
    	this.setPadding(new Insets(20, 20, 20, 20));
    	this.setSpacing(12);
    	
    	doneButton.setId("green");
    	
    	errorMessage = new Label("");
    	errorMessage.setTextFill(Color.RED);
    	
    	this.getChildren().addAll(shelfItemSelection,hBox, errorMessage, doneButton, deleteShelfSupportButton);

    	//Regalb�den bearbeitung
    	
    	
    	loadCapacityLabel = new Label("Tragkraft (kg):");
    	loadCapacityTextField = new TextField();
    	doneButton2 = new Button("Fertig"); 
    	deleteShelfFloorButton = new Button("Loeschen");
    	deleteShelfFloorButton.setVisible(false);

    }

	public Button getDoneButton2() {
		return doneButton2;
	}

	public Label getLoadCapacityLabel() {
		return loadCapacityLabel;
	}

	public TextField getLoadCapacityTextField() {
		return loadCapacityTextField;
	}

	public Label getEditShelfSupportLabel() {
		return editShelfSupportLabel;
	}

	public Button getDeleteShelfSupportButton() {
		return deleteShelfSupportButton;
	}

	public Label getMoveShelfSupportLabel() {
		return moveShelfSupportLabel;
	}

	public TextField getMoveShelfSupportTextField() {
		return moveShelfSupportTextField;
	}

	public Button getDoneButton() {
		return doneButton;
	}
	
	public Button getCloseButton() {
		return closeButton;
	}


	public ComboBox<String> getShelfItemSelection() {
		return shelfItemSelection;
	}


	public Label getLengthLabel() {
		return lengthLabel;
	}



	public TextField getLengthInput() {
		return lengthInput;
	}


	public HBox getHBox() {
		// TODO Auto-generated method stub
		return hBox;
	}
	
	
	
	public Button getDeleteShelfFloorButton() {
		return deleteShelfFloorButton;
	}
	
	public Label getErrorMessage() {
		return errorMessage;
	}

}
