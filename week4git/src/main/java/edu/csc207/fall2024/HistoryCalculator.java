package edu.csc207.fall2024;

/**
 * A calculator for performances of the "history" play type.
 * specific logic for calculating the amount and volume credits for historical plays.
 */
public class HistoryCalculator extends AbstractPerformanceCalculator {

    /**
     * Constructs a HistoryCalculator with the given performance and play.
     * @param performance the performance object representing this play.
     * @param play the play object of type "history".
     */
    public HistoryCalculator(Performance performance, Play play) {
        super(performance, play);
    }

    /**
     * Calculates the amount for this historical performance.
     * If the audience exceeds the threshold, additional charges are applied.
     * @return the total amount in cents for this performance.
     */
    @Override
    public int amountFor() {
        int result = Constants.HISTORY_BASE_AMOUNT;
        if (getPerformance().getAudience() > Constants.HISTORY_AUDIENCE_THRESHOLD) {
            result += Constants.HISTORY_OVER_BASE_CAPACITY_PER_PERSON
                    * (getPerformance().getAudience() - Constants.HISTORY_AUDIENCE_THRESHOLD);
        }
        return result;
    }

    /**
     * Calculates the volume credits for this historical performance.
     * Credits are earned if the audience exceeds the threshold.
     * @return the total volume credits for this performance.
     */
    @Override
    public int volumeCredits() {
        return Math.max(getPerformance().getAudience() - Constants.HISTORY_VOLUME_CREDIT_THRESHOLD, 0);
    }
}

