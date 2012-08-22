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
import logic.LanguageManager;
import java.awt.Color;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class ResetPasswordUI extends javax.swing.JFrame {
	private JPanelRound pnlBackground;
	private JButton btnSearch;
	private JButton btnCancel;
	private JLabel lblUserOrEmail;
	private JTextField txtAccount;
	private JLabel lblIdentify;

	private LanguageManager language;

	public ResetPasswordUI() {
		language = LanguageManager.language();
		initGUI();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void initGUI() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setTitle(language.getString("resetPasswordUITitle"));
		getContentPane().add(getPnlBackground());
		this.setSize(424, 207);
	}

	private JPanelRound getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanelRound();
			pnlBackground.setArcw(0);
			pnlBackground.setArch(0);
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
			lblIdentify.setForeground(Color.WHITE);
			lblIdentify.setText(language.getString("lblIdentify"));
			lblIdentify.setBounds(10, 21, 388, 14);
			lblIdentify.setFont(new java.awt.Font("Tahoma", 0, 11));
		}
		return lblIdentify;
	}

	private JTextField getTxtAccount() {
		if (txtAccount == null) {
			txtAccount = new JTextField();
			txtAccount.setCaretColor(Color.WHITE);
			txtAccount.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			txtAccount.setBackground(Color.BLACK);
			txtAccount.setForeground(Color.WHITE);
			txtAccount.setBounds(64, 90, 270, 25);
		}
		return txtAccount;
	}

	private JLabel getLblAccount() {
		if (lblUserOrEmail == null) {
			lblUserOrEmail = new JLabel();
			lblUserOrEmail.setForeground(Color.WHITE);
			lblUserOrEmail.setText(language.getString("lblUserOrEmail"));
			lblUserOrEmail.setBounds(20, 60, 128, 14);
			lblUserOrEmail.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblUserOrEmail;
	}

	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton();
			btnSearch.setText(language.getString("btnSearch"));
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
			btnCancel.setText(language.getString("btnCancel"));
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
