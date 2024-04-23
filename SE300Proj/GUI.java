import javax.swing.*;
<<<<<<< HEAD
import java.awt.*;
=======
>>>>>>> bb1e861 (Revert "Headers Included and .gitignored a file")
import java.awt.event.*;
import java.io.IOException;

class GUI {
    private String userSearchString;
<<<<<<< HEAD
    private String userUniqueCode;

    public static void main(String args[]) throws IOException {

        JFrame f = new JFrame("Digital Maintenance Log");
        GUI myobj = new GUI();
        CSVParser ob1 = new CSVParser();

        JLabel titleLabel = new JLabel("Digital Maintenance Log");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(250, 10, 250, 30);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        f.add(titleLabel);

        JTextField t12;
        t12 = new JTextField("Enter Tail Number");
        t12.setHorizontalAlignment(JTextField.CENTER);
        t12.setBounds(250, 50, 200, 30);

        JTextField tUniqueCode;
        tUniqueCode = new JTextField("Enter Unique Code");
        tUniqueCode.setHorizontalAlignment(JTextField.CENTER);
        tUniqueCode.setBounds(250, 100, 200, 30);

        JButton grabButton = new JButton("Search");
        grabButton.setBounds(300, 150, 100, 30);

        JButton closeButton = new JButton("Close");
        closeButton.setBounds(100, 600, 100, 30);

        JButton updateButton = new JButton("Update");
        updateButton.setBounds(300, 600, 100, 30);
        updateButton.setEnabled(false);

        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setBounds(50, 200, 600, 300);
        outputArea.setBackground(new Color(135, 206, 235));

        // Text fields for editing parts and dates
        JLabel[] labels = new JLabel[5];
        JTextField[] editFields = new JTextField[5]; // Only 5 fields available in LOG.csv
        labels[0] = new JLabel("Engine");
        labels[1] = new JLabel("Empennage");
        labels[2] = new JLabel("Wings");
        labels[3] = new JLabel("Fuselage");
        labels[4] = new JLabel("Date Maintained");
        for (int i = 0; i < 5; i++) {
            editFields[i] = new JTextField();
            editFields[i].setBounds(250, 200 + i * 50, 200, 30);
            editFields[i].setHorizontalAlignment(JTextField.CENTER);
            editFields[i].setEditable(false);
            editFields[i].setVisible(false); // Initially hide
            labels[i].setBounds(250, 225 + i * 50, 200, 20); // Adjusted y-coordinate to be directly under the edit
                                                             // field
            labels[i].setHorizontalAlignment(JLabel.CENTER);
            labels[i].setVisible(false); // Initially hide

            f.add(editFields[i]);
            f.add(labels[i]);
        }
=======

    public static void main(String args[]) throws IOException {
        JFrame f = new JFrame("Plane Search");
        GUI myobj = new GUI();
        CSVParser ob1 = new CSVParser();
        JTextField t12;
        t12 = new JTextField("EPIC GAMER Name!");
        t12.setHorizontalAlignment(JTextField.CENTER); // Center align the text
        t12.setBounds(150, 200, 200, 30);

        JButton grabButton = new JButton("Grab Text");
        grabButton.setBounds(200, 250, 100, 30);

        JButton closeButton = new JButton("Close");
        closeButton.setBounds(200, 400, 100, 30);

        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setBounds(150, 300, 200, 100);
>>>>>>> bb1e861 (Revert "Headers Included and .gitignored a file")

        grabButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myobj.setUserSearchString(t12.getText());
<<<<<<< HEAD
                myobj.setUserUniqueCode(tUniqueCode.getText());
        
                ob1.parseMasterCSV(myobj.getUserSearchString(), myobj.getUserUniqueCode(), outputArea, editFields, updateButton);
        
                // Check if the tail number is found and the code is correct before showing the edit fields
                if (ob1.getCheck() && updateButton.isEnabled()) {
                    // Call the parseLogCSV method of CSVParser
                    ob1.parseLogCSV(myobj.getUserSearchString(), outputArea, editFields);
        
                    // Show the edit fields after search
                    for (int i = 0; i < 5; i++) {
                        editFields[i].setVisible(true);
                        labels[i].setVisible(true);
                    }
                } else if (ob1.getCheck() && !updateButton.isEnabled()) {
                    // Tail number is found but unique code is incorrect
                    outputArea.append("Incorrect Unique Code!\n");
                } else {
                    // Tail number not found
                    outputArea.setText("Tail Number not found: " + myobj.getUserSearchString());
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
=======
                //outputArea.setText("Text grabbed: " + myobj.getUserSearchString());

                // Call the parseCSV method of CSVParser
                ob1.parseCSV(myobj.getUserSearchString(), outputArea);
>>>>>>> bb1e861 (Revert "Headers Included and .gitignored a file")
            }
        });

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose(); // Close the JFrame
            }
        });

        f.add(t12);
<<<<<<< HEAD
        f.add(tUniqueCode);
        f.add(grabButton);
        f.add(closeButton);
        f.add(updateButton);
        f.add(outputArea);

        f.setSize(700, 700); // Widened the frame
        f.setLayout(null);
        f.getContentPane().setBackground(new Color(135, 206, 235));
        f.setVisible(true);

        // Change button color
        UIManager.put("Button.background", UIManager.getColor("Panel.background"));
        UIManager.put("Button.foreground", UIManager.getColor("Panel.foreground"));
=======
        f.add(grabButton);
        f.add(closeButton);
        f.add(outputArea);

        f.setSize(1000, 1000);
        f.setLayout(null);
        f.setVisible(true);
>>>>>>> bb1e861 (Revert "Headers Included and .gitignored a file")
    }

    public void setUserSearchString(String userSearchString) {
        this.userSearchString = userSearchString;
    }

    public String getUserSearchString() {
        return userSearchString;
    }
<<<<<<< HEAD

    public void setUserUniqueCode(String userUniqueCode) {
        this.userUniqueCode = userUniqueCode;
    }

    public String getUserUniqueCode() {
        return userUniqueCode;
    }
=======
>>>>>>> bb1e861 (Revert "Headers Included and .gitignored a file")
}
