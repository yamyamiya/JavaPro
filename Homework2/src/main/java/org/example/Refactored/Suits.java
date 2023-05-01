package org.example.Refactored;

public enum Suits {

//    "clubs", "diamonds", "hearts", "spades"
    CLUBS("clubs"),
    DIAMONDS("diamonds"),
    HEARTS("hearts"),
    SPADES("spades");
    final String suitName;


    Suits(String suitName) {
        this.suitName = suitName;
    }
}
