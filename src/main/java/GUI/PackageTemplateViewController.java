package GUI;

import Business.ShelfManager.ShelfManager;

import java.util.ArrayList;
import java.util.List;

import Business.Package.Package;
import javafx.beans.InvalidationListener;
import javafx.beans.property.ListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

public class PackageTemplateViewController extends ViewController{
	
	private ObservableList<Package> lstTemplate;
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
    	
    	
    	
    	templateView.setCellFactory(
    			
    			new Callback<ListView<Package>, ListCell<Package>>() {
    				
    				@Override
    				public ListCell<Package> call(ListView<Package> v) {
    					return new PackageTemplateCell();
    				}
    				
    			});
    	    	
    	
//    	ObservableList<Package> lstTemplate = templateView.getItems();
 //   	lstTemplate.addAll(shelfManager.getTemplateList()); 
    	
    	lstTemplate = FXCollections.observableArrayList(shelfManager.getTemplateList());
    	templateView.setItems(lstTemplate);
    	
    	
//    	lstTemplate.addListener(new ListChangeListener<Package>() {
//            @Override
//            public void onChanged(Change<? extends Package> c) {
//                System.out.println("Changed on " + c);
//                while(c.next()){
//                    System.out.println("HI");
//                    
//                }
//
//            }
//
//        });
    	
//    	lstTemplate.addListener(new InvalidationListener() {
//    	@Override
//    	public void invalidated(javafx.beans.Observable observable) {
//    		System.out.println("change");
//    	}
//    	});
    	
    	shelfManager.newTemplateProp().addListener(new ChangeListener<Boolean>() {
    		
    		@Override
    		public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
    			if(newValue.booleanValue() == true) {
    				if(shelfManager.newTemplateProp().getValue() != null) {
    					lstTemplate = FXCollections.observableArrayList(shelfManager.getTemplateList());
    			    	templateView.setItems(lstTemplate);
    					shelfManager.newTemplateProp().setValue(false);
    				}
    			}
    		}
    	});
    	
    }
    
    
}
