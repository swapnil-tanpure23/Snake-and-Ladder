package com.example.snakeladder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintStream;

public class SnakeLadder extends Application {
    public static final int tilesize=40, width=10, height=10;
    public static final int buttonline = width*tilesize + 50, infoline = buttonline - 30;

    private static Dice dice = new Dice();

    private boolean gameStarted = false, playerOneTurn=true, playerTwoTurn = false;

    private Player playerOne, playerTwo;

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

        Button playerOneButton = new Button("Player 1");
        Button playerTwoButton = new Button("Player 2");
        Button startButton = new Button("Start");

        playerOneButton.setTranslateY(buttonline);
        playerOneButton.setTranslateX(20);
        playerOneButton.setDisable(true);
        playerTwoButton.setTranslateY(buttonline);
        playerTwoButton.setTranslateX(320);
        playerTwoButton.setDisable(true);
        startButton.setTranslateY(buttonline);
        startButton.setTranslateX(180);

        Label playeronelabel = new Label("");
        Label playertwolabel = new Label("");
        Label dicelabel = new Label("Start The Game...!");

        playeronelabel.setTranslateY(infoline);
        playeronelabel.setTranslateX(20);

        playertwolabel.setTranslateY(infoline);
        playertwolabel.setTranslateX(320);

        dicelabel.setTranslateY(infoline);
        dicelabel.setTranslateX(160);

        playerOne = new Player(tilesize, Color.BLACK,"Pro");
        playerTwo = new Player(tilesize-5,Color.WHITE,"Coder");

        playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStarted){
                    if(playerOneTurn){
                        int dicevalue = dice.getRollDiceValue();
                        dicelabel.setText("Dice Value : "+ dicevalue);
                        playerOne.movePlayer(dicevalue);
                        if(playerOne.isWinner()){
                            dicelabel.setText("Winner is : " + playerOne.getName());
                            playerOneTurn = false;
                            playerOneButton.setDisable(true);
                            playeronelabel.setText("");

                            playerTwoTurn = true;
                            playerTwoButton.setDisable(true);
                            playertwolabel.setText("");

                            startButton.setDisable(false);
                            startButton.setText("Restart");

                            gameStarted = false;
                        }
                        else{
                            playerOneTurn = false;

                            playerOneButton.setDisable(true);
                            playeronelabel.setText("");

                            playerTwoTurn = true;
                            playerTwoButton.setDisable(false);
                            playertwolabel.setText("Your Turn bro"+ playerTwo.getName());
                        }

                    }
                }

            }
        });

        playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStarted){
                    if(playerTwoTurn){
                        int dicevalue = dice.getRollDiceValue();
                        dicelabel.setText("Dice Value : "+ dicevalue);
                        playerTwo.movePlayer(dicevalue);
                        if(playerTwo.isWinner()){
                            dicelabel.setText("Winner is : " + playerTwo.getName());
                            playerOneTurn = false;
                            playerOneButton.setDisable(true);
                            playeronelabel.setText("");

                            playerTwoTurn = true;
                            playerTwoButton.setDisable(false);
                            playertwolabel.setText("");

                            startButton.setDisable(true);
                            startButton.setText("Restart");
                        }
                        else{
                            playerOneTurn = true;
                            playerOneButton.setDisable(false);
                            playeronelabel.setText("Your Turn Pro"+ playerOne.getName());

                            playerTwoTurn = false;
                            playerTwoButton.setDisable(true);
                            playertwolabel.setText("");
                        }

                    }
                }

            }
        });

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameStarted = true;
                dicelabel.setText("Game Started");
                startButton.setDisable(true);
                playerOneTurn = true;
                playeronelabel.setText("Your Turn" + playerOne.getName());
                playerOneButton.setDisable(false);
                playerOne.startingPosition();


                playerTwoTurn = false;
                playertwolabel.setText("");
                playerTwoButton.setDisable(true);
                playerTwo.startingPosition();
            }
        });

        root.getChildren().addAll(board, playerTwoButton, playerOneButton, startButton,
                playeronelabel, playertwolabel, dicelabel, playerOne.getCoin(), playerTwo.getCoin()

        );

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