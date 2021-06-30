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
    public EditShelfView(){
    	
    	//Regalst�tzen bearbeitung
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
    	this.getChildren().addAll(shelfItemSelection,hBox,hBox2,doneButton);
    	
    	//Regalb�den bearbeitung

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
