package edu.csc207.fall2024;

public class PastoralCalculator extends AbstractPerformanceCalculator {

    public PastoralCalculator(Performance performance, Play play) {
        super(performance, play);
    }

    @Override
    public int amountFor() {
        int result = Constants.PASTORAL_BASE_AMOUNT;
        if (performance.getAudience() > Constants.PASTORAL_AUDIENCE_THRESHOLD) {
            result += Constants.PASTORAL_OVER_BASE_CAPACITY_PER_PERSON * (performance.getAudience() - 20);
        }
        return result;
    }

    @Override
    public int volumeCredits() {
        return Math.max(performance.getAudience() - Constants.PASTORAL_VOLUME_CREDIT_THRESHOLD, 0) +
                performance.getAudience() / 2;
    }
}

