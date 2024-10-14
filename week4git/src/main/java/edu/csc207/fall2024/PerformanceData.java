package edu.csc207.fall2024;

/**
 * A data class representing the details of a specific performance.
 * This class encapsulates the performance, the associated play,
 * the calculated amount, and the volume credits earned for the performance.
 */
public class PerformanceData {
    private final Performance performance;
    private final Play play;
    private final int amount;
    private final int volumeCredits;

    /**
     * Constructs a PerformanceData object with the given performance, play, amount, and volume credits.
     * @param performance the performance details, including audience size.
     * @param play the play object associated with the performance.
     * @param amount the calculated amount for the performance, in cents.
     * @param volumeCredits the volume credits earned for the performance.
     */
    public PerformanceData(Performance performance, Play play, int amount, int volumeCredits) {
        this.performance = performance;
        this.play = play;
        this.amount = amount;
        this.volumeCredits = volumeCredits;
    }

    /**
     * Returns the name of the play associated with this performance.
     * @return the play's name.
     */
    public String getName() {
        return play.getName();
    }

    /**
     * Returns the number of audience members for this performance.
     * @return the audience size.
     */
    public int getAudience() {
        return performance.getAudience();
    }

    /**
     * Returns the type of the play associated with this performance.
     * @return the play type (e.g., "comedy", "tragedy").
     */
    public String getType() {
        return play.getType();
    }

    /**
     * Returns the calculated amount (in cents) for this performance.
     * @return the total amount for the performance.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Returns the volume credits earned for this performance.
     * @return the total volume credits.
     */
    public int getVolumeCredits() {
        return volumeCredits;
    }

}

