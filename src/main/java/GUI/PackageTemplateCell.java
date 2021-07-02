package GUI;

import Business.ShelfManager.ShelfManager;
import Business.Package.Package;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PackageTemplateCell extends ListCell<Package> {
	private HBox info1;
	private HBox info2;
	private VBox info;
	private Rectangle color;
	private Label packageName;
	private Label packageSpecification;
	private Button addPackage;
	private Label traglast;
	private Button removePackage;
	
	private ShelfManager shelfManager;
	
	
//	public PackageTemplateCell(ShelfManager shelfManager) {
//		mainRoot = new HBox();
//		this.shelfManager = shelfManager;
//		packageName = new Label();
//		packageSpecification = new Label();
//		addPackage = new Button("add");
//		
//		mainRoot.getChildren().addAll(packageName, packageSpecification, addPackage);
//		this.setGraphic(mainRoot);
//	}
	
	@Override
	public void updateItem(Package item, boolean empty) {
		super.updateItem(item, empty);
		
		if(!empty) {
			
			info1 = new HBox();
			color = new Rectangle(0,0, 20, 20);
			color.setFill(item.getColour());
			packageName = new Label(item.getName() + " ");
			packageSpecification = new Label(item.getSpecification());
			addPackage = new Button("add");
			
			info1.setSpacing(5);
			info1.getChildren().addAll(color, packageName, packageSpecification, addPackage);
			
			
			info2 = new HBox();
			traglast = new Label("Tragl.: " + item.getLoadCapacity() + "kg");
			Label unvertr = new Label("Unvertr.: ");
			info2.setSpacing(5);
			info2.getChildren().addAll(traglast, unvertr);
			for(Color c: item.getIncompatibility()) {
				Rectangle inc = new Rectangle(0, 0, 15, 15);
				inc.setFill(c);
				info2.getChildren().add(inc);
			}
			removePackage = new Button("del.");
			info2.getChildren().add(removePackage);
			
			info = new VBox();
			info.getChildren().addAll(info1, info2);
			
			setGraphic(info);
		
		}else {
			setGraphic(null);
		}
	}
	
	

}