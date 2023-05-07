package org.example;

public class RivalField extends CommonField {
    private static final char MISSED_SHOT = '*';
    private static final char SUCCESSFUL_SHOT = 'X';

    public void recordShotResult(ShotResult shotResult, Position position) {
        if (shotResult == ShotResult.MISSED) {
            field[position.getX()][position.getY()] = MISSED_SHOT;
        } else {
            field[position.getX()][position.getY()] = SUCCESSFUL_SHOT;
        }
        repaint();
    }
}
