import model.Pipe;
import service.impl.*;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;

public class PipeAndFilterProblem {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ClassLoader loader = PipeAndFilterProblem.class.getClassLoader();
        Scanner scanner = new Scanner(new File(loader.getResource("whole_macedonia.csv").getFile()));

        Pipe<String> pipe1 = new Pipe<>();
        Pipe<String> pipe2 = new Pipe<>();

        TourismFilter tourismFilter = new TourismFilter();
        HistoricFilter historicFilter = new HistoricFilter();

        pipe1.addFilter(tourismFilter);
        pipe2.addFilter(historicFilter);

        BufferedWriter writer = new BufferedWriter(new FileWriter("final_output_pipes.csv"));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            String filteredLine1 = pipe1.runFilters(line);
            String filteredLine2 = pipe2.runFilters(line);
            if(!filteredLine1.equals("")){
                System.out.println(filteredLine1);
                writer.write(filteredLine1);
                writer.newLine();
            }

            if(!filteredLine2.equals("")){
                System.out.println(filteredLine2);
                writer.write(filteredLine2);
                writer.newLine();
            }
        }

        writer.close();
    }
}
