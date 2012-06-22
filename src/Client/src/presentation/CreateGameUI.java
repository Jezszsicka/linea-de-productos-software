package presentation;

import java.awt.BorderLayout;
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
	private JLabel jLabel1;
	private JPanel jPanel1;
	private JPanel pnlCheckers;
	private JLabel lblIconCheckers;
	private JLabel lblCheckers;
	private JLabel lblCheckersPlayers;
	private JButton btnCancel;
	private JLabel lblGame;
	private JTextField txtGameName;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel lblGameTitle;
	private JLabel lblDescription;
	private JPanel pnlGameSelection;
	private JLabel lblGamePlayers;
	private JTextPane txtGameDescription;
	private JLabel lblPlayers;
	private JPanel pnlGame;
	private JLabel lblGameImage;
	private JLabel lblGameName;
	private JButton btnCreate;

	public CreateGameUI() {
		super();
		initGUI();
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private void initGUI() {
		try {
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
		BorderLayout thisLayout = new BorderLayout();
		getContentPane().setLayout(thisLayout);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				thisWindowClosing(evt);
			}
		});
		this.setSize(576, 467);
		getContentPane().add(getPnlBackground(), BorderLayout.CENTER);
	}

	private JPanel getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setBounds(0, 0, 415, 134);
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
			btnCreate.setBounds(450, 346, 95, 23);
			btnCreate.setFocusable(false);
			btnCreate.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnCreateMouseClicked(evt);
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
			txtGameName.setBounds(101, 13, 141, 20);
		}
		return txtGameName;
	}

	private JLabel getLblGame() {
		if (lblGame == null) {
			lblGame = new JLabel();
			lblGame.setText("Games");
			lblGame.setBounds(0, 72, 73, 20);
			lblGame.setHorizontalTextPosition(SwingConstants.CENTER);
			lblGame.setHorizontalAlignment(SwingConstants.CENTER);
			lblGame.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblGame;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.setBounds(450, 380, 95, 23);
			btnCancel.setText("Cancel");
			btnCancel.setFocusable(false);
			btnCancel.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnCancelMouseClicked(evt);
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
			lblIconCheckers.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/checkers_small_icon.png")));
		}
		return lblIconCheckers;
	}

	private JPanel getPnlCheckers() {
		if (pnlCheckers == null) {
			pnlCheckers = new JPanel();
			pnlCheckers.setLayout(null);
			pnlCheckers.setBounds(10, 98, 230, 38);
			pnlCheckers.setSize(230, 40);
			pnlCheckers.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					pnlCheckersMouseClicked(evt);
				}
			});
			pnlCheckers.add(getLblIconCheckers());
			pnlCheckers.add(getLblCheckers());
			pnlCheckers.add(getLblCheckersPlayers());
		}
		return pnlCheckers;
	}

	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
			jPanel1.setBounds(12, 142, 230, 32);
			jPanel1.setSize(230, 40);
			jPanel1.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					jPanel1MouseClicked(evt);
				}
			});
			jPanel1.add(getJLabel1());
			jPanel1.add(getJLabel2());
			jPanel1.add(getJLabel3());
		}
		return jPanel1;
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/trivial_small_icon.png")));
			jLabel1.setBounds(153, 6, 25, 25);
		}
		return jLabel1;
	}

	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Trivial");
			jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
			jLabel2.setBounds(67, 6, 58, 25);
		}
		return jLabel2;
	}

	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("8");
			jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
			jLabel3.setBounds(10, 6, 21, 25);
		}
		return jLabel3;
	}

	private JLabel getLblGameImage() {
		if (lblGameImage == null) {
			lblGameImage = new JLabel();
			lblGameImage.setBounds(2, 36, 254, 60);
			lblGameImage.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/3D_Checkers_icon.png")));
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
			pnlGame.setBounds(292, 21, 258, 295);
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
			txtGameDescription.setBounds(12, 178, 234, 108);
			txtGameDescription.setEditable(false);
			txtGameDescription.setBackground(new java.awt.Color(240, 240, 240));
			txtGameDescription.setFocusable(false);
		}
		return txtGameDescription;
	}

	private JLabel getLblGamePlayers() {
		if (lblGamePlayers == null) {
			lblGamePlayers = new JLabel();
			lblGamePlayers.setText("Dos jugadores");
			lblGamePlayers.setBounds(85, 129, 161, 18);
		}
		return lblGamePlayers;
	}

	private JPanel getPnlGameSelection() {
		if (pnlGameSelection == null) {
			pnlGameSelection = new JPanel();
			pnlGameSelection.setLayout(null);
			pnlGameSelection.setBounds(10, 21, 265, 295);
			pnlGameSelection.setBorder(BorderFactory.createTitledBorder(""));
			pnlGameSelection.add(getJPanel1());
			pnlGameSelection.add(getPnlCheckers());
			pnlGameSelection.add(getLblGame());
			pnlGameSelection.add(getTxtGameName());
			pnlGameSelection.add(getLblGameName());
		}
		return pnlGameSelection;
	}

	private void thisWindowClosing(WindowEvent evt) {
		Controller.getInstance().closeCreateGameUI();
	}

	private void btnCreateMouseClicked(MouseEvent evt) {
		Controller.getInstance().createGame(txtGameName.getText(),
				GameType.Checkers);
	}

	private void pnlCheckersMouseClicked(MouseEvent evt) {
		lblGameTitle.setText("Damas");
		txtGameDescription.setText("Las damas es un juego de mesa para dos contrincantes. El juego consiste en mover las piezas en diagonal a través de los cuadros negros de un tablero de ajedrez con la intención de capturar (comer) las piezas del contrario saltando por encima de ellas.");
		lblGameImage.setIcon(new ImageIcon(getClass().getClassLoader()
				.getResource("images/3D_Checkers_icon.png")));
	}
	
	private void jPanel1MouseClicked(MouseEvent evt) {
		lblGameTitle.setText("Trivial");
		txtGameDescription.setText("El trivial es un juego de mesa para dos contrincantes. El juego consiste en mover las piezas en diagonal a través de los cuadros negros de un tablero de ajedrez con la intención de capturar (comer) las piezas del contrario saltando por encima de ellas.");
		lblGameImage.setIcon(new ImageIcon(getClass().getClassLoader()
				.getResource("images/trivial_icon.png")));
	}

}