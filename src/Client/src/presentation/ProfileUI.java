package presentation;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import ProductLine.GameType;
import ProductLine.Ranking;
import ProductLine.User;
import domain.Controller;

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
public class ProfileUI extends javax.swing.JFrame {

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static final int lblRankingWidth = 75;
	private static final int lblRankingHeight = 15;
	private JScrollPane rankingScroll;

	private JPanel pnlBackground;
	private JLabel lblRate;
	private JLabel lblPlayed;
	private JLabel lblLost;
	private JLabel lblWins;
	private JLabel lblGame;
	private JButton btnCancel;
	private JLabel lblAccount;
	private JLabel lblPassword;
	private JLabel lblUserPassword;
	private JButton btnChangeName;
	private JLabel lblUserNickname;
	private JLabel lblName;
	private JLabel lblUsername;
	private JLabel lblEmail;
	private JLabel lblUserEmail;
	private JLabel lblAccountInfo;
	private JPanel pnlRanking;
	private JButton btnChangeEmail;
	private JButton btnChangePassword;
	private JLabel lblAvatar;
	private JButton btnAvatar;
	private JLabel lblNickname;
	private JFrame changeFrame;

	private User user;

	public ProfileUI(User user) {
		super();
		this.user = user;
		initGUI();
		lblNickname.setText(user.getUsername());
		lblName.setText(user.getName()+" "+user.getLastName());
		lblEmail.setText(user.getEmail());
		lblAvatar.setIcon(new ImageIcon(user.getAvatar()));
		//TODO Borrar luego
		ArrayList<Ranking> rank = new ArrayList<Ranking>();
		rank.add(new Ranking(20,5,GameType.Checkers));
		user.setRankings(rank);
		loadRankings();
	}

	private void loadRankings() {
		for(int i = 0; i< user.getRankings().size();i++){
			Ranking ranking = user.getRankings().get(i);
			JLabel lblGame = new JLabel(ranking.getGame().toString());
			JLabel lblPlayed = new JLabel(String.valueOf(ranking.getWonGames()+ranking.getLostGames()));
			JLabel lblWon = new JLabel(String.valueOf(ranking.getWonGames()));
			JLabel lblLost = new JLabel(String.valueOf(ranking.getLostGames()));
			JLabel lblRate = new JLabel(String.valueOf(ranking.getWonGames()/Double.parseDouble(lblPlayed.getText())*100+" %"));
			lblGame.setBounds(0,25+i*lblRankingHeight,lblRankingWidth,lblRankingHeight);
			lblGame.setHorizontalTextPosition(SwingConstants.CENTER);
			lblGame.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlayed.setBounds(lblRankingWidth,25+i*lblRankingHeight,lblRankingWidth,lblRankingHeight);
			lblPlayed.setHorizontalTextPosition(SwingConstants.CENTER);
			lblPlayed.setHorizontalAlignment(SwingConstants.CENTER);
			lblWon.setBounds(2*lblRankingWidth,25+i*lblRankingHeight,lblRankingWidth,lblRankingHeight);
			lblWon.setHorizontalTextPosition(SwingConstants.CENTER);
			lblWon.setHorizontalAlignment(SwingConstants.CENTER);
			lblLost.setBounds(3*lblRankingWidth,25+i*lblRankingHeight,lblRankingWidth,lblRankingHeight);
			lblLost.setHorizontalTextPosition(SwingConstants.CENTER);
			lblLost.setHorizontalAlignment(SwingConstants.CENTER);
			lblRate.setBounds(4*lblRankingWidth,25+i*lblRankingHeight,lblRankingWidth,lblRankingHeight);
			lblRate.setHorizontalTextPosition(SwingConstants.CENTER);
			lblRate.setHorizontalAlignment(SwingConstants.CENTER);
			
			pnlRanking.add(lblGame);
			pnlRanking.add(lblPlayed);
			pnlRanking.add(lblWon);
			pnlRanking.add(lblLost);
			pnlRanking.add(lblRate);
		}
		
		
	}

	private void initGUI() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setSize(622, 478);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				thisWindowClosing(evt);
			}
		});
		getContentPane().add(getPnlBackground(), BorderLayout.CENTER);
	}

	private JPanel getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setLayout(null);
			pnlBackground.setBounds(0, 0, 606, 440);
			pnlBackground.add(getLblNickname());
			pnlBackground.add(getBtnAvatar());
			pnlBackground.add(getLblAvatar());
			pnlBackground.add(getBtnCancel());
			pnlBackground.add(getBtnChangePassword());
			pnlBackground.add(getBtnChangeEmail());
			pnlBackground.add(getJScrollPane1());
			pnlBackground.add(getLblAccountInfo());
			pnlBackground.add(getLblUserEmail());
			pnlBackground.add(getLblEmail());
			pnlBackground.add(getLblUsername());
			pnlBackground.add(getLblName());
			pnlBackground.add(getLblUserNickname());
			pnlBackground.add(getBtnChangeName());
			pnlBackground.add(getLblUserPassword());
			pnlBackground.add(getLblPassword());
			pnlBackground.add(getLblAccount());
		}
		return pnlBackground;
	}

	private JLabel getLblNickname() {
		if (lblNickname == null) {
			lblNickname = new JLabel();
			lblNickname.setBounds(248, 47, 175, 20);
			lblNickname.setHorizontalTextPosition(SwingConstants.CENTER);
			lblNickname.setHorizontalAlignment(SwingConstants.LEFT);
			lblNickname.setText("Juan");
		}
		return lblNickname;
	}

	private JButton getBtnAvatar() {
		if (btnAvatar == null) {
			btnAvatar = new JButton();
			btnAvatar.setText("Choose avatar");
			btnAvatar.setBounds(16, 175, 104, 23);
			btnAvatar.setFocusable(false);
			btnAvatar.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnAvatarMouseClicked(evt);
				}
			});
		}
		return btnAvatar;
	}

	private void btnAvatarMouseClicked(MouseEvent evt) {
		new ChooseAvatarUI(this);
		setEnabled(false);
	}

	private JLabel getLblAvatar() {
		if (lblAvatar == null) {
			lblAvatar = new JLabel();
			lblAvatar.setBounds(16, 47, 98, 117);
			lblAvatar.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
		}
		return lblAvatar;
	}

	private JLabel getLblAccount() {
		if (lblAccount == null) {
			lblAccount = new JLabel();
			lblAccount.setText("Ranking");
			lblAccount.setBounds(16, 246, 98, 14);
			lblAccount.setHorizontalTextPosition(SwingConstants.CENTER);
			lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
			lblAccount.setFont(new java.awt.Font("Tahoma",1,11));
		}
		return lblAccount;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton();
			btnCancel.setText("Back");
			btnCancel.setBounds(508, 406, 74, 23);
			btnCancel.setHorizontalTextPosition(SwingConstants.CENTER);
			btnCancel.setFocusable(false);
			btnCancel.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnCancelMouseClicked(evt);
				}
			});
		}
		return btnCancel;
	}

	private JLabel getLblGame() {
		if (lblGame == null) {
			lblGame = new JLabel();
			lblGame.setText("Game");
			lblGame.setBounds(0, 0, 75, 15);
			lblGame.setHorizontalTextPosition(SwingConstants.CENTER);
			lblGame.setHorizontalAlignment(SwingConstants.CENTER);
			lblGame.setFont(new java.awt.Font("Tahoma",3,11));
		}
		return lblGame;
	}

	private JLabel getLblWins() {
		if (lblWins == null) {
			lblWins = new JLabel();
			lblWins.setText("Wins");
			lblWins.setBounds(150, 0, 75, 15);
			lblWins.setHorizontalTextPosition(SwingConstants.CENTER);
			lblWins.setHorizontalAlignment(SwingConstants.CENTER);
			lblWins.setFont(new java.awt.Font("Tahoma",3,11));
		}
		return lblWins;
	}

	private JLabel getLblLost() {
		if (lblLost == null) {
			lblLost = new JLabel();
			lblLost.setText("Lost");
			lblLost.setBounds(225, 0, 75, 15);
			lblLost.setHorizontalTextPosition(SwingConstants.CENTER);
			lblLost.setHorizontalAlignment(SwingConstants.CENTER);
			lblLost.setFont(new java.awt.Font("Tahoma",3,11));
		}
		return lblLost;
	}

	private JLabel getLblPlayed() {
		if (lblPlayed == null) {
			lblPlayed = new JLabel();
			lblPlayed.setText("Played");
			lblPlayed.setBounds(75, 0, 75, 15);
			lblPlayed.setHorizontalTextPosition(SwingConstants.CENTER);
			lblPlayed.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlayed.setFont(new java.awt.Font("Tahoma",3,11));
		}
		return lblPlayed;
	}

	private JLabel getLblRate() {
		if (lblRate == null) {
			lblRate = new JLabel();
			lblRate.setText("Rate");
			lblRate.setBounds(300, 0, 75, 15);
			lblRate.setHorizontalTextPosition(SwingConstants.CENTER);
			lblRate.setHorizontalAlignment(SwingConstants.CENTER);
			lblRate.setFont(new java.awt.Font("Tahoma",3,11));
		}
		return lblRate;
	}

	public void setAvatar(File avatarFile) {
		byte [] avatar = null;
		try {
			avatar = Files.readAllBytes(avatarFile.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(avatar);
		Image image = icon.getImage().getScaledInstance(100,
				120, Image.SCALE_SMOOTH);
		ImageIcon imageIconResize = new ImageIcon (image);
		int resizeWidth = imageIconResize.getIconWidth();
		int resizeHeight = imageIconResize.getIconHeight();
		BufferedImage bi = new BufferedImage(resizeWidth, resizeHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = bi.createGraphics();
		g2d.drawImage(image, 0, 0, null);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.createImageOutputStream(baos); 
			ImageIO.write(bi, "JPG", baos);
			baos.flush();
			avatar = baos.toByteArray(); 
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Controller.getInstance().changeAvatar(avatar);
		lblAvatar.setIcon(new ImageIcon(user.getAvatar()));
	}

	private void btnCancelMouseClicked(MouseEvent evt) {
		dispose();
		Controller.getInstance().closeProfile();
	}

	private JButton getBtnChangePassword() {
		if (btnChangePassword == null) {
			btnChangePassword = new JButton();
			btnChangePassword.setText("Change password");
			btnChangePassword.setBounds(458, 114, 124, 23);
			btnChangePassword.setFocusable(false);
			btnChangePassword.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnChangePasswordMouseClicked(evt);
				}
			});
		}
		return btnChangePassword;
	}

	private JButton getBtnChangeEmail() {
		if (btnChangeEmail == null) {
			btnChangeEmail = new JButton();
			btnChangeEmail.setText("Change email");
			btnChangeEmail.setBounds(458, 148, 124, 23);
			btnChangeEmail.setFocusable(false);
			btnChangeEmail.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnChangeEmailMouseClicked(evt);
				}
			});
		}
		return btnChangeEmail;
	}

	private void thisWindowClosing(WindowEvent evt) {
		Controller.getInstance().closeProfile();
	}
	
	private JPanel getJPanel1() {
		if(pnlRanking == null) {
			pnlRanking = new JPanel();
			pnlRanking.setLayout(null);
			pnlRanking.setBounds(130, 269, 375, 126);
			pnlRanking.add(getLblRate());
			pnlRanking.add(getLblPlayed());
			pnlRanking.add(getLblLost());
			pnlRanking.add(getLblWins());
			pnlRanking.add(getLblGame());
		}
		return pnlRanking;
	}
	
	private JLabel getLblAccountInfo() {
		if(lblAccountInfo == null) {
			lblAccountInfo = new JLabel();
			lblAccountInfo.setText("Account Info");
			lblAccountInfo.setBounds(292, 11, 104, 14);
			lblAccountInfo.setFont(new java.awt.Font("Tahoma",1,11));
			lblAccountInfo.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblAccountInfo;
	}
	
	private JLabel getLblUserEmail() {
		if(lblUserEmail == null) {
			lblUserEmail = new JLabel();
			lblUserEmail.setText("Email");
			lblUserEmail.setBounds(164, 148, 63, 17);
			lblUserEmail.setFont(new java.awt.Font("Tahoma",1,11));
		}
		return lblUserEmail;
	}
	
	private JLabel getLblEmail() {
		if(lblEmail == null) {
			lblEmail = new JLabel();
			lblEmail.setBounds(248, 146, 175, 20);
			lblEmail.setText("juanyanezgc");
		}
		return lblEmail;
	}
	
	private JLabel getLblUsername() {
		if(lblUsername == null) {
			lblUsername = new JLabel();
			lblUsername.setText("Name");
			lblUsername.setBounds(164, 78, 63, 23);
			lblUsername.setFont(new java.awt.Font("Tahoma",1,11));
		}
		return lblUsername;
	}
	
	private JLabel getLblName() {
		if(lblName == null) {
			lblName = new JLabel();
			lblName.setText("Juan Yáñez García-Catalán");
			lblName.setBounds(248, 78, 175, 23);
		}
		return lblName;
	}
	
	private JLabel getLblUserNickname() {
		if(lblUserNickname == null) {
			lblUserNickname = new JLabel();
			lblUserNickname.setText("Nickname");
			lblUserNickname.setBounds(164, 47, 63, 20);
			lblUserNickname.setFont(new java.awt.Font("Tahoma",1,11));
		}
		return lblUserNickname;
	}
	
	private void btnChangePasswordMouseClicked(MouseEvent evt) {
		changeFrame = new ChangePasswordUI(this);
		setEnabled(false);
	}
	
	private JButton getBtnChangeName() {
		if(btnChangeName == null) {
			btnChangeName = new JButton();
			btnChangeName.setText("Change name");
			btnChangeName.setBounds(458, 80, 124, 23);
			btnChangeName.setFocusable(false);
			btnChangeName.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnChangeNameMouseClicked(evt);
				}
			});
		}
		return btnChangeName;
	}
	
	private JLabel getLblUserPassword() {
		if(lblUserPassword == null) {
			lblUserPassword = new JLabel();
			lblUserPassword.setText("Password");
			lblUserPassword.setBounds(164, 112, 63, 20);
			lblUserPassword.setFont(new java.awt.Font("Tahoma",1,11));
		}
		return lblUserPassword;
	}
	
	private JLabel getLblPassword() {
		if(lblPassword == null) {
			lblPassword = new JLabel();
			lblPassword.setText("********");
			lblPassword.setBounds(248, 115, 175, 20);
		}
		return lblPassword;
	}
	
	private void btnChangeNameMouseClicked(MouseEvent evt) {
		changeFrame = new ChangeNameUI(this,user.getName(),user.getLastName());
		setEnabled(false);
	}

	public void refreshName() {
		lblName.setText(user.getName()+" "+user.getLastName());
		setEnabled(true);
		toFront();
	}
	
	private void btnChangeEmailMouseClicked(MouseEvent evt) {
		changeFrame = new ChangeEmailUI(this,user.getEmail());
		setEnabled(true);
	}
	
	public void closeChangeFrame(){
		changeFrame.dispose();
		setEnabled(true);
	}
	
	private JScrollPane getJScrollPane1() {
		if(rankingScroll == null) {
			rankingScroll = new JScrollPane();
			rankingScroll.setBounds(130, 269, 375, 126);
			rankingScroll.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			rankingScroll.setViewportView(getJPanel1());
		}
		return rankingScroll;
	}

}
