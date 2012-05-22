package presentation;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import domain.Controller;
import domain.LanguageManager;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
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

	private JPanel pnlBackground;
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
		setResizable(false);
		this.setSize(482, 272);
		getContentPane().add(getPnlBackground(), BorderLayout.CENTER);
		setLocationRelativeTo(null);
		BorderLayout thisLayout = new BorderLayout();
		getContentPane().setLayout(thisLayout);
		setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				thisWindowClosing(evt);
			}
		});
	}

	private JPanel getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setBounds(0, 0, 514, 234);
			pnlBackground.setLayout(null);
			pnlBackground.add(getBtnLogin());
			pnlBackground.add(getTxtUsername());
			pnlBackground.add(getTxtPassword());
			pnlBackground.add(getLblUsername());
			pnlBackground.add(getLblPassword());
			pnlBackground.add(getBtnRegister());
		}
		return pnlBackground;
	}

	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton(language.getString("LoginUI.btnLogin"));
			btnLogin.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					do_btnLogin_mouseClicked(e);
				}
			});
			btnLogin.setFocusable(false);
			btnLogin.setBounds(243, 143, 89, 23);
		}
		return btnLogin;
	}

	private JTextField getTxtUsername() {
		if (txtUsername == null) {
			txtUsername = new JTextField();
			txtUsername.setColumns(10);
			txtUsername.setBounds(228, 57, 120, 20);
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
			txtPassword.setColumns(10);
			txtPassword.setBounds(228, 96, 120, 20);
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
			lblUsername = new JLabel(language.getString("LoginUI.lblUsername"));
			lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblUsername.setAlignmentX(0.5f);
			lblUsername.setBounds(87, 58, 96, 20);
		}
		return lblUsername;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel(language.getString("LoginUI.lblPassword"));
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPassword.setBounds(87, 96, 98, 20);
		}
		return lblPassword;
	}

	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton(language.getString("LoginUI.btnRegister"));
			btnRegister.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					do_btnRegister_mouseClicked(e);
				}
			});
			btnRegister.setFocusable(false);
			btnRegister.setBounds(243, 177, 89, 23);
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
		if(evt.getKeyCode() == 10){
			loginUser();
		}
	}
	
	private void txtUsernameKeyPressed(KeyEvent evt) {
		if(evt.getKeyCode() == 10){
			loginUser();
		}
	}
	
	private void loginUser(){
		String password = new String(txtPassword.getPassword());
		Controller.getInstance().loginUser(txtUsername.getText(), password);
	}
	
	private void thisWindowClosing(WindowEvent evt) {
		Controller.getInstance().closeConnection();
	}
}
