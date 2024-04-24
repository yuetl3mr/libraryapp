package view;

import javax.swing.*;
import java.awt.*;

public class UserInfoGUI extends JFrame {
    private JLabel nameLabel, phoneLabel, emailLabel, addressLabel;
    private JTextField nameField, phoneField, emailField, addressField;
    private JButton editPhoneButton, editEmailButton, editAddressButton;

    public UserInfoGUI() {
        setTitle("Thông tin người dùng");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Hiển thị cửa sổ ở giữa màn hình
        setLayout(new BorderLayout());

        // Panel chứa thông tin người dùng
        JPanel userInfoPanel = new JPanel();
        userInfoPanel.setLayout(new GridLayout(4, 2));

        nameLabel = new JLabel("Tên:");
        userInfoPanel.add(nameLabel);
        nameField = new JTextField();
        nameField.setEditable(false); // Tên không thể sửa đổi
        userInfoPanel.add(nameField);

        phoneLabel = new JLabel("Số điện thoại:");
        userInfoPanel.add(phoneLabel);
        phoneField = new JTextField();
        phoneField.setEditable(false); // Số điện thoại không thể sửa đổi
        userInfoPanel.add(phoneField);

        emailLabel = new JLabel("Email:");
        userInfoPanel.add(emailLabel);
        emailField = new JTextField();
        emailField.setEditable(false); // Email không thể sửa đổi
        userInfoPanel.add(emailField);

        addressLabel = new JLabel("Địa chỉ:");
        userInfoPanel.add(addressLabel);
        addressField = new JTextField();
        addressField.setEditable(false); // Địa chỉ không thể sửa đổi
        userInfoPanel.add(addressField);

        // Panel chứa nút chỉnh sửa
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        editPhoneButton = new JButton("Sửa số điện thoại");
        editPhoneButton.addActionListener(e -> {
            String newPhone = JOptionPane.showInputDialog(this, "Nhập số điện thoại mới:");
            if (newPhone != null) {
                phoneField.setText(newPhone);
            }
        });
        buttonPanel.add(editPhoneButton);

        editEmailButton = new JButton("Sửa email");
        editEmailButton.addActionListener(e -> {
            String newEmail = JOptionPane.showInputDialog(this, "Nhập email mới:");
            if (newEmail != null) {
                emailField.setText(newEmail);
            }
        });
        buttonPanel.add(editEmailButton);

        editAddressButton = new JButton("Sửa địa chỉ");
        editAddressButton.addActionListener(e -> {
            String newAddress = JOptionPane.showInputDialog(this, "Nhập địa chỉ mới:");
            if (newAddress != null) {
                addressField.setText(newAddress);
            }
        });
        buttonPanel.add(editAddressButton);

        // Thêm panel vào frame
        add(userInfoPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UserInfoGUI::new);
    }
}
