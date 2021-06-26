package GUI;

import javafx.scene.layout.Pane;

public class AddPackageViewController extends ViewController{
    Pane view;

    public AddPackageViewController(){
        view = new AddPackageView();
        root = view;
        initialize();
    }

    public void initialize(){

    }
}
