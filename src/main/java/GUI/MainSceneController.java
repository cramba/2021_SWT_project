package GUI;

import Business.ShelfManager.ShelfManager;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class MainSceneController extends ViewController{

    Button addPackageButton;
    Button editShelfButton;

	MainScene view;
	ShelfManager shelfManager ;

    public MainSceneController(ShelfManager shelfManager){
    	super(shelfManager);
    	
    	view = new MainScene(shelfManager) ;
        addPackageButton = view.getConfigurationViewController().getView().getAddPackageButton();
        editShelfButton = view.getConfigurationViewController().getView().getShelfEditButton();
    	root = view;

        initialize();
    }
    public void initialize(){
        addPackageButton.setOnAction((e) -> {
            AddPackageView addPackageView = view.getAddPackageViewController().getView();
            view.setLeft(addPackageView);
            addPackageView.setVisible(true);
            addPackageView.managedProperty().bind(addPackageView.visibleProperty());
            //view.getAddPackageViewController().getView().setManaged(false);
        });
        
        editShelfButton.setOnAction((e) -> {
   
            EditShelfView editShelfView = (EditShelfView) view.getEditShelfViewController().getRoot();
            view.setLeft(editShelfView);
            editShelfView.setVisible(true);
            editShelfView.managedProperty().bind(editShelfView.visibleProperty());
        	


            //view.getAddPackageViewController().getView().setManaged(false);
        });
    }
}
