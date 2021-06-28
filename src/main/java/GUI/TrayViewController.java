package GUI;

import Business.Package.Package;

import Business.ShelfManager.ShelfManager;
import javafx.scene.layout.Pane;

public class TrayViewController extends ViewController{
	Pane view;

    public TrayViewController(ShelfManager shelfManager){
    	super(shelfManager);
        
    	initialize();
    }
    public void initialize(){

    }

    public void setPackageinTray(Package p){
        //Paket in Ablage setzen
    }
}
