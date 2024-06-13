package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import persistence.*;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ex {

    public static LocalDateTime parseDateToLocalDateTime(String dateString) {
        // Định dạng của chuỗi ngày tháng năm
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            // Chuyển đổi chuỗi thành LocalDate
            LocalDate date = LocalDate.parse(dateString, dateFormatter);

            // Tạo LocalDateTime từ LocalDate, với thời gian mặc định là 00:00:00
            return date.atStartOfDay();
        } catch (DateTimeParseException e) {
            System.err.println("Invalid date format: " + e.getMessage());
            return null; // Hoặc bạn có thể ném ra một ngoại lệ tùy theo yêu cầu của bạn
        }
    }

    public static void exportReaders() {
        List<Reader> readers = Zdata.readerDao.getAll();
        String filePath = "C:/datalms/Readers.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Reader reader : readers) {
                // Ghi thông tin của mỗi đối tượng reader vào file
                writer.write(reader.toString());
                writer.newLine(); // Xuống dòng sau mỗi đối tượng
            }
            System.out.println("Dữ liệu readers đã được ghi vào file: " + filePath);
        } catch (IOException e) {
        }
    }

    public static void sendReceiptEmail(Integer UserId, JTable jTable) {
        User user = Zdata.userDao.get(UserId);
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        int rowCount = model.getRowCount();
        String myEmail = "yueeeee404@gmail.com";
        //String myEmail = user.getPhoneNumber();
        String password = "rgdb hagv etuj opdo"; // Mật khẩu email của bạn// sua cai nay thanh thang muon sach

        //String email = user.getPhoneNumber();
        //String toEmail = email;
        String toEmail = user.getPhoneNumber();
        String host = "smtp.gmail.com";
        String port = "587";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmail, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Book borrowing eReceipt - LMS");

            String emailContent = "Book Borrowing eReceipt\n"
                    + "-------------------------------------------------------"
                    + "\nReader Information"
                    + "\nReader ID: " + UserId
                    + "\nName: " + user.getName()
                    + "\n-------------------------------------------------------"
                    + "\nBook List"
                    + "\n-------------------------------------------------------\n";

            for (int i = 0; i < rowCount; i++) {
                Integer id = (Integer) jTable.getValueAt(i, 0);
                String name = (String) jTable.getValueAt(i, 1);
                emailContent += String.format("%-3s %-30s %-50s\n", id, name, ""); // Sử dụng định dạng để căn chỉnh thông tin
            }

            emailContent += "-------------------------------------------------------"
                    + "\nBorrowing Time: " + LocalDateTime.now()
                    + "\nThank you!";

            message.setText(emailContent);
            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
        }
    }
    
    public static void reportEmail(Integer UserId, String row1,String row2,String row3,String row4,String row5,String row6,String row7) {
        User user = Zdata.userDao.get(UserId);
        String myEmail = "yueeeee404@gmail.com";
        String password = "rgdb hagv etuj opdo"; // Mật khẩu email của bạn// sua cai nay thanh thang muon sach
        //String email = user.getPhoneNumber();
        //String toEmail = email;
        String toEmail = "yuetl3mr@gmail.com";
        String host = "smtp.gmail.com";
        String port = "587";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmail, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("LMS - report");

            String emailContent = "Book Borrowing eReceipt\n"
                    + "Total number of reader : " + row1
                    + "\nTotal number of books : " + row2
                    + "\nNumber of category : " + row3
                    + "\nCategory with the most books: " + row4
                    + "\nCategory with the least books :" + row5
                    + "\nTotal transactions : " + row6
                    + "\nTotal number of books currently on loan : " + row7;

            message.setText(emailContent);
            Transport.send(message);
            JOptionPane.showMessageDialog(null, "Success!");
            
        } catch (MessagingException e) {
        }
    }

    public static void test() {
        List<Reader> readers = Zdata.readerDao.getAll();
        List<Book> books = Zdata.bookDao.getAll();
        List<Loan> loans = Zdata.loanDao.getAll();
    }

    // xử lí tài khoản trùng nhau
    public static boolean userNameTrue(String string) {
        if (string.length() < 6) {
            return false;
        }
        for (int i = 0; i < string.length(); i++) {
            char kyTu = string.charAt(i);
            if (!Character.isLetterOrDigit(kyTu)) {
                return false;
            }
        }
        return true;
    }

    // xử lí mật khẩu
    public static boolean passwordTrue(String string) {
        if (string.length() < 6) {
            return false;
        }
        return true;
    }

    // xử lí số điện thoại
    public static boolean phoneNumberTrue(String string) {
        if (string.length() != 10) {
            return false;
        }
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) < '0' || string.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    // xử lí địa chỉ 
    public static boolean addressTrue(String string) {
        if (string == "") {
            return false;
        }
        return true;
    }

    public static boolean emailTrue(String string) {
        // Biểu thức chính quy để kiểm tra email
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    // xử lí nhập lại mật khẩu
    public static Boolean enterThePassword(String passwordNew, String passwordRepeat) {
        if (passwordNew.equals(passwordRepeat)) {
            return true;
        }
        return false;
    }

    public static LocalDate parseToLocalDate(String string) {
        try {
            // Define the date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            // Parse the string to a LocalDate
            LocalDate date = LocalDate.parse(string, formatter);

            // Print the LocalDate
            return date;
        } catch (DateTimeParseException e) {
            // If the string is not in the expected format
            System.out.println("Error parsing the date: " + e.getMessage());
            return null;
        }
    }

    public static boolean isNumberic(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

}
