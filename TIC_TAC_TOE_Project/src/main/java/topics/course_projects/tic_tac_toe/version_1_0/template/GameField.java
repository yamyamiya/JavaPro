package topics.course_projects.tic_tac_toe.version_1_0.template;

import topics.course_projects.tic_tac_toe.version_1_0.template.enums.PlayerSymbol;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Game field
 * Игровое поле
 */
public class GameField {


    /**
     * Array containing the game field
     * Массив, содержащий игровое поле
     */
    private char[][] field;

    /**
     * Value of an empty cell
     * Значение для пустой ячейки
     */
    private final char EMPTY_CELL = '.';

    /**
     * Constructor
     * Конструктор
     */
    public GameField() {
        initialize();
        // When this constructor is called, initial filling of the game field should be performed.
        // При вызове конструктора должно производиться первоначальное заполнение игрового поля.
    }

    /**
     * Initial filling of the game field
     * Первоначальное заполнение игрового поля
     */
    public void initialize() {
        field = new char[3][3];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = EMPTY_CELL;
            }

        }
        // Logic of the method:
        // 1. Initialize the "field" field with an array of the desired size (3 rows, 3 columns).
        // 2. Fill all cells of the array with the value for an empty cell.

        // Логика метода:
        // 1. Инициализировать поле field массивом нужного размера (3 х 3).
        // 2. Пройтись по всему массиву и заполнить все его элементы значением для пустой ячейки.
    }

    /**
     * Print the game field to the console
     * Вывести игровое поле в консоль
     */
    public void repaint() {
        for (int i = 0; i < field.length; i++) {
            System.out.println();
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j] + " ");

            }

        }
        // Logic of the method:
        // Print the array to the console. Each row should be printed in a new line.
        // Symbols within one row should be separated by a space.

        // Логика метода:
        // Вывести массив, содержащий игровое поле, в консоль.
        // При этом каждая строка массива должна выводиться в новой строке,
        // а символы одной строки должны быть отделены друг от друга пробелом.
        System.out.println();
    }

    /**
     * Put the player symbol in the chosen cell
     * Проставить символ игрока в нужное поле
     *
     * @param symbol      player symbol (X or O) / символ игрока (Х или О)
     * @param coordinates coordinates in string format / координаты в виде строки
     *                    Coordinates must be in string format with a space as a splitter, example - "2 3".
     *                    Координаты должны передаваться в виде строки с разделителем-пробелом, пример - "2 3".
     * @return true, if the move was success and player symbol putted in chosen cell correctly
     * true, если ход выполнен успешно, символ игрока проставлен в поле
     */
    public boolean setSymbol(PlayerSymbol symbol, String coordinates) {
        // Logic of the method:
        // 1. Transform the coordinates into the String type array by dividing with a space.
        String[] input = coordinates.split(" ");
        int x;
        int y;


//       field[coordinates.charAt(0)][coordinates.charAt(2)]

        // 2. Return false if size of the array is different from 2.
        if (input.length != 2) return false;
        // 3. Parse the coordinates into the int type. Return false if any exception occurred during that.
        try {
            x = Integer.parseInt(input[0])-1;
            y = Integer.parseInt(input[1])-1;
        } catch (Exception e) {
            return false;
        }

        try {
            // 4. Check if the selected cell is already occupied. Return false in the case of that.
            if (field[x][y] != EMPTY_CELL) {
                return false;
            }
            // 5. Put the player symbol in the selected cell.
            field[x][y] = symbol.getValue();
        } catch (Exception err) {
            return false;
        }

        // 6. Return false if any exception occurred during execution of steps 4 and 5.

        // 7. Return true. Reaching the end of the method means the move is correctly performed.

        // Логика метода:
        // 1. Разбиваем полученные координаты на два значения.
        // 2. Проверяем, если число координат - не 2, возвращаем false.
        // 3. Парсим координаты в числовой тип. В случае ошибки парсинга возвращаем false.
        // 4. Проверяем не занята ли выбранная ячейка. Если занята - возвращаем false.
        // 5. Заполняем выбранную ячейку символом игрока.
        // 6. В случае ошибок в пунктах 4 и 5 возвращаем false.
        // 7. В конце метода возвращаем true (если дошли до конца метода, значит ход успешен).

        return true;
    }

    /**
     * Check if game field is completely filled
     * Проверка, заполнено ли поле
     *
     * @return true if game field is completely filled with players symbols
     * true, если поле полностью заполнено символами игроков
     */
    boolean isFieldFull() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == EMPTY_CELL) return false;
            }
        }
        return true;
        // Logic of the method:
        // Return false if at least one empty cell present in the game field, otherwise return true.

        // Логика метода:
        // Вернуть false, если есть хотя бы одна пустая ячейка, иначе вернуть true.
    }

    /**
     * Check if the win combination present in the game field
     * Проверка, присутствует ли на поле выигрышная комбинация
     *
     * @param symbol player symbol / символ игрока
     * @return true if the win combination present in the game field
     * true, если выигрышная комбинация присутствует на поле
     */
    boolean isWin(char symbol) {
        return checkRows(symbol) || checkColumns(symbol) || checkDiagonals(symbol);
        // Logic of the method:
        // Return true if at least one of the methods checkRows, checkColumns, checkDiagonals returns true.

        // Логика метода:
        // Вернуть true, если хотя бы один из методов checkRows, checkColumns, checkDiagonals вернёт true.

    }

    /**
     * Check if the win combination present in any of rows of the game field
     * Проверка, присутствует ли в каком-либо ряду выигрышная комбинация
     *
     * @param symbol player symbol / символ игрока
     * @return true if the win combination present in any of rows of the game field
     * true, если выигрышная комбинация присутствует в каком-либо ряду
     */
    boolean checkRows(char symbol) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == symbol) {
                    if (j == field.length - 1) {
                        return true;
                    }
                } else {
                    break;
                }
            }

        }
        // Logic of the method:
        // Check all the rows of the game field, return true if one of them is completely filled with player symbols.

        // Логика метода:
        // Пройтись по всем строкам массива и вернуть true, если хотя бы одна из них полностью заполнена символами игрока.

        return false;
    }

    /**
     * Check if the win combination present in any of columns of the game field
     * Проверка, присутствует ли в каком-либо столбце выигрышная комбинация
     *
     * @param symbol player symbol / символ игрока
     * @return true if the win combination present in any of columns of the game field
     * true, если выигрышная комбинация присутствует в каком-либо столбце
     */
    boolean checkColumns(char symbol) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[j][i] == symbol) {
                    if (j == field.length - 1) {
                        return true;
                    }
                } else {
                    break;
                }
            }

        }

        // Logic of the method:
        // Check all the columns of the game field, return true if one of them is completely filled with player symbols.

        // Логика метода:
        // Пройтись по всем столбцам массива и вернуть true, если хотя бы один из них полностью заполнен символами игрока.

        return false;
    }

    /**
     * Check if the win combination present in any of diagonals of the game field
     * Проверка, присутствует ли в одной из диагоналей выигрышная комбинация
     *
     * @param symbol player symbol / символ игрока
     * @return true if the win combination present in any of diagonals of the game field
     * true, если выигрышная комбинация присутствует в одной из диагоналей
     */
    boolean checkDiagonals(char symbol) {
        for (int i = 0; i < field.length; i++) {
            if (field[i][i] == symbol)
                if (i == field.length - 1) {
                    return true;
                } else {
                    break;
                }

        }
        for (int i = 0; i < field.length; i++) {
            if (field[i][field.length - i - 1] == symbol) {
                if (i == field.length - 1) {
                    return true;
                }
            } else {
                break;
            }


            // Logic of the method:
            // Check all the diagonals of the game field, return true if one of them is completely filled with player symbols.

            // Логика метода:
            // Вернуть true, если хотя бы одна из диагоналей полностью заполнена символами игрока.


        }
        return false;
    }
}