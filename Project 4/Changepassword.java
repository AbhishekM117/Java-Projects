package Bank;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.sql.*;
public class Changepassword extends JFrame{
	private static final long serialVersionUID = 1L;
private JPanel contentPane;
private JPasswordField changepas;
private JPasswordField oldpas;
static String srt;
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() { 
public void run() {
try {
Changepassword frame= new Changepassword();
frame.setVisible(true);
} catch (Exception e){
e.printStackTrace();
}
}
});
}
public void close() {
WindowEvent wine= new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wine);
}
public Changepassword() {
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setBounds(100,100,450,300);
contentPane=new JPanel();
contentPane.setBorder(new EmptyBorder(5,5,5,5));
setContentPane(contentPane);
contentPane.setLayout(null);
JLabel lblchangepassword=new JLabel("Change password");
lblchangepassword.setHorizontalAlignment(SwingConstants.CENTER);
lblchangepassword.setBounds(48,11,366,14);
contentPane.add(lblchangepassword);
JButton btnnewbutton= new JButton("change");
btnnewbutton.addActionListener(new ActionListener() {
public void actionPerformed1(ActionEvent arg0){
try{ Login lg=new Login();
Class.forName("com.mysql.jbdc.driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?test","root","");
srt=oldpas.getText();
if(srt.equalsIgnoreCase(lg.pass)){
String sql="update login set password=? Where password=?";
PreparedStatement stmt=con.prepareStatement(sql);
stmt.setString(1,changepas.getText());
stmt.setString(2,lg.pass);
stmt.executeUpdate();

JOptionPane.showMessageDialog(null,"successfully changed password");
close();
Login at=new Login();
at.setVisible(true);
}
else
{
JOptionPane.showMessageDialog(null,"invalid password");
}
con.close();
}
catch(Exception e){System.out.println(e);}
}
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}
});
btnnewbutton.setBounds(183,189,89,23);
contentPane.add(btnnewbutton);
changepas=new JPasswordField();
changepas.setBounds(48,107,327,20);
contentPane.add(changepas);
JLabel lbloldpassword=new JLabel("old password");
lbloldpassword.setBounds(48,24,224,14);
contentPane.add(lbloldpassword);
oldpas=new JPasswordField();
oldpas.setBounds(48,49,327,20);
contentPane.add(oldpas);
JLabel lblnewpassword=new JLabel("new password");
lblnewpassword.setBounds(48,80,245,14);
contentPane.add(lblnewpassword);
}
}
Deposit.java
package Bank;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;
public class Deposit extends JFrame{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JPanel contentpane;
private JTextField deposit;
static String srt;
/**
*launch the application
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() { 
public void run() {
try {
Deposit frame=new Deposit();
frame.setVisible(true);
}catch(Exception e) {
e.printStackTrace();
}
}
});
}
/**
*create the frame
*/
public void close() {
WindowEvent wine = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wine);
}
public Deposit(){
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setBounds(100,100,450,300);
contentpane=new JPanel();
contentpane.setBorder(new EmptyBorder(5,5,5,5));
setContentPane(contentpane);
contentpane.setLayout(null);
JLabel lbldeposit=new JLabel("deposit");
lbldeposit.setBounds(188,11,49,14);
contentpane.add(lbldeposit);
deposit=new JTextField();
deposit.setBounds(188,11,49,14);
contentpane.add(deposit);
deposit.setColumns(10);
JButton btnpressok= new JButton("press ok");
btnpressok.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0){
try{Login lg=new Login();
Class.forName("com.mysql.jbdc.driver");
Connection con=DriverManager.getConnection("jbdc:mysql://localhost:3306/test","root","");
Statement stmt1=con.createStatement();
String sql1="select balance from login where username='"+lg.str+"'and password'"+lg.pass+"";
srt=deposit.getText();
int j=Integer.parseInt(srt.trim()),k=0;
ResultSet rs1=stmt1.executeQuery(sql1);
int i;
while(rs1.next())
{
i=rs1.getInt(1);
k=i;
}
k=k+j;
String sql="update login set balance = ? where password =?";
PreparedStatement stmt=con.prepareStatement(sql);
stmt.setInt(1,k);
stmt.setString(2,lg.pass);
stmt.executeUpdate();
JOptionPane.showMessageDialog(null,"balance:"+k);
close();
Account at=new Account();
at.setVisible(true);
con.close();
}
catch(Exception e){System.out.println(e);}
}

public void actionPerformed1(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}
});
btnpressok.setBounds(158,96,89,23);
contentpane.add(btnpressok);
}
}