package presentation;
import java.awt.BorderLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
@SuppressWarnings("serial")
public class GameWaitingRoomUI extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

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
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			getContentPane().add(getPnlBackground(), BorderLayout.CENTER);
			pack();
			this.setSize(600, 456);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private JPanel getPnlBackground() {
		if(pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setLayout(null);
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
			btnSend.setBounds(505, 386, 65, 21);
		}
		return btnSend;
	}
	
	private JTextField getTxtMessage() {
		if(txtMessage == null) {
			txtMessage = new JTextField();
			txtMessage.setBounds(15, 386, 475, 20);
		}
		return txtMessage;
	}
	
	private JScrollPane getPnlChat() {
		if(pnlChat == null) {
			pnlChat = new JScrollPane();
			pnlChat.setBounds(15, 249, 475, 126);
			pnlChat.setViewportView(getTxtChat());
		}
		return pnlChat;
	}
	
	private JTextArea getTxtChat() {
		if(txtChat == null) {
			txtChat = new JTextArea();
			txtChat.setPreferredSize(new java.awt.Dimension(470, 124));
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
			lstPlayerType.setBounds(135, 26, 91, 20);
		}
		return lstPlayerType;
	}
	
	private JLabel getLblPlayerName() {
		if(lblPlayerName == null) {
			lblPlayerName = new JLabel();
			lblPlayerName.setText("Player name");
			lblPlayerName.setBounds(15, 26, 72, 20);
		}
		return lblPlayerName;
	}

}
