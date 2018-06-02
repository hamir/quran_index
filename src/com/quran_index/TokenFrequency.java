package com.quran_index;

import org.jqurantree.analysis.AnalysisTable;
import org.jqurantree.analysis.SortOrder;
import org.jqurantree.orthography.Document;
import org.jqurantree.orthography.Token;

public class TokenFrequency {

    public static void main(String[] args) {
        // Example #1.
        topTokensWithDiacritics();

        // Example #2.
        topTokensWithoutDiacritics();
    }

    private static void topTokensWithDiacritics() {

        // Create a new analysis table.
        AnalysisTable table = new AnalysisTable("Token");

        // Add each token to the table.
        for (Token token : Document.getTokens()) {
            table.add(token.toBuckwalter());
        }

        // Group and display top 10 results.
        AnalysisTable groupTable = table.group("Token");
        groupTable.sort("Count", SortOrder.Descending);
        System.out.println(groupTable.toString(10));
    }

    private static void topTokensWithoutDiacritics() {

        // Create a new analysis table.
        AnalysisTable table = new AnalysisTable("Token");

        // Add each token to the table, without diacritics.
        for (Token token : Document.getTokens()) {
            table.add(token.removeDiacritics().toBuckwalter());
        }

        // Group and display top 10 results.
        AnalysisTable groupTable = table.group("Token");
        groupTable.sort("Count", SortOrder.Descending);
        System.out.println(groupTable.toString(10));
    }
}
