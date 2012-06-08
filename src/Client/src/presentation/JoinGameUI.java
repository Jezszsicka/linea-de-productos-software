package presentation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import logic.Controller;



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
public class JoinGameUI extends javax.swing.JFrame {
	private JPanel pnlFondo;
	private JButton btnJoin;
	private JButton btnCancel;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

		
	public JoinGameUI() {
		super();
		initGUI();
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	private void initGUI() {
		try {
			this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			getContentPane().setLayout(null);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			getContentPane().add(getPnlFondo());
			pack();
			this.setSize(538, 362);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private JPanel getPnlFondo() {
		if(pnlFondo == null) {
			pnlFondo = new JPanel();
			pnlFondo.setLayout(null);
			pnlFondo.setBounds(0, 0, 522, 324);
			pnlFondo.add(getBtnJoin());
			pnlFondo.add(getBtnCancel());
		}
		return pnlFondo;
	}
	
	private JButton getBtnJoin() {
		if(btnJoin == null) {
			btnJoin = new JButton();
			btnJoin.setText("Join game");
			btnJoin.setBounds(69, 261, 81, 23);
		}
		return btnJoin;
	}
	
	private JButton getBtnCancel() {
		if(btnCancel == null) {
			btnCancel = new JButton();
			btnCancel.setText("Cancel");
			btnCancel.setBounds(377, 261, 65, 23);
			btnCancel.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnCancelMouseClicked(evt);
				}
			});
		}
		return btnCancel;
	}
	
	private void btnCancelMouseClicked(MouseEvent evt) {
		Controller.getInstance().closeJoinGameUI();
	}
	
	private void thisWindowClosing(WindowEvent evt) {
		Controller.getInstance().closeJoinGameUI();
	}

}
