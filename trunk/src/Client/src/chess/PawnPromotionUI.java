package chess;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import chess.Chess.Player;

@SuppressWarnings("serial")
public class PawnPromotionUI extends javax.swing.JFrame {
	private JPanel pnlBackground;
	private JButton btnAceptar;
	private JLabel lblPrevious;
	private JLabel lblNext;
	private JLabel lblPiece;
	private JLabel lblSelect;

	private ChessUI parent;
	private Player player;

	private int selectedPiece;

	public PawnPromotionUI(ChessUI parent, Player player) {
		super();
		parent.setEnabled(true);
		this.parent = parent;
		this.player = player;
		initGUI();

		if (player == Chess.Player.Black) {
			lblPiece.setIcon(new ImageIcon(PawnPromotionUI.class
					.getResource("/images/Chess/Black Q.png")));
			selectedPiece = Chess.BLACK_QUEEN;
		} else {
			lblPiece.setIcon(new ImageIcon(PawnPromotionUI.class
					.getResource("/images/Chess/White Q.png")));
			selectedPiece = Chess.WHITE_QUEEN;
		}

	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			getContentPane().add(getPnlBackground(), "Center");
			setSize(236, 200);
			setLocationRelativeTo(null);
			setVisible(true);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private JPanel getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setLayout(null);
			pnlBackground.setBounds(0, 0, 220, 162);
			pnlBackground.add(getLblSelect());
			pnlBackground.add(getLblPiece());
			pnlBackground.add(getLblNext());
			pnlBackground.add(getLblPrevious());
			pnlBackground.add(getBtnAceptar());
		}
		return pnlBackground;
	}

	private JLabel getLblSelect() {
		if (lblSelect == null) {
			lblSelect = new JLabel();
			lblSelect.setText("Select a piece for pawn promition");
			lblSelect.setBounds(0, 5, 224, 14);
			lblSelect.setHorizontalAlignment(SwingConstants.CENTER);
			lblSelect.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblSelect;
	}

	private JLabel getLblPiece() {
		if (lblPiece == null) {
			lblPiece = new JLabel();
			lblPiece.setBounds(76, 50, 60, 60);
			lblPiece.setBorder(BorderFactory.createTitledBorder(""));
			lblPiece.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblPiece;
	}

	private JLabel getLblNext() {
		if (lblNext == null) {
			lblNext = new JLabel();
			lblNext.setBounds(146, 55, 50, 50);
			lblNext.setIcon(new ImageIcon(PawnPromotionUI.class
					.getResource("/images/Chess/Forward.png")));
			lblNext.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lblNextMouseClicked(evt);
				}
			});
		}
		return lblNext;
	}

	private JLabel getLblPrevious() {
		if (lblPrevious == null) {
			lblPrevious = new JLabel();
			lblPrevious.setBounds(16, 55, 50, 50);
			lblPrevious.setIcon(new ImageIcon(PawnPromotionUI.class
					.getResource("/images/Chess/Backward.png")));
			lblPrevious.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lblPreviousMouseClicked(evt);
				}
			});
		}
		return lblPrevious;
	}

	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton();
			btnAceptar.setText("Aceptar");
			btnAceptar.setBounds(75, 129, 71, 23);
			btnAceptar.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnAceptarMouseClicked(evt);
				}
			});
		}
		return btnAceptar;
	}

	private void lblPreviousMouseClicked(MouseEvent evt) {
		if (player == Chess.Player.Black) {
			switch (selectedPiece) {
			case Chess.BLACK_QUEEN:
				lblPiece.setIcon(new ImageIcon(PawnPromotionUI.class
						.getResource("/images/Chess/Black R.png")));
				selectedPiece = Chess.BLACK_ROOK;
				break;
			case Chess.BLACK_KNIGHT:
				lblPiece.setIcon(new ImageIcon(PawnPromotionUI.class
						.getResource("/images/Chess/Black Q.png")));
				selectedPiece = Chess.BLACK_QUEEN;
				break;
			case Chess.BLACK_BISHOP:
				lblPiece.setIcon(new ImageIcon(PawnPromotionUI.class
						.getResource("/images/Chess/Black N.png")));
				selectedPiece = Chess.BLACK_KNIGHT;
				break;
			case Chess.BLACK_ROOK:
				lblPiece.setIcon(new ImageIcon(PawnPromotionUI.class
						.getResource("/images/Chess/Black B.png")));
				selectedPiece = Chess.BLACK_BISHOP;
				break;
			}
		} else {
			switch (selectedPiece) {
			case Chess.WHITE_QUEEN:
				lblPiece.setIcon(new ImageIcon(PawnPromotionUI.class
						.getResource("/images/Chess/White R.png")));
				selectedPiece = Chess.WHITE_ROOK;
				break;
			case Chess.WHITE_KNIGHT:
				lblPiece.setIcon(new ImageIcon(PawnPromotionUI.class
						.getResource("/images/Chess/White Q.png")));
				selectedPiece = Chess.WHITE_QUEEN;
				break;
			case Chess.WHITE_BISHOP:
				lblPiece.setIcon(new ImageIcon(PawnPromotionUI.class
						.getResource("/images/Chess/White N.png")));
				selectedPiece = Chess.WHITE_KNIGHT;
				break;
			case Chess.WHITE_ROOK:
				lblPiece.setIcon(new ImageIcon(PawnPromotionUI.class
						.getResource("/images/Chess/White B.png")));
				selectedPiece = Chess.WHITE_BISHOP;
				break;
			}
		}
	}

	private void lblNextMouseClicked(MouseEvent evt) {
		if (player == Chess.Player.Black) {
			switch (selectedPiece) {
			case Chess.BLACK_QUEEN:
				lblPiece.setIcon(new ImageIcon(PawnPromotionUI.class
						.getResource("/images/Chess/Black N.png")));
				selectedPiece = Chess.BLACK_KNIGHT;
				break;
			case Chess.BLACK_KNIGHT:
				lblPiece.setIcon(new ImageIcon(PawnPromotionUI.class
						.getResource("/images/Chess/Black B.png")));
				selectedPiece = Chess.BLACK_BISHOP;
				break;
			case Chess.BLACK_BISHOP:
				lblPiece.setIcon(new ImageIcon(PawnPromotionUI.class
						.getResource("/images/Chess/Black R.png")));
				selectedPiece = Chess.BLACK_ROOK;
				break;
			case Chess.BLACK_ROOK:
				lblPiece.setIcon(new ImageIcon(PawnPromotionUI.class
						.getResource("/images/Chess/Black Q.png")));
				selectedPiece = Chess.BLACK_QUEEN;
				break;
			}
		} else {
			switch (selectedPiece) {
			case Chess.WHITE_QUEEN:
				lblPiece.setIcon(new ImageIcon(PawnPromotionUI.class
						.getResource("/images/Chess/White N.png")));
				selectedPiece = Chess.WHITE_KNIGHT;
				break;
			case Chess.WHITE_KNIGHT:
				lblPiece.setIcon(new ImageIcon(PawnPromotionUI.class
						.getResource("/images/Chess/White B.png")));
				selectedPiece = Chess.WHITE_BISHOP;
				break;
			case Chess.WHITE_BISHOP:
				lblPiece.setIcon(new ImageIcon(PawnPromotionUI.class
						.getResource("/images/Chess/White R.png")));
				selectedPiece = Chess.WHITE_ROOK;
				break;
			case Chess.WHITE_ROOK:
				lblPiece.setIcon(new ImageIcon(PawnPromotionUI.class
						.getResource("/images/Chess/White Q.png")));
				selectedPiece = Chess.WHITE_QUEEN;
				break;
			}
		}
	}

	private void btnAceptarMouseClicked(MouseEvent evt) {
		parent.setEnabled(true);
		dispose();
		parent.promotePawn(selectedPiece);
	}

}
