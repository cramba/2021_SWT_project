package GUI;
import javafx.scene.control.Label;
import Business.Package.Package;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PackageTemplateView extends BorderPane {

	private Label heading;
	private ListView<Package> templateView;
	
    public PackageTemplateView(){
    	
    	heading = new Label("Paketvorlagen");
    	this.setTop(heading);
    	
    	templateView = new ListView<Package>();
    	this.setCenter(templateView);


    }
    
    public ListView<Package> getTemplateView() {
    	return templateView;
    }
}
