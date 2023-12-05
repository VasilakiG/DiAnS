package service.impl;

import service.Filter;

public class HistoricFilter implements Filter {
    @Override
    public String execute(Object input) {
        // Split the CSV line into columns
        String[] columns = input.toString().split(",");

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
