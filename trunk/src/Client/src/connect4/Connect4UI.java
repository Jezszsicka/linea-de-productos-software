package connect4;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.BorderFactory;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import constants.Constants;

import presentation.GameUI;

import logic.Controller;
import model.Game;
import model.User;
import ProductLine.Slot;
import ProductLine.SlotState;
import ProductLine.UserNotInGameException;
import presentation.JPanelRound;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class Connect4UI extends javax.swing.JFrame implements GameUI {
	private JPanelRound pnlBackground;
	private JLabel lbl75;
	private JLabel lblState;
	private JLabel lblOpponentName;
	private JButton btnQuit;
	private JButton btn1;
	private JLabel lbl11;
	private JLabel lbl12;
	private JLabel lbl13;
	private JLabel lbl14;
	private JLabel lbl15;
	private JLabel lbl16;
	private JLabel lbl26;
	private JLabel lbl25;
	private JLabel lbl24;
	private JLabel lbl23;
	private JLabel lbl22;
	private JLabel lbl21;
	private JButton btn2;
	private JButton btn3;
	private JLabel lbl31;
	private JLabel lbl32;
	private JLabel lbl33;
	private JLabel lbl34;
	private JLabel lbl35;
	private JLabel lbl36;
	private JLabel lbl46;
	private JLabel lbl45;
	private JLabel lbl44;
	private JLabel lbl43;
	private JLabel lbl42;
	private JLabel lbl41;
	private JButton btn4;
	private JButton btn5;
	private JLabel lbl51;
	private JLabel lbl52;
	private JLabel lbl53;
	private JLabel lbl54;
	private JLabel lbl55;
	private JLabel lbl56;
	private JLabel lbl66;
	private JLabel lbl65;
	private JLabel lbl64;
	private JLabel lbl63;
	private JLabel lbl62;
	private JLabel lbl61;
	private JButton btn6;
	private JButton btn7;
	private JLabel lbl71;
	private JLabel lbl72;
	private JLabel lbl73;
	private JLabel lbl74;
	private JLabel lbl76;
	private JPanel pnlBoard;
	private JLabel lblOpponentAvatar;
	private JTextField txtMessage;
	private JTextPane txtChat;
	private JScrollPane pnlChat;

	private JLabel[][] boardUI;

	private HTMLEditorKit htmlEditor;
	private HTMLDocument chatText;

	private String destinatary;
	private String username;
	private Game game;

	private int playerTurn;
	private int myPlayer;
	private Minimax minimax;
	private boolean computer;

	public Connect4UI(String username, Game game) {
		super();
		this.username = username;
		this.game = game;
		playerTurn = Connect4.RED;
		boardUI = new JLabel[6][7];
		minimax = new Minimax(Constants.Connect4ComputerLevel);
		destinatary = "";

		Slot opponentSlot = game.getSlot(0);
		myPlayer = Connect4.BLUE;

		if (opponentSlot.getPlayer().equalsIgnoreCase(username)) {
			opponentSlot = game.getSlot(1);
			myPlayer = Connect4.RED;
		}

		if (opponentSlot.getType() == SlotState.Human)
			computer = false;
		else
			computer = true;

		initGUI();

		if (computer) {
			lblOpponentAvatar.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/computer.png")));
			lblOpponentName.setText("Computer");
			setSize(762, 500);
			pnlBackground.setSize(762, 480);
			btnQuit.setLocation(btnQuit.getX(), lblState.getY());
			lblState.setText("Es tu turno");
		} else {
			User opponent = Controller.getInstance().searchUser(
					opponentSlot.getPlayer());
			if (opponent.getAvatar().length == 0) {
				lblOpponentAvatar.setIcon(new ImageIcon(Connect4UI.class
						.getResource("/images/no_avatar_icon.png")));
			} else {
				lblOpponentAvatar.setIcon(new ImageIcon(opponent.getAvatar()));
			}

			lblOpponentName.setText(opponent.getUsername());

			if (playerTurn != myPlayer) {
				activateButtons(false);
				lblState.setText("Es el turno de " + opponent.getName());
			} else {
				lblState.setText("Es tu turno");
				activateButtons(true);
			}
		}
	}

	private void initGUI() {
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getPnlBackground());
		setSize(762, 661);
		setLocationRelativeTo(null);
		setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				thisWindowClosing(evt);
			}
		});
	}

	private JPanelRound getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanelRound();
			pnlBackground.setArch(0);
			pnlBackground.setArcw(0);
			pnlBackground.setLayout(null);
			pnlBackground.setBounds(0, 0, 746, 623);
			pnlBackground.add(getPnlBoard());
			pnlBackground.add(getLblOpponentAvatar());
			if (!computer) {
				pnlBackground.add(getPnlChat());
				pnlBackground.add(getTxtMessage());
			}
			pnlBackground.add(getBtnQuit());
			pnlBackground.add(getLblOpponentName());
			pnlBackground.add(getLblState());
		}
		return pnlBackground;
	}

	private JLabel getLblOpponentAvatar() {
		if (lblOpponentAvatar == null) {
			lblOpponentAvatar = new JLabel();
			lblOpponentAvatar.setHorizontalAlignment(SwingConstants.CENTER);
			lblOpponentAvatar.setBounds(635, 13, 100, 120);
			lblOpponentAvatar.setBorder(new SoftBevelBorder(
					BevelBorder.LOWERED, null, null, null, null));
		}
		return lblOpponentAvatar;
	}

	private JScrollPane getPnlChat() {
		if (pnlChat == null) {
			pnlChat = new JScrollPane();
			pnlChat.setBorder(null);
			pnlChat.setBounds(10, 460, 615, 123);
			pnlChat.setViewportView(getTxtChat());
		}
		return pnlChat;
	}

	private JTextPane getTxtChat() {
		if (txtChat == null) {
			txtChat = new JTextPane();
			txtChat.setForeground(Color.WHITE);
			txtChat.setBackground(Color.BLACK);
			txtChat.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			htmlEditor = new HTMLEditorKit();
			chatText = new HTMLDocument();
			txtChat.setEditorKit(htmlEditor);
			txtChat.setDocument(chatText);
			txtChat.setEditable(false);
			txtChat.setBounds(230, 380, 363, 105);
		}
		return txtChat;
	}

	private JTextField getTxtMessage() {
		if (txtMessage == null) {
			txtMessage = new JTextField();
			txtMessage.setBackground(Color.BLACK);
			txtMessage.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			txtMessage.setForeground(Color.WHITE);
			txtMessage.setCaretColor(Color.WHITE);
			txtMessage.setText(null);
			txtMessage.setBounds(10, 590, 615, 25);
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
				htmlEditor.insertHTML(chatText, chatText.getLength(),
						"<font color=\"white\"><b>" + username + ":</b> "
								+ message + "</font>", 0, 0, null);
			} catch (BadLocationException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		txtMessage.setText(null);
		txtChat.setCaretPosition(txtChat.getDocument().getLength());
	}

	private JPanel getPnlBoard() {
		if (pnlBoard == null) {
			pnlBoard = new JPanel();
			pnlBoard.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			pnlBoard.setBackground(new java.awt.Color(0, 0, 0));
			pnlBoard.setLayout(null);
			pnlBoard.setBounds(10, 11, 615, 417);
			pnlBoard.add(getLbl76());
			pnlBoard.add(getLbl75());
			pnlBoard.add(getLbl74());
			pnlBoard.add(getLbl73());
			pnlBoard.add(getLbl72());
			pnlBoard.add(getLbl71());
			pnlBoard.add(getLbl61());
			pnlBoard.add(getLbl62());
			pnlBoard.add(getLbl63());
			pnlBoard.add(getLbl64());
			pnlBoard.add(getLbl65());
			pnlBoard.add(getLbl66());
			pnlBoard.add(getLbl56());
			pnlBoard.add(getLbl55());
			pnlBoard.add(getLbl54());
			pnlBoard.add(getLbl53());
			pnlBoard.add(getLbl52());
			pnlBoard.add(getLbl51());
			pnlBoard.add(getLbl41());
			pnlBoard.add(getLbl42());
			pnlBoard.add(getLbl43());
			pnlBoard.add(getLbl44());
			pnlBoard.add(getLbl45());
			pnlBoard.add(getLbl46());
			pnlBoard.add(getLbl36());
			pnlBoard.add(getLbl35());
			pnlBoard.add(getLbl34());
			pnlBoard.add(getLbl33());
			pnlBoard.add(getLbl32());
			pnlBoard.add(getLbl31());
			pnlBoard.add(getLbl21());
			pnlBoard.add(getLbl22());
			pnlBoard.add(getLbl23());
			pnlBoard.add(getLbl24());
			pnlBoard.add(getLbl25());
			pnlBoard.add(getLbl26());
			pnlBoard.add(getLbl16());
			pnlBoard.add(getLbl15());
			pnlBoard.add(getLbl14());
			pnlBoard.add(getLbl13());
			pnlBoard.add(getLbl12());
			pnlBoard.add(getLbl11());
			pnlBoard.add(getBtn1());
			pnlBoard.add(getBtn2());
			pnlBoard.add(getBtn3());
			pnlBoard.add(getBtn4());
			pnlBoard.add(getBtn5());
			pnlBoard.add(getBtn6());
			pnlBoard.add(getBtn7());
		}
		return pnlBoard;
	}

	private JLabel getLbl76() {
		if (lbl76 == null) {
			lbl76 = new JLabel();
			lbl76.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl76.setHorizontalAlignment(SwingConstants.CENTER);
			lbl76.setOpaque(true);
			lbl76.setBackground(new java.awt.Color(0, 0, 0));
			lbl76.setBounds(519, 338, 85, 61);
			boardUI[5][6] = lbl76;
		}
		return lbl76;
	}

	private JLabel getLbl75() {
		if (lbl75 == null) {
			lbl75 = new JLabel();
			lbl75.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl75.setHorizontalAlignment(SwingConstants.CENTER);
			lbl75.setOpaque(true);
			lbl75.setBackground(new java.awt.Color(0, 0, 0));
			lbl75.setBounds(519, 278, 85, 60);
			boardUI[4][6] = lbl75;
		}
		return lbl75;
	}

	private JLabel getLbl74() {
		if (lbl74 == null) {
			lbl74 = new JLabel();
			lbl74.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl74.setHorizontalAlignment(SwingConstants.CENTER);
			lbl74.setOpaque(true);
			lbl74.setBackground(new java.awt.Color(0, 0, 0));
			lbl74.setBounds(520, 220, 84, 60);
			boardUI[3][6] = lbl74;
		}
		return lbl74;
	}

	private JLabel getLbl73() {
		if (lbl73 == null) {
			lbl73 = new JLabel();
			lbl73.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl73.setHorizontalAlignment(SwingConstants.CENTER);
			lbl73.setOpaque(true);
			lbl73.setBackground(new java.awt.Color(0, 0, 0));
			lbl73.setBounds(520, 160, 84, 60);
			boardUI[2][6] = lbl73;
		}
		return lbl73;
	}

	private JLabel getLbl72() {
		if (lbl72 == null) {
			lbl72 = new JLabel();
			lbl72.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl72.setHorizontalAlignment(SwingConstants.CENTER);
			lbl72.setOpaque(true);
			lbl72.setBackground(new java.awt.Color(0, 0, 0));
			lbl72.setBounds(520, 100, 84, 60);
			boardUI[1][6] = lbl72;
		}
		return lbl72;
	}

	private JLabel getLbl71() {
		if (lbl71 == null) {
			lbl71 = new JLabel();
			lbl71.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl71.setHorizontalAlignment(SwingConstants.CENTER);
			lbl71.setOpaque(true);
			lbl71.setBackground(new java.awt.Color(0, 0, 0));
			lbl71.setBounds(520, 40, 84, 60);
			boardUI[0][6] = lbl71;
		}
		return lbl71;
	}

	private JButton getBtn7() {
		if (btn7 == null) {
			btn7 = new JButton();
			btn7.setText("Columna 7");
			// btn7.setVisible(opcion);
			btn7.setBackground(new java.awt.Color(0, 0, 0));
			btn7.setFocusable(false);
			btn7.setBounds(514, 17, 87, 23);
			btn7.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btn7MouseClicked(evt);
				}
			});
		}
		return btn7;
	}

	private JButton getBtn6() {
		if (btn6 == null) {
			btn6 = new JButton();
			btn6.setText("Columna 6");
			// btn6.setVisible(opcion);
			btn6.setBackground(new java.awt.Color(0, 0, 0));
			btn6.setFocusable(false);
			btn6.setBounds(431, 17, 83, 23);
			btn6.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btn6MouseClicked(evt);
				}
			});
		}
		return btn6;
	}

	private JLabel getLbl61() {
		if (lbl61 == null) {
			lbl61 = new JLabel();
			lbl61.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl61.setHorizontalAlignment(SwingConstants.CENTER);
			lbl61.setOpaque(true);
			lbl61.setBackground(new java.awt.Color(0, 0, 0));
			lbl61.setBounds(436, 40, 84, 60);
			boardUI[0][5] = lbl61;
		}
		return lbl61;
	}

	private JLabel getLbl62() {
		if (lbl62 == null) {
			lbl62 = new JLabel();
			lbl62.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl62.setHorizontalAlignment(SwingConstants.CENTER);
			lbl62.setOpaque(true);
			lbl62.setBackground(new java.awt.Color(0, 0, 0));
			lbl62.setBounds(436, 100, 84, 60);
			boardUI[1][5] = lbl62;
		}
		return lbl62;
	}

	private JLabel getLbl63() {
		if (lbl63 == null) {
			lbl63 = new JLabel();
			lbl63.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl63.setHorizontalAlignment(SwingConstants.CENTER);
			lbl63.setOpaque(true);
			lbl63.setBackground(new java.awt.Color(0, 0, 0));
			lbl63.setBounds(436, 160, 84, 60);
			boardUI[2][5] = lbl63;
		}
		return lbl63;
	}

	private JLabel getLbl64() {
		if (lbl64 == null) {
			lbl64 = new JLabel();
			lbl64.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl64.setHorizontalAlignment(SwingConstants.CENTER);
			lbl64.setOpaque(true);
			lbl64.setBackground(new java.awt.Color(0, 0, 0));
			lbl64.setBounds(436, 219, 84, 60);
			boardUI[3][5] = lbl64;
		}
		return lbl64;
	}

	private JLabel getLbl65() {
		if (lbl65 == null) {
			lbl65 = new JLabel();
			lbl65.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl65.setHorizontalAlignment(SwingConstants.CENTER);
			lbl65.setOpaque(true);
			lbl65.setBackground(new java.awt.Color(0, 0, 0));
			lbl65.setBounds(435, 279, 84, 60);
			boardUI[4][5] = lbl65;
		}
		return lbl65;
	}

	private JLabel getLbl66() {
		if (lbl66 == null) {
			lbl66 = new JLabel();
			lbl66.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl66.setHorizontalAlignment(SwingConstants.CENTER);
			lbl66.setOpaque(true);
			lbl66.setBackground(new java.awt.Color(0, 0, 0));
			lbl66.setBounds(436, 339, 84, 60);
			boardUI[5][5] = lbl66;
		}
		return lbl66;
	}

	private JLabel getLbl56() {
		if (lbl56 == null) {
			lbl56 = new JLabel();
			lbl56.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl56.setHorizontalAlignment(SwingConstants.CENTER);
			lbl56.setOpaque(true);
			lbl56.setBackground(new java.awt.Color(0, 0, 0));
			lbl56.setBounds(352, 339, 84, 60);
			boardUI[5][4] = lbl56;
		}
		return lbl56;
	}

	private JLabel getLbl55() {
		if (lbl55 == null) {
			lbl55 = new JLabel();
			lbl55.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl55.setHorizontalAlignment(SwingConstants.CENTER);
			lbl55.setOpaque(true);
			lbl55.setBackground(new java.awt.Color(0, 0, 0));
			lbl55.setBounds(351, 281, 84, 60);
			boardUI[4][4] = lbl55;
		}
		return lbl55;
	}

	private JLabel getLbl54() {
		if (lbl54 == null) {
			lbl54 = new JLabel();
			lbl54.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl54.setHorizontalAlignment(SwingConstants.CENTER);
			lbl54.setOpaque(true);
			lbl54.setBackground(new java.awt.Color(0, 0, 0));
			lbl54.setBounds(352, 221, 84, 60);
			boardUI[3][4] = lbl54;
		}
		return lbl54;
	}

	private JLabel getLbl53() {
		if (lbl53 == null) {
			lbl53 = new JLabel();
			lbl53.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl53.setHorizontalAlignment(SwingConstants.CENTER);
			lbl53.setOpaque(true);
			lbl53.setBackground(new java.awt.Color(0, 0, 0));
			lbl53.setBounds(352, 161, 84, 60);
			boardUI[2][4] = lbl53;
		}
		return lbl53;
	}

	private JLabel getLbl52() {
		if (lbl52 == null) {
			lbl52 = new JLabel();
			lbl52.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl52.setHorizontalAlignment(SwingConstants.CENTER);
			lbl52.setOpaque(true);
			lbl52.setBackground(new java.awt.Color(0, 0, 0));
			lbl52.setBounds(352, 101, 84, 60);
			boardUI[1][4] = lbl52;
		}
		return lbl52;
	}

	private JLabel getLbl51() {
		if (lbl51 == null) {
			lbl51 = new JLabel();
			lbl51.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl51.setHorizontalAlignment(SwingConstants.CENTER);
			lbl51.setOpaque(true);
			lbl51.setBackground(new java.awt.Color(0, 0, 0));
			lbl51.setBounds(352, 41, 84, 60);
			boardUI[0][4] = lbl51;
		}
		return lbl51;
	}

	private JButton getBtn5() {
		if (btn5 == null) {
			btn5 = new JButton();
			btn5.setText("Columna 5");
			// btn5.setVisible(opcion);
			btn5.setBackground(new java.awt.Color(0, 0, 0));
			btn5.setFocusable(false);
			btn5.setBounds(348, 17, 83, 23);
			btn5.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btn5MouseClicked(evt);
				}
			});
		}
		return btn5;
	}

	private JButton getBtn4() {
		if (btn4 == null) {
			btn4 = new JButton();
			btn4.setText("Columna 4");
			// btn4.setVisible(opcion);
			btn4.setBackground(new java.awt.Color(0, 0, 0));
			btn4.setFocusable(false);
			btn4.setBounds(265, 17, 83, 23);
			btn4.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btn4MouseClicked(evt);
				}
			});
		}
		return btn4;
	}

	private JLabel getLbl41() {
		if (lbl41 == null) {
			lbl41 = new JLabel();
			lbl41.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl41.setHorizontalAlignment(SwingConstants.CENTER);
			lbl41.setOpaque(true);
			lbl41.setBackground(new java.awt.Color(0, 0, 0));
			lbl41.setBounds(268, 41, 84, 60);
			boardUI[0][3] = lbl41;
		}
		return lbl41;
	}

	private JLabel getLbl42() {
		if (lbl42 == null) {
			lbl42 = new JLabel();
			lbl42.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl42.setHorizontalAlignment(SwingConstants.CENTER);
			lbl42.setOpaque(true);
			lbl42.setBackground(new java.awt.Color(0, 0, 0));
			lbl42.setBounds(268, 101, 84, 60);
			boardUI[1][3] = lbl42;
		}
		return lbl42;
	}

	private JLabel getLbl43() {
		if (lbl43 == null) {
			lbl43 = new JLabel();
			lbl43.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl43.setHorizontalAlignment(SwingConstants.CENTER);
			lbl43.setOpaque(true);
			lbl43.setBackground(new java.awt.Color(0, 0, 0));
			lbl43.setBounds(268, 161, 84, 60);
			boardUI[2][3] = lbl43;
		}
		return lbl43;
	}

	private JLabel getLbl44() {
		if (lbl44 == null) {
			lbl44 = new JLabel();
			lbl44.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl44.setHorizontalAlignment(SwingConstants.CENTER);
			lbl44.setOpaque(true);
			lbl44.setBackground(new java.awt.Color(0, 0, 0));
			lbl44.setBounds(268, 221, 84, 60);
			boardUI[3][3] = lbl44;
		}
		return lbl44;
	}

	private JLabel getLbl45() {
		if (lbl45 == null) {
			lbl45 = new JLabel();
			lbl45.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl45.setHorizontalAlignment(SwingConstants.CENTER);
			lbl45.setOpaque(true);
			lbl45.setBackground(new java.awt.Color(0, 0, 0));
			lbl45.setBounds(267, 281, 84, 60);
			boardUI[4][3] = lbl45;
		}
		return lbl45;
	}

	private JLabel getLbl46() {
		if (lbl46 == null) {
			lbl46 = new JLabel();
			lbl46.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl46.setHorizontalAlignment(SwingConstants.CENTER);
			lbl46.setOpaque(true);
			lbl46.setBackground(new java.awt.Color(0, 0, 0));
			lbl46.setBounds(268, 339, 84, 60);
			boardUI[5][3] = lbl46;
		}
		return lbl46;
	}

	private JLabel getLbl36() {
		if (lbl36 == null) {
			lbl36 = new JLabel();
			lbl36.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl36.setHorizontalAlignment(SwingConstants.CENTER);
			lbl36.setOpaque(true);
			lbl36.setBackground(new java.awt.Color(0, 0, 0));
			lbl36.setBounds(184, 339, 84, 60);
			boardUI[5][2] = lbl36;
		}
		return lbl36;
	}

	private JLabel getLbl35() {
		if (lbl35 == null) {
			lbl35 = new JLabel();
			lbl35.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl35.setHorizontalAlignment(SwingConstants.CENTER);
			lbl35.setOpaque(true);
			lbl35.setBackground(new java.awt.Color(0, 0, 0));
			lbl35.setBounds(184, 279, 84, 60);
			boardUI[4][2] = lbl35;
		}
		return lbl35;
	}

	private JLabel getLbl34() {
		if (lbl34 == null) {
			lbl34 = new JLabel();
			lbl34.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl34.setHorizontalAlignment(SwingConstants.CENTER);
			lbl34.setOpaque(true);
			lbl34.setBackground(new java.awt.Color(0, 0, 0));
			lbl34.setBounds(184, 219, 84, 60);
			boardUI[3][2] = lbl34;
		}
		return lbl34;
	}

	private JLabel getLbl33() {
		if (lbl33 == null) {
			lbl33 = new JLabel();
			lbl33.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl33.setHorizontalAlignment(SwingConstants.CENTER);
			lbl33.setOpaque(true);
			lbl33.setBackground(new java.awt.Color(0, 0, 0));
			lbl33.setBounds(184, 159, 84, 60);
			boardUI[2][2] = lbl33;
		}
		return lbl33;
	}

	private JLabel getLbl32() {
		if (lbl32 == null) {
			lbl32 = new JLabel();
			lbl32.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl32.setHorizontalAlignment(SwingConstants.CENTER);
			lbl32.setOpaque(true);
			lbl32.setBackground(new java.awt.Color(0, 0, 0));
			lbl32.setBounds(184, 100, 84, 60);
			boardUI[1][2] = lbl32;
		}
		return lbl32;
	}

	private JLabel getLbl31() {
		if (lbl31 == null) {
			lbl31 = new JLabel();
			lbl31.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl31.setHorizontalAlignment(SwingConstants.CENTER);
			lbl31.setOpaque(true);
			lbl31.setBackground(new java.awt.Color(0, 0, 0));
			lbl31.setBounds(184, 41, 84, 60);
			boardUI[0][2] = lbl31;
		}
		return lbl31;
	}

	private JButton getBtn3() {
		if (btn3 == null) {
			btn3 = new JButton();
			btn3.setText("Columna 3");
			// btn3.setVisible(opcion);
			btn3.setBackground(new java.awt.Color(0, 0, 0));
			btn3.setFocusable(false);
			btn3.setBounds(181, 17, 84, 23);
			btn3.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btn3MouseClicked(evt);
				}
			});
		}
		return btn3;
	}

	private JButton getBtn2() {
		if (btn2 == null) {
			btn2 = new JButton();
			btn2.setText("Columna 2");
			// btn2.setVisible(opcion);
			btn2.setBackground(new java.awt.Color(0, 0, 0));
			btn2.setFocusable(false);
			btn2.setBounds(97, 17, 84, 23);
			btn2.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btn2MouseClicked(evt);
				}
			});
		}
		return btn2;
	}

	private JLabel getLbl21() {
		if (lbl21 == null) {
			lbl21 = new JLabel();
			lbl21.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl21.setHorizontalAlignment(SwingConstants.CENTER);
			lbl21.setOpaque(true);
			lbl21.setBackground(new java.awt.Color(0, 0, 0));
			lbl21.setBounds(100, 40, 84, 60);
			boardUI[0][1] = lbl21;
		}
		return lbl21;
	}

	private JLabel getLbl22() {
		if (lbl22 == null) {
			lbl22 = new JLabel();
			lbl22.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl22.setHorizontalAlignment(SwingConstants.CENTER);
			lbl22.setOpaque(true);
			lbl22.setBackground(new java.awt.Color(0, 0, 0));
			lbl22.setBounds(100, 100, 84, 60);
			boardUI[1][1] = lbl22;
		}
		return lbl22;
	}

	private JLabel getLbl23() {
		if (lbl23 == null) {
			lbl23 = new JLabel();
			lbl23.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl23.setHorizontalAlignment(SwingConstants.CENTER);
			lbl23.setOpaque(true);
			lbl23.setBackground(new java.awt.Color(0, 0, 0));
			lbl23.setBounds(100, 160, 84, 60);
			boardUI[2][1] = lbl23;
		}
		return lbl23;
	}

	private JLabel getLbl24() {
		if (lbl24 == null) {
			lbl24 = new JLabel();
			lbl24.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl24.setHorizontalAlignment(SwingConstants.CENTER);
			lbl24.setOpaque(true);
			lbl24.setBackground(new java.awt.Color(0, 0, 0));
			lbl24.setBounds(100, 219, 84, 60);
			boardUI[3][1] = lbl24;
		}
		return lbl24;
	}

	private JLabel getLbl25() {
		if (lbl25 == null) {
			lbl25 = new JLabel();
			lbl25.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl25.setHorizontalAlignment(SwingConstants.CENTER);
			lbl25.setOpaque(true);
			lbl25.setBackground(new java.awt.Color(0, 0, 0));
			lbl25.setBounds(100, 279, 84, 60);
			boardUI[4][1] = lbl25;
		}
		return lbl25;
	}

	private JLabel getLbl26() {
		if (lbl26 == null) {
			lbl26 = new JLabel();
			lbl26.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl26.setHorizontalAlignment(SwingConstants.CENTER);
			lbl26.setOpaque(true);
			lbl26.setBackground(new java.awt.Color(0, 0, 0));
			lbl26.setBounds(100, 339, 84, 60);
			boardUI[5][1] = lbl26;
		}
		return lbl26;
	}

	private JLabel getLbl16() {
		if (lbl16 == null) {
			lbl16 = new JLabel();
			lbl16.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl16.setHorizontalAlignment(SwingConstants.CENTER);
			lbl16.setOpaque(true);
			lbl16.setBackground(new java.awt.Color(0, 0, 0));
			lbl16.setPreferredSize(new java.awt.Dimension(84, 60));
			lbl16.setBounds(16, 339, 84, 60);
			boardUI[5][0] = lbl16;
		}
		return lbl16;
	}

	private JLabel getLbl15() {
		if (lbl15 == null) {
			lbl15 = new JLabel();
			lbl15.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl15.setHorizontalAlignment(SwingConstants.CENTER);
			lbl15.setOpaque(true);
			lbl15.setBackground(new java.awt.Color(0, 0, 0));
			lbl15.setBounds(16, 280, 84, 60);
			boardUI[4][0] = lbl15;
		}
		return lbl15;
	}

	private JLabel getLbl14() {
		if (lbl14 == null) {
			lbl14 = new JLabel();
			lbl14.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl14.setHorizontalAlignment(SwingConstants.CENTER);
			lbl14.setOpaque(true);
			lbl14.setBackground(new java.awt.Color(0, 0, 0));
			lbl14.setBounds(16, 220, 84, 60);
			boardUI[3][0] = lbl14;
		}
		return lbl14;
	}

	private JLabel getLbl13() {
		if (lbl13 == null) {
			lbl13 = new JLabel();
			lbl13.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl13.setHorizontalAlignment(SwingConstants.CENTER);
			lbl13.setOpaque(true);
			lbl13.setBackground(new java.awt.Color(0, 0, 0));
			lbl13.setBounds(16, 160, 84, 60);
			boardUI[2][0] = lbl13;
		}
		return lbl13;
	}

	private JLabel getLbl12() {
		if (lbl12 == null) {
			lbl12 = new JLabel();
			lbl12.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl12.setHorizontalAlignment(SwingConstants.CENTER);
			lbl12.setOpaque(true);
			lbl12.setBackground(new java.awt.Color(0, 0, 0));
			lbl12.setBounds(16, 100, 84, 60);
			boardUI[1][0] = lbl12;
		}
		return lbl12;
	}

	private JLabel getLbl11() {
		if (lbl11 == null) {
			lbl11 = new JLabel();
			lbl11.setIcon(new ImageIcon(Connect4UI.class
					.getResource("/images/ConnectFour/Empty.jpg")));
			lbl11.setHorizontalAlignment(SwingConstants.CENTER);
			lbl11.setOpaque(true);
			lbl11.setBackground(new java.awt.Color(0, 0, 0));
			lbl11.setBounds(16, 40, 84, 60);
			boardUI[0][0] = lbl11;
		}
		return lbl11;
	}

	private JButton getBtn1() {
		if (btn1 == null) {
			btn1 = new JButton();
			btn1.setText("Columna 1");
			// btn1.setVisible(opcion);
			btn1.setBackground(new java.awt.Color(0, 0, 0));
			btn1.setFocusable(false);
			btn1.setBounds(13, 17, 84, 23);
			btn1.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btn1MouseClicked(evt);
				}
			});
		}
		return btn1;
	}

	/** Column buttons events **/
	private void btn1MouseClicked(MouseEvent evt) {
		ponerFicha(0);
	}

	private void btn2MouseClicked(MouseEvent evt) {
		ponerFicha(1);
	}

	private void btn3MouseClicked(MouseEvent evt) {
		ponerFicha(2);
	}

	private void btn4MouseClicked(MouseEvent evt) {
		ponerFicha(3);
	}

	private void btn5MouseClicked(MouseEvent evt) {
		ponerFicha(4);
	}

	private void btn6MouseClicked(MouseEvent evt) {
		ponerFicha(5);
	}

	private void btn7MouseClicked(MouseEvent evt) {
		ponerFicha(6);
	}

	private JButton getBtnQuit() {
		if (btnQuit == null) {
			btnQuit = new JButton();
			btnQuit.setFocusable(false);
			btnQuit.setText("Quit");
			btnQuit.setBounds(650, 589, 86, 23);
			btnQuit.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnQuitMouseClicked(evt);
				}
			});
		}
		return btnQuit;
	}

	private JLabel getLblOpponentName() {
		if (lblOpponentName == null) {
			lblOpponentName = new JLabel();
			lblOpponentName.setForeground(Color.WHITE);
			lblOpponentName.setBounds(635, 143, 101, 25);
			lblOpponentName.setHorizontalAlignment(SwingConstants.CENTER);
			lblOpponentName.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblOpponentName.setBorder(null);
		}
		return lblOpponentName;
	}

	private int libre(int columna) {
		return Connect4.libre(game.getBoard(), columna);
	}

	private void ponerFicha(int columna) {
		int fila = libre(columna);
		boolean winner = false;
		if (fila != -1) {
			Connect4.ponerFicha(game.getBoard(), columna, playerTurn);
			if (playerTurn == Connect4.RED) {
				boardUI[fila][columna].setIcon(new ImageIcon(Connect4UI.class
						.getResource("/images/ConnectFour/Red.jpg")));
			} else {
				boardUI[fila][columna].setIcon(new ImageIcon(Connect4UI.class
						.getResource("/images/ConnectFour/Blue.jpg")));
			}

			// Checks winner
			if (minimax.ganador(playerTurn, game.getBoard(), columna)) {
				winner = true;
				lblState.setText("Has ganado el juego");
			} else if (minimax.hayEmpate(game.getBoard())) {
				int[][] board = game.getBoard();
				if (minimax.tresEnRaya(board, playerTurn) > minimax.tresEnRaya(
						board, changePlayerTurn(playerTurn)))
					lblState.setText("El jugador azul ha ganado");
				else if (minimax.tresEnRaya(board, playerTurn) < minimax
						.tresEnRaya(board, changePlayerTurn(playerTurn)))
					lblState.setText("El jugador rojo ha ganado");
				else if (minimax.dosEnRaya(board, playerTurn) > minimax
						.dosEnRaya(board, changePlayerTurn(playerTurn)))
					lblState.setText("El jugador azul ha ganado");
				else if (minimax.tresEnRaya(board, playerTurn) < minimax
						.tresEnRaya(board, changePlayerTurn(playerTurn)))
					lblState.setText("El jugador rojo ha ganado");
				else
					lblState.setText("El juego ha terminado en empate");
				winner = true;
			}

			// TODO SI hay empate gana el último que pone ficha
			playerTurn = game.changeTurn();
			activateButtons(false);

			if (computer && !winner) {
				lblState.setText("Pensando...");
				new Thread() {
					public void run() {
						computerMove();
					}
				}.start();

			} else {
				if (!computer) {
					if (!winner) {
						Controller.getInstance().updateGame(game.getName());
						lblState.setText("Es el turno de "
								+ lblOpponentName.getText());
					} else {
						Controller.getInstance().finishGame(game.getName(),
								username);
						JOptionPane.showMessageDialog(this,
								"Has ganado el juego!");
						dispose();
					}
				}
			}
		}
	}

	private JLabel getLblState() {
		if (lblState == null) {
			lblState = new JLabel();
			lblState.setForeground(Color.WHITE);
			lblState.setBounds(10, 434, 615, 15);
			lblState.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		}
		return lblState;
	}

	private void activateButtons(boolean enabled) {
		btn1.setVisible(enabled);
		btn2.setVisible(enabled);
		btn3.setVisible(enabled);
		btn4.setVisible(enabled);
		btn5.setVisible(enabled);
		btn6.setVisible(enabled);
		btn7.setVisible(enabled);
	}

	private int changePlayerTurn(int jugador) {
		if (jugador == Connect4.RED)
			return Connect4.BLUE;
		else
			return Connect4.RED;
	}

	private void computerMove() {
		int movimiento = minimax.minimax(game.getBoard(), Connect4.BLUE);
		int fila = libre(movimiento);
		Connect4.ponerFicha(game.getBoard(), movimiento, Connect4.BLUE);
		boardUI[fila][movimiento].setIcon(new ImageIcon(Connect4UI.class
				.getResource("/images/ConnectFour/Blue.jpg")));
		playerTurn = game.changeTurn();

		// Computer has won the game
		if (minimax.ganador(Connect4.BLUE, game.getBoard(), movimiento)) {
			// TODO Aunque sea contra el ordenador hay que terminar la partida
			// avisando al servidor
			activateButtons(false);
			lblState.setText("Has perdido la partida");
			JOptionPane.showMessageDialog(this, "Has perdido el juego!");
			dispose();

		} else {
			activateButtons(true);
			lblState.setText("Es tu turno");
		}
	}

	private void btnQuitMouseClicked(MouseEvent evt) {
		Controller.getInstance().leaveGame(game.getName());
		dispose();
	}

	@Override
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

	@Override
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

	@Override
	public void updateBoard(int nextTurn) {
		int[][] board = game.getBoard();
		for (int i = 0; i < boardUI.length; i++) {
			for (int j = 0; j < boardUI[0].length; j++) {
				switch (board[i][j]) {
				case 0:
					boardUI[i][j].setIcon(new ImageIcon(Connect4UI.class
							.getResource("/images/ConnectFour/Red.jpg")));
					break;
				case 1:
					boardUI[i][j].setIcon(new ImageIcon(Connect4UI.class
							.getResource("/images/ConnectFour/Blue.jpg")));
					break;
				}
			}
		}

		playerTurn = game.changeTurn();
		lblState.setText("Es tu turno");
		activateButtons(true);
	}

	@Override
	public void lostGame() {
		lblState.setText("Has perdido la partida");
		activateButtons(false);
		new Thread() {
			public void run() {
				JOptionPane.showMessageDialog(Connect4UI.this,
						"Has perdido el juego!");
				dispose();
			}
		}.start();
	}

	@Override
	public void userLeaveGame(final String player) {
		new Thread() {
			public void run() {
				JOptionPane.showMessageDialog(Connect4UI.this, player
						+ " ha abandonado el juego. !Has ganado¡");
				dispose();
			}
		}.start();
	}

	private void thisWindowClosing(WindowEvent evt) {
		Controller.getInstance().leaveGame(game.getName());
		dispose();
	}
}
