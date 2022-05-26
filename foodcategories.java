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

public class foodcategories extends JFrame implements ItemListener,ActionListener{

	Container c;
	JButton addd,update,delete;
	JLabel ln,l1;
	JTextField t1;
	DefaultTableModel dm;
	JTable table;
	JScrollPane j1;
	Connection con;
	Statement st,st1;
	ResultSet rs;
	int rowcount;
	public foodcategories() {
		c=getContentPane();
		setResizable(false);
		setLayout(null);
		dm=new DefaultTableModel();
		table=new JTable(dm);
		j1=new JScrollPane(table);
		
		c.add(j1);
		
		j1.setBounds(550, 160, 500, 430);
		dm.addColumn("Category ID");
		dm.addColumn("Category Name");
		ln=new JLabel("Food Categories");
		l1=new JLabel("Category Name");
		t1=new JTextField(20);
		
		addd=new JButton("Add");
		update=new JButton("Update");
		delete=new JButton("Delete");
		ln.setBounds(350, -5, 500, 100);
		ln.setFont(new Font("serif",Font.BOLD,50));
		ln.setForeground(Color.white);
		c.add(ln);
		
		l1.setBounds(50, 150, 200, 50);
		l1.setFont(new Font("serif",Font.BOLD,20));
		c.add(l1);
		
		t1.setBounds(220, 160, 200, 30);
		c.add(t1);
	
		addd.setBounds(100, 260, 80, 30);
		addd.setFont(new Font("serif",Font.BOLD,20));
		c.add(addd);
		update.setBounds(207, 260, 100, 30);
		update.setFont(new Font("serif",Font.BOLD,20));
		c.add(update);
		delete.setBounds(330, 260, 90, 30);
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
            rs=st1.executeQuery("select * from foodcategoriess");
            
			while(rs.next())
			{
		
			int  a=rs.getInt("Categoryid");
			 String s1=rs.getString("Categorynamee");
			 Object o[]= {a,s1};
			
			 dm.addRow(o);
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
				st.executeUpdate("insert into foodcategoriess (categorynamee) values('"+t1.getText()+"')");
			
				JOptionPane.showMessageDialog(null, "inserted");
				}
				catch (Exception e1) {
					// TODO: handle exception
				JOptionPane.showMessageDialog(null, "problem in inserting the values"+e1.getMessage());
			e1.printStackTrace();	
				}
					}
		if(e.getSource()==delete)
		{
			String id=JOptionPane.showInputDialog("Enter Category Id");
			try
			{
			st=con.createStatement();
			st.executeUpdate("delete from foodcategoriess where categoryid='"+id+"'");
			JOptionPane.showMessageDialog(null, "Deleted");
			}
			catch (Exception e1) {
				// TODO: handle exception
			JOptionPane.showMessageDialog(null, "problem in deleting the values"+e1.getMessage());
			
			}
		}
		if(e.getSource()==update)
		{
			String id=JOptionPane.showInputDialog("Enter Category Id");
			try
			{
			st=con.createStatement();
			st.executeUpdate("update foodcategoriess set categorynamee='"+t1.getText()+"' where categoryid="+id);
			JOptionPane.showMessageDialog(null, "Updated");
			}
			catch (Exception e1) {
				// TODO: handle exception
			JOptionPane.showMessageDialog(null, "problem in updating the values"+e1.getMessage());
			
			}
			
		}
		t1.setText("");
		try
		{
		st1=con.createStatement();
      rs=st1.executeQuery("select * from foodcategoriess");
		
		while(rs.next())
		{
	
		int  a=rs.getInt("Categoryid");
		 String s1=rs.getString("Categorynamee");
		 Object o[]= {a,s1};

		 dm.addRow(o);
		}
		

		}
		catch (Exception e1) {
			// TODO: handle exception
		JOptionPane.showMessageDialog(null, "problem in inserting the values"+e1.getMessage());
	e1.printStackTrace();	
		}

	}

}
