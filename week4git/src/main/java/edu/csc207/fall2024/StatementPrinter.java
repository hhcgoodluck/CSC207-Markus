package edu.csc207.fall2024;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

/**
 * This class generates a statement for a given invoice of performances.
 */
public class StatementPrinter {
    public final StatementData statementData;
    /**
     * Constructs a new StatementPrinter with the given invoice and plays.
     * @param invoice the invoice containing the performances
     * @param plays the map of play IDs to play objects
     */
    public StatementPrinter(Invoice invoice, Map<String, Play> plays) {
        this.statementData = new StatementData(invoice, plays);
    }

    /**
     * Returns a formatted statement of the invoice associated with this printer.
     * @return the formatted statement
     * @throws RuntimeException if one of the play types is not known.
     */
    public String statement() {
        return renderPlainText(statementData);
    }

    public String renderPlainText(StatementData statementData) {
        String result = "Statement for " + statementData.getCustomer() + "\n";
        for (PerformanceData performanceData : statementData.getPerformances()) {
            // print line for this order
            result += String.format("  %s: %s (%s seats)%n", performanceData.getName(),
                    usd(performanceData.amountFor()), performanceData.getAudience());
        }

        result += String.format("Amount owed is %s%n", usd(statementData.totalAmount()));
        result += String.format("You earned %s credits\n", statementData.volumeCredits());
        return result;
    }

    public static String usd(int totalAmount) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(totalAmount / Constants.PERCENT_FACTOR);
    }

}
