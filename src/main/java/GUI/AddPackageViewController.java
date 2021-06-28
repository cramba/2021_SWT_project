package GUI;

import javafx.scene.layout.Pane;
import Business.ShelfManager.ShelfManager;


public class AddPackageViewController extends ViewController{
    
	Pane view;

    public AddPackageViewController(ShelfManager shelfManager){
    	super(shelfManager);
        view = new AddPackageView();
        root = view;
        initialize();
    }

    public void initialize(){

    }
}
