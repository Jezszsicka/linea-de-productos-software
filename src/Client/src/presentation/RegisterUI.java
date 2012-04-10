package presentation;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import domain.Facade;


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
public class RegisterUI extends javax.swing.JFrame {

	private JPanel pnlBackground;
	private JButton btnRegister;
	private JButton btnCancel;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblEmail;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JTextField txtEmail;
	private JPasswordField txtPasswordR;
	private JTextField txtEmailR;

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public RegisterUI() {
		super();
		initGUI();
	}

	private void initGUI() {
		setSize(new Dimension(550, 240));
		getContentPane().setLayout(null);
		getContentPane().add(getPnlBackground());
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private JPanel getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setBounds(0, 0, 534, 202);
			pnlBackground.setLayout(null);
			pnlBackground.add(getBtnRegister());
			pnlBackground.add(getBtnCancel());
			pnlBackground.add(getLblUsername());
			pnlBackground.add(getLblPassword());
			pnlBackground.add(getLblEmail());
			pnlBackground.add(getTxtUsername());
			pnlBackground.add(getTxtPassword());
			pnlBackground.add(getTxtEmail());
			pnlBackground.add(getTxtPasswordR());
			pnlBackground.add(getTxtEmailR());
		}
		return pnlBackground;
	}

	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("Register");
			btnRegister.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					do_btnRegister_mouseClicked(arg0);
				}
			});
			btnRegister.setBounds(120, 159, 89, 23);
			btnRegister.setFocusable(false);
		}
		return btnRegister;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					do_btnCancel_mouseClicked(e);
				}
			});
			btnCancel.setBounds(329, 159, 89, 23);
			btnCancel.setFocusable(false);
		}
		return btnCancel;
	}

	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username");
			lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblUsername.setBounds(77, 42, 59, 15);
		}
		return lblUsername;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPassword.setBounds(77, 75, 59, 15);
		}
		return lblPassword;
	}

	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email");
			lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblEmail.setBounds(77, 103, 31, 15);
		}
		return lblEmail;
	}

	private JTextField getTxtUsername() {
		if (txtUsername == null) {
			txtUsername = new JTextField();
			txtUsername.setBounds(202, 39, 120, 20);
			txtUsername.setColumns(10);
		}
		return txtUsername;
	}

	private JPasswordField getTxtPassword() {
		if (txtPassword == null) {
			txtPassword = new JPasswordField();
			txtPassword.setBounds(202, 72, 120, 20);
			txtPassword.setColumns(10);
		}
		return txtPassword;
	}

	private JTextField getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new JTextField();
			txtEmail.setBounds(202, 100, 120, 20);
			txtEmail.setColumns(10);
		}
		return txtEmail;
	}

	private JPasswordField getTxtPasswordR() {
		if (txtPasswordR == null) {
			txtPasswordR = new JPasswordField();
			txtPasswordR.setBounds(337, 72, 120, 20);
			txtPasswordR.setColumns(10);
		}
		return txtPasswordR;
	}

	private JTextField getTxtEmailR() {
		if (txtEmailR == null) {
			txtEmailR = new JTextField();
			txtEmailR.setBounds(337, 100, 120, 20);
			txtEmailR.setColumns(10);
		}
		return txtEmailR;
	}

	protected void do_btnCancel_mouseClicked(MouseEvent e) {
		Facade.getInstance().cancelRegister();
	}

	protected void do_btnRegister_mouseClicked(MouseEvent arg0) {
		String username = txtUsername.getText();
		String password = new String(txtPassword.getPassword());
		String retypedPassword = new String(txtPasswordR.getPassword());
		String email = txtEmail.getText();
		String retypedEmail = txtEmailR.getText();
		Facade.getInstance().registerUser(username, password, retypedPassword,
				email, retypedEmail);
	}
}
