package Bank;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
public class Account extends JFrame{
private JPanel contentPane;
static String srt;
public static void main(String[] args){
EventQueue.invokeLater(new Runnable(){
public void run(){
try{
Account frame=new Account();
frame.setVisible(true);
}catch(Exception e){
e.printStackTrace();
}
}
});
}
/**
*Create the frame.*/public void close(){
WindowEvent winE=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winE);
}
public Account(){
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setBounds(100,100,450,300);
contentPane=new JPanel();
contentPane.setBorder(new EmptyBorder(5,5,5,5));
setContentPane(contentPane);
contentPane.setLayout(null);
Login lg2=new Login();
JLabel lblWelcome=new JLabel("welcome to account:"+lg2.srt);
lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
lblWelcome.setBounds(49,11,377,14);
contentPane.add(lblWelcome);
JButton btnBalane=new JButton("balance");
btnBalane.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent arg0){
try{
Login lg=new Login();
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://loclhost:3306/test","root","");
Statement stmt=con.createStatement();
String sql1="Select balance from login where username=’"+lg.str+"’ and password=’"+lg.pass+"’";
ResultSet rs1=stmt.executeQuery(sql1);
int i;
while(rs1.next())
{
i=rs1.getInt(1);
srt=String.valueOf(i);
}
JOptionPane.showMessageDialog(null,"balance:"+srt);
con.close();
}
catch(Exception e){System.out.println(e);}
}
});
btnBalane.setBounds(49,33,145,23);
contentPane.add(btnBalane);
JButton btnWithdraw=new JButton("withdraw");
btnWithdraw.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent arg0){
close();
Withdraw b1=new Withdraw();
b1.setVisible(true);
}
});
btnWithdraw.setBounds(281,36,145,23);
contentPane.add(btnWithdraw);
JButton btnDeposit=new JButton("deposit");
btnDeposit.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent args0){
close();
Deposit b2=new Deposit();
b2.setVisible(true);
}
});
btnDeposit.setBounds(49,86,145,23);
contentPane.add(btnDeposit);
JButton btnChangepassword=new JButton("changepassword");
btnChangepassword.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent arg0){
close();
Changepassword b3=new Changepassword();
b3.setVisible(true);
}
});
btnChangepassword.setBounds(281,86,145,23);
contentPane.add(btnChangepassword);
JButton btnLogout=new JButton("logout");
btnLogout.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent arg0){
try{
JOptionPane.showMessageDialog(null,"logout successful");
close();
Login at=new Login();
at.setVisible(true);}
catch(Exception e){System.out.println(e);}
}
});
btnLogout.setBounds(194,134,89,23);
}
}

