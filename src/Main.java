import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by RikkiTheTramp on 13/05/18.
 */
public class Main extends Application{

    public static void main(String[] args) throws IOException {
        //int[] tst = new int[]{'L', 'I', 'S', 'T'};
        //System.out.println("L, I, S, T\n" + Arrays.toString(tst));
        Application.launch();
    }

    public void start(Stage primaryStage) throws IOException {
        VBox root = new VBox();

        Scene scene = new Scene(root, 300, 500);

        Controller cont = new Controller(root);
        cont.initialize();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Wave File Information");
        //primaryStage.setResizable(false);
        primaryStage.show();

    }
}
