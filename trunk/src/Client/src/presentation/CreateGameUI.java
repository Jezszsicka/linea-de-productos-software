package presentation;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import domain.Facade;
import domain.GamesManager;

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
	private JButton btnCancel;

	public CreateGameUI() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
		getContentPane().setLayout(null);
		getContentPane().add(getPnlBackground());
	}

	private JPanel getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setBounds(0, 0, 434, 262);
			pnlBackground.setLayout(null);
			pnlBackground.add(getBtnCancel());
		}
		return pnlBackground;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					do_btnCancel_mouseClicked(arg0);
				}
			});
			btnCancel.setBounds(284, 205, 89, 23);
		}
		return btnCancel;
	}

	protected void do_btnCancel_mouseClicked(MouseEvent arg0) {
		Facade.getInstance().cancelCreateGame();
	}
}
