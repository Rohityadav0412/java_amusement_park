package project;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class login extends JFrame implements ActionListener{

	Container c;
	JLabel ln,logo,l1,l2;
	JTextField t1;
	JPasswordField t2;
	JButton b1;
	ResultSet rs;
	Statement st;
	Connection con;
	int f=0;
	public login() {
		 try {
        	 
	            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	            String msAccDB = "C:\\Users\\DELL\\Documents\\Database3.accdb";
	            String dbURL = "jdbc:ucanaccess://"+ msAccDB; 
	            con= DriverManager.getConnection(dbURL); 
	            
		 
		 }
		 catch(Exception cnfex) {
			 
	            System.out.println("Problem in loading or "
	                    + "registering MS Access JDBC driver");
	            cnfex.printStackTrace();
	        }
		 
		c=getContentPane();
		setResizable(false);
		setLayout(null);
		ln=new JLabel("Management");
		logo=new JLabel(new ImageIcon("C:\\Users\\DELL\\Pictures\\login.jpg"));
		l1=new JLabel("Username");
		l2=new JLabel("Password");
		t1=new JTextField(20);
		t2=new JPasswordField(20);
		b1=new JButton("Login");
		ln.setFont(new Font("serif",Font.BOLD,70));
		c.add(ln);
		ln.setBounds(340, 80, 500, 100);
		ln.setForeground(Color.white);
		logo.setBounds(490, 220, 100, 110);
		c.add(logo);
		logo.setBorder(BorderFactory.createLineBorder(Color.white));
		l1.setBounds(350, 395, 200, 50);
		l1.setFont(new Font("serif",Font.BOLD,20));
		c.add(l1);
		t1.setBounds(480, 410, 200, 30);
		c.add(t1);
		
		l2.setBounds(350, 450, 200, 50);
		l2.setFont(new Font("serif",Font.BOLD,20));
		c.add(l2);
		t2.setBounds(480, 460, 200, 30);
		c.add(t2);
		b1.setBounds(530, 530, 100, 30);
		b1.setFont(new Font("serif",Font.BOLD,18));
		c.add(b1);
		b1.addActionListener(this);
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
		{try
		{
			String s=t1.getText();
			String s1=t2.getText().toString();
				  st=con.createStatement();
				rs=st.executeQuery("select username,password from admin");
				while(rs.next())
				{
	String s2=rs.getString("username");
	String s3=rs.getString("password");
				if(s.equals(s2) && s3.equals(s1))
				{
					this.setVisible(false);
					this.dispose();
					main w=new main(s1);
					w.setVisible(true);
					w.setBounds(-10,0,1920,1080);
					f=1;
					break;
				}
				}
				if(f==0) 
					JOptionPane.showMessageDialog(null, "Invalid Username or Password");
				
		}
		catch (Exception e1) {
			// TODO: handle exception
			
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
					}
	}

}
