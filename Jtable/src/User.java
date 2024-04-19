<<<<<<< HEAD
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class User extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public User() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnShowUser = new JButton("Show User Table");
		btnShowUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryupdate","root","Kiet1234");
					Statement st=con.createStatement();
					String query= "select * from USER";
					ResultSet rs= st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tblUser.getModel();
					
					int cols= rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String userid,name,address,phonenumber;
					while(rs.next()) {
						userid=rs.getString(1);
						name=rs.getString(2);
						address=rs.getString(3);
						phonenumber=rs.getString(4);
						String[] row= {userid,name,address,phonenumber};
						model.addRow(row);
					}
					st.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnShowUser.setBounds(10, 30, 125, 59);
		contentPane.add(btnShowUser);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tblUser.setModel(new DefaultTableModel());
			}
		});
		btnClear.setBounds(526, 393, 125, 59);
		contentPane.add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(310, 30, 485, 352);
		contentPane.add(scrollPane);
		
		tblUser = new JTable();
		scrollPane.setViewportView(tblUser);
		
		JButton btnShowReader = new JButton("Show Reader Table");
		btnShowReader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryupdate","root","Kiet1234");
					Statement st=con.createStatement();
					String query= "select * from READER";
					ResultSet rs= st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tblUser.getModel();
					
					int cols= rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String userid, sub;
					while(rs.next()) {
						userid=rs.getString(1);
						sub=rs.getString(2);
						String[] row= {userid, sub};
						model.addRow(row);
					}
					st.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnShowReader.setBounds(158, 30, 125, 59);
		contentPane.add(btnShowReader);
		
		JButton btnStaff = new JButton("Show Staff Table");
		btnStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryupdate","root","Kiet1234");
					Statement st=con.createStatement();
					String query= "select * from STAFF";
					ResultSet rs= st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tblUser.getModel();
					
					int cols= rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String userid,dept,salary;
					while(rs.next()) {
						userid=rs.getString(1);
						dept=rs.getString(2);
						salary=rs.getString(3);
						String[] row= {userid,dept,salary};
						model.addRow(row);
					}
					st.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnStaff.setBounds(10, 110, 125, 59);
		contentPane.add(btnStaff);
		
		JButton btnShowBook = new JButton("Show Book Table");
		btnShowBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryupdate","root","Kiet1234");
					Statement st=con.createStatement();
					String query= "select * from BOOK";
					ResultSet rs= st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tblUser.getModel();
					
					int cols= rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String bookid,categoryid,name,author,publication,status;
					while(rs.next()) {
						bookid=rs.getString(1);
						categoryid=rs.getString(2);
						name=rs.getString(3);
						author=rs.getString(4);
						publication=rs.getString(5);
						status=rs.getString(6);
						String[] row= {bookid,categoryid,name,author,publication,status};
						model.addRow(row);
					}
					st.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnShowBook.setBounds(158, 110, 125, 59);
		contentPane.add(btnShowBook);
		
		JButton btnShowCategory = new JButton("Show Category Table");
		btnShowCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryupdate","root","Kiet1234");
					Statement st=con.createStatement();
					String query= "select * from CATEGORY";
					ResultSet rs= st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tblUser.getModel();
					
					int cols= rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String categoryid,name;
					while(rs.next()) {
						categoryid=rs.getString(1);
						name=rs.getString(2);
						String[] row= {categoryid,name};
						model.addRow(row);
					}
					st.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnShowCategory.setBounds(10, 190, 125, 59);
		contentPane.add(btnShowCategory);
		
		JButton btnReview = new JButton("Show Review Table");
		btnReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryupdate","root","Kiet1234");
					Statement st=con.createStatement();
					String query= "select * from REVIEW";
					ResultSet rs= st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tblUser.getModel();
					
					int cols= rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String reviewid,bookid,userid,star,reviewtime,content;
					while(rs.next()) {
						reviewid=rs.getString(1);
						bookid=rs.getString(2);
						userid=rs.getString(3);
						star=rs.getString(4);
						reviewtime=rs.getString(5);
						content=rs.getString(6);
						String[] row= {reviewid,bookid,userid,star,reviewtime,content};
						model.addRow(row);
					}
					st.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnReview.setBounds(158, 190, 125, 59);
		contentPane.add(btnReview);
		
		JButton btnShowLoan = new JButton("Show Loan Table");
		btnShowLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryupdate","root","Kiet1234");
					Statement st=con.createStatement();
					String query= "select * from LOAN";
					ResultSet rs= st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tblUser.getModel();
					
					int cols= rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String loanid,userid,bookid,note;
					while(rs.next()) {
						loanid=rs.getString(1);
						userid=rs.getString(2);
						bookid=rs.getString(3);
						note=rs.getString(4);
						String[] row= {loanid,userid,bookid,note};
						model.addRow(row);
					}
					st.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnShowLoan.setBounds(10, 270, 125, 59);
		contentPane.add(btnShowLoan);
		
		JButton btnShowBorrow = new JButton("Show Borrow Table");
		btnShowBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryupdate","root","Kiet1234");
					Statement st=con.createStatement();
					String query= "select * from BORROW";
					ResultSet rs= st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tblUser.getModel();
					
					int cols= rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String loanid,releasetime,duetime;
					while(rs.next()) {
						loanid=rs.getString(1);
						releasetime=rs.getString(2);
						duetime=rs.getString(3);
						String[] row= {loanid,releasetime,duetime};
						model.addRow(row);
					}
					st.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnShowBorrow.setBounds(158, 270, 125, 59);
		contentPane.add(btnShowBorrow);
		
		JButton btnShowReturn = new JButton("Show Return Table");
		btnShowReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryupdate","root","Kiet1234");
					Statement st=con.createStatement();
					String query= "select * from `RETURN`";
					ResultSet rs= st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tblUser.getModel();
					
					int cols= rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String loanid,returntime;
					while(rs.next()) {
						loanid=rs.getString(1);
						returntime=rs.getString(2);
						String[] row= {loanid,returntime};
						model.addRow(row);
					}
					st.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnShowReturn.setBounds(10, 350, 125, 59);
		contentPane.add(btnShowReturn);
		
		JButton btnShowIssue = new JButton("Show Issue Table");
		btnShowIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryupdate","root","Kiet1234");
					Statement st=con.createStatement();
					String query= "select * from ISSUE";
					ResultSet rs= st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tblUser.getModel();
					
					int cols= rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String issueid,bookid,issuestatus,note;
					while(rs.next()) {
						issueid=rs.getString(1);
						bookid=rs.getString(2);
						issuestatus=rs.getString(3);
						note=rs.getString(4);
						String[] row= {issueid,bookid,issuestatus,note};
						model.addRow(row);
					}
					st.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnShowIssue.setBounds(158, 350, 125, 59);
		contentPane.add(btnShowIssue);
		
		JButton btnShowManagerSystem = new JButton("Show Account Table");
		btnShowManagerSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryupdate","root","Kiet1234");
					Statement st=con.createStatement();
					String query= "select * from MANAGERSYSTEM";
					ResultSet rs= st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tblUser.getModel();
					
					int cols= rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String userid,username,password;
					while(rs.next()) {
						userid=rs.getString(1);
						username=rs.getString(2);
						password=rs.getString(3);
						String[] row= {userid,username,password};
						model.addRow(row);
					}
					st.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnShowManagerSystem.setBounds(81, 420, 125, 59);
		contentPane.add(btnShowManagerSystem);
	}
}
=======
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class User extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public User() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnShowUser = new JButton("Show User Table");
		btnShowUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryupdate","root","Kiet1234");
					Statement st=con.createStatement();
					String query= "select * from USER";
					ResultSet rs= st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tblUser.getModel();
					
					int cols= rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String userid,name,address,phonenumber;
					while(rs.next()) {
						userid=rs.getString(1);
						name=rs.getString(2);
						address=rs.getString(3);
						phonenumber=rs.getString(4);
						String[] row= {userid,name,address,phonenumber};
						model.addRow(row);
					}
					st.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnShowUser.setBounds(10, 30, 125, 59);
		contentPane.add(btnShowUser);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tblUser.setModel(new DefaultTableModel());
			}
		});
		btnClear.setBounds(526, 393, 125, 59);
		contentPane.add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(310, 30, 485, 352);
		contentPane.add(scrollPane);
		
		tblUser = new JTable();
		scrollPane.setViewportView(tblUser);
		
		JButton btnShowReader = new JButton("Show Reader Table");
		btnShowReader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryupdate","root","Kiet1234");
					Statement st=con.createStatement();
					String query= "select * from READER";
					ResultSet rs= st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tblUser.getModel();
					
					int cols= rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String userid, sub;
					while(rs.next()) {
						userid=rs.getString(1);
						sub=rs.getString(2);
						String[] row= {userid, sub};
						model.addRow(row);
					}
					st.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnShowReader.setBounds(158, 30, 125, 59);
		contentPane.add(btnShowReader);
		
		JButton btnStaff = new JButton("Show Staff Table");
		btnStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryupdate","root","Kiet1234");
					Statement st=con.createStatement();
					String query= "select * from STAFF";
					ResultSet rs= st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tblUser.getModel();
					
					int cols= rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String userid,dept,salary;
					while(rs.next()) {
						userid=rs.getString(1);
						dept=rs.getString(2);
						salary=rs.getString(3);
						String[] row= {userid,dept,salary};
						model.addRow(row);
					}
					st.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnStaff.setBounds(10, 110, 125, 59);
		contentPane.add(btnStaff);
		
		JButton btnShowBook = new JButton("Show Book Table");
		btnShowBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryupdate","root","Kiet1234");
					Statement st=con.createStatement();
					String query= "select * from BOOK";
					ResultSet rs= st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tblUser.getModel();
					
					int cols= rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String bookid,categoryid,name,author,publication,status;
					while(rs.next()) {
						bookid=rs.getString(1);
						categoryid=rs.getString(2);
						name=rs.getString(3);
						author=rs.getString(4);
						publication=rs.getString(5);
						status=rs.getString(6);
						String[] row= {bookid,categoryid,name,author,publication,status};
						model.addRow(row);
					}
					st.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnShowBook.setBounds(158, 110, 125, 59);
		contentPane.add(btnShowBook);
		
		JButton btnShowCategory = new JButton("Show Category Table");
		btnShowCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryupdate","root","Kiet1234");
					Statement st=con.createStatement();
					String query= "select * from CATEGORY";
					ResultSet rs= st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tblUser.getModel();
					
					int cols= rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String categoryid,name;
					while(rs.next()) {
						categoryid=rs.getString(1);
						name=rs.getString(2);
						String[] row= {categoryid,name};
						model.addRow(row);
					}
					st.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnShowCategory.setBounds(10, 190, 125, 59);
		contentPane.add(btnShowCategory);
		
		JButton btnReview = new JButton("Show Review Table");
		btnReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryupdate","root","Kiet1234");
					Statement st=con.createStatement();
					String query= "select * from REVIEW";
					ResultSet rs= st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tblUser.getModel();
					
					int cols= rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String reviewid,bookid,userid,star,reviewtime,content;
					while(rs.next()) {
						reviewid=rs.getString(1);
						bookid=rs.getString(2);
						userid=rs.getString(3);
						star=rs.getString(4);
						reviewtime=rs.getString(5);
						content=rs.getString(6);
						String[] row= {reviewid,bookid,userid,star,reviewtime,content};
						model.addRow(row);
					}
					st.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnReview.setBounds(158, 190, 125, 59);
		contentPane.add(btnReview);
		
		JButton btnShowLoan = new JButton("Show Loan Table");
		btnShowLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryupdate","root","Kiet1234");
					Statement st=con.createStatement();
					String query= "select * from LOAN";
					ResultSet rs= st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tblUser.getModel();
					
					int cols= rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String loanid,userid,bookid,note;
					while(rs.next()) {
						loanid=rs.getString(1);
						userid=rs.getString(2);
						bookid=rs.getString(3);
						note=rs.getString(4);
						String[] row= {loanid,userid,bookid,note};
						model.addRow(row);
					}
					st.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnShowLoan.setBounds(10, 270, 125, 59);
		contentPane.add(btnShowLoan);
		
		JButton btnShowBorrow = new JButton("Show Borrow Table");
		btnShowBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryupdate","root","Kiet1234");
					Statement st=con.createStatement();
					String query= "select * from BORROW";
					ResultSet rs= st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tblUser.getModel();
					
					int cols= rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String loanid,releasetime,duetime;
					while(rs.next()) {
						loanid=rs.getString(1);
						releasetime=rs.getString(2);
						duetime=rs.getString(3);
						String[] row= {loanid,releasetime,duetime};
						model.addRow(row);
					}
					st.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnShowBorrow.setBounds(158, 270, 125, 59);
		contentPane.add(btnShowBorrow);
		
		JButton btnShowReturn = new JButton("Show Return Table");
		btnShowReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryupdate","root","Kiet1234");
					Statement st=con.createStatement();
					String query= "select * from `RETURN`";
					ResultSet rs= st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tblUser.getModel();
					
					int cols= rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String loanid,returntime;
					while(rs.next()) {
						loanid=rs.getString(1);
						returntime=rs.getString(2);
						String[] row= {loanid,returntime};
						model.addRow(row);
					}
					st.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnShowReturn.setBounds(10, 350, 125, 59);
		contentPane.add(btnShowReturn);
		
		JButton btnShowIssue = new JButton("Show Issue Table");
		btnShowIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryupdate","root","Kiet1234");
					Statement st=con.createStatement();
					String query= "select * from ISSUE";
					ResultSet rs= st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tblUser.getModel();
					
					int cols= rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String issueid,bookid,issuestatus,note;
					while(rs.next()) {
						issueid=rs.getString(1);
						bookid=rs.getString(2);
						issuestatus=rs.getString(3);
						note=rs.getString(4);
						String[] row= {issueid,bookid,issuestatus,note};
						model.addRow(row);
					}
					st.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnShowIssue.setBounds(158, 350, 125, 59);
		contentPane.add(btnShowIssue);
		
		JButton btnShowManagerSystem = new JButton("Show Account Table");
		btnShowManagerSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryupdate","root","Kiet1234");
					Statement st=con.createStatement();
					String query= "select * from MANAGERSYSTEM";
					ResultSet rs= st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tblUser.getModel();
					
					int cols= rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String userid,username,password;
					while(rs.next()) {
						userid=rs.getString(1);
						username=rs.getString(2);
						password=rs.getString(3);
						String[] row= {userid,username,password};
						model.addRow(row);
					}
					st.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnShowManagerSystem.setBounds(81, 420, 125, 59);
		contentPane.add(btnShowManagerSystem);
	}
}
>>>>>>> 0d335c8 (quyle 19.04.2024)
