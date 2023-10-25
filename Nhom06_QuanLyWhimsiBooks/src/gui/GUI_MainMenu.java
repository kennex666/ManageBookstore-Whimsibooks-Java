package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class GUI_MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_MainMenu frame = new GUI_MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**ExtendedState(Frame.MAXIMIZED_BOTH);
		set
	 * Create the frame.
	 */
	public GUI_MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1283, 826);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelTop = new JPanel();
		contentPane.add(panelTop, BorderLayout.NORTH);
		panelTop.setLayout(null);
		
		JPanel panelLeft = new JPanel();
		contentPane.add(panelLeft, BorderLayout.WEST);
	}

}
