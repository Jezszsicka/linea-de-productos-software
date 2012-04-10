package presentation;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import domain.Facade;
import domain.SessionManager;


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
public class WaitingRoomUI extends javax.swing.JFrame{
	private JPanel pnlBackground;
	private JButton btnProfile;
	private JTextArea txtChatUsers;
	private JScrollPane pnlChatUsers;
	private JButton btnJoinGame;
	private JButton btnSend;
	private JButton btnCreateGame;
	private JButton btnExit;
	private JTextField txtMessage;
	private JScrollPane pnlChat;
	private JTextArea txtChat;

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WaitingRoomUI() {
		super();
		initGUI();
	}

	public WaitingRoomUI(List<String> users){
		super();
		initGUI();
		String userList = null;
		for(String user : users)
			userList += user+"\n";
		txtChatUsers.setText(userList);
	}
	
	private void initGUI() {
		setSize(new Dimension(700, 500));
		setBounds(new Rectangle(0, 0, 700, 500));
		getContentPane().setLayout(null);
		getContentPane().add(getPnlBackground());
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private JPanel getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setBounds(0, 0, 684, 462);
			pnlBackground.setLayout(null);
			pnlBackground.add(getBtnSend());
			pnlBackground.add(getBtnCreateGame());
			pnlBackground.add(getBtnExit());
			pnlBackground.add(getTxtMessage());
			pnlBackground.add(getPnlChat());
			pnlBackground.add(getBtnJoinGame());
			pnlBackground.add(getPnlChatUsers());
			pnlBackground.add(getBtnProfile());
		}
		return pnlBackground;
	}

	private JButton getBtnSend() {
		if (btnSend == null) {
			btnSend = new JButton("Send");
			btnSend.setBounds(413, 413, 64, 23);
			btnSend.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnSendMouseClicked(evt);
				}
			});
		}
		return btnSend;
	}

	private JButton getBtnCreateGame() {
		if (btnCreateGame == null) {
			btnCreateGame = new JButton("Create game");
			btnCreateGame.setBounds(87, 11, 104, 23);
			btnCreateGame.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					btnCreateGameMouseClicked(e);
				}
			});
		}
		return btnCreateGame;
	}

	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("Exit");
			btnExit.setBounds(585, 413, 89, 23);
			btnExit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					btnExitMouseClicked(e);
				}
			});
		}
		return btnExit;
	}

	private JTextField getTxtMessage() {
		if (txtMessage == null) {
			txtMessage = new JTextField();
			txtMessage.setBounds(23, 414, 380, 20);
			txtMessage.setColumns(10);
		}
		return txtMessage;
	}

	private JScrollPane getPnlChat() {
		if (pnlChat == null) {
			pnlChat = new JScrollPane();
			pnlChat.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			pnlChat.setBounds(23, 54, 454, 349);
			pnlChat.setViewportView(getTxtChat());
		}
		return pnlChat;
	}

	private JTextArea getTxtChat() {
		if (txtChat == null) {
			txtChat = new JTextArea();
			txtChat.setInheritsPopupMenu(true);
			txtChat.setLineWrap(true);
			txtChat.setBounds(500, 54, 147, 291);
		}
		return txtChat;
	}
	
	private JButton getBtnJoinGame() {
		if(btnJoinGame == null) {
			btnJoinGame = new JButton();
			btnJoinGame.setText("Join game");
			btnJoinGame.setBounds(249, 11, 87, 23);
		}
		return btnJoinGame;
	}
	
	private JScrollPane getPnlChatUsers() {
		if(pnlChatUsers == null) {
			pnlChatUsers = new JScrollPane();
			pnlChatUsers.setBounds(522, 54, 152, 348);
			pnlChatUsers.setViewportView(getTxtChatUsers());
		}
		return pnlChatUsers;
	}
	
	private JTextArea getTxtChatUsers() {
		if(txtChatUsers == null) {
			txtChatUsers = new JTextArea();
		}
		return txtChatUsers;
	}

	protected void btnCreateGameMouseClicked(MouseEvent evt) {
		Facade.getInstance().startCreateGame();
	}

	protected void btnExitMouseClicked(MouseEvent evt) {
		int option = JOptionPane.showConfirmDialog(this,
				"Are you sure you want to exit?", "Are you sure?",
				JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION) {
			Facade.getInstance().logoutUser();
			dispose();
		}
	}

	
	private void btnSendMouseClicked(MouseEvent evt) {
		String message = txtMessage.getText();
		Facade.getInstance().sendGeneralMessage(message);
		txtChat.setText(txtChat.getText()+SessionManager.getInstance().getSession().getUsername()+": "+txtMessage.getText()+"\n");
		txtMessage.setText(null);
	}
	
	private JButton getBtnProfile() {
		if(btnProfile == null) {
			btnProfile = new JButton();
			btnProfile.setText("Profile");
			btnProfile.setBounds(601, 11, 63, 23);
		}
		return btnProfile;
	}

	public void receiveMessage(String sender, String message) {
		txtChat.setText(sender+": "+txtChat.getText()+message+"\n");
	}

	public void userLogged(String user) {
		txtChat.setText(txtChat.getText()+user+" has joined\n");
		txtChatUsers.setText(txtChatUsers.getText()+user+"\n");
	}
	
	public void userLeave(String user){
		txtChat.setText(txtChat.getText()+user+" has left\n");
		
	}

}
