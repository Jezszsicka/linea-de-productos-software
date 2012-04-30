package presentation;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import ProductLine.User;

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
public class ProfileUI extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JPanel pnlBackground;
	private JLabel lblRate;
	private JLabel lblPlayed;
	private JLabel lblLost;
	private JLabel lblWins;
	private JLabel lblGame;
	private JButton btnCancel;
	private JLabel lblAccount;
	private JButton btnChangeEmail;
	private JButton btnChangePassword;
	private JLabel lblAvatar;
	private JButton btnAvatar;
	private JLabel lblUser;
	private JButton btnSave;

	private User user;
		
	public ProfileUI(User user) {
		super();
		this.user = user;
		initGUI();
	}
	
	private void initGUI() {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setSize(591, 478);
			setLocationRelativeTo(null);
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			setVisible(true);
			getContentPane().add(getPnlBackground(), BorderLayout.CENTER);
	}
	
	private JPanel getPnlBackground() {
		if(pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setLayout(null);
			pnlBackground.setBounds(0, 0, 575, 440);
			pnlBackground.add(getBtnSave());
			pnlBackground.add(getLblUser());
			pnlBackground.add(getBtnAvatar());
			pnlBackground.add(getLblAvatar());
			pnlBackground.add(getLblAccount());
			pnlBackground.add(getBtnCancel());
			pnlBackground.add(getLblGame());
			pnlBackground.add(getLblWins());
			pnlBackground.add(getLblLost());
			pnlBackground.add(getLblPlayed());
			pnlBackground.add(getLblRate());
			pnlBackground.add(getBtnChangePassword());
			pnlBackground.add(getBtnChangeEmail());
		}
		return pnlBackground;
	}
	
	private JButton getBtnSave() {
		if(btnSave == null) {
			btnSave = new JButton();
			btnSave.setText("Save");
			btnSave.setBounds(375, 402, 73, 23);
			btnSave.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnSaveMouseClicked(evt);
				}
			});
		}
		return btnSave;
	}
	
	private JLabel getLblUser() {
		if(lblUser == null) {
			lblUser = new JLabel();
			lblUser.setBounds(28, 11, 72, 15);
			lblUser.setHorizontalTextPosition(SwingConstants.CENTER);
			lblUser.setHorizontalAlignment(SwingConstants.CENTER);
			lblUser.setText(user.getUsername());
		}
		return lblUser;
	}
	
	private JButton getBtnAvatar() {
		if(btnAvatar == null) {
			btnAvatar = new JButton();
			btnAvatar.setText("Choose avatar");
			btnAvatar.setBounds(18, 197, 104, 23);
			btnAvatar.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnAvatarMouseClicked(evt);
				}
			});
		}
		return btnAvatar;
	}
	
	private void btnAvatarMouseClicked(MouseEvent evt) {
		new AvatarList(this);
		setEnabled(false);
	}
	
	private JLabel getLblAvatar() {
		if(lblAvatar == null) {
			lblAvatar = new JLabel();
			lblAvatar.setBounds(18, 57, 104, 117);
			lblAvatar.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("1.jpg")));
		}
		return lblAvatar;
	}
	
	private JLabel getLblAccount() {
		if(lblAccount == null) {
			lblAccount = new JLabel();
			lblAccount.setText("Ranking");
			lblAccount.setBounds(285, 11, 69, 14);
			lblAccount.setHorizontalTextPosition(SwingConstants.CENTER);
			lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblAccount;
	}
	
	private JButton getBtnCancel() {
		if(btnCancel == null) {
			btnCancel = new JButton();
			btnCancel.setText("Cancel");
			btnCancel.setBounds(477, 402, 74, 23);
			btnCancel.setHorizontalTextPosition(SwingConstants.CENTER);
			btnCancel.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnCancelMouseClicked(evt);
				}
			});
		}
		return btnCancel;
	}
	
	private JLabel getLblGame() {
		if(lblGame == null) {
			lblGame = new JLabel();
			lblGame.setText("Game");
			lblGame.setBounds(181, 57, 39, 14);
			lblGame.setHorizontalTextPosition(SwingConstants.CENTER);
			lblGame.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblGame;
	}
	
	private JLabel getLblWins() {
		if(lblWins == null) {
			lblWins = new JLabel();
			lblWins.setText("Wins");
			lblWins.setBounds(327, 57, 39, 14);
			lblWins.setHorizontalTextPosition(SwingConstants.CENTER);
			lblWins.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblWins;
	}
	
	private JLabel getLblLost() {
		if(lblLost == null) {
			lblLost = new JLabel();
			lblLost.setText("Lost");
			lblLost.setBounds(394, 57, 39, 14);
			lblLost.setHorizontalTextPosition(SwingConstants.CENTER);
			lblLost.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblLost;
	}
	
	private JLabel getLblPlayed() {
		if(lblPlayed == null) {
			lblPlayed = new JLabel();
			lblPlayed.setText("Played");
			lblPlayed.setBounds(259, 57, 39, 14);
			lblPlayed.setHorizontalTextPosition(SwingConstants.CENTER);
			lblPlayed.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblPlayed;
	}
	
	private JLabel getLblRate() {
		if(lblRate == null) {
			lblRate = new JLabel();
			lblRate.setText("Rate");
			lblRate.setBounds(462, 57, 39, 14);
			lblRate.setHorizontalTextPosition(SwingConstants.CENTER);
			lblRate.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblRate;
	}

	public void setAvatar(int avatar) {
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(avatar+".jpg"));	
		lblAvatar.setIcon(icon);
	}
	
	private void btnCancelMouseClicked(MouseEvent evt) {
		dispose();
		Controller.getInstance().closeProfile(false);
	}
	
	private void btnSaveMouseClicked(MouseEvent evt) {
		dispose();
		Controller.getInstance().closeProfile(true);
	}
	
	private JButton getBtnChangePassword() {
		if(btnChangePassword == null) {
			btnChangePassword = new JButton();
			btnChangePassword.setText("Change password");
			btnChangePassword.setBounds(18, 278, 124, 23);
		}
		return btnChangePassword;
	}
	
	private JButton getBtnChangeEmail() {
		if(btnChangeEmail == null) {
			btnChangeEmail = new JButton();
			btnChangeEmail.setText("Change email");
			btnChangeEmail.setBounds(18, 312, 124, 23);
		}
		return btnChangeEmail;
	}

}
