package com.dians.backend;

import com.dians.backend.filter.impl.*;
import com.dians.backend.pipe.Pipe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.io.*;
import java.util.Scanner;

@ServletComponentScan
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
		QuoteModifierFilter quoteModifierFilter = new QuoteModifierFilter();
		SpaceRemovalFilter spaceRemovalFilter = new SpaceRemovalFilter();
		ValueChangeFilter valueChangeFilter = new ValueChangeFilter();
		EmptyValueReplacementFilter emptyValueReplacementFilter = new EmptyValueReplacementFilter();

		pipe1.addFilter(tourismFilter);
		pipe1.addFilter(columnSelectionFilter);
		//pipe1.addFilter(spaceRemovalFilter);
		pipe1.addFilter(quoteModifierFilter);
		//pipe1.addFilter(valueChangeFilter);
		pipe1.addFilter(emptyValueReplacementFilter);
		pipe1.addFilter(duplicateRemovalFilter);

		pipe2.addFilter(historicFilter);
		pipe2.addFilter(columnSelectionFilter);
		//pipe2.addFilter(spaceRemovalFilter);
		pipe2.addFilter(quoteModifierFilter);
		//pipe2.addFilter(valueChangeFilter);
		pipe2.addFilter(emptyValueReplacementFilter);
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
