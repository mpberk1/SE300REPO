import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


class GUI {
    private String userSearchString;
    private String userUniqueCode;

    public static void main(String args[]) throws IOException {
        JFrame f = new JFrame("Plane Search");
        GUI myobj = new GUI();
        CSVParser ob1 = new CSVParser();

        JTextField t12;
        t12 = new JTextField("Enter Tail Number");
        t12.setHorizontalAlignment(JTextField.CENTER);
        t12.setBounds(150, 50, 200, 30);

        JTextField tUniqueCode;
        tUniqueCode = new JTextField("Enter Unique Code");
        tUniqueCode.setHorizontalAlignment(JTextField.CENTER);
        tUniqueCode.setBounds(150, 100, 200, 30);

        JButton grabButton = new JButton("Search");
        grabButton.setBounds(200, 150, 100, 30);

        JButton closeButton = new JButton("Close");
        closeButton.setBounds(50, 600, 100, 30);

        JButton updateButton = new JButton("Update");
        updateButton.setBounds(200, 600, 100, 30);
        updateButton.setEnabled(false);

        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setBounds(50, 200, 400, 300);

        // Text fields for editing parts and dates
        JTextField[] editFields = new JTextField[5]; // Only 5 fields available in LOG.csv
        for (int i = 0; i < 5; i++) {
            editFields[i] = new JTextField();
            editFields[i].setBounds(150, 200 + i * 50, 200, 30);
            editFields[i].setHorizontalAlignment(JTextField.CENTER);
            editFields[i].setEditable(false);
            editFields[i].setVisible(false); // Initially hide
            f.add(editFields[i]);
        }

        grabButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myobj.setUserSearchString(t12.getText());
                myobj.setUserUniqueCode(tUniqueCode.getText());
                // Call the parseMasterCSV method of CSVParser
                ob1.parseMasterCSV(myobj.getUserSearchString(), myobj.getUserUniqueCode(), outputArea, editFields, updateButton);
                // Call the parseLogCSV method of CSVParser
                ob1.parseLogCSV(myobj.getUserSearchString(), outputArea, editFields);
                // Show the edit fields after search
                for (int i = 0; i < 5; i++) {
                    editFields[i].setVisible(true);
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] newData = new String[5];
                for (int i = 0; i < 5; i++) {
                    newData[i] = editFields[i].getText();
                }
                ob1.updateLogCSV(myobj.getUserSearchString(), newData);
                outputArea.setText("Data updated successfully!");
            }
        });

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose(); // Close the JFrame
            }
        });

        f.add(t12);
        f.add(tUniqueCode);
        f.add(grabButton);
        f.add(closeButton);
        f.add(updateButton);
        f.add(outputArea);

        f.setSize(500, 700);
        f.setLayout(null);
        f.getContentPane().setBackground(new Color(135, 206, 235));
        f.setVisible(true);

        // Change button color
        UIManager.put("Button.background", UIManager.getColor("Panel.background"));
        UIManager.put("Button.foreground", UIManager.getColor("Panel.foreground"));
    }

    public void setUserSearchString(String userSearchString) {
        this.userSearchString = userSearchString;
    }

    public String getUserSearchString() {
        return userSearchString;
    }

    public void setUserUniqueCode(String userUniqueCode) {
        this.userUniqueCode = userUniqueCode;
    }

    public String getUserUniqueCode() {
        return userUniqueCode;
    }
}