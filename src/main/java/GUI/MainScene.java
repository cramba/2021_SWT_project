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

	public AddPackageViewController getAddPackageViewController() {
		return addPackageViewController;
	}

	public ConfigurationViewController getConfigurationViewController() {
		return configurationViewController;
	}

	public EditShelfViewController getEditShelfViewController() {
		return editShelfViewController;
	}

	public PackageTemplateViewController getPackageTemplateViewController() {
		return packageTemplateViewController;
	}

	public ShelfViewController getShelfViewController() {
		return shelfViewController;
	}

	public TrayViewController getTrayViewController() {
		return trayViewController;
	}

	public VBox getSetRightVBox() {
		return setRightVBox;
	}

	public MainScene(ShelfManager shelfManager){

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
//    	this.setLeft(setRightVBox);
    	this.setRight(addPackageViewController.getRoot());
    	this.setBottom(configurationViewController.getRoot());
    	
    }
}
