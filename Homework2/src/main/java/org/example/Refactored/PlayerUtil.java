package org.example.Refactored;

public class PlayerUtil {
    int cardsForPlayer;
    int numberOfCards;

    public PlayerUtil(int cardsForPlayer, int numberOfCards) {
        this.cardsForPlayer = cardsForPlayer;
        this.numberOfCards = numberOfCards;
    }

    public boolean checkInput(int players) {
        if (players == 0) {
            System.out.println("The game has been terminated.");
            return true;
        } else if (players < 0) {
            System.out.println("The number of players cannot be less than 0");
            return false;
        } else if (cardsForPlayer * players > numberOfCards) {
            System.out.println("Too many players!");
            return false;
        } else {
            return true;
        }
    }
}

