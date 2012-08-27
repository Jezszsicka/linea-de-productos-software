package ludo;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import logic.Controller;
import model.Game;
import model.User;
import presentation.GameUI;
import ProductLine.Slot;
import ProductLine.SlotState;
import ProductLine.UserNotInGameException;
import constants.Constants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import presentation.JPanelRound;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class LudoUI extends JFrame implements GameUI {
	private JPanelRound pnlBackground;
	private JPanel pnlBoard;
	private JPanel pnlYellowPlayer;
	private JPanel pnlBluePlayer;
	private JPanel pnlRedPlayer;
	private JPanel pnlGreenPlayer;
	private JLabel lblEndBlue;
	private JLabel lblEndYellow;
	private JLabel lblEndGreen;
	private JLabel lblEndRed;
	private JPanel pnlCenter;
	private JLabel lbl_16;
	private JLabel lbl_15;
	private JLabel lbl_14;
	private JLabel lbl_13;
	private JLabel lbl_12;
	private JLabel lbl_11;
	private JPanel pnlBlueSide;
	private JLabel lbl_10;
	private JLabel lbl_9;
	private JLabel lbl_17;
	private JLabel lbl_85;
	private JLabel lbl_86;
	private JLabel lbl_87;
	private JLabel lbl_88;
	private JLabel lbl_89;
	private JLabel lbl_90;
	private JLabel lbl_91;
	private JLabel lbl_18;
	private JLabel lbl_19;
	private JLabel lbl_20;
	private JLabel lbl_21;
	private JLabel lbl_22;
	private JLabel lbl_23;
	private JLabel lbl_24;
	private JPanel pnlGreenSide;
	private JLabel lbl_59;
	private JLabel lbl_58;
	private JLabel lbl_57;
	private JLabel lbl_56;
	private JLabel lbl_55;
	private JLabel lbl_54;
	private JLabel lbl_53;
	private JLabel lbl_52;
	private JLabel lbl_99;
	private JLabel lbl_98;
	private JLabel lbl_97;
	private JLabel lbl_96;
	private JLabel lbl_95;
	private JLabel lbl_94;
	private JLabel lbl_93;
	private JLabel lbl_51;
	private JLabel lbl_43;
	private JLabel lbl_44;
	private JLabel lbl_45;
	private JLabel lbl_46;
	private JLabel lbl_47;
	private JLabel lbl_48;
	private JLabel lbl_49;
	private JLabel lbl_50;
	private JPanel pnlRedSide;
	private JLabel lbl_33;
	private JLabel lbl_34;
	private JLabel lbl_35;
	private JLabel lbl_32;
	private JLabel lbl_77;
	private JLabel lbl_36;
	private JLabel lbl_30;
	private JLabel lbl_79;
	private JLabel lbl_38;
	private JLabel lbl_37;
	private JLabel lbl_78;
	private JLabel lbl_31;
	private JLabel lbl_25;
	private JLabel lbl_26;
	private JLabel lbl_27;
	private JLabel lbl_28;
	private JLabel lbl_29;
	private JLabel lbl_80;
	private JLabel lbl_81;
	private JLabel lbl_82;
	private JLabel lbl_83;
	private JLabel lbl_42;
	private JLabel lbl_41;
	private JLabel lbl_40;
	private JLabel lbl_39;
	private JPanel pnlYellowSide;
	private JLabel lbl_8;
	private JLabel lbl_75;
	private JLabel lbl_60;
	private JLabel lbl_7;
	private JLabel lbl_74;
	private JLabel lbl_61;
	private JLabel lbl_5;
	private JLabel lbl_72;
	private JLabel lbl_63;
	private JLabel lbl_62;
	private JLabel lbl_73;
	private JLabel lbl_6;
	private JLabel lbl_1;
	private JLabel lbl_2;
	private JLabel lbl_3;
	private JLabel lbl_4;
	private JLabel lbl_71;
	private JLabel lbl_70;
	private JLabel lbl_69;
	private JLabel lbl_68;
	private JLabel lbl_67;
	private JLabel lbl_66;
	private JLabel lbl_65;
	private JLabel lbl_64;

	private JLabel lblYellowPlayerAvatar;
	private JLabel lblYellowPlayerName;
	private JLabel lblGreenPlayerAvatar;
	private JLabel lblGreenPlayerName;
	private JLabel lblRedPlayerAvatar;
	private JLabel lblRedPlayerName;
	private JLabel lblBluePlayerAvatar;
	private JLabel lblBluePlayerName;
	private JLabel lblBlueDice;
	private JLabel lblRedDice;
	private JLabel lblGreenDice;
	private JLabel lblYellowDice;
	private JButton btnQuit;
	private JTextField txtMessage;
	private JScrollPane scrollPane;
	private JTextPane txtChat;
	private JLabel lblState;
	private JLabel lblYellowPiece1;
	private JLabel lblYellowPiece2;
	private JLabel lblYellowPiece3;
	private JLabel lblYellowPiece4;
	private JLabel lblBluePiece1;
	private JLabel lblBluePiece2;
	private JLabel lblBluePiece3;
	private JLabel lblBluePiece4;
	private JLabel lblRedPiece1;
	private JLabel lblRedPiece2;
	private JLabel lblRedPiece3;
	private JLabel lblRedPiece4;
	private JLabel lblGreenPiece1;
	private JLabel lblGreenPiece2;
	private JLabel lblGreenPiece3;
	private JLabel lblGreenPiece4;

	private boolean yellowDice;
	private boolean redDice;
	private boolean blueDice;
	private boolean greenDice;

	private HTMLEditorKit htmlEditor;
	private HTMLDocument chatText;
	private String destinatary;

	private String username;
	private Game game;
	private int playerTurn;
	private int myPlayer;
	private int dice;
	private int sixes;
	private JLabel[] squares;
	private JLabel[] yellowPieces;
	private JLabel[] redPieces;
	private JLabel[] bluePieces;
	private JLabel[] greenPieces;
	private boolean[] enabledSquares;

	private boolean throwing;
	private boolean count20;
	private ThrowDiceThread throwDice;
	private JButton btnNewButton;

	public LudoUI(String username, Game game) {
		setTitle("Ludo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				LudoUI.class.getResource("/images/Games/ludo_icon.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				thisWindowClosing(arg0);
			}
		});
		this.username = username;
		this.game = game;
		squares = new JLabel[101];
		enabledSquares = new boolean[101];
		yellowPieces = new JLabel[4];
		redPieces = new JLabel[4];
		bluePieces = new JLabel[4];
		greenPieces = new JLabel[4];
		sixes = 0;
		destinatary = "";
		initGUI();
		initPlayers();
		initPieces();

		if (myPlayer == Ludo.YELLOW) {
			lblState.setText("Es tu turno, lanza el dado");
			enableDice(myPlayer);
		} else {
			lblState.setText("Es el turno de " + lblYellowPlayerName.getText());
			diceAnimation(playerTurn);
		}
	}

	private void initPlayers() {
		for (int i = 0; i < 4; i++) {
			Slot slot = game.getSlot(i);
			if (slot.getType() == SlotState.Human
					|| slot.getType() == SlotState.Computer) {
				String slotName = slot.getPlayer();
				ImageIcon icon;

				if (slot.getType() == SlotState.Computer) {
					slotName = "Computer";
					icon = new ImageIcon(
							LudoUI.class.getResource("/images/computer.png"));
				} else {
					User slotUser = Controller.getInstance().searchUser(
							slotName);
					if (slotUser.getAvatar().length != 0)
						icon = new ImageIcon(slotUser.getAvatar());
					else
						icon = new ImageIcon(
								LudoUI.class
										.getResource("/images/no_avatar_icon.png"));

				}

				int player = -1;

				switch (i) {
				case Ludo.YELLOW:
					player = Ludo.YELLOW;
					lblYellowPlayerName.setText(slotName);
					lblYellowPlayerAvatar.setIcon(icon);
					break;
				case Ludo.RED:
					player = Ludo.RED;
					lblRedPlayerName.setText(slotName);
					lblRedPlayerAvatar.setIcon(icon);
					break;
				case Ludo.BLUE:
					player = Ludo.BLUE;
					lblBluePlayerName.setText(slotName);
					lblBluePlayerAvatar.setIcon(icon);
					lblBluePlayerAvatar.setBorder(new BevelBorder(
							BevelBorder.LOWERED, null, null, null, null));
					break;
				case Ludo.GREEN:
					player = Ludo.GREEN;
					lblGreenPlayerName.setText(slotName);
					lblGreenPlayerAvatar.setIcon(icon);
					lblGreenPlayerAvatar.setBorder(new BevelBorder(
							BevelBorder.LOWERED, null, null, null, null));
					break;
				}

				if (slot.getPlayer().equalsIgnoreCase(username))
					myPlayer = player;
			}
		}
		playerTurn = Ludo.YELLOW;
	}

	private void enableDice(int player) {
		switch (player) {
		case Ludo.YELLOW:
			yellowDice = true;
			redDice = false;
			blueDice = false;
			greenDice = false;
			break;
		case Ludo.RED:
			yellowDice = false;
			redDice = true;
			blueDice = false;
			greenDice = false;
			break;
		case Ludo.BLUE:
			yellowDice = false;
			redDice = false;
			blueDice = true;
			greenDice = false;
			break;
		case Ludo.GREEN:
			yellowDice = false;
			redDice = false;
			blueDice = false;
			greenDice = true;
			break;
		}

		setDefaultCursor();
	}

	private void disableDices() {
		yellowDice = false;
		redDice = false;
		blueDice = false;
		greenDice = false;
		setDefaultCursor();

	}

	private void initPieces() {
		yellowPieces[0] = lblYellowPiece1;
		yellowPieces[1] = lblYellowPiece2;
		yellowPieces[2] = lblYellowPiece3;
		yellowPieces[3] = lblYellowPiece4;

		redPieces[0] = lblRedPiece1;
		redPieces[1] = lblRedPiece2;
		redPieces[2] = lblRedPiece3;
		redPieces[3] = lblRedPiece4;

		bluePieces[0] = lblBluePiece1;
		bluePieces[1] = lblBluePiece2;
		bluePieces[2] = lblBluePiece3;
		bluePieces[3] = lblBluePiece4;

		greenPieces[0] = lblGreenPiece1;
		greenPieces[1] = lblGreenPiece2;
		greenPieces[2] = lblGreenPiece3;
		greenPieces[3] = lblGreenPiece4;

	}

	private void initGUI() {
		setSize(new Dimension(647, 822));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		getContentPane().add(getPnlBackground());
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private JPanelRound getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanelRound();
			pnlBackground.setArcw(0);
			pnlBackground.setArch(0);
			pnlBackground.setBounds(0, 0, 642, 797);
			pnlBackground.setLayout(null);
			pnlBackground.add(getPnlBoard());
			pnlBackground.add(getBtnQuit());
			pnlBackground.add(getTxtMessage());
			pnlBackground.add(getScrollPane());
			pnlBackground.add(getLblState());
			pnlBackground.add(getBtnNewButton());
		}
		return pnlBackground;
	}

	private JPanel getPnlBoard() {
		if (pnlBoard == null) {
			pnlBoard = new JPanel();
			pnlBoard.setBackground(Color.BLACK);
			pnlBoard.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			pnlBoard.setBounds(10, 10, 622, 622);
			pnlBoard.setLayout(null);
			pnlBoard.add(getPnlYellowPlayer());
			pnlBoard.add(getPnlBluePlayer());
			pnlBoard.add(getPnlRedPlayer());
			pnlBoard.add(getPnlGreenPlayer());
			pnlBoard.add(getPnlCenter());
			pnlBoard.add(getPnlBlueSide());
			pnlBoard.add(getPnlGreenSide());
			pnlBoard.add(getPnlRedSide());
			pnlBoard.add(getPnlYellowSide());
		}
		return pnlBoard;
	}

	private JPanel getPnlYellowPlayer() {
		if (pnlYellowPlayer == null) {
			pnlYellowPlayer = new JPanel();
			pnlYellowPlayer.setBackground(new Color(255, 255, 0));
			pnlYellowPlayer.setBorder(new LineBorder(new Color(0, 0, 0)));
			pnlYellowPlayer.setBounds(10, 10, 210, 210);
			pnlYellowPlayer.setLayout(null);
			pnlYellowPlayer.add(getLblYellowPlayerAvatar());
			pnlYellowPlayer.add(getLblYellowPlayerName());
			pnlYellowPlayer.add(getLblYellowDice());
			pnlYellowPlayer.add(getLblYellowPiece1());
			pnlYellowPlayer.add(getLblYellowPiece2());
			pnlYellowPlayer.add(getLblYellowPiece3());
			pnlYellowPlayer.add(getLblYellowPiece4());
		}
		return pnlYellowPlayer;
	}

	private JPanel getPnlBluePlayer() {
		if (pnlBluePlayer == null) {
			pnlBluePlayer = new JPanel();
			pnlBluePlayer.setBackground(new Color(0, 0, 255));
			pnlBluePlayer.setBorder(new LineBorder(new Color(0, 0, 0)));
			pnlBluePlayer.setBounds(10, 400, 210, 210);
			pnlBluePlayer.setLayout(null);
			pnlBluePlayer.add(getLblBluePlayerAvatar());
			pnlBluePlayer.add(getLblBluePlayerName());
			pnlBluePlayer.add(getLblBlueDice());
			pnlBluePlayer.add(getLblBluePiece1());
			pnlBluePlayer.add(getLblBluePiece2());
			pnlBluePlayer.add(getLblBluePiece3());
			pnlBluePlayer.add(getLblBluePiece4());
		}
		return pnlBluePlayer;
	}

	private JPanel getPnlRedPlayer() {
		if (pnlRedPlayer == null) {
			pnlRedPlayer = new JPanel();
			pnlRedPlayer.setBackground(new Color(255, 0, 0));
			pnlRedPlayer.setBorder(new LineBorder(new Color(0, 0, 0)));
			pnlRedPlayer.setBounds(400, 400, 210, 210);
			pnlRedPlayer.setLayout(null);
			pnlRedPlayer.add(getLblRedPlayerAvatar());
			pnlRedPlayer.add(getLblRedPlayerName());
			pnlRedPlayer.add(getLblRedDice());
			pnlRedPlayer.add(getLblRedPiece1());
			pnlRedPlayer.add(getLblRedPiece2());
			pnlRedPlayer.add(getLblRedPiece3());
			pnlRedPlayer.add(getLblRedPiece4());
		}
		return pnlRedPlayer;
	}

	private JPanel getPnlGreenPlayer() {
		if (pnlGreenPlayer == null) {
			pnlGreenPlayer = new JPanel();
			pnlGreenPlayer.setBackground(new Color(50, 205, 50));
			pnlGreenPlayer.setBorder(new LineBorder(new Color(0, 0, 0)));
			pnlGreenPlayer.setBounds(400, 10, 210, 210);
			pnlGreenPlayer.setLayout(null);
			pnlGreenPlayer.add(getLblGreenPlayerAvatar());
			pnlGreenPlayer.add(getLblGreenPlayerName());
			pnlGreenPlayer.add(getLblGreenDice());
			pnlGreenPlayer.add(getLblGreenPiece1());
			pnlGreenPlayer.add(getLblGreenPiece2());
			pnlGreenPlayer.add(getLblGreenPiece3());
			pnlGreenPlayer.add(getLblGreenPiece4());
		}
		return pnlGreenPlayer;
	}

	private JLabel getLblEndBlue() {
		if (lblEndBlue == null) {
			lblEndBlue = new JLabel("");
			lblEndBlue.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/blue_final_square.png")));
			lblEndBlue.setBounds(0, 0, 60, 120);
			lblEndBlue.setBackground(new Color(0, 0, 255));
			squares[92] = lblEndBlue;
		}
		return lblEndBlue;
	}

	private JLabel getLblEndYellow() {
		if (lblEndYellow == null) {
			lblEndYellow = new JLabel("");
			lblEndYellow.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/yellow_final_square.png")));
			lblEndYellow.setBounds(0, 0, 120, 60);
			lblEndYellow.setBackground(new Color(255, 255, 255));
			squares[76] = lblEndYellow;
		}
		return lblEndYellow;
	}

	private JLabel getLblEndGreen() {
		if (lblEndGreen == null) {
			lblEndGreen = new JLabel("");
			lblEndGreen.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/green_final_square.png")));
			lblEndGreen.setBounds(60, 0, 60, 120);
			lblEndGreen.setBackground(new Color(50, 205, 50));
			squares[100] = lblEndGreen;
		}
		return lblEndGreen;
	}

	private JLabel getLblEndRed() {
		if (lblEndRed == null) {
			lblEndRed = new JLabel("");
			lblEndRed.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/red_final_square.png")));
			lblEndRed.setBounds(0, 60, 120, 60);
			lblEndRed.setBackground(new Color(255, 255, 255));
			squares[84] = lblEndRed;
		}
		return lblEndRed;
	}

	private JPanel getPnlCenter() {
		if (pnlCenter == null) {
			pnlCenter = new JPanel();
			pnlCenter.setBackground(new Color(0, 0, 0));
			pnlCenter.setBorder(new LineBorder(new Color(0, 0, 0), 0));
			pnlCenter.setBounds(250, 250, 120, 120);
			pnlCenter.setLayout(null);
			pnlCenter.add(getLblEndBlue());
			pnlCenter.add(getLblEndYellow());
			pnlCenter.add(getLblEndGreen());
			pnlCenter.add(getLblEndRed());
		}
		return pnlCenter;
	}

	private JLabel getLbl_16() {
		if (lbl_16 == null) {
			lbl_16 = new JLabel("16");
			lbl_16.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_16.setVerticalTextPosition(SwingConstants.BOTTOM);
			lbl_16.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_16MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_16MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_16MouseExited(e);
				}
			});
			lbl_16.setOpaque(true);
			lbl_16.setBackground(new Color(255, 255, 255));
			lbl_16.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl_16.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_16.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_16.setBounds(0, 0, 30, 60);
			lbl_16.setBorder(new LineBorder(new Color(0, 0, 0)));
			squares[16] = lbl_16;
		}
		return lbl_16;
	}

	private JLabel getLbl_15() {
		if (lbl_15 == null) {
			lbl_15 = new JLabel("15");
			lbl_15.setVerticalTextPosition(SwingConstants.BOTTOM);
			lbl_15.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_15MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_15MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_15MouseExited(e);
				}
			});
			lbl_15.setOpaque(true);
			lbl_15.setBackground(new Color(255, 255, 255));
			lbl_15.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl_15.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_15.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_15.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_15.setBounds(30, 0, 30, 60);
			lbl_15.setBorder(new LineBorder(new Color(0, 0, 0)));
			squares[15] = lbl_15;
		}
		return lbl_15;
	}

	private JLabel getLbl_14() {
		if (lbl_14 == null) {
			lbl_14 = new JLabel("14");
			lbl_14.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_14.setVerticalTextPosition(SwingConstants.BOTTOM);
			lbl_14.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_14MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_14MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_14MouseExited(e);
				}
			});
			lbl_14.setOpaque(true);
			lbl_14.setBackground(new Color(255, 255, 255));
			lbl_14.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl_14.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_14.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_14.setBounds(60, 0, 30, 60);
			lbl_14.setBorder(new LineBorder(new Color(0, 0, 0)));
			squares[14] = lbl_14;
		}
		return lbl_14;
	}

	private JLabel getLbl_13() {
		if (lbl_13 == null) {
			lbl_13 = new JLabel("13");
			lbl_13.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_13.setVerticalTextPosition(SwingConstants.BOTTOM);
			lbl_13.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_13MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_13MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_13MouseExited(e);
				}
			});
			lbl_13.setOpaque(true);
			lbl_13.setBackground(new Color(255, 255, 255));
			lbl_13.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl_13.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_13.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_13.setBounds(90, 0, 30, 60);
			lbl_13.setBorder(new LineBorder(new Color(0, 0, 0)));
			squares[13] = lbl_13;
		}
		return lbl_13;
	}

	private JLabel getLbl_12() {
		if (lbl_12 == null) {
			lbl_12 = new JLabel("12");
			lbl_12.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_12.setVerticalTextPosition(SwingConstants.BOTTOM);
			lbl_12.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_12MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_12MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_12MouseExited(e);
				}
			});
			lbl_12.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl_12.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_12.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_12.setOpaque(true);
			lbl_12.setBackground(new Color(192, 192, 192));
			lbl_12.setBounds(120, 0, 30, 60);
			lbl_12.setBorder(new LineBorder(new Color(0, 0, 0)));
			squares[12] = lbl_12;
		}
		return lbl_12;
	}

	private JLabel getLbl_11() {
		if (lbl_11 == null) {
			lbl_11 = new JLabel("11");
			lbl_11.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_11.setVerticalTextPosition(SwingConstants.BOTTOM);
			lbl_11.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_11MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_11MouseExited(e);
				}

				@Override
				public void mouseClicked(MouseEvent arg0) {
					lbl_11MouseClicked(arg0);
				}
			});
			lbl_11.setOpaque(true);
			lbl_11.setBackground(new Color(255, 255, 255));
			lbl_11.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl_11.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_11.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_11.setBounds(150, 0, 30, 60);
			lbl_11.setBorder(new LineBorder(new Color(0, 0, 0)));
			squares[11] = lbl_11;
		}
		return lbl_11;
	}

	private JPanel getPnlBlueSide() {
		if (pnlBlueSide == null) {
			pnlBlueSide = new JPanel();
			pnlBlueSide.setOpaque(false);
			pnlBlueSide.setBounds(10, 220, 240, 180);
			pnlBlueSide.setLayout(null);
			pnlBlueSide.add(getLbl_16());
			pnlBlueSide.add(getLbl_15());
			pnlBlueSide.add(getLbl_14());
			pnlBlueSide.add(getLbl_13());
			pnlBlueSide.add(getLbl_12());
			pnlBlueSide.add(getLbl_11());
			pnlBlueSide.add(getLbl_10());
			pnlBlueSide.add(getLbl_9());
			pnlBlueSide.add(getLbl_17());
			pnlBlueSide.add(getLbl_85());
			pnlBlueSide.add(getLbl_86());
			pnlBlueSide.add(getLbl_87());
			pnlBlueSide.add(getLbl_88());
			pnlBlueSide.add(getLbl_89());
			pnlBlueSide.add(getLbl_90());
			pnlBlueSide.add(getLbl_91());
			pnlBlueSide.add(getLbl_18());
			pnlBlueSide.add(getLbl_19());
			pnlBlueSide.add(getLbl_20());
			pnlBlueSide.add(getLbl_21());
			pnlBlueSide.add(getLbl_22());
			pnlBlueSide.add(getLbl_23());
			pnlBlueSide.add(getLbl_24());
			pnlBlueSide.add(getLbl_25());
		}
		return pnlBlueSide;
	}

	private JLabel getLbl_10() {
		if (lbl_10 == null) {
			lbl_10 = new JLabel("10");
			lbl_10.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_10.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl_10.setVerticalTextPosition(SwingConstants.BOTTOM);
			lbl_10.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_10MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_10MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_10MouseExited(e);
				}
			});
			lbl_10.setOpaque(true);
			lbl_10.setBackground(new Color(255, 255, 255));
			lbl_10.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_10.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_10.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_10.setBounds(180, 0, 30, 60);
			squares[10] = lbl_10;
		}
		return lbl_10;
	}

	private JLabel getLbl_9() {
		if (lbl_9 == null) {
			lbl_9 = new JLabel("");
			lbl_9.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_9MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_9MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_9MouseExited(e);
				}
			});
			lbl_9.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/square_9.png")));
			lbl_9.setBounds(210, 0, 30, 60);
			squares[9] = lbl_9;
		}
		return lbl_9;
	}

	private JLabel getLbl_17() {
		if (lbl_17 == null) {
			lbl_17 = new JLabel("17");
			lbl_17.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_17MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_17MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_17MouseExited(e);
				}
			});
			lbl_17.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_17.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_17.setOpaque(true);
			lbl_17.setBackground(new Color(0, 0, 255));
			lbl_17.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_17.setBounds(0, 60, 30, 60);
			squares[17] = lbl_17;
		}
		return lbl_17;
	}

	private JLabel getLbl_85() {
		if (lbl_85 == null) {
			lbl_85 = new JLabel("");
			lbl_85.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_85MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_85MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_85MouseExited(e);
				}
			});
			lbl_85.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_85.setOpaque(true);
			lbl_85.setBackground(new Color(0, 0, 255));
			lbl_85.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_85.setBounds(30, 60, 30, 60);
			squares[85] = lbl_85;
		}
		return lbl_85;
	}

	private JLabel getLbl_86() {
		if (lbl_86 == null) {
			lbl_86 = new JLabel("");
			lbl_86.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_86MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_86MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_86MouseExited(e);
				}
			});
			lbl_86.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_86.setOpaque(true);
			lbl_86.setBackground(new Color(0, 0, 255));
			lbl_86.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_86.setBounds(60, 60, 30, 60);
			squares[86] = lbl_86;
		}
		return lbl_86;
	}

	private JLabel getLbl_87() {
		if (lbl_87 == null) {
			lbl_87 = new JLabel("");
			lbl_87.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_87MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_87MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_87MouseExited(e);
				}
			});
			lbl_87.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_87.setOpaque(true);
			lbl_87.setBackground(new Color(0, 0, 255));
			lbl_87.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_87.setBounds(90, 60, 30, 60);
			squares[87] = lbl_87;
		}
		return lbl_87;
	}

	private JLabel getLbl_88() {
		if (lbl_88 == null) {
			lbl_88 = new JLabel("");
			lbl_88.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_88MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_88MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_88MouseExited(e);
				}
			});
			lbl_88.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_88.setOpaque(true);
			lbl_88.setBackground(new Color(0, 0, 255));
			lbl_88.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_88.setBounds(120, 60, 30, 60);
			squares[88] = lbl_88;
		}
		return lbl_88;
	}

	private JLabel getLbl_89() {
		if (lbl_89 == null) {
			lbl_89 = new JLabel("");
			lbl_89.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_89MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_89MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_89MouseExited(e);
				}
			});
			lbl_89.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_89.setOpaque(true);
			lbl_89.setBackground(new Color(0, 0, 255));
			lbl_89.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_89.setBounds(150, 60, 30, 60);
			squares[89] = lbl_89;
		}
		return lbl_89;
	}

	private JLabel getLbl_90() {
		if (lbl_90 == null) {
			lbl_90 = new JLabel("");
			lbl_90.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_90MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_90MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_90MouseExited(e);
				}
			});
			lbl_90.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_90.setOpaque(true);
			lbl_90.setBackground(new Color(0, 0, 255));
			lbl_90.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_90.setBounds(180, 60, 30, 60);
			squares[90] = lbl_90;
		}
		return lbl_90;
	}

	private JLabel getLbl_91() {
		if (lbl_91 == null) {
			lbl_91 = new JLabel("");
			lbl_91.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_91MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_91MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_91MouseExited(e);
				}
			});
			lbl_91.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_91.setOpaque(true);
			lbl_91.setBackground(new Color(0, 0, 255));
			lbl_91.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_91.setBounds(210, 60, 30, 60);
			squares[91] = lbl_91;
		}
		return lbl_91;
	}

	private JLabel getLbl_18() {
		if (lbl_18 == null) {
			lbl_18 = new JLabel("18");
			lbl_18.setVerticalTextPosition(SwingConstants.TOP);
			lbl_18.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_18.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_18MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_18MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_18MouseExited(e);
				}
			});
			lbl_18.setBackground(new Color(255, 255, 255));
			lbl_18.setOpaque(true);
			lbl_18.setVerticalAlignment(SwingConstants.TOP);
			lbl_18.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_18.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_18.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_18.setBounds(0, 120, 30, 60);
			squares[18] = lbl_18;
		}
		return lbl_18;
	}

	private JLabel getLbl_19() {
		if (lbl_19 == null) {
			lbl_19 = new JLabel("19");
			lbl_19.setVerticalTextPosition(SwingConstants.TOP);
			lbl_19.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_19.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_19MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_19MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_19MouseExited(e);
				}
			});
			lbl_19.setBackground(new Color(255, 255, 255));
			lbl_19.setOpaque(true);
			lbl_19.setVerticalAlignment(SwingConstants.TOP);
			lbl_19.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_19.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_19.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_19.setBounds(30, 120, 30, 60);
			squares[19] = lbl_19;
		}
		return lbl_19;
	}

	private JLabel getLbl_20() {
		if (lbl_20 == null) {
			lbl_20 = new JLabel("20");
			lbl_20.setVerticalTextPosition(SwingConstants.TOP);
			lbl_20.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_20.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_20MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_20MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_20MouseExited(e);
				}
			});
			lbl_20.setBackground(new Color(255, 255, 255));
			lbl_20.setOpaque(true);
			lbl_20.setVerticalAlignment(SwingConstants.TOP);
			lbl_20.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_20.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_20.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_20.setBounds(60, 120, 30, 60);
			squares[20] = lbl_20;
		}
		return lbl_20;
	}

	private JLabel getLbl_21() {
		if (lbl_21 == null) {
			lbl_21 = new JLabel("21");
			lbl_21.setVerticalTextPosition(SwingConstants.TOP);
			lbl_21.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_21.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_21MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_21MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_21MouseExited(e);
				}
			});
			lbl_21.setBackground(new Color(255, 255, 255));
			lbl_21.setOpaque(true);
			lbl_21.setVerticalAlignment(SwingConstants.TOP);
			lbl_21.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_21.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_21.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_21.setBounds(90, 120, 30, 60);
			squares[21] = lbl_21;
		}
		return lbl_21;
	}

	private JLabel getLbl_22() {
		if (lbl_22 == null) {
			lbl_22 = new JLabel("22");
			lbl_22.setVerticalTextPosition(SwingConstants.TOP);
			lbl_22.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_22.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_22MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_22MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_22MouseExited(e);
				}
			});
			lbl_22.setVerticalAlignment(SwingConstants.TOP);
			lbl_22.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_22.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_22.setBackground(new Color(0, 0, 255));
			lbl_22.setOpaque(true);
			lbl_22.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_22.setBounds(120, 120, 30, 60);
			squares[22] = lbl_22;
		}
		return lbl_22;
	}

	private JLabel getLbl_23() {
		if (lbl_23 == null) {
			lbl_23 = new JLabel("23");
			lbl_23.setVerticalTextPosition(SwingConstants.TOP);
			lbl_23.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_23.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_23MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_23MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_23MouseExited(e);
				}
			});
			lbl_23.setBackground(new Color(255, 255, 255));
			lbl_23.setOpaque(true);
			lbl_23.setVerticalAlignment(SwingConstants.TOP);
			lbl_23.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_23.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_23.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_23.setBounds(150, 120, 30, 60);
			squares[23] = lbl_23;
		}
		return lbl_23;
	}

	private JLabel getLbl_24() {
		if (lbl_24 == null) {
			lbl_24 = new JLabel("24");
			lbl_24.setVerticalTextPosition(SwingConstants.TOP);
			lbl_24.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_24.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_24MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_24MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_24MouseExited(e);
				}
			});
			lbl_24.setBackground(new Color(255, 255, 255));
			lbl_24.setOpaque(true);
			lbl_24.setVerticalAlignment(SwingConstants.TOP);
			lbl_24.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_24.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_24.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_24.setBounds(180, 120, 30, 60);
			squares[24] = lbl_24;
		}
		return lbl_24;
	}

	private JPanel getPnlGreenSide() {
		if (pnlGreenSide == null) {
			pnlGreenSide = new JPanel();
			pnlGreenSide.setOpaque(false);
			pnlGreenSide.setLayout(null);
			pnlGreenSide.setBounds(370, 220, 240, 180);
			pnlGreenSide.add(getLbl_59());
			pnlGreenSide.add(getLbl_58());
			pnlGreenSide.add(getLbl_57());
			pnlGreenSide.add(getLbl_56());
			pnlGreenSide.add(getLbl_55());
			pnlGreenSide.add(getLbl_54());
			pnlGreenSide.add(getLbl_53());
			pnlGreenSide.add(getLbl_52());
			pnlGreenSide.add(getLbl_99());
			pnlGreenSide.add(getLbl_98());
			pnlGreenSide.add(getLbl_97());
			pnlGreenSide.add(getLbl_96());
			pnlGreenSide.add(getLbl_95());
			pnlGreenSide.add(getLbl_94());
			pnlGreenSide.add(getLbl_93());
			pnlGreenSide.add(getLbl_51());
			pnlGreenSide.add(getLbl_43());
			pnlGreenSide.add(getLbl_44());
			pnlGreenSide.add(getLbl_45());
			pnlGreenSide.add(getLbl_46());
			pnlGreenSide.add(getLbl_47());
			pnlGreenSide.add(getLbl_48());
			pnlGreenSide.add(getLbl_49());
			pnlGreenSide.add(getLbl_50());
		}
		return pnlGreenSide;
	}

	private JLabel getLbl_59() {
		if (lbl_59 == null) {
			lbl_59 = new JLabel("");
			lbl_59.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_59MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_59MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_59MouseExited(e);
				}
			});
			lbl_59.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/square_59.png")));
			lbl_59.setBounds(0, 0, 30, 60);
			squares[59] = lbl_59;
		}
		return lbl_59;
	}

	private JLabel getLbl_58() {
		if (lbl_58 == null) {
			lbl_58 = new JLabel("58");
			lbl_58.setVerticalTextPosition(SwingConstants.BOTTOM);
			lbl_58.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_58.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_58MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_58MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_58MouseExited(e);
				}
			});
			lbl_58.setBackground(new Color(255, 255, 255));
			lbl_58.setOpaque(true);
			lbl_58.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl_58.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_58.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_58.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_58.setBounds(30, 0, 30, 60);
			squares[58] = lbl_58;
		}
		return lbl_58;
	}

	private JLabel getLbl_57() {
		if (lbl_57 == null) {
			lbl_57 = new JLabel("57");
			lbl_57.setVerticalTextPosition(SwingConstants.BOTTOM);
			lbl_57.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_57.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_57MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_57MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_57MouseExited(e);
				}
			});
			lbl_57.setBackground(new Color(255, 255, 255));
			lbl_57.setOpaque(true);
			lbl_57.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl_57.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_57.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_57.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_57.setBounds(60, 0, 30, 60);
			squares[57] = lbl_57;
		}
		return lbl_57;
	}

	private JLabel getLbl_56() {
		if (lbl_56 == null) {
			lbl_56 = new JLabel("56");
			lbl_56.setVerticalTextPosition(SwingConstants.BOTTOM);
			lbl_56.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_56.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_56MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_56MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_56MouseExited(e);
				}
			});
			lbl_56.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl_56.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_56.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_56.setOpaque(true);
			lbl_56.setBackground(new Color(50, 205, 50));
			lbl_56.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_56.setBounds(90, 0, 30, 60);
			squares[56] = lbl_56;
		}
		return lbl_56;
	}

	private JLabel getLbl_55() {
		if (lbl_55 == null) {
			lbl_55 = new JLabel("55");
			lbl_55.setVerticalTextPosition(SwingConstants.BOTTOM);
			lbl_55.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_55.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_55MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_55MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_55MouseExited(e);
				}
			});
			lbl_55.setBackground(new Color(255, 255, 255));
			lbl_55.setOpaque(true);
			lbl_55.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl_55.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_55.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_55.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_55.setBounds(120, 0, 30, 60);
			squares[55] = lbl_55;
		}
		return lbl_55;
	}

	private JLabel getLbl_54() {
		if (lbl_54 == null) {
			lbl_54 = new JLabel("54");
			lbl_54.setVerticalTextPosition(SwingConstants.BOTTOM);
			lbl_54.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_54.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_54MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_54MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_54MouseExited(e);
				}
			});
			lbl_54.setBackground(new Color(255, 255, 255));
			lbl_54.setOpaque(true);
			lbl_54.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl_54.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_54.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_54.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_54.setBounds(150, 0, 30, 60);
			squares[54] = lbl_54;
		}
		return lbl_54;
	}

	private JLabel getLbl_53() {
		if (lbl_53 == null) {
			lbl_53 = new JLabel("53");
			lbl_53.setVerticalTextPosition(SwingConstants.BOTTOM);
			lbl_53.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_53.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_53MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_53MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_53MouseExited(e);
				}
			});
			lbl_53.setBackground(new Color(255, 255, 255));
			lbl_53.setOpaque(true);
			lbl_53.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl_53.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_53.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_53.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_53.setBounds(180, 0, 30, 60);
			squares[53] = lbl_53;
		}
		return lbl_53;
	}

	private JLabel getLbl_52() {
		if (lbl_52 == null) {
			lbl_52 = new JLabel("52");
			lbl_52.setVerticalTextPosition(SwingConstants.BOTTOM);
			lbl_52.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_52.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_52MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_52MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_52MouseExited(e);
				}
			});
			lbl_52.setBackground(new Color(255, 255, 255));
			lbl_52.setOpaque(true);
			lbl_52.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl_52.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_52.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_52.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_52.setBounds(210, 0, 30, 60);
			squares[52] = lbl_52;
		}
		return lbl_52;
	}

	private JLabel getLbl_99() {
		if (lbl_99 == null) {
			lbl_99 = new JLabel("");
			lbl_99.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_99MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_99MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_99MouseExited(e);
				}
			});
			lbl_99.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_99.setBackground(new Color(50, 205, 50));
			lbl_99.setOpaque(true);
			lbl_99.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_99.setBounds(0, 60, 30, 60);
			squares[99] = lbl_99;
		}
		return lbl_99;
	}

	private JLabel getLbl_98() {
		if (lbl_98 == null) {
			lbl_98 = new JLabel("");
			lbl_98.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_98MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_98MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_98MouseExited(e);
				}
			});
			lbl_98.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_98.setBackground(new Color(50, 205, 50));
			lbl_98.setOpaque(true);
			lbl_98.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_98.setBounds(30, 60, 30, 60);
			squares[98] = lbl_98;
		}
		return lbl_98;
	}

	private JLabel getLbl_97() {
		if (lbl_97 == null) {
			lbl_97 = new JLabel("");
			lbl_97.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_97MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_97MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_97MouseExited(e);
				}
			});
			lbl_97.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_97.setBackground(new Color(50, 205, 50));
			lbl_97.setOpaque(true);
			lbl_97.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_97.setBounds(60, 60, 30, 60);
			squares[97] = lbl_97;
		}
		return lbl_97;
	}

	private JLabel getLbl_96() {
		if (lbl_96 == null) {
			lbl_96 = new JLabel("");
			lbl_96.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_96MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_96MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_96MouseExited(e);
				}
			});
			lbl_96.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_96.setBackground(new Color(50, 205, 50));
			lbl_96.setOpaque(true);
			lbl_96.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_96.setBounds(90, 60, 30, 60);
			squares[96] = lbl_96;
		}
		return lbl_96;
	}

	private JLabel getLbl_95() {
		if (lbl_95 == null) {
			lbl_95 = new JLabel("");
			lbl_95.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_95MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_95MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_95MouseExited(e);
				}
			});
			lbl_95.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_95.setBackground(new Color(50, 205, 50));
			lbl_95.setOpaque(true);
			lbl_95.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_95.setBounds(120, 60, 30, 60);
			squares[95] = lbl_95;
		}
		return lbl_95;
	}

	private JLabel getLbl_94() {
		if (lbl_94 == null) {
			lbl_94 = new JLabel("");
			lbl_94.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_94MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_94MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_94MouseExited(e);
				}
			});
			lbl_94.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_94.setBackground(new Color(50, 205, 50));
			lbl_94.setOpaque(true);
			lbl_94.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_94.setBounds(150, 60, 30, 60);
			squares[94] = lbl_94;
		}
		return lbl_94;
	}

	private JLabel getLbl_93() {
		if (lbl_93 == null) {
			lbl_93 = new JLabel("");
			lbl_93.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_93MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_93MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_93MouseExited(e);
				}
			});
			lbl_93.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_93.setBackground(new Color(50, 205, 50));
			lbl_93.setOpaque(true);
			lbl_93.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_93.setBounds(180, 60, 30, 60);
			squares[93] = lbl_93;
		}
		return lbl_93;
	}

	private JLabel getLbl_51() {
		if (lbl_51 == null) {
			lbl_51 = new JLabel("51");
			lbl_51.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_51MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_51MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_51MouseExited(e);
				}
			});
			lbl_51.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_51.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_51.setBackground(new Color(50, 205, 50));
			lbl_51.setOpaque(true);
			lbl_51.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_51.setBounds(210, 60, 30, 60);
			squares[51] = lbl_51;
		}
		return lbl_51;
	}

	private JLabel getLbl_43() {
		if (lbl_43 == null) {
			lbl_43 = new JLabel("");
			lbl_43.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_43MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_43MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_43MouseExited(e);
				}
			});
			lbl_43.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/square_43.png")));
			lbl_43.setBounds(0, 120, 30, 60);
			squares[43] = lbl_43;
		}
		return lbl_43;
	}

	private JLabel getLbl_44() {
		if (lbl_44 == null) {
			lbl_44 = new JLabel("44");
			lbl_44.setVerticalTextPosition(SwingConstants.TOP);
			lbl_44.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_44.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_44MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_44MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_44MouseExited(e);
				}
			});
			lbl_44.setBackground(new Color(255, 255, 255));
			lbl_44.setOpaque(true);
			lbl_44.setVerticalAlignment(SwingConstants.TOP);
			lbl_44.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_44.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_44.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_44.setBounds(30, 120, 30, 60);
			squares[44] = lbl_44;
		}
		return lbl_44;
	}

	private JLabel getLbl_45() {
		if (lbl_45 == null) {
			lbl_45 = new JLabel("45");
			lbl_45.setVerticalTextPosition(SwingConstants.TOP);
			lbl_45.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_45.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_45MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_45MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_45MouseExited(e);
				}
			});
			lbl_45.setBackground(new Color(255, 255, 255));
			lbl_45.setOpaque(true);
			lbl_45.setVerticalAlignment(SwingConstants.TOP);
			lbl_45.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_45.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_45.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_45.setBounds(60, 120, 30, 60);
			squares[45] = lbl_45;
		}
		return lbl_45;
	}

	private JLabel getLbl_46() {
		if (lbl_46 == null) {
			lbl_46 = new JLabel("46");
			lbl_46.setVerticalTextPosition(SwingConstants.TOP);
			lbl_46.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_46.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_46MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_46MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_46MouseExited(e);
				}
			});
			lbl_46.setVerticalAlignment(SwingConstants.TOP);
			lbl_46.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_46.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_46.setOpaque(true);
			lbl_46.setBackground(new Color(192, 192, 192));
			lbl_46.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_46.setBounds(90, 120, 30, 60);
			squares[46] = lbl_46;
		}
		return lbl_46;
	}

	private JLabel getLbl_47() {
		if (lbl_47 == null) {
			lbl_47 = new JLabel("47");
			lbl_47.setVerticalTextPosition(SwingConstants.TOP);
			lbl_47.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_47.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_47MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_47MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_47MouseExited(e);
				}
			});
			lbl_47.setBackground(new Color(255, 255, 255));
			lbl_47.setOpaque(true);
			lbl_47.setVerticalAlignment(SwingConstants.TOP);
			lbl_47.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_47.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_47.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_47.setBounds(120, 120, 30, 60);
			squares[47] = lbl_47;
		}
		return lbl_47;
	}

	private JLabel getLbl_48() {
		if (lbl_48 == null) {
			lbl_48 = new JLabel("48");
			lbl_48.setVerticalTextPosition(SwingConstants.TOP);
			lbl_48.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_48.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_48MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_48MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_48MouseExited(e);
				}
			});
			lbl_48.setBackground(new Color(255, 255, 255));
			lbl_48.setOpaque(true);
			lbl_48.setVerticalAlignment(SwingConstants.TOP);
			lbl_48.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_48.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_48.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_48.setBounds(150, 120, 30, 60);
			squares[48] = lbl_48;
		}
		return lbl_48;
	}

	private JLabel getLbl_49() {
		if (lbl_49 == null) {
			lbl_49 = new JLabel("49");
			lbl_49.setVerticalTextPosition(SwingConstants.TOP);
			lbl_49.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_49.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_49MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_49MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_49MouseExited(e);
				}
			});
			lbl_49.setBackground(new Color(255, 255, 255));
			lbl_49.setOpaque(true);
			lbl_49.setVerticalAlignment(SwingConstants.TOP);
			lbl_49.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_49.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_49.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_49.setBounds(180, 120, 30, 60);
			squares[49] = lbl_49;
		}
		return lbl_49;
	}

	private JLabel getLbl_50() {
		if (lbl_50 == null) {
			lbl_50 = new JLabel("50");
			lbl_50.setVerticalTextPosition(SwingConstants.TOP);
			lbl_50.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_50.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_50MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_50MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_50MouseExited(e);
				}
			});
			lbl_50.setBackground(new Color(255, 255, 255));
			lbl_50.setOpaque(true);
			lbl_50.setVerticalAlignment(SwingConstants.TOP);
			lbl_50.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_50.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_50.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_50.setBounds(210, 120, 30, 60);
			squares[50] = lbl_50;
		}
		return lbl_50;
	}

	private JPanel getPnlRedSide() {
		if (pnlRedSide == null) {
			pnlRedSide = new JPanel();
			pnlRedSide.setOpaque(false);
			pnlRedSide.setLayout(null);
			pnlRedSide.setBounds(220, 370, 180, 240);
			pnlRedSide.add(getLbl_33());
			pnlRedSide.add(getLbl_34());
			pnlRedSide.add(getLbl_35());
			pnlRedSide.add(getLbl_32());
			pnlRedSide.add(getLbl_77());
			pnlRedSide.add(getLbl_36());
			pnlRedSide.add(getLbl_30());
			pnlRedSide.add(getLbl_79());
			pnlRedSide.add(getLbl_38());
			pnlRedSide.add(getLbl_37());
			pnlRedSide.add(getLbl_78());
			pnlRedSide.add(getLbl_31());
			pnlRedSide.add(getLbl_26());
			pnlRedSide.add(getLbl_27());
			pnlRedSide.add(getLbl_28());
			pnlRedSide.add(getLbl_29());
			pnlRedSide.add(getLbl_80());
			pnlRedSide.add(getLbl_81());
			pnlRedSide.add(getLbl_82());
			pnlRedSide.add(getLbl_83());
			pnlRedSide.add(getLbl_42());
			pnlRedSide.add(getLbl_41());
			pnlRedSide.add(getLbl_40());
			pnlRedSide.add(getLbl_39());
		}
		return pnlRedSide;
	}

	private JLabel getLbl_33() {
		if (lbl_33 == null) {
			lbl_33 = new JLabel("33");
			lbl_33.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_33MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_33MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_33MouseExited(e);
				}
			});
			lbl_33.setOpaque(true);
			lbl_33.setBackground(new Color(255, 255, 255));
			lbl_33.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_33.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_33.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_33.setBounds(0, 210, 60, 30);
			squares[33] = lbl_33;
		}
		return lbl_33;
	}

	private JLabel getLbl_34() {
		if (lbl_34 == null) {
			lbl_34 = new JLabel("34");
			lbl_34.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_34MouseEntered(e);
				}

				@Override
				public void mouseClicked(MouseEvent arg0) {
					lbl_34MouseClicked(arg0);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_34MouseExited(e);
				}
			});
			lbl_34.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_34.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_34.setBackground(new Color(255, 0, 0));
			lbl_34.setOpaque(true);
			lbl_34.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_34.setBounds(60, 210, 60, 30);
			squares[34] = lbl_34;
		}
		return lbl_34;
	}

	private JLabel getLbl_35() {
		if (lbl_35 == null) {
			lbl_35 = new JLabel("35");
			lbl_35.setHorizontalTextPosition(SwingConstants.LEFT);
			lbl_35.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_35MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_35MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_35MouseExited(e);
				}
			});
			lbl_35.setOpaque(true);
			lbl_35.setBackground(new Color(255, 255, 255));
			lbl_35.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_35.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_35.setBounds(120, 210, 60, 30);
			squares[35] = lbl_35;
		}
		return lbl_35;
	}

	private JLabel getLbl_32() {
		if (lbl_32 == null) {
			lbl_32 = new JLabel("32");
			lbl_32.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_32MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_32MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_32MouseExited(e);
				}
			});
			lbl_32.setOpaque(true);
			lbl_32.setBackground(new Color(255, 255, 255));
			lbl_32.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_32.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_32.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_32.setBounds(0, 180, 60, 30);
			squares[32] = lbl_32;
		}
		return lbl_32;
	}

	private JLabel getLbl_77() {
		if (lbl_77 == null) {
			lbl_77 = new JLabel("");
			lbl_77.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_77MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_77MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_77MouseExited(e);
				}
			});
			lbl_77.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_77.setBackground(new Color(255, 0, 0));
			lbl_77.setOpaque(true);
			lbl_77.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_77.setBounds(60, 180, 60, 30);
			squares[77] = lbl_77;
		}
		return lbl_77;
	}

	private JLabel getLbl_36() {
		if (lbl_36 == null) {
			lbl_36 = new JLabel("36");
			lbl_36.setHorizontalTextPosition(SwingConstants.LEFT);
			lbl_36.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_36MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_36MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_36MouseExited(e);
				}
			});
			lbl_36.setOpaque(true);
			lbl_36.setBackground(new Color(255, 255, 255));
			lbl_36.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_36.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_36.setBounds(120, 180, 60, 30);
			squares[36] = lbl_36;
		}
		return lbl_36;
	}

	private JLabel getLbl_30() {
		if (lbl_30 == null) {
			lbl_30 = new JLabel("30");
			lbl_30.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_30MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_30MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_30MouseExited(e);
				}
			});
			lbl_30.setOpaque(true);
			lbl_30.setBackground(new Color(255, 255, 255));
			lbl_30.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_30.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_30.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_30.setBounds(0, 120, 60, 30);
			squares[30] = lbl_30;
		}
		return lbl_30;
	}

	private JLabel getLbl_79() {
		if (lbl_79 == null) {
			lbl_79 = new JLabel("");
			lbl_79.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_79MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_79MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_79MouseExited(e);
				}
			});
			lbl_79.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_79.setBackground(new Color(255, 0, 0));
			lbl_79.setOpaque(true);
			lbl_79.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_79.setBounds(60, 120, 60, 30);
			squares[79] = lbl_79;
		}
		return lbl_79;
	}

	private JLabel getLbl_38() {
		if (lbl_38 == null) {
			lbl_38 = new JLabel("38");
			lbl_38.setHorizontalTextPosition(SwingConstants.LEFT);
			lbl_38.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_38MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_38MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_38MouseExited(e);
				}
			});
			lbl_38.setOpaque(true);
			lbl_38.setBackground(new Color(255, 255, 255));
			lbl_38.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_38.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_38.setBounds(120, 120, 60, 30);
			squares[38] = lbl_38;
		}
		return lbl_38;
	}

	private JLabel getLbl_37() {
		if (lbl_37 == null) {
			lbl_37 = new JLabel("37");
			lbl_37.setHorizontalTextPosition(SwingConstants.LEFT);
			lbl_37.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_37MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_37MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_37MouseExited(e);
				}
			});
			lbl_37.setOpaque(true);
			lbl_37.setBackground(new Color(255, 255, 255));
			lbl_37.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_37.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_37.setBounds(120, 150, 60, 30);
			squares[37] = lbl_37;
		}
		return lbl_37;
	}

	private JLabel getLbl_78() {
		if (lbl_78 == null) {
			lbl_78 = new JLabel("");
			lbl_78.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_78MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_78MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_78MouseExited(e);
				}
			});
			lbl_78.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_78.setBackground(new Color(255, 0, 0));
			lbl_78.setOpaque(true);
			lbl_78.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_78.setBounds(60, 150, 60, 30);
			squares[78] = lbl_78;
		}
		return lbl_78;
	}

	private JLabel getLbl_31() {
		if (lbl_31 == null) {
			lbl_31 = new JLabel("31");
			lbl_31.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_31MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_31MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_31MouseExited(e);
				}
			});
			lbl_31.setOpaque(true);
			lbl_31.setBackground(new Color(255, 255, 255));
			lbl_31.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_31.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_31.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_31.setBounds(0, 150, 60, 30);
			squares[31] = lbl_31;
		}
		return lbl_31;
	}

	private JLabel getLbl_26() {
		if (lbl_26 == null) {
			lbl_26 = new JLabel("");
			lbl_26.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_26MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_26MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_26MouseExited(e);
				}
			});
			lbl_26.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/square_26.png")));
			lbl_26.setBounds(0, 0, 60, 30);
			squares[26] = lbl_26;
		}
		return lbl_26;
	}

	private JLabel getLbl_27() {
		if (lbl_27 == null) {
			lbl_27 = new JLabel("27");
			lbl_27.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_27MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_27MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_27MouseExited(e);
				}
			});
			lbl_27.setBackground(new Color(255, 255, 255));
			lbl_27.setOpaque(true);
			lbl_27.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_27.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_27.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_27.setBounds(0, 30, 60, 30);
			squares[27] = lbl_27;
		}
		return lbl_27;
	}

	private JLabel getLbl_28() {
		if (lbl_28 == null) {
			lbl_28 = new JLabel("28");
			lbl_28.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_28MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_28MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_28MouseExited(e);
				}
			});
			lbl_28.setBackground(new Color(255, 255, 255));
			lbl_28.setOpaque(true);
			lbl_28.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_28.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_28.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_28.setBounds(0, 60, 60, 30);
			squares[28] = lbl_28;
		}
		return lbl_28;
	}

	private JLabel getLbl_29() {
		if (lbl_29 == null) {
			lbl_29 = new JLabel("29");
			lbl_29.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_29MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_29MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_29MouseExited(e);
				}
			});
			lbl_29.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_29.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_29.setOpaque(true);
			lbl_29.setBackground(new Color(192, 192, 192));
			lbl_29.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_29.setBounds(0, 90, 60, 30);
			squares[29] = lbl_29;
		}
		return lbl_29;
	}

	private JLabel getLbl_80() {
		if (lbl_80 == null) {
			lbl_80 = new JLabel("");
			lbl_80.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_80MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_80MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_80MouseExited(e);
				}
			});
			lbl_80.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_80.setBackground(new Color(255, 0, 0));
			lbl_80.setOpaque(true);
			lbl_80.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_80.setBounds(60, 90, 60, 30);
			squares[80] = lbl_80;
		}
		return lbl_80;
	}

	private JLabel getLbl_81() {
		if (lbl_81 == null) {
			lbl_81 = new JLabel("");
			lbl_81.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_81MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_81MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_81MouseExited(e);
				}
			});
			lbl_81.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_81.setBackground(new Color(255, 0, 0));
			lbl_81.setOpaque(true);
			lbl_81.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_81.setBounds(60, 60, 60, 30);
			squares[81] = lbl_81;
		}
		return lbl_81;
	}

	private JLabel getLbl_82() {
		if (lbl_82 == null) {
			lbl_82 = new JLabel("");
			lbl_82.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_82MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_82MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_82MouseExited(e);
				}
			});
			lbl_82.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_82.setBackground(new Color(255, 0, 0));
			lbl_82.setOpaque(true);
			lbl_82.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_82.setBounds(60, 30, 60, 30);
			squares[82] = lbl_82;
		}
		return lbl_82;
	}

	private JLabel getLbl_83() {
		if (lbl_83 == null) {
			lbl_83 = new JLabel("");
			lbl_83.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_83MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_83MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_83MouseExited(e);
				}
			});
			lbl_83.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_83.setBackground(new Color(255, 0, 0));
			lbl_83.setOpaque(true);
			lbl_83.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_83.setBounds(60, 0, 60, 30);
			squares[83] = lbl_83;
		}
		return lbl_83;
	}

	private JLabel getLbl_42() {
		if (lbl_42 == null) {
			lbl_42 = new JLabel("");
			lbl_42.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_42MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_42MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_42MouseExited(e);
				}
			});
			lbl_42.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/square_42.png")));
			lbl_42.setBounds(120, 0, 60, 30);
			squares[42] = lbl_42;
		}
		return lbl_42;
	}

	private JLabel getLbl_41() {
		if (lbl_41 == null) {
			lbl_41 = new JLabel("41");
			lbl_41.setHorizontalTextPosition(SwingConstants.LEFT);
			lbl_41.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_41MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_41MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_41MouseExited(e);
				}
			});
			lbl_41.setBackground(new Color(255, 255, 255));
			lbl_41.setOpaque(true);
			lbl_41.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_41.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_41.setBounds(120, 30, 60, 30);
			squares[41] = lbl_41;
		}
		return lbl_41;
	}

	private JLabel getLbl_40() {
		if (lbl_40 == null) {
			lbl_40 = new JLabel("40");
			lbl_40.setHorizontalTextPosition(SwingConstants.LEFT);
			lbl_40.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_40MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_40MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_40MouseExited(e);
				}
			});
			lbl_40.setBackground(new Color(255, 255, 255));
			lbl_40.setOpaque(true);
			lbl_40.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_40.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_40.setBounds(120, 60, 60, 30);
			squares[40] = lbl_40;
		}
		return lbl_40;
	}

	private JLabel getLbl_39() {
		if (lbl_39 == null) {
			lbl_39 = new JLabel("39");
			lbl_39.setHorizontalTextPosition(SwingConstants.LEFT);
			lbl_39.setOpaque(true);
			lbl_39.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_39MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_39MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_39MouseExited(e);
				}
			});
			lbl_39.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_39.setBackground(new Color(255, 0, 0));
			lbl_39.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_39.setBounds(120, 90, 60, 30);
			squares[39] = lbl_39;
		}
		return lbl_39;
	}

	private JPanel getPnlYellowSide() {
		if (pnlYellowSide == null) {
			pnlYellowSide = new JPanel();
			pnlYellowSide.setOpaque(false);
			pnlYellowSide.setBorder(new LineBorder(new Color(0, 0, 0)));
			pnlYellowSide.setLayout(null);
			pnlYellowSide.setBounds(220, 10, 180, 240);
			pnlYellowSide.add(getLbl_8());
			pnlYellowSide.add(getLbl_75());
			pnlYellowSide.add(getLbl_60());
			pnlYellowSide.add(getLbl_7());
			pnlYellowSide.add(getLbl_74());
			pnlYellowSide.add(getLbl_61());
			pnlYellowSide.add(getLbl_5());
			pnlYellowSide.add(getLbl_72());
			pnlYellowSide.add(getLbl_63());
			pnlYellowSide.add(getLbl_62());
			pnlYellowSide.add(getLbl_73());
			pnlYellowSide.add(getLbl_6());
			pnlYellowSide.add(getLbl_1());
			pnlYellowSide.add(getLbl_2());
			pnlYellowSide.add(getLbl_3());
			pnlYellowSide.add(getLbl_4());
			pnlYellowSide.add(getLbl_71());
			pnlYellowSide.add(getLbl_70());
			pnlYellowSide.add(getLbl_69());
			pnlYellowSide.add(getLbl_68());
			pnlYellowSide.add(getLbl_67());
			pnlYellowSide.add(getLbl_66());
			pnlYellowSide.add(getLbl_65());
			pnlYellowSide.add(getLbl_64());
		}
		return pnlYellowSide;
	}

	private JLabel getLbl_8() {
		if (lbl_8 == null) {
			lbl_8 = new JLabel("");
			lbl_8.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_8MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_8MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_8MouseExited(e);
				}
			});
			lbl_8.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/square_8.png")));
			lbl_8.setBounds(0, 210, 60, 30);
			squares[8] = lbl_8;
		}
		return lbl_8;
	}

	private JLabel getLbl_75() {
		if (lbl_75 == null) {
			lbl_75 = new JLabel("");
			lbl_75.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_75MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_75MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_75MouseExited(e);
				}
			});
			lbl_75.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_75.setBackground(new Color(255, 255, 0));
			lbl_75.setOpaque(true);
			lbl_75.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_75.setBounds(60, 210, 60, 30);
			squares[75] = lbl_75;
		}
		return lbl_75;
	}

	private JLabel getLbl_60() {
		if (lbl_60 == null) {
			lbl_60 = new JLabel("");
			lbl_60.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					lbl_60MouseClicked(arg0);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_60MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_60MouseExited(e);
				}
			});
			lbl_60.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/square_60.png")));
			lbl_60.setBounds(120, 210, 60, 30);
			squares[60] = lbl_60;
		}
		return lbl_60;
	}

	private JLabel getLbl_7() {
		if (lbl_7 == null) {
			lbl_7 = new JLabel("7");
			lbl_7.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_7MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_7MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_7MouseExited(e);
				}
			});
			lbl_7.setOpaque(true);
			lbl_7.setBackground(new Color(255, 255, 255));
			lbl_7.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_7.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_7.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_7.setBounds(0, 180, 60, 30);
			squares[7] = lbl_7;
		}
		return lbl_7;
	}

	private JLabel getLbl_74() {
		if (lbl_74 == null) {
			lbl_74 = new JLabel("");
			lbl_74.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_74MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_74MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_74MouseExited(e);
				}
			});
			lbl_74.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_74.setOpaque(true);
			lbl_74.setBackground(new Color(255, 255, 0));
			lbl_74.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_74.setBounds(60, 180, 60, 30);
			squares[74] = lbl_74;
		}
		return lbl_74;
	}

	private JLabel getLbl_61() {
		if (lbl_61 == null) {
			lbl_61 = new JLabel("61");
			lbl_61.setHorizontalTextPosition(SwingConstants.LEFT);
			lbl_61.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_61MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_61MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_61MouseExited(e);
				}
			});
			lbl_61.setBackground(new Color(255, 255, 255));
			lbl_61.setOpaque(true);
			lbl_61.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_61.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_61.setBounds(120, 180, 60, 30);
			squares[61] = lbl_61;
		}
		return lbl_61;
	}

	private JLabel getLbl_5() {
		if (lbl_5 == null) {
			lbl_5 = new JLabel("5");
			lbl_5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_5MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					lbl_5MouseEntered(arg0);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_5MouseExited(e);
				}
			});
			lbl_5.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_5.setOpaque(true);
			lbl_5.setBackground(new Color(255, 255, 0));
			lbl_5.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_5.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_5.setBounds(0, 120, 60, 30);
			squares[5] = lbl_5;
		}
		return lbl_5;
	}

	private JLabel getLbl_72() {
		if (lbl_72 == null) {
			lbl_72 = new JLabel("");
			lbl_72.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_72MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_72MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_72MouseExited(e);
				}
			});
			lbl_72.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_72.setOpaque(true);
			lbl_72.setBackground(new Color(255, 255, 0));
			lbl_72.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_72.setBounds(60, 120, 60, 30);
			squares[72] = lbl_72;
		}
		return lbl_72;
	}

	private JLabel getLbl_63() {
		if (lbl_63 == null) {
			lbl_63 = new JLabel("63");
			lbl_63.setHorizontalTextPosition(SwingConstants.LEFT);
			lbl_63.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_63MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_63MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_63MouseExited(e);
				}
			});
			lbl_63.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_63.setOpaque(true);
			lbl_63.setBackground(new Color(192, 192, 192));
			lbl_63.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_63.setBounds(120, 120, 60, 30);
			squares[63] = lbl_63;
		}
		return lbl_63;
	}

	private JLabel getLbl_62() {
		if (lbl_62 == null) {
			lbl_62 = new JLabel("62");
			lbl_62.setHorizontalTextPosition(SwingConstants.LEFT);
			lbl_62.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_62MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_62MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_62MouseExited(e);
				}
			});
			lbl_62.setBackground(new Color(255, 255, 255));
			lbl_62.setOpaque(true);
			lbl_62.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_62.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_62.setBounds(120, 150, 60, 30);
			squares[62] = lbl_62;
		}
		return lbl_62;
	}

	private JLabel getLbl_73() {
		if (lbl_73 == null) {
			lbl_73 = new JLabel("");
			lbl_73.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					lbl_73MouseClicked(arg0);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_73MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					lbl_73MouseExited(arg0);
				}
			});
			lbl_73.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_73.setOpaque(true);
			lbl_73.setBackground(new Color(255, 255, 0));
			lbl_73.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_73.setBounds(60, 150, 60, 30);
			squares[73] = lbl_73;
		}
		return lbl_73;
	}

	private JLabel getLbl_6() {
		if (lbl_6 == null) {
			lbl_6 = new JLabel("6");
			lbl_6.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_6MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_6MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_6MouseExited(e);
				}
			});
			lbl_6.setOpaque(true);
			lbl_6.setBackground(new Color(255, 255, 255));
			lbl_6.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_6.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_6.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_6.setBounds(0, 150, 60, 30);
			squares[6] = lbl_6;
		}
		return lbl_6;
	}

	private JLabel getLbl_1() {
		if (lbl_1 == null) {
			lbl_1 = new JLabel("1");
			lbl_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_1MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_1MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_1MouseExited(e);
				}
			});
			lbl_1.setOpaque(true);
			lbl_1.setBackground(new Color(255, 255, 255));
			lbl_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_1.setBounds(0, 0, 60, 30);
			squares[1] = lbl_1;
		}
		return lbl_1;
	}

	private JLabel getLbl_2() {
		if (lbl_2 == null) {
			lbl_2 = new JLabel("2");
			lbl_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_2MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_2MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_2MouseExited(e);
				}
			});
			lbl_2.setOpaque(true);
			lbl_2.setBackground(new Color(255, 255, 255));
			lbl_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_2.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_2.setBounds(0, 30, 60, 30);
			squares[2] = lbl_2;
		}
		return lbl_2;
	}

	private JLabel getLbl_3() {
		if (lbl_3 == null) {
			lbl_3 = new JLabel("3");
			lbl_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_3MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_3MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_3MouseExited(e);
				}
			});
			lbl_3.setOpaque(true);
			lbl_3.setBackground(new Color(255, 255, 255));
			lbl_3.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_3.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_3.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_3.setBounds(0, 60, 60, 30);
			squares[3] = lbl_3;
		}
		return lbl_3;
	}

	private JLabel getLbl_4() {
		if (lbl_4 == null) {
			lbl_4 = new JLabel("4");
			lbl_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_4MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_4MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_4MouseExited(e);
				}
			});
			lbl_4.setOpaque(true);
			lbl_4.setBackground(new Color(255, 255, 255));
			lbl_4.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_4.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_4.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_4.setBounds(0, 90, 60, 30);
			squares[4] = lbl_4;
		}
		return lbl_4;
	}

	private JLabel getLbl_71() {
		if (lbl_71 == null) {
			lbl_71 = new JLabel("");
			lbl_71.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_71MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_71MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_71MouseExited(e);
				}
			});
			lbl_71.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_71.setOpaque(true);
			lbl_71.setBackground(new Color(255, 255, 0));
			lbl_71.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_71.setBounds(60, 90, 60, 30);
			squares[71] = lbl_71;
		}
		return lbl_71;
	}

	private JLabel getLbl_70() {
		if (lbl_70 == null) {
			lbl_70 = new JLabel("");
			lbl_70.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_70MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_70MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_70MouseExited(e);
				}
			});
			lbl_70.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_70.setOpaque(true);
			lbl_70.setBackground(new Color(255, 255, 0));
			lbl_70.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_70.setBounds(60, 60, 60, 30);
			squares[70] = lbl_70;
		}
		return lbl_70;
	}

	private JLabel getLbl_69() {
		if (lbl_69 == null) {
			lbl_69 = new JLabel("");
			lbl_69.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_69MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_69MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_69MouseExited(e);
				}
			});
			lbl_69.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_69.setOpaque(true);
			lbl_69.setBackground(new Color(255, 255, 0));
			lbl_69.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_69.setBounds(60, 30, 60, 30);
			squares[69] = lbl_69;

		}
		return lbl_69;
	}

	private JLabel getLbl_68() {
		if (lbl_68 == null) {
			lbl_68 = new JLabel("68");
			lbl_68.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_68MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_68MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_68MouseExited(e);
				}
			});
			lbl_68.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_68.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_68.setOpaque(true);
			lbl_68.setBackground(new Color(255, 255, 0));
			lbl_68.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_68.setBounds(60, 0, 60, 30);
			squares[68] = lbl_68;
		}
		return lbl_68;
	}

	private JLabel getLbl_67() {
		if (lbl_67 == null) {
			lbl_67 = new JLabel("67");
			lbl_67.setHorizontalTextPosition(SwingConstants.LEFT);
			lbl_67.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_67MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_67MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_67MouseExited(e);
				}
			});
			lbl_67.setBackground(new Color(255, 255, 255));
			lbl_67.setOpaque(true);
			lbl_67.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_67.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_67.setBounds(120, 0, 60, 30);
			squares[67] = lbl_67;
		}
		return lbl_67;
	}

	private JLabel getLbl_66() {
		if (lbl_66 == null) {
			lbl_66 = new JLabel("66");
			lbl_66.setHorizontalTextPosition(SwingConstants.LEFT);
			lbl_66.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_66MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_66MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_66MouseExited(e);
				}
			});
			lbl_66.setBackground(new Color(255, 255, 255));
			lbl_66.setOpaque(true);
			lbl_66.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_66.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_66.setBounds(120, 30, 60, 30);
			squares[66] = lbl_66;
		}
		return lbl_66;
	}

	private JLabel getLbl_65() {
		if (lbl_65 == null) {
			lbl_65 = new JLabel("65");
			lbl_65.setHorizontalTextPosition(SwingConstants.LEFT);
			lbl_65.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_65MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_65MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_65MouseExited(e);
				}
			});
			lbl_65.setBackground(new Color(255, 255, 255));
			lbl_65.setOpaque(true);
			lbl_65.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_65.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_65.setBounds(120, 60, 60, 30);
			squares[65] = lbl_65;
		}
		return lbl_65;
	}

	private JLabel getLbl_64() {
		if (lbl_64 == null) {
			lbl_64 = new JLabel("64");
			lbl_64.setHorizontalTextPosition(SwingConstants.LEFT);
			lbl_64.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_64MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_64MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_64MouseExited(e);
				}
			});
			lbl_64.setBackground(new Color(255, 255, 255));
			lbl_64.setOpaque(true);
			lbl_64.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_64.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_64.setBounds(120, 90, 60, 30);
			squares[64] = lbl_64;
		}
		return lbl_64;
	}

	private JLabel getLblYellowPlayerAvatar() {
		if (lblYellowPlayerAvatar == null) {
			lblYellowPlayerAvatar = new JLabel("");
			lblYellowPlayerAvatar.setHorizontalAlignment(SwingConstants.CENTER);
			lblYellowPlayerAvatar.setBorder(new BevelBorder(
					BevelBorder.LOWERED, null, null, null, null));
			lblYellowPlayerAvatar.setBounds(10, 30, 100, 120);
		}
		return lblYellowPlayerAvatar;
	}

	private JLabel getLblYellowPlayerName() {
		if (lblYellowPlayerName == null) {
			lblYellowPlayerName = new JLabel();
			lblYellowPlayerName.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblYellowPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
			lblYellowPlayerName.setBounds(10, 11, 100, 14);
		}
		return lblYellowPlayerName;
	}

	private JLabel getLblGreenPlayerAvatar() {
		if (lblGreenPlayerAvatar == null) {
			lblGreenPlayerAvatar = new JLabel("");
			lblGreenPlayerAvatar.setHorizontalAlignment(SwingConstants.CENTER);
			lblGreenPlayerAvatar.setBounds(100, 30, 100, 120);
		}
		return lblGreenPlayerAvatar;
	}

	private JLabel getLblGreenPlayerName() {
		if (lblGreenPlayerName == null) {
			lblGreenPlayerName = new JLabel("");
			lblGreenPlayerName.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblGreenPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
			lblGreenPlayerName.setBounds(100, 11, 100, 14);
		}
		return lblGreenPlayerName;
	}

	private JLabel getLblRedPlayerAvatar() {
		if (lblRedPlayerAvatar == null) {
			lblRedPlayerAvatar = new JLabel("");
			lblRedPlayerAvatar.setBorder(new BevelBorder(BevelBorder.LOWERED,
					null, null, null, null));
			lblRedPlayerAvatar.setHorizontalAlignment(SwingConstants.CENTER);
			lblRedPlayerAvatar.setBounds(100, 62, 100, 120);
		}
		return lblRedPlayerAvatar;
	}

	private JLabel getLblRedPlayerName() {
		if (lblRedPlayerName == null) {
			lblRedPlayerName = new JLabel("");
			lblRedPlayerName.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblRedPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
			lblRedPlayerName.setBounds(100, 190, 100, 14);
		}
		return lblRedPlayerName;
	}

	private JLabel getLblBluePlayerAvatar() {
		if (lblBluePlayerAvatar == null) {
			lblBluePlayerAvatar = new JLabel("");
			lblBluePlayerAvatar.setBorder(null);
			lblBluePlayerAvatar.setHorizontalAlignment(SwingConstants.CENTER);
			lblBluePlayerAvatar.setBounds(10, 65, 100, 120);
		}
		return lblBluePlayerAvatar;
	}

	private JLabel getLblBluePlayerName() {
		if (lblBluePlayerName == null) {
			lblBluePlayerName = new JLabel("");
			lblBluePlayerName.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblBluePlayerName.setHorizontalAlignment(SwingConstants.CENTER);
			lblBluePlayerName.setBounds(10, 190, 100, 14);
		}
		return lblBluePlayerName;
	}

	private JLabel getLblBlueDice() {
		if (lblBlueDice == null) {
			lblBlueDice = new JLabel("");
			lblBlueDice.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblBlueDiceMouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lblBlueDiceMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblBlueDiceMouseExited(e);
				}
			});
			lblBlueDice.setHorizontalAlignment(SwingConstants.CENTER);
			lblBlueDice.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			lblBlueDice.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Dice/1_40x40.png")));
			lblBlueDice.setBounds(10, 11, 40, 40);
		}
		return lblBlueDice;
	}

	private JLabel getLblRedDice() {
		if (lblRedDice == null) {
			lblRedDice = new JLabel("");
			lblRedDice.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					lblRedDiceMouseClicked(arg0);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lblRedDiceMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblRedDiceMouseExited(e);
				}
			});
			lblRedDice.setHorizontalAlignment(SwingConstants.CENTER);
			lblRedDice.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			lblRedDice.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Dice/1_40x40.png")));
			lblRedDice.setBounds(160, 11, 40, 40);
		}
		return lblRedDice;
	}

	private JLabel getLblGreenDice() {
		if (lblGreenDice == null) {
			lblGreenDice = new JLabel("");
			lblGreenDice.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblGreenDiceMouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lblGreenDiceMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblGreenDiceMouseExited(e);
				}
			});
			lblGreenDice.setHorizontalAlignment(SwingConstants.CENTER);
			lblGreenDice.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			lblGreenDice.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Dice/1_40x40.png")));
			lblGreenDice.setBounds(160, 161, 40, 40);
		}
		return lblGreenDice;
	}

	private JLabel getLblYellowDice() {
		if (lblYellowDice == null) {
			lblYellowDice = new JLabel("");
			lblYellowDice.setHorizontalAlignment(SwingConstants.CENTER);
			lblYellowDice.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			lblYellowDice.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					lblYellowDiceMouseClicked(arg0);
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					lblYellowDiceMouseEntered(arg0);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblYellowDiceMouseExited(e);
				}
			});
			lblYellowDice.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Dice/1_40x40.png")));
			lblYellowDice.setBounds(10, 159, 40, 40);
		}
		return lblYellowDice;
	}

	private JLabel getLbl_25() {
		if (lbl_25 == null) {
			lbl_25 = new JLabel("");
			lbl_25.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_25MouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_25MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_25MouseExited(e);
				}
			});
			lbl_25.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/square_25.png")));
			lbl_25.setBounds(210, 120, 30, 60);
			squares[25] = lbl_25;
		}
		return lbl_25;
	}

	private JLabel getLblYellowPiece1() {
		if (lblYellowPiece1 == null) {
			lblYellowPiece1 = new JLabel("");
			lblYellowPiece1.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/Pieces/yellow_1.png")));
			lblYellowPiece1.setBounds(64, 174, 20, 20);
		}
		return lblYellowPiece1;
	}

	private JLabel getLblYellowPiece2() {
		if (lblYellowPiece2 == null) {
			lblYellowPiece2 = new JLabel("");
			lblYellowPiece2.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/Pieces/yellow_1.png")));
			lblYellowPiece2.setBounds(94, 174, 20, 20);
		}
		return lblYellowPiece2;
	}

	private JLabel getLblYellowPiece3() {
		if (lblYellowPiece3 == null) {
			lblYellowPiece3 = new JLabel("");
			lblYellowPiece3.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/Pieces/yellow_1.png")));
			lblYellowPiece3.setBounds(124, 174, 20, 20);
		}
		return lblYellowPiece3;
	}

	private JLabel getLblYellowPiece4() {
		if (lblYellowPiece4 == null) {
			lblYellowPiece4 = new JLabel("");
			lblYellowPiece4.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/Pieces/yellow_1.png")));
			lblYellowPiece4.setBounds(154, 174, 20, 20);
		}
		return lblYellowPiece4;
	}

	private JLabel getLblBluePiece1() {
		if (lblBluePiece1 == null) {
			lblBluePiece1 = new JLabel("");
			lblBluePiece1.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/Pieces/blue_1.png")));
			lblBluePiece1.setBounds(60, 21, 20, 20);
		}
		return lblBluePiece1;
	}

	private JLabel getLblBluePiece2() {
		if (lblBluePiece2 == null) {
			lblBluePiece2 = new JLabel("");
			lblBluePiece2.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/Pieces/blue_1.png")));
			lblBluePiece2.setBounds(90, 21, 20, 20);
		}
		return lblBluePiece2;
	}

	private JLabel getLblBluePiece3() {
		if (lblBluePiece3 == null) {
			lblBluePiece3 = new JLabel("");
			lblBluePiece3.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/Pieces/blue_1.png")));
			lblBluePiece3.setBounds(120, 21, 20, 20);
		}
		return lblBluePiece3;
	}

	private JLabel getLblBluePiece4() {
		if (lblBluePiece4 == null) {
			lblBluePiece4 = new JLabel("");
			lblBluePiece4.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/Pieces/blue_1.png")));
			lblBluePiece4.setBounds(150, 21, 20, 20);
		}
		return lblBluePiece4;
	}

	private JLabel getLblRedPiece1() {
		if (lblRedPiece1 == null) {
			lblRedPiece1 = new JLabel("");
			lblRedPiece1.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/Pieces/red_1.png")));
			lblRedPiece1.setBounds(130, 21, 20, 20);
		}
		return lblRedPiece1;
	}

	private JLabel getLblRedPiece2() {
		if (lblRedPiece2 == null) {
			lblRedPiece2 = new JLabel("");
			lblRedPiece2.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/Pieces/red_1.png")));
			lblRedPiece2.setBounds(100, 21, 20, 20);
		}
		return lblRedPiece2;
	}

	private JLabel getLblRedPiece3() {
		if (lblRedPiece3 == null) {
			lblRedPiece3 = new JLabel("");
			lblRedPiece3.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/Pieces/red_1.png")));
			lblRedPiece3.setBounds(70, 21, 20, 20);
		}
		return lblRedPiece3;
	}

	private JLabel getLblRedPiece4() {
		if (lblRedPiece4 == null) {
			lblRedPiece4 = new JLabel("");
			lblRedPiece4.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/Pieces/red_1.png")));
			lblRedPiece4.setBounds(40, 21, 20, 20);
		}
		return lblRedPiece4;
	}

	private JLabel getLblGreenPiece1() {
		if (lblGreenPiece1 == null) {
			lblGreenPiece1 = new JLabel("");
			lblGreenPiece1.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/Pieces/green_1.png")));
			lblGreenPiece1.setBounds(130, 179, 20, 20);
		}
		return lblGreenPiece1;
	}

	private JLabel getLblGreenPiece2() {
		if (lblGreenPiece2 == null) {
			lblGreenPiece2 = new JLabel("");
			lblGreenPiece2.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/Pieces/green_1.png")));
			lblGreenPiece2.setBounds(100, 179, 20, 20);
		}
		return lblGreenPiece2;
	}

	private JLabel getLblGreenPiece3() {
		if (lblGreenPiece3 == null) {
			lblGreenPiece3 = new JLabel("");
			lblGreenPiece3.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/Pieces/green_1.png")));
			lblGreenPiece3.setBounds(70, 179, 20, 20);
		}
		return lblGreenPiece3;
	}

	private JLabel getLblGreenPiece4() {
		if (lblGreenPiece4 == null) {
			lblGreenPiece4 = new JLabel("");
			lblGreenPiece4.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Ludo/Pieces/green_1.png")));
			lblGreenPiece4.setBounds(40, 179, 20, 20);
		}
		return lblGreenPiece4;
	}

	private JButton getBtnQuit() {
		if (btnQuit == null) {
			btnQuit = new JButton();
			btnQuit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					btnQuitMouseClicked(arg0);
				}
			});
			btnQuit.setText("Salir");
			btnQuit.setBounds(535, 767, 86, 23);
		}
		return btnQuit;
	}

	private JTextField getTxtMessage() {
		if (txtMessage == null) {
			txtMessage = new JTextField();
			txtMessage.setCaretColor(Color.WHITE);
			txtMessage.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			txtMessage.setBackground(Color.BLACK);
			txtMessage.setForeground(Color.WHITE);
			txtMessage.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent arg0) {
					txtMessageKeyPressed(arg0);
				}
			});
			txtMessage.setText((String) null);
			txtMessage.setBounds(10, 763, 493, 25);
		}
		return txtMessage;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBorder(null);
			scrollPane.setBounds(10, 655, 493, 100);
			scrollPane.setViewportView(getTxtChat());
		}
		return scrollPane;
	}

	private JTextPane getTxtChat() {
		if (txtChat == null) {
			htmlEditor = new HTMLEditorKit();
			chatText = new HTMLDocument();

			txtChat = new JTextPane();
			txtChat.setBackground(Color.BLACK);
			txtChat.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			txtChat.setEditable(false);
			txtChat.setEditorKit(htmlEditor);
			txtChat.setDocument(chatText);
		}
		return txtChat;
	}

	private JLabel getLblState() {
		if (lblState == null) {
			lblState = new JLabel();
			lblState.setForeground(Color.WHITE);
			lblState.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			lblState.setBounds(10, 635, 622, 14);
		}
		return lblState;
	}

	protected void lbl_60MouseClicked(MouseEvent arg0) {
		if (enabledSquares[60])
			move(60);
	}

	protected void lbl_59MouseClicked(MouseEvent e) {
		if (enabledSquares[59])
			move(59);
	}

	protected void lbl_32MouseClicked(MouseEvent e) {
		if (enabledSquares[32])
			move(32);
	}

	protected void lbl_68MouseClicked(MouseEvent e) {
		if (enabledSquares[68])
			move(68);
	}

	protected void lbl_61MouseClicked(MouseEvent e) {
		if (enabledSquares[61])
			move(61);
	}

	protected void lbl_8MouseClicked(MouseEvent e) {
		if (enabledSquares[8])
			move(8);
	}

	protected void lbl_28MouseClicked(MouseEvent e) {
		if (enabledSquares[28])
			move(28);
	}

	protected void lbl_16MouseClicked(MouseEvent e) {
		if (enabledSquares[16])
			move(16);
	}

	protected void lbl_27MouseClicked(MouseEvent e) {
		if (enabledSquares[27])
			move(27);
	}

	protected void lbl_64MouseClicked(MouseEvent e) {
		if (enabledSquares[64])
			move(64);
	}

	protected void lbl_38MouseClicked(MouseEvent e) {
		if (enabledSquares[38])
			move(38);
	}

	protected void lbl_58MouseClicked(MouseEvent e) {
		if (enabledSquares[58])
			move(58);
	}

	protected void lbl_62MouseClicked(MouseEvent e) {
		if (enabledSquares[62])
			move(62);
	}

	protected void lbl_33MouseClicked(MouseEvent e) {
		if (enabledSquares[33])
			move(33);
	}

	protected void lbl_66MouseClicked(MouseEvent e) {
		if (enabledSquares[66])
			move(66);
	}

	protected void lbl_6MouseClicked(MouseEvent e) {
		if (enabledSquares[6])
			move(6);
	}

	protected void lbl_12MouseClicked(MouseEvent e) {
		if (enabledSquares[12])
			move(12);
	}

	protected void lbl_19MouseClicked(MouseEvent e) {
		if (enabledSquares[19])
			move(19);
	}

	protected void lbl_55MouseClicked(MouseEvent e) {
		if (enabledSquares[55])
			move(55);
	}

	protected void lbl_44MouseClicked(MouseEvent e) {
		if (enabledSquares[44])
			move(44);
	}

	protected void lbl_36MouseClicked(MouseEvent e) {
		if (enabledSquares[36])
			move(36);
	}

	protected void lbl_4MouseClicked(MouseEvent e) {
		if (enabledSquares[4])
			move(4);
	}

	protected void lbl_63MouseClicked(MouseEvent e) {
		if (enabledSquares[63])
			move(63);
	}

	protected void lbl_24MouseClicked(MouseEvent e) {
		if (enabledSquares[24])
			move(24);
	}

	protected void lbl_23MouseClicked(MouseEvent e) {
		if (enabledSquares[23])
			move(23);
	}

	protected void lbl_26MouseClicked(MouseEvent e) {
		if (enabledSquares[26])
			move(26);
	}

	protected void lbl_2MouseClicked(MouseEvent e) {
		if (enabledSquares[2])
			move(2);
	}

	protected void lbl_43MouseClicked(MouseEvent e) {
		if (enabledSquares[43])
			move(43);
	}

	protected void lbl_9MouseClicked(MouseEvent e) {
		if (enabledSquares[9])
			move(9);
	}

	protected void lbl_11MouseClicked(MouseEvent arg0) {
		if (enabledSquares[11])
			move(11);
	}

	protected void lbl_13MouseClicked(MouseEvent e) {
		if (enabledSquares[13])
			move(13);
	}

	protected void lbl_50MouseClicked(MouseEvent e) {
		if (enabledSquares[50])
			move(50);
	}

	protected void lbl_51MouseClicked(MouseEvent e) {
		if (enabledSquares[51])
			move(51);
	}

	protected void lbl_48MouseClicked(MouseEvent e) {
		if (enabledSquares[48])
			move(48);
	}

	protected void lbl_29MouseClicked(MouseEvent e) {
		if (enabledSquares[29])
			move(29);
	}

	protected void lbl_20MouseClicked(MouseEvent e) {
		if (enabledSquares[20])
			move(20);
	}

	protected void lbl_25MouseClicked(MouseEvent e) {
		if (enabledSquares[25])
			move(25);
	}

	protected void lbl_53MouseClicked(MouseEvent e) {
		if (enabledSquares[53])
			move(53);
	}

	protected void lbl_31MouseClicked(MouseEvent e) {
		if (enabledSquares[31])
			move(31);
	}

	protected void lbl_41MouseClicked(MouseEvent e) {
		if (enabledSquares[41])
			move(41);
	}

	protected void lbl_45MouseClicked(MouseEvent e) {
		if (enabledSquares[45])
			move(45);
	}

	protected void lbl_35MouseClicked(MouseEvent e) {
		if (enabledSquares[35])
			move(35);
	}

	protected void lbl_65MouseClicked(MouseEvent e) {
		if (enabledSquares[65])
			move(65);
	}

	protected void lbl_37MouseClicked(MouseEvent e) {
		if (enabledSquares[37])
			move(37);
	}

	protected void lbl_52MouseClicked(MouseEvent e) {
		if (enabledSquares[52])
			move(52);
	}

	protected void lbl_15MouseClicked(MouseEvent e) {
		if (enabledSquares[15])
			move(15);
	}

	protected void lbl_47MouseClicked(MouseEvent e) {
		if (enabledSquares[47])
			move(47);
	}

	protected void lbl_49MouseClicked(MouseEvent e) {
		if (enabledSquares[49])
			move(49);
	}

	protected void lbl_10MouseClicked(MouseEvent e) {
		if (enabledSquares[10])
			move(10);
	}

	protected void lbl_40MouseClicked(MouseEvent e) {
		if (enabledSquares[40])
			move(40);
	}

	protected void lbl_57MouseClicked(MouseEvent e) {
		if (enabledSquares[57])
			move(57);
	}

	protected void lbl_1MouseClicked(MouseEvent e) {
		if (enabledSquares[1])
			move(1);
	}

	protected void lbl_30MouseClicked(MouseEvent e) {
		if (enabledSquares[30])
			move(30);
	}

	protected void lbl_39MouseClicked(MouseEvent e) {
		if (enabledSquares[39])
			move(39);
	}

	protected void lbl_3MouseClicked(MouseEvent e) {
		if (enabledSquares[3])
			move(3);
	}

	protected void lbl_7MouseClicked(MouseEvent e) {
		if (enabledSquares[7])
			move(7);
	}

	protected void lbl_5MouseClicked(MouseEvent e) {
		if (enabledSquares[5])
			move(5);
	}

	protected void lbl_67MouseClicked(MouseEvent e) {
		if (enabledSquares[67])
			move(67);
	}

	protected void lbl_56MouseClicked(MouseEvent e) {
		if (enabledSquares[56])
			move(56);
	}

	protected void lbl_54MouseClicked(MouseEvent e) {
		if (enabledSquares[54])
			move(54);
	}

	protected void lbl_46MouseClicked(MouseEvent e) {
		if (enabledSquares[46])
			move(46);
	}

	protected void lbl_14MouseClicked(MouseEvent e) {
		if (enabledSquares[14])
			move(14);
	}

	protected void lbl_17MouseClicked(MouseEvent e) {
		if (enabledSquares[17])
			move(17);
	}

	protected void lbl_42MouseClicked(MouseEvent e) {
		if (enabledSquares[42])
			move(42);
	}

	protected void lbl_22MouseClicked(MouseEvent e) {
		if (enabledSquares[22])
			move(22);
	}

	protected void lbl_18MouseClicked(MouseEvent e) {
		if (enabledSquares[18])
			move(18);
	}

	protected void lbl_21MouseClicked(MouseEvent e) {
		if (enabledSquares[21])
			move(21);
	}

	protected void lbl_34MouseClicked(MouseEvent arg0) {
		if (enabledSquares[34])
			move(34);
	}

	protected void lbl_73MouseClicked(MouseEvent arg0) {
		if (enabledSquares[73])
			move(73);
	}

	protected void lbl_75MouseClicked(MouseEvent e) {
		if (enabledSquares[75])
			move(75);
	}

	protected void lbl_69MouseClicked(MouseEvent e) {
		if (enabledSquares[69])
			move(69);
	}

	protected void lbl_71MouseClicked(MouseEvent e) {
		if (enabledSquares[71])
			move(71);
	}

	protected void lbl_74MouseClicked(MouseEvent e) {
		if (enabledSquares[74])
			move(74);
	}

	protected void lbl_70MouseClicked(MouseEvent e) {
		if (enabledSquares[70])
			move(70);
	}

	protected void lbl_72MouseClicked(MouseEvent e) {
		if (enabledSquares[72])
			move(72);
	}

	protected void lbl_93MouseClicked(MouseEvent e) {
		if (enabledSquares[93])
			move(72);
	}

	protected void lbl_95MouseClicked(MouseEvent e) {
		if (enabledSquares[95])
			move(95);
	}

	protected void lbl_94MouseClicked(MouseEvent e) {
		if (enabledSquares[94])
			move(94);
	}

	protected void lbl_97MouseClicked(MouseEvent e) {
		if (enabledSquares[97])
			move(97);
	}

	protected void lbl_98MouseClicked(MouseEvent e) {
		if (enabledSquares[98])
			move(98);
	}

	protected void lbl_99MouseClicked(MouseEvent e) {
		if (enabledSquares[99])
			move(99);
	}

	protected void lbl_96MouseClicked(MouseEvent e) {
		if (enabledSquares[96])
			move(96);
	}

	protected void lbl_83MouseClicked(MouseEvent e) {
		if (enabledSquares[83])
			move(83);
	}

	protected void lbl_80MouseClicked(MouseEvent e) {
		if (enabledSquares[80])
			move(80);
	}

	protected void lbl_88MouseClicked(MouseEvent e) {
		if (enabledSquares[88])
			move(88);
	}

	protected void lbl_91MouseClicked(MouseEvent e) {
		if (enabledSquares[91])
			move(91);
	}

	protected void lbl_89MouseClicked(MouseEvent e) {
		if (enabledSquares[89])
			move(89);
	}

	protected void lbl_85MouseClicked(MouseEvent e) {
		if (enabledSquares[85])
			move(85);
	}

	protected void lbl_77MouseClicked(MouseEvent e) {
		if (enabledSquares[77])
			move(77);
	}

	protected void lbl_78MouseClicked(MouseEvent e) {
		if (enabledSquares[78])
			move(78);
	}

	protected void lbl_81MouseClicked(MouseEvent e) {
		if (enabledSquares[81])
			move(81);
	}

	protected void lbl_82MouseClicked(MouseEvent e) {
		if (enabledSquares[82])
			move(82);
	}

	protected void lbl_90MouseClicked(MouseEvent e) {
		if (enabledSquares[90])
			move(90);
	}

	protected void lbl_79MouseClicked(MouseEvent e) {
		if (enabledSquares[79])
			move(79);
	}

	protected void lbl_87MouseClicked(MouseEvent e) {
		if (enabledSquares[87])
			move(87);
	}

	protected void lbl_86MouseClicked(MouseEvent e) {
		if (enabledSquares[86])
			move(86);
	}

	// Cursors
	protected void lbl_7MouseEntered(MouseEvent e) {
		if (enabledSquares[7])
			setHandCursor();
	}

	protected void lbl_6MouseEntered(MouseEvent e) {
		if (enabledSquares[6])
			setHandCursor();
	}

	protected void lbl_1MouseEntered(MouseEvent e) {
		if (enabledSquares[1])
			setHandCursor();
	}

	protected void lbl_2MouseEntered(MouseEvent e) {
		if (enabledSquares[2])
			setHandCursor();
	}

	protected void lbl_3MouseEntered(MouseEvent e) {
		if (enabledSquares[3])
			setHandCursor();
	}

	protected void lbl_4MouseEntered(MouseEvent e) {
		if (enabledSquares[4])
			setHandCursor();
	}

	protected void lbl_59MouseEntered(MouseEvent e) {
		if (enabledSquares[59])
			setHandCursor();
	}

	protected void lbl_38MouseEntered(MouseEvent e) {
		if (enabledSquares[38])
			setHandCursor();
	}

	protected void lbl_43MouseEntered(MouseEvent e) {
		if (enabledSquares[43])
			setHandCursor();
	}

	protected void lbl_64MouseEntered(MouseEvent e) {
		if (enabledSquares[64])
			setHandCursor();
	}

	protected void lbl_35MouseEntered(MouseEvent e) {
		if (enabledSquares[35])
			setHandCursor();
	}

	protected void lbl_66MouseEntered(MouseEvent e) {
		if (enabledSquares[66])
			setHandCursor();
	}

	protected void lbl_67MouseEntered(MouseEvent e) {
		if (enabledSquares[67])
			setHandCursor();
	}

	protected void lbl_44MouseEntered(MouseEvent e) {
		if (enabledSquares[44])
			setHandCursor();
	}

	protected void lbl_42MouseEntered(MouseEvent e) {
		if (enabledSquares[42])
			setHandCursor();
	}

	protected void lbl_41MouseEntered(MouseEvent e) {
		if (enabledSquares[41])
			setHandCursor();
	}

	protected void lbl_45MouseEntered(MouseEvent e) {
		if (enabledSquares[45])
			setHandCursor();
	}

	protected void lbl_61MouseEntered(MouseEvent e) {
		if (enabledSquares[61])
			setHandCursor();
	}

	protected void lbl_49MouseEntered(MouseEvent e) {
		if (enabledSquares[49])
			setHandCursor();
	}

	protected void lbl_52MouseEntered(MouseEvent e) {
		if (enabledSquares[52])
			setHandCursor();
	}

	protected void lbl_62MouseEntered(MouseEvent e) {
		if (enabledSquares[62])
			setHandCursor();
	}

	protected void lbl_63MouseEntered(MouseEvent e) {
		if (enabledSquares[63])
			setHandCursor();
	}

	protected void lbl_65MouseEntered(MouseEvent e) {
		if (enabledSquares[65])
			setHandCursor();
	}

	protected void lbl_55MouseEntered(MouseEvent e) {
		if (enabledSquares[55])
			setHandCursor();
	}

	protected void lbl_47MouseEntered(MouseEvent e) {
		if (enabledSquares[47])
			setHandCursor();
	}

	protected void lbl_60MouseEntered(MouseEvent e) {
		if (enabledSquares[60])
			setHandCursor();
	}

	protected void lbl_46MouseEntered(MouseEvent e) {
		if (enabledSquares[46])
			setHandCursor();
	}

	protected void lbl_48MouseEntered(MouseEvent e) {
		if (enabledSquares[48])
			setHandCursor();
	}

	protected void lbl_37MouseEntered(MouseEvent e) {
		if (enabledSquares[37])
			setHandCursor();
	}

	protected void lbl_51MouseEntered(MouseEvent e) {
		if (enabledSquares[51])
			setHandCursor();
	}

	protected void lbl_54MouseEntered(MouseEvent e) {
		if (enabledSquares[54])
			setHandCursor();
	}

	protected void lbl_58MouseEntered(MouseEvent e) {
		if (enabledSquares[58])
			setHandCursor();
	}

	protected void lbl_34MouseEntered(MouseEvent e) {
		if (enabledSquares[34])
			setHandCursor();
	}

	protected void lbl_53MouseEntered(MouseEvent e) {
		if (enabledSquares[53])
			setHandCursor();
	}

	protected void lbl_36MouseEntered(MouseEvent e) {
		if (enabledSquares[36])
			setHandCursor();
	}

	protected void lbl_40MouseEntered(MouseEvent e) {
		if (enabledSquares[40])
			setHandCursor();
	}

	protected void lbl_50MouseEntered(MouseEvent e) {
		if (enabledSquares[50])
			setHandCursor();
	}

	protected void lbl_57MouseEntered(MouseEvent e) {
		if (enabledSquares[57])
			setHandCursor();
	}

	protected void lbl_56MouseEntered(MouseEvent e) {
		if (enabledSquares[56])
			setHandCursor();
	}

	protected void lbl_68MouseEntered(MouseEvent e) {
		if (enabledSquares[68])
			setHandCursor();
	}

	protected void lbl_26MouseEntered(MouseEvent e) {
		if (enabledSquares[26])
			setHandCursor();
	}

	protected void lbl_28MouseEntered(MouseEvent e) {
		if (enabledSquares[28])
			setHandCursor();
	}

	protected void lbl_18MouseEntered(MouseEvent e) {
		if (enabledSquares[18])
			setHandCursor();
	}

	protected void lbl_14MouseEntered(MouseEvent e) {
		if (enabledSquares[14])
			setHandCursor();
	}

	protected void lbl_30MouseEntered(MouseEvent e) {
		if (enabledSquares[30])
			setHandCursor();
	}

	protected void lbl_25MouseEntered(MouseEvent e) {
		if (enabledSquares[25])
			setHandCursor();
	}

	protected void lbl_13MouseEntered(MouseEvent e) {
		if (enabledSquares[13])
			setHandCursor();
	}

	protected void lbl_16MouseEntered(MouseEvent e) {
		if (enabledSquares[16])
			setHandCursor();
	}

	protected void lbl_32MouseEntered(MouseEvent e) {
		if (enabledSquares[32])
			setHandCursor();
	}

	protected void lbl_11MouseEntered(MouseEvent e) {
		if (enabledSquares[11])
			setHandCursor();
	}

	protected void lbl_29MouseEntered(MouseEvent e) {
		if (enabledSquares[29])
			setHandCursor();
	}

	protected void lbl_31MouseEntered(MouseEvent e) {
		if (enabledSquares[31])
			setHandCursor();
	}

	protected void lbl_8MouseEntered(MouseEvent e) {
		if (enabledSquares[8])
			setHandCursor();
	}

	protected void lbl_23MouseEntered(MouseEvent e) {
		if (enabledSquares[23])
			setHandCursor();
	}

	protected void lbl_20MouseEntered(MouseEvent e) {
		if (enabledSquares[20])
			setHandCursor();
	}

	protected void lbl_9MouseEntered(MouseEvent e) {
		if (enabledSquares[9])
			setHandCursor();
	}

	protected void lbl_17MouseEntered(MouseEvent e) {
		if (enabledSquares[17])
			setHandCursor();
	}

	protected void lbl_24MouseEntered(MouseEvent e) {
		if (enabledSquares[24])
			setHandCursor();
	}

	protected void lbl_22MouseEntered(MouseEvent e) {
		if (enabledSquares[22])
			setHandCursor();
	}

	protected void lbl_19MouseEntered(MouseEvent e) {
		if (enabledSquares[19])
			setHandCursor();
	}

	protected void lbl_27MouseEntered(MouseEvent e) {
		if (enabledSquares[27])
			setHandCursor();
	}

	protected void lbl_15MouseEntered(MouseEvent e) {
		if (enabledSquares[15])
			setHandCursor();
	}

	protected void lbl_12MouseEntered(MouseEvent e) {
		if (enabledSquares[12])
			setHandCursor();
	}

	protected void lbl_33MouseEntered(MouseEvent e) {
		if (enabledSquares[33])
			setHandCursor();
	}

	protected void lbl_21MouseEntered(MouseEvent e) {
		if (enabledSquares[21])
			setHandCursor();
	}

	protected void lbl_10MouseEntered(MouseEvent e) {
		if (enabledSquares[10])
			setHandCursor();
	}

	protected void lbl_5MouseEntered(MouseEvent arg0) {
		if (enabledSquares[5])
			setHandCursor();
	}

	protected void lbl_39MouseEntered(MouseEvent e) {
		if (enabledSquares[39])
			setHandCursor();
	}

	protected void lbl_70MouseEntered(MouseEvent e) {
		if (enabledSquares[70])
			setHandCursor();
	}

	protected void lbl_72MouseEntered(MouseEvent e) {
		if (enabledSquares[72])
			setHandCursor();
	}

	protected void lbl_71MouseEntered(MouseEvent e) {
		if (enabledSquares[71])
			setHandCursor();
	}

	protected void lbl_75MouseEntered(MouseEvent e) {
		if (enabledSquares[75])
			setHandCursor();
	}

	protected void lbl_73MouseEntered(MouseEvent e) {
		if (enabledSquares[73])
			setHandCursor();
	}

	protected void lbl_69MouseEntered(MouseEvent e) {
		if (enabledSquares[69])
			setHandCursor();
	}

	protected void lbl_93MouseEntered(MouseEvent e) {
		if (enabledSquares[93])
			setHandCursor();
	}

	protected void lbl_95MouseEntered(MouseEvent e) {
		if (enabledSquares[95])
			setHandCursor();
	}

	protected void lbl_98MouseEntered(MouseEvent e) {
		if (enabledSquares[98])
			setHandCursor();
	}

	protected void lbl_94MouseEntered(MouseEvent e) {
		if (enabledSquares[94])
			setHandCursor();
	}

	protected void lbl_97MouseEntered(MouseEvent e) {
		if (enabledSquares[97])
			setHandCursor();
	}

	protected void lbl_74MouseEntered(MouseEvent e) {
		if (enabledSquares[74])
			setHandCursor();
	}

	protected void lbl_96MouseEntered(MouseEvent e) {
		if (enabledSquares[96])
			setHandCursor();
	}

	protected void lbl_99MouseEntered(MouseEvent e) {
		if (enabledSquares[99])
			setHandCursor();
	}

	protected void lbl_81MouseEntered(MouseEvent e) {
		if (enabledSquares[81])
			setHandCursor();
	}

	protected void lbl_80MouseEntered(MouseEvent e) {
		if (enabledSquares[80])
			setHandCursor();
	}

	protected void lbl_87MouseEntered(MouseEvent e) {
		if (enabledSquares[87])
			setHandCursor();
	}

	protected void lbl_85MouseEntered(MouseEvent e) {
		if (enabledSquares[85])
			setHandCursor();
	}

	protected void lbl_83MouseEntered(MouseEvent e) {
		if (enabledSquares[83])
			setHandCursor();
	}

	protected void lbl_79MouseEntered(MouseEvent e) {
		if (enabledSquares[79])
			setHandCursor();
	}

	protected void lbl_89MouseEntered(MouseEvent e) {
		if (enabledSquares[89])
			setHandCursor();
	}

	protected void lbl_88MouseEntered(MouseEvent e) {
		if (enabledSquares[88])
			setHandCursor();
	}

	protected void lbl_82MouseEntered(MouseEvent e) {
		if (enabledSquares[82])
			setHandCursor();
	}

	protected void lbl_91MouseEntered(MouseEvent e) {
		if (enabledSquares[91])
			setHandCursor();
	}

	protected void lbl_78MouseEntered(MouseEvent e) {
		if (enabledSquares[78])
			setHandCursor();
	}

	protected void lbl_77MouseEntered(MouseEvent e) {
		if (enabledSquares[77])
			setHandCursor();
	}

	protected void lbl_86MouseEntered(MouseEvent e) {
		if (enabledSquares[86])
			setHandCursor();
	}

	protected void lbl_90MouseEntered(MouseEvent e) {
		if (enabledSquares[90])
			setHandCursor();
	}

	protected void lbl_39MouseExited(MouseEvent e) {
		if (enabledSquares[39])
			setDefaultCursor();
	}

	protected void lbl_5MouseExited(MouseEvent e) {
		if (enabledSquares[5])
			setDefaultCursor();
	}

	protected void lbl_11MouseExited(MouseEvent e) {
		if (enabledSquares[11])
			setDefaultCursor();
	}

	protected void lbl_16MouseExited(MouseEvent e) {
		if (enabledSquares[16])
			setDefaultCursor();
	}

	protected void lbl_1MouseExited(MouseEvent e) {
		if (enabledSquares[1])
			setDefaultCursor();
	}

	protected void lbl_28MouseExited(MouseEvent e) {
		if (enabledSquares[28])
			setDefaultCursor();
	}

	protected void lbl_12MouseExited(MouseEvent e) {
		if (enabledSquares[12])
			setDefaultCursor();
	}

	protected void lbl_9MouseExited(MouseEvent e) {
		if (enabledSquares[19])
			setDefaultCursor();
	}

	protected void lbl_31MouseExited(MouseEvent e) {
		if (enabledSquares[31])
			setDefaultCursor();
	}

	protected void lbl_4MouseExited(MouseEvent e) {
		if (enabledSquares[4])
			setDefaultCursor();
	}

	protected void lbl_21MouseExited(MouseEvent e) {
		if (enabledSquares[21])
			setDefaultCursor();
	}

	protected void lbl_3MouseExited(MouseEvent e) {
		if (enabledSquares[3])
			setDefaultCursor();
	}

	protected void lbl_8MouseExited(MouseEvent e) {
		if (enabledSquares[8])
			setDefaultCursor();
	}

	protected void lbl_33MouseExited(MouseEvent e) {
		if (enabledSquares[33])
			setDefaultCursor();
	}

	protected void lbl_27MouseExited(MouseEvent e) {
		if (enabledSquares[27])
			setDefaultCursor();
	}

	protected void lbl_24MouseExited(MouseEvent e) {
		if (enabledSquares[24])
			setDefaultCursor();
	}

	protected void lbl_18MouseExited(MouseEvent e) {
		if (enabledSquares[18])
			setDefaultCursor();
	}

	protected void lbl_32MouseExited(MouseEvent e) {
		if (enabledSquares[32])
			setDefaultCursor();
	}

	protected void lbl_29MouseExited(MouseEvent e) {
		if (enabledSquares[29])
			setDefaultCursor();
	}

	protected void lbl_30MouseExited(MouseEvent e) {
		if (enabledSquares[30])
			setDefaultCursor();
	}

	protected void lbl_17MouseExited(MouseEvent e) {
		if (enabledSquares[17])
			setDefaultCursor();
	}

	protected void lbl_23MouseExited(MouseEvent e) {
		if (enabledSquares[23])
			setDefaultCursor();
	}

	protected void lbl_19MouseExited(MouseEvent e) {
		if (enabledSquares[19])
			setDefaultCursor();
	}

	protected void lbl_7MouseExited(MouseEvent e) {
		if (enabledSquares[7])
			setDefaultCursor();
	}

	protected void lbl_6MouseExited(MouseEvent e) {
		if (enabledSquares[6])
			setDefaultCursor();
	}

	protected void lbl_25MouseExited(MouseEvent e) {
		if (enabledSquares[25])
			setDefaultCursor();
	}

	protected void lbl_20MouseExited(MouseEvent e) {
		if (enabledSquares[20])
			setDefaultCursor();
	}

	protected void lbl_14MouseExited(MouseEvent e) {
		if (enabledSquares[14])
			setDefaultCursor();
	}

	protected void lbl_26MouseExited(MouseEvent e) {
		if (enabledSquares[26])
			setDefaultCursor();
	}

	protected void lbl_15MouseExited(MouseEvent e) {
		if (enabledSquares[15])
			setDefaultCursor();
	}

	protected void lbl_2MouseExited(MouseEvent e) {
		if (enabledSquares[2])
			setDefaultCursor();
	}

	protected void lbl_13MouseExited(MouseEvent e) {
		if (enabledSquares[13])
			setDefaultCursor();
	}

	protected void lbl_34MouseExited(MouseEvent e) {
		if (enabledSquares[34])
			setDefaultCursor();
	}

	protected void lbl_22MouseExited(MouseEvent e) {
		if (enabledSquares[22])
			setDefaultCursor();
	}

	protected void lbl_10MouseExited(MouseEvent e) {
		if (enabledSquares[10])
			setDefaultCursor();
	}

	protected void lbl_36MouseExited(MouseEvent e) {
		if (enabledSquares[36])
			setDefaultCursor();
	}

	protected void lbl_35MouseExited(MouseEvent e) {
		if (enabledSquares[35])
			setDefaultCursor();
	}

	protected void lbl_38MouseExited(MouseEvent e) {
		if (enabledSquares[38])
			setDefaultCursor();
	}

	protected void lbl_37MouseExited(MouseEvent e) {
		if (enabledSquares[37])
			setDefaultCursor();
	}

	protected void lbl_41MouseExited(MouseEvent e) {
		if (enabledSquares[41])
			setDefaultCursor();
	}

	protected void lbl_42MouseExited(MouseEvent e) {
		if (enabledSquares[42])
			setDefaultCursor();
	}

	protected void lbl_40MouseExited(MouseEvent e) {
		if (enabledSquares[40])
			setDefaultCursor();
	}

	protected void lbl_49MouseExited(MouseEvent e) {
		if (enabledSquares[49])
			setDefaultCursor();
	}

	protected void lbl_46MouseExited(MouseEvent e) {
		if (enabledSquares[46])
			setDefaultCursor();
	}

	protected void lbl_44MouseExited(MouseEvent e) {
		if (enabledSquares[44])
			setDefaultCursor();
	}

	protected void lbl_47MouseExited(MouseEvent e) {
		if (enabledSquares[47])
			setDefaultCursor();
	}

	protected void lbl_43MouseExited(MouseEvent e) {
		if (enabledSquares[43])
			setDefaultCursor();
	}

	protected void lbl_45MouseExited(MouseEvent e) {
		if (enabledSquares[45])
			setDefaultCursor();
	}

	protected void lbl_50MouseExited(MouseEvent e) {
		if (enabledSquares[50])
			setDefaultCursor();
	}

	protected void lbl_48MouseExited(MouseEvent e) {
		if (enabledSquares[48])
			setDefaultCursor();
	}

	protected void lbl_60MouseExited(MouseEvent e) {
		if (enabledSquares[60])
			setDefaultCursor();
	}

	protected void lbl_59MouseExited(MouseEvent e) {
		if (enabledSquares[59])
			setDefaultCursor();
	}

	protected void lbl_51MouseExited(MouseEvent e) {
		if (enabledSquares[51])
			setDefaultCursor();
	}

	protected void lbl_56MouseExited(MouseEvent e) {
		if (enabledSquares[56])
			setDefaultCursor();
	}

	protected void lbl_61MouseExited(MouseEvent e) {
		if (enabledSquares[61])
			setDefaultCursor();
	}

	protected void lbl_58MouseExited(MouseEvent e) {
		if (enabledSquares[58])
			setDefaultCursor();
	}

	protected void lbl_57MouseExited(MouseEvent e) {
		if (enabledSquares[57])
			setDefaultCursor();
	}

	protected void lbl_52MouseExited(MouseEvent e) {
		if (enabledSquares[52])
			setDefaultCursor();
	}

	protected void lbl_53MouseExited(MouseEvent e) {
		if (enabledSquares[53])
			setDefaultCursor();
	}

	protected void lbl_54MouseExited(MouseEvent e) {
		if (enabledSquares[54])
			setDefaultCursor();
	}

	protected void lbl_55MouseExited(MouseEvent e) {
		if (enabledSquares[55])
			setDefaultCursor();
	}

	protected void lbl_63MouseExited(MouseEvent e) {
		if (enabledSquares[63])
			setDefaultCursor();
	}

	protected void lbl_66MouseExited(MouseEvent e) {
		if (enabledSquares[66])
			setDefaultCursor();
	}

	protected void lbl_62MouseExited(MouseEvent e) {
		if (enabledSquares[62])
			setDefaultCursor();
	}

	protected void lbl_68MouseExited(MouseEvent e) {
		if (enabledSquares[68])
			setDefaultCursor();
	}

	protected void lbl_64MouseExited(MouseEvent e) {
		if (enabledSquares[64])
			setDefaultCursor();
	}

	protected void lbl_67MouseExited(MouseEvent e) {
		if (enabledSquares[67])
			setDefaultCursor();
	}

	protected void lbl_65MouseExited(MouseEvent e) {
		if (enabledSquares[65])
			setDefaultCursor();
	}

	protected void lbl_73MouseExited(MouseEvent arg0) {
		if (enabledSquares[73])
			setDefaultCursor();
	}

	protected void lbl_74MouseExited(MouseEvent e) {
		if (enabledSquares[74])
			setDefaultCursor();
	}

	protected void lbl_75MouseExited(MouseEvent e) {
		if (enabledSquares[75])
			setDefaultCursor();
	}

	protected void lbl_70MouseExited(MouseEvent e) {
		if (enabledSquares[70])
			setDefaultCursor();
	}

	protected void lbl_72MouseExited(MouseEvent e) {
		if (enabledSquares[72])
			setDefaultCursor();
	}

	protected void lbl_69MouseExited(MouseEvent e) {
		if (enabledSquares[69])
			setDefaultCursor();
	}

	protected void lbl_71MouseExited(MouseEvent e) {
		if (enabledSquares[71])
			setDefaultCursor();
	}

	protected void lbl_99MouseExited(MouseEvent e) {
		if (enabledSquares[99])
			setDefaultCursor();
	}

	protected void lbl_95MouseExited(MouseEvent e) {
		if (enabledSquares[95])
			setDefaultCursor();
	}

	protected void lbl_93MouseExited(MouseEvent e) {
		if (enabledSquares[93])
			setDefaultCursor();
	}

	protected void lbl_96MouseExited(MouseEvent e) {
		if (enabledSquares[96])
			setDefaultCursor();
	}

	protected void lbl_98MouseExited(MouseEvent e) {
		if (enabledSquares[98])
			setDefaultCursor();
	}

	protected void lbl_97MouseExited(MouseEvent e) {
		if (enabledSquares[97])
			setDefaultCursor();
	}

	protected void lbl_94MouseExited(MouseEvent e) {
		if (enabledSquares[94])
			setDefaultCursor();
	}

	protected void lbl_79MouseExited(MouseEvent e) {
		if (enabledSquares[79])
			setDefaultCursor();
	}

	protected void lbl_88MouseExited(MouseEvent e) {
		if (enabledSquares[88])
			setDefaultCursor();
	}

	protected void lbl_85MouseExited(MouseEvent e) {
		if (enabledSquares[85])
			setDefaultCursor();
	}

	protected void lbl_78MouseExited(MouseEvent e) {
		if (enabledSquares[78])
			setDefaultCursor();
	}

	protected void lbl_86MouseExited(MouseEvent e) {
		if (enabledSquares[86])
			setDefaultCursor();
	}

	protected void lbl_87MouseExited(MouseEvent e) {
		if (enabledSquares[87])
			setDefaultCursor();
	}

	protected void lbl_77MouseExited(MouseEvent e) {
		if (enabledSquares[77])
			setDefaultCursor();
	}

	protected void lbl_80MouseExited(MouseEvent e) {
		if (enabledSquares[80])
			setDefaultCursor();
	}

	protected void lbl_83MouseExited(MouseEvent e) {
		if (enabledSquares[83])
			setDefaultCursor();
	}

	protected void lbl_82MouseExited(MouseEvent e) {
		if (enabledSquares[82])
			setDefaultCursor();
	}

	protected void lbl_81MouseExited(MouseEvent e) {
		if (enabledSquares[81])
			setDefaultCursor();
	}

	protected void lbl_89MouseExited(MouseEvent e) {
		if (enabledSquares[89])
			setDefaultCursor();
	}

	protected void lbl_91MouseExited(MouseEvent e) {
		if (enabledSquares[91])
			setDefaultCursor();
	}

	protected void lbl_90MouseExited(MouseEvent e) {
		if (enabledSquares[90])
			setDefaultCursor();
	}

	protected void txtMessageKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == 10 && txtMessage.getText().length() > 0)
			sendMessage();
	}

	protected void lblYellowDiceMouseClicked(MouseEvent evt) {
		if (yellowDice) {
			throwDice();
			disableDices();
		}
	}

	protected void lblYellowDiceMouseEntered(MouseEvent evt) {
		if (yellowDice)
			setHandCursor();
	}

	protected void lblYellowDiceMouseExited(MouseEvent evt) {
		if (yellowDice)
			setDefaultCursor();
	}

	protected void lblRedDiceMouseClicked(MouseEvent arg0) {
		if (redDice) {
			throwDice();
			disableDices();
		}
	}

	protected void lblRedDiceMouseEntered(MouseEvent e) {
		if (redDice)
			setHandCursor();
	}

	protected void lblRedDiceMouseExited(MouseEvent e) {
		if (redDice)
			setDefaultCursor();
	}

	protected void lblBlueDiceMouseClicked(MouseEvent e) {
		if (blueDice) {
			throwDice();
			disableDices();
		}
	}

	protected void lblBlueDiceMouseEntered(MouseEvent e) {
		if (blueDice)
			setHandCursor();
	}

	protected void lblBlueDiceMouseExited(MouseEvent e) {
		if (blueDice)
			setDefaultCursor();
	}

	protected void lblGreenDiceMouseClicked(MouseEvent e) {
		if (greenDice) {
			throwDice();
			disableDices();
		}
	}

	protected void lblGreenDiceMouseEntered(MouseEvent e) {
		if (greenDice)
			setHandCursor();
	}

	protected void lblGreenDiceMouseExited(MouseEvent e) {
		if (greenDice)
			setDefaultCursor();
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
	}

	private void setHandCursor() {
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	private void setDefaultCursor() {
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void updateBoard(int nextTurn) {

	}

	@Override
	public void lostGame() {
		JOptionPane.showMessageDialog(this, "Has perdido el juego!");
		dispose();
	}

	@Override
	public void receiveMessage(String sender, String message) {
		try {
			htmlEditor.insertHTML(chatText, chatText.getLength(),
					"<font color=\"white\"><b>" + sender + ":</b> " + message
							+ "</font>", 0, 0, null);
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
	public void userLeaveGame(String playerName) {

		if (game.players() > 2) {

			try {
				htmlEditor.insertHTML(chatText, chatText.getLength(),
						"<font color=\"white\"><b>" + playerName
								+ " has left the game</b></font> ", 0, 0, null);
			} catch (BadLocationException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			int playerIndex = 0;

			for (int i = 0; i < 4; i++) {
				if (game.getSlot(i).getPlayer().equalsIgnoreCase(playerName)) {
					playerIndex = i;
					break;
				}
			}

			for (int piece = 0; piece < 4; piece++) {
				int square = game.getBoard()[playerIndex][piece];
				if (square != Ludo.HOUSE) {
					game.getBoard()[playerIndex][piece] = Ludo.HOUSE;
					Square squareInfo = Ludo
							.squareInfo(game.getBoard(), square);
					setSquareIcon(squares[square], squareInfo, playerTurn);
				}
			}

			switch (playerIndex) {
			case Ludo.YELLOW:
				for (JLabel lbl : yellowPieces) {
					lbl.setIcon(new ImageIcon(LudoUI.class
							.getResource("/images/Ludo/pieces/yellow_1.png")));
					lblYellowPlayerAvatar.setIcon(null);
					lblYellowPlayerAvatar.setBorder(null);
					lblYellowPlayerName.setText(null);
				}
				break;
			case Ludo.RED:
				for (JLabel lbl : redPieces) {
					lbl.setIcon(new ImageIcon(LudoUI.class
							.getResource("/images/Ludo/pieces/red_1.png")));
					lblRedPlayerAvatar.setIcon(null);
					lblRedPlayerAvatar.setBorder(null);
					lblRedPlayerName.setText(null);
				}
				break;
			case Ludo.BLUE:
				for (JLabel lbl : bluePieces) {
					lbl.setIcon(new ImageIcon(LudoUI.class
							.getResource("/images/Ludo/pieces/blue_1.png")));
					lblBluePlayerAvatar.setIcon(null);
					lblBluePlayerAvatar.setBorder(null);
					lblBluePlayerName.setText(null);
				}
				break;
			case Ludo.GREEN:
				for (JLabel lbl : greenPieces) {
					lbl.setIcon(new ImageIcon(LudoUI.class
							.getResource("/images/Ludo/pieces/green_1.png")));
					lblGreenPlayerAvatar.setIcon(null);
					lblGreenPlayerAvatar.setBorder(null);
					lblGreenPlayerName.setText(null);
				}
				break;
			}

			if (playerIndex == playerTurn) {
				throwing = false;
				try {
					throwDice.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				changeTurn();
				if (playerTurn != myPlayer)
					diceAnimation(playerTurn);

			}
		} else {
			JOptionPane.showMessageDialog(this, "Has ganado el juego!");
			dispose();
		}

	}

	private void throwDice() {
		new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					dice = Ludo.throwDice();
					switch (playerTurn) {
					case Ludo.YELLOW:
						lblYellowDice.setIcon(new ImageIcon(LudoUI.class
								.getResource("/images/Dice/" + dice
										+ "_40x40.png")));
						break;
					case Ludo.RED:
						lblRedDice.setIcon(new ImageIcon(LudoUI.class
								.getResource("/images/Dice/" + dice
										+ "_40x40.png")));
						break;
					case Ludo.BLUE:
						lblBlueDice.setIcon(new ImageIcon(LudoUI.class
								.getResource("/images/Dice/" + dice
										+ "_40x40.png")));
						break;
					case Ludo.GREEN:
						lblGreenDice.setIcon(new ImageIcon(LudoUI.class
								.getResource("/images/Dice/" + dice
										+ "_40x40.png")));
						break;

					}

					try {
						sleep(Constants.LudoDiceTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// Take out a piece
				if (dice == 5) {

					if (Ludo.canBringPieceToStartingSquare(game.getBoard(),
							myPlayer)) {
						int piece = Ludo.takeOutPiece(game.getBoard(),
								playerTurn);

						Square square;
						JLabel squareLabel;
						switch (playerTurn) {
						case Ludo.YELLOW:
							square = Ludo.squareInfo(game.getBoard(),
									Ludo.YELLOW_INITIAL_SQUARE);
							squareLabel = squares[Ludo.YELLOW_INITIAL_SQUARE];
							setSquareIcon(squareLabel, square, playerTurn);

							pnlYellowPlayer.remove(yellowPieces[piece]);
							pnlYellowPlayer.repaint();
							break;
						case Ludo.RED:
							square = Ludo.squareInfo(game.getBoard(),
									Ludo.RED_INITIAL_SQUARE);
							squareLabel = squares[Ludo.RED_INITIAL_SQUARE];
							setSquareIcon(squareLabel, square, playerTurn);

							pnlRedPlayer.remove(redPieces[piece]);
							pnlRedPlayer.repaint();
							break;
						case Ludo.BLUE:
							square = Ludo.squareInfo(game.getBoard(),
									Ludo.BLUE_INITIAL_SQUARE);

							if (square.numberOfPieces() == 1) {
								squares[Ludo.BLUE_INITIAL_SQUARE]
										.setIcon(new ImageIcon(
												LudoUI.class
														.getResource("/images/Ludo/Pieces/blue_1.png")));
							} else {
								squares[Ludo.BLUE_INITIAL_SQUARE]
										.setIcon(new ImageIcon(
												LudoUI.class
														.getResource("/images/Ludo/Pieces/blue_2_vertical.png")));
							}
							pnlBluePlayer.remove(bluePieces[piece]);
							pnlBluePlayer.repaint();
							break;
						case Ludo.GREEN:
							square = Ludo.squareInfo(game.getBoard(),
									Ludo.GREEN_INITIAL_SQUARE);

							if (square.numberOfPieces() == 1) {
								squares[Ludo.GREEN_INITIAL_SQUARE]
										.setIcon(new ImageIcon(
												LudoUI.class
														.getResource("/images/Ludo/Pieces/green_1.png")));
							} else {
								squares[Ludo.GREEN_INITIAL_SQUARE]
										.setIcon(new ImageIcon(
												LudoUI.class
														.getResource("/images/Ludo/Pieces/green_2_vertical.png")));
							}

							pnlGreenPlayer.remove(greenPieces[piece]);
							pnlGreenPlayer.repaint();
							break;
						}

						changeTurn();
						Controller.getInstance().updateDiceGame(game.getName(),
								0, 5, piece);
						diceAnimation(playerTurn);
					} else {
						// Move piece
						if (Ludo.isPieceOut(game.getBoard(), myPlayer)) {
							if (dice == 6) {
								sixes++;
								if (sixes == 3) {
									sixes = 0;
									changeTurn();
									Controller.getInstance().updateDiceGame(
											game.getName(), -1, dice, -1);
									diceAnimation(playerTurn);
								} else {
									lblState.setText("Elige la ficha que quieras mover");
									enablePlayerSquares(myPlayer);
								}
							} else {
								sixes = 0;
								lblState.setText("Elige la ficha que quieras mover");
								enablePlayerSquares(myPlayer);
							}
						} else {
							if (dice == 6) {
								sixes++;
								if (sixes == 3) {
									sixes = 0;
									changeTurn();
									Controller.getInstance().updateDiceGame(
											game.getName(), -1, dice, -1);
									diceAnimation(playerTurn);
								} else {
									sixes = 0;
									Controller.getInstance().updateDiceGame(
											game.getName(), -1, dice, -1);
									enableDice(myPlayer);
								}
							} else {
								changeTurn();
								Controller.getInstance().updateDiceGame(
										game.getName(), -1, dice, -1);
								diceAnimation(playerTurn);
							}
						}

					}
				} else {
					// Move piece
					if (Ludo.isPieceOut(game.getBoard(), myPlayer)) {
						if (dice == 6) {
							sixes++;
							if (sixes == 3) {
								sixes = 0;
								changeTurn();
								Controller.getInstance().updateDiceGame(
										game.getName(), -1, dice, -1);
								diceAnimation(playerTurn);
							} else {
								lblState.setText("Elige la ficha que quieras mover");
								enablePlayerSquares(myPlayer);
							}
						} else {
							sixes = 0;
							lblState.setText("Elige la ficha que quieras mover");
							enablePlayerSquares(myPlayer);
						}

					} else {
						if (dice == 6) {
							sixes++;
							if (sixes == 3) {
								sixes = 0;
								changeTurn();
								Controller.getInstance().updateDiceGame(
										game.getName(), -1, dice, -1);
								diceAnimation(playerTurn);
							} else {
								sixes = 0;
								Controller.getInstance().updateDiceGame(
										game.getName(), -1, dice, -1);
								enableDice(myPlayer);
							}
						} else {
							changeTurn();
							Controller.getInstance().updateDiceGame(
									game.getName(), -1, dice, -1);
							diceAnimation(playerTurn);
						}
					}

				}
			}
		}.start();
	}

	private void move(int fromSquare) {
		disableSquares(myPlayer);

		int piece = Ludo.pieceInSquare(game.getBoard(), fromSquare, myPlayer);
		count20 = Ludo.move(piece, dice, game.getBoard(), myPlayer);
		moveAnimation(fromSquare, piece, myPlayer);
		if (dice != 6 && !count20) {
			playerTurn = game.changeTurn();
			diceAnimation(playerTurn);
		}

		Controller.getInstance().updateDiceGame(game.getName(), fromSquare,
				dice, piece);

	}

	private void diceAnimation(int player) {
		throwDice = new ThrowDiceThread(player);
		throwDice.start();
	}

	private void moveAnimation(final int fromSquare, final int piece,
			final int player) {

		new Thread() {
			public void run() {
				Square square;

				int toSquare = fromSquare + dice;

				switch (player) {
				case Ludo.YELLOW:
					// Caso normal
					if (fromSquare >= Ludo.YELLOW_INITIAL_SQUARE
							&& toSquare <= Ludo.YELLOW_LAST_SQUARE) {
						for (int from = fromSquare + 1; from <= toSquare; from++) {
							square = Ludo.squareInfo(game.getBoard(), from - 1);
							setSquareIcon(squares[from - 1], square, player);

							square = Ludo.squareInfo(game.getBoard(), from);
							if (from != toSquare)
								square.addPiece(player);
							setSquareIcon(squares[from], square, player);
							try {
								sleep(Constants.LudoPieceMoveTime);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					} else
					// En las casillas finales
					if (fromSquare >= 69
							&& fromSquare <= Ludo.YELLOW_FINAL_SQUARE - 1) {
						// Nos pasamos de la casilla final
						if (toSquare > Ludo.YELLOW_FINAL_SQUARE) {

							toSquare = game.getBoard()[player][piece];

							// Animación hacia arriba
							for (int from = fromSquare + 1; from <= Ludo.YELLOW_FINAL_SQUARE; from++) {
								square = Ludo.squareInfo(game.getBoard(),
										from - 1);
								if (from - 1 == toSquare)
									square.removePiece(player);
								setSquareIcon(squares[from - 1], square, player);

								square = Ludo.squareInfo(game.getBoard(), from);
								if (from != toSquare)
									square.addPiece(player);

								if (from == Ludo.YELLOW_FINAL_SQUARE)
									square.setPieces(Ludo.piecesInFinalSquare(
											game.getBoard(), player) + 1);

								setSquareIcon(squares[from], square, player);

								try {
									sleep(Constants.LudoPieceMoveTime);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}

							// Animación del rebote
							for (int from = Ludo.YELLOW_FINAL_SQUARE - 1; from >= toSquare; from--) {
								square = Ludo.squareInfo(game.getBoard(),
										from + 1);
								setSquareIcon(squares[from + 1], square, player);

								square = Ludo.squareInfo(game.getBoard(), from);
								if (from != toSquare)
									square.addPiece(player);
								setSquareIcon(squares[from], square, player);

								try {
									sleep(Constants.LudoPieceMoveTime);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}

						}
						// Llegamos justos o aún quedan casillas
						else {

							for (int from = fromSquare + 1; from <= toSquare; from++) {
								square = Ludo.squareInfo(game.getBoard(),
										from - 1);
								setSquareIcon(squares[from - 1], square, player);

								square = Ludo.squareInfo(game.getBoard(), from);
								if (from != toSquare)
									square.addPiece(player);
								setSquareIcon(squares[from], square, player);
								try {
									sleep(Constants.LudoPieceMoveTime);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}
					} else
					// Entramos en las casillas finales
					if (fromSquare <= Ludo.YELLOW_LAST_SQUARE
							&& toSquare > Ludo.YELLOW_LAST_SQUARE) {

						for (int from = fromSquare + 1; from <= toSquare; from++) {
							square = Ludo.squareInfo(game.getBoard(), from - 1);
							setSquareIcon(squares[from - 1], square, player);

							square = Ludo.squareInfo(game.getBoard(), from);
							if (from != toSquare)
								square.addPiece(player);
							setSquareIcon(squares[from], square, player);

							try {
								sleep(Constants.LudoPieceMoveTime);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					break;
				case Ludo.RED:
					// Caso normal 39-68 y Caso normal 1-34
					if ((fromSquare >= Ludo.RED_INITIAL_SQUARE && toSquare <= 68)
							|| (fromSquare >= 1 && toSquare <= Ludo.RED_LAST_SQUARE)) {
						for (int from = fromSquare + 1; from <= toSquare; from++) {
							square = Ludo.squareInfo(game.getBoard(), from - 1);
							setSquareIcon(squares[from - 1], square, player);

							square = Ludo.squareInfo(game.getBoard(), from);
							if (from != toSquare)
								square.addPiece(player);
							setSquareIcon(squares[from], square, player);
							try {
								sleep(Constants.LudoPieceMoveTime);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					} else
					// Caso normal pasamos del tramo 1 al 2
					if (fromSquare <= 68 && toSquare > 68) {
						toSquare = game.getBoard()[player][piece];

						for (int from = fromSquare + 1; from <= 68; from++) {
							square = Ludo.squareInfo(game.getBoard(), from - 1);
							setSquareIcon(squares[from - 1], square, player);

							square = Ludo.squareInfo(game.getBoard(), from);
							if (from != toSquare)
								square.addPiece(player);
							setSquareIcon(squares[from], square, player);
							try {
								sleep(Constants.LudoPieceMoveTime);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

						for (int from = 1; from <= toSquare; from++) {
							if (from - 1 == 0) {
								square = Ludo.squareInfo(game.getBoard(), 68);
								setSquareIcon(squares[68], square, player);
							} else {
								square = Ludo.squareInfo(game.getBoard(),
										from - 1);
								setSquareIcon(squares[from - 1], square, player);
							}

							square = Ludo.squareInfo(game.getBoard(), from);
							if (from != toSquare)
								square.addPiece(player);
							setSquareIcon(squares[from], square, player);
							try {
								sleep(Constants.LudoPieceMoveTime);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

					} else
					// En las casillas finales
					if (fromSquare >= 77
							&& fromSquare <= Ludo.RED_FINAL_SQUARE - 1) {
						// Nos pasamos de la casilla final
						if (toSquare > Ludo.RED_FINAL_SQUARE) {

							toSquare = game.getBoard()[player][piece];

							// Animación hacia arriba
							for (int from = fromSquare + 1; from <= Ludo.RED_FINAL_SQUARE; from++) {
								square = Ludo.squareInfo(game.getBoard(),
										from - 1);
								if (from - 1 == toSquare)
									square.removePiece(player);
								setSquareIcon(squares[from - 1], square, player);

								square = Ludo.squareInfo(game.getBoard(), from);
								if (from != toSquare)
									square.addPiece(player);

								if (from == Ludo.RED_FINAL_SQUARE)
									square.setPieces(Ludo.piecesInFinalSquare(
											game.getBoard(), player) + 1);

								setSquareIcon(squares[from], square, player);

								try {
									sleep(Constants.LudoPieceMoveTime);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}

							// Animación del rebote
							for (int from = Ludo.RED_FINAL_SQUARE - 1; from >= toSquare; from--) {
								square = Ludo.squareInfo(game.getBoard(),
										from + 1);
								setSquareIcon(squares[from + 1], square, player);

								square = Ludo.squareInfo(game.getBoard(), from);
								if (from != toSquare)
									square.addPiece(player);
								setSquareIcon(squares[from], square, player);

								try {
									sleep(Constants.LudoPieceMoveTime);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}

						}// Llegamos justos o aún quedan casillas
						else {
							for (int from = fromSquare + 1; from <= toSquare; from++) {
								square = Ludo.squareInfo(game.getBoard(),
										from - 1);
								setSquareIcon(squares[from - 1], square, player);

								square = Ludo.squareInfo(game.getBoard(), from);
								if (from != toSquare)
									square.addPiece(player);
								setSquareIcon(squares[from], square, player);
								try {
									sleep(Constants.LudoPieceMoveTime);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}
					} else
					// Entramos en las casillas finales
					if (fromSquare <= Ludo.RED_LAST_SQUARE
							&& toSquare > Ludo.RED_LAST_SQUARE) {

						toSquare = game.getBoard()[player][piece];

						if (fromSquare == Ludo.RED_LAST_SQUARE) {
							for (int from = 77; from <= toSquare; from++) {
								if (from == 77) {
									square = Ludo.squareInfo(game.getBoard(),
											34);
									setSquareIcon(squares[34], square, player);
								} else {
									square = Ludo.squareInfo(game.getBoard(),
											from - 1);
									setSquareIcon(squares[from - 1], square,
											player);
								}

								square = Ludo.squareInfo(game.getBoard(), from);
								if (from != toSquare)
									square.addPiece(player);
								setSquareIcon(squares[from], square, player);

								try {
									sleep(Constants.LudoPieceMoveTime);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						} else {

							for (int from = fromSquare + 1; from <= Ludo.RED_LAST_SQUARE; from++) {
								square = Ludo.squareInfo(game.getBoard(),
										from - 1);
								setSquareIcon(squares[from - 1], square, player);

								square = Ludo.squareInfo(game.getBoard(), from);
								square.addPiece(player);
								setSquareIcon(squares[from], square, player);

								try {
									sleep(Constants.LudoPieceMoveTime);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}

							for (int from = 77; from <= toSquare; from++) {
								if (from == 77) {
									square = Ludo.squareInfo(game.getBoard(),
											34);
									setSquareIcon(squares[34], square, player);
								} else {
									square = Ludo.squareInfo(game.getBoard(),
											from - 1);
									setSquareIcon(squares[from - 1], square,
											player);
								}

								square = Ludo.squareInfo(game.getBoard(), from);
								if (from != toSquare)
									square.addPiece(player);
								setSquareIcon(squares[from], square, player);

								try {
									sleep(Constants.LudoPieceMoveTime);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}
					}
					break;
				case Ludo.BLUE:
					// Caso normal 39-68 y Caso normal 1-34
					if ((fromSquare >= Ludo.BLUE_INITIAL_SQUARE && toSquare <= 68)
							|| (fromSquare >= 1 && toSquare <= Ludo.BLUE_LAST_SQUARE)) {
						for (int from = fromSquare + 1; from <= toSquare; from++) {
							square = Ludo.squareInfo(game.getBoard(), from - 1);
							setSquareIcon(squares[from - 1], square, player);

							square = Ludo.squareInfo(game.getBoard(), from);
							if (from != toSquare)
								square.addPiece(player);
							setSquareIcon(squares[from], square, player);
							try {
								sleep(Constants.LudoPieceMoveTime);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					} else
					// Caso normal pasamos del tramo 1 al 2
					if (fromSquare <= 68 && toSquare > 68) {
						toSquare = game.getBoard()[player][piece];

						for (int from = fromSquare + 1; from <= 68; from++) {
							square = Ludo.squareInfo(game.getBoard(), from - 1);
							setSquareIcon(squares[from - 1], square, player);

							square = Ludo.squareInfo(game.getBoard(), from);
							if (from != toSquare)
								square.addPiece(player);
							setSquareIcon(squares[from], square, player);
							try {
								sleep(Constants.LudoPieceMoveTime);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

						for (int from = 1; from <= toSquare; from++) {
							if (from - 1 == 0) {
								square = Ludo.squareInfo(game.getBoard(), 68);
								setSquareIcon(squares[68], square, player);
							} else {
								square = Ludo.squareInfo(game.getBoard(),
										from - 1);
								setSquareIcon(squares[from - 1], square, player);
							}

							square = Ludo.squareInfo(game.getBoard(), from);
							if (from != toSquare)
								square.addPiece(player);
							setSquareIcon(squares[from], square, player);
							try {
								sleep(Constants.LudoPieceMoveTime);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

					} else
					// En las casillas finales
					if (fromSquare >= 85
							&& fromSquare <= Ludo.BLUE_FINAL_SQUARE - 1) {
						// Nos pasamos de la casilla final
						if (toSquare > Ludo.BLUE_FINAL_SQUARE) {

							toSquare = game.getBoard()[player][piece];

							// Animación hacia arriba
							for (int from = fromSquare + 1; from <= Ludo.BLUE_FINAL_SQUARE; from++) {
								square = Ludo.squareInfo(game.getBoard(),
										from - 1);
								if (from - 1 == toSquare)
									square.removePiece(player);
								setSquareIcon(squares[from - 1], square, player);

								square = Ludo.squareInfo(game.getBoard(), from);
								if (from != toSquare)
									square.addPiece(player);

								if (from == Ludo.BLUE_FINAL_SQUARE)
									square.setPieces(Ludo.piecesInFinalSquare(
											game.getBoard(), player) + 1);

								setSquareIcon(squares[from], square, player);

								try {
									sleep(Constants.LudoPieceMoveTime);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}

							// Animación del rebote
							for (int from = Ludo.BLUE_FINAL_SQUARE - 1; from >= toSquare; from--) {
								square = Ludo.squareInfo(game.getBoard(),
										from + 1);
								setSquareIcon(squares[from + 1], square, player);

								square = Ludo.squareInfo(game.getBoard(), from);
								if (from != toSquare)
									square.addPiece(player);
								setSquareIcon(squares[from], square, player);

								try {
									sleep(Constants.LudoPieceMoveTime);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}

						}// Llegamos justos o aún quedan casillas
						else {
							for (int from = fromSquare + 1; from <= toSquare; from++) {
								square = Ludo.squareInfo(game.getBoard(),
										from - 1);
								setSquareIcon(squares[from - 1], square, player);

								square = Ludo.squareInfo(game.getBoard(), from);
								if (from != toSquare)
									square.addPiece(player);
								setSquareIcon(squares[from], square, player);
								try {
									sleep(Constants.LudoPieceMoveTime);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}
					} else
					// Entramos en las casillas finales
					if (fromSquare <= Ludo.BLUE_LAST_SQUARE
							&& toSquare > Ludo.BLUE_LAST_SQUARE) {

						toSquare = game.getBoard()[player][piece];

						if (fromSquare == Ludo.BLUE_LAST_SQUARE) {
							for (int from = 85; from <= toSquare; from++) {
								if (from == 85) {
									square = Ludo.squareInfo(game.getBoard(),
											17);
									setSquareIcon(squares[17], square, player);
								} else {
									square = Ludo.squareInfo(game.getBoard(),
											from - 1);
									setSquareIcon(squares[from - 1], square,
											player);
								}

								square = Ludo.squareInfo(game.getBoard(), from);
								if (from != toSquare)
									square.addPiece(player);
								setSquareIcon(squares[from], square, player);

								try {
									sleep(Constants.LudoPieceMoveTime);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						} else {

							for (int from = fromSquare + 1; from <= Ludo.BLUE_LAST_SQUARE; from++) {
								square = Ludo.squareInfo(game.getBoard(),
										from - 1);
								setSquareIcon(squares[from - 1], square, player);

								square = Ludo.squareInfo(game.getBoard(), from);
								square.addPiece(player);
								setSquareIcon(squares[from], square, player);

								try {
									sleep(Constants.LudoPieceMoveTime);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}

							for (int from = 85; from <= toSquare; from++) {
								if (from == 85) {
									square = Ludo.squareInfo(game.getBoard(),
											17);
									setSquareIcon(squares[17], square, player);
								} else {
									square = Ludo.squareInfo(game.getBoard(),
											from - 1);
									setSquareIcon(squares[from - 1], square,
											player);
								}

								square = Ludo.squareInfo(game.getBoard(), from);
								if (from != toSquare)
									square.addPiece(player);
								setSquareIcon(squares[from], square, player);

								try {
									sleep(Constants.LudoPieceMoveTime);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}
					}
					break;
				case Ludo.GREEN:
					// Caso normal 39-68 y Caso normal 1-34
					if ((fromSquare >= Ludo.GREEN_INITIAL_SQUARE && toSquare <= 68)
							|| (fromSquare >= 1 && toSquare <= Ludo.GREEN_LAST_SQUARE)) {
						for (int from = fromSquare + 1; from <= toSquare; from++) {
							square = Ludo.squareInfo(game.getBoard(), from - 1);
							setSquareIcon(squares[from - 1], square, player);

							square = Ludo.squareInfo(game.getBoard(), from);
							if (from != toSquare)
								square.addPiece(player);
							setSquareIcon(squares[from], square, player);
							try {
								sleep(Constants.LudoPieceMoveTime);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					} else
					// Caso normal pasamos del tramo 1 al 2
					if (fromSquare <= 68 && toSquare > 68) {
						toSquare = game.getBoard()[player][piece];

						for (int from = fromSquare + 1; from <= 68; from++) {
							square = Ludo.squareInfo(game.getBoard(), from - 1);
							setSquareIcon(squares[from - 1], square, player);

							square = Ludo.squareInfo(game.getBoard(), from);
							if (from != toSquare)
								square.addPiece(player);
							setSquareIcon(squares[from], square, player);
							try {
								sleep(Constants.LudoPieceMoveTime);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

						for (int from = 1; from <= toSquare; from++) {
							if (from - 1 == 0) {
								square = Ludo.squareInfo(game.getBoard(), 68);
								setSquareIcon(squares[68], square, player);
							} else {
								square = Ludo.squareInfo(game.getBoard(),
										from - 1);
								setSquareIcon(squares[from - 1], square, player);
							}

							square = Ludo.squareInfo(game.getBoard(), from);
							if (from != toSquare)
								square.addPiece(player);
							setSquareIcon(squares[from], square, player);
							try {
								sleep(Constants.LudoPieceMoveTime);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

					} else
					// En las casillas finales
					if (fromSquare >= 93
							&& fromSquare <= Ludo.GREEN_FINAL_SQUARE - 1) {
						// Nos pasamos de la casilla final
						if (toSquare > Ludo.GREEN_FINAL_SQUARE) {

							toSquare = game.getBoard()[player][piece];

							// Animación hacia arriba
							for (int from = fromSquare + 1; from <= Ludo.GREEN_FINAL_SQUARE; from++) {
								square = Ludo.squareInfo(game.getBoard(),
										from - 1);
								if (from - 1 == toSquare)
									square.removePiece(player);
								setSquareIcon(squares[from - 1], square, player);

								square = Ludo.squareInfo(game.getBoard(), from);
								if (from != toSquare)
									square.addPiece(player);

								if (from == Ludo.GREEN_FINAL_SQUARE)
									square.setPieces(Ludo.piecesInFinalSquare(
											game.getBoard(), player) + 1);

								setSquareIcon(squares[from], square, player);

								try {
									sleep(Constants.LudoPieceMoveTime);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}

							// Animación del rebote
							for (int from = Ludo.GREEN_FINAL_SQUARE - 1; from >= toSquare; from--) {
								square = Ludo.squareInfo(game.getBoard(),
										from + 1);
								setSquareIcon(squares[from + 1], square, player);

								square = Ludo.squareInfo(game.getBoard(), from);
								if (from != toSquare)
									square.addPiece(player);
								setSquareIcon(squares[from], square, player);

								try {
									sleep(Constants.LudoPieceMoveTime);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}

						}// Llegamos justos o aún quedan casillas
						else {
							for (int from = fromSquare + 1; from <= toSquare; from++) {
								square = Ludo.squareInfo(game.getBoard(),
										from - 1);
								setSquareIcon(squares[from - 1], square, player);

								square = Ludo.squareInfo(game.getBoard(), from);
								if (from != toSquare)
									square.addPiece(player);
								setSquareIcon(squares[from], square, player);
								try {
									sleep(Constants.LudoPieceMoveTime);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}
					} else
					// Entramos en las casillas finales
					if (fromSquare <= Ludo.GREEN_LAST_SQUARE
							&& toSquare > Ludo.GREEN_LAST_SQUARE) {

						toSquare = game.getBoard()[player][piece];

						if (fromSquare == Ludo.GREEN_LAST_SQUARE) {
							for (int from = 93; from <= toSquare; from++) {
								if (from == 93) {
									square = Ludo.squareInfo(game.getBoard(),
											51);
									setSquareIcon(squares[51], square, player);
								} else {
									square = Ludo.squareInfo(game.getBoard(),
											from - 1);
									setSquareIcon(squares[from - 1], square,
											player);
								}

								square = Ludo.squareInfo(game.getBoard(), from);
								if (from != toSquare)
									square.addPiece(player);
								setSquareIcon(squares[from], square, player);

								try {
									sleep(Constants.LudoPieceMoveTime);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						} else {

							for (int from = fromSquare + 1; from <= Ludo.GREEN_LAST_SQUARE; from++) {
								square = Ludo.squareInfo(game.getBoard(),
										from - 1);
								setSquareIcon(squares[from - 1], square, player);

								square = Ludo.squareInfo(game.getBoard(), from);
								square.addPiece(player);
								setSquareIcon(squares[from], square, player);

								try {
									sleep(Constants.LudoPieceMoveTime);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}

							for (int from = 93; from <= toSquare; from++) {
								if (from == 93) {
									square = Ludo.squareInfo(game.getBoard(),
											51);
									setSquareIcon(squares[51], square, player);
								} else {
									square = Ludo.squareInfo(game.getBoard(),
											from - 1);
									setSquareIcon(squares[from - 1], square,
											player);
								}

								square = Ludo.squareInfo(game.getBoard(), from);
								if (from != toSquare)
									square.addPiece(player);
								setSquareIcon(squares[from], square, player);

								try {
									sleep(Constants.LudoPieceMoveTime);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}
					}
					break;
				}

				if (toSquare == Ludo.YELLOW_FINAL_SQUARE
						|| toSquare == Ludo.RED_FINAL_SQUARE
						|| toSquare == Ludo.BLUE_FINAL_SQUARE
						|| toSquare == Ludo.GREEN_FINAL_SQUARE) {
					if (Ludo.isWinner(game.getBoard(), myPlayer)) {
						Controller.getInstance().finishGame(game.getName(),
								username);
						JOptionPane.showMessageDialog(LudoUI.this,
								"¡Has ganado el juego!");
						dispose();
					}
				} else

				if (!count20) {
					if (playerTurn != myPlayer) {
						switch (playerTurn) {
						case Ludo.YELLOW:
							lblState.setText("Es el turno de "
									+ lblYellowPlayerName.getText());
							break;
						case Ludo.RED:
							lblState.setText("Es el turno de "
									+ lblRedPlayerName.getText());
							break;
						case Ludo.BLUE:
							lblState.setText("Es el turno de "
									+ lblBluePlayerName.getText());
							break;
						case Ludo.GREEN:
							lblState.setText("Es el turno de "
									+ lblGreenPlayerName.getText());
							break;

						}
					} else {
						lblState.setText("Es tu turno, lanza el dado");
						enableDice(myPlayer);
					}
				} else {
					lblState.setText("Has comido una ficha, cuentate 20!");
					enablePlayerSquares(player);
					dice = 20;
					// refreshInitialPieces();
				}

			}
		}.start();

	}

	private void disableSquares(int player) {
		int[] piecesSquares = game.getBoard(player);
		for (int piece = 0; piece < 4; piece++) {
			int pieceSquare = piecesSquares[piece];
			if (pieceSquare != Ludo.HOUSE) {
				enabledSquares[pieceSquare] = false;
			}
		}

		setDefaultCursor();

	}

	private void enablePlayerSquares(int player) {
		boolean validMoves = false;

		int[] piecesSquares = game.getBoard(player);
		for (int piece = 0; piece < 4; piece++) {
			int pieceSquare = piecesSquares[piece];
			if (pieceSquare != Ludo.HOUSE
					&& Ludo.validateMove(piece, dice, game.getBoard(), player)) {
				enabledSquares[pieceSquare] = true;
				validMoves = true;
			}
		}

		if (!validMoves) {
			disableDices();
			changeTurn();
			Controller.getInstance().updateDiceGame(game.getName(), -1, dice,
					-1);
			diceAnimation(playerTurn);
		}

	}

	private void changeTurn() {
		playerTurn = game.changeTurn();
		switch (playerTurn) {
		case Ludo.YELLOW:
			lblState.setText("Es el turno de : "
					+ lblYellowPlayerName.getText());
			break;
		case Ludo.RED:
			lblState.setText("Es el turno de " + lblRedPlayerName.getText());
			break;
		case Ludo.BLUE:
			lblState.setText("Es el turno de " + lblBluePlayerName.getText());
			break;
		case Ludo.GREEN:
			lblState.setText("Es el turno de " + lblGreenPlayerName.getText());
			break;
		}

		if (myPlayer == playerTurn)
			enableDice(playerTurn);

	}

	public void updateBoard(int fromSquare, int squares, int movedPiece) {
		throwing = false;
		try {
			throwDice.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (squares != 20)
			switch (playerTurn) {
			case Ludo.YELLOW:
				lblYellowDice
						.setIcon(new ImageIcon(LudoUI.class
								.getResource("/images/Dice/" + squares
										+ "_40x40.png")));
				break;
			case Ludo.RED:
				lblRedDice
						.setIcon(new ImageIcon(LudoUI.class
								.getResource("/images/Dice/" + squares
										+ "_40x40.png")));
				break;
			case Ludo.BLUE:
				lblBlueDice
						.setIcon(new ImageIcon(LudoUI.class
								.getResource("/images/Dice/" + squares
										+ "_40x40.png")));
				break;
			case Ludo.GREEN:
				lblGreenDice
						.setIcon(new ImageIcon(LudoUI.class
								.getResource("/images/Dice/" + squares
										+ "_40x40.png")));
				break;
			}

		if (movedPiece != -1) {
			dice = squares;
			if (dice == 5) {
				int pieceSquare = game.getBoard()[playerTurn][movedPiece];

				Square squareInfo = Ludo.squareInfo(game.getBoard(),
						pieceSquare);

				switch (playerTurn) {
				case Ludo.YELLOW:
					if (pieceSquare == Ludo.YELLOW_INITIAL_SQUARE) {
						pnlYellowPlayer.remove(yellowPieces[movedPiece]);
						pnlYellowPlayer.repaint();
						setSquareIcon(this.squares[pieceSquare], squareInfo,
								playerTurn);
					} else {
						// The player moves a piece
						moveAnimation(fromSquare, movedPiece, playerTurn);
					}
					break;
				case Ludo.RED:
					if (pieceSquare == Ludo.RED_INITIAL_SQUARE) {
						pnlRedPlayer.remove(redPieces[movedPiece]);
						pnlRedPlayer.repaint();
						setSquareIcon(this.squares[pieceSquare], squareInfo,
								playerTurn);
					} else {
						// The player moves a piece
						moveAnimation(fromSquare, movedPiece, playerTurn);
					}
					break;
				case Ludo.BLUE:
					if (pieceSquare == Ludo.BLUE_INITIAL_SQUARE) {
						pnlBluePlayer.remove(bluePieces[movedPiece]);
						pnlBluePlayer.repaint();
						setSquareIcon(this.squares[pieceSquare], squareInfo,
								playerTurn);
					} else {
						moveAnimation(fromSquare, movedPiece, playerTurn);
					}
					break;
				case Ludo.GREEN:
					if (pieceSquare == Ludo.GREEN_INITIAL_SQUARE) {
						pnlGreenPlayer.remove(greenPieces[movedPiece]);
						pnlGreenPlayer.repaint();
						setSquareIcon(this.squares[pieceSquare], squareInfo,
								playerTurn);
					} else {
						// The player moves a piece
						moveAnimation(fromSquare, movedPiece, playerTurn);
					}
					break;
				}

			} else {
				// The player moves a piece
				moveAnimation(fromSquare, movedPiece, playerTurn);
			}

			playerTurn = game.getTurn();
		}

		playerTurn = game.getTurn();

		// Set label state
		if (playerTurn == myPlayer) {
			lblState.setText("Es tu turno, lanza el dado");
			enableDice(myPlayer);
		} else {
			switch (playerTurn) {
			case Ludo.YELLOW:
				lblState.setText("Es el turno de "
						+ lblYellowPlayerName.getText());
				break;
			case Ludo.RED:
				lblState.setText("Es el turno de " + lblRedPlayerName.getText());
				break;
			case Ludo.BLUE:
				lblState.setText("Es el turno de "
						+ lblBluePlayerName.getText());
				break;
			case Ludo.GREEN:
				lblState.setText("Es el turno de "
						+ lblGreenPlayerName.getText());
				break;
			}

			if (squares != 20)
				diceAnimation(playerTurn);
			else
				refreshInitialPieces();
		}

	}

	private void refreshInitialPieces() {
		for (int index = 0; index < 4; index++) {
			for (int piece = 0; piece < 4; piece++) {
				switch (index) {
				case Ludo.YELLOW:
					if (game.getBoard()[index][piece] == Ludo.HOUSE) {
						yellowPieces[piece]
								.setIcon(new ImageIcon(
										LudoUI.class
												.getResource("/images/Ludo/pieces/yellow_1.png")));
						yellowPieces[piece].repaint();
					}
					break;
				case Ludo.RED:
					if (game.getBoard()[index][piece] == Ludo.HOUSE) {
						redPieces[piece].setIcon(new ImageIcon(LudoUI.class
								.getResource("/images/Ludo/pieces/red_1.png")));
						redPieces[piece].repaint();
					}
					break;
				case Ludo.BLUE:
					if (game.getBoard()[index][piece] == Ludo.HOUSE) {
						bluePieces[piece]
								.setIcon(new ImageIcon(
										LudoUI.class
												.getResource("/images/Ludo/pieces/blue_1.png")));
						bluePieces[piece].repaint();
					}
					break;
				case Ludo.GREEN:
					if (game.getBoard()[index][piece] == Ludo.HOUSE) {
						greenPieces[piece]
								.setIcon(new ImageIcon(
										LudoUI.class
												.getResource("/images/Ludo/pieces/green_1.png")));
						greenPieces[piece].repaint();
					}
					break;
				}
			}
		}

		pnlYellowPlayer.repaint();
		pnlRedPlayer.repaint();
		pnlBluePlayer.repaint();
		pnlGreenPlayer.repaint();
	}

	private void setSquareIcon(JLabel lblSquare, Square square, int player) {
		int squareNum = square.getSquare();
		int pieces;

		/*
		 * if (squareNum == 76 || squareNum == 84 || squareNum == 92 ||
		 * squareNum == 100) pieces = Ludo.piecesInFinalSquare(game.getBoard(),
		 * player); else
		 */
		pieces = square.getPieces();

		switch (pieces) {
		case 0:
			if (squareNum < 69 && squareNum != 8 && squareNum != 9
					&& squareNum != 25 && squareNum != 26 && squareNum != 42
					&& squareNum != 43 && squareNum != 59 && squareNum != 60)
				lblSquare.setText(String.valueOf(square.getSquare()));

			// Diagonal Squares
			if (squareNum == 8 || squareNum == 9 || squareNum == 25
					|| squareNum == 26 || squareNum == 42 || squareNum == 43
					|| squareNum == 59 || squareNum == 60) {

				lblSquare.setIcon(new ImageIcon(LudoUI.class
						.getResource("/images/Ludo/square_" + squareNum
								+ ".png")));
			} else {
				// Last squares
				if (squareNum == 76 || squareNum == 84 || squareNum == 92
						|| squareNum == 100) {

					switch (player) {
					case Ludo.YELLOW:
						lblSquare
								.setIcon(new ImageIcon(
										LudoUI.class
												.getResource("/images/Ludo/yellow_final_square.png")));
						break;
					case Ludo.RED:
						lblSquare
								.setIcon(new ImageIcon(
										LudoUI.class
												.getResource("/images/Ludo/red_final_square.png")));
						break;
					case Ludo.BLUE:
						lblSquare
								.setIcon(new ImageIcon(
										LudoUI.class
												.getResource("/images/Ludo/blue_final_square.png")));
						break;
					case Ludo.GREEN:
						lblSquare
								.setIcon(new ImageIcon(
										LudoUI.class
												.getResource("/images/Ludo/green_final_square.png")));
						break;
					}

				} else {

					lblSquare.setIcon(null);

					if ((squareNum >= 1 && squareNum <= 7)
							|| (squareNum >= 27 && squareNum <= 33)) {
						lblSquare.setHorizontalAlignment(SwingConstants.RIGHT);
					} else if ((squareNum >= 61 && squareNum <= 67)
							|| (squareNum >= 35 && squareNum <= 41)) {
						lblSquare.setHorizontalAlignment(SwingConstants.LEFT);
					}
				}
			}

			break;
		case 1:
			switch (square.getFirstPiece()) {
			case Ludo.YELLOW:
				if (squareNum == 8 || squareNum == 9 || squareNum == 25
						|| squareNum == 26 || squareNum == 42
						|| squareNum == 43 || squareNum == 59
						|| squareNum == 60)
					lblSquare.setIcon(new ImageIcon(LudoUI.class
							.getResource("/images/Ludo/square_" + squareNum
									+ "_yellow.png")));
				else if (squareNum == 76) {
					lblSquare
							.setIcon(new ImageIcon(
									LudoUI.class
											.getResource("/images/Ludo/yellow_final_1_square.png")));
				} else {
					lblSquare.setIcon(new ImageIcon(LudoUI.class
							.getResource("/images/Ludo/Pieces/yellow_1.png")));
				}
				break;
			case Ludo.RED:
				if (squareNum == 8 || squareNum == 9 || squareNum == 25
						|| squareNum == 26 || squareNum == 42
						|| squareNum == 43 || squareNum == 59
						|| squareNum == 60)
					lblSquare.setIcon(new ImageIcon(LudoUI.class
							.getResource("/images/Ludo/square_" + squareNum
									+ "_red.png")));
				else if (squareNum == 84)
					lblSquare
							.setIcon(new ImageIcon(
									LudoUI.class
											.getResource("/images/Ludo/red_final_1_square.png")));
				else
					lblSquare.setIcon(new ImageIcon(LudoUI.class
							.getResource("/images/Ludo/Pieces/red_1.png")));
				break;
			case Ludo.BLUE:
				if (squareNum == 8 || squareNum == 9 || squareNum == 25
						|| squareNum == 26 || squareNum == 42
						|| squareNum == 43 || squareNum == 59
						|| squareNum == 60)
					lblSquare.setIcon(new ImageIcon(LudoUI.class
							.getResource("/images/Ludo/square_" + squareNum
									+ "_blue.png")));
				else if (squareNum == 92)
					lblSquare
							.setIcon(new ImageIcon(
									LudoUI.class
											.getResource("/images/Ludo/blue_final_1_square.png")));
				else
					lblSquare.setIcon(new ImageIcon(LudoUI.class
							.getResource("/images/Ludo/Pieces/blue_1.png")));
				break;
			case Ludo.GREEN:
				if (squareNum == 8 || squareNum == 9 || squareNum == 25
						|| squareNum == 26 || squareNum == 42
						|| squareNum == 43 || squareNum == 59
						|| squareNum == 60)
					lblSquare.setIcon(new ImageIcon(LudoUI.class
							.getResource("/images/Ludo/square_" + squareNum
									+ "_green.png")));
				else if (squareNum == 100)
					lblSquare
							.setIcon(new ImageIcon(
									LudoUI.class
											.getResource("/images/Ludo/green_final_1_square.png")));
				else
					lblSquare.setIcon(new ImageIcon(LudoUI.class
							.getResource("/images/Ludo/Pieces/green_1.png")));
				break;
			}

			if ((squareNum >= 1 && squareNum <= 7)
					|| (squareNum >= 27 && squareNum <= 33)) {
				lblSquare.setHorizontalAlignment(SwingConstants.RIGHT);
			}

			if ((squareNum >= 61 && squareNum <= 67)
					|| (squareNum >= 35 && squareNum <= 41)) {
				lblSquare.setHorizontalAlignment(SwingConstants.LEFT);
			}

			if (squareNum <= 68 && squareNum != 8 && squareNum != 9
					&& squareNum != 25 && squareNum != 26 && squareNum != 42
					&& squareNum != 43 && squareNum != 59 && squareNum != 60)
				lblSquare.setText(String.valueOf(square.getSquare()));

			if (squareNum == 17 || squareNum == 34 || squareNum == 51
					|| squareNum == 68)
				lblSquare.setText(null);

			break;
		case 2:

			// Same color
			if (square.getFirstPiece() == square.getSecondPiece()) {
				switch (square.getFirstPiece()) {
				case Ludo.YELLOW:
					if (squareNum == 76)
						lblSquare
								.setIcon(new ImageIcon(
										LudoUI.class
												.getResource("/images/Ludo/yellow_final_2_square.png")));
					else if ((squareNum >= 1 && squareNum <= 7)
							|| (squareNum >= 27 && squareNum <= 41)
							|| (squareNum >= 61 && squareNum <= 75)) {
						lblSquare
								.setIcon(new ImageIcon(
										LudoUI.class
												.getResource("/images/Ludo/Pieces/yellow_2.png")));
					} else if (squareNum == 8 || squareNum == 9
							|| squareNum == 25 || squareNum == 26
							|| squareNum == 42 || squareNum == 43
							|| squareNum == 59 || squareNum == 60) {
						lblSquare.setIcon(new ImageIcon(LudoUI.class
								.getResource("/images/Ludo/square_" + squareNum
										+ "_yellow_2.png")));
					} else {
						lblSquare
								.setIcon(new ImageIcon(
										LudoUI.class
												.getResource("/images/Ludo/Pieces/yellow_2_vertical.png")));
					}

					break;
				case Ludo.RED:
					if (squareNum == 84)
						lblSquare
								.setIcon(new ImageIcon(
										LudoUI.class
												.getResource("/images/Ludo/red_final_2_square.png")));
					else if ((squareNum >= 1 && squareNum <= 7)
							|| (squareNum >= 27 && squareNum <= 41)
							|| (squareNum >= 61 && squareNum <= 68)
							|| (squareNum >= 77 && squareNum <= 83)) {
						lblSquare.setIcon(new ImageIcon(LudoUI.class
								.getResource("/images/Ludo/Pieces/red_2.png")));
					} else if (squareNum == 8 || squareNum == 9
							|| squareNum == 25 || squareNum == 26
							|| squareNum == 42 || squareNum == 43
							|| squareNum == 59 || squareNum == 60) {
						lblSquare.setIcon(new ImageIcon(LudoUI.class
								.getResource("/images/Ludo/square_" + squareNum
										+ "_red_2.png")));
					} else {
						lblSquare
								.setIcon(new ImageIcon(
										LudoUI.class
												.getResource("/images/Ludo/Pieces/red_2_vertical.png")));
					}
					break;
				case Ludo.BLUE:
					if (squareNum == 92)
						lblSquare
								.setIcon(new ImageIcon(
										LudoUI.class
												.getResource("/images/Ludo/blue_final_2_square.png")));
					else if ((squareNum >= 1 && squareNum <= 7)
							|| (squareNum >= 27 && squareNum <= 41)
							|| (squareNum >= 61 && squareNum <= 68)) {
						lblSquare
								.setIcon(new ImageIcon(
										LudoUI.class
												.getResource("/images/Ludo/Pieces/blue_2.png")));
					} else if (squareNum == 8 || squareNum == 9
							|| squareNum == 25 || squareNum == 26
							|| squareNum == 42 || squareNum == 43
							|| squareNum == 59 || squareNum == 60) {
						lblSquare.setIcon(new ImageIcon(LudoUI.class
								.getResource("/images/Ludo/square_" + squareNum
										+ "_blue_2.png")));
					} else {
						lblSquare
								.setIcon(new ImageIcon(
										LudoUI.class
												.getResource("/images/Ludo/Pieces/blue_2_vertical.png")));
					}
					break;
				case Ludo.GREEN:
					if (squareNum == 100)
						lblSquare
								.setIcon(new ImageIcon(
										LudoUI.class
												.getResource("/images/Ludo/yellow_final_2_square.png")));
					else if ((squareNum >= 1 && squareNum <= 7)
							|| (squareNum >= 27 && squareNum <= 41)
							|| (squareNum >= 61 && squareNum <= 68)) {
						lblSquare
								.setIcon(new ImageIcon(
										LudoUI.class
												.getResource("/images/Ludo/Pieces/green_2.png")));
					} else if (squareNum == 8 || squareNum == 9
							|| squareNum == 25 || squareNum == 26
							|| squareNum == 42 || squareNum == 43
							|| squareNum == 59 || squareNum == 60) {
						lblSquare.setIcon(new ImageIcon(LudoUI.class
								.getResource("/images/Ludo/square_" + squareNum
										+ "_green_2.png")));
					} else {
						lblSquare
								.setIcon(new ImageIcon(
										LudoUI.class
												.getResource("/images/Ludo/Pieces/green_2_vertical.png")));
					}
					break;
				}
			} else
			// Yellow-Red
			if ((square.getFirstPiece() == Ludo.YELLOW && square
					.getSecondPiece() == Ludo.RED)
					|| (square.getFirstPiece() == Ludo.RED && square
							.getSecondPiece() == Ludo.YELLOW)) {
				if (squareNum == 8 || squareNum == 9 || squareNum == 25
						|| squareNum == 26 || squareNum == 42
						|| squareNum == 43 || squareNum == 59
						|| squareNum == 60) {
					lblSquare.setIcon(new ImageIcon(LudoUI.class
							.getResource("/images/Ludo/square_" + squareNum
									+ "_yellow_red.png")));
				} else

				if ((squareNum >= 1 && squareNum <= 7)
						|| (squareNum >= 27 && squareNum <= 41)
						|| (squareNum >= 61 && squareNum <= 68)) {
					lblSquare
							.setIcon(new ImageIcon(
									LudoUI.class
											.getResource("/images/Ludo/Pieces/yellow_red.png")));
				} else {
					lblSquare
							.setIcon(new ImageIcon(
									LudoUI.class
											.getResource("/images/Ludo/Pieces/yellow_red_vertical.png")));
				}

			} else
			// Yellow-Blue
			if ((square.getFirstPiece() == Ludo.YELLOW && square
					.getSecondPiece() == Ludo.BLUE)
					|| (square.getFirstPiece() == Ludo.BLUE && square
							.getSecondPiece() == Ludo.YELLOW)) {
				if (squareNum == 8 || squareNum == 9 || squareNum == 25
						|| squareNum == 26 || squareNum == 42
						|| squareNum == 43 || squareNum == 59
						|| squareNum == 60) {
					lblSquare.setIcon(new ImageIcon(LudoUI.class
							.getResource("/images/Ludo/square_" + squareNum
									+ "_yellow_blue.png")));
				} else

				if ((squareNum >= 1 && squareNum <= 7)
						|| (squareNum >= 27 && squareNum <= 41)
						|| (squareNum >= 61 && squareNum <= 68)) {
					lblSquare
							.setIcon(new ImageIcon(
									LudoUI.class
											.getResource("/images/Ludo/Pieces/yellow_blue.png")));
				} else {
					lblSquare
							.setIcon(new ImageIcon(
									LudoUI.class
											.getResource("/images/Ludo/Pieces/yellow_blue_vertical.png")));
				}

			} else
			// Yellow-Green
			if ((square.getFirstPiece() == Ludo.YELLOW && square
					.getSecondPiece() == Ludo.GREEN)
					|| (square.getFirstPiece() == Ludo.GREEN && square
							.getSecondPiece() == Ludo.YELLOW)) {

				if (squareNum == 8 || squareNum == 9 || squareNum == 25
						|| squareNum == 26 || squareNum == 42
						|| squareNum == 43 || squareNum == 59
						|| squareNum == 60) {
					lblSquare.setIcon(new ImageIcon(LudoUI.class
							.getResource("/images/Ludo/square_" + squareNum
									+ "_yellow_green.png")));
				} else if ((squareNum >= 1 && squareNum <= 7)
						|| (squareNum >= 27 && squareNum <= 41)
						|| (squareNum >= 61 && squareNum <= 68)) {
					lblSquare
							.setIcon(new ImageIcon(
									LudoUI.class
											.getResource("/images/Ludo/Pieces/yellow_green.png")));
				} else {
					lblSquare
							.setIcon(new ImageIcon(
									LudoUI.class
											.getResource("/images/Ludo/Pieces/yellow_green_vertical.png")));
				}

			} else
			// Red-Blue
			if ((square.getFirstPiece() == Ludo.RED && square.getSecondPiece() == Ludo.BLUE)
					|| (square.getFirstPiece() == Ludo.BLUE && square
							.getSecondPiece() == Ludo.RED)) {

				if (squareNum == 8 || squareNum == 9 || squareNum == 25
						|| squareNum == 26 || squareNum == 42
						|| squareNum == 43 || squareNum == 59
						|| squareNum == 60) {
					lblSquare.setIcon(new ImageIcon(LudoUI.class
							.getResource("/images/Ludo/square_" + squareNum
									+ "_red_blue.png")));

				} else if ((squareNum >= 1 && squareNum <= 7)
						|| (squareNum >= 27 && squareNum <= 41)
						|| (squareNum >= 61 && squareNum <= 68)) {
					lblSquare.setIcon(new ImageIcon(LudoUI.class
							.getResource("/images/Ludo/Pieces/red_blue.png")));
				} else {
					lblSquare
							.setIcon(new ImageIcon(
									LudoUI.class
											.getResource("/images/Ludo/Pieces/red_blue_vertical.png")));
				}

			} else
			// Red-Green
			if ((square.getFirstPiece() == Ludo.RED && square.getSecondPiece() == Ludo.GREEN)
					|| (square.getFirstPiece() == Ludo.GREEN && square
							.getSecondPiece() == Ludo.RED)) {

				if (squareNum == 8 || squareNum == 9 || squareNum == 25
						|| squareNum == 26 || squareNum == 42
						|| squareNum == 43 || squareNum == 59
						|| squareNum == 60) {
					lblSquare.setIcon(new ImageIcon(LudoUI.class
							.getResource("/images/Ludo/square_" + squareNum
									+ "_red_green.png")));
				} else

				if ((squareNum >= 1 && squareNum <= 7)
						|| (squareNum >= 27 && squareNum <= 41)
						|| (squareNum >= 61 && squareNum <= 68)) {
					lblSquare.setIcon(new ImageIcon(LudoUI.class
							.getResource("/images/Ludo/Pieces/red_green.png")));
				} else {
					lblSquare
							.setIcon(new ImageIcon(
									LudoUI.class
											.getResource("/images/Ludo/Pieces/red_green_vertical.png")));
				}

			} else
			// Blue-Green
			if ((square.getFirstPiece() == Ludo.BLUE && square.getSecondPiece() == Ludo.GREEN)
					|| (square.getFirstPiece() == Ludo.GREEN && square
							.getSecondPiece() == Ludo.BLUE)) {

				if (squareNum == 8 || squareNum == 9 || squareNum == 25
						|| squareNum == 26 || squareNum == 42
						|| squareNum == 43 || squareNum == 59
						|| squareNum == 60) {
					lblSquare.setIcon(new ImageIcon(LudoUI.class
							.getResource("/images/Ludo/square_" + squareNum
									+ "_blue_green.png")));
				} else

				if ((squareNum >= 1 && squareNum <= 7)
						|| (squareNum >= 27 && squareNum <= 41)
						|| (squareNum >= 61 && squareNum <= 68)) {
					lblSquare
							.setIcon(new ImageIcon(
									LudoUI.class
											.getResource("/images/Ludo/Pieces/blue_green.png")));
				} else {
					lblSquare
							.setIcon(new ImageIcon(
									LudoUI.class
											.getResource("/images/Ludo/Pieces/blue_green_vertical.png")));
				}

			}

			lblSquare.setHorizontalAlignment(SwingConstants.CENTER);
			lblSquare.setText(null);
			break;
		case 3:
			switch (player) {
			case Ludo.YELLOW:
				lblSquare
						.setIcon(new ImageIcon(
								LudoUI.class
										.getResource("/images/Ludo/yellow_final_3_square.png")));
				break;
			case Ludo.RED:
				lblSquare.setIcon(new ImageIcon(LudoUI.class
						.getResource("/images/Ludo/red_final_3_square.png")));
				break;
			case Ludo.BLUE:
				lblSquare.setIcon(new ImageIcon(LudoUI.class
						.getResource("/images/Ludo/blue_final_3_square.png")));
				break;
			case Ludo.GREEN:
				lblSquare.setIcon(new ImageIcon(LudoUI.class
						.getResource("/images/Ludo/green_final_3_square.png")));
				break;
			}
			break;
		case 4:
			switch (player) {
			case Ludo.YELLOW:
				lblSquare
						.setIcon(new ImageIcon(
								LudoUI.class
										.getResource("/images/Ludo/yellow_final_4_square.png")));
				break;
			case Ludo.RED:
				lblSquare.setIcon(new ImageIcon(LudoUI.class
						.getResource("/images/Ludo/red_final_4_square.png")));
				break;
			case Ludo.BLUE:
				lblSquare.setIcon(new ImageIcon(LudoUI.class
						.getResource("/images/Ludo/blue_final_4_square.png")));
				break;
			case Ludo.GREEN:
				lblSquare.setIcon(new ImageIcon(LudoUI.class
						.getResource("/images/Ludo/green_final_4_square.png")));
				break;
			}
			break;
		}
	}

	private class ThrowDiceThread extends Thread {
		private int player;

		public ThrowDiceThread(int player) {
			super();
			this.player = player;
		}

		public void run() {
			throwing = true;
			while (throwing) {
				int playerDice = Ludo.throwDice();
				switch (player) {
				case Ludo.YELLOW:
					lblYellowDice.setIcon(new ImageIcon(LudoUI.class
							.getResource("/images/Dice/" + playerDice
									+ "_40x40.png")));
					break;
				case Ludo.RED:
					lblRedDice.setIcon(new ImageIcon(LudoUI.class
							.getResource("/images/Dice/" + playerDice
									+ "_40x40.png")));
					break;
				case Ludo.BLUE:
					lblBlueDice.setIcon(new ImageIcon(LudoUI.class
							.getResource("/images/Dice/" + playerDice
									+ "_40x40.png")));
					break;
				case Ludo.GREEN:
					lblGreenDice.setIcon(new ImageIcon(LudoUI.class
							.getResource("/images/Dice/" + playerDice
									+ "_40x40.png")));
					break;
				}

				try {
					sleep(Constants.LudoDiceTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	protected void btnQuitMouseClicked(MouseEvent arg0) {
		Controller.getInstance().leaveGame(game.getName());
		dispose();
	}

	protected void thisWindowClosing(WindowEvent arg0) {
		Controller.getInstance().leaveGame(game.getName());
		dispose();
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
			btnNewButton.setVisible(false);
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					btnNewButtonMouseClicked(arg0);
				}
			});
			btnNewButton.setBounds(535, 660, 89, 23);
		}
		return btnNewButton;
	}

	protected void btnNewButtonMouseClicked(MouseEvent arg0) {
		Ludo.printState(game.getBoard());
	}
}
