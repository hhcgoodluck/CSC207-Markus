package edu.csc207.fall2024;

public class TragedyCalculator extends AbstractPerformanceCalculator {
    public TragedyCalculator(Performance performance, Play play) {
        super(performance, play);
    }

    @Override
    public int amountFor() {
        int result = Constants.TRAGEDY_BASE_AMOUNT;
        if (performance.getAudience() > Constants.TRAGEDY_AUDIENCE_THRESHOLD) {
            result += Constants.TRAGEDY_OVER_BASE_CAPACITY_PER_PERSON *
                    (performance.getAudience() - Constants.TRAGEDY_AUDIENCE_THRESHOLD);
        }
        return result;
    }

}
