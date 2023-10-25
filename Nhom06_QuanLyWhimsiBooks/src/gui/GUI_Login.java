package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import utilities.ColorProcessing;
import utilities.ImageProcessing;
import utilities.WindowTitle;

import java.awt.Window.Type;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
/**
 * 
 * @author: Dương Thái Bảo
 * @lastUpdate: 24/10/2023
 * @description: 
 * 				1. Giao diện đăng nhập
 *
 */
public class GUI_Login extends JFrame {
	private JTextField txtUsername;
	private JPasswordField pwdUserType;
	/**
	 * Create the frame.
	 */
	public GUI_Login() {
		setTitle(WindowTitle.getTitleContent("Đăng nhập"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblBackgroundLogin = new JLabel("");
		lblBackgroundLogin.setBounds(54, 135, 437, 390);

		ImageProcessing.scaleImageFitToLabel(
				lblBackgroundLogin, 
				ImageProcessing.generateImageIcon(GUI_Login.class.getResource("/img/background/bg-login.png"))
		);
		
		
		getContentPane().add(lblBackgroundLogin);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(75, 41, 204, 45);
		
		ImageProcessing.scaleImageFitToLabel(
				lblLogo, 
				ImageProcessing.generateImageIcon(GUI_Login.class.getResource("/img/logo/whimsibooks-logo.png"))
		);
				getContentPane().add(lblLogo);
				
				JLabel lblLine = new JLabel("");
				lblLine.setIcon(new ImageIcon(GUI_Login.class.getResource("/img/background/line.png")));
				lblLine.setBounds(511, 119, 11, 390);
				getContentPane().add(lblLine);
				
				JLabel lblWelcome = new JLabel("Chào mừng trở lại!");
				lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 23));
				lblWelcome.setBounds(542, 85, 227, 45);
				getContentPane().add(lblWelcome);
				
				JLabel lblHyngNhp = new JLabel("Hãy đăng nhập vào hệ thống để tiếp tục công việc của bạn");
				lblHyngNhp.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblHyngNhp.setBounds(542, 121, 388, 45);
				getContentPane().add(lblHyngNhp);
				
				JLabel lblUsername = new JLabel("Username:");
				lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblUsername.setBounds(542, 193, 388, 45);
				getContentPane().add(lblUsername);
				
				txtUsername = new JTextField();
				txtUsername.setBounds(542, 236, 369, 35);
				getContentPane().add(txtUsername);
				txtUsername.setColumns(10);
				
				JLabel lblPassword = new JLabel("Password:");
				lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblPassword.setBounds(542, 277, 388, 45);
				getContentPane().add(lblPassword);
				
				pwdUserType = new JPasswordField();
				pwdUserType.setColumns(10);
				pwdUserType.setBounds(542, 319, 369, 35);
				getContentPane().add(pwdUserType);
				
				JButton btnLogin = new JButton("Đăng nhập");
				btnLogin.setForeground(Color.WHITE);
				btnLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnLogin.setBounds(556, 419, 156, 45);
				
				btnLogin.setBackground(ColorProcessing.rgbColor(15, 145, 239));
				
				getContentPane().add(btnLogin);
				
				JButton btnResetPassword = new JButton("Quên mật khẩu");
				btnResetPassword.setForeground(Color.WHITE);
				btnResetPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnResetPassword.setBounds(740, 419, 157, 45);		
				btnResetPassword.setBackground(ColorProcessing.rgbColor(15, 145, 239));
				getContentPane().add(btnResetPassword);
				
				JLabel lblDesignedBy = new JLabel("Panther's team project (Nhóm 7 - Application Development) ");
				lblDesignedBy.setHorizontalAlignment(SwingConstants.CENTER);
				lblDesignedBy.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblDesignedBy.setBounds(542, 480, 369, 45);
				getContentPane().add(lblDesignedBy);
		this.setSize(1000, 620);
		this.setLocationRelativeTo(null);
	}
}
