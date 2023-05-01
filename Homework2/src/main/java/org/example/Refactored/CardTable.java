package org.example.Refactored;

public class CardTable {

    final int cardsForPlayer = 5;
    int players;




    // the shuffled deck is displayed
    public void printTheCardsOfPlayers(String[] deck) {
        for (int i = 0; i < players * cardsForPlayer; i++) {
            System.out.println(deck[i]);

            if (i % cardsForPlayer == cardsForPlayer - 1)
                System.out.println();
        }
    }
}
