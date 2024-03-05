
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

class CSVParser {
    private boolean check;

    public void parseCSV(String searchString, JTextArea outputArea) {
        String csvFilePath = "Master 1.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            List<String[]> rows = new ArrayList<>();
            String line;

            // Read the header row
            String headerLine = reader.readLine();
            if (headerLine == null) {
                outputArea.setText("CSV file is empty.");
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
            // String value = rows.get(0)[0]; // First row, first column
            int userTailNumberRow = 0;
            for (int i = 0; i < rows.size(); i++) {
                String value = rows.get(i)[0];
                if (value.equalsIgnoreCase(searchString)) {
                    setCheck(true);
                    outputArea.append("Tail Number found: " + searchString + "\n");
                    userTailNumberRow = i;
                    if (getCheck()) {
                        for (int j = 1; j < 34; j++) {
                            String output = rows.get(userTailNumberRow)[j];
                            outputArea.append("UserInfo " + output + "\n");
                        }
                        return; // Exit the method if found
                    }
            }
        }


            // If not found
            outputArea.setText("Text not found: " + searchString);

        } catch (IOException e) {
            e.printStackTrace();
            outputArea.setText("Error occurred: " + e.getMessage());
        }  
    }

   

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean getCheck() {
        return check;
    }
    
}