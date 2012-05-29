package presentation;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import domain.LanguageManager;

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
	private JComboBox<String> lstLanguages;
	private JLabel lblLanguage;

	private JPanel pnlBackground;
	private JLabel lblRate;
	private JLabel lblPlayed;
	private JLabel lblLost;
	private JLabel lblWins;
	private JLabel lblGame;
	private JButton btnBack;
	private JLabel lblRanking;
	private JLabel lblPassword;
	private JLabel lblUserPassword;
	private JButton btnChangeName;
	private JLabel lblUserNickname;
	private JLabel lblName;
	private JLabel lblUserName;
	private JLabel lblEmail;
	private JLabel lblUserEmail;
	private JLabel lblAccount;
	private JPanel pnlRanking;
	private JButton btnChangeEmail;
	private JButton btnChangePassword;
	private JLabel lblAvatar;
	private JButton btnAvatar;
	private JLabel lblNickname;
	private JFrame changeFrame;

	private LanguageManager language;
	private User user;

	public ProfileUI(User user) {
		super();
		this.language = LanguageManager.language();
		this.user = user;
		initGUI();
		lblNickname.setText(user.getUsername());
		lblName.setText(user.getName() + " " + user.getLastName());
		lblEmail.setText(user.getEmail());
		lblAvatar.setIcon(new ImageIcon(user.getAvatar()));
		lstLanguages.setSelectedIndex(language.getLanguageCode());
		// TODO Borrar luego, cuando se recojan los rankings de la base de datos
		ArrayList<Ranking> rank = new ArrayList<Ranking>();
		rank.add(new Ranking(20, 5, GameType.Checkers));
		user.setRankings(rank);
		loadRankings();
	}

	private void loadRankings() {
		for (int i = 0; i < user.getRankings().size(); i++) {
			Ranking ranking = user.getRankings().get(i);
			JLabel lblGame = new JLabel(ranking.getGame().toString());
			JLabel lblPlayed = new JLabel(String.valueOf(ranking.getWonGames()
					+ ranking.getLostGames()));
			JLabel lblWon = new JLabel(String.valueOf(ranking.getWonGames()));
			JLabel lblLost = new JLabel(String.valueOf(ranking.getLostGames()));
			JLabel lblRate = new JLabel(String.valueOf(ranking.getWonGames()
					/ Double.parseDouble(lblPlayed.getText()) * 100 + " %"));
			lblGame.setBounds(0, 25 + i * lblRankingHeight, lblRankingWidth,
					lblRankingHeight);
			lblGame.setHorizontalTextPosition(SwingConstants.CENTER);
			lblGame.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlayed.setBounds(lblRankingWidth, 25 + i * lblRankingHeight,
					lblRankingWidth, lblRankingHeight);
			lblPlayed.setHorizontalTextPosition(SwingConstants.CENTER);
			lblPlayed.setHorizontalAlignment(SwingConstants.CENTER);
			lblWon.setBounds(2 * lblRankingWidth, 25 + i * lblRankingHeight,
					lblRankingWidth, lblRankingHeight);
			lblWon.setHorizontalTextPosition(SwingConstants.CENTER);
			lblWon.setHorizontalAlignment(SwingConstants.CENTER);
			lblLost.setBounds(3 * lblRankingWidth, 25 + i * lblRankingHeight,
					lblRankingWidth, lblRankingHeight);
			lblLost.setHorizontalTextPosition(SwingConstants.CENTER);
			lblLost.setHorizontalAlignment(SwingConstants.CENTER);
			lblRate.setBounds(4 * lblRankingWidth, 25 + i * lblRankingHeight,
					lblRankingWidth, lblRankingHeight);
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
			pnlBackground.add(getBtnBack());
			pnlBackground.add(getBtnChangePassword());
			pnlBackground.add(getBtnChangeEmail());
			pnlBackground.add(getJScrollPane1());
			pnlBackground.add(getLblAccount());
			pnlBackground.add(getLblUserEmail());
			pnlBackground.add(getLblEmail());
			pnlBackground.add(getLblUserName());
			pnlBackground.add(getLblName());
			pnlBackground.add(getLblUserNickname());
			pnlBackground.add(getBtnChangeName());
			pnlBackground.add(getLblUserPassword());
			pnlBackground.add(getLblPassword());
			pnlBackground.add(getLblRanking());
			pnlBackground.add(getLblLanguage());
			pnlBackground.add(getLstLanguages());
		}
		return pnlBackground;
	}

	private JLabel getLblNickname() {
		if (lblNickname == null) {
			lblNickname = new JLabel();
			lblNickname.setBounds(264, 47, 159, 20);
			lblNickname.setHorizontalTextPosition(SwingConstants.CENTER);
			lblNickname.setHorizontalAlignment(SwingConstants.LEFT);
			lblNickname.setText("Juan");
		}
		return lblNickname;
	}

	private JButton getBtnAvatar() {
		if (btnAvatar == null) {
			btnAvatar = new JButton("Seleccionar avatar");
			btnAvatar.setText(language.getString("btnSelectAvatar"));
			btnAvatar.setBounds(10, 170, 114, 23);
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

	private JLabel getLblRanking() {
		if (lblRanking == null) {
			lblRanking = new JLabel("Ranking");
			lblRanking.setText(language.getString("lblRanking"));
			lblRanking.setBounds(16, 246, 98, 14);
			lblRanking.setHorizontalTextPosition(SwingConstants.CENTER);
			lblRanking.setHorizontalAlignment(SwingConstants.CENTER);
			lblRanking.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblRanking;
	}

	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Volver");
			btnBack.setText(language.getString("btnBack"));
			btnBack.setBounds(508, 406, 74, 23);
			btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
			btnBack.setFocusable(false);
			btnBack.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnBackMouseClicked(evt);
				}
			});
		}
		return btnBack;
	}

	private JLabel getLblGame() {
		if (lblGame == null) {
			lblGame = new JLabel("Juego");
			lblGame.setText(language.getString("lblGame"));
			lblGame.setBounds(0, 0, 75, 15);
			lblGame.setHorizontalTextPosition(SwingConstants.CENTER);
			lblGame.setHorizontalAlignment(SwingConstants.CENTER);
			lblGame.setFont(new java.awt.Font("Tahoma", 3, 11));
		}
		return lblGame;
	}

	private JLabel getLblWins() {
		if (lblWins == null) {
			lblWins = new JLabel("Ganadas");
			lblWins.setText(language.getString("lblWins"));
			lblWins.setBounds(150, 0, 75, 15);
			lblWins.setHorizontalTextPosition(SwingConstants.CENTER);
			lblWins.setHorizontalAlignment(SwingConstants.CENTER);
			lblWins.setFont(new java.awt.Font("Tahoma", 3, 11));
		}
		return lblWins;
	}

	private JLabel getLblLost() {
		if (lblLost == null) {
			lblLost = new JLabel("Perdidas");
			lblLost.setText(language.getString("lblLost"));
			lblLost.setBounds(225, 0, 75, 15);
			lblLost.setHorizontalTextPosition(SwingConstants.CENTER);
			lblLost.setHorizontalAlignment(SwingConstants.CENTER);
			lblLost.setFont(new java.awt.Font("Tahoma", 3, 11));
		}
		return lblLost;
	}

	private JLabel getLblPlayed() {
		if (lblPlayed == null) {
			lblPlayed = new JLabel("Jugadas");
			lblPlayed.setText(language.getString("lblPlayed"));
			lblPlayed.setBounds(75, 0, 75, 15);
			lblPlayed.setHorizontalTextPosition(SwingConstants.CENTER);
			lblPlayed.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlayed.setFont(new java.awt.Font("Tahoma", 3, 11));
		}
		return lblPlayed;
	}

	private JLabel getLblRate() {
		if (lblRate == null) {
			lblRate = new JLabel("Ratio");
			lblRate.setText(language.getString("lblRate"));
			lblRate.setBounds(300, 0, 75, 15);
			lblRate.setHorizontalTextPosition(SwingConstants.CENTER);
			lblRate.setHorizontalAlignment(SwingConstants.CENTER);
			lblRate.setFont(new java.awt.Font("Tahoma", 3, 11));
		}
		return lblRate;
	}

	public void setAvatar(File avatarFile) {
		byte[] avatar = null;
		try {
			avatar = Files.readAllBytes(avatarFile.toPath());
			ImageIcon icon = new ImageIcon(avatar);
			Image image = icon.getImage().getScaledInstance(100, 120,
					Image.SCALE_SMOOTH);
			ImageIcon imageIconResize = new ImageIcon(image);
			int resizeWidth = imageIconResize.getIconWidth();
			int resizeHeight = imageIconResize.getIconHeight();
			BufferedImage bi = new BufferedImage(resizeWidth, resizeHeight,
					BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = bi.createGraphics();
			g2d.drawImage(image, 0, 0, null);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.createImageOutputStream(baos);
			ImageIO.write(bi, "JPG", baos);
			baos.flush();
			avatar = baos.toByteArray();
			baos.close();
			Controller.getInstance().changeAvatar(avatar);
			lblAvatar.setIcon(new ImageIcon(user.getAvatar()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void btnBackMouseClicked(MouseEvent evt) {
		dispose();
		Controller.getInstance().closeProfileUI();
	}

	private JButton getBtnChangePassword() {
		if (btnChangePassword == null) {
			btnChangePassword = new JButton(language.getString("btnChangePassword"));
			btnChangePassword.setBounds(458, 114, 138, 23);
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
			btnChangeEmail = new JButton(language.getString("btnChangeEmail"));
			btnChangeEmail.setBounds(458, 148, 138, 23);
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
		Controller.getInstance().closeProfileUI();
	}

	private JPanel getJPanel1() {
		if (pnlRanking == null) {
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

	private JLabel getLblAccount() {
		if (lblAccount == null) {
			lblAccount = new JLabel("Información de la cuenta");
			lblAccount.setText(language.getString("lblAccount"));
			lblAccount.setBounds(164, 11, 418, 14);
			lblAccount.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblAccount;
	}

	private JLabel getLblUserEmail() {
		if (lblUserEmail == null) {
			lblUserEmail = new JLabel("E-mail");
			lblUserEmail.setText(language.getString("lblEmail"));
			lblUserEmail.setBounds(164, 146, 82, 20);
			lblUserEmail.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblUserEmail;
	}

	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel();
			lblEmail.setBounds(264, 146, 159, 20);
			lblEmail.setText("juanyanezgc");
		}
		return lblEmail;
	}

	private JLabel getLblUserName() {
		if (lblUserName == null) {
			lblUserName = new JLabel("Nombre");
			lblUserName.setText(language.getString("lblName"));
			lblUserName.setBounds(164, 78, 82, 23);
			lblUserName.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblUserName;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel();
			lblName.setText("Juan Yáñez García-Catalán");
			lblName.setBounds(264, 78, 159, 23);
		}
		return lblName;
	}

	private JLabel getLblUserNickname() {
		if (lblUserNickname == null) {
			lblUserNickname = new JLabel("Usuario");
			lblUserNickname.setText(language.getString("lblUsername"));
			lblUserNickname.setBounds(164, 47, 82, 20);
			lblUserNickname.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblUserNickname;
	}

	private void btnChangePasswordMouseClicked(MouseEvent evt) {
		changeFrame = new ChangePasswordUI(this);
		setEnabled(false);
	}

	private JButton getBtnChangeName() {
		if (btnChangeName == null) {
			btnChangeName = new JButton("Cambiar nombre");
			btnChangeName.setText(language.getString("btnChangeName"));
			btnChangeName.setBounds(458, 80, 138, 23);
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
		if (lblUserPassword == null) {
			lblUserPassword = new JLabel(language.getString("lblPassword"));
			lblUserPassword.setBounds(164, 112, 82, 20);
			lblUserPassword.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblUserPassword;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel();
			lblPassword.setText("********");
			lblPassword.setBounds(264, 115, 159, 20);
		}
		return lblPassword;
	}

	private void btnChangeNameMouseClicked(MouseEvent evt) {
		changeFrame = new ChangeNameUI(this, user.getName(), user.getLastName());
		setEnabled(false);
	}

	public void refreshName() {
		lblName.setText(user.getName() + " " + user.getLastName());
		setEnabled(true);
		toFront();
	}

	private void btnChangeEmailMouseClicked(MouseEvent evt) {
		changeFrame = new ChangeEmailUI(this, user.getEmail());
		setEnabled(true);
	}

	public void closeChangeFrame() {
		changeFrame.dispose();
		setEnabled(true);
	}

	private JScrollPane getJScrollPane1() {
		if (rankingScroll == null) {
			rankingScroll = new JScrollPane();
			rankingScroll.setBounds(130, 269, 375, 126);
			rankingScroll
					.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			rankingScroll.setViewportView(getJPanel1());
		}
		return rankingScroll;
	}


	private void changeLanguage(int selectedLanguage){
		Controller.getInstance().changeLanguage(selectedLanguage);
		lblAccount.setText(language.getString("lblAccount"));
		lblUserNickname.setText(language.getString("lblUsername"));
		lblUserName.setText(language.getString("lblName"));
		lblUserEmail.setText(language.getString("lblEmail"));
		lblUserPassword.setText(language.getString("lblPassword"));
		lblLanguage.setText(language.getString("lblLanguage"));
		lblRanking.setText(language.getString("lblRanking"));
		lblGame.setText(language.getString("lblGame"));
		lblPlayed.setText(language.getString("lblPlayed"));
		lblWins.setText(language.getString("lblWins"));
		lblLost.setText(language.getString("lblLost"));
		lblRate.setText(language.getString("lblRate"));
		btnChangeName.setText(language.getString("btnChangeName"));
		btnChangePassword.setText(language.getString("btnChangePassword"));
		btnChangeEmail.setText(language.getString("btnChangeEmail"));
		btnBack.setText(language.getString("btnBack"));
		btnAvatar.setText(language.getString("btnSelectAvatar"));
	}
	
	private JLabel getLblLanguage() {
		if(lblLanguage == null) {
			lblLanguage = new JLabel(language.getString("lblLanguage"));
			lblLanguage.setBounds(164, 178, 82, 20);
			lblLanguage.setFont(new java.awt.Font("Tahoma",1,11));
		}
		return lblLanguage;
	}
	
	private JComboBox<String> getLstLanguages() {
		if(lstLanguages == null) {
			ComboBoxModel<String> lstLanguagesModel = 
					new DefaultComboBoxModel<String>(
							new String[] { language.getString("UnitedStates"),language.getString("Spain"), language.getString("France"),
									language.getString("Germany") });
			lstLanguages = new JComboBox<String>();
			lstLanguages.setModel(lstLanguagesModel);
			lstLanguages.setBounds(264, 178, 107, 20);
			lstLanguages.setFocusable(false);
			lstLanguages.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					lstLanguagesActionPerformed(evt);
				}
			});
			lstLanguages.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					lstLanguagesItemStateChanged(evt);
				}
			});
		}
		return lstLanguages;
	}
	
	private void lstLanguagesItemStateChanged(ItemEvent evt) {
		int selectedLanguage = lstLanguages.getSelectedIndex();
		changeLanguage(selectedLanguage);
	}
	
	private void lstLanguagesActionPerformed(ActionEvent evt) {
		ComboBoxModel<String> lstLanguagesModel = 
				new DefaultComboBoxModel<String>(
						new String[] { language.getString("UnitedStates"),language.getString("Spain"), language.getString("France"),
								language.getString("Germany") });
		lstLanguages.setModel(lstLanguagesModel);
		lstLanguages.setSelectedIndex(language.getLanguageCode());
	}
}
