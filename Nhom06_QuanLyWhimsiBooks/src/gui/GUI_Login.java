package gui;

import bus.NhanVien_BUS;
import com.itextpdf.awt.geom.misc.Messages;
import entities.NhanVien;
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
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Properties;
import javax.swing.SwingConstants;
import utilities.CurrentSession;
import utilities.EmailUtils;
import utilities.EnviromentConfigs;
import utilities.ErrorMessage;
import utilities.PasswordGenerator;

/**
 *
 * @author: Dương Thái Bảo
 * @lastUpdate: 24/10/2023
 * @description: 1. Giao diện đăng nhập
 *
 */
public class GUI_Login extends JFrame implements ActionListener {

	private JTextField txtUsername;
	private JPasswordField pwdUserType;
	private JButton btnLogin, btnResetPassword;
	private NhanVien nhanVien;
	private NhanVien_BUS nhanVien_BUS;

	/**
	 * Create the frame.
	 */
	public GUI_Login() {
		nhanVien_BUS = new NhanVien_BUS();
		setTitle(WindowTitle.getTitleContent("Đăng nhập"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);

		JLabel lblBackgroundLogin = new JLabel("");
		lblBackgroundLogin.setBounds(54, 135, 437, 390);

		ImageProcessing.scaleImageFitToLabel(lblBackgroundLogin,
				ImageProcessing.generateImageIcon(GUI_Login.class.getResource("/img/background/bg-login.png")));

		getContentPane().add(lblBackgroundLogin);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(75, 41, 204, 45);

		ImageProcessing.scaleImageFitToLabel(lblLogo,
				ImageProcessing.generateImageIcon(GUI_Login.class.getResource("/img/logo/whimsibooks-logo.png")));
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

		btnLogin = new JButton("Đăng nhập");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBounds(556, 419, 156, 45);

		btnLogin.setBackground(ColorProcessing.rgbColor(15, 145, 239));

		getContentPane().add(btnLogin);

		btnResetPassword = new JButton("Quên mật khẩu");
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

		btnLogin.addActionListener(this);
		btnResetPassword.addActionListener(this);
		txtUsername.addActionListener(this);
		pwdUserType.addActionListener(this);
		txtUsername.setText("quanly01");
		pwdUserType.setText("123456");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnLogin)) {
			if (txtUsername.getText().isBlank()) {
				ErrorMessage.showMessageWithFocusTextField("Lỗi đăng nhập", "Cần nhập username!", txtUsername);
				txtUsername.requestFocus();
				return;
			}
			if (new String(pwdUserType.getPassword()).length() < 1) {
				ErrorMessage.showMessageWithFocusTextField("Lỗi đăng nhập", "Cần nhập mật khẩu", txtUsername);
				pwdUserType.requestFocus();
				return;
			}
			nhanVien = nhanVien_BUS.dangNhapNhanVien(txtUsername.getText(), new String(pwdUserType.getPassword()));
			if (nhanVien == null) {
				ErrorMessage.showMessageWithFocusTextField("Lỗi đăng nhập", "Tài khoản/Mật khẩu không hợp lệ!",
						txtUsername);
				return;
			}

			if (nhanVien.getNhanVienID() == null) {
				ErrorMessage.showMessageWithFocusTextField("Lỗi đăng nhập", "Tài khoản/Mật khẩu không hợp lệ!",
						txtUsername);
				return;
			}

			CurrentSession.getInstance().setNhanVienHienHanh(nhanVien);
			GUI_MainMenu gui = new GUI_MainMenu();
			gui.guiDisable();
			gui.setVisible(true);
			this.setVisible(false);
			dispose();
		}

		if (e.getSource().equals(btnResetPassword)) {
			
			if (txtUsername.getText().isBlank()) {
				ErrorMessage.showMessageWithFocusTextField("Yêu cầu hành động",
						"Hãy gõ username vào ô. Chúng tôi sẽ gửi mật khẩu mới về tài khoản email đã đăng ký!",
						txtUsername);
				txtUsername.requestFocus();
				return;
			}
			String emailUser = nhanVien_BUS.getNhanVienEmailViaUsername(txtUsername.getText());
			if (emailUser == null) {
				ErrorMessage.showMessageWithFocusTextField("Lỗi", "Không tìm thấy email của " + txtUsername.getText()
						+ " hoặc user này không có email trên hệ thống!", txtUsername);
				return;
			}

			String to = emailUser;
			String host = "smtp.gmail.com";
			String tempPassword = PasswordGenerator.generatePassword(10);


			try {

				
				System.out.println("TLSEmail Start");
				Properties props = new Properties();

				props.put("mail.smtp.host", host); //SMTP Host
				props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.prot", "465");

				
		                //create Authenticator object to pass in Session.getInstance argument
				Authenticator auth = new Authenticator() {
					//override the getPasswordAuthentication method
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(EnviromentConfigs.STMP_USERNAME, EnviromentConfigs.STMP_PASSWORD);
					}
				};
				Session session = Session.getInstance(props, auth);
				
				
				boolean isSuccessReset = nhanVien_BUS.resetUserPassword(txtUsername.getText(), tempPassword);

				if (isSuccessReset != true) {
					ErrorMessage.showMessageWithFocusTextField("Lỗi",
							"Không thể cập nhật lại mật khẩu của người dùng " + txtUsername.getText() + ": Lỗi CSDL!",
							txtUsername);
					return;
				}
				EmailUtils.sendEmail(
						session, 
						emailUser, 
						"[Whimsibooks] Đặt lại mật khẩu",
						"Chào " + txtUsername.getText() + ", "
								+ "\n\nBạn vừa yêu cầu đặt lại mật khẩu từ hệ thống Whimsibooks - Quản lý nhà sách.\n\nTUYỆT ĐỐI KHÔNG CUNG CẤP MẬT KHẨU VỚI BẤT KỲ AI\nMật khẩu mới của bạn là: "
								+ tempPassword + 
								"\n\nĐể đổi mật khẩu, bạn hãy đăng nhập lại hệ thống. Ở góc bên trái trên cùng có nút \"Chào, <Tên bạn>\", hãy ấn vào và chọn đổi mật khẩu!\n\nWhimsibooks trân trọng cảm ơn!");
				ErrorMessage.showMessageWithFocusTextField("Đã gửi mật khẩu mới", "Đã gửi mật khẩu mới về email " + emailUser.substring(0, 3) + "********! Hãy kiểm tra email và đăng nhập.", pwdUserType);
			} catch (Exception mex) {
				mex.printStackTrace();
				JOptionPane.showMessageDialog(null,
						"Đã xảy ra lỗi, vui lòng kiểm tra lại thiết lập email hoặc sự cố Internet!");
			}

			return;
		}

		if (e.getSource().equals(txtUsername))

		{
			if (txtUsername.getText().isBlank()) {
				ErrorMessage.showMessageWithFocusTextField("Lỗi đăng nhập", "Cần nhập username!", txtUsername);
				txtUsername.requestFocus();
				return;
			}
			pwdUserType.requestFocus();
		}

		if (e.getSource().equals(pwdUserType)) {
			if (new String(pwdUserType.getPassword()).length() < 1) {
				ErrorMessage.showMessageWithFocusTextField("Lỗi đăng nhập", "Cần nhập mật khẩu", txtUsername);
				pwdUserType.requestFocus();
				return;
			}
			btnLogin.doClick();
		}

	}

}
