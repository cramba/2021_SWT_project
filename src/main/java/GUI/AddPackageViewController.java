package GUI;

import Business.Package.Package;
import Business.ShelfManager.ShelfManager;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class AddPackageViewController extends ViewController{
    AddPackageView view;

    Button closeButton;
    Button addIncompatibilityColour;
    Button doneButton;
    Button newTemplateButton;

    ShelfManager shelfManager;
    TrayViewController trayViewController;

    public AddPackageViewController(ShelfManager shelfManager, TrayViewController trayViewController){
        this.shelfManager = shelfManager;
        this.trayViewController = trayViewController;
        view = new AddPackageView();

        closeButton = view.getCloseButton();
        addIncompatibilityColour = view.getAddIncompatibilityColour();
        doneButton = view.getDoneButton();

        initialize();
    }

    public void initialize(){
        closeButton.setOnAction((e) -> {
            view.setVisible(false);
        });

        addIncompatibilityColour.setOnAction((e) -> {
            ColorPicker newColor = new ColorPicker();
            view.getIncompatibilityInput().getChildren().add(newColor);
        });

        doneButton.setOnAction((e) -> {
            String name = view.getNameLabel().getText();
            int height = Integer.parseInt(view.getHeightInput().getText());
            int width = Integer.parseInt(view.getWidthInput().getText());
            float weight = Float.parseFloat(view.getWeightInput().getText());
            Color colour = view.getColourInput().getValue();
            List<Color> incompatibilityColors = new ArrayList<>();
            for(Node node: view.getIncompatibility().getChildren()){
                if(node instanceof ColorPicker){
                    incompatibilityColors.add(((ColorPicker) node).getValue());
                }
            }
            Package newPck = new Package(name, height, width, weight, colour, 0, 0, incompatibilityColors);
            trayViewController.setPackageinTray(newPck);
        });
    }
}
