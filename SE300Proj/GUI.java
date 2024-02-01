import javax.swing.*;
class GUI{
    public static void main(String args[]){
       JFrame frame = new JFrame("Plane Part Stuff");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(300,300);
       JButton button = new JButton("Press");
       frame.getContentPane().add(button); // Adds Button to content pane of frame
       frame.setVisible(true);
    }
}