package utilities;

import java.awt.Component;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ShowMessageError {
	public static void showError(Component component,JTextField nameTxt, String displayErrors, String typeDisplay) {
		JOptionPane.showMessageDialog(component, displayErrors , typeDisplay,
				JOptionPane.INFORMATION_MESSAGE);
		nameTxt.requestFocus();
	}
}
