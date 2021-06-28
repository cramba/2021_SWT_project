package GUI;

import Business.ShelfManager.ShelfManager;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainScene extends BorderPane {
	
	AddPackageViewController addPackageViewController;
	ConfigurationViewController configurationViewController ; 
	EditShelfViewController editShelfViewController ; 
	PackageTemplateViewController packageTemplateViewController ; 
	ShelfViewController shelfViewController;
	TrayViewController trayViewController ; 
	VBox setRightVBox;

    public MainScene(ShelfManager shelfManager ){

        //Top
        //Left
        //Center -shelfView (Gridpane/Stackpane)
        //Right -packageTemplateView - Marc , TrayView  - Florian 
        //Bottom - configurationView (Hbox)   - Florian 

        //popUPFenster - addPackageView, (EditShelfView)  - Lena 


        //Logic: jeder versucht schonmal seine logic der Funktion die er im Laufzeidiagramm hatte zu implementieren.

    	trayViewController = new TrayViewController(shelfManager);
    	addPackageViewController = new AddPackageViewController(shelfManager, trayViewController);
    	configurationViewController = new ConfigurationViewController(shelfManager);
    	editShelfViewController = new EditShelfViewController(shelfManager);
    	packageTemplateViewController = new PackageTemplateViewController(shelfManager);
    	shelfViewController = new ShelfViewController(shelfManager);
    	setRightVBox = new VBox();
    	
    	
//    	setRightVBox.getChildren().addAll(packageTemplateViewController.getRoot(),trayViewController.getRoot());
    	

//    	this.setTop();
//   	this.setCenter(shelfViewController.getRoot());
//    	this.setRight(setRightVBox);
//    	this.setLeft();
    	this.setBottom(configurationViewController.getRoot());
    	
    }
}
