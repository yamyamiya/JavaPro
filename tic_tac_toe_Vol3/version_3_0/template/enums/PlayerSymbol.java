package topics.course_projects.tic_tac_toe.version_3_0.template.enums;

/**
 * Enum of player symbols
 * Перечисление символов игрока
 */
public enum PlayerSymbol {

    /**
     * Symbol X
     * Символ X
     */
    X ('X'),

    /**
     * Symbol O
     * Символ O
     */
    O ('O');

    /**
     * Symbol value
     * Символьное значение
     */
    private final char VALUE;

    /**
     * Constructor
     * Конструктор
     *
     * @param value symbol value / символьное значение
     */
    PlayerSymbol(char value) {
        this.VALUE = value;
    }

    /**
     * Getter
     * Геттер
     *
     * @return symbol value / символьное значение
     */
    public char getValue() {
        return VALUE;
    }
}