import GUI.MainScene;
import GUI.MainSceneController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application {

    private Stage primaryStage;
    private Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        //Pane root = new MainSceneController().getRoot();
        Pane root = new MainScene();
        primaryStage.setTitle("Warehouse Masters!");
        scene = new Scene(root, 800, 500);

        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public void stop(){
        System.exit(0);

    }
}
