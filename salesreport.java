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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Vector;
import java.awt.*;

public class salesreport extends JFrame implements ItemListener,ActionListener{

	Container c;
	JButton printt,show;
	JLabel ln,total,gst,grandtotal,startdate,enddate,forwhat;
	JTextField total1,gst1,grandtotal1;
	JComboBox forwhat1,startdate1,enddate1;
	DefaultTableModel dm;
	JTable table;
	String tic,foo,strd,end;
	JScrollPane j1;
	Connection con;
	Statement st,st1;
	ResultSet rs;
	int rowcount;
	Object s[]=new Object[50];
	public salesreport() {
		c=getContentPane();
		setResizable(false);
		setLayout(null);
		dm=new DefaultTableModel();
		table=new JTable(dm);
		j1=new JScrollPane(table);
		c.add(j1);
		j1.setBounds(50, 200, 975, 500);
		dm.addColumn("Booking ID");
		dm.addColumn("Name");
		dm.addColumn("Phone");
		dm.addColumn("Address");
		dm.addColumn("Bill Amount");  
		dm.addColumn("GST");
		dm.addColumn("Bill Total"); 
		
		ln=new JLabel("Sales Report");
		startdate=new JLabel("Start Date");
		enddate=new JLabel("End Date");
		forwhat=new JLabel("For What");
		total=new JLabel(" Bill Total");
		gst=new JLabel("GST Total");
		grandtotal=new JLabel("Grand Total");
		
		startdate1=new JComboBox();
		enddate1=new JComboBox();
		total1=new JTextField(20);
		gst1=new JTextField("14",20);
		grandtotal1=new JTextField(20);
		forwhat1=new JComboBox();
		printt=new JButton("Print");
		show=new JButton("Show");
		printt.setBounds(945, 720, 80, 30);
		printt.setFont(new Font("serif",Font.BOLD,20));
		c.add(printt);
		
		ln.setBounds(400, -10, 500, 100);
		ln.setFont(new Font("serif",Font.BOLD,50));
		ln.setForeground(Color.white);
		c.add(ln);
		
		
		startdate.setBounds(50,100,100,50);
		startdate.setFont(new Font("serif",Font.BOLD,20));
		c.add(startdate);
		startdate1.setBounds(150,110,170,30);
		c.add(startdate1);
		enddate.setBounds(370,100,100,50);
		enddate.setFont(new Font("serif",Font.BOLD,20));
		c.add(enddate);
		enddate1.setBounds(470,110,170,30);
		c.add(enddate1);
		
		forwhat.setBounds(690,100,100,50);
		forwhat.setFont(new Font("serif",Font.BOLD,20));
		c.add(forwhat);
		forwhat1.setBounds(790,110,150,30);
		forwhat1.addItem("Choose Category");
		forwhat1.addItem("Ticket");
		forwhat1.addItem("Food");
		c.add(forwhat1);
		show.setBounds(947,110,80,30);
		show.setFont(new Font("serif",Font.BOLD,20));
		c.add(show);
		show.addActionListener(this);
		enddate1.addItemListener(this);
		startdate1.addItemListener(this);
		total.setBounds(50, 720, 80, 30);
		total.setFont(new Font("serif",Font.BOLD,17));
		c.add(total);
		total1.setBounds(130,726,80,25);
		c.add(total1);
		gst.setBounds(280, 720, 80, 30);
		gst.setFont(new Font("serif",Font.BOLD,17));
		c.add(gst);
		gst1.setBounds(365,726,80,25);
		c.add(gst1);
		grandtotal.setBounds(510, 720, 100, 30);
		grandtotal.setFont(new Font("serif",Font.BOLD,17));
		c.add(grandtotal);
		grandtotal1.setBounds(620,726,80,25);
		c.add(grandtotal1);
		printt.addActionListener(this);
		try {
       	 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String msAccDB = "C:\\Users\\DELL\\Documents\\Database3.accdb";
            String dbURL = "jdbc:ucanaccess://"+ msAccDB; 
            con= DriverManager.getConnection(dbURL); 
          
            System.out.println("connected");
            st1=con.createStatement();
            rs=st1.executeQuery("select * from bookingticket");
            
			while(rs.next())
			{
			 startdate1.addItem(rs.getString("date"));
			 enddate1.addItem(rs.getString("date"));
		//	 dm.addRow(o);
			}
			
	   }
	   catch(Exception e)
	   {
		System.out.println(e.getMessage());   
	   }   
//		startdate1.setSelectedIndex(0);
	//	enddate1.setSelectedIndex(0);
		//forwhat1.setSelectedIndex(1);
		
	}



	@Override
	public void itemStateChanged(ItemEvent e) {
		repaint();
			}
	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		Color ce=new Color(115,175,255);
        c.setBackground(ce);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tic=forwhat1.getSelectedItem().toString();
		strd=startdate1.getSelectedItem().toString();
		end=enddate1.getSelectedItem().toString();
float cost1=0,gst2=0,tcost1=0;
		if(e.getSource()==show)
		{
			int rowcount=dm.getRowCount();
			   for(int i=0;i<rowcount;i++) {
				dm.removeRow(0);}
			if(tic.equals("Ticket"))
			{
				
				
			try 
			{
				DateTimeFormatter f = DateTimeFormatter.ofPattern( "dd-MM-yyyy" );
				DateTimeFormatter f1 = DateTimeFormatter.ofPattern( "dd-MM-yyyy" );
				
				LocalDate d1 = LocalDate.parse( strd, f );
				LocalDate d2 = LocalDate.parse( end, f1 );

			st1=con.createStatement();
            rs=st1.executeQuery("select * from bookingticket");
            
			while(rs.next())
			{
				String datee=rs.getString("date");
				LocalDate d3 = LocalDate.parse( datee, f );
				if((d3.isAfter(d1)||d3.isEqual(d1)) && (d3.isBefore(d2)||d3.isEqual(d2)))
				{
					
				//
			String s1=rs.getString("bookingid");
			String s11=rs.getString("adname");
			String s111=rs.getString("phone");
			String s1111=rs.getString("address");
			
			String s111111=rs.getString("cost").trim();
			cost1=cost1+Float.parseFloat(s111111);
			
			String s1111111=rs.getString("gst").trim();
			gst2=gst2+Float.parseFloat(s1111111);
			String s11111111=rs.getString("totalcost").trim();
			tcost1=tcost1+Float.parseFloat(s11111111);
			Object o[]= {s1,s11,s111,s1111,s111111,s1111111,s11111111};
			dm.addRow(o);
				}
			}
			total1.setText(""+cost1);	
			gst1.setText(""+gst2);
			grandtotal1.setText(""+tcost1);
				
	   }
	   catch(Exception ef)
	   {
		System.out.println(ef.getMessage());   
	   }
			}
			if(tic.equals("Food"))
			{
				try 
				{
					DateTimeFormatter f = DateTimeFormatter.ofPattern( "dd-MM-yyyy" );
					DateTimeFormatter f1 = DateTimeFormatter.ofPattern( "dd-MM-yyyy" );
					
					LocalDate d1 = LocalDate.parse( strd, f );
					LocalDate d2 = LocalDate.parse( end, f1 );

				st1=con.createStatement();
	            rs=st1.executeQuery("select * from bookingfood");
	            
				while(rs.next())
				{
					String datee=rs.getString("date");
					LocalDate d3 = LocalDate.parse( datee, f );
					if((d3.isAfter(d1)||d3.isEqual(d1)) && (d3.isBefore(d2)||d3.isEqual(d2)))
					{
						
					//
				String s1=rs.getString("bookingid");
				String s11=rs.getString("adname");
				String s111=rs.getString("phone");
				String s1111=rs.getString("address");
				
				String s111111=rs.getString("cost").trim();
				cost1=cost1+Float.parseFloat(s111111);
				
				String s1111111=rs.getString("gst").trim();
				gst2=gst2+Float.parseFloat(s1111111);
				String s11111111=rs.getString("totalcost").trim();
				tcost1=tcost1+Float.parseFloat(s11111111);
				Object o[]= {s1,s11,s111,s1111,s111111,s1111111,s11111111};
				dm.addRow(o);
					}
				}
				total1.setText(""+cost1);	
				gst1.setText(""+gst2);
				grandtotal1.setText(""+tcost1);
					
		   }
		   catch(Exception ef)
		   {
			System.out.println(ef.getMessage());   
		   }
			
			}	
		}
	
		
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
