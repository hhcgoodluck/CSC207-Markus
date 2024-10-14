package edu.csc207.fall2024;

/**
 * Abstract class for calculating performance-related metrics, such as the amount
 * and volume credits, for various types of plays.
 * different play types like Tragedy, Comedy, History, and Pastoral.
 */
public abstract class AbstractPerformanceCalculator {

    private final Performance performance;
    private final Play play;

    /**
     * Constructs an AbstractPerformanceCalculator with the given performance and play.
     * @param performance the performance instance
     * @param play the play instance associated with the performance
     */
    public AbstractPerformanceCalculator(Performance performance, Play play) {
        this.performance = performance;
        this.play = play;
    }

    /**
     * Factory method to create the appropriate calculator based on the play type.
     * @param performance the performance instance
     * @param play the play instance associated with the performance
     * @return an instance of a subclass of AbstractPerformanceCalculator
     * @throws IllegalArgumentException if the play type is unknown
     */
    public static AbstractPerformanceCalculator createPerformanceCalculator(Performance performance, Play play) {
        switch (play.getType()) {
            case "tragedy":
                return new TragedyCalculator(performance, play);
            case "comedy":
                return new ComedyCalculator(performance, play);
            case "history":
                return new HistoryCalculator(performance, play);
            case "pastoral":
                return new PastoralCalculator(performance, play);
            default:
                throw new IllegalArgumentException("Unknown play type: " + play.getType());
        }
    }

    /**
     * Calculates the amount for the given performance.
     * @return the calculated amount for the performance
     */
    public abstract int amountFor();

    /**
     * Calculates the volume credits earned for the given performance.
     * @return the volume credits earned
     */
    public int volumeCredits() {
        return Math.max(performance.getAudience() - Constants.BASE_VOLUME_CREDIT_THRESHOLD, 0);
    }

    /**
     * Returns the play associated with this calculator.
     * @return the play instance
     */
    public Play getPlay() {
        return play;
    }

    /**
     * Returns the performance associated with this calculator.
     * @return the performance instance
     */
    public Performance getPerformance() {
        return performance;
    }
}

