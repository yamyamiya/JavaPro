package org.example;

public abstract class CommonField {
    public char[][] field;
    public static final char EMPTY_CELL = '.';

    public CommonField() {
        initialize();
    }


    public void initialize() {
        field = new char[10][10];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = EMPTY_CELL;
            }
        }
    }

    public void repaint() {
        for (int i = 0; i < field.length; i++) {
            System.out.println();
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j] + " ");
            }
        }
        System.out.println();
    }
}
