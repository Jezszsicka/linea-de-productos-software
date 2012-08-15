package presentation;

import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import logic.Controller;
import ProductLine.GameType;

@SuppressWarnings("serial")
public class CreateGameUI extends javax.swing.JFrame {

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JPanel pnlBackground;
	private JLabel lblConnect4lIcon;
	private JPanel pnlConnect4;
	private JPanel pnlCheckers;
	private JLabel lblIconCheckers;
	private JLabel lblCheckers;
	private JLabel lblCheckersPlayers;
	private JButton btnCancel;
	private JLabel lblGame;
	private JTextField txtGameName;
	private JLabel lblGoosePlayers;
	private JLabel lblGoose;
	private JLabel lblGooseIcon;
	private JPanel pnlGoose;
	private JLabel lblChessPlayers;
	private JLabel lblConnect4;
	private JLabel lblConnect4Players;
	private JLabel lblGameTitle;
	private JLabel lblDescription;
	private JLabel lblIconChess;
	private JLabel lblChess;
	private JPanel pnlChess;
	private JPanel pnlGameSelection;
	private JLabel lblGamePlayers;
	private JTextPane txtGameDescription;
	private JLabel lblPlayers;
	private JPanel pnlGame;
	private JLabel lblGameImage;
	private JLabel lblGameName;
	private JButton btnCreate;
	private GameType selectedGame;
	private JPanel pnlLudo;
	private JLabel lblLudoIcon;
	private JLabel lblLudo;
	private JLabel lblLudoPlayers;

	public CreateGameUI() {
		super();
		setResizable(false);
		selectedGame = GameType.Checkers;
		initGUI();
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private void initGUI() {
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				thisWindowClosing(evt);
			}
		});
		this.setSize(569, 454);
		getContentPane().setLayout(null);
		getContentPane().add(getPnlBackground());
	}

	private JPanel getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setBounds(0, 0, 563, 426);
			pnlBackground.setLayout(null);
			pnlBackground.add(getBtnCreate());
			pnlBackground.add(getBtnCancel());
			pnlBackground.add(getPnlGame());
			pnlBackground.add(getPnlGameSelection());
		}
		return pnlBackground;
	}

	private JButton getBtnCreate() {
		if (btnCreate == null) {
			btnCreate = new JButton();
			btnCreate.setText("Create game");
			btnCreate.setBounds(450, 362, 95, 23);
			btnCreate.setFocusable(false);
			btnCreate.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnCreateMouseClicked(evt);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					btnCreateMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnCreateMouseExited(e);
				}
			});
		}
		return btnCreate;
	}

	private JLabel getLblGameName() {
		if (lblGameName == null) {
			lblGameName = new JLabel();
			lblGameName.setText("Game name");
			lblGameName.setBounds(2, 13, 89, 20);
			lblGameName.setHorizontalAlignment(SwingConstants.CENTER);
			lblGameName.setHorizontalTextPosition(SwingConstants.CENTER);
			lblGameName.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblGameName;
	}

	private JTextField getTxtGameName() {
		if (txtGameName == null) {
			txtGameName = new JTextField();
			txtGameName.setBounds(101, 13, 152, 20);
			txtGameName.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent evt) {
					txtGameNameKeyPressed(evt);
				}
			});
		}
		return txtGameName;
	}

	private JLabel getLblGame() {
		if (lblGame == null) {
			lblGame = new JLabel();
			lblGame.setText("Games");
			lblGame.setBounds(12, 50, 61, 20);
			lblGame.setHorizontalTextPosition(SwingConstants.CENTER);
			lblGame.setHorizontalAlignment(SwingConstants.LEFT);
			lblGame.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblGame;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.setBounds(450, 391, 95, 23);
			btnCancel.setText("Cancel");
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

	private void btnCancelMouseClicked(MouseEvent evt) {
		Controller.getInstance().closeCreateGameUI();
	}

	private JLabel getLblCheckersPlayers() {
		if (lblCheckersPlayers == null) {
			lblCheckersPlayers = new JLabel();
			lblCheckersPlayers.setText("2");
			lblCheckersPlayers.setBounds(10, 8, 21, 25);
			lblCheckersPlayers.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblCheckersPlayers;
	}

	private JLabel getLblCheckers() {
		if (lblCheckers == null) {
			lblCheckers = new JLabel();
			lblCheckers.setText("Damas");
			lblCheckers.setBounds(72, 8, 58, 25);
			lblCheckers.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblCheckers;
	}

	private JLabel getLblIconCheckers() {
		if (lblIconCheckers == null) {
			lblIconCheckers = new JLabel();
			lblIconCheckers.setBounds(154, 8, 25, 25);
			lblIconCheckers.setIcon(new ImageIcon(CreateGameUI.class
					.getResource("/images/Games/checkers_small_icon.png")));
		}
		return lblIconCheckers;
	}

	private JPanel getPnlCheckers() {
		if (pnlCheckers == null) {
			pnlCheckers = new JPanel();
			pnlCheckers.setLayout(null);
			pnlCheckers.setBounds(10, 76, 243, 40);
			pnlCheckers.setBorder(BorderFactory.createTitledBorder(""));
			pnlCheckers.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					pnlCheckersMouseClicked(evt);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					pnlCheckersMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					pnlCheckersMouseExited(e);
				}
			});
			pnlCheckers.add(getLblIconCheckers());
			pnlCheckers.add(getLblCheckers());
			pnlCheckers.add(getLblCheckersPlayers());
		}
		return pnlCheckers;
	}

	private JPanel getConnect4() {
		if (pnlConnect4 == null) {
			pnlConnect4 = new JPanel();
			pnlConnect4.setLayout(null);
			pnlConnect4.setBounds(10, 122, 243, 40);
			pnlConnect4.setBorder(BorderFactory.createTitledBorder(""));
			pnlConnect4.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					pnlConnect4MouseClicked(evt);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					pnlConnect4MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					pnlConnect4MouseExited(e);
				}
			});
			pnlConnect4.add(getJLabel1());
			pnlConnect4.add(getJLabel2());
			pnlConnect4.add(getJLabel3());
		}
		return pnlConnect4;
	}

	private JLabel getJLabel1() {
		if (lblConnect4lIcon == null) {
			lblConnect4lIcon = new JLabel();
			lblConnect4lIcon.setBounds(153, 6, 25, 25);
			lblConnect4lIcon.setIcon(new ImageIcon(CreateGameUI.class
					.getResource("/images/Games/connect4_small_icon.png")));
		}
		return lblConnect4lIcon;
	}

	private JLabel getJLabel2() {
		if (lblConnect4 == null) {
			lblConnect4 = new JLabel();
			lblConnect4.setText("Conecta 4");
			lblConnect4.setHorizontalAlignment(SwingConstants.CENTER);
			lblConnect4.setBounds(70, 6, 59, 25);
		}
		return lblConnect4;
	}

	private JLabel getJLabel3() {
		if (lblConnect4Players == null) {
			lblConnect4Players = new JLabel();
			lblConnect4Players.setText("2");
			lblConnect4Players.setHorizontalAlignment(SwingConstants.CENTER);
			lblConnect4Players.setBounds(10, 6, 21, 25);
		}
		return lblConnect4Players;
	}

	private JLabel getLblGameImage() {
		if (lblGameImage == null) {
			lblGameImage = new JLabel();
			lblGameImage.setBounds(2, 36, 254, 60);
			lblGameImage.setIcon(new ImageIcon(CreateGameUI.class
					.getResource("/images/Games/checkers_icon.png")));
			lblGameImage.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblGameImage;
	}

	private JLabel getJLabel4() {
		if (lblGameTitle == null) {
			lblGameTitle = new JLabel();
			lblGameTitle.setText("Damas");
			lblGameTitle.setBounds(2, 13, 253, 16);
			lblGameTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lblGameTitle.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblGameTitle;
	}

	private JPanel getPnlGame() {
		if (pnlGame == null) {
			pnlGame = new JPanel();
			pnlGame.setLayout(null);
			pnlGame.setBounds(292, 21, 258, 330);
			pnlGame.setBorder(BorderFactory.createTitledBorder(""));
			pnlGame.add(getJLabel4());
			pnlGame.add(getLblGameImage());
			pnlGame.add(getLblPlayers());
			pnlGame.add(getLblDescription());
			pnlGame.add(getTxtGameDescription());
			pnlGame.add(getLblGamePlayers());
		}
		return pnlGame;
	}

	private JLabel getLblPlayers() {
		if (lblPlayers == null) {
			lblPlayers = new JLabel();
			lblPlayers.setText("Jugadores:");
			lblPlayers.setBounds(12, 129, 67, 18);
			lblPlayers.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblPlayers;
	}

	private JLabel getLblDescription() {
		if (lblDescription == null) {
			lblDescription = new JLabel();
			lblDescription.setText("Descripción:");
			lblDescription.setBounds(12, 158, 74, 14);
			lblDescription.setFont(new java.awt.Font("Tahoma", 1, 11));
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
			txtGameDescription.setBounds(12, 178, 234, 138);
			txtGameDescription.setEditable(false);
			txtGameDescription.setBackground(new java.awt.Color(240, 240, 240));
			txtGameDescription.setFocusable(false);
		}
		return txtGameDescription;
	}

	private JLabel getLblGamePlayers() {
		if (lblGamePlayers == null) {
			lblGamePlayers = new JLabel();
			lblGamePlayers.setText("2 jugadores");
			lblGamePlayers.setBounds(85, 129, 161, 18);
		}
		return lblGamePlayers;
	}

	private JPanel getPnlGameSelection() {
		if (pnlGameSelection == null) {
			pnlGameSelection = new JPanel();
			pnlGameSelection.setLayout(null);
			pnlGameSelection.setBounds(10, 21, 265, 330);
			pnlGameSelection.setBorder(BorderFactory.createTitledBorder(""));
			pnlGameSelection.add(getLblGame());
			pnlGameSelection.add(getTxtGameName());
			pnlGameSelection.add(getLblGameName());
			pnlGameSelection.add(getPnlCheckers());
			pnlGameSelection.add(getPnlChess());
			pnlGameSelection.add(getConnect4());
			pnlGameSelection.add(getPnlGoose());
			pnlGameSelection.add(getPnlLudo());
		}
		return pnlGameSelection;
	}

	private JPanel getPnlChess() {
		if (pnlChess == null) {
			pnlChess = new JPanel();
			pnlChess.setLayout(null);
			pnlChess.setBounds(10, 168, 243, 40);
			pnlChess.setBorder(BorderFactory.createTitledBorder(""));
			pnlChess.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					pnlChessMouseClicked(evt);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					pnlChessMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					pnlChessMouseExited(e);
				}
			});
			pnlChess.add(getLblIconChess());
			pnlChess.add(getLblChess());
			pnlChess.add(getLblChessPlayers());
		}
		return pnlChess;
	}

	private JLabel getLblIconChess() {
		if (lblIconChess == null) {
			lblIconChess = new JLabel();
			lblIconChess.setIcon(new ImageIcon(CreateGameUI.class
					.getResource("/images/Games/chess_small_icon.png")));
			lblIconChess.setBounds(153, 8, 25, 25);
		}
		return lblIconChess;
	}

	private JLabel getLblChess() {
		if (lblChess == null) {
			lblChess = new JLabel();
			lblChess.setText("Ajedrez");
			lblChess.setHorizontalAlignment(SwingConstants.CENTER);
			lblChess.setBounds(70, 8, 59, 25);
		}
		return lblChess;
	}

	private JLabel getLblChessPlayers() {
		if (lblChessPlayers == null) {
			lblChessPlayers = new JLabel();
			lblChessPlayers.setText("2");
			lblChessPlayers.setHorizontalAlignment(SwingConstants.CENTER);
			lblChessPlayers.setBounds(9, 8, 21, 25);
		}
		return lblChessPlayers;
	}

	private JPanel getPnlGoose() {
		if (pnlGoose == null) {
			pnlGoose = new JPanel();
			pnlGoose.setBorder(BorderFactory.createTitledBorder(""));
			pnlGoose.setLayout(null);
			pnlGoose.setBounds(10, 214, 243, 40);
			pnlGoose.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					pnlGooseMouseClicked(evt);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					pnlGooseMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					pnlGooseMouseExited(e);
				}
			});
			pnlGoose.add(getLblGooseIcon());
			pnlGoose.add(getLblGoose());
			pnlGoose.add(getLblGoosePlayers());
		}
		return pnlGoose;
	}

	private JLabel getLblGooseIcon() {
		if (lblGooseIcon == null) {
			lblGooseIcon = new JLabel();
			lblGooseIcon.setIcon(new ImageIcon(CreateGameUI.class
					.getResource("/images/Games/goose_icon_small.png")));
			lblGooseIcon.setBounds(153, 6, 25, 25);
		}
		return lblGooseIcon;
	}

	private JLabel getLblGoose() {
		if (lblGoose == null) {
			lblGoose = new JLabel();
			lblGoose.setText("Oca");
			lblGoose.setHorizontalAlignment(SwingConstants.CENTER);
			lblGoose.setBounds(70, 6, 59, 25);
		}
		return lblGoose;
	}

	private JLabel getLblGoosePlayers() {
		if (lblGoosePlayers == null) {
			lblGoosePlayers = new JLabel();
			lblGoosePlayers.setText("8");
			lblGoosePlayers.setHorizontalAlignment(SwingConstants.CENTER);
			lblGoosePlayers.setBounds(10, 6, 21, 25);
		}
		return lblGoosePlayers;
	}

	private JPanel getPnlLudo() {
		if (pnlLudo == null) {
			pnlLudo = new JPanel();
			pnlLudo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					pnlLudoMouseClicked(arg0);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					pnlLudoMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					pnlLudoMouseExited(e);
				}
			});
			pnlLudo.setLayout(null);
			pnlLudo.setBorder(BorderFactory.createTitledBorder(""));
			pnlLudo.setBounds(10, 265, 243, 40);
			pnlLudo.add(getLblLudoIcon());
			pnlLudo.add(getLblLudo());
			pnlLudo.add(getLblLudoPlayers());
		}
		return pnlLudo;
	}

	private JLabel getLblLudoIcon() {
		if (lblLudoIcon == null) {
			lblLudoIcon = new JLabel();
			lblLudoIcon.setIcon(new ImageIcon(CreateGameUI.class
					.getResource("/images/Games/ludo_small_icon.png")));
			lblLudoIcon.setBounds(153, 6, 25, 25);
		}
		return lblLudoIcon;
	}

	private JLabel getLblLudo() {
		if (lblLudo == null) {
			lblLudo = new JLabel();
			lblLudo.setText("Parchís");
			lblLudo.setHorizontalAlignment(SwingConstants.CENTER);
			lblLudo.setBounds(70, 6, 59, 25);
		}
		return lblLudo;
	}

	private JLabel getLblLudoPlayers() {
		if (lblLudoPlayers == null) {
			lblLudoPlayers = new JLabel();
			lblLudoPlayers.setText("4");
			lblLudoPlayers.setHorizontalAlignment(SwingConstants.CENTER);
			lblLudoPlayers.setBounds(10, 6, 21, 25);
		}
		return lblLudoPlayers;
	}

	private void thisWindowClosing(WindowEvent evt) {
		Controller.getInstance().closeCreateGameUI();
	}

	private void btnCreateMouseClicked(MouseEvent evt) {
		createGame();
	}

	private void txtGameNameKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == 10) {
			createGame();
		}
	}

	private void createGame() {
		Controller.getInstance()
				.createGame(txtGameName.getText(), selectedGame);
	}

	private void pnlCheckersMouseClicked(MouseEvent evt) {
		checkersSelected();
	}

	private void pnlChessMouseClicked(MouseEvent evt) {
		chessSelected();
	}

	private void pnlConnect4MouseClicked(MouseEvent evt) {
		connect4Selected();
	}

	private void pnlGooseMouseClicked(MouseEvent evt) {
		gooseSelected();
	}

	protected void pnlLudoMouseClicked(MouseEvent arg0) {
		ludoSelected();
	}

	private void checkersSelected() {
		lblGameTitle.setText("Damas");
		txtGameDescription
				.setText("Las damas es un juego de mesa para dos contrincantes. El juego consiste en mover las piezas en diagonal a través de los cuadros negros de un tablero de ajedrez con la intención de capturar (comer) las piezas del contrario saltando por encima de ellas.");
		lblGameImage.setIcon(new ImageIcon(CreateGameUI.class
				.getResource("/images/Games/checkers_icon.png")));
		lblGamePlayers.setText("2 jugadores");
		selectedGame = GameType.Checkers;
	}

	private void chessSelected() {
		lblGameTitle.setText("Ajedrez");
		txtGameDescription
				.setText("El ajedrez es un juego competitivo entre dos personas, cada una de las cuales dispone de 16 piezas móviles que se colocan sobre un tablero dividido en 64 escaques.");
		lblGameImage.setIcon(new ImageIcon(CreateGameUI.class
				.getResource("/images/Games/chess_icon.png")));
		lblGamePlayers.setText("2 jugadores");
		selectedGame = GameType.Chess;
	}

	private void connect4Selected() {
		lblGameTitle.setText("Conecta 4");
		txtGameDescription
				.setText("Conecta 4 es un juego de mesa para dos contrincantes. El juego consiste en mover las piezas en diagonal a través de los cuadros negros de un tablero de ajedrez con la intención de capturar (comer) las piezas del contrario saltando por encima de ellas.");
		lblGameImage.setIcon(new ImageIcon(CreateGameUI.class
				.getResource("/images/Games/connect4_icon.png")));
		lblGamePlayers.setText("2 jugadores");
		selectedGame = GameType.Connect4;
	}

	private void gooseSelected() {
		lblGameTitle.setText("Juego de la oca");
		txtGameDescription
				.setText("El juego de la oca es un juego de mesa en el que cada jugador avanza su ficha por un tablero con 63 casillas con dibujos. Dependiendo de la casilla en la que se caiga se puede avanzar o por el contrario retroceder y en algunas de ellas está indicado un castigo. En su turno cada jugador tira el dado que le indica el número de casillas que debe avanzar. Gana el juego el primer jugador que llega a la casilla 63, el jardín de la oca.");
		lblGameImage.setIcon(new ImageIcon(CreateGameUI.class
				.getResource("/images/Games/goose_icon.png")));
		lblGamePlayers.setText("2-8 jugadores");
		selectedGame = GameType.Goose;
	}

	private void ludoSelected() {
		lblGameTitle.setText("Parchís");
		txtGameDescription
				.setText("El parchís es un juego de mesa que se juega con 1 dado y 4 fichas para cada uno de los jugadores. El objeto del juego es que cada jugador lleve sus fichas desde la salida hasta la meta intentando, en el camino, comerse a las demás. El primero en conseguirlo será el ganador.");
		lblGameImage.setIcon(new ImageIcon(CreateGameUI.class
				.getResource("/images/Games/ludo_icon.png")));
		lblGamePlayers.setText("2-4 jugadores");
		selectedGame = GameType.Ludo;
	}

	private void setHandCursor() {
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	private void setDefaultCursor() {
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	protected void btnCreateMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnCreateMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void btnCancelMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnCancelMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void pnlCheckersMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void pnlCheckersMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void pnlConnect4MouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void pnlConnect4MouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void pnlChessMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void pnlChessMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void pnlGooseMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void pnlGooseMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void pnlLudoMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void pnlLudoMouseExited(MouseEvent e) {
		setDefaultCursor();
	}
}