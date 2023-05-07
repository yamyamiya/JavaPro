package org.example;

public class Game {


    final int numberOfPlayers = 2;

    Player player1 = new Player("Player 1");
    Player player2 = new Player("Player 2");
    Player[] playersArray = new Player[2];


    public void prepareTheGame() {
        player1.fillYourField();
        player2.fillYourField();
        playersArray[0] = player1;
        playersArray[1] = player2;
        player1.setRivalPlayer(player2);
        player2.setRivalPlayer(player1);

    }

    public void play() {
        while (true) {

            for (int i = 0; i < playersArray.length; i++) {
                playersArray[i].rivalField.repaint();
                boolean isMissed = false;
                while (!isMissed) {
                    ShotResult result = playersArray[i].makeMove();
                    if (result == ShotResult.MISSED) {
                        isMissed = true;
                        System.out.println("Вы промахнулись. Переход хода.");
                    } else if (result == ShotResult.DAMAGED) {
                        System.out.println("Вы попали. Корабль ранен.");
                    } else {
                        System.out.println("Вы попали. Корабль убит.");
                    }
                    if (!playersArray[i].rivalPlayer.playerField.hasMoreShips()) {
                        System.out.println("Игра окончена. " + playersArray[i].getName() + " победил.");
                        return;
                    }
                }
            }
        }
    }
}
