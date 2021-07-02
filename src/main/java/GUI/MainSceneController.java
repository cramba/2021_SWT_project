package GUI;

import Business.ShelfManager.ShelfManager;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class MainSceneController extends ViewController{

    Button addPackageButton;
    Button editShelfButton;

	MainScene view;
	
	
	EditShelfView editShelfView ; 

    public MainSceneController(ShelfManager shelfManager){
    	super(shelfManager);
    	
    	
    	
    	view = new MainScene(shelfManager) ;
        addPackageButton = view.getConfigurationViewController().getView().getAddPackageButton();
        editShelfButton = view.getConfigurationViewController().getView().getShelfEditButton();
    	root = view;
    	
    	editShelfView = view.getEditShelfViewController().getView();

        initialize();
    }
    public void initialize(){
    	
    	//pop up addPackage oeffnen
        addPackageButton.setOnAction((e) -> {
            AddPackageView addPackageView = view.getAddPackageViewController().getView();
            view.setLeft(addPackageView);
            addPackageView.setVisible(true);
            addPackageView.managedProperty().bind(addPackageView.visibleProperty());
            //view.getAddPackageViewController().getView().setManaged(false);
        });
        
      //pop up EditShelf �ffnen
        editShelfButton.setOnAction((e) -> {
   
            EditShelfView editShelfView = (EditShelfView) view.getEditShelfViewController().getRoot();
            view.setLeft(editShelfView);
            editShelfView.setVisible(true);
            editShelfView.managedProperty().bind(editShelfView.visibleProperty());

        });
        

        
        
    }
}
