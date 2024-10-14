package edu.csc207.fall2024;

/**
 * Calculator for performances of the tragedy type.
 * provides the specific logic to calculate the amount for tragedy plays.
 */
public class TragedyCalculator extends AbstractPerformanceCalculator {

    /**
     * Constructs a new {@code TragedyCalculator} for the given performance and play.
     * @param performance the performance instance associated with the calculation
     * @param play the play instance associated with the performance
     */
    public TragedyCalculator(Performance performance, Play play) {
        super(performance, play);
    }

    /**
     * Calculates the amount for a tragedy performance.
     * @return the calculated amount for the tragedy performance
     */
    @Override
    public int amountFor() {
        int result = Constants.TRAGEDY_BASE_AMOUNT;
        if (getPerformance().getAudience() > Constants.TRAGEDY_AUDIENCE_THRESHOLD) {
            result += Constants.TRAGEDY_OVER_BASE_CAPACITY_PER_PERSON
                    * (getPerformance().getAudience() - Constants.TRAGEDY_AUDIENCE_THRESHOLD);
        }
        return result;
    }

}
