package GUI;

import Business.ShelfManager.ShelfManager;
import Business.Package.Package;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

public class PackageTemplateViewController extends ViewController{
	
	PackageTemplateView view;
	
	private ListView<Package>templateView;


    public PackageTemplateViewController(ShelfManager shelfManager){
    	super(shelfManager);
    	this.shelfManager = shelfManager;
    	view = new PackageTemplateView();
    	templateView = view.getTemplateView();
    	root = view;
    	
    	
         initialize();
    }

    public void initialize(){
    	
    	templateView.setCellFactory(new Callback<ListView<Package>, ListCell<Package>>() {

			@Override
			public ListCell<Package> call(ListView<Package> param) {
				// TODO Auto-generated method stub
				return new PackageTemplateCell(shelfManager);
			}
			
		});
    	
    	ObservableList<Package> uiModel = templateView.getItems();
		uiModel.addAll(shelfManager.getTemplateList()); 

    }
}
