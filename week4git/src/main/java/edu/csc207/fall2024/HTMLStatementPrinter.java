package edu.csc207.fall2024;

import java.util.Map;

public class HTMLStatementPrinter extends StatementPrinter {

    public HTMLStatementPrinter(Invoice invoice, Map<String, Play> plays) {
        super(invoice, plays);
    }

    @Override
    public String statement() {
        final StringBuilder result = new StringBuilder(String.format("<h1>Statement for %s</h1>%n",
                statementData.getCustomer()));
        result.append("<table>").append(System.lineSeparator());
        result.append(String.format(" <caption>Statement for %s</caption>%n", statementData.getCustomer()));
        result.append(" <tr><th>play</th><th>seats</th><th>cost</th></tr>").append(System.lineSeparator());

        for (PerformanceData perfData : statementData.getPerformances()) {
            result.append(String.format(" <tr><td>%s</td><td>%d</td><td>%s</td></tr>%n",
                    perfData.getName(),
                    perfData.getAudience(),
                    usd(perfData.amountFor())));
        }

        result.append("</table>").append(System.lineSeparator());
        result.append(String.format("<p>Amount owed is <em>%s</em></p>%n", usd(statementData.totalAmount())));
        result.append(String.format("<p>You earned <em>%d</em> credits</p>%n", statementData.volumeCredits()));

        return result.toString();
    }
}
