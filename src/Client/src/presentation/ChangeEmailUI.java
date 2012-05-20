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
public class ChangeEmailUI extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JPanel pnlBackgroun;
	private JLabel lblConfirmEmail;
	private JButton btnSave;
	private JButton btnCancel;
	private JPasswordField txtPassword;
	private JTextField txtConfirmEmail;
	private JTextField txtEmail;
	private JLabel lblPassword;
	private JLabel lblEmail;
	private ProfileUI parent;

	public ChangeEmailUI(ProfileUI parent, String email) {
		super();
		this.parent = parent;
		initGUI();
		txtEmail.setText(email);
	}
	
	private void initGUI() {
		try {
			this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			getContentPane().add(getPnlBackgroun(), BorderLayout.CENTER);
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
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private JPanel getPnlBackgroun() {
		if(pnlBackgroun == null) {
			pnlBackgroun = new JPanel();
			pnlBackgroun.setLayout(null);
			pnlBackgroun.add(getLblEmail());
			pnlBackgroun.add(getLblConfirmEmail());
			pnlBackgroun.add(getLblPassword());
			pnlBackgroun.add(getTxtEmail());
			pnlBackgroun.add(getTxtConfirmEmail());
			pnlBackgroun.add(getTxtPassword());
			pnlBackgroun.add(getBtnSave());
			pnlBackgroun.add(getBtnCancel());
		}
		return pnlBackgroun;
	}
	
	private JLabel getLblEmail() {
		if(lblEmail == null) {
			lblEmail = new JLabel();
			lblEmail.setText("Email");
			lblEmail.setBounds(73, 20, 84, 18);
			lblEmail.setFont(new java.awt.Font("Tahoma",1,11));
		}
		return lblEmail;
	}
	
	private JLabel getLblConfirmEmail() {
		if(lblConfirmEmail == null) {
			lblConfirmEmail = new JLabel();
			lblConfirmEmail.setText("Confirm email");
			lblConfirmEmail.setBounds(73, 51, 84, 18);
			lblConfirmEmail.setFont(new java.awt.Font("Tahoma",1,11));
		}
		return lblConfirmEmail;
	}
	
	private JLabel getLblPassword() {
		if(lblPassword == null) {
			lblPassword = new JLabel();
			lblPassword.setText("Password");
			lblPassword.setBounds(73, 81, 84, 18);
			lblPassword.setFont(new java.awt.Font("Tahoma",1,11));
		}
		return lblPassword;
	}
	
	private JTextField getTxtEmail() {
		if(txtEmail == null) {
			txtEmail = new JTextField();
			txtEmail.setBounds(194, 19, 145, 20);
		}
		return txtEmail;
	}
	
	private JTextField getTxtConfirmEmail() {
		if(txtConfirmEmail == null) {
			txtConfirmEmail = new JTextField();
			txtConfirmEmail.setBounds(194, 50, 145, 20);
		}
		return txtConfirmEmail;
	}
	
	private JPasswordField getTxtPassword() {
		if(txtPassword == null) {
			txtPassword = new JPasswordField();
			txtPassword.setBounds(194, 81, 145, 20);
		}
		return txtPassword;
	}
	
	private JButton getBtnSave() {
		if(btnSave == null) {
			btnSave = new JButton();
			btnSave.setText("Save");
			btnSave.setBounds(73, 121, 57, 23);
			btnSave.setFocusable(false);
			btnSave.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnSaveMouseClicked(evt);
				}
			});
		}
		return btnSave;
	}
	
	private JButton getBtnCancel() {
		if(btnCancel == null) {
			btnCancel = new JButton();
			btnCancel.setText("Cancel");
			btnCancel.setBounds(234, 121, 65, 23);
			btnCancel.setFocusable(false);
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
		parent.toFront();
		dispose();
	}
	
	private void btnSaveMouseClicked(MouseEvent evt) {
		String password = new String(txtPassword.getPassword());
		Controller.getInstance().changeEmail(txtEmail.getText(),txtConfirmEmail.getText(),password);
	}
	
	private void thisWindowClosing(WindowEvent evt) {
		parent.setEnabled(true);
		dispose();
	}

}
