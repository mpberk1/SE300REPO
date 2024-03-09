import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

class CSVParser {
    private boolean check;

    public void parseCSV(String searchString, String uniqueCode, JTextArea outputArea) {
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
            int userTailNumberRow = -1; // Initialize to -1 to indicate not found
            for (int i = 0; i < rows.size(); i++) {
                String value = rows.get(i)[0];
                if (value.equalsIgnoreCase(searchString)) {
                    setCheck(true);
                    outputArea.append("Tail Number found: " + searchString + "\n");
                    userTailNumberRow = i;
                    if (getCheck()) {
                        // Check if the row contains the unique code in the 30th column
                        if (rows.get(userTailNumberRow).length > 30) {
                            String storedUniqueCode = rows.get(userTailNumberRow)[30];
                            if (storedUniqueCode.equals(uniqueCode)) {
                                // Output other information from columns
                                for (int j = 1; j < 34; j++) {
                                    String output = rows.get(userTailNumberRow)[j];
                                    outputArea.append(headers[j] + ": " + output + "\n");
                                }
                                return; // Exit the method if found and unique code matches
                            } else {
                                outputArea.append("Incorrect Unique Code!\n");
                                return; // Exit if unique code doesn't match
                            }
                        } else {
                            outputArea.append("Unique Code not found for the given tail number.\n");
                        }
                    }
                }
            }

            // If not found
            outputArea.setText("Tail Number not found: " + searchString);

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