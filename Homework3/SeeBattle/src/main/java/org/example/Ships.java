package org.example;

public enum Ships {
    ONE_DECK(1,4),
    TWO_DECK(2,3),
    THREE_DECK(3,2),
    FOUR_DECK(4,1);
    final int numberOfDecks;
    final int numberOfShips;

    Ships(int numberOfDecks, int numberOfShips) {
        this.numberOfDecks = numberOfDecks;
        this.numberOfShips = numberOfShips;
    }
}
