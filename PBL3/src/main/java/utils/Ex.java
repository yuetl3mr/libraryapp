package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex {

	// xử lí tài khoản trùng nhau
	public static boolean userNameTrue(String string) {
		if(string.length() < 6) {
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
		if(string.length() < 6) {
			return false;
		}
		return true;
	}
	
	// xử lí số điện thoại
	public static boolean phoneNumberTrue(String string) {
		if(string.length() != 10) {
			return false;
		}
		for (int i = 0; i < string.length(); i++) {
			if(string.charAt(i) < '0' || string.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}
	
	// xử lí địa chỉ 
	public static boolean addressTrue(String string) {
		if(string == "") {
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
		if(passwordNew.equals(passwordRepeat)) {
			return true;
		}
		return false;
	}
	
	
	
	
}
