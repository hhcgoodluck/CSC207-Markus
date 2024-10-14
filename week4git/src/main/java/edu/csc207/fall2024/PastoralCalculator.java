package edu.csc207.fall2024;

/**
 * Calculator for performances of type "Pastoral".
 * This class extends AbstractPerformanceCalculator and provides
 */
public class PastoralCalculator extends AbstractPerformanceCalculator {

    /**
     * Constructs a new PastoralCalculator.
     * @param performance The performance data to be used in calculations.
     *                    Cannot be null; otherwise, behavior is undefined.
     * @param play        The play data associated with the performance.
     *                    Cannot be null; otherwise, behavior is undefined.
     */
    public PastoralCalculator(Performance performance, Play play) {
        super(performance, play);
    }

    /**
     * Calculates the total amount for a pastoral performance.
     * If the audience size exceeds Constants.PASTORAL_AUDIENCE_THRESHOLD,
     * additional charges are applied for each audience member beyond the threshold.
     * @return The total amount for the pastoral performance.
     */
    @Override
    public int amountFor() {
        int result = Constants.PASTORAL_BASE_AMOUNT;
        if (getPerformance().getAudience() > Constants.PASTORAL_AUDIENCE_THRESHOLD) {
            result += Constants.PASTORAL_OVER_BASE_CAPACITY_PER_PERSON
                    * (getPerformance().getAudience() - Constants.PASTORAL_AUDIENCE_THRESHOLD);
        }
        return result;
    }

    /**
     * Calculates the volume credits earned from a pastoral performance.
     * Volume credits are determined by the audience size. A bonus is given if the audience
     * exceeds Constants.PASTORAL_VOLUME_CREDIT_THRESHOLD, and additional credits
     * are awarded based on half the audience size.
     * @return The total volume credits earned from the pastoral performance.
     */
    @Override
    public int volumeCredits() {
        return Math.max(getPerformance().getAudience() - Constants.PASTORAL_VOLUME_CREDIT_THRESHOLD, 0)
                + getPerformance().getAudience() / 2;
    }
}

