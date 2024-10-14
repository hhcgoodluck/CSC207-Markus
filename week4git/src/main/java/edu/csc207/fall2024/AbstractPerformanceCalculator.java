package edu.csc207.fall2024;

public class AbstractPerformanceCalculator {

    protected final Performance performance;
    protected final Play play;

    public AbstractPerformanceCalculator(Performance performance, Play play) {
        this.performance = performance;
        this.play = play;
    }

    public static AbstractPerformanceCalculator createPerformanceCalculator(Performance performance, Play play) {
        return new AbstractPerformanceCalculator(performance, play);  // 目前仅返回该类的实例
    }

    // 移动后的 amountFor() 方法
    public int amountFor() {
        int result = 0;
        switch (play.getType()) {
            case "tragedy":
                result = Constants.TRAGEDY_BASE_AMOUNT;
                if (performance.getAudience() > Constants.TRAGEDY_AUDIENCE_THRESHOLD) {
                    result += Constants.TRAGEDY_OVER_BASE_CAPACITY_PER_PERSON *
                            (performance.getAudience() - Constants.TRAGEDY_AUDIENCE_THRESHOLD);
                }
                break;
            case "comedy":
                result = Constants.COMEDY_BASE_AMOUNT;
                if (performance.getAudience() > Constants.COMEDY_AUDIENCE_THRESHOLD) {
                    result += Constants.COMEDY_OVER_BASE_CAPACITY_AMOUNT +
                            Constants.COMEDY_OVER_BASE_CAPACITY_PER_PERSON *
                                    (performance.getAudience() - Constants.COMEDY_AUDIENCE_THRESHOLD);
                }
                result += Constants.COMEDY_AMOUNT_PER_AUDIENCE * performance.getAudience();
                break;
            default:
                throw new RuntimeException("Unknown play type: " + play.getType());
        }
        return result;
    }

    // 移动后的 volumeCredits() 方法
    public int volumeCredits() {
        int result = Math.max(performance.getAudience() - Constants.BASE_VOLUME_CREDIT_THRESHOLD, 0);
        if ("comedy".equals(play.getType())) {
            result += performance.getAudience() / Constants.COMEDY_EXTRA_VOLUME_FACTOR;
        }
        return result;
    }
}

