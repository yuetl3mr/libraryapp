package aaa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppointmentScheduler extends JFrame implements ActionListener {
    private JTextField nameField;
    private JSpinner dateSpinner, startTimeSpinner, endTimeSpinner;
    private JTextArea noteArea;

    public AppointmentScheduler() {
        setTitle("Appointment Scheduler");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.WEST;

        JLabel nameLabel = new JLabel("Tên lịch hẹn:");
        nameField = new JTextField();
        nameField.setColumns(20);
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(nameLabel, constraints);
        constraints.gridx = 1;
        panel.add(nameField, constraints);

        JLabel dateLabel = new JLabel("Ngày:");
        dateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
        dateSpinner.setEditor(dateEditor);
        dateSpinner.setValue(new java.util.Date());
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(dateLabel, constraints);
        constraints.gridx = 1;
        panel.add(dateSpinner, constraints);

        JLabel startTimeLabel = new JLabel("Thời gian bắt đầu:");
        startTimeSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor startTimeEditor = new JSpinner.DateEditor(startTimeSpinner, "HH:mm");
        startTimeSpinner.setEditor(startTimeEditor);
        startTimeSpinner.setValue(new java.util.Date());
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(startTimeLabel, constraints);
        constraints.gridx = 1;
        panel.add(startTimeSpinner, constraints);

        JLabel endTimeLabel = new JLabel("Thời gian kết thúc:");
        endTimeSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor endTimeEditor = new JSpinner.DateEditor(endTimeSpinner, "HH:mm");
        endTimeSpinner.setEditor(endTimeEditor);
        endTimeSpinner.setValue(new java.util.Date());
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(endTimeLabel, constraints);
        constraints.gridx = 1;
        panel.add(endTimeSpinner, constraints);

        JLabel noteLabel = new JLabel("Nội dung:");
        noteArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(noteArea);
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        panel.add(noteLabel, constraints);
        constraints.gridy = 5;
        panel.add(scrollPane, constraints);

        JButton scheduleButton = new JButton("Đặt lịch");
        scheduleButton.addActionListener(this);
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        panel.add(scheduleButton, constraints);

        JButton backButton = new JButton("Quay lại");
        backButton.addActionListener(this);
        constraints.gridx = 0;
        constraints.gridy = 7;
        panel.add(backButton, constraints);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Đặt lịch")) {
            // Xử lý đặt lịch
        	
            JOptionPane.showMessageDialog(this, "Lịch hẹn đã được đặt!");
        } else if (e.getActionCommand().equals("Quay lại")) {
            this.dispose(); // Đóng cửa sổ hiện tại
            new UserInformation(LoginGUI.id); // Mở giao diện thông tin người dùng
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AppointmentScheduler();
            }
        });
    }
}
