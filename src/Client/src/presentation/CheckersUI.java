package presentation;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

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
public class CheckersUI extends javax.swing.JFrame {
	private JPanel pnlBackground;
	private JLabel lblAvatarRed;
	private JPanel pnlBoard;
	private JLabel lblAvatarBlack;

	public CheckersUI() {
		super();
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getPnlBackground());
		pack();
		this.setSize(653, 495);
	}

	private JPanel getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setLayout(null);
			pnlBackground.setBounds(0, 0, 637, 457);
			pnlBackground.add(getLblAvatarBlack());
			pnlBackground.add(getLblAvatarRed());
			pnlBackground.add(getPnlBoard());
		}
		return pnlBackground;
	}

	private JLabel getLblAvatarBlack() {
		if (lblAvatarBlack == null) {
			lblAvatarBlack = new JLabel();
			lblAvatarBlack.setBounds(511, 22, 101, 123);
			lblAvatarBlack.setBorder(new SoftBevelBorder(BevelBorder.LOWERED,
					null, null, null, null));
		}
		return lblAvatarBlack;
	}

	private JLabel getLblAvatarRed() {
		if (lblAvatarRed == null) {
			lblAvatarRed = new JLabel();
			lblAvatarRed.setBounds(511, 325, 101, 121);
			lblAvatarRed.setBorder(new SoftBevelBorder(BevelBorder.LOWERED,
					null, null, null, null));
		}
		return lblAvatarRed;
	}

	private JPanel getPnlBoard() {
		if (pnlBoard == null) {
			pnlBoard = new JPanel();
			pnlBoard.setLayout(null);
			pnlBoard.setBounds(10, 22, 486, 271);
			pnlBoard.setBorder(BorderFactory.createTitledBorder(""));
		}
		return pnlBoard;
	}

}
