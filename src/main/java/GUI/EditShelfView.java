package GUI;
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
    	
    	//Regalstuetzen bearbeitung
    	shelfItemSelection =  new ComboBox<String>();
    	shelfItemSelection.getItems().addAll("Regalst�tze","Regalboden");
    	shelfItemSelection.setId("ShelfItemSelection");
    	shelfItemSelection.getSelectionModel().selectFirst();
    	lengthLabel = new Label("L�nge:");
    	lengthInput = new TextField();
    	hBox = new HBox();
    	distanceLabel = new Label("Abstand:");
    	distanceInput = new TextField();
    	hBox2 = new HBox();
    	closeButton = new Button("x");
    	doneButton = new Button("Fertig"); 
    	
    	hBox.getChildren().addAll(lengthLabel, lengthInput);
    	hBox2.getChildren().addAll(distanceLabel,distanceInput);
    	
    	//zusatz f�r Regalst�tzen l�schen :
    	
    	editShelfSupportLabel = new Label("Bearbeiten:");
    	deleteShelfSupportButton = new Button("L�schen");
    	deleteShelfSupportButton.setVisible(false);
    	moveShelfSupportLabel = new Label("Verschieben");
    	moveShelfSupportTextField = new TextField();
    	
    	this.getChildren().addAll(shelfItemSelection,hBox,hBox2,doneButton, deleteShelfSupportButton);

    	//Regalb�den bearbeitung

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
