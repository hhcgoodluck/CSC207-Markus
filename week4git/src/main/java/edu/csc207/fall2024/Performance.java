package edu.csc207.fall2024;

/**
 * Represents a performance in a theater, containing the play's ID,
 * and the number of audience members attending.
 * This class is immutable, meaning the values cannot be changed once set.
 */
public class Performance {

    private final String playID;
    private final int audience;

    /**
     * Constructs a Performance instance with the specified play ID and audience size.
     * @param playID the unique identifier for the play (must not be null or empty)
     * @param audience the number of audience members (must be non-negative)
     * @throws IllegalArgumentException if playID is null, empty, or if audience is negative.
     */
    public Performance(String playID, int audience) {
        if (playID == null) {
            throw new IllegalArgumentException("playID must not be null.");
        }
        if (audience < 0) {
            throw new IllegalArgumentException("Audience size cannot be negative.");
        }
        this.playID = playID;
        this.audience = audience;
    }

    /**
     * Returns the play ID of this performance.
     * @return the play ID
     */
    public String getPlayID() {
        return playID;
    }

    /**
     * Returns the audience size of this performance.
     * @return the audience size
     */
    public int getAudience() {
        return audience;
    }

}
