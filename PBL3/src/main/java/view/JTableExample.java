package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JTableExample extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public JTableExample() {
        setTitle("JTable Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo một DefaultTableModel với các cột "ID", "Name", "Age"
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Age");

        // Thêm dữ liệu mẫu vào bảng
        model.addRow(new Object[]{"1", "John", "25"});
        model.addRow(new Object[]{"2", "Jane", "30"});
        model.addRow(new Object[]{"3", "Doe", "35"});

        // Tạo JTable với DefaultTableModel đã tạo
        table = new JTable(model);

        // Tạo một JScrollPane và đặt JTable vào đó
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JTableExample::new);
    }
}

