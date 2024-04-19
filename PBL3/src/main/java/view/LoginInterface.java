package view;

import javax.swing.*;

import dao.HibernateManagerSystemDao;
import dao.HibernateUserDao;
import dao.ManagerSystemDao;
import dao.UserDao;
import persistence.ManagerSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginInterface extends JFrame implements ActionListener {
	
	private static UserDao userDao;
	private static ManagerSystemDao managerSystemDao;
	static {
		userDao = new HibernateUserDao();
		managerSystemDao = new HibernateManagerSystemDao();
	}
	
	
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public LoginInterface() {
        setTitle("Đăng nhập");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel usernameLabel = new JLabel("Tên đăng nhập:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Mật khẩu:");
        passwordField = new JPasswordField();

        inputPanel.add(usernameLabel);
        inputPanel.add(usernameField);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        loginButton = new JButton("Đăng nhập");
        registerButton = new JButton("Đăng ký tài khoản");

        loginButton.addActionListener(this);
        registerButton.addActionListener(this);

        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        JLabel imageLabel = new JLabel(new ImageIcon("library.jpg"));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        panel.add(inputPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        panel.add(imageLabel, BorderLayout.NORTH);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Thực hiện kiểm tra đăng nhập ở đây, ví dụ:
            if (kTra(username, password)) {
                dispose();
                new LibraryHomePage();
            } else {
                JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu không đúng.");
            }
        } else if (e.getSource() == registerButton) {
        	dispose();
        	new RegisterInterface();
        }
    }

    public static void main(String[] args) {
        new LoginInterface();
    }
    
    public static boolean kTra(String username, String password) {
    	System.out.println(userDao.maxId());
    	if(managerSystemDao.get(username, password) == null) {
    		return false;
    	}else {
    		return true;
    	}
    	
    }
}
