package GUI;
import javafx.geometry.Insets;
import javafx.scene.Node;
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
	Label distanceLabel;

	TextField distanceInput;
	HBox hBox;
	HBox hBox2;
	Button closeButton;
    Button doneButton;
    
    Label editShelfSupportLabel;
    Button deleteShelfSupportButton;
    Label moveShelfSupportLabel;
    TextField moveShelfSupportTextField;


    public EditShelfView(){
    	
    	//Regalstützen bearbeitung
    	shelfItemSelection =  new ComboBox<String>();
    	shelfItemSelection.getItems().addAll("Regalstütze","Regalboden");
    	shelfItemSelection.setId("ShelfItemSelection");
    	shelfItemSelection.getSelectionModel().selectFirst();
    	lengthLabel = new Label("Länge:");
    	lengthInput = new TextField();
    	hBox = new HBox();
    	distanceLabel = new Label("Abstand:");
    	distanceInput = new TextField();
    	hBox2 = new HBox();
    	closeButton = new Button("x");
    	doneButton = new Button("Fertig"); 
    	
    	hBox.getChildren().addAll(lengthLabel, lengthInput);
    	hBox2.getChildren().addAll(distanceLabel,distanceInput);
    	this.getChildren().addAll(shelfItemSelection,hBox,hBox2,doneButton);
    	
    	hBox.setSpacing(65);
    	hBox2.setSpacing(50);
    	//zusatz für Regalstützen löschen :
    	
    	editShelfSupportLabel = new Label("Bearbeiten:");
    	deleteShelfSupportButton = new Button("Löschen");
    	moveShelfSupportLabel = new Label("Verschieben");
    	moveShelfSupportTextField = new TextField();
    	//Regalböden bearbeitung
    	
    	this.getStyleClass().addAll("background");
    	
    	this.setPadding(new Insets(55, 20, 20, 20));
    	this.setSpacing(12);
    	
    	doneButton.setId("green");
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
	
	public TextField getDistanceInput() {
		return distanceInput;
	}

	public HBox getHBox() {
		// TODO Auto-generated method stub
		return hBox;
	}
	
	public HBox getHBox2() {
		// TODO Auto-generated method stub
		return hBox2;
	}


    
    

}
