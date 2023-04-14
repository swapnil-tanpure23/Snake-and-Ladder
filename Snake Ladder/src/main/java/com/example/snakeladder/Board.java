package com.example.snakeladder;

import javafx.geometry.Pos;
import javafx.util.Pair;

import java.util.ArrayList;

public class Board {
    ArrayList<Pair<Integer,Integer>> PositionCordinates;

    public Board(){
        PositionCordinates = new ArrayList<>();
        populatePostionCordinates();
    }

    private void populatePostionCordinates(){

        PositionCordinates.add(new Pair<>(0,0));
        for (int i = 0; i < SnakeLadder.height; i++) {
            for (int j = 0; j < SnakeLadder.width; j++) {
                int xCord = 0;
                if (i % 2 == 0) {
                    xCord = j * SnakeLadder.tilesize + SnakeLadder.tilesize / 2;
                } else {

                    xCord = SnakeLadder.tilesize * SnakeLadder.height - (j * SnakeLadder.tilesize) - SnakeLadder.tilesize / 2;

                }
                int yCord = SnakeLadder.tilesize * SnakeLadder.height - (i * SnakeLadder.tilesize) - SnakeLadder.tilesize / 2;
                PositionCordinates.add(new Pair<>(xCord, yCord));
            }
        }

    }
    int getXCordinate(int position){
        if(position>=1 && position<=100)
            return PositionCordinates.get(position).getKey();
        return -1;
    }

    int getYCordinate(int position){
        if(position>=1 && position<=100)
            return PositionCordinates.get(position).getValue();
        return -1;
    }

//    public static void main(String[] args) {
//        Board board = new Board();
//        for (int i = 0; i < board.PositionCordinates.size(); i++) {
//            System.out.println(i + " $  x : " +  board.PositionCordinates.get(i).getKey() + "  Y : " + board.PositionCordinates.get(i).getValue());
//
//        }
//    }
}
