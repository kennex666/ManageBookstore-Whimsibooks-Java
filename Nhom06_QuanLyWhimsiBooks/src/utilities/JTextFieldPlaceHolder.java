package utilities;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JTextField;

public class JTextFieldPlaceHolder extends JTextField{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String placeholder;
	
	public void setPlaceholder (String holder) {
		this.placeholder = holder;
	}
	
	public String getPlaceholder() {
		return placeholder;
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		if (getText().isBlank() && !hasFocus()) {
			g.setColor(new Color(0, 0, 0, 0.6f));
			g.drawString(placeholder, getWidth()/2/2/2/2, getHeight() * 2 / 3);
		}
	}
}
