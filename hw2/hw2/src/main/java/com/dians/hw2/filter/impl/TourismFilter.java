package com.dians.hw2.filter.impl;

import com.dians.hw2.filter.Filter;

public class TourismFilter implements Filter<String> {
    @Override
    public String execute(String input) {
        // Split the CSV line into columns
        String[] columns = input.split(",");

        // Assuming 'tourism' is the column at index 50 (adjust if necessary)
        int tourismIndex = 59;

        // Check if the 'tourism' column has the value 'attraction'
        if (columns.length > tourismIndex && columns[tourismIndex].equalsIgnoreCase("attraction")) {
            // If it does, return the input unchanged
            return input.toString();
        } else {
            // If not, return null to indicate that this row should be filtered out
            return "";
        }
    }
}
