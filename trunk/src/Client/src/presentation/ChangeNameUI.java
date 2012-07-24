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
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import logic.Controller;
import logic.LanguageManager;

@SuppressWarnings("serial")
public class ChangeNameUI extends javax.swing.JFrame {
	private JPanel pnglBackground;
	private JTextField txtName;
	private JPasswordField txtPassword;
	private JLabel lblPassword;
	private JButton btnCancel;
	private JButton btnSave;
	private JTextField txtLastname;
	private JLabel lblLastName;
	private JLabel lblName;
	private ProfileUI parent;
	private LanguageManager language;

	public ChangeNameUI(ProfileUI parent, String name, String lastname) {
		super();
		this.parent = parent;
		this.language = LanguageManager.language();
		initGUI();
		txtName.setText(name);
		txtLastname.setText(lastname);
	}

	private void initGUI() {
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		getContentPane().add(getPnglBackground(), BorderLayout.CENTER);
		this.setSize(400, 200);
		setVisible(true);
		setLocationRelativeTo(null);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				thisWindowClosing(evt);
			}
		});
	}

	private JPanel getPnglBackground() {
		if (pnglBackground == null) {
			pnglBackground = new JPanel();
			pnglBackground.setLayout(null);
			pnglBackground.setPreferredSize(new java.awt.Dimension(474, 130));
			pnglBackground.add(getLblName());
			pnglBackground.add(getLblLastName());
			pnglBackground.add(getTxtName());
			pnglBackground.add(getTxtLastname());
			pnglBackground.add(getBtnSave());
			pnglBackground.add(getBtnCancel());
			pnglBackground.add(getLblPassword());
			pnglBackground.add(getTxtPassword());
		}
		return pnglBackground;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Nombre");
			lblName.setText(language.getString("lblName"));
			lblName.setBounds(73, 21, 88, 20);
			lblName.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblName;
	}

	private JLabel getLblLastName() {
		if (lblLastName == null) {
			lblLastName = new JLabel("Apellidos");
			lblLastName.setText(language.getString("lblLastname"));
			lblLastName.setBounds(73, 52, 88, 20);
			lblLastName.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblLastName;
	}

	private JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
			txtName.setBounds(179, 21, 149, 20);
		}
		return txtName;
	}

	private JTextField getTxtLastname() {
		if (txtLastname == null) {
			txtLastname = new JTextField();
			txtLastname.setBounds(179, 52, 149, 20);
		}
		return txtLastname;
	}

	private JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("Cambiar");
			btnSave.setText(language.getString("btnChange"));
			btnSave.setBounds(28, 123, 82, 23);
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

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancelar");
			btnCancel.setText(language.getString("btnCancel"));
			btnCancel.setBounds(274, 123, 82, 23);
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

	private void btnCancelMouseClicked(MouseEvent evt) {
		parent.setEnabled(true);
		dispose();
	}

	private void btnSaveMouseClicked(MouseEvent evt) {
		String password = new String(txtPassword.getPassword());
		Controller.getInstance().changeName(txtName.getText(),
				txtLastname.getText(), password);
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Contraseña");
			lblPassword.setText(language.getString("lblPassword"));
			lblPassword.setBounds(73, 83, 88, 20);
			lblPassword.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblPassword;
	}

	private JPasswordField getTxtPassword() {
		if (txtPassword == null) {
			txtPassword = new JPasswordField();
			txtPassword.setBounds(179, 83, 149, 20);
		}
		return txtPassword;
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

	protected void btnSaveMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnSaveMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void btnCancelMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnCancelMouseExited(MouseEvent e) {
		setDefaultCursor();
	}
}
