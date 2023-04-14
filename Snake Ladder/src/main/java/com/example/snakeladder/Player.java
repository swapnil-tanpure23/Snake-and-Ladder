package com.example.snakeladder;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Player {

    private Circle coin;

    private int currentPosition;

    private String name;

    private static Board gameboard = new Board();

    public Player(int tilesize, Color coinColor, String playername){
        coin = new Circle(tilesize/2);
        coin.setFill(coinColor);
        currentPosition =1;
        name = playername;


    }
    public void movePlayer(int diceValue){
        if(currentPosition+diceValue<=100){
            currentPosition+=diceValue;

        int x = gameboard.getXCordinate(currentPosition);
        int y = gameboard.getYCordinate(currentPosition);
        coin.setTranslateX(x);
        coin.setTranslateY(y);
        }
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
