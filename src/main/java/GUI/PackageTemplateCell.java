package GUI;

import Business.ShelfManager.ShelfManager;
import Business.Package.Package;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

public class PackageTemplateCell extends ListCell<Package> {
	HBox mainRoot;
	//testkommentar
	private Label packageName;
	private Label packageSpecification;
	private Button addPackage;
	
	private ShelfManager shelfManager;
	
	
	public PackageTemplateCell(ShelfManager shelfManager) {
		mainRoot = new HBox();
		this.shelfManager = shelfManager;
		packageName = new Label();
		packageSpecification = new Label();
		addPackage = new Button("add");
		
		mainRoot.getChildren().addAll(packageName, packageSpecification, addPackage);
		this.setGraphic(mainRoot);
	}
	
	@Override
	public void updateItem(Package item, boolean empty) {
		super.updateItem(item, empty);
		
		if(!empty) {
			packageName.setText(item.getName());
			packageSpecification.setText(item.getSpecification());
			
		}
	}

}