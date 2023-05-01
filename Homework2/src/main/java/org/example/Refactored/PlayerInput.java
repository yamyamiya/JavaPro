package org.example.Refactored;

import java.util.Scanner;

public class PlayerInput {
PlayerUtil util;

    public PlayerInput(PlayerUtil util) {
        this.util = util;
    }

    final Scanner sc = new Scanner(System.in);

    public int enterTheNumberOfPlayers() {
        while (true) {
            System.out.println("Enter the number of players: ");
            if (sc.hasNextInt()) {
                int players = sc.nextInt();
                boolean isInputValid = util.checkInput(players);

                if (isInputValid) {
                    return players;
                }
            } else {
                System.out.println("You have not entered a number, or your number is too large!");
            }
        }

    }

}
