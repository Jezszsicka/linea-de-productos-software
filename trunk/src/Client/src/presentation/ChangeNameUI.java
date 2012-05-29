package presentation;

import java.awt.BorderLayout;
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

import domain.Controller;
import domain.LanguageManager;

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
		try {
			this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			getContentPane().add(getPnglBackground(), BorderLayout.CENTER);
			pack();
			this.setSize(400, 200);
			setVisible(true);
			setLocationRelativeTo(null);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
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
			btnSave.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnSaveMouseClicked(evt);
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
			btnCancel.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnCancelMouseClicked(evt);
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

}
