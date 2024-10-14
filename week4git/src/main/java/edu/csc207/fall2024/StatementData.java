package edu.csc207.fall2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Holds and processes the data for generating a statement for performances.
 */
public class StatementData {

    private final Invoice invoice;
    private final List<PerformanceData> performanceDataList;

    public StatementData(Invoice invoice, Map<String, Play> plays) {
        this.invoice = invoice;

        final List<PerformanceData> tempList = new ArrayList<>();
        for (Performance performance : invoice.getPerformances()) {
            final PerformanceData performanceData = createPerformanceData(performance, plays);
            tempList.add(performanceData);
        }
        this.performanceDataList = tempList;
    }

    /**
     * Creates a PerformanceData object using the given performance and plays.
     * @param performance the performance object.
     * @param plays the map of play IDs to Play objects.
     * @return a PerformanceData object with the calculated amount and credits.
     */
    private PerformanceData createPerformanceData(Performance performance, Map<String, Play> plays) {
        final Play play = plays.get(performance.getPlayID());
        final AbstractPerformanceCalculator calculator =
                AbstractPerformanceCalculator.createPerformanceCalculator(performance, play);

        final int amount = calculator.amountFor();
        final int volumeCredits = calculator.volumeCredits();

        return new PerformanceData(performance, play, amount, volumeCredits);
    }

    /**
     * Returns the name of the customer associated with the invoice.
     * @return the customer name.
     */
    public String getCustomer() {
        return invoice.getCustomer();
    }

    /**
     * Returns the list of performance data.
     * @return the list of PerformanceData objects.
     */
    public List<PerformanceData> getPerformances() {
        return performanceDataList;
    }

    /**
     * Calculates the total amount for all performances.
     * @return the total amount.
     */
    public int totalAmount() {
        int totalAmount = 0;
        for (PerformanceData performance : performanceDataList) {
            totalAmount += performance.getAmount();
        }
        return totalAmount;
    }

    /**
     * Calculates the total volume credits for all performances.
     * @return the total volume credits.
     */
    public int volumeCredits() {
        int volumeCredits = 0;
        for (PerformanceData performance : performanceDataList) {
            volumeCredits += performance.getVolumeCredits();
        }
        return volumeCredits;
    }

}

