package edu.csc207.fall2024;

public class HistoryCalculator extends AbstractPerformanceCalculator {
    public HistoryCalculator(Performance performance, Play play) {
        super(performance, play);
    }

    @Override
    public int amountFor() {
        int result = Constants.HISTORY_BASE_AMOUNT;
        if (performance.getAudience() > Constants.HISTORY_AUDIENCE_THRESHOLD) {
            result += Constants.HISTORY_OVER_BASE_CAPACITY_PER_PERSON * (performance.getAudience() - Constants.HISTORY_AUDIENCE_THRESHOLD);
        }
        return result;
    }

    @Override
    public int volumeCredits() {
        return Math.max(performance.getAudience() - Constants.HISTORY_VOLUME_CREDIT_THRESHOLD, 0);
    }
}

