package org.example.Refactored;

public enum Rank {
//   {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("Jack"),
    QUEEN("Queen"),
    KING("King"),
    ACE("Ace");
    final String rankName;

    Rank(String rankName) {
        this.rankName = rankName;
    }
}
