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
            PerformanceData performanceData = createPerformanceCalculator(plays, performance);
            tempList.add(performanceData);
        }
        this.performanceDataList = tempList;
    }

    private static PerformanceData createPerformanceCalculator(Map<String, Play> plays, Performance performance) {
        AbstractPerformanceCalculator calculator = AbstractPerformanceCalculator.
                createPerformanceCalculator(performance, plays.get(performance.getPlayID()));
        return new PerformanceData(performance, calculator.play);
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
            totalAmount += performance.amountFor();
        }
        return totalAmount;
    }

    public int volumeCredits() {
        int volumeCredits = 0;
        for (PerformanceData performance : performanceDataList) {
            volumeCredits += performance.volumeCredits(performance);
        }
        return volumeCredits;
    }

}

