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
public class ChangePasswordUI extends javax.swing.JFrame {
	private JPanel pnlBackground;
	private JLabel lblPassword;
	private JPasswordField txtPassword;
	private JLabel lblNewPassword;
	private JPasswordField txtNewPassword;
	private JLabel lblConfirmPassword;
	private JPasswordField txtConfirmPassword;
	private JButton btnSave;
	private JButton btnCancel;
	private ProfileUI parent;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	public ChangePasswordUI(ProfileUI parent) {
		super();
		this.parent = parent;
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			getContentPane().add(getPnlBackground(), BorderLayout.CENTER);
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
	
	private JPanel getPnlBackground() {
		if(pnlBackground == null) {
			pnlBackground = new JPanel();
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
	
	private JPasswordField getTxtConfirmPassword() {
		if(txtConfirmPassword == null) {
			txtConfirmPassword = new JPasswordField();
			txtConfirmPassword.setBounds(194, 81, 145, 20);
		}
		return txtConfirmPassword;
	}
	
	private JLabel getLblConfirmPassword() {
		if(lblConfirmPassword == null) {
			lblConfirmPassword = new JLabel();
			lblConfirmPassword.setText("Confirm password");
			lblConfirmPassword.setFont(new java.awt.Font("Tahoma",1,11));
			lblConfirmPassword.setBounds(47, 81, 110, 18);
		}
		return lblConfirmPassword;
	}
	
	private JPasswordField getTxtNewPassword() {
		if(txtNewPassword == null) {
			txtNewPassword = new JPasswordField();
			txtNewPassword.setBounds(194, 50, 145, 20);
		}
		return txtNewPassword;
	}
	
	private JLabel getLblNewPassword() {
		if(lblNewPassword == null) {
			lblNewPassword = new JLabel();
			lblNewPassword.setText("New password");
			lblNewPassword.setFont(new java.awt.Font("Tahoma",1,11));
			lblNewPassword.setBounds(47, 51, 110, 18);
		}
		return lblNewPassword;
	}
	
	private JPasswordField getTxtPassword() {
		if(txtPassword == null) {
			txtPassword = new JPasswordField();
			txtPassword.setBounds(194, 19, 145, 20);
		}
		return txtPassword;
	}
	
	private JLabel getLblPassword() {
		if(lblPassword == null) {
			lblPassword = new JLabel();
			lblPassword.setText("Password");
			lblPassword.setFont(new java.awt.Font("Tahoma",1,11));
			lblPassword.setBounds(47, 20, 110, 18);
		}
		return lblPassword;
	}
	
	private void btnSaveMouseClicked(MouseEvent evt) {
		String password = new String(txtPassword.getPassword());
		String newPassword = new String(txtNewPassword.getPassword());
		String confirmPassword = new String(txtConfirmPassword.getPassword());
		Controller.getInstance().changePassword(password,newPassword,confirmPassword);
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

}
