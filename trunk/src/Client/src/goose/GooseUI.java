package goose;

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
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import chess.Chess.Player;

import logic.Controller;
import model.Game;
import model.User;
import presentation.GameUI;
import ProductLine.Slot;
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
public class GooseUI extends javax.swing.JFrame implements GameUI {

	private HTMLEditorKit htmlEditor;
	private HTMLDocument chatText;

	private String destinatary;
	private String username;
	private JLabel lbl_31;
	private JLabel lblOpponentName;
	private JTextPane txtChat;
	private JScrollPane pnlChat;
	private JTextField txtMessage;
	private JButton btnQuit;
	private JLabel lbl_1;
	private JLabel lbl_2;
	private JLabel lbl_3;
	private JLabel lbl_4;
	private JLabel lbl_5;
	private JLabel lbl_6;
	private JLabel lbl_7;
	private JLabel lbl_0;
	private JLabel lbl_60;
	private JLabel lbl_61;
	private JLabel lbl_62;
	private JLabel lbl_63;
	private JLabel lbl_64;
	private JLabel lbl_65;
	private JLabel lbl_66;
	private JLabel lbl_67;
	private JLabel lbl_50;
	private JLabel lbl_51;
	private JLabel lbl_52;
	private JLabel lbl_53;
	private JLabel lbl_54;
	private JLabel lbl_56;
	private JLabel lbl_55;
	private JLabel lbl_57;
	private JLabel lbl_40;
	private JLabel lbl_41;
	private JLabel lbl_42;
	private JLabel lbl_43;
	private JLabel lbl_44;
	private JLabel lbl_45;
	private JLabel lbl_46;
	private JLabel lbl_47;
	private JLabel lbl_30;
	private JLabel lbl_32;
	private JLabel lbl_33;
	private JLabel lbl_34;
	private JLabel lbl_35;
	private JLabel lbl_36;
	private JLabel lbl_37;
	private JLabel lbl_20;
	private JLabel lbl_21;
	private JLabel lbl_22;
	private JLabel lbl_23;
	private JLabel lbl_24;
	private JLabel lbl_25;
	private JLabel lbl_26;
	private JLabel lbl_27;
	private JLabel lbl_10;
	private JLabel lbl_11;
	private JLabel lbl_12;
	private JLabel lbl_13;
	private JLabel lbl_14;
	private JLabel lbl_15;
	private JLabel lbl_16;
	private JLabel lbl_17;
	private JLabel lbl_07;
	private JLabel lbl_06;
	private JLabel lbl_05;
	private JLabel lbl_04;
	private JLabel lbl_03;
	private JLabel lbl_02;
	private JLabel lbl_01;
	private JLabel lbl_00;
	private JPanel pnlBoard;
	private JLabel lblOpponentAvatar;
	private JPanel pnlBackground;
	private JLabel lblState;

	private static final Border blackBorder = new LineBorder(
			new java.awt.Color(0, 0, 0), 1, false);
	private static final Border redBorder = new LineBorder(new java.awt.Color(
			255, 0, 0), 4, false);
	private JButton btnThrow;
	private JLabel lblDice;
	private static final Border greenBorder = new LineBorder(
			new java.awt.Color(0, 255, 0), 4, false);
	private static final Border blueBorder = new LineBorder(new java.awt.Color(
			0, 0, 255), 4, false);

	private JLabel[][] boardUI;
	private Game game;
	private Player myPlayer;
	private Player playerTurn;
	private int selectedRow;
	private int selectedColumn;
	private boolean activeSquares;
	

	public GooseUI(String username, Game game) {
		super();
		this.username = username;
		this.game = game;
		destinatary = "";
		boardUI = new JLabel[8][8];

		myPlayer = Player.White;
		playerTurn = Player.White;
		Slot opponentSlot = game.getSlot(1);

		if (opponentSlot.getPlayer().equalsIgnoreCase(username)) {
			opponentSlot = game.getSlot(0);
			myPlayer = Player.Black;
		}

		initGUI();
		selectedRow = -1;

	//	User opponent = Controller.getInstance().searchUser(
	//			opponentSlot.getPlayer());
	//	lblOpponentAvatar.setIcon(new ImageIcon(opponent.getAvatar()));
	//	lblOpponentName.setText(opponent.getUsername());

		if (playerTurn == myPlayer) {
			activeSquares = true;
			lblState.setText("Es tu turno");
		} else {
		//	lblState.setText("Es el turno de " + opponent.getName());
			activeSquares = false;
		}
		repaint();
	}

	private void initGUI() {
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		pack();
		this.setSize(660, 732);
		setLocationRelativeTo(null);
		setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				thisWindowClosing(evt);
			}
		});
		getContentPane().add(getPnlBackground());
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
	}

	private JPanel getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setLayout(null);
			pnlBackground.setBounds(0, 0, 644, 694);
			pnlBackground.add(getLblOpponentAvatar());
			pnlBackground.add(getPnlBoard());
			pnlBackground.add(getBtnQuit());
			pnlBackground.add(getTxtMessage());
			pnlBackground.add(getPnlChat());
			pnlBackground.add(getLblOpponentName());
			pnlBackground.add(getLblState());
			pnlBackground.add(getLblDice());
			pnlBackground.add(getBtnThrow());
		}
		return pnlBackground;
	}

	private JLabel getLblOpponentAvatar() {
		if (lblOpponentAvatar == null) {
			lblOpponentAvatar = new JLabel();
			lblOpponentAvatar.setBounds(522, 11, 101, 124);
			lblOpponentAvatar.setBorder(new SoftBevelBorder(
					BevelBorder.LOWERED, null, null, null, null));
		}
		return lblOpponentAvatar;
	}

	private JPanel getPnlBoard() {
		if (pnlBoard == null) {
			pnlBoard = new JPanel();
			pnlBoard.setLayout(null);
			pnlBoard.setBounds(10, 11, 493, 492);
			pnlBoard.setBorder(BorderFactory.createTitledBorder(""));
			pnlBoard.add(getLbl_00());
			pnlBoard.add(getLbl_01());
			pnlBoard.add(getLbl_02());
			pnlBoard.add(getLbl_03());
			pnlBoard.add(getLbl_04());
			pnlBoard.add(getLbl_05());
			pnlBoard.add(getLbl_06());
			pnlBoard.add(getLbl_07());
			pnlBoard.add(getLbl_17());
			pnlBoard.add(getLbl_16());
			pnlBoard.add(getLbl_15());
			pnlBoard.add(getLbl_14());
			pnlBoard.add(getLbl_13());
			pnlBoard.add(getLbl_12());
			pnlBoard.add(getLbl_11());
			pnlBoard.add(getLbl_10());
			pnlBoard.add(getLbl_27());
			pnlBoard.add(getLbl_26());
			pnlBoard.add(getLbl_25());
			pnlBoard.add(getLbl_24());
			pnlBoard.add(getLbl_23());
			pnlBoard.add(getLbl_22());
			pnlBoard.add(getLbl_21());
			pnlBoard.add(getLbl_20());
			pnlBoard.add(getLbl_37());
			pnlBoard.add(getLbl_36());
			pnlBoard.add(getLbl_35());
			pnlBoard.add(getLbl_34());
			pnlBoard.add(getLbl_33());
			pnlBoard.add(getLbl_32());
			pnlBoard.add(getLbl_31());
			pnlBoard.add(getLbl_30());
			pnlBoard.add(getLbl_47());
			pnlBoard.add(getLbl_46());
			pnlBoard.add(getLbl_45());
			pnlBoard.add(getLbl_44());
			pnlBoard.add(getLbl_43());
			pnlBoard.add(getLbl_42());
			pnlBoard.add(getLbl_41());
			pnlBoard.add(getLbl_40());
			pnlBoard.add(getLbl_57());
			pnlBoard.add(getLbl_55());
			pnlBoard.add(getLbl_56());
			pnlBoard.add(getLbl_54());
			pnlBoard.add(getLbl_53());
			pnlBoard.add(getLbl_52());
			pnlBoard.add(getLbl_51());
			pnlBoard.add(getLbl_50());
			pnlBoard.add(getLbl_67());
			pnlBoard.add(getLbl_66());
			pnlBoard.add(getLbl_65());
			pnlBoard.add(getLbl_64());
			pnlBoard.add(getLbl_63());
			pnlBoard.add(getLbl_62());
			pnlBoard.add(getLbl_61());
			pnlBoard.add(getLbl_60());
			pnlBoard.add(getLbl_0());
			pnlBoard.add(getLbl_7());
			pnlBoard.add(getLbl_6());
			pnlBoard.add(getLbl_5());
			pnlBoard.add(getLbl_4());
			pnlBoard.add(getLbl_3());
			pnlBoard.add(getLbl_2());
			pnlBoard.add(getLbl_1());
		}
		return pnlBoard;
	}

	private JLabel getLbl_00() {
		if (lbl_00 == null) {
			lbl_00 = new JLabel();
			lbl_00.setBounds(7, 7, 60, 60);
			lbl_00.setBackground(new java.awt.Color(255, 255, 255));
			lbl_00.setOpaque(true);
			lbl_00.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_00.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_00.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/Black R.png")));
			boardUI[0][0] = lbl_00;
		}
		return lbl_00;
	}

	private JLabel getLbl_01() {
		if (lbl_01 == null) {
			lbl_01 = new JLabel();
			lbl_01.setBounds(67, 7, 60, 60);
			lbl_01.setOpaque(true);
			lbl_01.setBackground(new java.awt.Color(255,255,255));
			lbl_01.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_01.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/Black N.png")));
			lbl_01.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[0][1] = lbl_01;
		}
		return lbl_01;
	}

	private JLabel getLbl_02() {
		if (lbl_02 == null) {
			lbl_02 = new JLabel();
			lbl_02.setOpaque(true);
			lbl_02.setBackground(new java.awt.Color(255, 255, 255));
			lbl_02.setBounds(127, 7, 60, 60);
			lbl_02.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_02.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_02.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/Black B.png")));
			boardUI[0][2] = lbl_02;
		}
		return lbl_02;
	}

	private JLabel getLbl_03() {
		if (lbl_03 == null) {
			lbl_03 = new JLabel();
			lbl_03.setOpaque(true);
			lbl_03.setBackground(new java.awt.Color(255,255,255));
			lbl_03.setBounds(187, 7, 60, 60);
			lbl_03.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_03.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/Black Q.png")));
			lbl_03.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[0][3] = lbl_03;
		}
		return lbl_03;
	}

	private JLabel getLbl_04() {
		if (lbl_04 == null) {
			lbl_04 = new JLabel();
			lbl_04.setOpaque(true);
			lbl_04.setBackground(new java.awt.Color(255, 255, 255));
			lbl_04.setBounds(247, 7, 60, 60);
			lbl_04.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_04.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_04.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/Black K.png")));
			boardUI[0][4] = lbl_04;
		}
		return lbl_04;
	}

	private JLabel getLbl_05() {
		if (lbl_05 == null) {
			lbl_05 = new JLabel();
			lbl_05.setOpaque(true);
			lbl_05.setBackground(new java.awt.Color(255,255,255));
			lbl_05.setBounds(307, 7, 60, 60);
			lbl_05.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_05.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/Black B.png")));
			lbl_05.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[0][5] = lbl_05;
		}
		return lbl_05;
	}

	private JLabel getLbl_06() {
		if (lbl_06 == null) {
			lbl_06 = new JLabel();
			lbl_06.setOpaque(true);
			lbl_06.setBackground(new java.awt.Color(255, 255, 255));
			lbl_06.setBounds(367, 7, 60, 60);
			lbl_06.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_06.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_06.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/Black N.png")));
			boardUI[0][6] = lbl_06;
		}
		return lbl_06;
	}

	private JLabel getLbl_07() {
		if (lbl_07 == null) {
			lbl_07 = new JLabel();
			lbl_07.setBounds(427, 7, 60, 60);
			lbl_07.setBackground(new java.awt.Color(255,255,255));
			lbl_07.setOpaque(true);
			lbl_07.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_07.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/Black R.png")));
			lbl_07.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[0][7] = lbl_07;
		}
		return lbl_07;
	}

	private JLabel getLbl_17() {
		if (lbl_17 == null) {
			lbl_17 = new JLabel();
			lbl_17.setOpaque(true);
			lbl_17.setBackground(new java.awt.Color(255, 255, 255));
			lbl_17.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_17.setBounds(427, 67, 60, 60);
			lbl_17.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_17.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/Black P.png")));
			boardUI[1][7] = lbl_17;
		}
		return lbl_17;
	}

	private JLabel getLbl_16() {
		if (lbl_16 == null) {
			lbl_16 = new JLabel();
			lbl_16.setOpaque(true);
			lbl_16.setBackground(new java.awt.Color(255,255,255));
			lbl_16.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_16.setBounds(367, 67, 60, 60);
			lbl_16.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/Black P.png")));
			lbl_16.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[1][6] = lbl_16;
		}
		return lbl_16;
	}

	private JLabel getLbl_15() {
		if (lbl_15 == null) {
			lbl_15 = new JLabel();
			lbl_15.setOpaque(true);
			lbl_15.setBackground(new java.awt.Color(255, 255, 255));
			lbl_15.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_15.setBounds(307, 67, 60, 60);
			lbl_15.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_15.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/Black P.png")));
			boardUI[1][5] = lbl_15;
		}
		return lbl_15;
	}

	private JLabel getLbl_14() {
		if (lbl_14 == null) {
			lbl_14 = new JLabel();
			lbl_14.setOpaque(true);
			lbl_14.setBackground(new java.awt.Color(255,255,255));
			lbl_14.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_14.setBounds(247, 67, 60, 60);
			lbl_14.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/Black P.png")));
			lbl_14.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[1][4] = lbl_14;
		}
		return lbl_14;
	}

	private JLabel getLbl_13() {
		if (lbl_13 == null) {
			lbl_13 = new JLabel();
			lbl_13.setOpaque(true);
			lbl_13.setBackground(new java.awt.Color(255, 255, 255));
			lbl_13.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_13.setBounds(187, 67, 60, 60);
			lbl_13.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_13.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/Black P.png")));
			boardUI[1][3] = lbl_13;
		}
		return lbl_13;
	}

	private JLabel getLbl_12() {
		if (lbl_12 == null) {
			lbl_12 = new JLabel();
			lbl_12.setOpaque(true);
			lbl_12.setBackground(new java.awt.Color(255,255,255));
			lbl_12.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_12.setBounds(127, 67, 60, 60);
			lbl_12.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/Black P.png")));
			lbl_12.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[1][2] = lbl_12;
		}
		return lbl_12;
	}

	private JLabel getLbl_11() {
		if (lbl_11 == null) {
			lbl_11 = new JLabel();
			lbl_11.setOpaque(true);
			lbl_11.setBackground(new java.awt.Color(255, 255, 255));
			lbl_11.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_11.setBounds(67, 67, 60, 60);
			lbl_11.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_11.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/Black P.png")));
			boardUI[1][1] = lbl_11;
		}
		return lbl_11;
	}

	private JLabel getLbl_10() {
		if (lbl_10 == null) {
			lbl_10 = new JLabel();
			lbl_10.setOpaque(true);
			lbl_10.setBackground(new java.awt.Color(255,255,255));
			lbl_10.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_10.setBounds(7, 67, 60, 60);
			lbl_10.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/Black P.png")));
			lbl_10.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[1][0] = lbl_10;
		}
		return lbl_10;
	}

	private JLabel getLbl_27() {
		if (lbl_27 == null) {
			lbl_27 = new JLabel();
			lbl_27.setOpaque(true);
			lbl_27.setBackground(new java.awt.Color(255,255,255));
			lbl_27.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_27.setBounds(427, 127, 60, 60);
			lbl_27.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[2][7] = lbl_27;
		}
		return lbl_27;
	}

	private JLabel getLbl_26() {
		if (lbl_26 == null) {
			lbl_26 = new JLabel();
			lbl_26.setOpaque(true);
			lbl_26.setBackground(new java.awt.Color(255, 255, 255));
			lbl_26.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_26.setBounds(367, 127, 60, 60);
			lbl_26.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[2][6] = lbl_26;
		}
		return lbl_26;
	}

	private JLabel getLbl_25() {
		if (lbl_25 == null) {
			lbl_25 = new JLabel();
			lbl_25.setOpaque(true);
			lbl_25.setBackground(new java.awt.Color(255,255,255));
			lbl_25.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_25.setBounds(307, 127, 60, 60);
			lbl_25.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[2][5] = lbl_25;
		}
		return lbl_25;
	}

	private JLabel getLbl_24() {
		if (lbl_24 == null) {
			lbl_24 = new JLabel();
			lbl_24.setOpaque(true);
			lbl_24.setBackground(new java.awt.Color(255, 255, 255));
			lbl_24.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_24.setBounds(247, 127, 60, 60);
			lbl_24.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[2][4] = lbl_24;
		}
		return lbl_24;
	}

	private JLabel getLbl_23() {
		if (lbl_23 == null) {
			lbl_23 = new JLabel();
			lbl_23.setOpaque(true);
			lbl_23.setBackground(new java.awt.Color(255,255,255));
			lbl_23.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_23.setBounds(187, 127, 60, 60);
			lbl_23.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[2][3] = lbl_23;
		}
		return lbl_23;
	}

	private JLabel getLbl_22() {
		if (lbl_22 == null) {
			lbl_22 = new JLabel();
			lbl_22.setOpaque(true);
			lbl_22.setBackground(new java.awt.Color(255, 255, 255));
			lbl_22.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_22.setBounds(127, 127, 60, 60);
			lbl_22.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[2][2] = lbl_22;
		}
		return lbl_22;
	}

	private JLabel getLbl_21() {
		if (lbl_21 == null) {
			lbl_21 = new JLabel();
			lbl_21.setOpaque(true);
			lbl_21.setBackground(new java.awt.Color(255,255,255));
			lbl_21.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_21.setBounds(67, 127, 60, 60);
			lbl_21.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[2][1] = lbl_21;
		}
		return lbl_21;
	}

	private JLabel getLbl_20() {
		if (lbl_20 == null) {
			lbl_20 = new JLabel();
			lbl_20.setOpaque(true);
			lbl_20.setBackground(new java.awt.Color(255, 255, 255));
			lbl_20.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_20.setBounds(7, 127, 60, 60);
			lbl_20.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[2][0] = lbl_20;
		}
		return lbl_20;
	}

	private JLabel getLbl_37() {
		if (lbl_37 == null) {
			lbl_37 = new JLabel();
			lbl_37.setOpaque(true);
			lbl_37.setBackground(new java.awt.Color(255, 255, 255));
			lbl_37.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_37.setBounds(427, 186, 60, 60);
			lbl_37.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[3][7] = lbl_37;
		}
		return lbl_37;
	}

	private JLabel getLbl_36() {
		if (lbl_36 == null) {
			lbl_36 = new JLabel();
			lbl_36.setOpaque(true);
			lbl_36.setBackground(new java.awt.Color(255,255,255));
			lbl_36.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_36.setBounds(367, 186, 60, 60);
			lbl_36.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[3][6] = lbl_36;
		}
		return lbl_36;
	}

	private JLabel getLbl_35() {
		if (lbl_35 == null) {
			lbl_35 = new JLabel();
			lbl_35.setOpaque(true);
			lbl_35.setBackground(new java.awt.Color(255, 255, 255));
			lbl_35.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_35.setBounds(307, 186, 60, 60);
			lbl_35.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[3][5] = lbl_35;
		}
		return lbl_35;
	}

	private JLabel getLbl_34() {
		if (lbl_34 == null) {
			lbl_34 = new JLabel();
			lbl_34.setOpaque(true);
			lbl_34.setBackground(new java.awt.Color(255,255,255));
			lbl_34.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_34.setBounds(247, 186, 60, 60);
			lbl_34.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[3][4] = lbl_34;
		}
		return lbl_34;
	}

	private JLabel getLbl_33() {
		if (lbl_33 == null) {
			lbl_33 = new JLabel();
			lbl_33.setOpaque(true);
			lbl_33.setBackground(new java.awt.Color(255, 255, 255));
			lbl_33.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_33.setBounds(187, 186, 60, 60);
			lbl_33.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[3][3] = lbl_33;
		}
		return lbl_33;
	}

	private JLabel getLbl_32() {
		if (lbl_32 == null) {
			lbl_32 = new JLabel();
			lbl_32.setOpaque(true);
			lbl_32.setBackground(new java.awt.Color(255,255,255));
			lbl_32.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_32.setBounds(127, 186, 60, 60);
			lbl_32.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[3][2] = lbl_32;
		}
		return lbl_32;
	}

	private JLabel getLbl_31() {
		if (lbl_31 == null) {
			lbl_31 = new JLabel();
			lbl_31.setOpaque(true);
			lbl_31.setBackground(new java.awt.Color(255, 255, 255));
			lbl_31.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_31.setBounds(67, 186, 60, 60);
			lbl_31.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[3][1] = lbl_31;
		}
		return lbl_31;
	}

	private JLabel getLbl_30() {
		if (lbl_30 == null) {
			lbl_30 = new JLabel();
			lbl_30.setOpaque(true);
			lbl_30.setBackground(new java.awt.Color(255,255,255));
			lbl_30.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_30.setBounds(7, 186, 60, 60);
			lbl_30.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[3][0] = lbl_30;
		}
		return lbl_30;
	}

	private JLabel getLbl_47() {
		if (lbl_47 == null) {
			lbl_47 = new JLabel();
			lbl_47.setOpaque(true);
			lbl_47.setBackground(new java.awt.Color(255,255,255));
			lbl_47.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_47.setBounds(427, 246, 60, 60);
			lbl_47.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[4][7] = lbl_47;
		}
		return lbl_47;
	}

	private JLabel getLbl_46() {
		if (lbl_46 == null) {
			lbl_46 = new JLabel();
			lbl_46.setOpaque(true);
			lbl_46.setBackground(new java.awt.Color(255, 255, 255));
			lbl_46.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_46.setBounds(367, 246, 60, 60);
			lbl_46.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[4][6] = lbl_46;
		}
		return lbl_46;
	}

	private JLabel getLbl_45() {
		if (lbl_45 == null) {
			lbl_45 = new JLabel();
			lbl_45.setOpaque(true);
			lbl_45.setBackground(new java.awt.Color(255,255,255));
			lbl_45.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_45.setBounds(307, 246, 60, 60);
			lbl_45.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[4][5] = lbl_45;
		}
		return lbl_45;
	}

	private JLabel getLbl_44() {
		if (lbl_44 == null) {
			lbl_44 = new JLabel();
			lbl_44.setOpaque(true);
			lbl_44.setBackground(new java.awt.Color(255, 255, 255));
			lbl_44.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_44.setBounds(247, 246, 60, 60);
			lbl_44.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[4][4] = lbl_44;
		}
		return lbl_44;
	}

	private JLabel getLbl_43() {
		if (lbl_43 == null) {
			lbl_43 = new JLabel();
			lbl_43.setOpaque(true);
			lbl_43.setBackground(new java.awt.Color(255,255,255));
			lbl_43.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_43.setBounds(187, 246, 60, 60);
			lbl_43.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[4][3] = lbl_43;
		}
		return lbl_43;
	}

	private JLabel getLbl_42() {
		if (lbl_42 == null) {
			lbl_42 = new JLabel();
			lbl_42.setOpaque(true);
			lbl_42.setBackground(new java.awt.Color(255, 255, 255));
			lbl_42.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_42.setBounds(127, 246, 60, 60);
			lbl_42.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[4][2] = lbl_42;
		}
		return lbl_42;
	}

	private JLabel getLbl_41() {
		if (lbl_41 == null) {
			lbl_41 = new JLabel();
			lbl_41.setOpaque(true);
			lbl_41.setBackground(new java.awt.Color(255,255,255));
			lbl_41.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_41.setBounds(67, 246, 60, 60);
			lbl_41.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[4][1] = lbl_41;
		}
		return lbl_41;
	}

	private JLabel getLbl_40() {
		if (lbl_40 == null) {
			lbl_40 = new JLabel();
			lbl_40.setOpaque(true);
			lbl_40.setBackground(new java.awt.Color(255, 255, 255));
			lbl_40.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_40.setBounds(7, 246, 60, 60);
			lbl_40.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[4][0] = lbl_40;
		}
		return lbl_40;
	}

	private JLabel getLbl_57() {
		if (lbl_57 == null) {
			lbl_57 = new JLabel();
			lbl_57.setOpaque(true);
			lbl_57.setBackground(new java.awt.Color(255, 255, 255));
			lbl_57.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_57.setBounds(427, 306, 60, 60);
			lbl_57.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[5][7] = lbl_57;
		}
		return lbl_57;
	}

	private JLabel getLbl_55() {
		if (lbl_55 == null) {
			lbl_55 = new JLabel();
			lbl_55.setOpaque(true);
			lbl_55.setBackground(new java.awt.Color(255, 255, 255));
			lbl_55.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_55.setBounds(307, 306, 60, 60);
			lbl_55.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[5][5] = lbl_55;
		}
		return lbl_55;
	}

	private JLabel getLbl_56() {
		if (lbl_56 == null) {
			lbl_56 = new JLabel();
			lbl_56.setOpaque(true);
			lbl_56.setBackground(new java.awt.Color(255,255,255));
			lbl_56.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_56.setBounds(367, 306, 60, 60);
			lbl_56.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[5][6] = lbl_56;
		}
		return lbl_56;
	}

	private JLabel getLbl_54() {
		if (lbl_54 == null) {
			lbl_54 = new JLabel();
			lbl_54.setOpaque(true);
			lbl_54.setBackground(new java.awt.Color(255,255,255));
			lbl_54.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_54.setBounds(247, 306, 60, 60);
			lbl_54.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[5][4] = lbl_54;
		}
		return lbl_54;
	}

	private JLabel getLbl_53() {
		if (lbl_53 == null) {
			lbl_53 = new JLabel();
			lbl_53.setOpaque(true);
			lbl_53.setBackground(new java.awt.Color(255, 255, 255));
			lbl_53.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_53.setBounds(187, 306, 60, 60);
			lbl_53.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[5][3] = lbl_53;
		}
		return lbl_53;
	}

	private JLabel getLbl_52() {
		if (lbl_52 == null) {
			lbl_52 = new JLabel();
			lbl_52.setOpaque(true);
			lbl_52.setBackground(new java.awt.Color(255,255,255));
			lbl_52.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_52.setBounds(127, 306, 60, 60);
			lbl_52.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[5][2] = lbl_52;
		}
		return lbl_52;
	}

	private JLabel getLbl_51() {
		if (lbl_51 == null) {
			lbl_51 = new JLabel();
			lbl_51.setOpaque(true);
			lbl_51.setBackground(new java.awt.Color(255, 255, 255));
			lbl_51.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_51.setBounds(67, 306, 60, 60);
			lbl_51.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[5][1] = lbl_51;
		}
		return lbl_51;
	}

	private JLabel getLbl_50() {
		if (lbl_50 == null) {
			lbl_50 = new JLabel();
			lbl_50.setOpaque(true);
			lbl_50.setBackground(new java.awt.Color(255,255,255));
			lbl_50.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_50.setBounds(7, 306, 60, 60);
			lbl_50.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[5][0] = lbl_50;
		}
		return lbl_50;
	}

	private JLabel getLbl_67() {
		if (lbl_67 == null) {
			lbl_67 = new JLabel();
			lbl_67.setOpaque(true);
			lbl_67.setBackground(new java.awt.Color(255,255,255));
			lbl_67.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_67.setBounds(427, 366, 60, 60);
			lbl_67.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/White P.png")));
			lbl_67.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[6][7] = lbl_67;
		}
		return lbl_67;
	}

	private JLabel getLbl_66() {
		if (lbl_66 == null) {
			lbl_66 = new JLabel();
			lbl_66.setOpaque(true);
			lbl_66.setBackground(new java.awt.Color(255, 255, 255));
			lbl_66.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_66.setBounds(367, 366, 60, 60);
			lbl_66.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_66.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/White P.png")));
			boardUI[6][6] = lbl_66;
		}
		return lbl_66;
	}

	private JLabel getLbl_65() {
		if (lbl_65 == null) {
			lbl_65 = new JLabel();
			lbl_65.setOpaque(true);
			lbl_65.setBackground(new java.awt.Color(255,255,255));
			lbl_65.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_65.setBounds(307, 366, 60, 60);
			lbl_65.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/White P.png")));
			lbl_65.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[6][5] = lbl_65;
		}
		return lbl_65;
	}

	private JLabel getLbl_64() {
		if (lbl_64 == null) {
			lbl_64 = new JLabel();
			lbl_64.setOpaque(true);
			lbl_64.setBackground(new java.awt.Color(255, 255, 255));
			lbl_64.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_64.setBounds(247, 366, 60, 60);
			lbl_64.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_64.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/White P.png")));
			boardUI[6][4] = lbl_64;
		}
		return lbl_64;
	}

	private JLabel getLbl_63() {
		if (lbl_63 == null) {
			lbl_63 = new JLabel();
			lbl_63.setOpaque(true);
			lbl_63.setBackground(new java.awt.Color(255,255,255));
			lbl_63.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_63.setBounds(187, 366, 60, 60);
			lbl_63.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/White P.png")));
			lbl_63.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[6][3] = lbl_63;
		}
		return lbl_63;
	}

	private JLabel getLbl_62() {
		if (lbl_62 == null) {
			lbl_62 = new JLabel();
			lbl_62.setOpaque(true);
			lbl_62.setBackground(new java.awt.Color(255, 255, 255));
			lbl_62.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_62.setBounds(127, 366, 60, 60);
			lbl_62.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_62.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/White P.png")));
			boardUI[6][2] = lbl_62;
		}
		return lbl_62;
	}

	private JLabel getLbl_61() {
		if (lbl_61 == null) {
			lbl_61 = new JLabel();
			lbl_61.setOpaque(true);
			lbl_61.setBackground(new java.awt.Color(255,255,255));
			lbl_61.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_61.setBounds(67, 366, 60, 60);
			lbl_61.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/White P.png")));
			lbl_61.setHorizontalAlignment(SwingConstants.CENTER);
			boardUI[6][1] = lbl_61;
		}
		return lbl_61;
	}

	private JLabel getLbl_60() {
		if (lbl_60 == null) {
			lbl_60 = new JLabel();
			lbl_60.setOpaque(true);
			lbl_60.setBackground(new java.awt.Color(255, 255, 255));
			lbl_60.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_60.setBounds(7, 366, 60, 60);
			lbl_60.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_60.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/White P.png")));
			boardUI[6][0] = lbl_60;
		}
		return lbl_60;
	}

	private JLabel getLbl_0() {
		if (lbl_0 == null) {
			lbl_0 = new JLabel();
			lbl_0.setOpaque(true);
			lbl_0.setBackground(new java.awt.Color(255,255,255));
			lbl_0.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_0.setBounds(7, 426, 60, 60);
			lbl_0.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_0.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/White R.png")));
			boardUI[7][0] = lbl_0;
		}
		return lbl_0;
	}

	private JLabel getLbl_7() {
		if (lbl_7 == null) {
			lbl_7 = new JLabel();
			lbl_7.setOpaque(true);
			lbl_7.setBackground(new java.awt.Color(255, 255, 255));
			lbl_7.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_7.setBounds(427, 426, 60, 60);
			lbl_7.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_7.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/White R.png")));
			boardUI[7][7] = lbl_7;
		}
		return lbl_7;
	}

	private JLabel getLbl_6() {
		if (lbl_6 == null) {
			lbl_6 = new JLabel();
			lbl_6.setOpaque(true);
			lbl_6.setBackground(new java.awt.Color(255,255,255));
			lbl_6.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_6.setBounds(367, 426, 60, 60);
			lbl_6.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_6.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/White N.png")));
			boardUI[7][6] = lbl_6;
		}
		return lbl_6;
	}

	private JLabel getLbl_5() {
		if (lbl_5 == null) {
			lbl_5 = new JLabel();
			lbl_5.setOpaque(true);
			lbl_5.setBackground(new java.awt.Color(255, 255, 255));
			lbl_5.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_5.setBounds(307, 426, 60, 60);
			lbl_5.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_5.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/White B.png")));
			boardUI[7][5] = lbl_5;
		}
		return lbl_5;
	}

	private JLabel getLbl_4() {
		if (lbl_4 == null) {
			lbl_4 = new JLabel();
			lbl_4.setOpaque(true);
			lbl_4.setBackground(new java.awt.Color(255,255,255));
			lbl_4.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_4.setBounds(247, 426, 60, 60);
			lbl_4.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_4.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/White K.png")));
			boardUI[7][4] = lbl_4;
		}
		return lbl_4;
	}

	private JLabel getLbl_3() {
		if (lbl_3 == null) {
			lbl_3 = new JLabel();
			lbl_3.setOpaque(true);
			lbl_3.setBackground(new java.awt.Color(255, 255, 255));
			lbl_3.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_3.setBounds(187, 426, 60, 60);
			lbl_3.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_3.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/White Q.png")));
			boardUI[7][3] = lbl_3;
		}
		return lbl_3;
	}

	private JLabel getLbl_2() {
		if (lbl_2 == null) {
			lbl_2 = new JLabel();
			lbl_2.setOpaque(true);
			lbl_2.setBackground(new java.awt.Color(255,255,255));
			lbl_2.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_2.setBounds(127, 426, 60, 60);
			lbl_2.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_2.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/White B.png")));
			boardUI[7][2] = lbl_2;
		}
		return lbl_2;
	}

	private JLabel getLbl_1() {
		if (lbl_1 == null) {
			lbl_1 = new JLabel();
			lbl_1.setOpaque(true);
			lbl_1.setBackground(new java.awt.Color(255, 255, 255));
			lbl_1.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_1.setBounds(67, 426, 60, 60);
			lbl_1.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_1.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Chess/White N.png")));
			boardUI[7][1] = lbl_1;
		}
		return lbl_1;
	}

	private JButton getBtnQuit() {
		if (btnQuit == null) {
			btnQuit = new JButton();
			btnQuit.setText("Quit");
			btnQuit.setBounds(538, 660, 86, 23);
			btnQuit.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnQuitMouseClicked(evt);
				}
			});
		}
		return btnQuit;
	}

	private JTextField getTxtMessage() {
		if (txtMessage == null) {
			txtMessage = new JTextField();
			txtMessage.setText(null);
			txtMessage.setBounds(10, 663, 493, 20);
			txtMessage.setText(null);
			txtMessage.setText(null);
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
			pnlChat.setBounds(10, 527, 493, 128);
			pnlChat.setViewportView(getTxtChat());
		}
		return pnlChat;
	}

	private JTextPane getTxtChat() {
		if (txtChat == null) {

			htmlEditor = new HTMLEditorKit();

			chatText = new HTMLDocument();

			txtChat = new JTextPane();
			txtChat.setEditable(false);
			txtChat.setEditorKit(htmlEditor);
			txtChat.setDocument(chatText);
		}
		return txtChat;
	}

	private JLabel getLblOpponentName() {
		if (lblOpponentName == null) {
			lblOpponentName = new JLabel();
			lblOpponentName.setHorizontalAlignment(SwingConstants.CENTER);
			lblOpponentName.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblOpponentName.setBorder(BorderFactory.createTitledBorder(""));
			lblOpponentName.setBounds(522, 141, 102, 16);
		}
		return lblOpponentName;
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
		} catch (BadLocationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateBoard() {
		int turn = game.changeTurn();
		playerTurn = toChessTurn(turn);
		activeSquares = true;
		refreshBoard();
		lblState.setText("Es tu turno");
	}

	private Player toChessTurn(int turn) {
		if(turn == 0)
			return Player.White;
		
		return Player.Black;
	}

	@Override
	public void lostGame() {
		refreshBoard();
		lblState.setText("Has perdido la partida");
		activeSquares = false;
		new Thread() {
			public void run() {
				JOptionPane.showMessageDialog(GooseUI.this,
						"Has perdido el juego!");
				dispose();
			}
		}.start();
	}

	@Override
	public void userLeaveGame(final String player) {
		new Thread() {
			public void run() {
				JOptionPane.showMessageDialog(GooseUI.this, player
						+ " ha abandonado el juego. !Has ganado¡");
				dispose();
			}
		}.start();

	}

	public void refreshBoard() {
		
	}

	private JLabel getLblState() {
		if (lblState == null) {
			lblState = new JLabel();
			lblState.setBounds(10, 503, 493, 18);
			lblState.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblState;
	}

	private void btnQuitMouseClicked(MouseEvent evt) {
		Controller.getInstance().leaveGame(game.getName());
		dispose();
	}

	private void thisWindowClosing(WindowEvent evt) {
		Controller.getInstance().leaveGame(game.getName());
		dispose();
	}
	
	private JLabel getLblDice() {
		if(lblDice == null) {
			lblDice = new JLabel();
			lblDice.setBounds(522, 273, 112, 139);
			lblDice.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			lblDice.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/Dice/4.png")));
			lblDice.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblDice;
	}
	
	private JButton getBtnThrow() {
		if(btnThrow == null) {
			btnThrow = new JButton();
			btnThrow.setText("Throw");
			btnThrow.setBounds(548, 534, 63, 23);
			btnThrow.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnThrowMouseClicked(evt);
				}
			});
		}
		return btnThrow;
	}
	
	private void btnThrowMouseClicked(MouseEvent evt) {
		new Thread(){
			public void run(){
				for(int i=0; i<10;i++){				
					int result = Goose.throwDice();
					lblDice.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/Dice/"+result+".png")));
					try {
						sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

}
