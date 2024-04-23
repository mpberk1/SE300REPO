import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;


class CSVParser {
    private boolean check;

    public void parseMasterCSV(String searchString, String uniqueCode, JTextArea outputArea, JTextField[] editFields, JButton updateButton) {
        String csvFilePath = "Master 1.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            List<String[]> rows = new ArrayList<>();
            String line;

            String headerLine = reader.readLine();
            if (headerLine == null) {
                outputArea.setText("CSV file is empty.");
                return;
            }
            String[] headers = headerLine.split(",");

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                rows.add(data);
            }

            int userTailNumberRow = -1;
            for (int i = 0; i < rows.size(); i++) {
                String value = rows.get(i)[0];
                if (value.equalsIgnoreCase(searchString)) {
                    setCheck(true);
                    outputArea.append("Tail Number found: N" + searchString + "\n");
                    userTailNumberRow = i;
                    if (getCheck()) {
                        if (rows.get(userTailNumberRow).length > 30) {
                            String storedUniqueCode = rows.get(userTailNumberRow)[30];
                            if (storedUniqueCode.equals(uniqueCode)) {
                                for (int j = 1; j < 6; j++) { // Only 5 fields available in LOG.csv
                                    editFields[j - 1].setEditable(true);
                                }
                                outputArea.append("Welcome User: " + rows.get(userTailNumberRow)[6].substring(0, 12) + "\n");
                                outputArea.append("Year Manufactured: " + rows.get(userTailNumberRow)[4] + "\n");
                                String date = rows.get(userTailNumberRow)[23];
                                String formattedDate = date.substring(4, 6) + "/" + date.substring(6) + "/" + date.substring(0,4);
                                outputArea.append("Airworthiness Date: " + formattedDate + "\n");

                                outputArea.append("Registration Expiration Date: " + rows.get(userTailNumberRow)[29] + "\n");
                                
                                updateButton.setEnabled(true);
                                return;
                            } else {
                               // outputArea.append("Incorrect Unique Code!\n");
                                return;
                            }
                        } else {
                            outputArea.append("Unique Code not found for the given tail number.\n");
                        }
                    }
                }
            }

            outputArea.setText("Tail Number not found: " + searchString + "\n");

        } catch (IOException e) {
            e.printStackTrace();
            outputArea.setText("Error occurred: " + e.getMessage());
        }
    }

    public void parseLogCSV(String searchString, JTextArea outputArea, JTextField[] editFields) {
    String csvFilePath = "LOG.csv";

    try {
        // Create LOG.csv file if it doesn't exist
        boolean fileExists = new File(csvFilePath).exists();
        if (!fileExists) {
            FileWriter writer = new FileWriter(csvFilePath);
            writer.append("Tail Number,Engine,Empennage,Wings,Fuselage,Date Maintained\n");
            try (BufferedReader reader = new BufferedReader(new FileReader("Master 1.csv"))) {
                reader.readLine(); // Skip header line
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] rowData = line.split(",");
                    // Check if there are enough elements in rowData
                    if (rowData.length >= 1) {
                        writer.append(rowData[0]); // Write Tail Number
                        for (int i = 0; i < 5; i++) { 
                            writer.append(",Update Maintence Here");
                        }
                        writer.append("\n");
                    }
                }
            }
            writer.close(); // Close the FileWriter
        }

        // Read from LOG.csv
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            List<String[]> rows = new ArrayList<>();
            String line;
            String headerLine = reader.readLine();
            if (headerLine == null) {
                outputArea.setText("LOG.csv file is empty.");
                return;
            }
            String[] headers = headerLine.split(",");
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                rows.add(data);
            }

            int userTailNumberRow = -1;
            for (int i = 0; i < rows.size(); i++) {
                String value = rows.get(i)[0];
                if (value.equalsIgnoreCase(searchString)) {
                    userTailNumberRow = i;
                    for (int j = 1; j < 6; j++) { // Only 5 fields available in LOG.csv
                        if (userTailNumberRow < rows.size()) { // Ensure row exists
                            String output = rows.get(userTailNumberRow)[j];
                            editFields[j - 1].setText(output);
                        }
                    }
                    return;
                }
            }

            outputArea.setText("Tail Number not found in LOG.csv: " + searchString);

        } catch (IOException e) {
            e.printStackTrace();
            outputArea.setText("Error occurred: " + e.getMessage());
        }
    } catch (IOException e) {
        e.printStackTrace();
        outputArea.setText("Error occurred: " + e.getMessage());
    }
}

    public void updateLogCSV(String searchString, String[] newData) {
        String csvFilePath = "LOG.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            List<String> fileContent = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith(searchString)) {
                    line = searchString + "," + newData[0] + "," + newData[1] + "," + newData[2] + "," + newData[3] + "," + newData[4];
                }
                fileContent.add(line);
            }

            try (FileWriter writer = new FileWriter(csvFilePath)) {
                for (String updatedLine : fileContent) {
                    writer.write(updatedLine + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean getCheck() {
        return check;
    }
}
