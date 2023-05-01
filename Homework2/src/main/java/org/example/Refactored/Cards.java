package org.example.Refactored;

import java.util.Random;

public class Cards {

//    final String[] suits = {"clubs", "diamonds", "hearts", "spades"};
//    final String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    final int numberOfCards = Suits.values().length * Rank.values().length; // number of cards

    String[] deck = new String[numberOfCards];
    String[] shuffledDeck = new String[numberOfCards];

    // deck initialization
    public void createDeck() {

        for (int i = 0; i < Rank.values().length; i++) {
            for (int j = 0; j < Suits.values().length; j++) {
                deck[Suits.values().length * i + j] = Rank.values()[i].rankName + " " + Suits.values()[j].suitName;
            }
        }
    }

    // deck shuffling
    public void deckShuffle() {

        final Random random = new Random();
        shuffledDeck = deck.clone();
        for (int i = 0; i < numberOfCards; i++) {
            int card = i + (random.nextInt(numberOfCards - i)); // random card in the deck
            String temp = shuffledDeck[card];
            shuffledDeck[card] = shuffledDeck[i];
            shuffledDeck[i] = temp;
        }
    }


}
