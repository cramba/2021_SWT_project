package GUI;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EditShelfView extends VBox {
	
	ComboBox<String> shelfItemSelection;
	
	Label lengthLabel;
	TextField lengthInput;
	HBox hBox;
	Button closeButton;
    Button doneButton;
    public EditShelfView(){
    	
    	shelfItemSelection =  new ComboBox<String>();
    	shelfItemSelection.getItems().addAll("Regalstütze","Regalboden");
    	lengthLabel = new Label("Länge:");
    	lengthInput = new TextField();
    	hBox = new HBox();
    	closeButton = new Button("x");
    	doneButton = new Button("Fertig"); 
    	
    	hBox.getChildren().addAll(lengthLabel, lengthInput);
    	this.getChildren().addAll(shelfItemSelection,hBox,doneButton);
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


    
    

}
