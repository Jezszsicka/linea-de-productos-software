package presentation;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WaitingRoomUI extends javax.swing.JFrame {
	private WaitingRoomController controller;
	private JPanel pnlBackground;
	private JButton btnSend;

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WaitingRoomUI() {
		super();
		initGUI();
	}

	public WaitingRoomUI(WaitingRoomController waitingRoomController) {
		super();
		this.controller = waitingRoomController;
		initGUI();
	}

	private void initGUI() {
		setBounds(new Rectangle(0, 0, 500, 500));
		getContentPane().setLayout(null);
		getContentPane().add(getPnlBackground());
	}

	private JPanel getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setBounds(0, 0, 684, 462);
			pnlBackground.setLayout(null);
			pnlBackground.add(getBtnSend());
		}
		return pnlBackground;
	}

	private JButton getBtnSend() {
		if (btnSend == null) {
			btnSend = new JButton("Send");
			btnSend.setBounds(152, 389, 89, 23);
		}
		return btnSend;
	}
}
