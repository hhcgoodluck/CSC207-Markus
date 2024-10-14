package edu.csc207.fall2024;

public class PerformanceData {
    private final Performance performance;
    private final Play play;
    private final int amount;
    private final int volumeCredits;


    public PerformanceData(Performance performance, Play play, int amount, int volumeCredits) {
        this.performance = performance;
        this.play = play;
        this.amount = amount;
        this.volumeCredits = volumeCredits;
    }

    public String getName() {
        return play.getName();
    }

    public int getAudience() {
        return performance.getAudience();
    }

    public String getType() {
        return play.getType();
    }

    public int getAmount() {
        return amount;
    }

    public int getVolumeCredits() {
        return volumeCredits;
    }

}

