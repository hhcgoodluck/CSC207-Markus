package edu.csc207.fall2024;

/**
 * A calculator for performances of the "comedy" play type.
 * specific logic for calculating the amount and volume credits for comedy plays.
 */
public class ComedyCalculator extends AbstractPerformanceCalculator {

    /**
     * Constructs a ComedyCalculator with the given performance and play.
     * @param performance the performance object representing this play.
     * @param play the play object of type "comedy".
     */
    public ComedyCalculator(Performance performance, Play play) {
        super(performance, play);
    }

    /**
     * Calculates the amount for this comedy performance.
     * @return the total amount in cents for this performance.
     */
    @Override
    public int amountFor() {
        int result = Constants.COMEDY_BASE_AMOUNT;
        if (getPerformance().getAudience() > Constants.COMEDY_AUDIENCE_THRESHOLD) {
            result += Constants.COMEDY_OVER_BASE_CAPACITY_AMOUNT
                    + Constants.COMEDY_OVER_BASE_CAPACITY_PER_PERSON
                    * (getPerformance().getAudience() - Constants.COMEDY_AUDIENCE_THRESHOLD);
        }
        result += Constants.COMEDY_AMOUNT_PER_AUDIENCE * getPerformance().getAudience();
        return result;
    }

    /**
     * Calculates the volume credits for this comedy performance.
     * @return the total volume credits for this performance.
     */
    @Override
    public int volumeCredits() {
        int result = super.volumeCredits();
        result += getPerformance().getAudience() / Constants.COMEDY_EXTRA_VOLUME_FACTOR;
        return result;
    }

}
