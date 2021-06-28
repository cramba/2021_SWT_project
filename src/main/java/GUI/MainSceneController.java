package GUI;

import Business.ShelfManager.ShelfManager;
import javafx.scene.layout.Pane;

public class MainSceneController extends ViewController{
	
	Pane view;
	ShelfManager shelfManager ;

    public MainSceneController(ShelfManager shelfManager){
    	super(shelfManager);
    	
    	view = new MainScene(shelfManager) ;
    	root = view  ;

        initialize();
    }
    public void initialize(){
    	
    	
        
    }
}
