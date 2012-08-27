package presentation;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import logic.Controller;
import logic.LanguageManager;
import ludo.JDiagonalLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.TitledBorder;

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

	private JPanelRound pnlBackground;
	private JLabel lblRemember;
	private JButton btnLogin;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnRegister;
	private LanguageManager language;

	public LoginUI() {
		super();
		language = LanguageManager.language();
		initGUI();

	}

	private void initGUI() {
		setTitle("Bienvenido");
		setResizable(false);
		this.setSize(466, 255);
		getContentPane().setLayout(null);
		getContentPane().add(getPnlBackground());
		setLocationRelativeTo(null);
		setVisible(true);
		this.setIconImage(new ImageIcon(LoginUI.class
				.getResource("/images/icon.png")).getImage());
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				thisWindowClosing(evt);
			}
		});
	}

	private JPanelRound getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanelRound();
			pnlBackground.setArcw(0);
			pnlBackground.setArch(0);
			pnlBackground.setBounds(0, 0, 460, 227);
			pnlBackground.setLayout(null);
			pnlBackground.add(getBtnLogin());
			pnlBackground.add(getTxtUsername());
			pnlBackground.add(getTxtPassword());
			pnlBackground.add(getLblUsername());
			pnlBackground.add(getLblPassword());
			pnlBackground.add(getBtnRegister());
			pnlBackground.add(getLblRemember());
		}
		return pnlBackground;
	}

	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Entrar");
			btnLogin.setText(language.getString("btnLogin"));
			btnLogin.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					do_btnLogin_mouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					btnLoginMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnLoginMouseExited(e);
				}
			});
			btnLogin.setFocusable(false);
			btnLogin.setBounds(259, 142, 89, 23);
		}
		return btnLogin;
	}

	private JTextField getTxtUsername() {
		if (txtUsername == null) {
			txtUsername = new JTextField();
			txtUsername.setCaretColor(Color.WHITE);
			txtUsername.setForeground(Color.WHITE);
			txtUsername.setBackground(Color.BLACK);
			txtUsername.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			txtUsername.setColumns(10);
			txtUsername.setBounds(228, 51, 120, 25);
			txtUsername.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent evt) {
					txtUsernameKeyPressed(evt);
				}
			});
		}
		return txtUsername;
	}

	private JPasswordField getTxtPassword() {
		if (txtPassword == null) {
			txtPassword = new JPasswordField();
			txtPassword.setCaretColor(Color.WHITE);
			txtPassword.setForeground(Color.WHITE);
			txtPassword.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			txtPassword.setBackground(Color.BLACK);
			txtPassword.setColumns(10);
			txtPassword.setBounds(228, 87, 120, 25);
			txtPassword.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent evt) {
					txtPasswordKeyPressed(evt);
				}
			});
		}
		return txtPassword;
	}

	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Usuario");
			lblUsername.setForeground(Color.WHITE);
			lblUsername.setText(language.getString("lblUsername"));
			lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblUsername.setAlignmentX(0.5f);
			lblUsername.setBounds(87, 51, 96, 25);
		}
		return lblUsername;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Contraseña");
			lblPassword.setForeground(Color.WHITE);
			lblPassword.setText(language.getString("lblPassword"));
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPassword.setBounds(87, 87, 98, 23);
		}
		return lblPassword;
	}

	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("Registrar");
			btnRegister.setText(language.getString("btnRegister"));
			btnRegister.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					do_btnRegister_mouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					btnRegisterMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnRegisterMouseExited(e);
				}
			});
			btnRegister.setFocusable(false);
			btnRegister.setBounds(259, 176, 89, 23);
		}
		return btnRegister;
	}

	protected void do_btnRegister_mouseClicked(MouseEvent e) {
		Controller.getInstance().showRegisterUI();
	}

	protected void do_btnLogin_mouseClicked(MouseEvent e) {
		loginUser();
	}

	private void txtPasswordKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == 10) {
			loginUser();
		}
	}

	private void txtUsernameKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == 10) {
			loginUser();
		}
	}

	private void loginUser() {
		String password = new String(txtPassword.getPassword());
		Controller.getInstance().loginUser(txtUsername.getText(), password);
	}

	private void thisWindowClosing(WindowEvent evt) {
		Controller.getInstance().closeConnection();
	}

	private JLabel getLblRemember() {
		if (lblRemember == null) {
			lblRemember = new JLabel();
			lblRemember.setForeground(Color.WHITE);
			lblRemember.setText(language.getString("lblRemember"));
			lblRemember.setBounds(47, 180, 170, 14);
			lblRemember.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblRemember.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lblRememberMouseClicked(evt);
				}

				public void mouseExited(MouseEvent evt) {
					lblRememberMouseExited(evt);
				}

				public void mouseEntered(MouseEvent evt) {
					lblRememberMouseEntered(evt);
				}
			});
		}
		return lblRemember;
	}

	private void lblRememberMouseEntered(MouseEvent evt) {
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	private void lblRememberMouseExited(MouseEvent evt) {
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	private void lblRememberMouseClicked(MouseEvent evt) {
		Controller.getInstance().showResetPasswordUI();
	}

	private void setHandCursor() {
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	private void setDefaultCursor() {
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	protected void btnLoginMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnLoginMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void btnRegisterMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnRegisterMouseExited(MouseEvent e) {
		setDefaultCursor();
	}
}
