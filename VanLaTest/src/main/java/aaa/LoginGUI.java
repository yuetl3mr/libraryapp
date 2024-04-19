package aaa;

import javax.swing.*;

import dao.HibernateUserDaoaaa;
import dao.UserDaoaaa;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class LoginGUI extends JFrame implements ActionListener {
	
	private static UserDaoaaa userDaoaaa;
	static {
		userDaoaaa = new HibernateUserDaoaaa();
	}
	public static Integer id;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginGUI() {
        setTitle("Đăng nhập");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        JLabel usernameLabel = new JLabel("Tài khoản:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Mật khẩu:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Đăng nhập");
        loginButton.addActionListener(this);

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Kiểm tra thông tin đăng nhập ở đây
        if (ktra(username, password)) {
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
            this.dispose(); // Đóng cửa sổ đăng nhập
            new UserInformation(id); // Mở giao diện thông tin người dùng
        } else {
            JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu không đúng!");
        }
    }
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI();
            }
        });
    }
    
    public static boolean ktra(String username, String password) {
    	List<user> users = userDaoaaa.users();
    	for(user user : users) {
    		System.out.println(user);
    		if(username.equals(user.getTaikhoan()) && password.equals(user.getMatkhau())) {
    			id = user.getId();
    			return true;
    		}
    	}
    	return false;
    }
}

