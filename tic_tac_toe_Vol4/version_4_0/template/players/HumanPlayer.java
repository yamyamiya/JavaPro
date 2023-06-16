package topics.course_projects.tic_tac_toe.version_4_0.template.players;

import topics.course_projects.tic_tac_toe.version_4_0.template.enums.PlayerSymbol;

import java.util.Scanner;

/**
 * Human player.
 * Игрок-человек.
 */
public class HumanPlayer extends AbstractPlayer {
    /**
     * Constructor.
     * Конструктор.
     *
     * @param name   player name / имя игрока.
     * @param symbol player symbol / символ игрока.
     */

/**
     * Constructor.
     * Конструктор.
     *
     * @param name      player name / имя игрока.
     * @param symbol    player symbol / символ игрока.
     */
    public HumanPlayer(String name, PlayerSymbol symbol) {
        super(name, symbol);
//
//        // Implement the constructor body just by calling the superclass constructor.
//        // Реализовать тело конструктора, вызвав конструктор суперкласса.
    }

    /**
     * Make a move.
     * Сделать ход.
     *
     * @return  coordinates in string format with a space as a splitter, example - "2 3".
     *          координаты в виде строки с разделителем-пробелом, например - "2 3".
     */
    @Override
    public String makeMove() {
        System.out.println("Please enter your coordinates in string format with a space as a splitter. Example: - \"2 3\")");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
        // Logic of the method:
        // 1. Print to the console that the player should input the coordinates.
        // 2. Return the inputted value.

        // Логика метода:
        // 1. Вывести в консоль приглашение ввести координаты.
        // 2. Вернуть значение, которое ввёл пользователь.
    }

}