package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class welcome extends JFrame implements ActionListener{

	JLabel l1;
	Container c;
	JButton b1,b2;
	public welcome() {
		c=getContentPane();
		setResizable(false);
		setLayout(null);
		b1=new JButton("Sign Up");
		b2=new JButton("Login");
		l1=new JLabel(new ImageIcon("C:\\Users\\DELL\\Desktop\\web dev\\20BIT0337\\project3.jpg"));
		l1.setBounds(0, -150, 1100, 1100);
		c.add(l1);
		l1.setLayout(null);
		b1.setBounds(390, 800, 103, 30);
		b1.setFont(new Font("serif",Font.BOLD,20));
		l1.add(b1);
		b1.addActionListener(this);
		b2.setBounds(510, 800, 100, 30);
		b2.setFont(new Font("serif",Font.BOLD,20));
		l1.add(b2);
		b2.addActionListener(this);


	}

	public static void main(String[] args) {
		welcome w=new welcome();
		w.setVisible(true);
		
		w.setBounds(200,10,1110,800);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{
			createadmin c1=	new createadmin();
			c1.setVisible(true);
			c1.setBounds(200,10,1110,800);
				}
		if(e.getSource()==b2)
		{
			this.setVisible(false);
			this.dispose();
			login w=new login();
			w.setVisible(true);
			w.setBounds(200,10,1110,800);
		}
		
	}

}
