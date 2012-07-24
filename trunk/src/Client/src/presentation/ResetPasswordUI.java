package presentation;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import logic.Controller;

@SuppressWarnings("serial")
public class ResetPasswordUI extends javax.swing.JFrame {
	private JPanel pnlBackground;
	private JButton btnSearch;
	private JButton btnCancel;
	private JLabel lblAccount;
	private JTextField txtAccount;
	private JLabel lblIdentify;

	/**
	 * Auto-generated main method to display this JFrame
	 */

	public ResetPasswordUI() {
		super();
		initGUI();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void initGUI() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setTitle("Identifica tu cuenta");
		getContentPane().add(getPnlBackground());
		this.setSize(424, 207);
	}

	private JPanel getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setLayout(null);
			pnlBackground.setBounds(0, 0, 408, 169);
			pnlBackground.add(getLblIdentify());
			pnlBackground.add(getTxtAccount());
			pnlBackground.add(getLblAccount());
			pnlBackground.add(getBtnSearch());
			pnlBackground.add(getBtnCancel());
		}
		return pnlBackground;
	}

	private JLabel getLblIdentify() {
		if (lblIdentify == null) {
			lblIdentify = new JLabel();
			lblIdentify
					.setText("Para resetear tu contraseña, por favor primero identifica tu cuenta");
			lblIdentify.setBounds(10, 21, 388, 14);
			lblIdentify.setFont(new java.awt.Font("Tahoma", 0, 11));
		}
		return lblIdentify;
	}

	private JTextField getTxtAccount() {
		if (txtAccount == null) {
			txtAccount = new JTextField();
			txtAccount.setBounds(64, 90, 270, 20);
		}
		return txtAccount;
	}

	private JLabel getLblAccount() {
		if (lblAccount == null) {
			lblAccount = new JLabel();
			lblAccount.setText("Usuario o email");
			lblAccount.setBounds(20, 60, 128, 14);
			lblAccount.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblAccount;
	}

	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton();
			btnSearch.setText("Buscar");
			btnSearch.setBounds(242, 133, 71, 23);
			btnSearch.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnSearchMouseClicked(evt);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					btnSearchMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnSearchMouseExited(e);
				}
			});
		}
		return btnSearch;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton();
			btnCancel.setText("Cancelar");
			btnCancel.setBounds(323, 133, 75, 23);
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

	private void btnSearchMouseClicked(MouseEvent evt) {
		String identifier = txtAccount.getText();
		Controller.getInstance().resetPassword(identifier);
	}

	private void btnCancelMouseClicked(MouseEvent evt) {
		dispose();
	}

	private void setHandCursor() {
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	private void setDefaultCursor() {
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	protected void btnSearchMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnSearchMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void btnCancelMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnCancelMouseExited(MouseEvent e) {
		setDefaultCursor();
	}
}
