package presentation;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LoginUI extends javax.swing.JFrame {

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JTextField txtUser;
	private JPasswordField txtPassword;
	private LoginUIController controller;

	/**
	 * Auto-generated main method to display this JFrame
	 */

	public LoginUI() {
		super();
		setSize(new Dimension(470, 292));
		setName("LoginUI");
		initGUI();
		setLocationRelativeTo(null);
	}

	public LoginUI(LoginUIController loginUIController) {
		super();
		setSize(new Dimension(470, 292));
		setName("LoginUI");
		initGUI();
		setLocationRelativeTo(null);
		this.controller = loginUIController;
	}

	private void initGUI() {
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 454, 254);
		getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFocusable(false);
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				do_btnLogin_mouseClicked(arg0);
			}
		});
		btnLogin.setBounds(227, 149, 89, 23);
		panel.add(btnLogin);

		txtUser = new JTextField();
		txtUser.setBounds(212, 63, 120, 20);
		panel.add(txtUser);
		txtUser.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(212, 102, 120, 20);
		panel.add(txtPassword);
		txtPassword.setColumns(10);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblUsername.setBounds(107, 66, 59, 15);
		panel.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(109, 105, 59, 15);
		panel.add(lblPassword);

		JButton btnRegister = new JButton("Register");
		btnRegister.setFocusable(false);
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				do_btnRegister_mouseClicked(arg0);
			}
		});
		btnRegister.setBounds(227, 183, 89, 23);
		panel.add(btnRegister);
	}

	protected void do_btnLogin_mouseClicked(MouseEvent arg0) {
		String password = new String(txtPassword.getPassword());
		controller.loginUser(txtUser.getText(), password);
	}

	protected void do_btnRegister_mouseClicked(MouseEvent arg0) {
		controller.openRegisterUI();
	}
}
