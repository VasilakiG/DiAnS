package com.dians.backend.filter.impl;

import com.dians.backend.filter.Filter;

public class QuoteModifierFilter implements Filter<String> {
    @Override
    public String execute(String input) {
        // Split the CSV line into columns
        String[] columns = input.split(",");

        // Assuming the 4th column is at index 3 (adjust if necessary)
        int fourthColumnIndex = 3;

        // Check if the 4th column is within bounds
        if (fourthColumnIndex >= 0 && fourthColumnIndex < columns.length) {
            // Add double quotation marks to the 4th column
            columns[fourthColumnIndex] = "\"" + columns[fourthColumnIndex] + "\"";
        }

        // Join the modified columns back into a CSV line and return it
        return String.join(",", columns);
    }
}
