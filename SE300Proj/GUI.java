import javax.swing.*;
import java.io.*;
class GUI
{
public static void main(String args[])  throws IOException
{
JFrame f= new JFrame("Plane Search ");
JTextField t12;
t12=new JTextField("\t\tEPIC GAMER Name!");
t12.setBounds(300,600, 250,300);

f.add(t12);
f.setSize(500,500);
f.setVisible(true);
}
}