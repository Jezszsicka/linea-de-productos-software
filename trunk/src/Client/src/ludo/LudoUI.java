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
import chess.Chess.Player;
import constants.Constants;

@SuppressWarnings("serial")
public class LudoUI extends JFrame implements GameUI {
	private JPanel pnlBackground;
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
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_13;
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
	private JLabel label_31;
	private JLabel label_32;
	private JLabel label_33;
	private JLabel label_34;
	private JLabel label_35;
	private JLabel label_36;
	private JLabel label_37;
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
	private JLabel label_50;
	private JLabel lbl_36;
	private JLabel lbl_30;
	private JLabel label_53;
	private JLabel lbl_38;
	private JLabel lbl_37;
	private JLabel label_56;
	private JLabel lbl_31;
	private JLabel lbl_25;
	private JLabel lbl_26;
	private JLabel lbl_27;
	private JLabel lbl_28;
	private JLabel lbl_29;
	private JLabel label_62;
	private JLabel label_63;
	private JLabel label_64;
	private JLabel label_65;
	private JLabel lbl_42;
	private JLabel lbl_41;
	private JLabel lbl_40;
	private JLabel lbl_39;
	private JPanel pnlYellowSide;
	private JLabel lbl_8;
	private JLabel label_71;
	private JLabel lbl_60;
	private JLabel lbl_7;
	private JLabel label_74;
	private JLabel lbl_61;
	private JLabel lbl_5;
	private JLabel label_77;
	private JLabel lbl_63;
	private JLabel lbl_62;
	private JLabel label_80;
	private JLabel lbl_6;
	private JLabel lbl_1;
	private JLabel lbl_2;
	private JLabel lbl_3;
	private JLabel lbl_4;
	private JLabel label_86;
	private JLabel label_87;
	private JLabel label_88;
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
	private JButton button;
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
	private JLabel[] squares;
	private JLabel[] yellowPieces;
	private JLabel[] redPieces;
	private JLabel[] bluePieces;
	private JLabel[] greenPieces;
	private boolean[] enabledSquares;

	public LudoUI(String username, Game game) {
		this.username = username;
		this.game = game;
		squares = new JLabel[69];
		enabledSquares = new boolean[69];
		yellowPieces = new JLabel[4];
		redPieces = new JLabel[4];
		bluePieces = new JLabel[4];
		greenPieces = new JLabel[4];
		destinatary = "";
		initGUI();
		initPlayers();
		initPieces();

		if (myPlayer == Ludo.YELLOW) {
			lblState.setText("Es tu turno, lanza el dado");
			enableDice(myPlayer);
		} else {
			lblState.setText("Es el turno de " + lblYellowPlayerName.getText());
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
					icon = new ImageIcon(slotUser.getAvatar());
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
					break;
				case Ludo.GREEN:
					player = Ludo.GREEN;
					lblGreenPlayerName.setText(slotName);
					lblGreenPlayerAvatar.setIcon(icon);
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
		setSize(new Dimension(647, 850));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		getContentPane().add(getPnlBackground());
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private JPanel getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setBounds(0, 0, 642, 822);
			pnlBackground.setLayout(null);
			pnlBackground.add(getPnlBoard());
			pnlBackground.add(getButton());
			pnlBackground.add(getTxtMessage());
			pnlBackground.add(getScrollPane());
			pnlBackground.add(getLblState());
		}
		return pnlBackground;
	}

	private JPanel getPnlBoard() {
		if (pnlBoard == null) {
			pnlBoard = new JPanel();
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
			lbl_11.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_11MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lbl_11MouseExited(e);
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
			pnlBlueSide.add(getLabel_4());
			pnlBlueSide.add(getLabel_5());
			pnlBlueSide.add(getLabel_7());
			pnlBlueSide.add(getLabel_8());
			pnlBlueSide.add(getLabel_10());
			pnlBlueSide.add(getLabel_11());
			pnlBlueSide.add(getLabel_13());
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
			lbl_10.setVerticalAlignment(SwingConstants.BOTTOM);
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

	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("");
			label_4.setHorizontalAlignment(SwingConstants.CENTER);
			label_4.setOpaque(true);
			label_4.setBackground(new Color(0, 0, 255));
			label_4.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_4.setBounds(30, 60, 30, 60);
			squares[4] = lbl_4;
		}
		return label_4;
	}

	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("");
			label_5.setHorizontalAlignment(SwingConstants.CENTER);
			label_5.setOpaque(true);
			label_5.setBackground(new Color(0, 0, 255));
			label_5.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_5.setBounds(60, 60, 30, 60);
			squares[5] = lbl_5;
		}
		return label_5;
	}

	private JLabel getLabel_7() {
		if (label_7 == null) {
			label_7 = new JLabel("");
			label_7.setHorizontalAlignment(SwingConstants.CENTER);
			label_7.setOpaque(true);
			label_7.setBackground(new Color(0, 0, 255));
			label_7.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_7.setBounds(90, 60, 30, 60);
			squares[7] = lbl_7;
		}
		return label_7;
	}

	private JLabel getLabel_8() {
		if (label_8 == null) {
			label_8 = new JLabel("");
			label_8.setHorizontalAlignment(SwingConstants.CENTER);
			label_8.setOpaque(true);
			label_8.setBackground(new Color(0, 0, 255));
			label_8.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_8.setBounds(120, 60, 30, 60);
			squares[8] = lbl_8;
		}
		return label_8;
	}

	private JLabel getLabel_10() {
		if (label_10 == null) {
			label_10 = new JLabel("");
			label_10.setHorizontalAlignment(SwingConstants.CENTER);
			label_10.setOpaque(true);
			label_10.setBackground(new Color(0, 0, 255));
			label_10.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_10.setBounds(150, 60, 30, 60);
			squares[10] = lbl_10;
		}
		return label_10;
	}

	private JLabel getLabel_11() {
		if (label_11 == null) {
			label_11 = new JLabel("");
			label_11.setHorizontalAlignment(SwingConstants.CENTER);
			label_11.setOpaque(true);
			label_11.setBackground(new Color(0, 0, 255));
			label_11.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_11.setBounds(180, 60, 30, 60);
			squares[11] = lbl_11;
		}
		return label_11;
	}

	private JLabel getLabel_13() {
		if (label_13 == null) {
			label_13 = new JLabel("");
			label_13.setHorizontalAlignment(SwingConstants.CENTER);
			label_13.setOpaque(true);
			label_13.setBackground(new Color(0, 0, 255));
			label_13.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_13.setBounds(210, 60, 30, 60);
			squares[13] = lbl_13;
		}
		return label_13;
	}

	private JLabel getLbl_18() {
		if (lbl_18 == null) {
			lbl_18 = new JLabel("18");
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
			pnlGreenSide.add(getLabel_31());
			pnlGreenSide.add(getLabel_32());
			pnlGreenSide.add(getLabel_33());
			pnlGreenSide.add(getLabel_34());
			pnlGreenSide.add(getLabel_35());
			pnlGreenSide.add(getLabel_36());
			pnlGreenSide.add(getLabel_37());
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

	private JLabel getLabel_31() {
		if (label_31 == null) {
			label_31 = new JLabel("");
			label_31.setHorizontalAlignment(SwingConstants.CENTER);
			label_31.setBackground(new Color(50, 205, 50));
			label_31.setOpaque(true);
			label_31.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_31.setBounds(0, 60, 30, 60);
			squares[31] = lbl_31;
		}
		return label_31;
	}

	private JLabel getLabel_32() {
		if (label_32 == null) {
			label_32 = new JLabel("");
			label_32.setHorizontalAlignment(SwingConstants.CENTER);
			label_32.setBackground(new Color(50, 205, 50));
			label_32.setOpaque(true);
			label_32.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_32.setBounds(30, 60, 30, 60);
			squares[32] = lbl_32;
		}
		return label_32;
	}

	private JLabel getLabel_33() {
		if (label_33 == null) {
			label_33 = new JLabel("");
			label_33.setHorizontalAlignment(SwingConstants.CENTER);
			label_33.setBackground(new Color(50, 205, 50));
			label_33.setOpaque(true);
			label_33.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_33.setBounds(60, 60, 30, 60);
			squares[33] = lbl_33;
		}
		return label_33;
	}

	private JLabel getLabel_34() {
		if (label_34 == null) {
			label_34 = new JLabel("");
			label_34.setHorizontalAlignment(SwingConstants.CENTER);
			label_34.setBackground(new Color(50, 205, 50));
			label_34.setOpaque(true);
			label_34.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_34.setBounds(90, 60, 30, 60);
			squares[34] = lbl_34;
		}
		return label_34;
	}

	private JLabel getLabel_35() {
		if (label_35 == null) {
			label_35 = new JLabel("");
			label_35.setHorizontalAlignment(SwingConstants.CENTER);
			label_35.setBackground(new Color(50, 205, 50));
			label_35.setOpaque(true);
			label_35.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_35.setBounds(120, 60, 30, 60);
			squares[35] = lbl_35;
		}
		return label_35;
	}

	private JLabel getLabel_36() {
		if (label_36 == null) {
			label_36 = new JLabel("");
			label_36.setHorizontalAlignment(SwingConstants.CENTER);
			label_36.setBackground(new Color(50, 205, 50));
			label_36.setOpaque(true);
			label_36.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_36.setBounds(150, 60, 30, 60);
			squares[36] = lbl_36;
		}
		return label_36;
	}

	private JLabel getLabel_37() {
		if (label_37 == null) {
			label_37 = new JLabel("");
			label_37.setHorizontalAlignment(SwingConstants.CENTER);
			label_37.setBackground(new Color(50, 205, 50));
			label_37.setOpaque(true);
			label_37.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_37.setBounds(180, 60, 30, 60);
			squares[37] = lbl_37;
		}
		return label_37;
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
			pnlRedSide.add(getLabel_50());
			pnlRedSide.add(getLbl_36());
			pnlRedSide.add(getLbl_30());
			pnlRedSide.add(getLabel_53());
			pnlRedSide.add(getLbl_38());
			pnlRedSide.add(getLbl_37());
			pnlRedSide.add(getLabel_56());
			pnlRedSide.add(getLbl_31());
			pnlRedSide.add(getLbl_26());
			pnlRedSide.add(getLbl_27());
			pnlRedSide.add(getLbl_28());
			pnlRedSide.add(getLbl_29());
			pnlRedSide.add(getLabel_62());
			pnlRedSide.add(getLabel_63());
			pnlRedSide.add(getLabel_64());
			pnlRedSide.add(getLabel_65());
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
			lbl_35.setHorizontalAlignment(SwingConstants.LEFT);
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

	private JLabel getLabel_50() {
		if (label_50 == null) {
			label_50 = new JLabel("");
			label_50.setHorizontalAlignment(SwingConstants.CENTER);
			label_50.setBackground(new Color(255, 0, 0));
			label_50.setOpaque(true);
			label_50.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_50.setBounds(60, 180, 60, 30);
			squares[50] = lbl_50;
		}
		return label_50;
	}

	private JLabel getLbl_36() {
		if (lbl_36 == null) {
			lbl_36 = new JLabel("36");
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
			lbl_36.setHorizontalAlignment(SwingConstants.LEFT);
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

	private JLabel getLabel_53() {
		if (label_53 == null) {
			label_53 = new JLabel("");
			label_53.setHorizontalAlignment(SwingConstants.CENTER);
			label_53.setBackground(new Color(255, 0, 0));
			label_53.setOpaque(true);
			label_53.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_53.setBounds(60, 120, 60, 30);
			squares[53] = lbl_53;
		}
		return label_53;
	}

	private JLabel getLbl_38() {
		if (lbl_38 == null) {
			lbl_38 = new JLabel("38");
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
			lbl_38.setHorizontalAlignment(SwingConstants.LEFT);
			lbl_38.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_38.setBounds(120, 120, 60, 30);
			squares[38] = lbl_38;
		}
		return lbl_38;
	}

	private JLabel getLbl_37() {
		if (lbl_37 == null) {
			lbl_37 = new JLabel("37");
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
			lbl_37.setHorizontalAlignment(SwingConstants.LEFT);
			lbl_37.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_37.setBounds(120, 150, 60, 30);
			squares[37] = lbl_37;
		}
		return lbl_37;
	}

	private JLabel getLabel_56() {
		if (label_56 == null) {
			label_56 = new JLabel("");
			label_56.setHorizontalAlignment(SwingConstants.CENTER);
			label_56.setBackground(new Color(255, 0, 0));
			label_56.setOpaque(true);
			label_56.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_56.setBounds(60, 150, 60, 30);
			squares[56] = lbl_56;
		}
		return label_56;
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

	private JLabel getLabel_62() {
		if (label_62 == null) {
			label_62 = new JLabel("");
			label_62.setHorizontalAlignment(SwingConstants.CENTER);
			label_62.setBackground(new Color(255, 0, 0));
			label_62.setOpaque(true);
			label_62.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_62.setBounds(60, 90, 60, 30);
			squares[62] = lbl_62;
		}
		return label_62;
	}

	private JLabel getLabel_63() {
		if (label_63 == null) {
			label_63 = new JLabel("");
			label_63.setHorizontalAlignment(SwingConstants.CENTER);
			label_63.setBackground(new Color(255, 0, 0));
			label_63.setOpaque(true);
			label_63.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_63.setBounds(60, 60, 60, 30);
			squares[63] = lbl_63;
		}
		return label_63;
	}

	private JLabel getLabel_64() {
		if (label_64 == null) {
			label_64 = new JLabel("");
			label_64.setHorizontalAlignment(SwingConstants.CENTER);
			label_64.setBackground(new Color(255, 0, 0));
			label_64.setOpaque(true);
			label_64.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_64.setBounds(60, 30, 60, 30);
			squares[64] = lbl_64;
		}
		return label_64;
	}

	private JLabel getLabel_65() {
		if (label_65 == null) {
			label_65 = new JLabel("");
			label_65.setHorizontalAlignment(SwingConstants.CENTER);
			label_65.setBackground(new Color(255, 0, 0));
			label_65.setOpaque(true);
			label_65.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_65.setBounds(60, 0, 60, 30);
			squares[65] = lbl_65;
		}
		return label_65;
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
			lbl_41.setHorizontalAlignment(SwingConstants.LEFT);
			lbl_41.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_41.setBounds(120, 30, 60, 30);
			squares[41] = lbl_41;
		}
		return lbl_41;
	}

	private JLabel getLbl_40() {
		if (lbl_40 == null) {
			lbl_40 = new JLabel("40");
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
			lbl_40.setHorizontalAlignment(SwingConstants.LEFT);
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
			pnlYellowSide.add(getLabel_71());
			pnlYellowSide.add(getLbl_60());
			pnlYellowSide.add(getLbl_7());
			pnlYellowSide.add(getLabel_74());
			pnlYellowSide.add(getLbl_61());
			pnlYellowSide.add(getLbl_5());
			pnlYellowSide.add(getLabel_77());
			pnlYellowSide.add(getLbl_63());
			pnlYellowSide.add(getLbl_62());
			pnlYellowSide.add(getLabel_80());
			pnlYellowSide.add(getLbl_6());
			pnlYellowSide.add(getLbl_1());
			pnlYellowSide.add(getLbl_2());
			pnlYellowSide.add(getLbl_3());
			pnlYellowSide.add(getLbl_4());
			pnlYellowSide.add(getLabel_86());
			pnlYellowSide.add(getLabel_87());
			pnlYellowSide.add(getLabel_88());
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

	private JLabel getLabel_71() {
		if (label_71 == null) {
			label_71 = new JLabel("");
			label_71.setHorizontalAlignment(SwingConstants.CENTER);
			label_71.setBackground(new Color(255, 255, 0));
			label_71.setOpaque(true);
			label_71.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_71.setBounds(60, 210, 60, 30);
		}
		return label_71;
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

	private JLabel getLabel_74() {
		if (label_74 == null) {
			label_74 = new JLabel("");
			label_74.setHorizontalAlignment(SwingConstants.CENTER);
			label_74.setOpaque(true);
			label_74.setBackground(new Color(255, 255, 0));
			label_74.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_74.setBounds(60, 180, 60, 30);
		}
		return label_74;
	}

	private JLabel getLbl_61() {
		if (lbl_61 == null) {
			lbl_61 = new JLabel("61");
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
			lbl_61.setHorizontalAlignment(SwingConstants.LEFT);
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

	private JLabel getLabel_77() {
		if (label_77 == null) {
			label_77 = new JLabel("");
			label_77.setHorizontalAlignment(SwingConstants.CENTER);
			label_77.setOpaque(true);
			label_77.setBackground(new Color(255, 255, 0));
			label_77.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_77.setBounds(60, 120, 60, 30);
		}
		return label_77;
	}

	private JLabel getLbl_63() {
		if (lbl_63 == null) {
			lbl_63 = new JLabel("63");
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
			lbl_63.setHorizontalAlignment(SwingConstants.LEFT);
			lbl_63.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_63.setBounds(120, 120, 60, 30);
			squares[63] = lbl_63;
		}
		return lbl_63;
	}

	private JLabel getLbl_62() {
		if (lbl_62 == null) {
			lbl_62 = new JLabel("62");
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
			lbl_62.setHorizontalAlignment(SwingConstants.LEFT);
			lbl_62.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_62.setBounds(120, 150, 60, 30);
			squares[62] = lbl_62;
		}
		return lbl_62;
	}

	private JLabel getLabel_80() {
		if (label_80 == null) {
			label_80 = new JLabel("");
			label_80.setHorizontalAlignment(SwingConstants.CENTER);
			label_80.setOpaque(true);
			label_80.setBackground(new Color(255, 255, 0));
			label_80.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_80.setBounds(60, 150, 60, 30);
		}
		return label_80;
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
			lbl_6.setHorizontalTextPosition(SwingConstants.CENTER);
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

	private JLabel getLabel_86() {
		if (label_86 == null) {
			label_86 = new JLabel("");
			label_86.setHorizontalAlignment(SwingConstants.CENTER);
			label_86.setOpaque(true);
			label_86.setBackground(new Color(255, 255, 0));
			label_86.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_86.setBounds(60, 90, 60, 30);
		}
		return label_86;
	}

	private JLabel getLabel_87() {
		if (label_87 == null) {
			label_87 = new JLabel("");
			label_87.setHorizontalAlignment(SwingConstants.CENTER);
			label_87.setOpaque(true);
			label_87.setBackground(new Color(255, 255, 0));
			label_87.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_87.setBounds(60, 60, 60, 30);
		}
		return label_87;
	}

	private JLabel getLabel_88() {
		if (label_88 == null) {
			label_88 = new JLabel("");
			label_88.setHorizontalAlignment(SwingConstants.CENTER);
			label_88.setOpaque(true);
			label_88.setBackground(new Color(255, 255, 0));
			label_88.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_88.setBounds(60, 30, 60, 30);
		}
		return label_88;
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
			lbl_67.setHorizontalAlignment(SwingConstants.LEFT);
			lbl_67.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_67.setBounds(120, 0, 60, 30);
			squares[67] = lbl_67;
		}
		return lbl_67;
	}

	private JLabel getLbl_66() {
		if (lbl_66 == null) {
			lbl_66 = new JLabel("66");
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
			lbl_66.setHorizontalAlignment(SwingConstants.LEFT);
			lbl_66.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_66.setBounds(120, 30, 60, 30);
			squares[66] = lbl_66;
		}
		return lbl_66;
	}

	private JLabel getLbl_65() {
		if (lbl_65 == null) {
			lbl_65 = new JLabel("65");
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
			lbl_65.setHorizontalAlignment(SwingConstants.LEFT);
			lbl_65.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_65.setBounds(120, 60, 60, 30);
			squares[65] = lbl_65;
		}
		return lbl_65;
	}

	private JLabel getLbl_64() {
		if (lbl_64 == null) {
			lbl_64 = new JLabel("64");
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
			lbl_64.setHorizontalAlignment(SwingConstants.LEFT);
			lbl_64.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_64.setBounds(120, 90, 60, 30);
			squares[64] = lbl_64;
		}
		return lbl_64;
	}

	private JLabel getLblYellowPlayerAvatar() {
		if (lblYellowPlayerAvatar == null) {
			lblYellowPlayerAvatar = new JLabel("");
			lblYellowPlayerAvatar.setBorder(new BevelBorder(
					BevelBorder.LOWERED, null, null, null, null));
			lblYellowPlayerAvatar.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Avatars/2.jpg")));
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
			lblGreenPlayerAvatar.setBorder(new BevelBorder(BevelBorder.LOWERED,
					null, null, null, null));
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
			lblBluePlayerAvatar.setBorder(new BevelBorder(BevelBorder.LOWERED,
					null, null, null, null));
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

	private JButton getButton() {
		if (button == null) {
			button = new JButton();
			button.setText("Quit");
			button.setBounds(538, 788, 86, 23);
		}
		return button;
	}

	private JTextField getTxtMessage() {
		if (txtMessage == null) {
			txtMessage = new JTextField();
			txtMessage.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent arg0) {
					txtMessageKeyPressed(arg0);
				}
			});
			txtMessage.setText((String) null);
			txtMessage.setBounds(10, 791, 493, 20);
		}
		return txtMessage;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 655, 493, 128);
			scrollPane.setViewportView(getTxtChat());
		}
		return scrollPane;
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

	private JLabel getLblState() {
		if (lblState == null) {
			lblState = new JLabel();
			lblState.setFont(new Font("Tahoma", Font.BOLD, 11));
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

	protected void txtMessageKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == 10 && txtMessage.getText().length() > 0)
			sendMessage();
	}

	protected void lblYellowDiceMouseClicked(MouseEvent evt) {
		if (yellowDice) {
			throwDice();
			disableDices();
			/*
			 * new Thread() { public void run() { for (int i = 1; i < 68; i++) {
			 * if (i != 1) { squares[i - 1].setIcon(null); squares[i -
			 * 1].setText(String.valueOf(i - 1)); } squares[i] .setIcon(new
			 * ImageIcon( LudoUI.class
			 * .getResource("/images/Ludo/Pieces/yellow_1.png")));
			 * squares[i].setText(null); try { sleep(500); } catch
			 * (InterruptedException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } } } }.start();
			 */
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

	private void setHandCursor() {
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	private void setDefaultCursor() {
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void updateBoard(int nextTurn) {
		for (int player = 0; player < 4; player++) {
			switch (player) {
			case Ludo.YELLOW:
				for (int piece = 0; piece < 4; piece++) {
					if (game.getBoard()[player][piece] != 0) {
						pnlYellowPlayer.remove(yellowPieces[piece]);
					}
				}
				pnlYellowPlayer.repaint();

				break;
			case Ludo.RED:
				for (int piece = 0; piece < 4; piece++) {
					if (game.getBoard()[player][piece] != 0) {
						pnlRedPlayer.remove(redPieces[piece]);
					}
				}
				pnlRedPlayer.repaint();
				break;
			case Ludo.BLUE:
				for (int piece = 0; piece < 4; piece++) {
					if (game.getBoard()[player][piece] != 0) {
						pnlBluePlayer.remove(bluePieces[piece]);
					}
				}
				pnlBluePlayer.repaint();
				break;
			case Ludo.GREEN:
				for (int piece = 0; piece < 4; piece++) {
					if (game.getBoard()[player][piece] != 0) {
						pnlGreenPlayer.remove(greenPieces[piece]);
					}
				}
				pnlGreenPlayer.repaint();
				break;
			}
		}

		game.setTurn(nextTurn);
		playerTurn = nextTurn;

		if (myPlayer == playerTurn) {
			lblState.setText("Es tu turno, lanza el dado");
			enableDice(playerTurn);
		}
	}

	@Override
	public void lostGame() {
		// TODO Auto-generated method stub

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
	public void userLeaveGame(String player) {
		// TODO Auto-generated method stub

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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				// Take out a piece
				if (dice == 5) {
					int piece = Ludo.canBringPieceToStartingSquare(
							game.getBoard(), myPlayer);
					if (piece != -1) {
						Ludo.takeOutPiece(game.getBoard(), piece, playerTurn);
						switch (playerTurn) {
						case Ludo.YELLOW:
							squares[Ludo.YELLOW_INITIAL_SQUARE]
									.setIcon(new ImageIcon(
											LudoUI.class
													.getResource("/images/Ludo/Pieces/yellow_1.png")));
							pnlYellowPlayer.remove(yellowPieces[piece]);
							pnlYellowPlayer.repaint();
							break;
						case Ludo.RED:
							squares[Ludo.RED_INITIAL_SQUARE]
									.setIcon(new ImageIcon(
											LudoUI.class
													.getResource("/images/Ludo/Pieces/red_1.png")));
							pnlRedPlayer.remove(redPieces[piece]);
							pnlRedPlayer.repaint();
							break;
						case Ludo.BLUE:
							squares[Ludo.BLUE_INITIAL_SQUARE]
									.setIcon(new ImageIcon(
											LudoUI.class
													.getResource("/images/Ludo/Pieces/blue_1.png")));
							pnlBluePlayer.remove(bluePieces[piece]);
							pnlBluePlayer.repaint();
							break;
						case Ludo.GREEN:
							squares[Ludo.GREEN_INITIAL_SQUARE]
									.setIcon(new ImageIcon(
											LudoUI.class
													.getResource("/images/Ludo/Pieces/green_1.png")));
							pnlGreenPlayer.remove(greenPieces[piece]);
							pnlGreenPlayer.repaint();
							break;
						}

						changeTurn();
						Controller.getInstance().updateGame(game.getName());
					} else {
						// Move piece
						if (Ludo.isPieceOut(game.getBoard(), myPlayer)) {
							lblState.setText("Elige la ficha que quieras mover");
						} else {
							changeTurn();
							Controller.getInstance().updateGame(game.getName());
						}

					}
				} else {
					// Move piece
					if (Ludo.isPieceOut(game.getBoard(), myPlayer)) {
						lblState.setText("Elige la ficha que quieras mover");
						enablePlayerSquares(myPlayer);
					} else {
						changeTurn();
						Controller.getInstance().updateGame(game.getName());
					}
				}

			}

		}.start();
	}

	private void move(int fromSquare) {
		int piece = Ludo.pieceInSquare(game.getBoard(), fromSquare, myPlayer);
		Ludo.move(piece, dice, game.getBoard(), myPlayer);
		moveAnimation(fromSquare);
	}

	private void moveAnimation(final int fromSquare) {
		disableSquare(fromSquare);

		new Thread() {
			public void run() {
				int toSquare = fromSquare + dice;
				ImageIcon icon = null;

				switch (playerTurn) {
				case Ludo.YELLOW:
					icon = new ImageIcon(
							LudoUI.class
									.getResource("/images/Ludo/Pieces/yellow_1.png"));
					break;
				case Ludo.RED:
					icon = new ImageIcon(
							LudoUI.class
									.getResource("/images/Ludo/Pieces/red_1.png"));
					break;
				case Ludo.BLUE:
					icon = new ImageIcon(
							LudoUI.class
									.getResource("/images/Ludo/Pieces/blue_1.png"));
					break;
				case Ludo.GREEN:
					icon = new ImageIcon(
							LudoUI.class
									.getResource("/images/Ludo/Pieces/green_1.png"));
					break;
				}

				for (int from = fromSquare + 1; from <= toSquare; from++) {
					squares[from - 1].setIcon(null);
					squares[from - 1].repaint();
					squares[from].setIcon(icon);
					squares[from].repaint();

					try {
						sleep(Constants.LudoPieceMoveTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				playerTurn = game.changeTurn();
				Controller.getInstance().updateGame(game.getName());
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
			}
		}.start();

	}

	private void disableSquare(int square) {
		enabledSquares[square] = false;
		setDefaultCursor();

	}

	private void enablePlayerSquares(int player) {
		int[] piecesSquares = game.getBoard(player);
		for (int piece = 0; piece < 4; piece++) {
			int pieceSquare = piecesSquares[piece];
			if (pieceSquare != Ludo.HOUSE) {
				enabledSquares[pieceSquare] = true;
			}
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

}
