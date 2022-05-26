package project;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class main extends JFrame implements ActionListener{

	Container c;
	JLabel l1;
	JMenuBar m1;
	String uname;
	JMenu useraccount,manageticket,managefood,booking,view;
	JMenuItem manageuser,changepassword,logout,ticketcategories,ticketname,foodcategory,foodname,ticket,food,salereport;
	public main(String username) {
		c=getContentPane();
		uname=username;
		setResizable(false);
		setLayout(null);
		ImageIcon logoutt=new ImageIcon("C:\\Users\\DELL\\Pictures\\logout.jpg");
		ImageIcon changepasswordd=new ImageIcon("C:\\Users\\DELL\\Pictures\\changepasswordd.jpg");
		ImageIcon manageuserr=new ImageIcon("C:\\Users\\DELL\\Pictures\\manageuser.jpg");
		ImageIcon tickett=new ImageIcon("C:\\Users\\DELL\\Pictures\\ticket.jpg");
		ImageIcon foodd=new ImageIcon("C:\\Users\\DELL\\Pictures\\food.jpg");
		m1=new JMenuBar();
		setJMenuBar(m1);
		useraccount=new JMenu("User Account");
		manageticket=new JMenu("Manage Ticket");
		managefood=new JMenu("Manage Food");
		booking=new JMenu("Booking/Billing");
		view=new JMenu("View");
		manageuser=new JMenuItem("Manage User",manageuserr);
		changepassword=new JMenuItem("Change Password",changepasswordd);
		logout=new JMenuItem("Log Out",logoutt);
		ticketcategories=new JMenuItem("Ticket Categories");
		ticketname=new JMenuItem("Ticket Name/Prices");
		foodcategory=new JMenuItem("Food Category");
		foodname=new JMenuItem("Food Name/Price");
		ticket=new JMenuItem("Ticket",tickett);
		food=new JMenuItem("Food",foodd);
		salereport=new JMenuItem("Sale Report");
		m1.add(useraccount);
		m1.add(manageticket);
		m1.add(managefood);
		m1.add(booking);
		m1.add(view);
		useraccount.add(manageuser);
		useraccount.add(changepassword);
		useraccount.add(logout);
		manageticket.add(ticketcategories);
		manageticket.add(ticketname);
		managefood.add(foodcategory);
		managefood.add(foodname);
		booking.add(ticket);
		booking.add(food);
		view.add(salereport);
		l1=new JLabel(new ImageIcon("C:\\Users\\DELL\\Pictures\\project3.jpg"));
		l1.setBounds(-200, -218, 1929, 1080);
		c.add(l1);
		manageuser.addActionListener(this);
		changepassword.addActionListener(this);
		logout.addActionListener(this);
		ticketcategories.addActionListener(this);
		ticketname.addActionListener(this);
		foodcategory.addActionListener(this);
		foodname.addActionListener(this);
		ticket.addActionListener(this);
		food.addActionListener(this);
		salereport.addActionListener(this);
		
	}

	public static void main(String[] args) {
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==manageuser)
		{
			manageuser w=new manageuser();
			w.setVisible(true);
			w.setBounds(200,10,1110,800);
			
		}
		if(e.getSource()==changepassword)
		{
			changepassword w=new changepassword(uname);
			w.setVisible(true);
			w.setBounds(200,10,1110,800);
			
		}
		if(e.getSource()==ticketcategories)
		{
			ticketcategories w=new ticketcategories();
			w.setVisible(true);
			w.setBounds(200,10,1110,800);
			
		}
		if(e.getSource()==ticketname)
		{
			ticketnames w=new ticketnames();
			w.setVisible(true);
			w.setBounds(200,10,1110,800);
			
		}
		if(e.getSource()==foodcategory)
		{
			foodcategories w=new foodcategories();
			w.setVisible(true);
			w.setBounds(200,10,1110,800);
			
		}
		if(e.getSource()==foodname)
		{
			foodnames w=new foodnames();
			w.setVisible(true);
			w.setBounds(200,10,1110,800);
			
		}
		if(e.getSource()==logout)
		{
			this.setVisible(false);
			this.dispose();
			
		}
		if(e.getSource()==ticket)
		{
			ticket w=new ticket();
			w.setVisible(true);
			w.setBounds(200,10,1110,800);
			
		}
		if(e.getSource()==food)
		{
			food w=new food();
			w.setVisible(true);
			w.setBounds(200,10,1110,800);
			
		}
		if(e.getSource()==salereport)
		{
			salesreport w=new salesreport();
			w.setVisible(true);
			w.setBounds(200,10,1110,800);
			
		}   
		
	}

}
