package presentation;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import javax.swing.WindowConstants;

import logic.Controller;
import logic.LanguageManager;
import java.awt.Color;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class DeleteAccountUI extends javax.swing.JFrame {
	private ProfileUI parent;
	private JPanelRound pnlBackground;
	private JButton btnCancel;
	private JButton btnDelete;
	private JLabel lblPassword;
	private JPasswordField txtPassword;
	private LanguageManager language;

	public DeleteAccountUI(ProfileUI parent) {
		super();
		this.parent = parent;
		this.language = LanguageManager.language();
		initGUI();
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private void initGUI() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().add(getPnlBackground(), BorderLayout.CENTER);
		setSize(360, 156);
	}

	private JPanelRound getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanelRound();
			pnlBackground.setArch(0);
			pnlBackground.setArcw(0);
			pnlBackground.setLayout(null);
			pnlBackground.add(getTxtPassword());
			pnlBackground.add(getLblPassword());
			pnlBackground.add(getBtnDelete());
			pnlBackground.add(getBtnCancel());
		}
		return pnlBackground;
	}

	private JPasswordField getTxtPassword() {
		if (txtPassword == null) {
			txtPassword = new JPasswordField();
			txtPassword.setBackground(Color.BLACK);
			txtPassword.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			txtPassword.setCaretColor(Color.WHITE);
			txtPassword.setForeground(Color.WHITE);
			txtPassword.setBounds(156, 28, 145, 25);
		}
		return txtPassword;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Contraseña");
			lblPassword.setForeground(Color.WHITE);
			lblPassword.setText(language.getString("lblPassword"));
			lblPassword.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblPassword.setBounds(45, 28, 108, 25);
		}
		return lblPassword;
	}

	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton();
			btnDelete.setText("Eliminar");
			btnDelete.setFocusable(false);
			btnDelete.setBounds(32, 73, 85, 23);
			btnDelete.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnDeleteMouseClicked(evt);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					btnDeleteMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnDeleteMouseExited(e);
				}
			});
		}
		return btnDelete;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.setText(language.getString("btnCancel"));
			btnCancel.setBounds(228, 73, 85, 23);
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

	private void btnDeleteMouseClicked(MouseEvent evt) {
		int option = JOptionPane.showConfirmDialog(this,
				"Are you sure you want to close yout account?",
				"Are you sure?", JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION) {
			String password = new String(txtPassword.getPassword());
			Controller.getInstance().deleteAccount(password);
			parent.setEnabled(true);
			dispose();
		}
	}

	private void btnCancelMouseClicked(MouseEvent evt) {
		parent.setEnabled(true);
		dispose();
	}

	private void setHandCursor() {
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	private void setDefaultCursor() {
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	protected void btnDeleteMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnDeleteMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void btnCancelMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnCancelMouseExited(MouseEvent e) {
		setDefaultCursor();
	}
}
