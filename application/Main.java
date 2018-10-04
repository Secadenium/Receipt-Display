package application;

import controller.ShowController;
import controller.ViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("../view/Type.fxml"));
        primaryStage.setTitle("Receipt Input");
        primaryStage.setScene(new Scene(gameLoader.load(), 1000, 600));
        ViewController controller1 = gameLoader.getController();
        primaryStage.show();

        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../view/Show.fxml"));
        Stage stage = new Stage ();
        stage.setTitle("Receipt Output");
        stage.setScene(new Scene(loader2.load(), 1108, 726));
        ShowController controller2 = loader2.getController();
        controller1.setMaster(controller2);
        stage.show();
    }
}
