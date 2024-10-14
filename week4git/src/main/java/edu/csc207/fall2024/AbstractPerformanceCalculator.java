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
}

