package com.dians.backend.filter.impl;

import com.dians.backend.filter.Filter;

public class EmptyValueReplacementFilter implements Filter<String> {
    @Override
    public String execute(String input) {
        // Split the CSV line into columns
        String[] columns = input.split(",");

        // Replace empty values with "-"
        for (int i = 0; i < columns.length; i++) {
            if (columns[i].trim().isEmpty()) {
                columns[i] = "-";
            }
        }

        // Join the modified columns back into a CSV line and return it
        return String.join(",", columns);
    }
}
