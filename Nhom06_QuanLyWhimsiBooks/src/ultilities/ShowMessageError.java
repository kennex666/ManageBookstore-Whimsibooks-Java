package ultilities;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class ShowMessageError {
	public static void showError(Component component,JTextField nameTxt, String displayErrors, String typeDisplay) {
		JOptionPane.showMessageDialog(component, displayErrors , typeDisplay,
				JOptionPane.INFORMATION_MESSAGE);
		nameTxt.requestFocus();
	}
	
	public static void showErrorNoTextFile(Component component, String displayErrors, String typeDisplay) {
		JOptionPane.showMessageDialog(component, displayErrors , typeDisplay,
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void showErrorJPanl(JTextField nameTxt,JLabel jLabel, String typeDisplay) {
		jLabel.setText(typeDisplay);
		jLabel.setForeground(Color.decode("#DB4F4E"));
        Font italicFont = jLabel.getFont().deriveFont(Font.ITALIC);
        jLabel.setFont(italicFont);
        nameTxt.requestFocus();
	}
	public static void showErrorJcalendar(JDateChooser chooser,JLabel jLabel,String typeDisplay) {
		jLabel.setText(typeDisplay);
		jLabel.setForeground(Color.decode("#DB4F4E"));
        Font italicFont = jLabel.getFont().deriveFont(Font.ITALIC);
        jLabel.setFont(italicFont);
	}
}
