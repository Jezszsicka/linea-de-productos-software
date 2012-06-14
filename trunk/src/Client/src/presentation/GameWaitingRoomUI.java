package presentation;
import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import logic.Controller;
import logic.Utils;
import model.Game;
import model.User;
import ProductLine.UserNotInGameException;


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
	private JTextPane txtGameDescription;
	private JLabel lblDescription;
	private JLabel lblName;
	private JLabel lblGameName;
	private JButton btnCancel;
	private JButton btnStartGame;
	private JLabel lblGameImage;
	private JLabel lblGame;
	private JPanel pnlGame;
	private JTextPane txtChat;
	private JPanel pnlPlayers;
	private JScrollPane pnlChat;
	private JTextField txtMessage;

	private String destinatary;
	private HTMLEditorKit htmlEditor;
	private HTMLDocument chatText;
	private User user;
	private Game game;
	private List<PlayerPanel> playerPanels;
		
	public GameWaitingRoomUI(User user,Game game) {
		super();
		this.user = user;
		this.game = game;
		playerPanels = new ArrayList<PlayerPanel>();
		initGUI();
		setVisible(true);
		setLocationRelativeTo(null);
		PlayerPanel creator = new PlayerPanel(user);
		creator.setBounds(2, 2, 361, 56);
		pnlPlayers.add(creator);
		playerPanels.add(creator);
		destinatary = "";
		for(int i = 1 ; i<game.getMaxPlayers();i++){
			PlayerPanel player = new PlayerPanel();
			player.setBounds(2, 2+i*56, 361, 56);
			pnlPlayers.add(player);
		}
	} 
	
	private void initGUI() {
		try {
			this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			getContentPane().add(getPnlBackground(), BorderLayout.CENTER);
			pack();
			this.setSize(677, 456);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private JPanel getPnlBackground() {
		if(pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setLayout(null);
			pnlBackground.add(getTxtMessage());
			pnlBackground.add(getPnlChat());
			pnlBackground.add(getPnlPlayers());
			pnlBackground.add(getPnlGame());
			pnlBackground.add(getBtnStartGame());
			pnlBackground.add(getBtnCancel());
		}
		return pnlBackground;
	}

	private JTextField getTxtMessage() {
		if(txtMessage == null) {
			txtMessage = new JTextField();
			txtMessage.setBounds(10, 386, 365, 20);
			txtMessage.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent evt) {
					txtMessageKeyPressed(evt);
				}
			});
		}
		return txtMessage;
	}
	
	private JScrollPane getPnlChat() {
		if(pnlChat == null) {
			pnlChat = new JScrollPane();
			pnlChat.setBounds(10, 273, 365, 107);
			pnlChat.setViewportView(getTxtChat());
		}
		return pnlChat;
	}

	private JPanel getPnlPlayers() {
		if(pnlPlayers == null) {
			pnlPlayers = new JPanel();
			pnlPlayers.setLayout(null);
			pnlPlayers.setBounds(10, 16, 365, 246);
			pnlPlayers.setBorder(BorderFactory.createTitledBorder(""));
		}
		return pnlPlayers;
	}
	
	private JTextPane getTxtChat() {
		if(txtChat == null) {
			txtChat = new JTextPane();
			txtChat.setPreferredSize(new java.awt.Dimension(330, 124));
			htmlEditor = new HTMLEditorKit();
			chatText = new HTMLDocument();
			txtChat.setEditorKit(htmlEditor);
			txtChat.setDocument(chatText);
		}
		return txtChat;
	}
	
	private JPanel getPnlGame() {
		if(pnlGame == null) {
			pnlGame = new JPanel();
			pnlGame.setBorder(BorderFactory.createTitledBorder(""));
			pnlGame.setLayout(null);
			pnlGame.setBounds(385, 16, 265, 246);
			pnlGame.add(getJLabel4());
			pnlGame.add(getLblGameImage());
			pnlGame.add(getLblDescription());
			pnlGame.add(getTxtGameDescription());
			pnlGame.add(getLblGameName());
			pnlGame.add(getLblName());
		}
		return pnlGame;
	}
	
	private JLabel getJLabel4() {
		if(lblGame == null) {
			lblGame = new JLabel();
			lblGame.setText("Damas");
			lblGame.setHorizontalAlignment(SwingConstants.CENTER);
			lblGame.setFont(new java.awt.Font("Tahoma",1,11));
			lblGame.setBounds(2, 33, 261, 19);
			lblGame.setFocusTraversalPolicyProvider(true);
		}
		return lblGame;
	}
	
	private JLabel getLblGameImage() {
		if(lblGameImage == null) {
			lblGameImage = new JLabel();
			lblGameImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblGameImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/3D_Checkers_icon.png")));
			lblGameImage.setBounds(2, 57, 261, 60);
		}
		return lblGameImage;
	}

	private JLabel getLblDescription() {
		if(lblDescription == null) {
			lblDescription = new JLabel();
			lblDescription.setText("Descripción:");
			lblDescription.setFont(new java.awt.Font("Tahoma",1,11));
			lblDescription.setBounds(12, 129, 74, 14);
		}
		return lblDescription;
	}
	
	private JTextPane getTxtGameDescription() {
		if(txtGameDescription == null) {
			txtGameDescription = new JTextPane();
			txtGameDescription.setText("Las damas es un juego de mesa para dos contrincantes. El juego consiste en mover las piezas en diagonal a través de los cuadros negros de un tablero de ajedrez con la intención de capturar (comer) las piezas del contrario saltando por encima de ellas.");
			txtGameDescription.setEditable(false);
			txtGameDescription.setBackground(new java.awt.Color(240,240,240));
			txtGameDescription.setFocusable(false);
			txtGameDescription.setBounds(12, 145, 234, 87);
		}
		return txtGameDescription;
	}

	private JButton getBtnStartGame() {
		if(btnStartGame == null) {
			btnStartGame = new JButton();
			btnStartGame.setText("Empezar juego");
			btnStartGame.setBounds(548, 356, 103, 23);
			btnStartGame.setFocusable(false);
			btnStartGame.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnStartGameMouseClicked(evt);
				}
			});
		}
		return btnStartGame;
	}
	
	private JButton getBtnCancel() {
		if(btnCancel == null) {
			btnCancel = new JButton();
			btnCancel.setText("Cancelar");
			btnCancel.setBounds(548, 385, 103, 23);
			btnCancel.setFocusable(false);
			btnCancel.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnCancelMouseClicked(evt);
				}
			});
		}
		return btnCancel;
	}

	private JLabel getLblGameName() {
		if(lblGameName == null) {
			lblGameName = new JLabel();
			lblGameName.setText("Nombre de la partida:");
			lblGameName.setBounds(12, 13, 127, 14);
			lblGameName.setFont(new java.awt.Font("Tahoma",1,11));
		}
		return lblGameName;
	}

	private JLabel getLblName() {
		if(lblName == null) {
			lblName = new JLabel();
			lblName.setText("Partidaca");
			lblName.setBounds(149, 13, 114, 14);
		}
		return lblName;
	}
	
	private void btnCancelMouseClicked(MouseEvent evt) {
		Controller.getInstance().cancelGame(game.getName());
	}
	
	private void btnStartGameMouseClicked(MouseEvent evt) {
		//TODO
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
			if (!destinatary.equalsIgnoreCase(user.getUsername())) {
				String privateMessage = message.split(destinatary)[1];
				try {
					Controller.getInstance().sendGamePrivateMessage(game.getName(),
							user.getUsername(), destinatary, privateMessage);
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
										+ " is not in game</b></font>", 0, 0, null);
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
			Controller.getInstance().sendGameMessage(game.getName(),message);
			try {
				htmlEditor.insertHTML(chatText, chatText.getLength(), "<b>"
						+ user.getUsername() + ":</b> " + message, 0, 0, null);
			} catch (BadLocationException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		txtMessage.setText(null);
		txtChat.setCaretPosition(txtChat.getDocument().getLength());
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
			txtChat.setCaretPosition(txtChat.getDocument().getLength());
		} catch (BadLocationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private class PlayerPanel extends JPanel{
		private JLabel lblAvatar;
		private JLabel lblPlayer;
		private JLabel lblCountry;
		private JComboBox<String> playerType;
		
		public PlayerPanel(){
			add(getLblAvatar());
			add(getLblCountry());
			add(getLblPlayer());
			add(getPlayerType());
			setLayout(null);
		}
		
		public PlayerPanel(User player){
			add(getLblAvatar());
			add(getLblCountry());
			add(getLblPlayer());
			add(getPlayerType());
			lblAvatar.setIcon(new ImageIcon(user.getAvatar()));
			lblPlayer.setText(player.getUsername());
			lblCountry.setIcon(new ImageIcon(getClass().getClassLoader()
						.getResource(Utils.countrySmallImgPath(player.getCountry()))));
			setLayout(null);
		}
		
		private JLabel getLblAvatar() {
			if(lblAvatar == null) {
				lblAvatar = new JLabel();
				lblAvatar.setBounds(19, 11, 41, 34);
			}
			return lblAvatar;
		}
		
		private JLabel getLblPlayer() {
			if(lblPlayer == null) {
				lblPlayer = new JLabel();
				lblPlayer.setBounds(79, 19, 81, 20);
			}
			return lblPlayer;
		}
		
		private JLabel getLblCountry() {
			if(lblCountry == null) {
				lblCountry = new JLabel();
				lblCountry.setBounds(178, 18, 26, 20);
			}
			return lblCountry;
		}
		
		private JComboBox<String> getPlayerType() {
			if(playerType == null) {
				ComboBoxModel<String> playerTypeModel = 
						new DefaultComboBoxModel<String>(
								new String[] { "Jugador", "Ordenador","Cerrada" });
				playerType = new JComboBox<String>();
				playerType.setModel(playerTypeModel);
				playerType.setBounds(246, 19, 97, 20);
			}
			return playerType;
		}
	}


}




