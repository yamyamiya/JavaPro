package topics.course_projects.tic_tac_toe.version_2_0.template;

import topics.course_projects.tic_tac_toe.version_2_0.template.enums.PlayerSymbol;
import topics.course_projects.tic_tac_toe.version_2_0.template.interfaces.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The game "Tic-Tac-toe".
 * Игра "Крестики-нолики".
 *
 * @author Andrey Pomelov.
 * @version 2.0.
 */
public class TicTacToe {

    private static final List<Player> PLAYERS = new ArrayList<>();
    private static boolean isGameOver;
    private static GameField field;

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
        field = new GameField(getFieldSize());
        Player player1 = new HumanPlayer("Player1", PlayerSymbol.X);
        Player player2 = new HumanPlayer("Player2", PlayerSymbol.O);
        PLAYERS.add(player1);
        PLAYERS.add(player2);
        field.repaint();


        // Logic of the method:
        // 1. Print the name of the game to the console.
        // 2. Create an instance of the game field
        //    (get the size of it by calling a right method located in this class).
        // 3. Create two players and add them to the list of players.
        //    Players should have different names and different game symbols.
        // 4. Print the game field to the console (using the method of the game field instance).

        // Логика работы метода:
        // 1. Вывести в консоль название игры.
        // 2. Создать экземпляр игрового поля
        //    (получив его размер, вызвав соответствующий метод данного класса).
        // 3. Создать двух игроков и добавить их к списку игроков.
        //    У игроков должны быть разные имена и разные игровые символы.
        // 4. Отрисовать в консоли игровое поле (с помощью готового метода игрового поля).
    }

    /**
     * Choosing the game field size by the player.
     * Выбор игроком размера игрового поля.
     *
     * @return the size of the game field / размер игрового поля.
     */
    private static int getFieldSize() {
        int gameFieldSize;
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

        while (true) {
            System.out.println("Please enter the size of your game field (integer number from 3 to 8):");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                gameFieldSize = scanner.nextInt();
                if (gameFieldSize > 2 && gameFieldSize < 9) {
                    return gameFieldSize;
                }else{
                    System.out.println("Incorrect input! Please enter your integer in the correct range from 3 to 8.");
                }
            } else{
                System.out.println("Incorrect input! Please enter an integer number");
            }
        }
    }
}