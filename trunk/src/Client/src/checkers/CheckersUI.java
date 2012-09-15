package checkers;

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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import logic.Controller;
import model.Game;
import model.User;
import presentation.IGame;
import ProductLine.Slot;
import ProductLine.SlotState;
import ProductLine.UserNotInGameException;
import constants.Constants;
import presentation.JPanelRound;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class CheckersUI extends javax.swing.JFrame implements IGame {

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
	private JLabel lbl_71;
	private JLabel lbl_72;
	private JLabel lbl_73;
	private JLabel lbl_74;
	private JLabel lbl_75;
	private JLabel lbl_76;
	private JLabel lbl_77;
	private JLabel lbl_70;
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
	private JPanelRound pnlBackground;
	private JLabel lblState;
	private Thread timerThread;

	private static final Border blackBorder = new LineBorder(
			new java.awt.Color(0, 0, 0), 1, false);
	private static final Border redBorder = new LineBorder(new java.awt.Color(
			255, 0, 0), 4, false);
	private static final Border greenBorder = new LineBorder(
			new java.awt.Color(0, 255, 0), 4, false);
	private static final Border blueBorder = new LineBorder(new java.awt.Color(
			0, 0, 255), 4, false);

	private JLabel[][] boardUI;
	private Game game;
	private int myPlayer;
	private int playerTurn;
	private List<CheckersMove> moves;
	private int selectedRow;
	private int selectedColumn;
	private boolean activeSquares;
	private boolean computer;
	private boolean turnPassed;
	private Minimax minimax;
	private JLabel lblTimer;
	private JLabel lblLblturn;

	public CheckersUI(String username, Game game) {
		super();
		setTitle("Damas");
		setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(
						CheckersUI.class
								.getResource("/images/Games/checkers_icon.png")));
		this.username = username;
		this.game = game;
		destinatary = "";
		boardUI = new JLabel[8][8];
		minimax = new Minimax(6);

		playerTurn = Checkers.RED;
		Slot opponentSlot = game.getSlot(0);

		myPlayer = Checkers.BLACK;

		if (opponentSlot.getPlayer().equalsIgnoreCase(username)) {
			opponentSlot = game.getSlot(1);
			myPlayer = Checkers.RED;
		}

		if (opponentSlot.getType() == SlotState.Human)
			computer = false;
		else
			computer = true;

		initGUI();
		selectedRow = -1;

		if (computer) {
			lblOpponentAvatar.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/computer.png")));
			lblOpponentName.setText("Computer");
			lblState.setText("Es tu turno");
			activeSquares = true;
			pnlBackground.remove(lblTimer);

		} else {
			User opponent = Controller.getInstance().searchUser(
					opponentSlot.getPlayer());

			if (opponent.getAvatar().length == 0) {
				lblOpponentAvatar.setIcon(new ImageIcon(CheckersUI.class
						.getResource("/images/no_avatar_icon.png")));
			} else {
				lblOpponentAvatar.setIcon(new ImageIcon(opponent.getAvatar()));
			}

			lblOpponentName.setText(opponent.getUsername());

			if (playerTurn == myPlayer) {
				moves = Checkers.legalMoves(game.getBoard(), myPlayer);
				resaltarMovimientos();
				activeSquares = true;
				lblState.setText("Es tu turno");
				startTimer();
			} else {
				lblState.setText("Es el turno de " + opponent.getName());
				activeSquares = false;
			}
		}

		refreshBoard();

	}

	private void initGUI() {
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
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

	private JPanelRound getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanelRound();
			pnlBackground.setArch(0);
			pnlBackground.setArcw(0);
			pnlBackground.setLayout(null);
			pnlBackground.setBounds(0, 0, 644, 694);
			pnlBackground.add(getLblOpponentAvatar());
			pnlBackground.add(getPnlBoard());
			pnlBackground.add(getBtnQuit());
			pnlBackground.add(getTxtMessage());
			pnlBackground.add(getPnlChat());
			pnlBackground.add(getLblOpponentName());
			pnlBackground.add(getLblState());
			pnlBackground.add(getLblTimer());
			pnlBackground.add(getLblLblturn());
		}
		return pnlBackground;
	}

	private JLabel getLblOpponentAvatar() {
		if (lblOpponentAvatar == null) {
			lblOpponentAvatar = new JLabel();
			lblOpponentAvatar.setHorizontalAlignment(SwingConstants.CENTER);
			lblOpponentAvatar.setBounds(522, 11, 101, 124);
			lblOpponentAvatar.setBorder(new SoftBevelBorder(
					BevelBorder.LOWERED, null, null, null, null));
		}
		return lblOpponentAvatar;
	}

	private JPanel getPnlBoard() {
		if (pnlBoard == null) {
			pnlBoard = new JPanel();
			pnlBoard.setBackground(Color.BLACK);
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
			pnlBoard.add(getLbl_70());
			pnlBoard.add(getLbl_77());
			pnlBoard.add(getLbl_76());
			pnlBoard.add(getLbl_75());
			pnlBoard.add(getLbl_74());
			pnlBoard.add(getLbl_73());
			pnlBoard.add(getLbl_72());
			pnlBoard.add(getLbl_71());
		}
		return pnlBoard;
	}

	private JLabel getLbl_00() {
		if (lbl_00 == null) {
			lbl_00 = new JLabel();
			lbl_00.setBounds(7, 7, 60, 60);
			lbl_00.setBackground(Color.BLACK);
			lbl_00.setOpaque(true);
			lbl_00.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_00.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_00.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_00MouseClicked(evt);
				}
			});
			boardUI[0][0] = lbl_00;
		}
		return lbl_00;
	}

	private JLabel getLbl_01() {
		if (lbl_01 == null) {
			lbl_01 = new JLabel();
			lbl_01.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_01.setBounds(67, 7, 60, 60);
			lbl_01.setOpaque(true);
			lbl_01.setBackground(Color.WHITE);
			lbl_01.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_01.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_01MouseClicked(evt);
				}
			});
			boardUI[0][1] = lbl_01;
		}
		return lbl_01;
	}

	private JLabel getLbl_02() {
		if (lbl_02 == null) {
			lbl_02 = new JLabel();
			lbl_02.setOpaque(true);
			lbl_02.setBackground(Color.BLACK);
			lbl_02.setBounds(127, 7, 60, 60);
			lbl_02.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_02.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_02.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_02MouseClicked(evt);
				}
			});
			boardUI[0][2] = lbl_02;
		}
		return lbl_02;
	}

	private JLabel getLbl_03() {
		if (lbl_03 == null) {
			lbl_03 = new JLabel();
			lbl_03.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_03.setOpaque(true);
			lbl_03.setBackground(Color.WHITE);
			lbl_03.setBounds(187, 7, 60, 60);
			lbl_03.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_03.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_03MouseClicked(evt);
				}
			});
			boardUI[0][3] = lbl_03;
		}
		return lbl_03;
	}

	private JLabel getLbl_04() {
		if (lbl_04 == null) {
			lbl_04 = new JLabel();
			lbl_04.setOpaque(true);
			lbl_04.setBackground(Color.BLACK);
			lbl_04.setBounds(247, 7, 60, 60);
			lbl_04.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_04.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_04.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_04MouseClicked(evt);
				}
			});
			boardUI[0][4] = lbl_04;
		}
		return lbl_04;
	}

	private JLabel getLbl_05() {
		if (lbl_05 == null) {
			lbl_05 = new JLabel();
			lbl_05.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_05.setOpaque(true);
			lbl_05.setBackground(Color.WHITE);
			lbl_05.setBounds(307, 7, 60, 60);
			lbl_05.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_05.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_05MouseClicked(evt);
				}
			});
			boardUI[0][5] = lbl_05;
		}
		return lbl_05;
	}

	private JLabel getLbl_06() {
		if (lbl_06 == null) {
			lbl_06 = new JLabel();
			lbl_06.setOpaque(true);
			lbl_06.setBackground(Color.BLACK);
			lbl_06.setBounds(367, 7, 60, 60);
			lbl_06.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_06.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_06.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_06MouseClicked(evt);
				}
			});
			boardUI[0][6] = lbl_06;
		}
		return lbl_06;
	}

	private JLabel getLbl_07() {
		if (lbl_07 == null) {
			lbl_07 = new JLabel();
			lbl_07.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_07.setBounds(427, 7, 60, 60);
			lbl_07.setBackground(Color.WHITE);
			lbl_07.setOpaque(true);
			lbl_07.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_07.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_07MouseClicked(evt);
				}
			});
			boardUI[0][7] = lbl_07;
		}
		return lbl_07;
	}

	private JLabel getLbl_17() {
		if (lbl_17 == null) {
			lbl_17 = new JLabel();
			lbl_17.setOpaque(true);
			lbl_17.setBackground(Color.BLACK);
			lbl_17.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_17.setBounds(427, 67, 60, 60);
			lbl_17.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_17.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_17MouseClicked(evt);
				}
			});
			boardUI[1][7] = lbl_17;
		}
		return lbl_17;
	}

	private JLabel getLbl_16() {
		if (lbl_16 == null) {
			lbl_16 = new JLabel();
			lbl_16.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_16.setOpaque(true);
			lbl_16.setBackground(Color.WHITE);
			lbl_16.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_16.setBounds(367, 67, 60, 60);
			lbl_16.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_16MouseClicked(evt);
				}
			});
			boardUI[1][6] = lbl_16;
		}
		return lbl_16;
	}

	private JLabel getLbl_15() {
		if (lbl_15 == null) {
			lbl_15 = new JLabel();
			lbl_15.setOpaque(true);
			lbl_15.setBackground(Color.BLACK);
			lbl_15.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_15.setBounds(307, 67, 60, 60);
			lbl_15.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_15.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_15MouseClicked(evt);
				}
			});
			boardUI[1][5] = lbl_15;
		}
		return lbl_15;
	}

	private JLabel getLbl_14() {
		if (lbl_14 == null) {
			lbl_14 = new JLabel();
			lbl_14.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_14.setOpaque(true);
			lbl_14.setBackground(Color.WHITE);
			lbl_14.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_14.setBounds(247, 67, 60, 60);
			lbl_14.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_14MouseClicked(evt);
				}
			});
			boardUI[1][4] = lbl_14;
		}
		return lbl_14;
	}

	private JLabel getLbl_13() {
		if (lbl_13 == null) {
			lbl_13 = new JLabel();
			lbl_13.setOpaque(true);
			lbl_13.setBackground(Color.BLACK);
			lbl_13.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_13.setBounds(187, 67, 60, 60);
			lbl_13.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_13.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_13MouseClicked(evt);
				}
			});
			boardUI[1][3] = lbl_13;
		}
		return lbl_13;
	}

	private JLabel getLbl_12() {
		if (lbl_12 == null) {
			lbl_12 = new JLabel();
			lbl_12.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_12.setOpaque(true);
			lbl_12.setBackground(Color.WHITE);
			lbl_12.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_12.setBounds(127, 67, 60, 60);
			lbl_12.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_12MouseClicked(evt);
				}
			});
			boardUI[1][2] = lbl_12;
		}
		return lbl_12;
	}

	private JLabel getLbl_11() {
		if (lbl_11 == null) {
			lbl_11 = new JLabel();
			lbl_11.setOpaque(true);
			lbl_11.setBackground(Color.BLACK);
			lbl_11.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_11.setBounds(67, 67, 60, 60);
			lbl_11.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_11.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_11MouseClicked(evt);
				}
			});
			boardUI[1][1] = lbl_11;
		}
		return lbl_11;
	}

	private JLabel getLbl_10() {
		if (lbl_10 == null) {
			lbl_10 = new JLabel();
			lbl_10.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_10.setOpaque(true);
			lbl_10.setBackground(Color.WHITE);
			lbl_10.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_10.setBounds(7, 67, 60, 60);
			lbl_10.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_10MouseClicked(evt);
				}
			});
			boardUI[1][0] = lbl_10;
		}
		return lbl_10;
	}

	private JLabel getLbl_27() {
		if (lbl_27 == null) {
			lbl_27 = new JLabel();
			lbl_27.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_27.setOpaque(true);
			lbl_27.setBackground(Color.WHITE);
			lbl_27.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_27.setBounds(427, 127, 60, 60);
			lbl_27.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_27MouseClicked(evt);
				}
			});
			boardUI[2][7] = lbl_27;
		}
		return lbl_27;
	}

	private JLabel getLbl_26() {
		if (lbl_26 == null) {
			lbl_26 = new JLabel();
			lbl_26.setOpaque(true);
			lbl_26.setBackground(Color.BLACK);
			lbl_26.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_26.setBounds(367, 127, 60, 60);
			lbl_26.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_26.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_26MouseClicked(evt);
				}
			});
			boardUI[2][6] = lbl_26;
		}
		return lbl_26;
	}

	private JLabel getLbl_25() {
		if (lbl_25 == null) {
			lbl_25 = new JLabel();
			lbl_25.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_25.setOpaque(true);
			lbl_25.setBackground(Color.WHITE);
			lbl_25.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_25.setBounds(307, 127, 60, 60);
			lbl_25.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_25MouseClicked(evt);
				}
			});
			boardUI[2][5] = lbl_25;
		}
		return lbl_25;
	}

	private JLabel getLbl_24() {
		if (lbl_24 == null) {
			lbl_24 = new JLabel();
			lbl_24.setOpaque(true);
			lbl_24.setBackground(Color.BLACK);
			lbl_24.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_24.setBounds(247, 127, 60, 60);
			lbl_24.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_24.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_24MouseClicked(evt);
				}
			});
			boardUI[2][4] = lbl_24;
		}
		return lbl_24;
	}

	private JLabel getLbl_23() {
		if (lbl_23 == null) {
			lbl_23 = new JLabel();
			lbl_23.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_23.setOpaque(true);
			lbl_23.setBackground(Color.WHITE);
			lbl_23.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_23.setBounds(187, 127, 60, 60);
			lbl_23.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_23MouseClicked(evt);
				}
			});
			boardUI[2][3] = lbl_23;
		}
		return lbl_23;
	}

	private JLabel getLbl_22() {
		if (lbl_22 == null) {
			lbl_22 = new JLabel();
			lbl_22.setOpaque(true);
			lbl_22.setBackground(Color.BLACK);
			lbl_22.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_22.setBounds(127, 127, 60, 60);
			lbl_22.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_22.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_22MouseClicked(evt);
				}
			});
			boardUI[2][2] = lbl_22;
		}
		return lbl_22;
	}

	private JLabel getLbl_21() {
		if (lbl_21 == null) {
			lbl_21 = new JLabel();
			lbl_21.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_21.setOpaque(true);
			lbl_21.setBackground(Color.WHITE);
			lbl_21.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_21.setBounds(67, 127, 60, 60);
			lbl_21.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_21MouseClicked(evt);
				}
			});
			boardUI[2][1] = lbl_21;
		}
		return lbl_21;
	}

	private JLabel getLbl_20() {
		if (lbl_20 == null) {
			lbl_20 = new JLabel();
			lbl_20.setOpaque(true);
			lbl_20.setBackground(Color.BLACK);
			lbl_20.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_20.setBounds(7, 127, 60, 60);
			lbl_20.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_20.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_20MouseClicked(evt);
				}
			});
			boardUI[2][0] = lbl_20;
		}
		return lbl_20;
	}

	private JLabel getLbl_37() {
		if (lbl_37 == null) {
			lbl_37 = new JLabel();
			lbl_37.setOpaque(true);
			lbl_37.setBackground(Color.BLACK);
			lbl_37.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_37.setBounds(427, 186, 60, 60);
			lbl_37.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_37.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_37MouseClicked(evt);
				}
			});
			boardUI[3][7] = lbl_37;
		}
		return lbl_37;
	}

	private JLabel getLbl_36() {
		if (lbl_36 == null) {
			lbl_36 = new JLabel();
			lbl_36.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_36.setOpaque(true);
			lbl_36.setBackground(Color.WHITE);
			lbl_36.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_36.setBounds(367, 186, 60, 60);
			lbl_36.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_36MouseClicked(evt);
				}
			});
			boardUI[3][6] = lbl_36;
		}
		return lbl_36;
	}

	private JLabel getLbl_35() {
		if (lbl_35 == null) {
			lbl_35 = new JLabel();
			lbl_35.setOpaque(true);
			lbl_35.setBackground(Color.BLACK);
			lbl_35.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_35.setBounds(307, 186, 60, 60);
			lbl_35.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_35.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_35MouseClicked(evt);
				}
			});
			boardUI[3][5] = lbl_35;
		}
		return lbl_35;
	}

	private JLabel getLbl_34() {
		if (lbl_34 == null) {
			lbl_34 = new JLabel();
			lbl_34.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_34.setOpaque(true);
			lbl_34.setBackground(Color.WHITE);
			lbl_34.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_34.setBounds(247, 186, 60, 60);
			lbl_34.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_34MouseClicked(evt);
				}
			});
			boardUI[3][4] = lbl_34;
		}
		return lbl_34;
	}

	private JLabel getLbl_33() {
		if (lbl_33 == null) {
			lbl_33 = new JLabel();
			lbl_33.setOpaque(true);
			lbl_33.setBackground(Color.BLACK);
			lbl_33.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_33.setBounds(187, 186, 60, 60);
			lbl_33.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_33.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_33MouseClicked(evt);
				}
			});
			boardUI[3][3] = lbl_33;
		}
		return lbl_33;
	}

	private JLabel getLbl_32() {
		if (lbl_32 == null) {
			lbl_32 = new JLabel();
			lbl_32.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_32.setOpaque(true);
			lbl_32.setBackground(Color.WHITE);
			lbl_32.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_32.setBounds(127, 186, 60, 60);
			lbl_32.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_32MouseClicked(evt);
				}
			});
			boardUI[3][2] = lbl_32;
		}
		return lbl_32;
	}

	private JLabel getLbl_31() {
		if (lbl_31 == null) {
			lbl_31 = new JLabel();
			lbl_31.setOpaque(true);
			lbl_31.setBackground(Color.BLACK);
			lbl_31.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_31.setBounds(67, 186, 60, 60);
			lbl_31.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_31.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_31MouseClicked(evt);
				}
			});
			boardUI[3][1] = lbl_31;
		}
		return lbl_31;
	}

	private JLabel getLbl_30() {
		if (lbl_30 == null) {
			lbl_30 = new JLabel();
			lbl_30.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_30.setOpaque(true);
			lbl_30.setBackground(Color.WHITE);
			lbl_30.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_30.setBounds(7, 186, 60, 60);
			lbl_30.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_30MouseClicked(evt);
				}
			});
			boardUI[3][0] = lbl_30;
		}
		return lbl_30;
	}

	private JLabel getLbl_47() {
		if (lbl_47 == null) {
			lbl_47 = new JLabel();
			lbl_47.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_47.setOpaque(true);
			lbl_47.setBackground(Color.WHITE);
			lbl_47.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_47.setBounds(427, 246, 60, 60);
			lbl_47.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_47MouseClicked(evt);
				}
			});
			boardUI[4][7] = lbl_47;
		}
		return lbl_47;
	}

	private JLabel getLbl_46() {
		if (lbl_46 == null) {
			lbl_46 = new JLabel();
			lbl_46.setOpaque(true);
			lbl_46.setBackground(Color.BLACK);
			lbl_46.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_46.setBounds(367, 246, 60, 60);
			lbl_46.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_46.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_46MouseClicked(evt);
				}
			});
			boardUI[4][6] = lbl_46;
		}
		return lbl_46;
	}

	private JLabel getLbl_45() {
		if (lbl_45 == null) {
			lbl_45 = new JLabel();
			lbl_45.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_45.setOpaque(true);
			lbl_45.setBackground(Color.WHITE);
			lbl_45.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_45.setBounds(307, 246, 60, 60);
			lbl_45.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_45MouseClicked(evt);
				}
			});
			boardUI[4][5] = lbl_45;
		}
		return lbl_45;
	}

	private JLabel getLbl_44() {
		if (lbl_44 == null) {
			lbl_44 = new JLabel();
			lbl_44.setOpaque(true);
			lbl_44.setBackground(Color.BLACK);
			lbl_44.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_44.setBounds(247, 246, 60, 60);
			lbl_44.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_44.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_44MouseClicked(evt);
				}
			});
			boardUI[4][4] = lbl_44;
		}
		return lbl_44;
	}

	private JLabel getLbl_43() {
		if (lbl_43 == null) {
			lbl_43 = new JLabel();
			lbl_43.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_43.setOpaque(true);
			lbl_43.setBackground(Color.WHITE);
			lbl_43.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_43.setBounds(187, 246, 60, 60);
			lbl_43.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_43MouseClicked(evt);
				}
			});
			boardUI[4][3] = lbl_43;
		}
		return lbl_43;
	}

	private JLabel getLbl_42() {
		if (lbl_42 == null) {
			lbl_42 = new JLabel();
			lbl_42.setOpaque(true);
			lbl_42.setBackground(Color.BLACK);
			lbl_42.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_42.setBounds(127, 246, 60, 60);
			lbl_42.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_42.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_42MouseClicked(evt);
				}
			});
			boardUI[4][2] = lbl_42;
		}
		return lbl_42;
	}

	private JLabel getLbl_41() {
		if (lbl_41 == null) {
			lbl_41 = new JLabel();
			lbl_41.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_41.setOpaque(true);
			lbl_41.setBackground(Color.WHITE);
			lbl_41.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_41.setBounds(67, 246, 60, 60);
			lbl_41.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_41MouseClicked(evt);
				}
			});
			boardUI[4][1] = lbl_41;
		}
		return lbl_41;
	}

	private JLabel getLbl_40() {
		if (lbl_40 == null) {
			lbl_40 = new JLabel();
			lbl_40.setOpaque(true);
			lbl_40.setBackground(Color.BLACK);
			lbl_40.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_40.setBounds(7, 246, 60, 60);
			lbl_40.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_40.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_40MouseClicked(evt);
				}
			});
			boardUI[4][0] = lbl_40;
		}
		return lbl_40;
	}

	private JLabel getLbl_57() {
		if (lbl_57 == null) {
			lbl_57 = new JLabel();
			lbl_57.setOpaque(true);
			lbl_57.setBackground(Color.BLACK);
			lbl_57.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_57.setBounds(427, 306, 60, 60);
			lbl_57.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_57.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_57MouseClicked(evt);
				}
			});
			boardUI[5][7] = lbl_57;
		}
		return lbl_57;
	}

	private JLabel getLbl_55() {
		if (lbl_55 == null) {
			lbl_55 = new JLabel();
			lbl_55.setOpaque(true);
			lbl_55.setBackground(Color.BLACK);
			lbl_55.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_55.setBounds(307, 306, 60, 60);
			lbl_55.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_55.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_55MouseClicked(evt);
				}
			});
			boardUI[5][5] = lbl_55;
		}
		return lbl_55;
	}

	private JLabel getLbl_56() {
		if (lbl_56 == null) {
			lbl_56 = new JLabel();
			lbl_56.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_56.setOpaque(true);
			lbl_56.setBackground(Color.WHITE);
			lbl_56.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_56.setBounds(367, 306, 60, 60);
			lbl_56.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_56MouseClicked(evt);
				}
			});
			boardUI[5][6] = lbl_56;
		}
		return lbl_56;
	}

	private JLabel getLbl_54() {
		if (lbl_54 == null) {
			lbl_54 = new JLabel();
			lbl_54.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_54.setOpaque(true);
			lbl_54.setBackground(Color.WHITE);
			lbl_54.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_54.setBounds(247, 306, 60, 60);
			lbl_54.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_54MouseClicked(evt);
				}
			});
			boardUI[5][4] = lbl_54;
		}
		return lbl_54;
	}

	private JLabel getLbl_53() {
		if (lbl_53 == null) {
			lbl_53 = new JLabel();
			lbl_53.setOpaque(true);
			lbl_53.setBackground(Color.BLACK);
			lbl_53.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_53.setBounds(187, 306, 60, 60);
			lbl_53.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_53.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_53MouseClicked(evt);
				}
			});
			boardUI[5][3] = lbl_53;
		}
		return lbl_53;
	}

	private JLabel getLbl_52() {
		if (lbl_52 == null) {
			lbl_52 = new JLabel();
			lbl_52.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_52.setOpaque(true);
			lbl_52.setBackground(Color.WHITE);
			lbl_52.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_52.setBounds(127, 306, 60, 60);
			lbl_52.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_52MouseClicked(evt);
				}
			});
			boardUI[5][2] = lbl_52;
		}
		return lbl_52;
	}

	private JLabel getLbl_51() {
		if (lbl_51 == null) {
			lbl_51 = new JLabel();
			lbl_51.setOpaque(true);
			lbl_51.setBackground(Color.BLACK);
			lbl_51.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_51.setBounds(67, 306, 60, 60);
			lbl_51.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_51.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_51MouseClicked(evt);
				}
			});
			boardUI[5][1] = lbl_51;
		}
		return lbl_51;
	}

	private JLabel getLbl_50() {
		if (lbl_50 == null) {
			lbl_50 = new JLabel();
			lbl_50.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_50.setOpaque(true);
			lbl_50.setBackground(Color.WHITE);
			lbl_50.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_50.setBounds(7, 306, 60, 60);
			lbl_50.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_50MouseClicked(evt);
				}
			});
			boardUI[5][0] = lbl_50;
		}
		return lbl_50;
	}

	private JLabel getLbl_67() {
		if (lbl_67 == null) {
			lbl_67 = new JLabel();
			lbl_67.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_67.setOpaque(true);
			lbl_67.setBackground(Color.WHITE);
			lbl_67.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_67.setBounds(427, 366, 60, 60);
			lbl_67.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_67MouseClicked(evt);
				}
			});
			boardUI[6][7] = lbl_67;
		}
		return lbl_67;
	}

	private JLabel getLbl_66() {
		if (lbl_66 == null) {
			lbl_66 = new JLabel();
			lbl_66.setOpaque(true);
			lbl_66.setBackground(Color.BLACK);
			lbl_66.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_66.setBounds(367, 366, 60, 60);
			lbl_66.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_66.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_66MouseClicked(evt);
				}
			});
			boardUI[6][6] = lbl_66;
		}
		return lbl_66;
	}

	private JLabel getLbl_65() {
		if (lbl_65 == null) {
			lbl_65 = new JLabel();
			lbl_65.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_65.setOpaque(true);
			lbl_65.setBackground(Color.WHITE);
			lbl_65.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_65.setBounds(307, 366, 60, 60);
			lbl_65.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_65MouseClicked(evt);
				}
			});
			boardUI[6][5] = lbl_65;
		}
		return lbl_65;
	}

	private JLabel getLbl_64() {
		if (lbl_64 == null) {
			lbl_64 = new JLabel();
			lbl_64.setOpaque(true);
			lbl_64.setBackground(Color.BLACK);
			lbl_64.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_64.setBounds(247, 366, 60, 60);
			lbl_64.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_64.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_64MouseClicked(evt);
				}
			});
			boardUI[6][4] = lbl_64;
		}
		return lbl_64;
	}

	private JLabel getLbl_63() {
		if (lbl_63 == null) {
			lbl_63 = new JLabel();
			lbl_63.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_63.setOpaque(true);
			lbl_63.setBackground(Color.WHITE);
			lbl_63.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_63.setBounds(187, 366, 60, 60);
			lbl_63.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_63MouseClicked(evt);
				}
			});
			boardUI[6][3] = lbl_63;
		}
		return lbl_63;
	}

	private JLabel getLbl_62() {
		if (lbl_62 == null) {
			lbl_62 = new JLabel();
			lbl_62.setOpaque(true);
			lbl_62.setBackground(Color.BLACK);
			lbl_62.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_62.setBounds(127, 366, 60, 60);
			lbl_62.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_62.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_62MouseClicked(evt);
				}
			});
			boardUI[6][2] = lbl_62;
		}
		return lbl_62;
	}

	private JLabel getLbl_61() {
		if (lbl_61 == null) {
			lbl_61 = new JLabel();
			lbl_61.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_61.setOpaque(true);
			lbl_61.setBackground(Color.WHITE);
			lbl_61.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_61.setBounds(67, 366, 60, 60);
			lbl_61.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_61MouseClicked(evt);
				}
			});
			boardUI[6][1] = lbl_61;
		}
		return lbl_61;
	}

	private JLabel getLbl_60() {
		if (lbl_60 == null) {
			lbl_60 = new JLabel();
			lbl_60.setOpaque(true);
			lbl_60.setBackground(Color.BLACK);
			lbl_60.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_60.setBounds(7, 366, 60, 60);
			lbl_60.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_60.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_60MouseClicked(evt);
				}
			});
			boardUI[6][0] = lbl_60;
		}
		return lbl_60;
	}

	private JLabel getLbl_70() {
		if (lbl_70 == null) {
			lbl_70 = new JLabel();
			lbl_70.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_70.setOpaque(true);
			lbl_70.setBackground(Color.WHITE);
			lbl_70.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_70.setBounds(7, 426, 60, 60);
			lbl_70.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_70MouseClicked(evt);
				}
			});
			boardUI[7][0] = lbl_70;
		}
		return lbl_70;
	}

	private JLabel getLbl_77() {
		if (lbl_77 == null) {
			lbl_77 = new JLabel();
			lbl_77.setOpaque(true);
			lbl_77.setBackground(Color.BLACK);
			lbl_77.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_77.setBounds(427, 426, 60, 60);
			lbl_77.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_77.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_77MouseClicked(evt);
				}
			});
			boardUI[7][7] = lbl_77;
		}
		return lbl_77;
	}

	private JLabel getLbl_76() {
		if (lbl_76 == null) {
			lbl_76 = new JLabel();
			lbl_76.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_76.setOpaque(true);
			lbl_76.setBackground(Color.WHITE);
			lbl_76.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_76.setBounds(367, 426, 60, 60);
			lbl_76.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_76MouseClicked(evt);
				}
			});
			boardUI[7][6] = lbl_76;
		}
		return lbl_76;
	}

	private JLabel getLbl_75() {
		if (lbl_75 == null) {
			lbl_75 = new JLabel();
			lbl_75.setOpaque(true);
			lbl_75.setBackground(Color.BLACK);
			lbl_75.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_75.setBounds(307, 426, 60, 60);
			lbl_75.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_75.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_75MouseClicked(evt);
				}
			});
			boardUI[7][5] = lbl_75;
		}
		return lbl_75;
	}

	private JLabel getLbl_74() {
		if (lbl_74 == null) {
			lbl_74 = new JLabel();
			lbl_74.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_74.setOpaque(true);
			lbl_74.setBackground(Color.WHITE);
			lbl_74.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_74.setBounds(247, 426, 60, 60);
			lbl_74.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_74MouseClicked(evt);
				}
			});
			boardUI[7][4] = lbl_74;
		}
		return lbl_74;
	}

	private JLabel getLbl_73() {
		if (lbl_73 == null) {
			lbl_73 = new JLabel();
			lbl_73.setOpaque(true);
			lbl_73.setBackground(Color.BLACK);
			lbl_73.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_73.setBounds(187, 426, 60, 60);
			lbl_73.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_73.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_73MouseClicked(evt);
				}
			});
			boardUI[7][3] = lbl_73;
		}
		return lbl_73;
	}

	private JLabel getLbl_72() {
		if (lbl_72 == null) {
			lbl_72 = new JLabel();
			lbl_72.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_72.setOpaque(true);
			lbl_72.setBackground(Color.WHITE);
			lbl_72.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_72.setBounds(127, 426, 60, 60);
			lbl_72.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_72MouseClicked(evt);
				}
			});
			boardUI[7][2] = lbl_72;
		}
		return lbl_72;
	}

	private JLabel getLbl_71() {
		if (lbl_71 == null) {
			lbl_71 = new JLabel();
			lbl_71.setOpaque(true);
			lbl_71.setBackground(Color.BLACK);
			lbl_71.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			lbl_71.setBounds(67, 426, 60, 60);
			lbl_71.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_71.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lbl_71MouseClicked(evt);
				}
			});
			boardUI[7][1] = lbl_71;
		}
		return lbl_71;
	}

	private JButton getBtnQuit() {
		if (btnQuit == null) {
			btnQuit = new JButton();
			btnQuit.setText("Salir");
			btnQuit.setBounds(536, 661, 86, 23);
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
			txtMessage.setCaretColor(Color.WHITE);
			txtMessage.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			txtMessage.setBackground(Color.BLACK);
			txtMessage.setForeground(Color.WHITE);
			txtMessage.setText(null);
			txtMessage.setBounds(10, 660, 493, 25);
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
			pnlChat.setBorder(null);
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
			txtChat.setForeground(Color.WHITE);
			txtChat.setBackground(Color.BLACK);
			txtChat.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			txtChat.setEditable(false);
			txtChat.setEditorKit(htmlEditor);
			txtChat.setDocument(chatText);
		}
		return txtChat;
	}

	private JLabel getLblOpponentName() {
		if (lblOpponentName == null) {
			lblOpponentName = new JLabel();
			lblOpponentName.setForeground(Color.WHITE);
			lblOpponentName.setHorizontalAlignment(SwingConstants.CENTER);
			lblOpponentName.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblOpponentName.setBorder(null);
			lblOpponentName.setBounds(522, 141, 102, 25);
		}
		return lblOpponentName;
	}

	private void lbl_00MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(0, 0);
	}

	private void lbl_01MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(0, 1);
	}

	private void lbl_02MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(0, 2);
	}

	private void lbl_03MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(0, 3);
	}

	private void lbl_04MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(0, 4);
	}

	private void lbl_05MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(0, 5);
	}

	private void lbl_06MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(0, 6);
	}

	private void lbl_07MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(0, 7);
	}

	private void lbl_17MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(1, 7);
	}

	private void lbl_16MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(1, 6);
	}

	private void lbl_15MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(1, 5);
	}

	private void lbl_14MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(1, 4);
	}

	private void lbl_13MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(1, 3);
	}

	private void lbl_12MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(1, 2);
	}

	private void lbl_11MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(1, 1);
	}

	private void lbl_10MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(1, 0);
	}

	private void lbl_27MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(2, 7);
	}

	private void lbl_26MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(2, 6);
	}

	private void lbl_25MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(2, 5);
	}

	private void lbl_24MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(2, 4);
	}

	private void lbl_23MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(2, 3);
	}

	private void lbl_22MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(2, 2);
	}

	private void lbl_21MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(2, 1);
	}

	private void lbl_20MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(2, 0);
	}

	private void lbl_37MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(3, 7);
	}

	private void lbl_36MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(3, 6);
	}

	private void lbl_35MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(3, 5);
	}

	private void lbl_34MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(3, 4);
	}

	private void lbl_33MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(3, 3);
	}

	private void lbl_32MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(3, 2);
	}

	private void lbl_31MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(3, 1);
	}

	private void lbl_30MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(3, 0);
	}

	private void lbl_47MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(4, 7);
	}

	private void lbl_46MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(4, 6);
	}

	private void lbl_45MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(4, 5);
	}

	private void lbl_44MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(4, 4);
	}

	private void lbl_43MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(4, 3);
	}

	private void lbl_42MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(4, 2);
	}

	private void lbl_41MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(4, 1);
	}

	private void lbl_40MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(4, 0);
	}

	private void lbl_57MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(5, 7);
	}

	private void lbl_55MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(5, 5);
	}

	private void lbl_56MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(5, 6);
	}

	private void lbl_54MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(5, 4);
	}

	private void lbl_53MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(5, 3);
	}

	private void lbl_52MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(5, 2);
	}

	private void lbl_51MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(5, 1);
	}

	private void lbl_50MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(5, 0);
	}

	private void lbl_67MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(6, 7);
	}

	private void lbl_66MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(6, 6);
	}

	private void lbl_65MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(6, 5);
	}

	private void lbl_64MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(6, 4);
	}

	private void lbl_63MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(6, 3);
	}

	private void lbl_62MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(6, 2);
	}

	private void lbl_61MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(6, 1);
	}

	private void lbl_60MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(6, 0);
	}

	private void lbl_70MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(7, 0);
	}

	private void lbl_77MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(7, 7);
	}

	private void lbl_76MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(7, 6);
	}

	private void lbl_75MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(7, 5);
	}

	private void lbl_74MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(7, 4);
	}

	private void lbl_73MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(7, 3);
	}

	private void lbl_72MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(7, 2);
	}

	private void lbl_71MouseClicked(MouseEvent evt) {
		if (activeSquares)
			movimientosPosibles(7, 1);
	}

	private JLabel getLblState() {
		if (lblState == null) {
			lblState = new JLabel();
			lblState.setForeground(Color.WHITE);
			lblState.setBounds(10, 503, 493, 18);
			lblState.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblState;
	}

	private JLabel getLblTimer() {
		if (lblTimer == null) {
			lblTimer = new JLabel();
			lblTimer.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblTimer.setForeground(Color.WHITE);
			lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
			lblTimer.setText(formatTurnTime(Constants.CheckersTurn));
			lblTimer.setBounds(513, 462, 121, 23);
		}
		return lblTimer;
	}

	private void btnQuitMouseClicked(MouseEvent evt) {
		turnPassed = true;
		Controller.getInstance().leaveGame(game.getName());
		dispose();
	}

	private void thisWindowClosing(WindowEvent evt) {
		turnPassed = true;
		Controller.getInstance().leaveGame(game.getName());
		dispose();
	}

	private void movimientosPosibles(int row, int column) {
		boolean validMove = false;

		// Same square pressed
		if (!(selectedRow == row && selectedColumn == column)) {
			// Possible moves from this square
			List<CheckersMove> possibleMoves = new ArrayList<CheckersMove>();

			for (CheckersMove move : moves) {
				if (move.getFromRow() == row && move.getFromColumn() == column) {
					possibleMoves.add(move);
				}
			}

			// There are movements from this square
			if (possibleMoves.size() > 0) {
				selectedRow = row;
				selectedColumn = column;

				for (CheckersMove move : moves) {
					if (!(move.getFromRow() == row && move.getFromColumn() == column)) {
						boardUI[move.getFromRow()][move.getFromColumn()]
								.setBorder(new LineBorder(new java.awt.Color(0,
										255, 0), 4, false));
						boardUI[move.getToRow()][move.getToColumn()]
								.setBorder(new LineBorder(new java.awt.Color(0,
										0, 0), 1, false));
					}
				}

				for (CheckersMove move : possibleMoves) {
					boardUI[row][column].setBorder(new LineBorder(
							new java.awt.Color(0, 0, 255), 4, false));
					boardUI[move.getToRow()][move.getToColumn()]
							.setBorder(new LineBorder(new java.awt.Color(255,
									0, 0), 4, false));
				}
			} else {
				// Check if it's a legal move
				for (CheckersMove move : moves) {
					if (move.getFromRow() == selectedRow
							&& move.getFromColumn() == selectedColumn) {
						if (move.getToRow() == row
								&& move.getToColumn() == column) {
							// It's a valid move
							Checkers.move(game.getBoard(), selectedRow,
									selectedColumn, row, column);
							validMove = true;
							if (move.isJump()) {
								moves = Checkers.getLegalJumpsFrom(
										game.getBoard(), myPlayer,
										move.getToRow(), move.getToColumn());
								if (!moves.isEmpty()) {
									refreshBoard();
									lblState.setText("Que tienes para dar otro saltito hombre!");
									// TODO
									if (!turnPassed) {
										endTurn();
										timerThread.interrupt();
										startTimer();
										Controller.getInstance().updateGame(
												game.getName());
									}

								} else { // No more jumps
									activeSquares = false;
									playerTurn = game.changeTurn();
									refreshBoard();
									List<CheckersMove> opponentMoves = Checkers
											.legalMoves(game.getBoard(),
													playerTurn);
									if (opponentMoves.size() > 0) {
										if (computer) {
											computerMove();
										} else {
											if (!turnPassed) {
												endTurn();
												Controller.getInstance()
														.updateGame(
																game.getName());
												lblState.setText("Es el turno de "
														+ lblOpponentName
																.getText());
											}
										}
									} else {
										if (!turnPassed) {
											endTurn();
											Controller.getInstance()
													.finishGame(game.getName(),
															username);
											JOptionPane.showMessageDialog(this,
													"Has ganado el juego!");
											dispose();
										}
									}
								}
							} else {
								activeSquares = false;
								playerTurn = game.changeTurn();
								refreshBoard();
								List<CheckersMove> opponentMoves = Checkers
										.legalMoves(game.getBoard(), playerTurn);
								if (opponentMoves.size() > 0) {
									if (computer) {
										computerMove();
									} else {
										if (!turnPassed) {
											endTurn();
											Controller.getInstance()
													.updateGame(game.getName());
											lblState.setText("Es el turno de "
													+ lblOpponentName.getText());
										}
									}
								} else {
									if (!turnPassed) {
										endTurn();
										Controller.getInstance().finishGame(
												game.getName(), username);
										JOptionPane.showMessageDialog(this,
												"Has ganado el juego!");
										dispose();
									}
								}
							}
							break;
						}
					}
				}

				if (!validMove)
					lblState.setText("Ese movimiento no es válido");

			}
		}
	}

	private void computerMove() {
		CheckersMove move = minimax.minimax(game.getBoard(), game.getTurn());
		Checkers.move(game.getBoard(), move.getFromRow(), move.getFromColumn(),
				move.getToRow(), move.getToColumn());
		playerTurn = game.changeTurn();
		activeSquares = true;
		refreshBoard();
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
	public void updateBoard(int nextTurn) {
		if (nextTurn == myPlayer) {
			playerTurn = game.changeTurn();
			turnPassed = false;
			activeSquares = true;
			lblState.setText("Es tu turno");
			startTimer();
		}

		refreshBoard();
	}

	@Override
	public void lostGame() {
		refreshBoard();
		lblState.setText("Has perdido la partida");
		activeSquares = false;
		new Thread() {
			public void run() {
				JOptionPane.showMessageDialog(CheckersUI.this,
						"Has perdido el juego!");
				dispose();
			}
		}.start();
	}

	@Override
	public void userLeaveGame(final String player) {
		turnPassed = true;
		new Thread() {
			public void run() {
				JOptionPane.showMessageDialog(CheckersUI.this, player
						+ " ha abandonado el juego. !Has ganado¡");
				dispose();
			}
		}.start();

	}

	private void resaltarMovimientos() {
		for (CheckersMove move : moves) {
			int row = move.getFromRow();
			int column = move.getFromColumn();
			boardUI[row][column].setBorder(greenBorder);
			repaint();
		}
	}

	public void refreshBoard() {
		int[][] board = game.getBoard();
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				boardUI[row][column].setBorder(blackBorder);
				switch (board[row][column]) {
				case Checkers.EMPTY:
					boardUI[row][column].setIcon(null);
					break;
				case Checkers.RED:
					boardUI[row][column].setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"images/Checkers/Red.png")));
					break;
				case Checkers.RED_KING:
					boardUI[row][column].setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"images/Checkers/Red_King.png")));
					break;
				case Checkers.BLACK:
					boardUI[row][column].setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"images/Checkers/Black.png")));
					break;
				case Checkers.BLACK_KING:
					boardUI[row][column].setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"images/Checkers/Black_King.png")));
					break;
				}
			}
		}

		if (playerTurn == myPlayer) {
			moves = Checkers.legalMoves(game.getBoard(), myPlayer);
			resaltarMovimientos();
		}
	}

	private void startTimer() {
		turnPassed = false;
		timerThread = new Thread() {
			public void run() {
				lblTimer.setText(formatTurnTime(Constants.CheckersTurn));
				try {
					for (int turn = Constants.CheckersTurn - 1; turn >= 0
							&& !turnPassed; turn--) {

						sleep(1000);

						lblTimer.setText(formatTurnTime(turn));
					}

					if (!turnPassed) {
						endTurn();
						playerTurn = game.changeTurn();
						Controller.getInstance().updateGame(game.getName());
						activeSquares = false;
						lblState.setText("Se te ha acabado el tiempo. Es el turno de "
								+ lblOpponentName.getText());

						refreshBoard();
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lblTimer.setText(formatTurnTime(Constants.CheckersTurn));

			}
		};

		timerThread.start();
	}

	private synchronized void endTurn() {
		turnPassed = true;
	}

	private String formatTurnTime(int turnTime) {
		int minutes = (int) (turnTime / 60);
		int seconds = turnTime % 60;

		String formattedTime;

		if (minutes < 10)
			formattedTime = "0" + minutes + ":";
		else
			formattedTime = minutes + ":";

		if (seconds < 10)
			formattedTime += "0" + seconds;
		else
			formattedTime += seconds;

		return formattedTime;
	}

	private JLabel getLblLblturn() {
		if (lblLblturn == null) {
			lblLblturn = new JLabel("Tiempo de turno");
			lblLblturn.setHorizontalAlignment(SwingConstants.CENTER);
			lblLblturn.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblLblturn.setForeground(Color.WHITE);
			lblLblturn.setBounds(513, 426, 121, 25);
		}
		return lblLblturn;
	}
}
