package presentation;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.WindowConstants;

import logic.Controller;
import logic.LanguageManager;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class ChangePasswordUI extends javax.swing.JFrame {
	private JPanelRound pnlBackground;
	private JLabel lblPassword;
	private JPasswordField txtPassword;
	private JLabel lblNewPassword;
	private JPasswordField txtNewPassword;
	private JLabel lblConfirmPassword;
	private JPasswordField txtConfirmPassword;
	private JButton btnSave;
	private JButton btnCancel;
	private ProfileUI parent;
	private LanguageManager language;

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ChangePasswordUI(ProfileUI parent) {
		super();
		this.parent = parent;
		this.language = LanguageManager.language();
		initGUI();
	}

	private void initGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				ChangePasswordUI.class.getResource("/images/icon.png")));
		setTitle("Cambiar contraseña");
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		getContentPane().add(getPnlBackground(), BorderLayout.CENTER);
		this.setSize(400, 200);
		setVisible(true);
		setLocationRelativeTo(null);
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
			pnlBackground.setLayout(null);
			pnlBackground.setSize(400, 200);
			pnlBackground.add(getBtnCancel());
			pnlBackground.add(getBtnSave());
			pnlBackground.add(getTxtConfirmPassword());
			pnlBackground.add(getLblConfirmPassword());
			pnlBackground.add(getTxtNewPassword());
			pnlBackground.add(getLblNewPassword());
			pnlBackground.add(getTxtPassword());
			pnlBackground.add(getLblPassword());
		}
		return pnlBackground;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancelar");
			btnCancel.setText(language.getString("btnCancel"));
			btnCancel.setBounds(259, 121, 84, 23);
			btnCancel.setFocusable(false);
			btnCancel.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnCancelMouseClicked(evt);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					btnCancelMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnCancelMouseExited(e);
				}
			});
		}
		return btnCancel;
	}

	private JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("Cambiar");
			btnSave.setText(language.getString("btnChange"));
			btnSave.setBounds(38, 121, 84, 23);
			btnSave.setFocusable(false);
			btnSave.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnSaveMouseClicked(evt);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					btnSaveMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnSaveMouseExited(e);
				}
			});
		}
		return btnSave;
	}

	private JPasswordField getTxtConfirmPassword() {
		if (txtConfirmPassword == null) {
			txtConfirmPassword = new JPasswordField();
			txtConfirmPassword.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			txtConfirmPassword.setBackground(Color.BLACK);
			txtConfirmPassword.setCaretColor(Color.WHITE);
			txtConfirmPassword.setForeground(Color.WHITE);
			txtConfirmPassword.setBounds(194, 81, 145, 25);
		}
		return txtConfirmPassword;
	}

	private JLabel getLblConfirmPassword() {
		if (lblConfirmPassword == null) {
			lblConfirmPassword = new JLabel("Confirmar contraseña");
			lblConfirmPassword.setForeground(Color.WHITE);
			lblConfirmPassword
					.setText(language.getString("lblConfirmPassword"));
			lblConfirmPassword.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblConfirmPassword.setBounds(28, 81, 129, 25);
		}
		return lblConfirmPassword;
	}

	private JPasswordField getTxtNewPassword() {
		if (txtNewPassword == null) {
			txtNewPassword = new JPasswordField();
			txtNewPassword.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			txtNewPassword.setBackground(Color.BLACK);
			txtNewPassword.setCaretColor(Color.WHITE);
			txtNewPassword.setForeground(Color.WHITE);
			txtNewPassword.setBounds(194, 50, 145, 25);
		}
		return txtNewPassword;
	}

	private JLabel getLblNewPassword() {
		if (lblNewPassword == null) {
			lblNewPassword = new JLabel("Nueva contraseña");
			lblNewPassword.setForeground(Color.WHITE);
			lblNewPassword.setText(language.getString("lblNewPassword"));
			lblNewPassword.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblNewPassword.setBounds(28, 51, 129, 25);
		}
		return lblNewPassword;
	}

	private JPasswordField getTxtPassword() {
		if (txtPassword == null) {
			txtPassword = new JPasswordField();
			txtPassword.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			txtPassword.setBackground(Color.BLACK);
			txtPassword.setCaretColor(Color.WHITE);
			txtPassword.setForeground(Color.WHITE);
			txtPassword.setBounds(194, 19, 145, 25);
		}
		return txtPassword;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Contraseña");
			lblPassword.setForeground(Color.WHITE);
			lblPassword.setText(language.getString("lblPassword"));
			lblPassword.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblPassword.setBounds(28, 20, 129, 25);
		}
		return lblPassword;
	}

	private void btnSaveMouseClicked(MouseEvent evt) {
		String password = new String(txtPassword.getPassword());
		String newPassword = new String(txtNewPassword.getPassword());
		String confirmPassword = new String(txtConfirmPassword.getPassword());
		Controller.getInstance().changePassword(password, newPassword,
				confirmPassword);
	}

	private void btnCancelMouseClicked(MouseEvent evt) {
		parent.setEnabled(true);
		parent.toFront();
		dispose();
	}

	private void thisWindowClosing(WindowEvent evt) {
		parent.setEnabled(true);
		dispose();
	}

	private void setHandCursor() {
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	private void setDefaultCursor() {
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	protected void btnCancelMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnCancelMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void btnSaveMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnSaveMouseExited(MouseEvent e) {
		setDefaultCursor();
	}
}
