import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;

import java.io.File;

/**
 * Created by RikkiTheTramp on 15/05/18.
 */
public class Controller {

    private final VBox root;
    private Label fileInfo;
    private Label fileName;
    private HBox hBox;

    public Controller(VBox root){
        this.root = root;
        fileInfo = new Label();
        fileName = new Label();
        hBox = new HBox();
        root.getChildren().addAll(fileName, fileInfo, hBox);
    }

    public void initialize(){

        root.setSpacing(5);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(5));
        root.setOnDragOver(ev -> ev.acceptTransferModes(TransferMode.COPY));
        root.setOnDragDropped(this::dragFile);

        fileName.setText("Wave file");
        fileName.setWrapText(true);
        fileName.setTextAlignment(TextAlignment.CENTER);
        fileName.setMinHeight(30);
        fileName.setStyle("-fx-font-weight: bold");

        fileInfo.setText("Wave file information");
        fileInfo.setWrapText(true);
        fileInfo.setTextAlignment(TextAlignment.LEFT);
        fileInfo.setMinHeight(100);

        hBox.setSpacing(5);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(5));
        //hBox.setPrefWidth(400);
        //hBox.setPrefHeight(200);

        Button openFileButton = new Button("Open Wave File");
        openFileButton.setOnMouseClicked(ev -> chooseFile());

        Button exitButton = new Button("Exit Application");
        exitButton.setOnMouseClicked(ev -> Platform.exit());

        hBox.getChildren().addAll(openFileButton, exitButton);
    }

    private void dragFile(DragEvent dragEvent) {
        openFile(dragEvent.getDragboard().getFiles().get(0));
    }

    private void chooseFile() {
        openFile(new FileChooser().showOpenDialog(null));
    }


    private void openFile(File file) {
        if (file == null){
            System.err.println("No file chosen");
        }else {

            try (WaveFileReader wfr = new WaveFileReader(file)){

                WaveFile wf = wfr.getWaveFile();

                fileName.setText(wf.getFileName());

                String text = "";
                for (Chunk chunk : wf.getChunks()) {
                    text += chunk + "\n\n";
                }
                fileInfo.setText(text);
            } catch (Exception e) {
                System.err.println("Error while reading file");
                e.printStackTrace();
            }
        }

    }
}
