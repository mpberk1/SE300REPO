import javax.swing.*;
import java.io.*;
class GUI
{
public static void main(String args[])  throws IOException
{
JFrame f= new JFrame("Plane Search ");
JTextField t12;
t12=new JTextField("EPIC GAMER Name!");
t12.setBounds(10,100, 250,30);

f.add(t12);
f.setSize(500,500);
f.setVisible(true);
}
}