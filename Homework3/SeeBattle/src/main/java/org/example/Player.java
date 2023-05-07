package org.example;

import java.util.Scanner;

public class Player {
    PlayerField playerField;
    RivalField rivalField = new RivalField();
    private final String name;

    public void setRivalPlayer(Player rivalPlayer) {
        this.rivalPlayer = rivalPlayer;
    }

    Player rivalPlayer;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void fillYourField() {
        playerField = new PlayerField();
        playerField.createPlayerField(this);
    }

    public ShotResult makeMove() {
        System.out.println(name + ", введите координаты вашего выстрела");
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        Position shotPosition = new Position(Integer.parseInt(input[0]) - 1, Integer.parseInt(input[1]) - 1);
        ShotResult shotResult = rivalPlayer.playerField.takeAShot(shotPosition);
        rivalField.recordShotResult(shotResult, shotPosition);
        return shotResult;
    }
}
