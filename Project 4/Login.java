package Bank;
import java.awt.EventQueue;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Login extends JFrame{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JPanel contentPane;
private JTextField user;
private JPasswordField pas;
String srt;
String pass;
String str;
public static void main(String[] args){
EventQueue.invokeLater(new Runnable(){
public void run(){
try{
Login frame = new Login();
frame.setVisible(true);
}catch (Exception e) {
e.printStackTrace();
}
}
});
}
public void close() {
WindowEvent winE=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winE);
}
public Login(){
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setBounds(100,100,511,365);
contentPane=new JPanel();
contentPane.setBorder(new EmptyBorder(5,5,5,5));
setContentPane(contentPane);
contentPane.setLayout(null);
JLabel lblNewlabel=new JLabel("login page");
lblNewlabel.setHorizontalAlignment(SwingConstants.CENTER);
lblNewlabel.setBounds(45,34,344,14);
contentPane.add(lblNewlabel);
JLabel lblUsername=new JLabel("username");
lblUsername.setBounds(44,59,133,14);
contentPane.add(lblUsername);
user=new JTextField();
user.setBounds(45,78,344,20);
contentPane.add(user);
user.setColumns(10);
JLabel llPassword=new JLabel("password");
llPassword.setBounds(45,109,89,14);
contentPane.add(llPassword);
JButton btnLogin=new JButton("login");
btnLogin.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent args0){
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
Statement stmt=con.createStatement();
String sql="Select*from login where username='"+user.getText()+"’and password='"+pas.getText()+"’";
String sql1="select accountnumber from login where username="+user.getText()+"’ and password="+pas.getText()+"’";
pass=pas.getText();
str=user.getText();
ResultSet rs1=stmt.executeQuery(sql1);
int i;
while(rs1.next())
{
i=rs1.getInt(1);
srt=String.valueOf(i);
}
ResultSet rs=stmt.executeQuery(sql);
if(rs.next())
{JOptionPane.showMessageDialog(null,"login successful");
close();
Account at=new Account();
at.setVisible(true);
}
else
{JOptionPane.showMessageDialog(null,"incorrect nameor password");
}
con.close();
}catch(Exception e) {System.out.println(e);}
}
});
btnLogin.setBounds(45,178,89,23);
contentPane.add(btnLogin);
pas=new JPasswordField();
pas.setBounds(45,134,344,20);
contentPane.add(pas);
}
}