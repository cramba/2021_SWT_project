package Application;
import GUI.MainScene;
import GUI.MainSceneController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

import Business.ShelfManager.ShelfManager;

public class Main extends Application {
//testkommentar3
    private Stage primaryStage;
    private Scene scene;
    private ShelfManager shelfManager;
    private MainSceneController rootController ; 

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        shelfManager = new ShelfManager();
        rootController = new MainSceneController(shelfManager);
     
        Pane root = rootController.getRoot();
        primaryStage.setTitle("Warehouse Masters!");
        scene = new Scene(root, 1450, 740);
        scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
        
        primaryStage.setScene(scene);
        System.out.println("Fertig");
        primaryStage.show();
    }

    public void stop(){
        System.exit(0);
    }
}
