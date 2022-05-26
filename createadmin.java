package project;
import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.*;

public class createadmin extends JFrame implements ItemListener,ActionListener,FocusListener{

	Container c;
	String str,str1;
	Boolean b=false;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,ln;
	JTextField t1,t2,t3,t4,t5,t8;
	JPasswordField p6;
	JTextArea a1;
	JRadioButton r1,r2;
	ButtonGroup bg1;
	JComboBox jc1;
	JButton b1,b2;
	JFileChooser f1=new JFileChooser();
	Connection con;
	Statement st;
	public createadmin() {
		c=getContentPane();
		setResizable(false);
		setLayout(null);
		ln=new JLabel("Create Admin");
		l1=new JLabel("Name");
		l2=new JLabel("Phone");
		l3=new JLabel("Address");
		l4=new JLabel("Gender");
		l5=new JLabel("Username");
		l6=new JLabel("Password");
		l7=new JLabel("User Type");
		l8=new JLabel("D.O.B");
		l9=new JLabel();
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);
		t4=new JTextField(20);
		t5=new JTextField(20);
		p6=new JPasswordField(20);
		t8=new JTextField(20);
		r1=new JRadioButton("Male");
		r2=new JRadioButton("Female");
		bg1=new ButtonGroup();
		jc1=new JComboBox();
		b1=new JButton("Add");
		b2=new JButton("Choose Image");
		a1=new JTextArea(null,50,50);
		r1.setOpaque(false);
	    r2.setOpaque(false);
		ln.setFont(new Font("serif",Font.BOLD,50));
		c.add(ln);
		ln.setBounds(400, -5, 500, 100);
		
		ln.setForeground(Color.white);
		l1.setBounds(50, 100, 200, 50);
		l1.setFont(new Font("serif",Font.BOLD,20));
		c.add(l1);
		t1.setBounds(180, 110, 200, 30);
		c.add(t1);
		l2.setBounds(50, 150, 200, 50);
		l2.setFont(new Font("serif",Font.BOLD,20));
		c.add(l2);
		t2.setBounds(180, 160, 200, 30);
		c.add(t2);
		l3.setBounds(50, 210, 200, 50);
		l3.setFont(new Font("serif",Font.BOLD,20));
		c.add(l3);
		a1.setBounds(180, 220, 200, 200);
		c.add(a1);
		l4.setBounds(50, 440, 200, 50);
		l4.setFont(new Font("serif",Font.BOLD,20));
		c.add(l4);
		bg1.add(r1);
		c.add(r1);
		r1.setBounds(180, 450, 80, 30);
		r1.setFont(new Font("serif",Font.BOLD,20));
		bg1.add(r2);
		c.add(r2);
		r2.setBounds(260, 450, 120, 30);
		r2.setFont(new Font("serif",Font.BOLD,20));
		
		l5.setBounds(50, 495, 200, 50);
		l5.setFont(new Font("serif",Font.BOLD,20));
		c.add(l5);
		t5.setBounds(180, 510, 200, 30);
		c.add(t5);
		
		l6.setBounds(50, 545, 200, 50);
		l6.setFont(new Font("serif",Font.BOLD,20));
		c.add(l6);
		p6.setBounds(180, 560, 200, 30);
		c.add(p6);
	    l7.setBounds(50, 600, 200, 50);
		l7.setFont(new Font("serif",Font.BOLD,20));
		c.add(l7);
		jc1.setBounds(180, 610, 200, 30);
		jc1.addItem("Admin");
		jc1.addItem("Employee");
		c.add(jc1);
		
		
		l8.setBounds(50, 650, 200, 50);
		l8.setFont(new Font("serif",Font.BOLD,20));
		c.add(l8);
		t8.setBounds(180, 660, 200, 30);
		c.add(t8);
		b1.setBounds(220, 710, 100, 30);
		b1.setFont(new Font("serif",Font.BOLD,20));
		c.add(b1);
	    b1.addActionListener(this);
		l9.setBounds(600, 110, 150, 180);
		l9.setBorder(BorderFactory.createLineBorder(Color.white));
		c.add(l9);
		b2.setBounds(600, 320, 150, 30);
		b2.setFont(new Font("serif",Font.BOLD,18));
		c.add(b2);
		b2.addActionListener(this);
		r1.addItemListener(this);
		r2.addItemListener(this);
		t2.addFocusListener(this);
		
		   try {
	        	 
	            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	            String msAccDB = "C:\\Users\\DELL\\Documents\\Database3.accdb";
	            String dbURL = "jdbc:ucanaccess://"+ msAccDB; 
	            con= DriverManager.getConnection(dbURL); 
	            System.out.println("connected");
		   }
		   catch(Exception e)
		   {
			System.out.println(e.getMessage());   
		   }
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(r1.isSelected())
		{
			str="male";
			b=true;
		}
		if(r2.isSelected())
		{
        str="female";
        b=true;
		}
		 str1=jc1.getSelectedItem().toString();
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Color ce=new Color(115,175,255);
        c.setBackground(ce);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b2)
		{
		
			 int i=f1. showOpenDialog(null);
			 if(i==f1.APPROVE_OPTION)
			 {
				 String s=f1.getSelectedFile().getAbsolutePath().toString();
				 l9.setIcon(new ImageIcon(s));
				 
			 }
		}
		if(e.getSource()==b1)
		{
			
			
			if((t1.getText().equals("") || b==false || t2.getText().equals("") || a1.getText().equals("") || t5.getText().equals("") || p6.getText().equals("") || t8.getText().equals("") || a1.getText().equals("")))
			{
				JOptionPane.showMessageDialog(null,"Please Insert text in all fields");
			}
			else
			{
				try
				{
				st=con.createStatement();
				st.executeUpdate("insert into admin (adname,phone,Address,gender,username,password,usertype,dob) values('"+t1.getText()+"','"+t2.getText()+"','"+a1.getText()+"','"+str+"','"+t5.getText()+"','"+p6.getText()+"','"+str1+"','"+t8.getText()+"')");
				JOptionPane.showMessageDialog(null, "Admin Added Successfully");
				
				this.setVisible(false);
				this.dispose();
		
				}
				catch (Exception e1) {
					// TODO: handle exception
				JOptionPane.showMessageDialog(null, "problem in inserting the values"+e1.getMessage());
			e1.printStackTrace();	
				}
					}
		}
		
	}


	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
	
	}


	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==t2)
		{
			try
			{
				int i=Integer.parseInt(t2.getText());
			}
			catch(Exception f)
			{
				JOptionPane.showMessageDialog(null, "Wrong Input");
				t2.setText("");
				t2.requestFocus();
			}
		}
	}

}
