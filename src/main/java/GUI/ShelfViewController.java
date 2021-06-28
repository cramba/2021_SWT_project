package GUI;

import Business.ShelfManager.ShelfManager;
import javafx.scene.layout.Pane;

public class ShelfViewController extends ViewController{
	Pane view;


    public ShelfViewController(ShelfManager shelfManager){
    	super(shelfManager);
    	view = new ShelfView();
    	root = view;

         initialize();
    }
    public void initialize(){

    }
}
