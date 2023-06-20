package topics.course_projects.tic_tac_toe.version_4_0.template;

import topics.course_projects.tic_tac_toe.version_4_0.template.enums.PlayerSymbol;
import topics.course_projects.tic_tac_toe.version_4_0.template.interfaces.Player;
import topics.course_projects.tic_tac_toe.version_4_0.template.players.ComputerPlayer;
import topics.course_projects.tic_tac_toe.version_4_0.template.players.HumanPlayer;
//import topics.course_projects.tic_tac_toe.version_4_0.template.players.ComputerPlayer;
//import topics.course_projects.tic_tac_toe.version_4_0.template.players.HumanPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The game "Tic-Tac-toe".
 * Игра "Крестики-нолики".
 *
 * @version 4.0.
 * @author Andrey Pomelov.
 */
public class TicTacToe {

    /**
     * List of the players.
     * Список игроков.
     */
    private static final List<Player> PLAYERS = new ArrayList<>();

    /**
     * Flag that shows if the game is over.
     * Флаг окончания игры, true - если игра окончена.
     */
    private static boolean isGameOver;

    /**
     * Instance of the game field.
     * Экземпляр игрового поля.
     */
    private static GameField field;

    /**
     * The minimal size of the game field
     * (the minimal win combination length will be
     * equal to this value as well).
     * Минимальный размер игрового поля
     * (минимальная длина выигрышной комбинации
     * также будет равна этому значению).
     */
    private static final int MIN_FIELD_SIZE = 3;

    /**
     * The maximal size of the game field.
     * Максимальный размер игрового поля.
     */
    private static final int MAX_FIELD_SIZE = 8;

    /**
     * Main method of the game.
     * Точка старта приложения.
     */
    public static void main(String[] args) {
        init();
        isGameOver =false;
        while(!isGameOver){

            for (int i = 0; i < PLAYERS.size(); i++) {
                while(!field.setSymbol(PLAYERS.get(i).getSymbol(), PLAYERS.get(i).makeMove())){
                    System.out.println("Please enter correct values");
                }
                field.repaint();
                if(field.isWin(PLAYERS.get(i).getSymbol().getValue())){
                    System.out.println(PLAYERS.get(i).getName()+" has won!");
                    isGameOver=true;
                    break;
                }
                if(field.isFieldFull()){
                    System.out.println("Draw!");
                    isGameOver=true;
                    break;
                }
            }
        }
        // Logic of the method:
        // 1. Create the game field (call the right method located in this class).
        // 2. Start the game cycle, which continues while isGameOver value is false.
        //      Inside the cycle:
        //      1. Start another cycle that iterates through the players, inside this cycle:
        //      2. Read the coordinates inputted by the player (using the method of the player instance).
        //      3. Pass that coordinates to the method of the playing field, filling the cell with the player symbol.
        //      4. Steps 2 and 3 should be repeated until the player enters the correct coordinates.
        //      5. Print the game field to the console.
        //      6. Check if the player won after his move.
        //         In that case print the message about the victory to the console and finish the game.
        //      7. Check if the game field is completely filled.
        //         In that case print the message about the draw to the console and finish the game.

        // Логика работы метода:
        // 1. Создать игровое поле (вызвать соответствующий метод этого же класса).
        // 2. Запустить игровой цикл, который продолжается до тех пор, пока isGameOver == false.
        //    Внутри цикла:
        //      1. Запустить ещё один цикл, перебирающий игроков и внутри этого цикла:
        //      2. Считать координаты, введённые игроком с помощью готового метода игрока.
        //      3. Передать считанные координаты в метод игрового поля, заполняющий ячейку символом игрока.
        //      4. Пункты 2 и 3 должны повторяться до тех пор, пока пользователь не введёт корректные координаты.
        //      5. Отрисовать в консоли игровое поле.
        //      6. Проверить, не выиграл ли игрок в результате своего хода.
        //         Если выиграл - выводим сообщение о победе и завершаем игру.
        //      7. Проверить, не заполнено ли игровое поле полностью.
        //         Если заполнено - выводим сообщение о ничье и завершаем игру.
    }

    /**
     * Initializing of the game, creating the game field.
     * Первоначальная инициализация игры, создание игрового поля.
     */
    private static void init() {
        System.out.println("TIC TAC TOE");
        int fieldSize = getFieldSize();
        field = new GameField(fieldSize,getWinLength(fieldSize));
        createPlayers(field);
        field.repaint();
        // Logic of the method:
        // 1. Print the name of the game to the console.
        // 2. Create an instance of the game field
        //    (get the size of it and the win combination length
        //    by calling a right methods located in this class).
        // 3. Create two players by calling a right method located in this class.
        // 4. Print the game field to the console (using the method of the game field instance).

        // Логика работы метода:
        // 1. Вывести в консоль название игры.
        // 2. Создать экземпляр игрового поля
        //    (получив его размер и длину выигрышной комбинации,
        //    вызвав соответствующие методы данного класса).
        // 3. Создать двух игроков, используя метод данного класса.
        // 4. Отрисовать в консоли игровое поле (с помощью готового метода игрового поля).
    }

    /**
     * Creating two players, the second player may be AI depending on the selected game mode.
     * Метод создаёт игроков в зависимости от выбранного режима игры.
     */
    private static void createPlayers(GameField field) {
        System.out.println("Please select the game mode: 1 - human against human, 2 - human against AI.");
        Scanner scanner = new Scanner(System.in);
        int gameMode = scanner.nextInt();
        while (gameMode != 1 && gameMode != 2) {
            System.out.println("Incorrect input. Please select the game mode: 1 - human against human, 2 - human against AI.");
            scanner = new Scanner(System.in);
            gameMode = scanner.nextInt();
        }

        Player player1 = new HumanPlayer("Player 1", PlayerSymbol.X);
        PLAYERS.add(player1);
        if (gameMode == 1) {
            Player player2 = new HumanPlayer("Player 2", PlayerSymbol.O);
            PLAYERS.add(player2);
        } else {
            Player player2 = new ComputerPlayer(PlayerSymbol.O, field);
            PLAYERS.add(player2);
        }


        // Logic of the method:
        // 1. Print to the console invitation to select the game mode: 1 - human against human, 2 - human against AI.
        // 2. Read the inputted value from the console.
        // 3. Repeat steps 1 and 2 until the player inputs the correct value.
        // 4. Create a human player and add him to the game.
        // 5. Depends on the selected game mode create human or AI player and add him/it to the game.

        // Логика работы метода:
        // 1. Выведите в консоль приглашение выбрать режим игры: 1 - два игрока, 2 - игрок против компьютера.
        // 2. Считать с консоли значение, введённое игроком.
        // 3. Повторять пункты 1 и 2 до тех пор, пока не будет введено корректное значение.
        // 4. Создать и добавить в игру первого игрока-человека.
        // 5. В зависимости от выбранного режима игры создать игрока-человека
        //    или компьютерного игрока и добавить в игру.
    }

    /**
     * Choosing the win combination length by the player.
     * Выбор игроком длины выигрышной комбинации.
     *
     * @param fieldSize game field size / размер игрового поля.
     * @return win combination length / длина выигрышной комбинации.
     */
    private static int getWinLength(int fieldSize) {
        int winLength;
        if(fieldSize==3){
            return 3;
        }
        while (true) {
            System.out.println("Please enter the length of your win combination (integer number from 3 to " + fieldSize + "):");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                winLength = scanner.nextInt();
                if (winLength >= MIN_FIELD_SIZE && winLength <= fieldSize) {
                    return winLength;
                } else {
                    System.out.println("Incorrect input! Please enter your integer in the correct range from 3 to " + fieldSize + ".");
                }
            } else {
                System.out.println("Incorrect input! Please enter an integer number.");
            }
            // Logic of the method:
            // 1. Print to the console invitation to select the win combination length
            //    (from 3 to value of the game field size).
            // 2. Read the inputted value from the console.
            // 3. Repeat steps 1 and 2 until the player inputs the correct value.
            // 4. Return the inputted value.

            // Логика работы метода:
            // 1. Вывести в консоль приглашение выбрать длину выигрышной комбинации
            //    (от 3 до значения размера игрового поля).
            // 2. Считать с консоли число, введённое игроком.
            // 3. Повторять шаги 1 и 2 до тех пор, пока игрок не введёт корректное значение.
            // 4. Вернуть введённое значение.
        }
    }

        /*
          Choosing the game field size by the player.
          Выбор игроком размера игрового поля.

          @return the size of the game field / размер игрового поля.
         */

        private static int getFieldSize() {
            int gameFieldSize;
            while (true) {
                System.out.println("Please enter the size of your game field (integer number from 3 to 8):");
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextInt()) {
                    gameFieldSize = scanner.nextInt();
                    if (gameFieldSize >= MIN_FIELD_SIZE && gameFieldSize <=MAX_FIELD_SIZE) {
                        return gameFieldSize;
                    } else {
                        System.out.println("Incorrect input! Please enter your integer in the correct range from 3 to 8.");
                    }
                } else {
                    System.out.println("Incorrect input! Please enter an integer number.");
                }
            }

            // Logic of the method:
            // 1. Print to the console invitation to select the game field size.
            // 2. Read the inputted value from the console.
            // 3. Repeat steps 1 and 2 until the player inputs the correct value.
            // 4. Return the inputted value.

            // Логика работы метода:
            // 1. Вывести в консоль приглашение выбрать размер игрового поля (от 3 до 8).
            // 2. Считать с консоли число, введённое игроком.
            // 3. Повторять шаги 1 и 2 до тех пор, пока игрок не введёт корректное значение.
            // 4. Вернуть введённое значение.
        }
    }
