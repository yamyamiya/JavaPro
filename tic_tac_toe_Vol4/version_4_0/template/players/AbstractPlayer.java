package topics.course_projects.tic_tac_toe.version_4_0.template.players;

import topics.course_projects.tic_tac_toe.version_4_0.template.enums.PlayerSymbol;
import topics.course_projects.tic_tac_toe.version_4_0.template.interfaces.Player;

/**
 * Superclass for the players classes.
 * Суперкласс для классов игроков.
 */
public abstract class AbstractPlayer implements Player {

    /**
     * Player name.
     * Имя игрока.
     */
    protected final String NAME;

    /**
     * Player symbol, X or O.
     * Символ игрока, Х или О.
     */
    protected final PlayerSymbol SYMBOL;

    /**
     * Constructor.
     * Конструктор.
     *
     * @param name      player name / имя игрока.
     * @param symbol    player symbol / символ игрока.
     */
    public AbstractPlayer(String name, PlayerSymbol symbol) {
        this.NAME = name;
        this.SYMBOL = symbol;

        // Implement the constructor body.
        // Реализовать тело конструктора.
    }

    /**
     * Getter.
     * Геттер.
     *
     * @return player symbol / символ игрока.
     */
    @Override
    public PlayerSymbol getSymbol() {

//        // Implement the getter body.
//        // Реализовать тело геттера.

        return SYMBOL;
    }

    /**
     * Getter.
     * Геттер.
     *
     * @return player name / имя игрока.
     */
    @Override
    public String getName() {
        // Implement the getter body.
        // Реализовать тело геттера.

        return NAME;
    }
}