package com.dians.hw2.filter.impl;

import com.dians.hw2.filter.Filter;

import java.util.HashSet;
import java.util.Set;

public class DuplicateRemovalFilter implements Filter<String> {
    private Set<String> uniqueIds = new HashSet<>();
    @Override
    public String execute(String input) {
        // Split the CSV line into columns
        String[] columns = input.split(",");

        // Assuming 'osm_id' is the column at index 0 (adjust if necessary)
        int osmIdIndex = 0;

        // Check if the 'osm_id' is already in the set
        if (osmIdIndex >= 0 && osmIdIndex < columns.length && uniqueIds.add(columns[osmIdIndex])) {
            // If it's not in the set, return the input unchanged
            return input;
        } else {
            // If it's in the set (duplicate), return null to indicate that this row should be filtered out
            return null;
        }
    }
}
