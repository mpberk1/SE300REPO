import javax.swing.*;
import java.io.*;
class GUI
{
public static void main(String args[])  throws IOException
{
JFrame f= new JFrame("Example of TextField ");
//variable declaration
JTextField t12,t22;
t12=new JTextField("EPIC GAMER Name!");
t12.setBounds(10,100, 250,30);
//declaring new example
t22=new JTextField("new example");
//setting bounds
t22.setBounds(10,150, 100,30);
//adding into frames
f.add(t12); f.add(t22);
f.setSize(500,500);
f.setVisible(true);
}
}