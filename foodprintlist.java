package project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Vector;
import java.awt.*;

public class foodprintlist extends JFrame implements ItemListener,ActionListener{

	Container c;
	JButton printt;
	JLabel ln,bookingid,bookingid1,date,total,gst,grandtotal,address,address1,name,name11,phone,phone11,address111,address1111;
	JTextField date1,total1,gst1,grandtotal1;;
	DefaultTableModel dm;
	JTable table;
	JScrollPane j1;
	Connection con;
	Statement st,st1;
	ResultSet rs;
	int rowcount;
	Object s[]=new Object[50];
	public foodprintlist(Object o[][],int l,String tottal,String gsst,String grandtottal,String bk,String name1,String phone1,String address11) {
		c=getContentPane();
		setResizable(false);
		setLayout(null);
		dm=new DefaultTableModel();
		String arrr[]= {"Food Category","Food Name","Price","Quantity","Total Cost"};
		table=new JTable(o,arrr);
		j1=new JScrollPane(table);
		c.add(j1);
		j1.setBounds(50, 270, 975, 390);
     
		
		ln=new JLabel("Amusement Park");
		bookingid=new JLabel("Booking ID");
		bookingid1=new JLabel(bk);
		name=new JLabel("Customer Name");
		name11=new JLabel(name1);
		phone=new JLabel("Phone");
		phone11=new JLabel(phone1);
		address111=new JLabel("Address");
		address1111=new JLabel(address11);
		date=new JLabel("Date");
		total=new JLabel("Total");
		gst=new JLabel("GST");
		grandtotal=new JLabel("Grand Total");
		address=new JLabel("V.P.O Dabra Tosham Road Hisar, Haryana");
		address1=new JLabel("Phone: 9034307844");
		date1=new JTextField(20);
		total1=new JTextField(20);
		gst1=new JTextField("14",20);
		grandtotal1=new JTextField(20);
		printt=new JButton("Print");
		printt.setBounds(945, 720, 80, 30);
		printt.setFont(new Font("serif",Font.BOLD,20));
		c.add(printt);
		
		ln.setBounds(350, -10, 500, 100);
		ln.setFont(new Font("serif",Font.BOLD,50));
		ln.setForeground(Color.white);
		c.add(ln);
		address.setBounds(350,70,400,50);
		address.setFont(new Font("serif",Font.BOLD,20));
		c.add(address);
		address1.setBounds(460,100,400,50);
		address1.setFont(new Font("serif",Font.BOLD,20));
		c.add(address1);
		
		bookingid.setBounds(50,100,200,50);
		bookingid.setFont(new Font("serif",Font.BOLD,20));
		c.add(bookingid);
		bookingid1.setBounds(180,100,200,50);
		bookingid1.setFont(new Font("serif",Font.BOLD,20));
		c.add(bookingid1);
		name.setBounds(50,160,200,50);
		name.setFont(new Font("serif",Font.BOLD,20));
		c.add(name);
		name11.setBounds(200,160,200,50);
		name11.setFont(new Font("serif",Font.BOLD,20));
		c.add(name11);
		phone.setBounds(400,160,200,50);
		phone.setFont(new Font("serif",Font.BOLD,20));
		c.add(phone);
		phone11.setBounds(470,160,200,50);
		phone11.setFont(new Font("serif",Font.BOLD,20));
		c.add(phone11);
		address111.setBounds(50,205,200,50);
		address111.setFont(new Font("serif",Font.BOLD,20));
		c.add(address111);
		address1111.setBounds(130,205,900,50);
		address1111.setFont(new Font("serif",Font.BOLD,20));
		c.add(address1111);
		date.setBounds(800,100,150,50);
		date.setFont(new Font("serif",Font.BOLD,20));
		c.add(date);
		Calendar cal=Calendar.getInstance();
		String curdate=""+cal.get(Calendar.DATE)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.YEAR);
		date1.setText(curdate);
		date1.setEditable(false);
		
		date1.setBounds(870,115,70,25);
		c.add(date1);
		
		
		total1.setText(tottal);
		gst1.setText(gsst);
		grandtotal1.setText(grandtottal);
		total.setBounds(50, 720, 80, 30);
		total.setFont(new Font("serif",Font.BOLD,17));
		c.add(total);
		total1.setBounds(100,726,80,25);
		c.add(total1);
		gst.setBounds(250, 720, 80, 30);
		gst.setFont(new Font("serif",Font.BOLD,17));
		c.add(gst);
		gst1.setBounds(300,726,80,25);
		c.add(gst1);
		grandtotal.setBounds(450, 720, 100, 30);
		grandtotal.setFont(new Font("serif",Font.BOLD,17));
		c.add(grandtotal);
		grandtotal1.setBounds(560,726,80,25);
		c.add(grandtotal1);
		printt.addActionListener(this);
		try {
       	 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String msAccDB = "C:\\Users\\DELL\\Documents\\Database3.accdb";
            String dbURL = "jdbc:ucanaccess://"+ msAccDB; 
            con= DriverManager.getConnection(dbURL); 
          
            System.out.println("connected");
            st1=con.createStatement();
            rs=st1.executeQuery("select * from foodcategories");
            
			while(rs.next())
			{

			}
			
	   }
	   catch(Exception e)
	   {
		System.out.println(e.getMessage());   
	   }   
		
	}

	public static void main(String[] args) {

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		
	}
	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		Color ce=new Color(115,175,255);
        c.setBackground(ce);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==printt)
		{
			try
			{
				table.print();
			}
			catch (Exception ef) {
				// TODO: handle exception
				System.out.println(ef.getMessage());
			}
		}
		
	}

}