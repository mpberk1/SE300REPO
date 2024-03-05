import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

class GUI {
    private String userSearchString;

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

        grabButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myobj.setUserSearchString(t12.getText());
                outputArea.setText("Text grabbed: " + myobj.getUserSearchString());

                // Call the parseCSV method of CSVParser
                ob1.parseCSV(myobj.getUserSearchString(), outputArea);
            }
        });

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose(); // Close the JFrame
            }
        });

        f.add(t12);
        f.add(grabButton);
        f.add(closeButton);
        f.add(outputArea);

        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void setUserSearchString(String userSearchString) {
        this.userSearchString = userSearchString;
    }

    public String getUserSearchString() {
        return userSearchString;
    }
}
