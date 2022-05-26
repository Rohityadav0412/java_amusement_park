package project;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class changepassword extends JFrame implements ActionListener{

	Container c;
	JLabel ln,l1,l2,l3;
	JPasswordField t1,t2,t3;
	JButton b1;
	String unamee;
	Connection con;
	Statement st;
	ResultSet rs;
	public changepassword(String username) {
		c=getContentPane();
		unamee=username;
		setResizable(false);
		setLayout(null);
		ln=new JLabel("Change Password");
		
		l1=new JLabel("Current Password");
		l2=new JLabel("New Password");
		l3=new JLabel("Confirm New Password");
		t1=new JPasswordField(20);
		t2=new JPasswordField(20);
		t3=new JPasswordField(20);
		b1=new JButton("Change Password");
		ln.setFont(new Font("serif",Font.BOLD,50));
		c.add(ln);
		ln.setBounds(340, 20, 500, 100);
		ln.setForeground(Color.white);
		
		l1.setBounds(200, 200, 200, 50);
		l1.setFont(new Font("serif",Font.BOLD,20));
		c.add(l1);
		t1.setBounds(480, 210, 200, 30);
		c.add(t1);
		
		l2.setBounds(200, 270, 200, 50);
		l2.setFont(new Font("serif",Font.BOLD,20));
		c.add(l2);
		t2.setBounds(480, 280, 200, 30);
		c.add(t2);
		l3.setBounds(200, 340, 250, 50);
		l3.setFont(new Font("serif",Font.BOLD,20));
		c.add(l3);
		t3.setBounds(480, 350, 200, 30);
		c.add(t3);
		
		b1.setBounds(500, 430, 153, 30);
		b1.setFont(new Font("serif",Font.BOLD,16));
		c.add(b1);
		b1.addActionListener(this);
		
	}

	public static void main(String[] args) {
	/*	changepassword w=new changepassword(String username);
		w.setVisible(true);
		w.setBounds(200,10,1110,800);*/

	}
	public void paint(Graphics g) {
		
		super.paint(g);
		Color ce=new Color(115,175,255);
        c.setBackground(ce);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==b1)
		{
			
			if(t1.getText().equals(unamee))
			{
				if(t2.getText().equals(t3.getText()))
				{
					try
					{
				     Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				     String msAccDB = "C:\\Users\\DELL\\Documents\\Database3.accdb";
				     String dbURL = "jdbc:ucanaccess://"+ msAccDB; 
				    con= DriverManager.getConnection(dbURL); 
				    System.out.println("connected");
					st=con.createStatement();
					rs=st.executeQuery("select * from admin");
					st.executeUpdate("update admin set password='"+t2.getText()+"' where password='"+t1.getText()+"'");

					JOptionPane.showMessageDialog(null, "Password Updated");
					
					}
					catch (Exception e1) {
						// TODO: handle exception
					JOptionPane.showMessageDialog(null, "problem in updating the values"+e1.getMessage());
					
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "New Password didnot matched");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Current Password didnot Matched");
			}
		}
	}

}
