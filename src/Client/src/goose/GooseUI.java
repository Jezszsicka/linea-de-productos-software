package goose;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import presentation.GameUI;

import logic.Controller;
import model.Game;
import ProductLine.UserNotInGameException;

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
public class GooseUI extends javax.swing.JFrame implements GameUI{
	private JPanel pnlBackground;
	private JTextPane txtChat;
	private JScrollPane pnlChat;
	private JTextField txtMessage;
	private JButton btnQuit;
	private JPanel pnlBoard;
	private JLabel lblAvatarBlack;
	
	
	private HTMLEditorKit htmlEditor;
	private HTMLDocument chatText;

	private String destinatary;
	private String username;
	private Game game;

	public GooseUI(String username, Game game) {
		super();
		this.username = username;
		this.game = game;
		destinatary = "";
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getPnlBackground());
		pack();
		this.setSize(762, 661);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private JPanel getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setLayout(null);
			pnlBackground.setBounds(0, 0, 746, 623);
			pnlBackground.add(getLblAvatarBlack());
			pnlBackground.add(getPnlBoard());
			pnlBackground.add(getBtnQuit());
			pnlBackground.add(getTxtMessage());
			pnlBackground.add(getPnlChat());
		}
		return pnlBackground;
	}

	private JLabel getLblAvatarBlack() {
		if (lblAvatarBlack == null) {
			lblAvatarBlack = new JLabel();
			lblAvatarBlack.setBounds(635, 11, 101, 124);
			lblAvatarBlack.setBorder(new SoftBevelBorder(BevelBorder.LOWERED,
					null, null, null, null));
		}
		return lblAvatarBlack;
	}

	private JPanel getPnlBoard() {
		if (pnlBoard == null) {
			pnlBoard = new JPanel();
			pnlBoard.setLayout(null);
			pnlBoard.setBounds(10, 11, 615, 430);
			pnlBoard.setBorder(BorderFactory.createTitledBorder(""));
		}
		return pnlBoard;
	}
	
	private JButton getBtnQuit() {
		if(btnQuit == null) {
			btnQuit = new JButton();
			btnQuit.setText("Quit");
			btnQuit.setBounds(650, 589, 86, 23);
		}
		return btnQuit;
	}
	
	private JTextField getTxtMessage() {
		if(txtMessage == null) {
			txtMessage = new JTextField();
			txtMessage.setText(null);
			txtMessage.setBounds(10, 592, 615, 20);
			txtMessage.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent evt) {
					txtMessageKeyPressed(evt);
				}
			});
		}
		return txtMessage;
	}
	
	private void txtMessageKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == 10 && txtMessage.getText().length() > 0)
			sendMessage();
	}

	private void sendMessage() {
		String message = txtMessage.getText();
		if (message.startsWith("\"")) {
			String[] splitMessage = message.split(" ");
			destinatary = splitMessage[0].substring(1);
			if (!destinatary.equalsIgnoreCase(username)) {
				String privateMessage = message.split(destinatary)[1];
				try {
					Controller.getInstance().sendGamePrivateMessage(
							game.getName(), username, destinatary,
							privateMessage);
					try {
						htmlEditor.insertHTML(chatText, chatText.getLength(),
								"<font color=\"red\"><b> >" + destinatary
										+ ":</b>" + privateMessage + "</font>",
								0, 0, null);
					} catch (BadLocationException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} catch (UserNotInGameException e1) {
					try {
						htmlEditor.insertHTML(chatText, chatText.getLength(),
								"<font color=\"gray\"><b>" + destinatary
										+ " is not in game</b></font>", 0, 0,
								null);
					} catch (BadLocationException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				try {
					htmlEditor
							.insertHTML(
									chatText,
									chatText.getLength(),
									"<font color=\"gray\"><b>You can't send a message to yourself</b></font>",
									0, 0, null);
				} catch (BadLocationException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			Controller.getInstance().sendGameMessage(game.getName(), message);
			try {
				htmlEditor.insertHTML(chatText, chatText.getLength(), "<b>"
						+ username + ":</b> " + message, 0, 0, null);
			} catch (BadLocationException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		txtMessage.setText(null);
	}

	public void receiveMessage(String sender, String message) {
		try {
			htmlEditor.insertHTML(chatText, chatText.getLength(), "<b>"
					+ sender + ":</b> " + message, 0, 0, null);
			txtChat.setCaretPosition(txtChat.getDocument().getLength());
		} catch (BadLocationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void receivePrivateMessage(String sender, String message) {
		destinatary = sender;
		try {
			htmlEditor.insertHTML(chatText, chatText.getLength(),
					"<font color=\"red\"><b> &lt;" + sender + ":</b>" + message
							+ "</font>", 0, 0, null);
		} catch (BadLocationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateBoard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lostGame() {
		// TODO Auto-generated method stub
		
	}
	
	private JScrollPane getPnlChat() {
		if(pnlChat == null) {
			pnlChat = new JScrollPane();
			pnlChat.setBounds(10, 452, 615, 129);
			pnlChat.setViewportView(getTxtChat());
		}
		return pnlChat;
	}
	
	private JTextPane getTxtChat() {
		if(txtChat == null) {
			txtChat = new JTextPane();
			txtChat.setEditable(false);
			htmlEditor = new HTMLEditorKit();
			chatText = new HTMLDocument();
			txtChat.setEditorKit(htmlEditor);
			txtChat.setDocument(chatText);
		}
		return txtChat;
	}

}
