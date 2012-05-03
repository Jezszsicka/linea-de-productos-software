package presentation;
import java.awt.BorderLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.WindowConstants;


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
public class GameWaitingRoomUI extends javax.swing.JFrame {
	private JPanel pnlBackground;
	private JLabel lblPlayerName;
	private JComboBox lstPlayerType;
	private JTextArea txtChat;
	private JScrollPane pnlChat;
	private JTextField txtMessage;
	private JButton btnSend;

	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public GameWaitingRoomUI() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			getContentPane().add(getPnlBackground(), "Center");
			pack();
			this.setSize(781, 456);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private JPanel getPnlBackground() {
		if(pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setLayout(null);
			pnlBackground.setBounds(0, 0, 765, 418);
			pnlBackground.add(getBtnSend());
			pnlBackground.add(getTxtMessage());
			pnlBackground.add(getPnlChat());
			pnlBackground.add(getLstPlayerType());
			pnlBackground.add(getLblPlayerName());
		}
		return pnlBackground;
	}
	
	private JButton getBtnSend() {
		if(btnSend == null) {
			btnSend = new JButton();
			btnSend.setText("Send");
			btnSend.setBounds(505, 356, 65, 21);
		}
		return btnSend;
	}
	
	private JTextField getTxtMessage() {
		if(txtMessage == null) {
			txtMessage = new JTextField();
			txtMessage.setBounds(15, 356, 475, 20);
		}
		return txtMessage;
	}
	
	private JScrollPane getPnlChat() {
		if(pnlChat == null) {
			pnlChat = new JScrollPane();
			pnlChat.setBounds(15, 141, 738, 195);
			pnlChat.setViewportView(getTxtChat());
		}
		return pnlChat;
	}
	
	private JTextArea getTxtChat() {
		if(txtChat == null) {
			txtChat = new JTextArea();
		}
		return txtChat;
	}
	
	private JComboBox getLstPlayerType() {
		if(lstPlayerType == null) {
			ComboBoxModel lstPlayerTypeModel = 
					new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });
			lstPlayerType = new JComboBox();
			lstPlayerType.setModel(lstPlayerTypeModel);
			lstPlayerType.setBounds(135, 95, 91, 20);
		}
		return lstPlayerType;
	}
	
	private JLabel getLblPlayerName() {
		if(lblPlayerName == null) {
			lblPlayerName = new JLabel();
			lblPlayerName.setText("Player name");
			lblPlayerName.setBounds(15, 95, 72, 20);
		}
		return lblPlayerName;
	}

}
