package GUI;

import Business.ShelfManager.ShelfManager;
import javafx.scene.layout.Pane;

public abstract class ViewController {
	
	protected Pane root;
	protected ShelfManager shelfManager ;
	
	public ViewController(ShelfManager shelfManager) {
		this.shelfManager = shelfManager; 
	}
	public abstract void initialize();
	
	public Pane getRoot() {
		return root;
	}
	

}