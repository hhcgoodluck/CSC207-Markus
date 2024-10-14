package edu.csc207.fall2024;

import java.util.Map;

/**
 * A specialized statement printer that generates the statement in HTML format.
 * This class extends StatementPrinter to provide an HTML-specific version of the statement.
 */
public class HTMLStatementPrinter extends StatementPrinter {

    /**
     * Constructs an HTMLStatementPrinter with the given invoice and plays.
     * @param invoice the invoice containing the performances.
     * @param plays the map of play IDs to Play objects.
     */
    public HTMLStatementPrinter(Invoice invoice, Map<String, Play> plays) {
        super(invoice, plays);
    }

    /**
     * Generates an HTML-formatted statement for the invoice.
     * @return the HTML representation of the statement.
     */
    @Override
    public String statement() {
        final StringBuilder result = new StringBuilder(String.format("<h1>Statement for %s</h1>%n",
                getStatementData().getCustomer()));
        result.append("<table>").append(System.lineSeparator());
        result.append(String.format(" <caption>Statement for %s</caption>%n", getStatementData().getCustomer()));
        result.append(" <tr><th>play</th><th>seats</th><th>cost</th></tr>").append(System.lineSeparator());

        for (PerformanceData perfData : getStatementData().getPerformances()) {
            result.append(String.format(" <tr><td>%s</td><td>%d</td><td>%s</td></tr>%n",
                    perfData.getName(),
                    perfData.getAudience(),
                    usd(perfData.getAmount())));
        }

        result.append("</table>").append(System.lineSeparator());
        result.append(String.format("<p>Amount owed is <em>%s</em></p>%n", usd(getStatementData().totalAmount())));
        result.append(String.format("<p>You earned <em>%d</em> credits</p>%n", getStatementData().volumeCredits()));

        return result.toString();
    }
}
