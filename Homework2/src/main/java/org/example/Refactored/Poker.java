package org.example.Refactored;

public class Poker {
    public void play(){
        Cards cards = new Cards();
        CardTable cardTable = new CardTable();
        PlayerInput input = new PlayerInput(new PlayerUtil(cardTable.cardsForPlayer, cards.numberOfCards));
        cardTable.players = input.enterTheNumberOfPlayers();
        cards.createDeck();
        cards.deckShuffle();
        cardTable.printTheCardsOfPlayers(cards.shuffledDeck);

    }
    }

