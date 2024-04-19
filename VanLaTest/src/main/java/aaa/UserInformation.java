package aaa;

import javax.swing.*;

import dao.HibernateUserDaoaaa;
import dao.UserDaoaaa;

import java.awt.*;
import java.awt.event.*;

public class UserInformation extends JFrame implements ActionListener {
    private JLabel gmailLabel, phoneLabel, addressLabel;
    private static UserDaoaaa userDaoaaa;
	static {
		userDaoaaa = new HibernateUserDaoaaa();
	}
    
    public UserInformation(Integer integer) {
        setTitle("Thông tin người dùng");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.WEST;

        gmailLabel = new JLabel("Gmail: " + userDaoaaa.getEmail(integer));
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(gmailLabel, constraints);

        phoneLabel = new JLabel("Tên người dùng: " + userDaoaaa.getTenNguoiDung(integer));
        constraints.gridy = 1;
        panel.add(phoneLabel, constraints);

        addressLabel = new JLabel("Địa chỉ: " + userDaoaaa.getDiaChi(integer));
        constraints.gridy = 2;
        panel.add(addressLabel, constraints);

        JButton scheduleButton = new JButton("Đặt lịch hẹn");
        scheduleButton.addActionListener(this);
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(scheduleButton, constraints);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Đặt lịch hẹn")) {
            this.dispose(); // Đóng cửa sổ hiện tại
            new AppointmentScheduler(); // Mở giao diện lịch hẹn
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UserInformation(LoginGUI.id);
            }
        });
    }
    
    
}

