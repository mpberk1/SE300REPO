import javax.swing.*;
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
        t12.setHorizontalAlignment(JTextField.CENTER); // Center align the text
        t12.setBounds(150, 50, 200, 30);

        JTextField tUniqueCode;
        tUniqueCode = new JTextField("Enter Unique Code");
        tUniqueCode.setHorizontalAlignment(JTextField.CENTER); // Center align the text
        tUniqueCode.setBounds(150, 100, 200, 30);

        JButton grabButton = new JButton("Grab Text");
        grabButton.setBounds(200, 150, 100, 30);

        JButton closeButton = new JButton("Close");
        closeButton.setBounds(200, 250, 100, 30);

        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setBounds(50, 300, 400, 300);

        grabButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myobj.setUserSearchString(t12.getText());
                myobj.setUserUniqueCode(tUniqueCode.getText());
                
                // Call the parseCSV method of CSVParser
                ob1.parseCSV(myobj.getUserSearchString(), myobj.getUserUniqueCode(), outputArea);
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
        f.add(outputArea);

        f.setSize(500, 700); // Increased window size
        f.setLayout(null);
        f.setVisible(true);
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
