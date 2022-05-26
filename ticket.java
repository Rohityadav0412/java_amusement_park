package project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.awt.*;

public class ticket extends JFrame implements ItemListener,ActionListener{

	String s1="",s11="",gsst,tottal,grandtottal,bk,name11,phone11,address11;
	Container c;
	JButton addd,save;
	JLabel ln,bookingid,bookingid1,date,customerdetails,ticketdetails,name,phone,address,chooseticketcategory,chooseticketname,ticketprice,noofticket,total,gst,grandtotal;
	JTextField date1,customerdetails1,ticketdetails1,name1,phone1,ticketprice1,noofticket1,total1,gst1,grandtotal1;
	JTextArea address1;
	JComboBox chooseticketcategory1,chooseticketname1;
	DefaultTableModel dm;
	JTable table;
	JScrollPane j1,scroll;
	JPanel p1,p2;
	static float price;
	float cost,tp,tt,ttp,ttpp;
	Connection con;
	Statement st,st1,st11;
	ResultSet rs,rss;
	int rowcount,bkid1;
	Object s[]=new Object[50];
	Object o[][]=new Object[15][5];
	int i=0;
	public ticket() {
		c=getContentPane();
		setResizable(false);
		setLayout(null);
		dm=new DefaultTableModel();
		table=new JTable(dm);
		j1=new JScrollPane(table);
		c.add(j1);
		j1.setBounds(50, 550, 975, 150);
		dm.addColumn("Ticket Category");
		dm.addColumn("Ticket Name");
		dm.addColumn("Price");
		dm.addColumn("No. Of Tickets");
		dm.addColumn("Total Cost");     
		
		ln=new JLabel("Booking Ticket");
		bookingid=new JLabel("Booking ID");
		bookingid1=new JLabel(""+bkid1);
		date=new JLabel("Date");
		customerdetails=new JLabel("Customer Details");
		ticketdetails=new JLabel("Ticket Details");
		name=new JLabel("Name");
		phone=new JLabel("Phone");
		address=new JLabel("Address");
		chooseticketcategory=new JLabel("Choose Ticket Category");
		chooseticketname=new JLabel("Choose Ticket Name");
		ticketprice=new JLabel("Ticket Price");
		noofticket=new JLabel("No. Of Tickets");
		total=new JLabel("Total");
		gst=new JLabel("GST");
		grandtotal=new JLabel("Grand Total");
		p1=new JPanel();
		p2=new JPanel();
		p1.setLayout(null);
		p2.setLayout(null);
		scroll=new JScrollPane(address1);
		date1=new JTextField(20);
		total1=new JTextField(20);
		gst1=new JTextField(20);
		grandtotal1=new JTextField(20);
		customerdetails1=new JTextField(20);
		name1=new JTextField(20);
		phone1=new JTextField(20);
		address1=new JTextArea(null,30,30);
		chooseticketcategory1=new JComboBox();
		chooseticketname1=new JComboBox();
		ticketprice1=new JTextField(20);
		noofticket1=new JTextField(20);
		
		
		addd=new JButton("Add");
		save=new JButton("Save");
		ln.setBounds(350, -10, 500, 100);
		ln.setFont(new Font("serif",Font.BOLD,50));
		ln.setForeground(Color.white);
		c.add(ln);
		
		bookingid.setBounds(50,100,200,50);
		bookingid.setFont(new Font("serif",Font.BOLD,20));
		c.add(bookingid);
		bookingid1.setBounds(180,100,200,50);
		bookingid1.setFont(new Font("serif",Font.BOLD,20));
		c.add(bookingid1);
		date.setBounds(800,100,150,50);
		date.setFont(new Font("serif",Font.BOLD,20));
		c.add(date);
		date1.setBounds(870,110,65,30);
		c.add(date1);
		customerdetails.setBounds(50, 150, 200, 50);
		customerdetails.setFont(new Font("serif",Font.BOLD,20));
		c.add(customerdetails);
		p1.setBounds(50, 190, 400, 300);
		p1.setBorder(BorderFactory.createLineBorder(Color.white));
		c.add(p1);
		name.setBounds(40, 10, 50, 50);
		name.setFont(new Font("serif",Font.BOLD,20));
		p1.add(name);
		name1.setBounds(150, 20, 200, 30);
		name1.setFont(new Font("serif",Font.BOLD,20));
		p1.add(name1);
		phone.setBounds(40, 60, 70, 50);
		phone.setFont(new Font("serif",Font.BOLD,20));
		p1.add(phone);
		phone1.setBounds(150, 70, 200, 30);
		phone1.setFont(new Font("serif",Font.BOLD,20));
		p1.add(phone1);
		address.setBounds(40, 110, 90, 50);
		address.setFont(new Font("serif",Font.BOLD,20));
		p1.add(address);
		address1.setBounds(150, 120, 200, 170);
		address1.setFont(new Font("serif",Font.BOLD,20));
		p1.add(address1);
		ticketdetails.setBounds(530, 150, 200, 50);
		ticketdetails.setFont(new Font("serif",Font.BOLD,20));
		c.add(ticketdetails);
		Calendar cal=Calendar.getInstance();
		String d1="",d2="";
		if(cal.get(Calendar.DATE)<=9)
		{
		 d1="0"+cal.get(Calendar.DATE);
		}
		if((Calendar.MONTH)+1<=9)
		{
			d2="0"+cal.get(Calendar.MONTH);
				
		}
		String curdate=""+d1+"-"+d2+"-"+cal.get(Calendar.YEAR);
		
		System.out.println(curdate);
		date1.setText(curdate);
		date1.setEditable(false);
		
		p2.setBounds(530, 190, 490, 300);
		p2.setBorder(BorderFactory.createLineBorder(Color.white));
		c.add(p2);
		chooseticketcategory.setBounds(20, 20, 215, 50);
		chooseticketcategory.setFont(new Font("serif",Font.BOLD,20));
		p2.add(chooseticketcategory);
		chooseticketcategory1.setBounds(270, 30, 180, 30);
		p2.add(chooseticketcategory1);
		chooseticketname.setBounds(20, 90, 215, 50);
		chooseticketname.setFont(new Font("serif",Font.BOLD,20));
		p2.add(chooseticketname);
		chooseticketname1.setBounds(270, 100, 180, 30);
		p2.add(chooseticketname1);
		ticketprice.setBounds(20, 160, 120, 50);
		ticketprice.setFont(new Font("serif",Font.BOLD,20));
		p2.add(ticketprice);
		ticketprice1.setBounds(270, 170, 180, 30);
		p2.add(ticketprice1);
		noofticket.setBounds(20, 230, 150, 50);
		noofticket.setFont(new Font("serif",Font.BOLD,20));
		p2.add(noofticket);
		noofticket1.setBounds(270, 240, 180, 30);
		p2.add(noofticket1);
		
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
		addd.setBounds(940, 500, 80, 30);
		addd.setFont(new Font("serif",Font.BOLD,20));
		c.add(addd);
		save.setBounds(940, 720, 80, 30);
		save.setFont(new Font("serif",Font.BOLD,20));
		c.add(save);

		
		addd.addActionListener(this);
		save.addActionListener(this);
		chooseticketcategory1.addItemListener(this);
		chooseticketname1.addItemListener(this);
		try {
       	 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String msAccDB = "C:\\Users\\DELL\\Documents\\Database3.accdb";
            String dbURL = "jdbc:ucanaccess://"+ msAccDB; 
            con= DriverManager.getConnection(dbURL); 
          
            System.out.println("connected");
            st1=con.createStatement();
            rs=st1.executeQuery("select * from ticketcategories");
            st11=con.createStatement();
            rss=st11.executeQuery("select * from bookingticket");
			while(rs.next())
			{
			chooseticketcategory1.addItem(rs.getString("categoryname"));
			chooseticketname1.addItem(rs.getString("ticketname"));
			
			}
			while(rss.next())
			{
				bkid1=rss.getInt("bookingid");
				
			}
			
			bookingid1.setText(""+(bkid1+1));
			bk=bookingid1.getText().toString();
			
			ticketprice1.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					// TODO Auto-generated method stub
					try
					{
					 st1=con.createStatement();
			         rs=st1.executeQuery("select * from ticketcategories");
			         
						while(rs.next())
						{
					      if(s1.equals(rs.getString("categoryname")) && s11.equals(rs.getString("ticketname")))
					      {
					    	   tp=Integer.parseInt(rs.getString("ticketprice"));
					    	  ticketprice1.setText(tp+"");
					      }
						}
					}
					catch (Exception ef) {
						// TODO: handle exception
						System.out.println(ef.getMessage());
					}
					
				}
			});
			
	   }
	   catch(Exception e)
	   {
		System.out.println(e.getMessage());   
	   }   
		
	}



	@Override
	public void itemStateChanged(ItemEvent e) {
		
		
		if(e.getSource()==chooseticketcategory1)
		{
		 s1=chooseticketcategory1.getSelectedItem().toString();
		
		}
		if(e.getSource()==chooseticketname1)
		{
		 s11=chooseticketname1.getSelectedItem().toString();
		}
		
		
			}
	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		Color ce=new Color(115,175,255);
        c.setBackground(ce);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==addd)
		{
			cost=tp*Integer.parseInt(noofticket1.getText());
			price=price+cost;
			ttp=(cost*((14.0f)/100.00f))+cost;
			ttpp=(price)*(14.0f/100.0f);
			String s1=chooseticketcategory1.getSelectedItem().toString();
			String s11=chooseticketname1.getSelectedItem().toString();
			String s111=ticketprice1.getText();
			String s1111=noofticket1.getText();
			
			Object ob[]= {s1,s11,s111,s1111,cost};
		 o[i][0]= s1;
		 o[i][1]=s11;
		 o[i][2]=s111;
		 o[i][3]=s1111;
		 o[i][4]=cost;
			dm.addRow(ob);
			i++;
			ticketprice1.setText("");
			noofticket1.setText("");
			total1.setText(""+price);
			gst1.setText(""+ttpp);
			tt=(Float.parseFloat(gst1.getText())+price);
			grandtotal1.setText(""+tt);
			gsst=gst1.getText();
			tottal=total1.getText();
			grandtottal=grandtotal1.getText();
			
		}
		if(e.getSource()==save)
		{
			name11=name1.getText();
			phone11=phone1.getText();
			address11=address1.getText();
			try
			{
			st=con.createStatement();
			st.executeUpdate("insert into bookingticket (adname,phone,address,date,cost,gst,totalcost) values('"+name1.getText()+"', '"+phone1.getText()+"', '"+address1.getText()+"', '"+date1.getText()+"', "+price+", '"+ttpp+"',"+tt+")");
			
		
			
			}
			catch (Exception e1) {
				// TODO: handle exception
			JOptionPane.showMessageDialog(null, "problem in inserting the values"+e1.getMessage());
		e1.printStackTrace();	
			}

			
			ticketprintlist w=new ticketprintlist(o,i,tottal,gsst,grandtottal,bk,name11,phone11,address11);
			w.setVisible(true);
			w.setBounds(200,10,1110,800);
			this.setVisible(false);
			this.dispose();
			
		}
	}

}
