package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LibraryHomePage extends JFrame {
    public LibraryHomePage() {
        super("Hệ Thống Quản Lý Thư Viện");

        // Tạo các nút chức năng với biểu tượng
        JButton muonSachButton = new JButton("Mượn Sách", new ImageIcon("borrow.png"));
        JButton traSachButton = new JButton("Trả Sách", new ImageIcon("return.png"));
        JButton timKiemButton = new JButton("Tìm Kiếm Sách", new ImageIcon("search.png"));
        JButton xemTatCaButton = new JButton("Xem Tất Cả Sách", new ImageIcon("view.png"));
        JButton thongTinButton = new JButton("Xem Thông Tin Cá Nhân", new ImageIcon("profile.png"));
        JButton moRongButton = new JButton("Tính Năng Mở Rộng Thư Viện", new ImageIcon("expand.png"));

        // Thiết lập kích thước cho các nút
        Dimension buttonSize = new Dimension(200, 50);
        muonSachButton.setPreferredSize(buttonSize);
        traSachButton.setPreferredSize(buttonSize);
        timKiemButton.setPreferredSize(buttonSize);
        xemTatCaButton.setPreferredSize(buttonSize);
        thongTinButton.setPreferredSize(buttonSize);
        moRongButton.setPreferredSize(buttonSize);

        // Tạo một panel để chứa các nút chức năng
        JPanel buttonPanel = new JPanel(new GridLayout(6, 1, 10, 10)); // Sử dụng GridLayout để chia cách đều các nút
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Tạo khoảng trống xung quanh panel
        buttonPanel.add(muonSachButton);
        buttonPanel.add(traSachButton);
        buttonPanel.add(timKiemButton);
        buttonPanel.add(xemTatCaButton);
        buttonPanel.add(thongTinButton);
        buttonPanel.add(moRongButton);

        // Đặt màu nền cho panel
        buttonPanel.setBackground(Color.WHITE);

        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.CENTER);

        // Xử lý sự kiện khi nhấn các nút
        muonSachButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(LibraryHomePage.this, "Bạn đã nhấn nút Mượn Sách");
            }
        });

        traSachButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(LibraryHomePage.this, "Bạn đã nhấn nút Trả Sách");
            }
        });

        timKiemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(LibraryHomePage.this, "Bạn đã nhấn nút Tìm Kiếm Sách");
            }
        });

        xemTatCaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(LibraryHomePage.this, "Bạn đã nhấn nút Xem Tất Cả Sách");
            }
        });

        thongTinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(LibraryHomePage.this, "Bạn đã nhấn nút Xem Thông Tin Cá Nhân");
            }
        });

        moRongButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(LibraryHomePage.this, "Bạn đã nhấn nút Tính Năng Mở Rộng Thư Viện");
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null); // Đặt cửa sổ ở trung tâm màn hình
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LibraryHomePage(); // Tạo và hiển thị cửa sổ chính
            }
        });
    }
}

