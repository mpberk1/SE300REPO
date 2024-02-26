import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    public static void main(String[] args) {
        String csvFilePath = "Master 1.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            List<String[]> rows = new ArrayList<>();
            String line;

            // Read the header row
            String headerLine = reader.readLine();
            if (headerLine == null) {
                System.err.println("CSV file is empty.");
                return;
            }
            String[] headers = headerLine.split(",");

            // Read and process data rows
    
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                rows.add(data);
            }

            // Now you have your data in a List<String[]>.
            // Access it like rows.get(rowIndex)[columnIndex].
            // For example:
            String value = rows.get(200001)[0]; // First row, first column
            System.out.println(headers[1]);
            System.out.println(value);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
