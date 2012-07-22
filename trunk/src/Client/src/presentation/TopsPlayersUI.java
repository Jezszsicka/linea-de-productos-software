package presentation;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class TopsPlayersUI extends javax.swing.JFrame {
	private JPanel pnlBackground;
	private JButton btnClose;

	/**
	 * Auto-generated main method to display this JFrame
	 */

	public TopsPlayersUI() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().add(getPnlBackground(), BorderLayout.CENTER);
			this.setSize(800, 600);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private JPanel getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setLayout(null);
			pnlBackground.add(getBtnClose());
		}
		return pnlBackground;
	}

	private JButton getBtnClose() {
		if (btnClose == null) {
			btnClose = new JButton();
			btnClose.setText("Close");
			btnClose.setBounds(696, 528, 67, 23);
		}
		return btnClose;
	}

}
