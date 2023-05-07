package org.example;

import java.util.Scanner;

public class PlayerField extends CommonField {

    private static final char DECK_CELL = 'D';
    private static final char BLOCKED_CELL = ' ';
    private static final char DAMAGED_DECK = 'X';


    public void createPlayerField(Player player) {
        for (Ships shipType : Ships.values()) {
            for (int i = 0; i < shipType.numberOfShips; i++) {
                placeTheShip(shipType.numberOfDecks, player);

            }
        }
        repaint();
    }


    public boolean tryToBlockTheCell(int x, int y) {
        try {
            field[x][y] = BLOCKED_CELL;
            return true;
        } catch (IndexOutOfBoundsException error) {
            return false;
        }
    }

    public void placeTheShip(int numberOfDecks, Player player) {
        repaint();
        String oneDeck = "палубой";
        String manyDecks = "палубами";
        if (numberOfDecks == 1) {
            System.out.println(player.getName() + ", введите координаты для коробля с " + numberOfDecks + " " + oneDeck + " (в строчном формате с пробелом. Пример: - \"2 3\"):");
        } else {
            System.out.println(player.getName() + ", введите координаты для коробля с " + numberOfDecks + " " + manyDecks + " (в строчном формате с пробелом. Пример: - \"2 3\"):");
        }
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        if (input.length != 2) {
            System.out.println("Неверные координаты.");
            placeTheShip(numberOfDecks, player);
            return;
        }
        Position position = new Position(Integer.parseInt(input[0]) - 1, Integer.parseInt(input[1]) - 1);
        if (numberOfDecks != 1) {
            System.out.println(player.getName() + ", введите направление (RIGHT или DOWN) для коробля с " + numberOfDecks + " " + manyDecks + ":");
            String directionInput = scanner.nextLine().toUpperCase();
            if (!directionInput.equals("DOWN") && !directionInput.equals("RIGHT")) {
                System.out.println("Неверное направление.");
                placeTheShip(numberOfDecks, player);
                return;
            }
            Direction direction = Direction.valueOf(directionInput);

            if (direction == Direction.DOWN) {
                for (int j = position.getX(); j < position.getX() + numberOfDecks; j++) {
                    if (field[j][position.getY()] != EMPTY_CELL) {
                        System.out.println("Такое расположение данного корабля невозможно. Выбирите другое расположение.");
                        placeTheShip(numberOfDecks, player);
                        return;
                    }
                }
                for (int j = position.getX(); j < position.getX() + numberOfDecks; j++) {
                    field[j][position.getY()] = DECK_CELL;
                    tryToBlockTheCell(j, position.getY() - 1);
                    tryToBlockTheCell(j, position.getY() + 1);
                }
                tryToBlockTheCell(position.getX() - 1, position.getY() - 1);
                tryToBlockTheCell(position.getX() - 1, position.getY());
                tryToBlockTheCell(position.getX() - 1, position.getY() + 1);
                tryToBlockTheCell(position.getX() + numberOfDecks, position.getY() - 1);
                tryToBlockTheCell(position.getX() + numberOfDecks, position.getY());
                tryToBlockTheCell(position.getX() + numberOfDecks, position.getY() + 1);
            }
            if (direction == Direction.RIGHT) {
                for (int k = position.getY(); k < position.getY() + numberOfDecks; k++) {
                    field[position.getX()][k] = DECK_CELL;
                    tryToBlockTheCell(position.getX() - 1, k);
                    tryToBlockTheCell(position.getX() + 1, k);
                }
                tryToBlockTheCell(position.getX() - 1, position.getY() - 1);
                tryToBlockTheCell(position.getX(), position.getY() - 1);
                tryToBlockTheCell(position.getX() + 1, position.getY() - 1);
                tryToBlockTheCell(position.getX() - 1, position.getY() + numberOfDecks);
                tryToBlockTheCell(position.getX(), position.getY() + numberOfDecks);
                tryToBlockTheCell(position.getX() + 1, position.getY() + numberOfDecks);
            }

        } else {
            if (field[position.getX()][position.getY()] != EMPTY_CELL) {
                System.out.println("Такое расположение данного корабля невозможно. Выбирите другое расположение.");
                placeTheShip(numberOfDecks, player);
            } else {
                field[position.getX()][position.getY()] = DECK_CELL;
                tryToBlockTheCell(position.getX() - 1, position.getY() - 1);
                tryToBlockTheCell(position.getX(), position.getY() - 1);
                tryToBlockTheCell(position.getX() + 1, position.getY() - 1);
                tryToBlockTheCell(position.getX() + 1, position.getY());
                tryToBlockTheCell(position.getX() + 1, position.getY() + 1);
                tryToBlockTheCell(position.getX(), position.getY() + 1);
                tryToBlockTheCell(position.getX() - 1, position.getY() + 1);
                tryToBlockTheCell(position.getX() - 1, position.getY());
            }
        }
    }

    public ShotResult takeAShot(Position position) {
        if (field[position.getX()][position.getY()] == DECK_CELL) {
            field[position.getX()][position.getY()] = DAMAGED_DECK;
            if (hasMoreDecks(position)) {
                return ShotResult.DAMAGED;
            } else {
                return ShotResult.KILLED;
            }
        } else {
            return ShotResult.MISSED;
        }
    }

    public boolean hasMoreDecks(Position position) {
        boolean upDeck = hasTheDeck(position.getX() - 1, position.getY());
        boolean upDeckLeft = hasTheDeck(position.getX() - 1, position.getY() - 1);
        boolean upDeckRight = hasTheDeck(position.getX() - 1, position.getY() + 1);
        boolean leftDeck = hasTheDeck(position.getX(), position.getY() - 1);
        boolean rightDeck = hasTheDeck(position.getX(), position.getY() + 1);
        boolean downDeck = hasTheDeck(position.getX() + 1, position.getY());
        boolean downDeckLeft = hasTheDeck(position.getX() + 1, position.getY() - 1);
        boolean downDeckRight = hasTheDeck(position.getX() + 1, position.getY() + 1);

        return upDeck || upDeckRight || upDeckLeft || leftDeck || rightDeck || downDeckRight || downDeckLeft || downDeck;
    }


    public boolean hasTheDeck(int x, int y) {
        try {
            return field[x][y] == DECK_CELL;
        } catch (IndexOutOfBoundsException error) {
            return false;
        }
    }

    public boolean hasMoreShips() {

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == DECK_CELL) {
                    return true;
                }
            }

        }
        return false;
    }


}