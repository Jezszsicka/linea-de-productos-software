package presentation;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
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
public class ChangeNameUI extends javax.swing.JFrame {
	private JPanel pnglBackground;
	private JTextField txtName;
	private JButton btnCancel;
	private JButton btnSave;
	private JTextField txtLastname;
	private JLabel lblLastName;
	private JLabel lblName;
	private ProfileUI parent;

	public ChangeNameUI(ProfileUI parent, String name, String lastname) {
		super();
		this.parent = parent;
		initGUI();
		txtName.setText(name);
		txtLastname.setText(lastname);
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().add(getPnglBackground(), BorderLayout.CENTER);
			pack();
			this.setSize(356, 166);
			setVisible(true);
			setLocationRelativeTo(null);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private JPanel getPnglBackground() {
		if(pnglBackground == null) {
			pnglBackground = new JPanel();
			pnglBackground.setLayout(null);
			pnglBackground.setPreferredSize(new java.awt.Dimension(474, 130));
			pnglBackground.add(getLblName());
			pnglBackground.add(getLblLastName());
			pnglBackground.add(getTxtName());
			pnglBackground.add(getTxtLastname());
			pnglBackground.add(getBtnSave());
			pnglBackground.add(getBtnCancel());
		}
		return pnglBackground;
	}
	
	private JLabel getLblName() {
		if(lblName == null) {
			lblName = new JLabel();
			lblName.setText("Name");
			lblName.setBounds(67, 24, 88, 20);
			lblName.setFont(new java.awt.Font("Tahoma",1,11));
		}
		return lblName;
	}
	
	private JLabel getLblLastName() {
		if(lblLastName == null) {
			lblLastName = new JLabel();
			lblLastName.setText("Last Name");
			lblLastName.setBounds(67, 55, 88, 20);
			lblLastName.setFont(new java.awt.Font("Tahoma",1,11));
		}
		return lblLastName;
	}
	
	private JTextField getTxtName() {
		if(txtName == null) {
			txtName = new JTextField();
			txtName.setBounds(173, 24, 123, 20);
		}
		return txtName;
	}
	
	private JTextField getTxtLastname() {
		if(txtLastname == null) {
			txtLastname = new JTextField();
			txtLastname.setBounds(173, 55, 123, 20);
		}
		return txtLastname;
	}
	
	private JButton getBtnSave() {
		if(btnSave == null) {
			btnSave = new JButton();
			btnSave.setText("Save");
			btnSave.setBounds(67, 94, 68, 23);
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
			btnCancel.setBounds(199, 94, 68, 23);
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
		Controller.getInstance().changeName(txtName.getText(),txtLastname.getText());
		parent.refreshName();
		dispose();
	}

}
