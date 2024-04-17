import java.io.BufferedReader;
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
                    outputArea.append("Tail Number found: " + searchString + "\n");
                    userTailNumberRow = i;
                    if (getCheck()) {
                        if (rows.get(userTailNumberRow).length > 30) {
                            String storedUniqueCode = rows.get(userTailNumberRow)[30];
                            if (storedUniqueCode.equals(uniqueCode)) {
                                for (int j = 1; j < 6; j++) { // Only 5 fields available in LOG.csv
                                    editFields[j - 1].setEditable(true);
                                }
                                return;
                            } else {
                                outputArea.append("Incorrect Unique Code!\n");
                                return;
                            }
                        } else {
                            outputArea.append("Unique Code not found for the given tail number.\n");
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
                        String output = rows.get(userTailNumberRow)[j];
                        editFields[j - 1].setText(output);
                    }
                    return;
                }
            }

            outputArea.setText("Tail Number not found in LOG.csv: " + searchString);

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