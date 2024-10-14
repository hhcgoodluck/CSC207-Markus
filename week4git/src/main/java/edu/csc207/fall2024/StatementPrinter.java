package edu.csc207.fall2024;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

/**
 * This class generates a statement for a given invoice of performances.
 */
public class StatementPrinter {
    private final Invoice invoice;
    private final Map<String, Play> plays;

    /**
     * Constructs a new StatementPrinter with the given invoice and plays.
     * @param invoice the invoice containing the performances
     * @param plays the map of play IDs to play objects
     */
    public StatementPrinter(Invoice invoice, Map<String, Play> plays) {
        this.invoice = invoice;
        this.plays = plays;
    }

    /**
     * Returns a formatted statement of the invoice associated with this printer.
     * @return the formatted statement
     * @throws RuntimeException if one of the play types is not known.
     */
    public String statement() {

        String result = "Statement for " + getInvoice().getCustomer() + "\n";
        for (Performance performance : getInvoice().getPerformances()) {
            // print line for this order
            result += String.format("  %s: %s (%s seats)%n", getPlay(performance).getName(),
                    usd(getAmount(performance)), performance.getAudience());
        }

        result += String.format("Amount owed is %s%n", usd(getTotalAmount()));
        result += String.format("You earned %s credits\n", getVolumeCredits());
        return result;
    }

    private int getTotalAmount() {
        int totalAmount = 0;
        for (Performance performance : getInvoice().getPerformances()) {
            totalAmount += getAmount(performance);
        }
        return totalAmount;
    }

    private int getVolumeCredits() {
        int volumeCredits = 0;
        for (Performance performance : getInvoice().getPerformances()) {
            volumeCredits += volumeCreditsFor(performance);
        }
        return volumeCredits;
    }

    private static String usd(int totalAmount) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(totalAmount / Constants.PERCENT_FACTOR);
    }

    private int volumeCreditsFor(Performance performance) {
        int result = 0;
        // add volume credits
        result += Math.max(performance.getAudience() - Constants.BASE_VOLUME_CREDIT_THRESHOLD, 0);
        // add extra credit for every five comedy attendees
        if ("comedy".equals(getPlay(performance).getType())) {
            result += performance.getAudience() / Constants.COMEDY_EXTRA_VOLUME_FACTOR;
        }
        return result;
    }

    private Play getPlay(Performance performance) {
        return getPlays().get(performance.getPlayID());
    }

    private int getAmount(Performance performance) {
        int result = amountFor(performance);
        return result;
    }

    private int amountFor(Performance performance) {
        int result = 0;

        switch (getPlay(performance).getType()) {
            case "tragedy":
                result = Constants.TRAGEDY_BASE_AMOUNT;
                if (performance.getAudience() > Constants.TRAGEDY_AUDIENCE_THRESHOLD) {
                    result += Constants.TRAGEDY_OVER_BASE_CAPACITY_PER_PERSON * (performance.getAudience()
                            - Constants.TRAGEDY_AUDIENCE_THRESHOLD);
                }
                break;
            case "comedy":
                result = Constants.COMEDY_BASE_AMOUNT;
                if (performance.getAudience() > Constants.COMEDY_AUDIENCE_THRESHOLD) {
                    result += Constants.COMEDY_OVER_BASE_CAPACITY_AMOUNT
                            + (Constants.COMEDY_OVER_BASE_CAPACITY_PER_PERSON
                            * (performance.getAudience() - Constants.COMEDY_AUDIENCE_THRESHOLD));
                }
                result += Constants.COMEDY_AMOUNT_PER_AUDIENCE * performance.getAudience();
                break;
            default:
                throw new RuntimeException(String.format("unknown type: %s", getPlay(performance).getType()));
        }
        return result;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public Map<String, Play> getPlays() {
        return plays;
    }

}
