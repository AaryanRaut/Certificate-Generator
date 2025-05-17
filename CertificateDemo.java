	
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
	import java.sql.*;  
	import java.util.Date;
	import java.text.SimpleDateFormat;
	import javax.imageio.ImageIO;
	import java.awt.image.BufferedImage;
	import java.io.File;
	import java.awt.Graphics2D;


	class MyFrame extends JFrame
	{
		JLabel l1, l2, l3, l4, l5, l6, l7;
		JTextField t1, t2, t3, t4, t5;
		JButton b1, b2, b3, b4;

		public MyFrame()
		{
			super("Login Page");
			setSize(800,500);
			setLocation(550,200);
			setDefaultCloseOperation(MyFrame.EXIT_ON_CLOSE);
			setResizable(false);
			setLayout(null);

			l1 = new JLabel("Sign Up");
			l1.setFont(new Font("Times New Roman", Font.BOLD, 25));
			l1.setBounds(100,20,100,40);
			add(l1);

			l2 = new JLabel("Name :");
			l2.setFont(new Font("Times New Roman", Font.BOLD, 25));
			l2.setBounds(50,80,100,40);
			add(l2);

			t1 = new JTextField();
			t1.setFont(new Font("Times New Roman", Font.BOLD, 25));
			t1.setBounds(150,85,120,35);
			add(t1);

			l3 = new JLabel("Password :");
			l3.setFont(new Font("Times New Roman", Font.BOLD, 25));
			l3.setBounds(50,130,120,40);
			add(l3);

			t2 = new JTextField();
			t2.setFont(new Font("Times New Roman", Font.BOLD, 25));
			t2.setBounds(190,130,120,35);
			add(t2);

			b1 = new JButton("Submit");
			b1.setBounds(50,250,100,40);
			add(b1);

			b2 = new JButton("Reset");
			b2.setBounds(200,250,100,40);
			add(b2);

			l4 = new JLabel("Sign In");
			l4.setFont(new Font("Times New Roman", Font.BOLD, 25));
			l4.setBounds(550,20,100,40);
			add(l4);

			l5 = new JLabel("Name :");
			l5.setFont(new Font("Times New Roman", Font.BOLD, 25));
			l5.setBounds(450,80,100,40);
			add(l5);
			
			t3 = new JTextField();
			t3.setFont(new Font("Times New Roman", Font.BOLD, 25));
			t3.setBounds(550,85,120,35);
			add(t3);
			
			l6 = new JLabel("Password :");
			l6.setFont(new Font("Times New Roman", Font.BOLD, 25));
			l6.setBounds(450,130,120,40);
			add(l6);

			t4 = new JTextField();
			t4.setFont(new Font("Times New Roman", Font.BOLD, 25));
			t4.setBounds(580,130,120,35);
			add(t4);

			l7 = new JLabel("Full Name :");
			l7.setFont(new Font("Times New Roman", Font.BOLD, 25));
			l7.setBounds(50,180,140,40);
			add(l7);

			t5 = new JTextField();
			t5.setFont(new Font("Times New Roman", Font.BOLD, 25));
			t5.setBounds(180,180,200,35);
			add(t5);
	
			b3 = new JButton("Submit");
			b3.setBounds(450,200,100,40);
			add(b3);

			b4 = new JButton("Reset");
			b4.setBounds(600,200,100,40);
			add(b4);
				
			b1.addActionListener(new ActionListener(){
			
				public void actionPerformed(ActionEvent e)
				{
               				if(t1.getText().equals(""))
               				{
         				JOptionPane.showMessageDialog(MyFrame.this,"Please Enter Username","MESSAGE",JOptionPane.PLAIN_MESSAGE); 
                             		return;
               				}

               				if(t2.getText().equals(""))
               				{
         				JOptionPane.showMessageDialog(MyFrame.this,"Please Enter Password","MESSAGE",JOptionPane.PLAIN_MESSAGE); 
                             		return;
               				}	 

               				if(t5.getText().equals(""))
               				{
         				JOptionPane.showMessageDialog(MyFrame.this,"Please Enter Password","MESSAGE",JOptionPane.PLAIN_MESSAGE); 
                             		return;
               				}	 
				
					                Connection con = null;         
				        try
         				{  
                 				Class.forName("com.mysql.jdbc.Driver"); 
 
				                con=DriverManager.getConnection                                              	
	
						("jdbc:mysql://localhost:3308/sample","root","mysql");  

						Statement stmt=con.createStatement();  

					        String name = t1.getText();
         					String password = t2.getText();
						String fname = t5.getText();

  						int i = stmt.executeUpdate("insert into login values('"+name+"','"+password+"','"+fname+"')");  
         			JOptionPane.showMessageDialog(MyFrame.this,"Login Successfully!","MESSAGE",JOptionPane.PLAIN_MESSAGE);          

              					t1.setText("");
               					t2.setText("");
						t5.setText("");

						con.close();
					}

					catch(Exception ex)
					{
						System.out.print(ex);
					}
				}
			});

			b2.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					t1.setText("");
					t2.setText("");
					t5.setText("");
				}
			});

			b3.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
               				if(t3.getText().equals(""))
               				{
         				JOptionPane.showMessageDialog(MyFrame.this,"Please Enter Username","MESSAGE",JOptionPane.PLAIN_MESSAGE); 
                             		return;
               				}
               				if(t4.getText().equals(""))
               				{
         				JOptionPane.showMessageDialog(MyFrame.this,"Please Enter Password","MESSAGE",JOptionPane.PLAIN_MESSAGE); 
                             		return;
               				}	 

                			Connection con = null;
         
         				try
				        {  
                 				Class.forName("com.mysql.jdbc.Driver"); 
	 
        				        con=DriverManager.getConnection("jdbc:mysql://localhost:3308/sample","root","mysql");
                                          
						Statement stmt=con.createStatement();  

						ResultSet rs = stmt.executeQuery("select * from login where name = '"+t3.getText()+"' ");

						if(rs.next() && rs.getString(1).equals(t3.getText()) && rs.getString(2).equals(t4.getText()))
						{
						//	String lg = t3.getText();
		
				         JOptionPane.showMessageDialog(MyFrame.this,"LOGIN Successful!","MESSAGE",JOptionPane.PLAIN_MESSAGE); 
							String lg = t3.getText();
							t3.setText("");
							t4.setText("");         

							new MyFrame2(lg);
							MyFrame.this.setVisible(false);
						}	
						else
						{
         				 JOptionPane.showMessageDialog(MyFrame.this,"Check Entered Details!","Wrong Input",JOptionPane.ERROR_MESSAGE);          
						}

						con.close();	
					}
					catch(Exception ex)
					{
						System.out.print(ex);
					}
				}
			});
			
			b4.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					t3.setText("");
					t4.setText("");
				}
			});

			setVisible(true);			
		}
	}

	class MyFrame2 extends JFrame
	{
		JButton b1;
		JLabel l1;
		String username;

		public MyFrame2(String username)
		{		
			super("Dashboard");
			setSize(500,500);
			setLocation(650,200);
			setDefaultCloseOperation(MyFrame2.EXIT_ON_CLOSE);
			setResizable(false);
			setLayout(null);

			this.username = username;

			l1 = new JLabel("Welcome.....");
			l1.setFont(new Font("Times New Roman",Font.BOLD,24));
			l1.setBounds(10,20,150,50);
			add(l1);		

			b1 = new JButton("Generate Certificate");
			b1.setBounds(140,100,170,50);
			add(b1);

			b1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					new MyFrame3(MyFrame2.this.username);
					MyFrame2.this.setVisible(false);
				}
			});

			setVisible(true);			
		}
	}

	class MyFrame3 extends JFrame implements ActionListener
	{
		JMenuBar mb;
		JMenu m1;
		JMenuItem i1;
		JLabel l1,l2,l3,l4,l5;
		String username;

		public MyFrame3(String username)
		{
			super("Certificate");
			setSize(800,600);
			setLocation(550,200);
			setDefaultCloseOperation(MyFrame2.EXIT_ON_CLOSE);
			setResizable(false);
			setLayout(null);

			this.username = username;

			l1 = new JLabel("Certificate of Achievement", JLabel.CENTER);
			l1.setFont(new Font("Serif", Font.BOLD, 32));
			l1.setBounds(150, 50, 500, 50);
			add(l1);

			l2 = new JLabel("This certificate is awarded to:", JLabel.CENTER);
			l2.setFont(new Font("SansSerif", Font.PLAIN, 20));
			l2.setBounds(200, 170, 400, 30);
			add(l2);

			l3 = new JLabel(" ", JLabel.CENTER);
			l3.setFont(new Font("Serif", Font.BOLD, 28));
			l3.setBounds(200, 220, 400, 40);
			add(l3);

			l4 = new JLabel("For outstanding performance and dedication.", JLabel.CENTER);
			l4.setFont(new Font("SansSerif", Font.ITALIC, 18));
			l4.setBounds(150, 280, 500, 30);
			add(l4);

			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date date = new Date();
			String currentDate = formatter.format(date);

			l5 = new JLabel("Date: "+currentDate, JLabel.CENTER);
			l5.setFont(new Font("SansSerif", Font.PLAIN, 16));
			l5.setBounds(150, 350, 500, 30);
			add(l5);
			
			String n = l3.getText();

			try
			{
        			Class.forName("com.mysql.jdbc.Driver"); 
	 
        			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/sample","root","mysql");
                                          
				Statement stmt = con.createStatement();

				ResultSet rs = stmt.executeQuery("Select full_name from login where name = '"+username+"'");				

				if(rs.next())
				{
					String fn = rs.getString("full_name");

					l3.setText(fn);
				}  

				con.close();
			}
		
			catch(Exception ex)
			{
				System.out.print(ex);
			}


			mb = new JMenuBar();
			m1 = new JMenu("FILE");
			i1 = new JMenuItem("Download");

			m1.add(i1);

			mb.add(m1);
				
		        this.setJMenuBar(mb);  
  
 		        i1.addActionListener(this);
		
			setVisible(true);
		}

		public void saveFrame(JFrame frame, String fname)
		{
			try
			{
				BufferedImage image = new BufferedImage(
					frame.getWidth(),
					frame.getHeight(),
					BufferedImage.TYPE_INT_RGB
				);

				Graphics2D gd = image.createGraphics();
				frame.paint(gd);
				gd.dispose();

				File f = new File(fname);
				ImageIO.write(image, "png", f);
				JOptionPane.showMessageDialog(frame, "Saved as: " + fname);
			}
			catch(Exception ex)
			{
				System.out.print(ex);
			}
		}
		
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource().equals(i1))
			{
				saveFrame(this,"Certificate.png");
			}
		}
	}

	public class CertificateDemo
	{
		public static void main(String [] args)
		{
			new MyFrame();
		}	
	}