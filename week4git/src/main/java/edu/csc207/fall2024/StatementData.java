package edu.csc207.fall2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StatementData {

    private final Invoice invoice;
    private final List<PerformanceData> performanceDataList;

    public StatementData(Invoice invoice, Map<String, Play> plays) {
        this.invoice = invoice;

        List<PerformanceData> tempList = new ArrayList<>();
        for (Performance performance : invoice.getPerformances()) {
            PerformanceData performanceData = createPerformanceData(performance, plays);
            tempList.add(performanceData);
        }
        this.performanceDataList = tempList;
    }

    private PerformanceData createPerformanceData(Performance performance, Map<String, Play> plays) {
        Play play = plays.get(performance.getPlayID());
        AbstractPerformanceCalculator calculator =
                AbstractPerformanceCalculator.createPerformanceCalculator(performance, play);

        int amount = calculator.amountFor();
        int volumeCredits = calculator.volumeCredits();

        return new PerformanceData(performance, play, amount, volumeCredits);
    }

    public String getCustomer() {
        return invoice.getCustomer();
    }

    public List<PerformanceData> getPerformances() {

        return performanceDataList;
    }

    public int totalAmount() {
        int totalAmount = 0;
        for (PerformanceData performance : performanceDataList) {
            totalAmount += performance.getAmount();
        }
        return totalAmount;
    }

    public int volumeCredits() {
        int volumeCredits = 0;
        for (PerformanceData performance : performanceDataList) {
            volumeCredits += performance.getVolumeCredits();
        }
        return volumeCredits;
    }

}

