package presentation;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ProductLine.GameType;
import domain.Controller;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
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
	private JButton btnCancel;
	private JComboBox<GameType> lstGames;
	private JLabel lblGame;
	private JTextField txtGameName;
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
		getContentPane().setLayout(null);
		this.setSize(431, 172);
		getContentPane().add(getPnlBackground());
	}

	private JPanel getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setBounds(0, 0, 415, 134);
			pnlBackground.setLayout(null);
			pnlBackground.add(getLblGameName());
			pnlBackground.add(getTxtGameName());
			pnlBackground.add(getLblGame());
			pnlBackground.add(getLstGames());
			pnlBackground.add(getBtnCreate());
			pnlBackground.add(getBtnCancel());
		}
		return pnlBackground;
	}
	
	private JButton getBtnCreate() {
		if(btnCreate == null) {
			btnCreate = new JButton();
			btnCreate.setText("Create game");
			btnCreate.setBounds(17, 96, 95, 23);
		}
		return btnCreate;
	}
	
	private JLabel getLblGameName() {
		if(lblGameName == null) {
			lblGameName = new JLabel();
			lblGameName.setText("Name");
			lblGameName.setBounds(23, 50, 33, 14);
			lblGameName.setHorizontalAlignment(SwingConstants.CENTER);
			lblGameName.setHorizontalTextPosition(SwingConstants.CENTER);
		}
		return lblGameName;
	}
	
	private JTextField getTxtGameName() {
		if(txtGameName == null) {
			txtGameName = new JTextField();
			txtGameName.setBounds(143, 47, 114, 20);
		}
		return txtGameName;
	}
	
	private JLabel getLblGame() {
		if(lblGame == null) {
			lblGame = new JLabel();
			lblGame.setText("Game");
			lblGame.setBounds(23, 19, 33, 14);
			lblGame.setHorizontalTextPosition(SwingConstants.CENTER);
			lblGame.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblGame;
	}
	
	private JComboBox<GameType> getLstGames() {
		if(lstGames == null) {
			ComboBoxModel<GameType> lstGamesModel = 
					new DefaultComboBoxModel<GameType>(
							GameType.values());
			lstGames = new JComboBox<GameType>();
			lstGames.setModel(lstGamesModel);
			lstGames.setBounds(143, 16, 114, 20);
		}
		return lstGames;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.setBounds(285, 96, 89, 23);
			btnCancel.setText("Cancel");
			btnCancel.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnCancelMouseClicked(evt);
				}
			});
		}
		return btnCancel;
	}
	
	private void btnCancelMouseClicked(MouseEvent evt) {
		Controller.getInstance().cancelCreateGame();
	}

}
