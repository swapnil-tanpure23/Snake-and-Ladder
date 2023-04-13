package com.example.snakeladder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeLadder extends Application {
    public static final int tilesize=40, width=10, height=10;
    public static final int buttonline = width*tilesize + 50, infoline = buttonline - 30;
    private Pane createContent(){
        Pane root = new Pane();

        root.setPrefSize(width*tilesize, height*tilesize + 100);

        for (int i = 0; i <height ; i++) {
            for (int j = 0; j <width ; j++) {
                Tile tile = new Tile(tilesize);
                tile.setTranslateX(j*tilesize);
                tile.setTranslateY(i*tilesize);
                root.getChildren().add(tile);
            }
        }

        Image image = new Image("D:\\Acciojob projects\\Snake and Ladder\\Snake Ladder\\istockphoto-531466314-612x612.jpg");
        ImageView board = new ImageView();
        board.setImage(image);
        board.setFitHeight(height*tilesize);
        board.setFitWidth(width*tilesize);

        Button playerOne = new Button("Player 1");
        Button playerTwo = new Button("Player 2");
        Button startButton = new Button("Start");

        playerOne.setTranslateY(buttonline);
        playerOne.setTranslateX(20);

        playerTwo.setTranslateY(buttonline);
        playerTwo.setTranslateX(320);

        startButton.setTranslateY(buttonline);
        startButton.setTranslateX(180);

        Label playeronelabel = new Label("Your Turn!");
        Label playertwolabel = new Label("Your Turn!");
        Label dicelabel = new Label("Start The Game...!");

        playeronelabel.setTranslateY(infoline);
        playeronelabel.setTranslateX(20);

        playertwolabel.setTranslateY(infoline);
        playertwolabel.setTranslateX(320);

        dicelabel.setTranslateY(infoline);
        dicelabel.setTranslateX(160);

        root.getChildren().addAll(board, playerTwo, playerOne, startButton, playeronelabel, playertwolabel, dicelabel);

        return root;
     }


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SnakeLadder.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Snake and Ladder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}