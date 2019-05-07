package Bank;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class Withdraw extends JFrame{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JPanel contentpane;
private JTextField withdraw;
static String srt1,srt;
/**
*launch the application
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() { 
public void run() {
try {
Withdraw frame=new Withdraw ();
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
public void close(){
WindowEvent wine = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wine);


}
public Withdraw(){
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setBounds(100,100,450,300);
contentpane=new JPanel();
contentpane.setBorder(new EmptyBorder(5,5,5,5));
setContentPane(contentpane);
contentpane.setLayout(null);
JLabel lblwithdraw =new JLabel("withdraw");
lblwithdraw.setBounds(200,11,105,14);
contentpane.add(lblwithdraw);
withdraw =new JTextField();
withdraw.setBounds(71,59,313,20);
contentpane.add(withdraw);
withdraw.setColumns(10);
JButton btnpressok= new JButton("press ok");
btnpressok.addActionListener(new ActionListener() {
public void actionperformed(ActionEvent arg0){
try{Login lg=new Login();
Class.forName("com.mysql.jbdc.driver");
Connection con=DriverManager.getConnection("jbdc:mysql://localhost:3306/test","root","");
Statement stmt1=con.createStatement();
String sql1="select balance from login where username='"+lg.str+"'and password='"+lg.pass+"'";
srt=withdraw.getText();
int j=Integer.parseInt(srt.trim()),k=0;
ResultSet rs1=stmt1.executeQuery(sql1);
int i;
while(rs1.next())
{
i=rs1.getInt(1);
k=i;
}
k=k-j;
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
catch(Exception e){System.out.println(e);
}}
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}
});
btnpressok.setBounds(174,98,89,23);
contentpane.add(btnpressok);
}
}
