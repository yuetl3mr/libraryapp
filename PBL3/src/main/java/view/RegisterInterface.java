package view;

import javax.swing.*;

import dao.HibernateManagerSystemDao;
import dao.HibernateUserDao;
import dao.ManagerSystemDao;
import dao.UserDao;
import persistence.ManagerSystem;
import persistence.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class RegisterInterface extends JFrame implements ActionListener{
	
	private static UserDao userDao;
	private static ManagerSystemDao managerSystemDao;
	static {
		userDao = new HibernateUserDao();
		managerSystemDao = new HibernateManagerSystemDao();
	}
	
    private JTextField nameField;
    private JTextField phoneField;
    private JTextField emailField;
    private JTextField addressField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JButton backButton;

    public RegisterInterface() {
        setTitle("Đăng ký tài khoản");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Đóng cửa sổ này khi mở cửa sổ mới
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel nameLabel = new JLabel("Họ và tên:");
        nameField = new JTextField();
        nameField.addActionListener(this);
        
        JLabel phoneLabel = new JLabel("Số điện thoại:");
        phoneField = new JTextField();
        phoneField.addActionListener(this);
        
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        emailField.addActionListener(this);
        
        JLabel addressLabel = new JLabel("địa chỉ:");
        addressField = new JTextField();
        phoneField.addActionListener(this);
        
        JLabel usernameLabel = new JLabel("Tên đăng nhập:");
        usernameField = new JTextField();
        usernameField.addActionListener(this);
        
        JLabel passwordLabel = new JLabel("Mật khẩu:");
        passwordField = new JPasswordField();
        passwordField.addActionListener(this);

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(phoneLabel);
        inputPanel.add(phoneField);
        inputPanel.add(emailLabel);
        inputPanel.add(emailField);
        inputPanel.add(addressLabel);
        inputPanel.add(addressField);
        inputPanel.add(usernameLabel);
        inputPanel.add(usernameField);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        registerButton = new JButton("Đăng ký");
        registerButton.addActionListener(this);
        backButton = new JButton("quay lại");
        backButton.addActionListener(this);
        
        buttonPanel.add(backButton);
        buttonPanel.add(registerButton);

        panel.add(inputPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == backButton) {
    		dispose();
    		new LoginInterface();
    	}
    	if(e.getSource() == registerButton) {
    		User user = new User(2, nameField.getText(), addressField.getText(), phoneField.getText());
    		ManagerSystem managerSystem = new ManagerSystem(2, usernameField.getText(), passwordField.getText());
    		userDao.save(user);
    		managerSystemDao.save(managerSystem);
    	}
    }
}
