package edu.csc207.fall2024;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatementData {

    private final Invoice invoice;
    private final List<PerformanceData> performanceDataList;

    public StatementData(Invoice invoice, Map<String, Play> plays) {
        this.invoice = invoice;
        this.performanceDataList = invoice.getPerformances().stream().map(performance -> new PerformanceData(performance, plays.get(performance.getPlayID()))).collect(Collectors.toList());
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

