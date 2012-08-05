package presentation;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import utils.Utils;

import logic.Controller;
import model.Game;
import model.User;
import ProductLine.NotEnoughPlayersException;
import ProductLine.Slot;
import ProductLine.UserNotInGameException;
import ProductLine.SlotState;

@SuppressWarnings("serial")
public class GameWaitingRoomUI extends javax.swing.JFrame {

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static final int userIconLabelWidth = 38;
	private static final int userIconLabelHeight = 45;

	private JPanel pnlBackground;
	private JTextPane txtGameDescription;
	private JLabel lblDescription;
	private JScrollPane pnlPlayersScroll;
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
	private String username;
	private Game game;
	private List<PlayerPanel> playerPanels;
	private boolean creator;

	public GameWaitingRoomUI(String username, Game game, boolean creator) {
		super();
		this.username = username;
		this.game = game;
		this.creator = creator;
		playerPanels = new ArrayList<PlayerPanel>();
		initGUI();
		setVisible(true);
		setLocationRelativeTo(null);
		destinatary = "";
		initPlayers();
		lblName.setText(game.getName());
		switch (game.getTypeGame()) {
		case Checkers:
			checkersSelected();
			break;
		case Chess:
			chessSelected();
			break;
		case Connect4:
			connect4Selected();
			break;
		case Goose:
			gooseSelected();
		case Ludo:
			ludoSelected();
		}

	}

	private void checkersSelected() {
		lblGame.setText("Damas");
		txtGameDescription
				.setText("Las damas es un juego de mesa para dos contrincantes. El juego consiste en mover las piezas en diagonal a través de los cuadros negros de un tablero de ajedrez con la intención de capturar (comer) las piezas del contrario saltando por encima de ellas.");
		lblGameImage.setIcon(new ImageIcon(GameWaitingRoomUI.class
				.getResource("/images/Games/checkers_icon.png")));
	}

	private void chessSelected() {
		lblGame.setText("Ajedrez");
		txtGameDescription
				.setText("El ajedrez es un juego competitivo entre dos personas, cada una de las cuales dispone de 16 piezas móviles que se colocan sobre un tablero dividido en 64 escaques.");
		lblGameImage.setIcon(new ImageIcon(GameWaitingRoomUI.class
				.getResource("/images/Games/chess_icon.png")));

		for (PlayerPanel pnl : playerPanels) {
			JComboBox<String> box = pnl.getPlayerType();
			ComboBoxModel<String> playerTypeModel = new DefaultComboBoxModel<String>(
					new String[] { "Jugador", "Cerrada" });
			box.setModel(playerTypeModel);
		}

	}

	private void connect4Selected() {
		lblGame.setText("Conecta 4");
		txtGameDescription
				.setText("Conecta 4 es un juego de mesa para dos contrincantes. El juego consiste en mover las piezas en diagonal a través de los cuadros negros de un tablero de ajedrez con la intención de capturar (comer) las piezas del contrario saltando por encima de ellas.");
		lblGameImage.setIcon(new ImageIcon(GameWaitingRoomUI.class
				.getResource("/images/Games/connect4_icon.png")));
	}

	private void gooseSelected() {
		lblGame.setText("Juego de la oca");
		txtGameDescription
				.setText("El juego de la oca es un juego de mesa en el que cada jugador avanza su ficha por un tablero con 63 casillas con dibujos. Dependiendo de la casilla en la que se caiga se puede avanzar o por el contrario retroceder y en algunas de ellas está indicado un castigo. En su turno cada jugador tira el dado que le indica el número de casillas que debe avanzar. Gana el juego el primer jugador que llega a la casilla 63, el jardín de la oca.");
		lblGameImage.setIcon(new ImageIcon(GameWaitingRoomUI.class
				.getResource("/images/Games/goose_icon.png")));
	}

	private void ludoSelected() {
		lblGame.setText("Parchís");
		txtGameDescription
				.setText("El parchís es un juego de mesa que se juega con 1 dado y 4 fichas para cada uno de los jugadores. El objeto del juego es que cada jugador lleve sus fichas desde la salida hasta la meta intentando, en el camino, comerse a las demás. El primero en conseguirlo será el ganador.");
		lblGameImage.setIcon(new ImageIcon(GameWaitingRoomUI.class
				.getResource("/images/Games/ludo_icon.png")));
	}

	private void initPlayers() {
		int size = 0;
		PlayerPanel playerPanel = null;
		for (int i = 0; i < game.getSlots().size(); i++) {
			Slot slot = game.getSlots().get(i);
			switch (slot.getType()) {
			case Human:
				User user = Controller.getInstance().searchUser(
						slot.getPlayer());
				playerPanel = new PlayerPanel(user, i);
				break;
			case Empty:
				playerPanel = new PlayerPanel(i, SlotState.Empty);
				break;
			case Computer:
				playerPanel = new PlayerPanel(i, SlotState.Computer);
				break;
			case Closed:
				playerPanel = new PlayerPanel(i, SlotState.Closed);
				break;
			}
			playerPanel.setLocation(2, 2 + i * 57);
			playerPanel.setBorder(BorderFactory.createTitledBorder(""));
			pnlPlayers.add(playerPanel);
			playerPanels.add(playerPanel);
			size += 57;
		}

		if (size > pnlPlayersScroll.getHeight()) {
			for (PlayerPanel panel : playerPanels) {
				panel.setPreferredSize(new Dimension(panel.getWidth() - 15,
						panel.getHeight()));
				panel.setSize(panel.getWidth() - 15, panel.getHeight());
				JComboBox<String> playerType = panel.getPlayerType();
				playerType.setLocation(playerType.getX() - 15,
						playerType.getY());
				panel.repaint();
			}

		}

		pnlPlayers.setPreferredSize(new Dimension(pnlPlayers.getWidth(), size));
		pnlPlayers.setSize(pnlPlayers.getWidth(), size);
		pnlPlayers.repaint();

	}

	private void refreshPlayers() {
		for (int i = 0; i < game.getSlots().size(); i++) {
			Slot slot = game.getSlot(i);
			PlayerPanel playerPanel = playerPanels.get(i);
			switch (slot.getType()) {
			case Human:
				User user = Controller.getInstance().searchUser(
						slot.getPlayer());
				playerPanel.setPlayer(user.getUsername());

				if (user.getAvatar().length == 0) {
					ImageIcon image = new ImageIcon(
							GameWaitingRoomUI.class
									.getResource("/images/no_avatar_icon.png"));
					image = new ImageIcon(image.getImage().getScaledInstance(
							userIconLabelWidth, userIconLabelHeight,
							Image.SCALE_SMOOTH));
					playerPanel.setAvatar(image);
				} else {

					ImageIcon image = new ImageIcon(user.getAvatar());
					image = new ImageIcon(image.getImage().getScaledInstance(
							userIconLabelWidth, userIconLabelHeight,
							Image.SCALE_SMOOTH));
					playerPanel.setAvatar(image);
				}
				playerPanel.setCountry(user.getCountry());
				break;
			case Empty:
				playerPanel.setPlayer("Free");
				playerPanel.setAvatar(new ImageIcon(GameWaitingRoomUI.class
						.getResource("/images/empty_icon.png")));
				playerPanel.setCountry(-1);
				break;
			case Computer:
				playerPanel.setPlayer("Computer");
				ImageIcon image = new ImageIcon(
						GameWaitingRoomUI.class
								.getResource("/images/computer.png"));
				image = new ImageIcon(image.getImage().getScaledInstance(
						userIconLabelWidth, userIconLabelHeight,
						Image.SCALE_SMOOTH));
				playerPanel.setAvatar(image);
				playerPanel.setCountry(-1);
				break;
			case Closed:
				playerPanel.setPlayer("Closed");
				playerPanel.setAvatar(new ImageIcon(GameWaitingRoomUI.class
						.getResource("/images/empty_icon.png")));
				playerPanel.setCountry(-1);
				break;
			}
		}
	}

	private void initGUI() {
		try {
			this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			this.setResizable(false);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			getContentPane().add(getPnlBackground(), BorderLayout.CENTER);
			this.setSize(677, 450);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private JPanel getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setLayout(null);
			pnlBackground.add(getTxtMessage());
			pnlBackground.add(getPnlChat());
			pnlBackground.add(getJScrollPane1());
			pnlBackground.add(getPnlGame());
			if (creator)
				pnlBackground.add(getBtnStartGame());
			pnlBackground.add(getBtnCancel());
		}
		return pnlBackground;
	}

	private JTextField getTxtMessage() {
		if (txtMessage == null) {
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
		if (pnlChat == null) {
			pnlChat = new JScrollPane();
			pnlChat.setBounds(10, 273, 365, 107);
			pnlChat.setViewportView(getTxtChat());
		}
		return pnlChat;
	}

	private JPanel getPnlPlayers() {
		if (pnlPlayers == null) {
			pnlPlayers = new JPanel();
			pnlPlayers.setLayout(null);
			pnlPlayers.setBounds(10, 16, 365, 246);
			pnlPlayers.setAutoscrolls(true);
		}
		return pnlPlayers;
	}

	private JTextPane getTxtChat() {
		if (txtChat == null) {
			txtChat = new JTextPane();
			txtChat.setPreferredSize(new java.awt.Dimension(330, 124));
			htmlEditor = new HTMLEditorKit();
			chatText = new HTMLDocument();
			txtChat.setEditorKit(htmlEditor);
			txtChat.setDocument(chatText);
			txtChat.setEditable(false);
		}
		return txtChat;
	}

	private JPanel getPnlGame() {
		if (pnlGame == null) {
			pnlGame = new JPanel();
			pnlGame.setBorder(BorderFactory.createTitledBorder(""));
			pnlGame.setLayout(null);
			pnlGame.setBounds(385, 16, 265, 246);
			pnlGame.add(getLblGame());
			pnlGame.add(getLblGameImage());
			pnlGame.add(getLblDescription());
			pnlGame.add(getTxtGameDescription());
			pnlGame.add(getLblGameName());
			pnlGame.add(getLblName());
		}
		return pnlGame;
	}

	private JLabel getLblGame() {
		if (lblGame == null) {
			lblGame = new JLabel();
			lblGame.setText("Damas");
			lblGame.setHorizontalAlignment(SwingConstants.CENTER);
			lblGame.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblGame.setBounds(2, 33, 261, 19);
			lblGame.setFocusTraversalPolicyProvider(true);
		}
		return lblGame;
	}

	private JLabel getLblGameImage() {
		if (lblGameImage == null) {
			lblGameImage = new JLabel();
			lblGameImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblGameImage.setIcon(new ImageIcon(GameWaitingRoomUI.class
					.getResource("/images/Games/checkers_icon.png")));
			lblGameImage.setBounds(2, 57, 261, 60);
		}
		return lblGameImage;
	}

	private JLabel getLblDescription() {
		if (lblDescription == null) {
			lblDescription = new JLabel();
			lblDescription.setText("Descripción:");
			lblDescription.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblDescription.setBounds(12, 129, 74, 14);
		}
		return lblDescription;
	}

	private JTextPane getTxtGameDescription() {
		if (txtGameDescription == null) {
			SimpleAttributeSet style = new SimpleAttributeSet();
			StyleConstants.setAlignment(style, StyleConstants.ALIGN_JUSTIFIED);
			txtGameDescription = new JTextPane();
			txtGameDescription.getStyledDocument().setParagraphAttributes(0,
					txtGameDescription.getDocument().getLength(), style, false);
			txtGameDescription
					.setText("Las damas es un juego de mesa para dos contrincantes. El juego consiste en mover las piezas en diagonal a través de los cuadros negros de un tablero de ajedrez con la intención de capturar (comer) las piezas del contrario saltando por encima de ellas.");
			txtGameDescription.setEditable(false);
			txtGameDescription.setBackground(new java.awt.Color(240, 240, 240));
			txtGameDescription.setFocusable(false);
			txtGameDescription.setBounds(12, 145, 241, 87);
		}
		return txtGameDescription;
	}

	private JButton getBtnStartGame() {
		if (btnStartGame == null) {
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
		if (btnCancel == null) {
			btnCancel = new JButton();
			if (creator)
				btnCancel.setText("Cancelar");
			else
				btnCancel.setText("Salir");
			btnCancel.setBounds(548, 385, 103, 23);
			btnCancel.setFocusable(false);
			btnCancel.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnCancelMouseClicked(evt);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					btnCancelMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnCancelMouseExited(e);
				}
			});
		}
		return btnCancel;
	}

	private JLabel getLblGameName() {
		if (lblGameName == null) {
			lblGameName = new JLabel();
			lblGameName.setText("Nombre de la partida:");
			lblGameName.setBounds(12, 13, 127, 14);
			lblGameName.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblGameName;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel();
			lblName.setText("Partidaca");
			lblName.setBounds(149, 13, 114, 14);
		}
		return lblName;
	}

	private void btnCancelMouseClicked(MouseEvent evt) {
		if (btnCancel.isEnabled()) {
			if (creator)
				Controller.getInstance().deleteGame(game.getName());
			else
				Controller.getInstance().leaveGame(game.getName());
			dispose();
		}
	}

	private void btnStartGameMouseClicked(MouseEvent evt) {
		if (btnStartGame.isEnabled()) {
			try {
				Controller.getInstance().startGame(game.getName());
				btnCancel.setEnabled(false);
				btnStartGame.setEnabled(false);
				setEnabled(false);
				for (int i = 1; i < playerPanels.size(); i++) {
					playerPanels.get(i).getPlayerType().setEnabled(false);
				}
				new Thread() {
					public void run() {
						for (int i = 5; i > 0; i--) {
							try {
								htmlEditor.insertHTML(chatText,
										chatText.getLength(),
										"<b>La partida empezará en " + i
												+ " </b>", 0, 0, null);
								txtChat.setCaretPosition(txtChat.getDocument()
										.getLength());
								try {
									sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} catch (BadLocationException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						Controller.getInstance().closeGameWaitingRoomUI(
								game.getName());
					}
				}.start();
			} catch (NotEnoughPlayersException e1) {
				JOptionPane.showMessageDialog(this,
						"Que vas a jugar tu solo gañán!",
						"Echandome un solitario",
						JOptionPane.INFORMATION_MESSAGE);
				e1.printStackTrace();
			}
		}
	}

	public void gameStarted() {
		btnCancel.setEnabled(false);
		setEnabled(false);
		new Thread() {
			public void run() {
				for (int i = 5; i > 0; i--) {
					try {
						htmlEditor.insertHTML(chatText, chatText.getLength(),
								"<b>La partida empezará en " + i + " </b>", 0,
								0, null);
						txtChat.setCaretPosition(txtChat.getDocument()
								.getLength());
						try {
							sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Controller.getInstance().closeGameWaitingRoomUI(game.getName());
			}
		}.start();
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
							game.getName(), destinatary, privateMessage);
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

	public void userJoinGame(String player) {
		try {
			htmlEditor.insertHTML(chatText, chatText.getLength(), "<b>"
					+ player + " has joined the game</b> ", 0, 0, null);
		} catch (BadLocationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		refreshPlayers();
	}

	public void userLeaveGame(String player) {
		try {
			htmlEditor.insertHTML(chatText, chatText.getLength(), "<b>"
					+ player + " has left the game</b> ", 0, 0, null);
		} catch (BadLocationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		refreshPlayers();
	}

	public void slotStateChanged() {
		refreshPlayers();
	}

	private JScrollPane getJScrollPane1() {
		if (pnlPlayersScroll == null) {
			pnlPlayersScroll = new JScrollPane();
			pnlPlayersScroll.setBounds(10, 16, 365, 246);
			pnlPlayersScroll.setBorder(BorderFactory.createTitledBorder(""));
			pnlPlayersScroll
					.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			pnlPlayersScroll.setViewportView(getPnlPlayers());
		}
		return pnlPlayersScroll;
	}

	private void thisWindowClosing(WindowEvent evt) {
		if (creator)
			Controller.getInstance().deleteGame(game.getName());
		else
			Controller.getInstance().leaveGame(game.getName());
		dispose();
	}

	private class PlayerPanel extends JPanel {
		private JLabel lblAvatar;
		private JLabel lblPlayer;
		private JLabel lblCountry;
		private JComboBox<String> playerType;
		private int slot;

		public PlayerPanel(int slot, SlotState state) {
			super();
			this.slot = slot;
			setSize(pnlPlayers.getWidth() - 5, userIconLabelHeight + 10);
			add(getLblAvatar());
			add(getLblCountry());
			add(getLblPlayer());
			add(getPlayerType());
			setLayout(null);
			lblAvatar.setIcon(new ImageIcon(GameWaitingRoomUI.class
					.getResource("/images/empty_icon.png")));
			if (!creator)
				playerType.setEnabled(false);
			switch (state) {
			case Empty: // Empty
				lblAvatar.setIcon(new ImageIcon(GameWaitingRoomUI.class
						.getResource("/images/empty_icon.png")));
				lblPlayer.setText("Free");
				lblCountry.setIcon(null);
				playerType.setSelectedIndex(0);
				break;
			case Computer: // Computer
				ImageIcon image = new ImageIcon(
						GameWaitingRoomUI.class
								.getResource("/images/computer.png"));
				image = new ImageIcon(image.getImage().getScaledInstance(
						userIconLabelWidth, userIconLabelHeight,
						Image.SCALE_SMOOTH));
				lblAvatar.setIcon(image);
				lblPlayer.setText("Computer");
				lblCountry.setIcon(null);
				playerType.setSelectedIndex(1);
				break;
			case Closed: // Closed
				lblAvatar.setIcon(new ImageIcon(GameWaitingRoomUI.class
						.getResource("/images/empty_icon.png")));
				lblPlayer.setText("Closed");
				lblCountry.setIcon(null);
				playerType.setSelectedIndex(2);
				break;
			default:
				break;
			}
		}

		public PlayerPanel(User player, int slot) {
			super();
			this.slot = slot;
			setSize(pnlPlayers.getWidth() - 5, userIconLabelHeight + 10);
			add(getLblAvatar());
			add(getLblCountry());
			add(getLblPlayer());
			if (!(creator && slot == 0)) {
				add(getPlayerType());
			}

			if (player.getAvatar().length == 0) {
				ImageIcon image = new ImageIcon(
						GameWaitingRoomUI.class
								.getResource("/images/no_avatar_icon.png"));
				image = new ImageIcon(image.getImage().getScaledInstance(
						userIconLabelWidth, userIconLabelHeight,
						Image.SCALE_SMOOTH));
				lblAvatar.setIcon(image);
			} else {
				ImageIcon image = new ImageIcon(player.getAvatar());
				image = new ImageIcon(image.getImage().getScaledInstance(
						userIconLabelWidth, userIconLabelHeight,
						Image.SCALE_SMOOTH));
				lblAvatar.setIcon(image);
			}
			lblPlayer.setText(player.getUsername());

			lblCountry.setIcon(new ImageIcon(
					GameWaitingRoomUI.class.getResource(Utils
							.countrySmallImgPath(player.getCountry()))));
			setLayout(null);
			if (!creator)
				playerType.setEnabled(false);

		}

		private JLabel getLblAvatar() {
			if (lblAvatar == null) {
				lblAvatar = new JLabel();
				lblAvatar.setBounds(5, 5, userIconLabelWidth,
						userIconLabelHeight);
				lblAvatar.setBorder(BorderFactory
						.createBevelBorder(BevelBorder.LOWERED));
				lblAvatar.setHorizontalAlignment(SwingConstants.CENTER);
			}
			return lblAvatar;
		}

		private JLabel getLblPlayer() {
			if (lblPlayer == null) {
				lblPlayer = new JLabel();
				lblPlayer.setBounds(80, userIconLabelHeight / 2 - 5, 80, 20);
			}
			return lblPlayer;
		}

		private JLabel getLblCountry() {
			if (lblCountry == null) {
				lblCountry = new JLabel();
				lblCountry.setBounds(180, userIconLabelHeight / 2 - 5, 80, 20);
			}
			return lblCountry;
		}

		private JComboBox<String> getPlayerType() {
			if (playerType == null) {
				ComboBoxModel<String> playerTypeModel = new DefaultComboBoxModel<String>(
						new String[] { "Jugador", "Ordenador", "Cerrada" });
				playerType = new JComboBox<String>();
				playerType.setModel(playerTypeModel);
				playerType.setBounds(getWidth() - 105,
						userIconLabelHeight / 2 - 5, 100, 20);
				playerType.setFocusable(false);
				if (creator) {
					playerType.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							playerTypeItemStateChanged(evt);
						}
					});
				}
			}
			return playerType;
		}

		private void playerTypeItemStateChanged(ItemEvent evt) {
			if (evt.getStateChange() == ItemEvent.SELECTED) {
				int type = playerType.getSelectedIndex();
				switch (type) {
				case 0: // Empty
					Controller.getInstance().changeSlotState(game.getName(),
							slot, SlotState.Empty);
					lblAvatar.setIcon(new ImageIcon(GameWaitingRoomUI.class
							.getResource("/images/empty_icon.png")));
					lblPlayer.setText("Free");
					lblCountry.setIcon(null);
					break;
				case 1: // Computer
					Controller.getInstance().changeSlotState(game.getName(),
							slot, SlotState.Computer);
					ImageIcon image = new ImageIcon(
							GameWaitingRoomUI.class
									.getResource("/images/computer.png"));
					image = new ImageIcon(image.getImage().getScaledInstance(
							userIconLabelWidth, userIconLabelHeight,
							Image.SCALE_SMOOTH));
					lblAvatar.setIcon(image);
					lblPlayer.setText("Computer");
					lblCountry.setIcon(null);
					break;
				case 2: // Closed
					Controller.getInstance().changeSlotState(game.getName(),
							slot, SlotState.Closed);
					lblAvatar.setIcon(new ImageIcon(GameWaitingRoomUI.class
							.getResource("/images/empty_icon.png")));
					lblPlayer.setText("Closed");
					lblCountry.setIcon(null);
					break;
				}
			}
		}

		public void setPlayer(String player) {
			lblPlayer.setText(player);
		}

		public void setAvatar(ImageIcon avatar) {
			lblAvatar.setIcon(avatar);
		}

		public void setCountry(int country) {
			if (country != -1)
				lblCountry.setIcon(new ImageIcon(GameWaitingRoomUI.class
						.getResource(Utils.countrySmallImgPath(country))));
			else
				lblCountry.setIcon(null);
		}
	}

	private void setHandCursor() {
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	private void setDefaultCursor() {
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	protected void btnCancelMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnCancelMouseExited(MouseEvent e) {
		setDefaultCursor();
	}
}
