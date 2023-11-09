package utilities;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ErrorMessage {
	public static boolean showConfirmDialogYesNo(String title, String message) {
		return (JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION) 
				== JOptionPane.YES_OPTION);
	}
	
	public static void showMessageWithFocusTextField(String title, String message, JTextField txt) {
		JOptionPane.showConfirmDialog(null, message, title, JOptionPane.CLOSED_OPTION);
		txt.requestFocus();
	}
}
