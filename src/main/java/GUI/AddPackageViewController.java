package GUI;

import Business.Package.Package;
import Business.ShelfManager.ShelfManager;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;

public class AddPackageViewController extends ViewController {
    AddPackageView view;

    Button closeButton;
    Button addIncompatibilityColourButton;
    Button doneButton;
    Button newTemplateButton;

    ComboBox<Color> colorComboBox;

    TrayViewController trayViewController;

    public AddPackageViewController(ShelfManager shelfManager, TrayViewController trayViewController) {
        super(shelfManager);
        this.trayViewController = trayViewController;
        view = new AddPackageView();

        closeButton = view.getCloseButton();
        addIncompatibilityColourButton = view.getAddIncompatibilityColourButton();
        doneButton = view.getDoneButton();

        colorComboBox = view.getColourInput();

        root = view;
        initialize();

    }

    public void initialize() {
        colorComboBox.setCellFactory(new Callback<ListView<Color>, ListCell<Color>>() {
            @Override public ListCell<Color> call(ListView<Color> p) {
                return new ListCell<Color>() {
                    private final Rectangle rectangle;
                    {
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                        rectangle = new Rectangle(10, 10);
                    }

                    @Override protected void updateItem(Color item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setGraphic(null);
                        } else {
                            rectangle.setFill(item);
                            setGraphic(rectangle);
                        }
                    }
                };
            }
        });

        addIncompatibilityColourButton.setOnAction((e) -> {
            ComboBox<Color> comboBox = new ComboBox<>();
            view.getIncompatibilityInput().getChildren().add(comboBox);
        });

        addIncompatibilityColourButton.setOnAction((e) -> {
            ColorPicker newColor = new ColorPicker();
            view.getIncompatibilityInput().getChildren().add(newColor);
        });
        
        closeButton.setOnAction((e) -> {
            view.setVisible(false);
        });


        doneButton.setOnAction((e) -> {
            String name = view.getNameLabel().getText();
            int height = Integer.parseInt(view.getHeightInput().getText());
            int width = Integer.parseInt(view.getWidthInput().getText());
            float weight = Float.parseFloat(view.getWeightInput().getText());
            Color colour = view.getColourInput().getValue();
            List<Color> incompatibilityColors = new ArrayList<>();
            for (Node node : view.getIncompatibility().getChildren()) {
                if (node instanceof ColorPicker) {
                    incompatibilityColors.add(((ColorPicker) node).getValue());
                }
            }
            //Package newPck = new Package(name, height, width, weight, colour, 0, 0, incompatibilityColors);
            //trayViewController.setPackageinTray(newPck);
        });
    }

    public AddPackageView getView() {
        return view;
    }
}
