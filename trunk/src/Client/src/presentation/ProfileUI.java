package presentation;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
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
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
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

import logic.Controller;
import logic.LanguageManager;
import ProductLine.GameType;
import ProductLine.Ranking;
import ProductLine.User;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;

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
	private JButton btnDeleteAccount;
	private JComboBox lstLanguages;
	private JLabel lblLanguage;

	private JPanelRound pnlBackground;
	private JLabel lblRate;
	private JLabel lblPlayed;
	private JLabel lblLost;
	private JLabel lblWins;
	private JLabel lblGame;
	private JButton btnBack;
	private JLabel lblRanking;
	private JLabel lblUserPassword;
	private JLabel lblPassword;
	private JButton btnChangeName;
	private JLabel lblNickname;
	private JLabel lblUserName;
	private JLabel lblName;
	private JLabel lblUserEmail;
	private JLabel lblEmail;
	private JLabel lblAccount;
	private JPanel pnlRanking;
	private JButton btnChangeEmail;
	private JButton btnChangePassword;
	private JLabel lblAvatar;
	private JButton btnAvatar;
	private JLabel lblUserNickname;
	private JFrame changeFrame;

	private LanguageManager language;
	private User user;

	public ProfileUI(User user) {
		super();
		setTitle("Perfil");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				ProfileUI.class.getResource("/images/icon.png")));
		this.language = LanguageManager.language();
		this.user = user;
		initGUI();
		lblUserNickname.setText(user.getUsername());
		lblUserName.setText(user.getName() + " " + user.getLastName());
		lblUserEmail.setText(user.getEmail());
		lblAvatar.setIcon(new ImageIcon(user.getAvatar()));
		lstLanguages.setSelectedIndex(language.getLanguageCode());
		loadRankings();
	}

	private void loadRankings() {
		for (int i = 0; i < user.getRankings().size(); i++) {

			NumberFormat format = NumberFormat.getInstance();
			format.setMaximumFractionDigits(1);
			format.setMinimumFractionDigits(1);
			Ranking ranking = user.getRankings().get(i);

			int played = ranking.getWonGames() + ranking.getLostGames();
			int won = ranking.getWonGames();
			int lost = ranking.getLostGames();
			double rate;

			if (played == 0) {
				rate = 0;
			} else {
				rate = (double) won / played * 100.0;
			}

			String txtGame = null;

			switch (ranking.getGame()) {
			case Checkers:
				txtGame = language.getString("checkersName");
				break;
			case Chess:
				txtGame = language.getString("chessName");
				break;
			case Connect4:
				txtGame = language.getString("connect4Name");
				break;
			case Goose:
				txtGame = language.getString("gooseName");
				break;
			case Ludo:
				txtGame = language.getString("ludoName");
				break;
			}

			JLabel lblGame = new JLabel(txtGame);
			JLabel lblPlayed = new JLabel(String.valueOf(played));
			JLabel lblWon = new JLabel(String.valueOf(won));
			JLabel lblLost = new JLabel(String.valueOf(lost));
			JLabel lblRate = new JLabel(String.valueOf(format.format(rate))
					+ " %");

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

			lblGame.setForeground(Color.WHITE);
			lblPlayed.setForeground(Color.WHITE);
			lblWon.setForeground(Color.WHITE);
			lblLost.setForeground(Color.WHITE);
			lblRate.setForeground(Color.WHITE);
			pnlRanking.add(lblGame);
			pnlRanking.add(lblPlayed);
			pnlRanking.add(lblWon);
			pnlRanking.add(lblLost);
			pnlRanking.add(lblRate);
		}

	}

	private void initGUI() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setSize(635, 500);
		setLocationRelativeTo(null);
		BorderLayout thisLayout = new BorderLayout();
		getContentPane().setLayout(thisLayout);
		setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				thisWindowClosing(evt);
			}
		});
		getContentPane().add(getPnlBackground(), BorderLayout.CENTER);
	}

	private JPanelRound getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanelRound();
			pnlBackground.setArcw(0);
			pnlBackground.setArch(0);
			pnlBackground.setLayout(null);
			pnlBackground.setBounds(0, 0, 606, 440);
			pnlBackground.add(getLblUserNickname());
			pnlBackground.add(getBtnAvatar());
			pnlBackground.add(getLblAvatar());
			pnlBackground.add(getBtnBack());
			pnlBackground.add(getBtnChangePassword());
			pnlBackground.add(getBtnChangeEmail());
			pnlBackground.add(getJScrollPane1());
			pnlBackground.add(getLblAccount());
			pnlBackground.add(getLblEmail());
			pnlBackground.add(getLblUserEmail());
			pnlBackground.add(getLblName());
			pnlBackground.add(getLblUserName());
			pnlBackground.add(getLblNickname());
			pnlBackground.add(getBtnChangeName());
			pnlBackground.add(getLblPassword());
			pnlBackground.add(getLblUserPassword());
			pnlBackground.add(getLblRanking());
			pnlBackground.add(getLblLanguage());
			pnlBackground.add(getLstLanguages());
			pnlBackground.add(getBtnDeleteAccount());
		}
		return pnlBackground;
	}

	private JLabel getLblUserNickname() {
		if (lblUserNickname == null) {
			lblUserNickname = new JLabel();
			lblUserNickname.setForeground(Color.WHITE);
			lblUserNickname.setBounds(264, 47, 159, 20);
			lblUserNickname.setHorizontalTextPosition(SwingConstants.CENTER);
			lblUserNickname.setHorizontalAlignment(SwingConstants.LEFT);
			lblUserNickname.setText("Juan");
		}
		return lblUserNickname;
	}

	private JButton getBtnAvatar() {
		if (btnAvatar == null) {
			btnAvatar = new JButton("Seleccionar avatar");
			btnAvatar.setText(language.getString("btnSelectAvatar"));
			btnAvatar.setBounds(20, 177, 105, 23);
			btnAvatar.setFocusable(false);
			btnAvatar.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnAvatarMouseClicked(evt);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					btnAvatarMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnAvatarMouseExited(e);
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
			lblAvatar.setBounds(20, 49, 105, 117);
			lblAvatar.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
		}
		return lblAvatar;
	}

	private JLabel getLblRanking() {
		if (lblRanking == null) {
			lblRanking = new JLabel("Ranking");
			lblRanking.setForeground(Color.WHITE);
			lblRanking.setText(language.getString("lblRanking"));
			lblRanking.setBounds(15, 238, 98, 20);
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
			btnBack.setBounds(522, 420, 74, 23);
			btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
			btnBack.setFocusable(false);
			btnBack.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnBackMouseClicked(evt);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					btnBackMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnBackMouseExited(e);
				}
			});
		}
		return btnBack;
	}

	private JLabel getLblGame() {
		if (lblGame == null) {
			lblGame = new JLabel("Juego");
			lblGame.setForeground(Color.WHITE);
			lblGame.setText(language.getString("lblGame"));
			lblGame.setBounds(0, 0, 75, 20);
			lblGame.setHorizontalTextPosition(SwingConstants.CENTER);
			lblGame.setHorizontalAlignment(SwingConstants.CENTER);
			lblGame.setFont(new java.awt.Font("Tahoma", 3, 11));
		}
		return lblGame;
	}

	private JLabel getLblWins() {
		if (lblWins == null) {
			lblWins = new JLabel("Ganadas");
			lblWins.setForeground(Color.WHITE);
			lblWins.setText(language.getString("lblWins"));
			lblWins.setBounds(150, 0, 75, 20);
			lblWins.setHorizontalTextPosition(SwingConstants.CENTER);
			lblWins.setHorizontalAlignment(SwingConstants.CENTER);
			lblWins.setFont(new java.awt.Font("Tahoma", 3, 11));
		}
		return lblWins;
	}

	private JLabel getLblLost() {
		if (lblLost == null) {
			lblLost = new JLabel("Perdidas");
			lblLost.setForeground(Color.WHITE);
			lblLost.setText(language.getString("lblLost"));
			lblLost.setBounds(225, 0, 75, 20);
			lblLost.setHorizontalTextPosition(SwingConstants.CENTER);
			lblLost.setHorizontalAlignment(SwingConstants.CENTER);
			lblLost.setFont(new java.awt.Font("Tahoma", 3, 11));
		}
		return lblLost;
	}

	private JLabel getLblPlayed() {
		if (lblPlayed == null) {
			lblPlayed = new JLabel("Jugadas");
			lblPlayed.setForeground(Color.WHITE);
			lblPlayed.setText(language.getString("lblPlayed"));
			lblPlayed.setBounds(75, 0, 75, 20);
			lblPlayed.setHorizontalTextPosition(SwingConstants.CENTER);
			lblPlayed.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlayed.setFont(new java.awt.Font("Tahoma", 3, 11));
		}
		return lblPlayed;
	}

	private JLabel getLblRate() {
		if (lblRate == null) {
			lblRate = new JLabel("Ratio");
			lblRate.setForeground(Color.WHITE);
			lblRate.setText(language.getString("lblRate"));
			lblRate.setBounds(300, 0, 75, 20);
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
			btnChangePassword = new JButton("Cambiar contraseña");
			btnChangePassword.setText(language.getString("btnChangePassword"));
			btnChangePassword.setBounds(458, 114, 138, 23);
			btnChangePassword.setFocusable(false);
			btnChangePassword.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnChangePasswordMouseClicked(evt);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					btnChangePasswordMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnChangePasswordMouseExited(e);
				}
			});
		}
		return btnChangePassword;
	}

	private JButton getBtnChangeEmail() {
		if (btnChangeEmail == null) {
			btnChangeEmail = new JButton("Cambiar e-mail");
			btnChangeEmail.setText(language.getString("btnChangeEmail"));
			btnChangeEmail.setBounds(458, 148, 138, 23);
			btnChangeEmail.setFocusable(false);
			btnChangeEmail.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnChangeEmailMouseClicked(evt);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					btnChangeEmailMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnChangeEmailMouseExited(e);
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
			pnlRanking.setBackground(Color.BLACK);
			pnlRanking.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
			lblAccount.setForeground(Color.WHITE);
			lblAccount.setText(language.getString("lblAccount"));
			lblAccount.setBounds(20, 11, 576, 14);
			lblAccount.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblAccount;
	}

	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("E-mail");
			lblEmail.setForeground(Color.WHITE);
			lblEmail.setText(language.getString("lblEmail"));
			lblEmail.setBounds(164, 146, 82, 20);
			lblEmail.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblEmail;
	}

	private JLabel getLblUserEmail() {
		if (lblUserEmail == null) {
			lblUserEmail = new JLabel();
			lblUserEmail.setForeground(Color.WHITE);
			lblUserEmail.setBounds(264, 146, 159, 20);
			lblUserEmail.setText("juanyanezgc");
		}
		return lblUserEmail;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Nombre");
			lblName.setForeground(Color.WHITE);
			lblName.setText(language.getString("lblName"));
			lblName.setBounds(164, 78, 82, 23);
			lblName.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblName;
	}

	private JLabel getLblUserName() {
		if (lblUserName == null) {
			lblUserName = new JLabel();
			lblUserName.setForeground(Color.WHITE);
			lblUserName.setText("Juan Yáñez García-Catalán");
			lblUserName.setBounds(264, 78, 159, 23);
		}
		return lblUserName;
	}

	private JLabel getLblNickname() {
		if (lblNickname == null) {
			lblNickname = new JLabel("Usuario");
			lblNickname.setForeground(Color.WHITE);
			lblNickname.setText(language.getString("lblUsername"));
			lblNickname.setBounds(164, 47, 82, 20);
			lblNickname.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblNickname;
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

				@Override
				public void mouseEntered(MouseEvent e) {
					btnChangeNameMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnChangeNameMouseExited(e);
				}
			});
		}
		return btnChangeName;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Contraseña");
			lblPassword.setForeground(Color.WHITE);
			lblPassword.setText(language.getString("lblPassword"));
			lblPassword.setBounds(164, 112, 82, 20);
			lblPassword.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblPassword;
	}

	private JLabel getLblUserPassword() {
		if (lblUserPassword == null) {
			lblUserPassword = new JLabel();
			lblUserPassword.setForeground(Color.WHITE);
			lblUserPassword.setText("********");
			lblUserPassword.setBounds(264, 115, 159, 20);
		}
		return lblUserPassword;
	}

	private void btnChangeNameMouseClicked(MouseEvent evt) {
		changeFrame = new ChangeNameUI(this, user.getName(), user.getLastName());
		setEnabled(false);
	}

	public void refreshName() {
		lblUserName.setText(user.getName() + " " + user.getLastName());
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
			rankingScroll.setBounds(130, 269, 375, 143);
			rankingScroll.setBorder(null);
			rankingScroll.setViewportView(getJPanel1());
		}
		return rankingScroll;
	}

	private void changeLanguage(int selectedLanguage) {
		Controller.getInstance().changeLanguage(selectedLanguage);
		lblAccount.setText(language.getString("lblAccount"));
		lblNickname.setText(language.getString("lblUsername"));
		lblName.setText(language.getString("lblName"));
		lblEmail.setText(language.getString("lblEmail"));
		lblPassword.setText(language.getString("lblPassword"));
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
		btnDeleteAccount.setText(language.getString("btnDeleteAccount"));
	}

	private JLabel getLblLanguage() {
		if (lblLanguage == null) {
			lblLanguage = new JLabel("País");
			lblLanguage.setForeground(Color.WHITE);
			lblLanguage.setText(language.getString("lblLanguage"));
			lblLanguage.setBounds(164, 178, 82, 20);
			lblLanguage.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblLanguage;
	}

	private JComboBox<String> getLstLanguages() {
		if (lstLanguages == null) {
			ImageIcon[] icons = {
					new ImageIcon(
							ProfileUI.class
									.getResource("/images/Flags/us_small.png")),
					new ImageIcon(
							ProfileUI.class
									.getResource("/images/Flags/es_small.png")),
					new ImageIcon(
							ProfileUI.class
									.getResource("/images/Flags/fr_small.png")),
					new ImageIcon(
							ProfileUI.class
									.getResource("/images/Flags/de_small.png")) };
			String[] description = new String[] { language.getString("US"),
					language.getString("Spanish"),
					language.getString("French"), language.getString("German") };
			Integer[] intArray = new Integer[description.length];
			for (int i = 0; i < icons.length; i++) {
				intArray[i] = new Integer(i);
				if (icons[i] != null) {
					icons[i].setDescription(description[i]);
				}
			}
			ComboBoxRenderer renderer = new ComboBoxRenderer(icons, description);
			renderer.setPreferredSize(new Dimension(120, 24));
			lstLanguages = new JComboBox(intArray);
			lstLanguages.setBounds(264, 178, 140, 20);
			lstLanguages.setFocusable(false);
			lstLanguages.setRenderer(renderer);
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
		ImageIcon[] icons = {
				new ImageIcon(
						ProfileUI.class
								.getResource("/images/Flags/us_small.png")),
				new ImageIcon(
						ProfileUI.class
								.getResource("/images/Flags/es_small.png")),
				new ImageIcon(
						ProfileUI.class
								.getResource("/images/Flags/fr_small.png")),
				new ImageIcon(
						ProfileUI.class
								.getResource("/images/Flags/de_small.png")) };
		String[] description = new String[] { language.getString("US"),
				language.getString("Spanish"), language.getString("French"),
				language.getString("German") };
		Integer[] intArray = new Integer[description.length];
		for (int i = 0; i < icons.length; i++) {
			intArray[i] = new Integer(i);
			if (icons[i] != null) {
				icons[i].setDescription(description[i]);
			}
		}
		ComboBoxRenderer renderer = new ComboBoxRenderer(icons, description);
		renderer.setPreferredSize(new Dimension(120, 24));
		lstLanguages.setRenderer(renderer);
		lstLanguages.setSelectedIndex(language.getLanguageCode());
	}

	private JButton getBtnDeleteAccount() {
		if (btnDeleteAccount == null) {
			btnDeleteAccount = new JButton("Borrar cuenta");
			btnDeleteAccount.setText(language.getString("btnDeleteAccount"));
			btnDeleteAccount.setBounds(458, 177, 138, 23);
			btnDeleteAccount.setFocusable(false);
			btnDeleteAccount.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnDeleteAccountMouseClicked(evt);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					btnDeleteAccountMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnDeleteAccountMouseExited(e);
				}
			});
		}
		return btnDeleteAccount;
	}

	private void btnDeleteAccountMouseClicked(MouseEvent evt) {
		new DeleteAccountUI(this);
	}

	private void setHandCursor() {
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	private void setDefaultCursor() {
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	protected void btnAvatarMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnChangePasswordMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnBackMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnChangeEmailMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnDeleteAccountMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnChangeNameMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnAvatarMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void btnChangePasswordMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void btnBackMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void btnChangeEmailMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void btnChangeNameMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void btnDeleteAccountMouseExited(MouseEvent e) {
		setDefaultCursor();
	}
}