package GUI;

import Business.Package.Package;

import Business.ShelfManager.ShelfManager;
import javafx.scene.layout.Pane;

public class TrayViewController extends ViewController{
	TrayView view;

    public TrayViewController(ShelfManager shelfManager){
    	super(shelfManager);
    	view = new TrayView();
    	root = view  ;
        
    	initialize();
    }
    public void initialize(){

    }

    public void setPackageinTray(Package p){
        //Paket in Ablage setzen
    }
}
