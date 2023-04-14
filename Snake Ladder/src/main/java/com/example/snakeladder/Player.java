package com.example.snakeladder;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Player {

    private Circle coin;

    private int currentPosition;

    private String name;

    private static Board gameboard = new Board();

    public Player(int tilesize, Color coinColor, String playername){
        coin = new Circle(tilesize/2);
        coin.setFill(coinColor);
        currentPosition =0;
        movePlayer(1);
        name = playername;


    }
    public void movePlayer(int diceValue){
        if(currentPosition+diceValue<=100) {
            currentPosition += diceValue;
            TranslateTransition secondMove=null,firstMove = translateAnimation(diceValue);


            int newposition = gameboard.getNewPosition(currentPosition);
            if(newposition!=currentPosition && newposition!=-1){
                currentPosition=newposition;
                secondMove=translateAnimation(6);
            }
            if(secondMove == null){
                firstMove.play();
            }
            else{
                SequentialTransition sequentialTransition = new SequentialTransition(firstMove,
                        new PauseTransition(Duration.millis(1000)),secondMove
                        );
                sequentialTransition.play();
            }
        }
//        int x = gameboard.getXCordinate(currentPosition);
//        int y = gameboard.getYCordinate(currentPosition);
//        coin.setTranslateX(x);
//        coin.setTranslateY(y);


    }

    private TranslateTransition translateAnimation(int diceValue){
        TranslateTransition animation = new TranslateTransition(Duration.millis(200 * diceValue),coin);
        animation.setToX(gameboard.getXCordinate(currentPosition));
        animation.setToY(gameboard.getYCordinate(currentPosition));
        animation.setAutoReverse(false);
        return animation;
    }

    public void startingPosition(){
        currentPosition=0;
        movePlayer(1);
    }

    boolean isWinner(){
        if(currentPosition==100) return true;
        return false;
    }

    public Circle getCoin() {
        return coin;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getName() {
        return name;
    }
}
