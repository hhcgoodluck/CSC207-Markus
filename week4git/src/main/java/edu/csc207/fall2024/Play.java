package edu.csc207.fall2024;

/**
 * Represents a play with a specific name and type.
 * Each play object is immutable, ensuring its fields cannot change after creation.
 */
public class Play {

    private final String name;
    private final String type;

    /**
     * Constructs a new Play instance with the specified name and type.
     * @param name the name of the play (must not be null)
     * @param type the type or genre of the play (must not be null)
     * @throws IllegalArgumentException if name or type is null.
     */
    public Play(String name, String type) {
        if (name == null) {
            throw new IllegalArgumentException("Name must not be null.");
        }
        if (type == null) {
            throw new IllegalArgumentException("Type must not be null.");
        }
        this.name = name;
        this.type = type;
    }

    /**
     * Returns the name of the play.
     * @return the play's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the type or genre of the play.
     * @return the play's type
     */
    public String getType() {
        return type;
    }

}
