package presentation;

import java.awt.BorderLayout;
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

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
@SuppressWarnings("serial")
public class DeleteAccountUI extends javax.swing.JFrame {
	private ProfileUI parent;
	private JPanel pnlBackground;
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
		pack();
		this.setSize(360, 156);
	}

	private JPanel getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanel();
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
			txtPassword.setBounds(157, 30, 145, 20);
		}
		return txtPassword;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Contraseña");
			lblPassword.setText(language.getString("lblPassword"));
			lblPassword.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblPassword.setBounds(45, 30, 108, 20);
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

}
