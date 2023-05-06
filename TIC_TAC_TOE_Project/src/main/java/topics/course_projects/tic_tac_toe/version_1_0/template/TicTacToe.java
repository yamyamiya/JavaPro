package topics.course_projects.tic_tac_toe.version_1_0.template;

import topics.course_projects.tic_tac_toe.version_1_0.template.enums.PlayerSymbol;
import topics.course_projects.tic_tac_toe.version_1_0.template.interfaces.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * The game "Tic-Tac-toe"
 * Игра "Крестики-нолики"
 *
 * @version 1.0
 * @author Andrey Pomelov
 */
public class TicTacToe {

    private static final List<Player> PLAYERS = new ArrayList<>();
    private static boolean isGameOver;

    public static void main(String[] args) {
        // Logic of the method:
        // 1. Print the name of the game to the console.
        System.out.println("TIC TAC TOE");
        GameField gameField = new GameField();
        Player player1 = new HumanPlayer("Player1", PlayerSymbol.X);
        Player player2 = new HumanPlayer("Player2", PlayerSymbol.O);
        Player[] playersList = {player1,player2};
        gameField.repaint();
        isGameOver =false;
        while(!isGameOver){

            for (int i = 0; i < playersList.length; i++) {
                while(!gameField.setSymbol(playersList[i].getSymbol(), playersList[i].makeMove())){
                    System.out.println("Please enter correct values");
                }
                gameField.repaint();
                if(gameField.isWin(playersList[i].getSymbol().getValue())){
                    System.out.println(playersList[i].getName()+" has won!");
                    isGameOver=true;
                    break;
                }
                if(gameField.isFieldFull()){
                    System.out.println("Draw!");
                }
            }


        }

        // 2. Create an instance of the game field.
        // 3. Create two players and add them to the list of players.
        //    Players should have different names and different game symbols.
        // 4. Print the game field to the console (using the method of the game field instance).
        // 5. Start the game cycle, which continues while isGameOver value is false.
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
        // 1. Вывести в консоль название игры.
        // 2. Создать экземпляр игрового поля.
        // 3. Создать двух игроков и добавить их к списку игроков.
        //    У игроков должны быть разные имена и разные игровые символы.
        // 4. Отрисовать в консоли игровое поле (с помощью готового метода игрового поля).
        // 5. Запустить игровой цикл, который продолжается до тех пор, пока isGameOver == false.
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
}