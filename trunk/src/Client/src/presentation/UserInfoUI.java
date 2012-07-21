package presentation;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import logic.LanguageManager;
import logic.Utils;

import ProductLine.GameType;
import ProductLine.Ranking;
import ProductLine.User;

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
public class UserInfoUI extends javax.swing.JFrame {

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
	private WaitingRoomUI parent;
	private JPanel pnlBackground;
	private JScrollPane rankingScroll;
	private JButton btnBack;
	private JButton btnInvite;
	private JLabel lblFlag;
	private JLabel lblEmail;
	private JLabel lblUserEmail;
	private JLabel lblAvatar;
	private JLabel lblNickname;
	private JLabel lblUserNickname;
	private JLabel lblAccount;
	private JLabel lblName;
	private JLabel lblUserName;
	private JLabel lblGame;
	private JLabel lblWins;
	private JLabel lblLost;
	private JLabel lblPlayed;
	private JLabel lblRate;
	private JPanel pnlRanking;
	private JLabel lblRanking;
	private LanguageManager language;

	public UserInfoUI(WaitingRoomUI parent, User user) {
		super();
		this.parent = parent;
		language = LanguageManager.language();
		initGUI();

		ArrayList<Ranking> rank = new ArrayList<Ranking>();
		rank.add(new Ranking(20, 5, GameType.Checkers));
		rank.add(new Ranking(20, 67, GameType.Chess));
		user.setRankings(rank);

		loadRankings(user);
		lblUserNickname.setText(user.getUsername());
		lblUserName.setText(user.getName() + " " + user.getLastName());
		lblUserEmail.setText(user.getEmail());
		lblAvatar.setIcon(new ImageIcon(user.getAvatar()));
		lblFlag.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
				Utils.countryImgPath(user.getCountry()))));
		setVisible(true);
		setLocationRelativeTo(null);

	}

	private void initGUI() {
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				thisWindowClosing(evt);
			}
		});
		getContentPane().add(getJPanel1(), BorderLayout.CENTER);
		pack();
		this.setSize(600, 500);
	}

	private void loadRankings(User user) {
		for (int i = 0; i < user.getRankings().size(); i++) {
			NumberFormat format = NumberFormat.getInstance();
			format.setMaximumFractionDigits(1);
			format.setMinimumFractionDigits(1);
			Ranking ranking = user.getRankings().get(i);
			JLabel lblGame = new JLabel(ranking.getGame().toString());
			JLabel lblPlayed = new JLabel(String.valueOf(ranking.getWonGames()
					+ ranking.getLostGames()));
			JLabel lblWon = new JLabel(String.valueOf(ranking.getWonGames()));
			JLabel lblLost = new JLabel(String.valueOf(ranking.getLostGames()));
			JLabel lblRate = new JLabel(String.valueOf(format.format(ranking
					.getWonGames()
					/ Double.parseDouble(lblPlayed.getText())
					* 100) + " %"));
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

	private JPanel getJPanel1() {
		if (pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setLayout(null);
			pnlBackground.add(getLblRanking());
			pnlBackground.add(getRankingScroll());
			pnlBackground.add(getLblUserName());
			pnlBackground.add(getLblName());
			pnlBackground.add(getLblAccount());
			pnlBackground.add(getLblUserNickname());
			pnlBackground.add(getLblNickname());
			pnlBackground.add(getLblAvatar());
			pnlBackground.add(getLblUserEmail());
			pnlBackground.add(getLblEmail());
			pnlBackground.add(getLblFlag());
			pnlBackground.add(getBtnInvite());
			pnlBackground.add(getBtnBack());
		}
		return pnlBackground;
	}

	private JLabel getLblRanking() {
		if (lblRanking == null) {
			lblRanking = new JLabel("Ranking");
			lblRanking.setText(language.getString("lblRanking"));
			lblRanking.setHorizontalAlignment(SwingConstants.LEFT);
			lblRanking.setHorizontalTextPosition(SwingConstants.CENTER);
			lblRanking.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblRanking.setBounds(20, 221, 98, 20);
		}
		return lblRanking;
	}

	private JScrollPane getRankingScroll() {
		if (rankingScroll == null) {
			rankingScroll = new JScrollPane();
			rankingScroll
					.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			rankingScroll.setBounds(86, 263, 377, 143);
			rankingScroll.setAutoscrolls(true);
			rankingScroll
					.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			rankingScroll.setViewportView(getPnlRanking());
		}
		return rankingScroll;
	}

	private JPanel getPnlRanking() {
		if (pnlRanking == null) {
			pnlRanking = new JPanel();
			pnlRanking.setLayout(null);
			pnlRanking.setBounds(130, 269, 375, 126);
			pnlRanking.setLayout(null);
			pnlRanking.add(getLblRate());
			pnlRanking.add(getLblPlayed());
			pnlRanking.add(getLblLost());
			pnlRanking.add(getLblWins());
			pnlRanking.add(getLblGame());
		}
		return pnlRanking;
	}

	private JLabel getLblRate() {
		if (lblRate == null) {
			lblRate = new JLabel("Ratio");
			lblRate.setText(language.getString("lblRate"));
			lblRate.setHorizontalAlignment(SwingConstants.CENTER);
			lblRate.setHorizontalTextPosition(SwingConstants.CENTER);
			lblRate.setFont(new java.awt.Font("Tahoma", 3, 11));
			lblRate.setBounds(300, 0, 75, 15);
		}
		return lblRate;
	}

	private JLabel getLblPlayed() {
		if (lblPlayed == null) {
			lblPlayed = new JLabel("Jugadas");
			lblPlayed.setText(language.getString("lblPlayed"));
			lblPlayed.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlayed.setHorizontalTextPosition(SwingConstants.CENTER);
			lblPlayed.setFont(new java.awt.Font("Tahoma", 3, 11));
			lblPlayed.setBounds(75, 0, 75, 15);
		}
		return lblPlayed;
	}

	private JLabel getLblLost() {
		if (lblLost == null) {
			lblLost = new JLabel("Perdidas");
			lblLost.setText(language.getString("lblLost"));
			lblLost.setHorizontalAlignment(SwingConstants.CENTER);
			lblLost.setHorizontalTextPosition(SwingConstants.CENTER);
			lblLost.setFont(new java.awt.Font("Tahoma", 3, 11));
			lblLost.setBounds(225, 0, 75, 15);
		}
		return lblLost;
	}

	private JLabel getLblWins() {
		if (lblWins == null) {
			lblWins = new JLabel("Ganadas");
			lblWins.setText(language.getString("lblWins"));
			lblWins.setHorizontalAlignment(SwingConstants.CENTER);
			lblWins.setHorizontalTextPosition(SwingConstants.CENTER);
			lblWins.setFont(new java.awt.Font("Tahoma", 3, 11));
			lblWins.setBounds(150, 0, 75, 15);
		}
		return lblWins;
	}

	private JLabel getLblGame() {
		if (lblGame == null) {
			lblGame = new JLabel("Juego");
			lblGame.setText(language.getString("lblGame"));
			lblGame.setHorizontalAlignment(SwingConstants.CENTER);
			lblGame.setHorizontalTextPosition(SwingConstants.CENTER);
			lblGame.setFont(new java.awt.Font("Tahoma", 3, 11));
			lblGame.setBounds(0, 0, 75, 15);
		}
		return lblGame;
	}

	private JLabel getLblUserName() {
		if (lblUserName == null) {
			lblUserName = new JLabel();
			lblUserName.setText("Juan Yáñez García-Catalán");
			lblUserName.setBounds(264, 84, 159, 23);
		}
		return lblUserName;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Nombre");
			lblName.setText(language.getString("lblName"));
			lblName.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblName.setBounds(164, 84, 82, 23);
		}
		return lblName;
	}

	private JLabel getLblAccount() {
		if (lblAccount == null) {
			lblAccount = new JLabel("Información de la cuenta");
			lblAccount.setText(language.getString("lblAccount"));
			lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
			lblAccount.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblAccount.setBounds(0, 11, 584, 14);
		}
		return lblAccount;
	}

	private JLabel getLblUserNickname() {
		if (lblUserNickname == null) {
			lblUserNickname = new JLabel();
			lblUserNickname.setText("Juan");
			lblUserNickname.setHorizontalAlignment(SwingConstants.LEFT);
			lblUserNickname.setHorizontalTextPosition(SwingConstants.CENTER);
			lblUserNickname.setBounds(264, 53, 159, 20);
		}
		return lblUserNickname;
	}

	private JLabel getLblNickname() {
		if (lblNickname == null) {
			lblNickname = new JLabel("Usuario");
			lblNickname.setText(language.getString("lblUsername"));
			lblNickname.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblNickname.setBounds(164, 53, 82, 20);
		}
		return lblNickname;
	}

	private JLabel getLblAvatar() {
		if (lblAvatar == null) {
			lblAvatar = new JLabel();
			lblAvatar.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar.setBounds(20, 35, 105, 117);
		}
		return lblAvatar;
	}

	private JLabel getLblUserEmail() {
		if (lblUserEmail == null) {
			lblUserEmail = new JLabel();
			lblUserEmail.setText("juanyanezgc");
			lblUserEmail.setBounds(264, 118, 159, 20);
		}
		return lblUserEmail;
	}

	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("E-mail");
			lblEmail.setText(language.getString("lblEmail"));
			lblEmail.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblEmail.setBounds(164, 118, 82, 20);
		}
		return lblEmail;
	}

	private JLabel getLblFlag() {
		if (lblFlag == null) {
			lblFlag = new JLabel();
			lblFlag.setBounds(440, 35, 131, 117);
			lblFlag.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/Flags/es.png")));
		}
		return lblFlag;
	}

	private void thisWindowClosing(WindowEvent evt) {
		parent.setEnabled(true);
		dispose();
	}

	private JButton getBtnInvite() {
		if (btnInvite == null) {
			btnInvite = new JButton();
			btnInvite.setText("Invitar amigo");
			btnInvite.setBounds(479, 399, 95, 23);
			btnInvite.setFocusable(false);
		}
		return btnInvite;
	}

	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton();
			btnBack.setText("Volver");
			btnBack.setBounds(479, 428, 95, 23);
			btnBack.setFocusable(false);
			btnBack.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnBackMouseClicked(evt);
				}
			});
		}
		return btnBack;
	}

	private void btnBackMouseClicked(MouseEvent evt) {
		dispose();
	}

}
