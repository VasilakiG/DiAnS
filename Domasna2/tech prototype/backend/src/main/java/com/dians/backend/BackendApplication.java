package com.dians.backend;

import com.dians.backend.filter.impl.ColumnSelectionFilter;
import com.dians.backend.filter.impl.DuplicateRemovalFilter;
import com.dians.backend.filter.impl.HistoricFilter;
import com.dians.backend.filter.impl.TourismFilter;
import com.dians.backend.pipe.Pipe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.Scanner;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		SpringApplication.run(BackendApplication.class, args);

		ClassLoader loader = BackendApplication.class.getClassLoader();
		Scanner scanner = new Scanner(new File(loader.getResource("whole_macedonia.csv").getFile()));

		Pipe<String> pipe1 = new Pipe<>();
		Pipe<String> pipe2 = new Pipe<>();

		TourismFilter tourismFilter = new TourismFilter();
		HistoricFilter historicFilter = new HistoricFilter();
		ColumnSelectionFilter columnSelectionFilter = new ColumnSelectionFilter();
		DuplicateRemovalFilter duplicateRemovalFilter = new DuplicateRemovalFilter();

		pipe1.addFilter(tourismFilter);
		pipe1.addFilter(columnSelectionFilter);
		pipe1.addFilter(duplicateRemovalFilter);

		pipe2.addFilter(historicFilter);
		pipe2.addFilter(columnSelectionFilter);
		pipe2.addFilter(duplicateRemovalFilter);

		BufferedWriter writer = new BufferedWriter(new FileWriter("final_output_pipes.csv"));
		writer.write("osm_id,historic,tourism,way\n");

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();

			String filteredLine1 = pipe1.runFilters(line);
			String filteredLine2 = pipe2.runFilters(line);
			if(filteredLine1!=null && !filteredLine1.equals("") && !filteredLine1.equals(",,,")){
				System.out.println(filteredLine1);
				writer.write(filteredLine1);
				writer.newLine();
			}

			if(filteredLine2!=null && !filteredLine2.equals("") && !filteredLine2.equals(",,,")){
				System.out.println(filteredLine2);
				writer.write(filteredLine2);
				writer.newLine();
			}
		}

		writer.close();
	}
}
