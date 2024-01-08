package com.dians.backend.filter.impl;

import com.dians.backend.filter.Filter;

public class ColumnSelectionFilter implements Filter<String> {
    @Override
    public String execute(String input) {
        // Split the CSV line into columns
        String[] columns = input.split(",");

        // Assuming the indices of the desired columns
        int[] desiredColumnIndices = {0, 29, 59, 68};

        // Create a StringBuilder to store the filtered line
        StringBuilder filteredLineBuilder = new StringBuilder();

        // Append the desired columns to the filtered line
        for (int index : desiredColumnIndices) {
            if (index >= 0 && index < columns.length) {
                filteredLineBuilder.append(columns[index]).append(",");
            } else {
                // Handle the case where the index is out of bounds
                filteredLineBuilder.append(",");
            }
        }

        // Remove the trailing comma and return the filtered line
        return filteredLineBuilder.toString().replaceAll(",$", "");
    }
}
