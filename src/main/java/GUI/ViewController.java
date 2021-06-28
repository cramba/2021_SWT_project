package GUI;

import javafx.scene.layout.Pane;
public abstract class ViewController{
    Pane view;

    public Pane getRootView(){
        return view;
    }
}
