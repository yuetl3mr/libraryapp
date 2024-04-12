package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.HibernateManagerSystemDao;
import dao.HibernateUserDao;
import dao.ManagerSystemDao;
import dao.UserDao;
import persistence.ManagerSystem;
import persistence.User;
import utils.SqlUtils;

public class HibernateTest {
	private static UserDao userDao;
	private static ManagerSystemDao managerSystemDao;
	
	boolean m = false;
	
	JTextField jTextFieldPassword;
	JTextField jTextFieldUser;

	static {
		userDao = new HibernateUserDao();
		managerSystemDao = new HibernateManagerSystemDao();
	}

	public static void main(String[] args) {
		new HibernateTest();
	}
	
	List<User> users = userDao.getAll();
	List<ManagerSystem> managerSystems = managerSystemDao.getAll();
	
	public HibernateTest() {
		SqlUtils.generate("chill", userDao.getAll());
		SqlUtils.generate("chill", managerSystemDao.getAll());
		
		JFrame jFrame = new JFrame();
		jFrame.setSize(500, 500);
		jFrame.setDefaultCloseOperation(3);
		jFrame.setLocationRelativeTo(null);
		
		jFrame.setLayout(new GridLayout(3, 1));
		
		ActionListener actionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == "dang nhap") {
					String userName = jTextFieldUser.getText();
					String password = jTextFieldPassword.getText();
					for(ManagerSystem managerSystem : managerSystems) {
						System.out.println(managerSystem.getUsername() + " ---- " + userName);
						System.out.println(managerSystem.getPassword() + " ---- " + password);
						if(managerSystem.getUsername().equals(userName) && managerSystem.getPassword().equals(password)) {
							System.out.println(managerSystem.getUser().getName());
							m = true;
							break;
						}
					}
					if(m == false) {
						System.out.println("yeu cau nhap lai");
						userName = "";
						password = "";
					}
					
				}
				
			}
		};
		
		JPanel jPanelUser = new JPanel(new GridLayout(1,2));
		JLabel jLabelUser = new JLabel("username : ");
		jTextFieldUser = new JTextField();
		jPanelUser.add(jLabelUser);
		jPanelUser.add(jTextFieldUser);
		jFrame.add(jPanelUser);
		
		JPanel jPanelPassword = new JPanel(new GridLayout(1,2));
		jTextFieldPassword = new JTextField();
		JLabel jLabelPassword = new JLabel("password : ");
		jPanelPassword.add(jLabelPassword);
		jPanelPassword.add(jTextFieldPassword);
		jFrame.add(jPanelPassword);
		
		JPanel jPanelButton = new JPanel(new GridLayout(1,2));
		JButton jButton = new JButton("dang nhap");
		jButton.addActionListener(actionListener);
		jPanelButton.add(jButton);
		jFrame.add(jPanelButton);
		jFrame.setVisible(true);
	}
}
