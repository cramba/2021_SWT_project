package GUI;

import Business.ShelfManager.ShelfManager;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class MainSceneController extends ViewController{

    Button addPackageButton;

	MainScene view;
	ShelfManager shelfManager ;

    public MainSceneController(ShelfManager shelfManager){
    	super(shelfManager);
    	
    	view = new MainScene(shelfManager) ;
        addPackageButton = view.getConfigurationViewController().getView().getAddPackageButton();
    	root = view;

        initialize();
    }
    public void initialize(){
        addPackageButton.setOnAction((e) -> {
            AddPackageView addPackageView = view.getAddPackageViewController().getView();
            addPackageView.setVisible(true);
            addPackageView.managedProperty().bind(addPackageView.visibleProperty());
            //view.getAddPackageViewController().getView().setManaged(false);
        });
    }
}
