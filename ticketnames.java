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
import java.awt.*;

public class ticketnames extends JFrame implements ItemListener,ActionListener{

	Container c;
	JButton addd,update,delete;
	JLabel ln,l1,ticketname,ticketprice;
	JTextField t2,t3;
	JComboBox c1;
	DefaultTableModel dm;
	JTable table;
	JScrollPane j1;
	Connection con;
	Statement st,st1;
	ResultSet rs,rss;
	int rowcount;
	Object s[]=new Object[50];
	public ticketnames() {
		c=getContentPane();
		setResizable(false);
		setLayout(null);
		dm=new DefaultTableModel();
		table=new JTable(dm);
		j1=new JScrollPane(table);
		
		c.add(j1);
		
		j1.setBounds(550, 160, 500, 430);
		
		dm.addColumn("Ticket ID");
		dm.addColumn("Category Name");
		dm.addColumn("Ticket Name");
		dm.addColumn("Ticket Price");
		ln=new JLabel("Ticket Names/Prices");
		l1=new JLabel("Choose Ticket Category");
		ticketname=new JLabel("Ticket Name");
		ticketprice=new JLabel("Ticket Price");
		t2=new JTextField(20);
		t3=new JTextField(20);
		c1=new JComboBox();
		
		addd=new JButton("Add");
		update=new JButton("Update");
		delete=new JButton("Delete");
		ln.setBounds(330, -5, 500, 100);
		ln.setFont(new Font("serif",Font.BOLD,50));
		ln.setForeground(Color.white);
		c.add(ln);
		
		l1.setBounds(50, 150, 205, 50);
		l1.setFont(new Font("serif",Font.BOLD,20));
		c.add(l1);
		c1.setBounds(280, 160, 200, 30);
		c.add(c1);
		
		
		ticketname.setBounds(50, 250, 200, 50);
		ticketname.setFont(new Font("serif",Font.BOLD,20));
		c.add(ticketname);
		t2.setBounds(280, 260, 200, 30);
		c.add(t2);
		ticketprice.setBounds(50, 350, 205, 50);
		ticketprice.setFont(new Font("serif",Font.BOLD,20));
		c.add(ticketprice);
		t3.setBounds(280, 360, 200, 30);
		c.add(t3);
		addd.setBounds(165, 500, 80, 30);
		addd.setFont(new Font("serif",Font.BOLD,20));
		c.add(addd);
		update.setBounds(270, 500, 100, 30);
		update.setFont(new Font("serif",Font.BOLD,20));
		c.add(update);
		delete.setBounds(395, 500, 90, 30);
		delete.setFont(new Font("serif",Font.BOLD,20));
		c.add(delete);

		addd.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
		try {
       	 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String msAccDB = "C:\\Users\\DELL\\Documents\\Database3.accdb";
            String dbURL = "jdbc:ucanaccess://"+ msAccDB; 
            con= DriverManager.getConnection(dbURL); 
            System.out.println("connected");
            st1=con.createStatement();
            st=con.createStatement();
            rs=st1.executeQuery("select * from ticketcategories");
            rss=st.executeQuery("select * from ticketcategoriess");
			while(rs.next())
			{
		
			int  a=rs.getInt("categoryid");
			 String s1=rs.getString("ticketname");
			 String s11=rs.getString("ticketprice");
			 String s111=rs.getString("categoryname");
			 Object o[]= {a,s111,s1,s11};
			
			 
			}
			while(rss.next())
			{
				c1.addItem(rss.getString("categorynamee"));
			}
	   }
	   catch(Exception e)
	   {
		System.out.println(e.getMessage());   
	   }
		
	}



	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
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
		int rowcount=dm.getRowCount();
		   for(int i=0;i<rowcount;i++) {
			dm.removeRow(0);}
		if(e.getSource()==addd)
		{
			   
				try
				{
				st=con.createStatement();
				st.executeUpdate("insert into ticketcategories (categoryname,ticketname,ticketprice) values('"+c1.getSelectedItem()+"', '"+t2.getText()+"', '"+t3.getText()+"')");
				
			
				JOptionPane.showMessageDialog(null, "inserted");
				}
				catch (Exception e1) {
					// TODO: handle exception
				JOptionPane.showMessageDialog(null, "problem in inserting the values"+e1.getMessage());
			e1.printStackTrace();	
				}
				showdata();
					}
		if(e.getSource()==delete)
		{
			String id=JOptionPane.showInputDialog("Enter Category Id");
			try
			{
			st=con.createStatement();
			st.executeUpdate("delete from ticketcategories where categoryid='"+id+"'");
			JOptionPane.showMessageDialog(null, "Deleted");
			}
			catch (Exception e1) {
				// TODO: handle exception
			JOptionPane.showMessageDialog(null, "problem in deleting the values"+e1.getMessage());
			
			}
			showdata();
		}
		if(e.getSource()==update)
		{
			
			String id=JOptionPane.showInputDialog("Enter Category Id");
			//String catname=JOptionPane.showInputDialog("Enter category name");
			
			try
			{
			st=con.createStatement();
			st.executeUpdate("update ticketcategories set categoryname='"+c1.getSelectedItem()+"', ticketname='"+t2.getText()+"', ticketprice='"+t3.getText()+"' where categoryid="+id);

			JOptionPane.showMessageDialog(null, "Updated");
			Thread.sleep(1000);
			}
			catch (Exception e1) {
				// TODO: handle exception
			JOptionPane.showMessageDialog(null, "problem in updating the values"+e1.getMessage());
			
			}
		
			showdata();
			
		}
	}
public void showdata()
{
		try
		{
			st1=con.createStatement();
            rs=st1.executeQuery("select * from ticketcategories");
            
			while(rs.next())
			{
		
			int  a=rs.getInt("categoryid");
			 String s1=rs.getString("ticketname");
			 String s11=rs.getString("ticketprice");
			 String s111=rs.getString("categoryname");
			 Object o[]= {a,s111,s1,s11};
			
			 dm.addRow(o);
			}
	   }
	   catch(Exception e1)
	   {
		System.out.println(e1.getMessage());   
	   }

		
	}

}
