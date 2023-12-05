package com.dians.backend.filter.impl;

import com.dians.backend.filter.Filter;

public class HistoricFilter implements Filter<String>{
    @Override
    public String execute(String input) {
        // Split the CSV line into columns
        String[] columns = input.split(",");

        // Assuming 'attraction' is the column at index 51 (adjust if necessary)
        int attractionIndex = 29;

        // Check if the 'attraction' column has the value 'monument'
        if (columns.length > attractionIndex && columns[attractionIndex].equalsIgnoreCase("monument")) {
            // If it does, return the input unchanged
            return input.toString();
        } else {
            // If not, return null to indicate that this row should be filtered out
            return "";
        }
    }
}
