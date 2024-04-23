<<<<<<< HEAD
<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
=======

=======
>>>>>>> 1051c99 (Migrated chnages)
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
<<<<<<< HEAD
>>>>>>> bb1e861 (Revert "Headers Included and .gitignored a file")
=======
import java.io.FileWriter;
>>>>>>> 1051c99 (Migrated chnages)
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

<<<<<<< HEAD
<<<<<<< HEAD

class CSVParser {
    private boolean check;

    public void parseMasterCSV(String searchString, String uniqueCode, JTextArea outputArea, JTextField[] editFields, JButton updateButton) {
=======
class CSVParser {
    private boolean check;

    public void parseCSV(String searchString, JTextArea outputArea) {
>>>>>>> bb1e861 (Revert "Headers Included and .gitignored a file")
=======

class CSVParser {
    private boolean check;

    public void parseMasterCSV(String searchString, String uniqueCode, JTextArea outputArea, JTextField[] editFields, JButton updateButton) {
>>>>>>> 1051c99 (Migrated chnages)
        String csvFilePath = "Master 1.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            List<String[]> rows = new ArrayList<>();
            String line;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
            // Read the header row
>>>>>>> d280e34 (message)
=======
            // Read the header row
>>>>>>> bb1e861 (Revert "Headers Included and .gitignored a file")
=======
>>>>>>> 1051c99 (Migrated chnages)
            String headerLine = reader.readLine();
            if (headerLine == null) {
                outputArea.setText("CSV file is empty.");
                return;
            }
            String[] headers = headerLine.split(",");

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
            // Read and process data rows
    
>>>>>>> d280e34 (message)
=======
            // Read and process data rows
>>>>>>> bb1e861 (Revert "Headers Included and .gitignored a file")
=======
>>>>>>> 1051c99 (Migrated chnages)
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                rows.add(data);
            }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
            int userTailNumberRow = -1;
=======
            // Now you have your data in a List<String[]>.
            // Access it like rows.get(rowIndex)[columnIndex].
            // For example:
            // String value = rows.get(0)[0]; // First row, first column
            int userTailNumberRow = 0;
>>>>>>> bb1e861 (Revert "Headers Included and .gitignored a file")
=======
            int userTailNumberRow = -1;
>>>>>>> 1051c99 (Migrated chnages)
            for (int i = 0; i < rows.size(); i++) {
                String value = rows.get(i)[0];
                if (value.equalsIgnoreCase(searchString)) {
                    setCheck(true);
                    outputArea.append("Tail Number found: " + searchString + "\n");
                    userTailNumberRow = i;
                    if (getCheck()) {
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 1051c99 (Migrated chnages)
                        if (rows.get(userTailNumberRow).length > 30) {
                            String storedUniqueCode = rows.get(userTailNumberRow)[30];
                            if (storedUniqueCode.equals(uniqueCode)) {
                                for (int j = 1; j < 6; j++) { // Only 5 fields available in LOG.csv
                                    editFields[j - 1].setEditable(true);
                                }
                                updateButton.setEnabled(true);
                                return;
                            } else {
                                outputArea.append("Incorrect Unique Code!\n");
                                return;
                            }
                        } else {
                            outputArea.append("Unique Code not found for the given tail number.\n");
<<<<<<< HEAD
                        }
                    }
                }
            }

            outputArea.setText("Tail Number not found: " + searchString);

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
=======
                        for (int j = 1; j < 34; j++) {
                            String output = rows.get(userTailNumberRow)[j];
                            outputArea.append("UserInfo " + output + "\n");
=======
>>>>>>> 1051c99 (Migrated chnages)
                        }
                    }
                }
            }

<<<<<<< HEAD

            // If not found
            outputArea.setText("Text not found: " + searchString);
>>>>>>> bb1e861 (Revert "Headers Included and .gitignored a file")
=======
            outputArea.setText("Tail Number not found: " + searchString);
>>>>>>> 1051c99 (Migrated chnages)

        } catch (IOException e) {
            e.printStackTrace();
            outputArea.setText("Error occurred: " + e.getMessage());
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
            // Now you have your data in a List<String[]>.
            // Access it like rows.get(rowIndex)[columnIndex].
            // For example:
            String value = rows.get(200001)[0]; // First row, first column
            System.out.println(headers[1]);
            System.out.println(value);
<<<<<<< HEAD
>>>>>>> d280e34 (message)

=======
            
>>>>>>> 5641652 (h)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
=======
=======
>>>>>>> ee441fb (j)
        }  
    }

   
>>>>>>> bb1e861 (Revert "Headers Included and .gitignored a file")
=======
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
>>>>>>> 1051c99 (Migrated chnages)

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean getCheck() {
        return check;
    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
}
=======
    
}
>>>>>>> bb1e861 (Revert "Headers Included and .gitignored a file")
=======
    
}
>>>>>>> ee441fb (j)
=======
}
>>>>>>> 1051c99 (Migrated chnages)
