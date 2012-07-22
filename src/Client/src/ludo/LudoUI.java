package ludo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;

import logic.Controller;
import logic.SessionManager;
import model.Game;
import model.User;

import presentation.GameUI;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import ProductLine.Slot;
import ProductLine.SlotState;

@SuppressWarnings("serial")
public class LudoUI extends JFrame implements GameUI {
	private JPanel pnlBackground;
	private JPanel pnlBoard;
	private JPanel pnlYellowPlayer;
	private JPanel pnlBluePlayer;
	private JPanel pnlRedPlayer;
	private JPanel pnlGreenPlayer;
	private JLabel lblEndGreen;
	private JLabel lblEndred;
	private JLabel lblEndBlue;
	private JLabel lblEndYellow;
	private JPanel pnlCenter;
	private JLabel lbl_16;
	private JLabel lbl_15;
	private JLabel lbl_14;
	private JLabel lbl_13;
	private JLabel lbl_12;
	private JLabel lbl_11;
	private JPanel pnlBlueSide;
	private JLabel lbl_10;
	private JLabel lbl_9;
	private JLabel lbl_17;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_13;
	private JLabel lbl_18;
	private JLabel lbl_19;
	private JLabel lbl_20;
	private JLabel lbl_21;
	private JLabel lbl_22;
	private JLabel lbl_23;
	private JLabel lbl_24;
	private JLabel lbl_25;
	private JPanel pnlGreenSide;
	private JLabel lbl_59;
	private JLabel lbl_58;
	private JLabel lbl_57;
	private JLabel lbl_56;
	private JLabel lbl_55;
	private JLabel lbl_54;
	private JLabel lbl_53;
	private JLabel lbl_52;
	private JLabel label_31;
	private JLabel label_32;
	private JLabel label_33;
	private JLabel label_34;
	private JLabel label_35;
	private JLabel label_36;
	private JLabel label_37;
	private JLabel lbl_51;
	private JLabel lbl_43;
	private JLabel lbl_44;
	private JLabel lbl_45;
	private JLabel lbl_46;
	private JLabel lbl_47;
	private JLabel lbl_48;
	private JLabel lbl_49;
	private JLabel lbl_50;
	private JPanel pnlRedSide;
	private JLabel lbl_33;
	private JLabel lbl_34;
	private JLabel lbl_35;
	private JLabel lbl_32;
	private JLabel label_50;
	private JLabel lbl_36;
	private JLabel lbl_30;
	private JLabel label_53;
	private JLabel lbl_38;
	private JLabel lbl_37;
	private JLabel label_56;
	private JLabel lbl_31;
	private JLabel lbl_26;
	private JLabel lbl_27;
	private JLabel lbl_28;
	private JLabel lbl_29;
	private JLabel label_62;
	private JLabel label_63;
	private JLabel label_64;
	private JLabel label_65;
	private JLabel lbl_42;
	private JLabel lbl_41;
	private JLabel lbl_40;
	private JLabel lbl_39;
	private JPanel pnlYellowSide;
	private JLabel lbl_8;
	private JLabel label_71;
	private JLabel lbl_60;
	private JLabel lbl_7;
	private JLabel label_74;
	private JLabel lbl_61;
	private JLabel lbl_5;
	private JLabel label_77;
	private JLabel lbl_63;
	private JLabel lbl_62;
	private JLabel label_80;
	private JLabel lbl_6;
	private JLabel lbl_1;
	private JLabel lbl_2;
	private JLabel lbl_3;
	private JLabel lbl_4;
	private JLabel label_86;
	private JLabel label_87;
	private JLabel label_88;
	private JLabel lbl_68;
	private JLabel lbl_67;
	private JLabel lbl_66;
	private JLabel lbl_65;
	private JLabel lbl_64;
	private JLabel lblYellowPlayerAvatar;
	private JLabel lblYellowPlayerName;
	private JLabel lblGreenPlayerAvatar;
	private JLabel lblGreenPlayerName;
	private JLabel lblRedPlayerAvatar;
	private JLabel lblRedPlayerName;
	private JLabel lblBluePlayerAvatar;
	private JLabel lblBluePlayerName;
	private JLabel lblDice;
	private JLabel lblBlueDice;
	private JLabel lblRedDice;
	private JLabel lblGreenDice;
	private JLabel lblYellowDice;
	private JButton button;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTextPane textPane;
	private JLabel lblState;

	private String username;
	private Game game;

	public LudoUI(String username, Game game) {
		this.username = username;
		this.game = game;
		initGUI();
		initPlayers();
	}

	private void initPlayers() {
		for (int i = 0; i < 4; i++) {
			Slot slot = game.getSlot(i);
			if (slot.getType() == SlotState.Human
					|| slot.getType() == SlotState.Computer) {
				String slotName = slot.getPlayer();
				ImageIcon icon;

				if (slot.getType() == SlotState.Computer) {
					slotName = "Computer";
					icon = new ImageIcon(
							LudoUI.class.getResource("/images/computer.png"));
				} else {
					User slotUser = Controller.getInstance().searchUser(
							slotName);
					icon = new ImageIcon(slotUser.getAvatar());
				}

				switch (i) {
				case 0:
					lblYellowPlayerName.setText(slotName);
					lblYellowPlayerAvatar.setIcon(icon);
					break;
				case 1:
					lblRedPlayerName.setText(slotName);
					lblRedPlayerAvatar.setIcon(icon);
					break;
				case 2:
					lblBluePlayerName.setText(slotName);
					lblBluePlayerAvatar.setIcon(icon);
					break;
				case 3:
					lblGreenPlayerName.setText(slotName);
					lblGreenPlayerAvatar.setIcon(icon);
					break;
				}
			}
		}
	}

	private void initGUI() {
		setSize(new Dimension(647, 850));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		getContentPane().add(getPnlBackground());
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private JPanel getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setBounds(0, 0, 642, 822);
			pnlBackground.setLayout(null);
			pnlBackground.add(getPnlBoard());
			pnlBackground.add(getButton());
			pnlBackground.add(getTextField());
			pnlBackground.add(getScrollPane());
			pnlBackground.add(getLblState());
		}
		return pnlBackground;
	}

	private JPanel getPnlBoard() {
		if (pnlBoard == null) {
			pnlBoard = new JPanel();
			pnlBoard.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			pnlBoard.setBounds(10, 10, 622, 622);
			pnlBoard.setLayout(null);
			pnlBoard.add(getPnlYellowPlayer());
			pnlBoard.add(getPnlBluePlayer());
			pnlBoard.add(getPnlRedPlayer());
			pnlBoard.add(getPnlGreenPlayer());
			pnlBoard.add(getPnlCenter());
			pnlBoard.add(getPnlBlueSide());
			pnlBoard.add(getPnlGreenSide());
			pnlBoard.add(getPnlRedSide());
			pnlBoard.add(getPnlYellowSide());
		}
		return pnlBoard;
	}

	private JPanel getPnlYellowPlayer() {
		if (pnlYellowPlayer == null) {
			pnlYellowPlayer = new JPanel();
			pnlYellowPlayer.setBackground(new Color(255, 255, 0));
			pnlYellowPlayer.setBorder(new LineBorder(new Color(0, 0, 0)));
			pnlYellowPlayer.setBounds(10, 10, 210, 210);
			pnlYellowPlayer.setLayout(null);
			pnlYellowPlayer.add(getLblYellowPlayerAvatar());
			pnlYellowPlayer.add(getLblYellowPlayerName());
			pnlYellowPlayer.add(getLblYellowDice());
		}
		return pnlYellowPlayer;
	}

	private JPanel getPnlBluePlayer() {
		if (pnlBluePlayer == null) {
			pnlBluePlayer = new JPanel();
			pnlBluePlayer.setBackground(new Color(0, 0, 255));
			pnlBluePlayer.setBorder(new LineBorder(new Color(0, 0, 0)));
			pnlBluePlayer.setBounds(10, 400, 210, 210);
			pnlBluePlayer.setLayout(null);
			pnlBluePlayer.add(getLblBluePlayerAvatar());
			pnlBluePlayer.add(getLblBluePlayerName());
			pnlBluePlayer.add(getLblBlueDice());
		}
		return pnlBluePlayer;
	}

	private JPanel getPnlRedPlayer() {
		if (pnlRedPlayer == null) {
			pnlRedPlayer = new JPanel();
			pnlRedPlayer.setBackground(new Color(255, 0, 0));
			pnlRedPlayer.setBorder(new LineBorder(new Color(0, 0, 0)));
			pnlRedPlayer.setBounds(400, 400, 210, 210);
			pnlRedPlayer.setLayout(null);
			pnlRedPlayer.add(getLblRedPlayerAvatar());
			pnlRedPlayer.add(getLblRedPlayerName());
			pnlRedPlayer.add(getLblRedDice());
		}
		return pnlRedPlayer;
	}

	private JPanel getPnlGreenPlayer() {
		if (pnlGreenPlayer == null) {
			pnlGreenPlayer = new JPanel();
			pnlGreenPlayer.setBackground(new Color(50, 205, 50));
			pnlGreenPlayer.setBorder(new LineBorder(new Color(0, 0, 0)));
			pnlGreenPlayer.setBounds(400, 10, 210, 210);
			pnlGreenPlayer.setLayout(null);
			pnlGreenPlayer.add(getLblGreenPlayerAvatar());
			pnlGreenPlayer.add(getLblGreenPlayerName());
			pnlGreenPlayer.add(getLblGreenDice());
		}
		return pnlGreenPlayer;
	}

	private JLabel getLblEndGreen() {
		if (lblEndGreen == null) {
			lblEndGreen = new JLabel("");
			lblEndGreen.setBounds(0, 0, 40, 120);
			lblEndGreen.setOpaque(true);
			lblEndGreen.setBackground(new Color(0, 0, 255));
			lblEndGreen.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return lblEndGreen;
	}

	private JLabel getLblEndred() {
		if (lblEndred == null) {
			lblEndred = new JLabel("");
			lblEndred.setBounds(0, 0, 120, 40);
			lblEndred.setOpaque(true);
			lblEndred.setBackground(new Color(255, 255, 0));
			lblEndred.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return lblEndred;
	}

	private JLabel getLblEndBlue() {
		if (lblEndBlue == null) {
			lblEndBlue = new JLabel("");
			lblEndBlue.setBounds(80, 0, 40, 120);
			lblEndBlue.setOpaque(true);
			lblEndBlue.setBackground(new Color(50, 205, 50));
			lblEndBlue.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return lblEndBlue;
	}

	private JLabel getLblEndYellow() {
		if (lblEndYellow == null) {
			lblEndYellow = new JLabel("");
			lblEndYellow.setBounds(0, 80, 120, 40);
			lblEndYellow.setOpaque(true);
			lblEndYellow.setBackground(new Color(255, 0, 0));
			lblEndYellow.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return lblEndYellow;
	}

	private JPanel getPnlCenter() {
		if (pnlCenter == null) {
			pnlCenter = new JPanel();
			pnlCenter.setBounds(250, 250, 120, 120);
			pnlCenter.setLayout(null);
			pnlCenter.add(getLblEndGreen());
			pnlCenter.add(getLblEndred());
			pnlCenter.add(getLblEndBlue());
			pnlCenter.add(getLblEndYellow());
			pnlCenter.add(getLblDice());
		}
		return pnlCenter;
	}

	private JLabel getLbl_16() {
		if (lbl_16 == null) {
			lbl_16 = new JLabel("16");
			lbl_16.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_16.setBounds(0, 0, 30, 60);
			lbl_16.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return lbl_16;
	}

	private JLabel getLbl_15() {
		if (lbl_15 == null) {
			lbl_15 = new JLabel("15");
			lbl_15.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_15.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_15.setBounds(30, 0, 30, 60);
			lbl_15.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return lbl_15;
	}

	private JLabel getLbl_14() {
		if (lbl_14 == null) {
			lbl_14 = new JLabel("14");
			lbl_14.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_14.setBounds(60, 0, 30, 60);
			lbl_14.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return lbl_14;
	}

	private JLabel getLbl_13() {
		if (lbl_13 == null) {
			lbl_13 = new JLabel("13");
			lbl_13.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_13.setBounds(90, 0, 30, 60);
			lbl_13.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return lbl_13;
	}

	private JLabel getLbl_12() {
		if (lbl_12 == null) {
			lbl_12 = new JLabel("12");
			lbl_12.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_12.setOpaque(true);
			lbl_12.setBackground(new Color(192, 192, 192));
			lbl_12.setBounds(120, 0, 30, 60);
			lbl_12.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return lbl_12;
	}

	private JLabel getLbl_11() {
		if (lbl_11 == null) {
			lbl_11 = new JLabel("11");
			lbl_11.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_11.setBounds(150, 0, 30, 60);
			lbl_11.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return lbl_11;
	}

	private JPanel getPnlBlueSide() {
		if (pnlBlueSide == null) {
			pnlBlueSide = new JPanel();
			pnlBlueSide.setBounds(10, 220, 240, 180);
			pnlBlueSide.setLayout(null);
			pnlBlueSide.add(getLbl_16());
			pnlBlueSide.add(getLbl_15());
			pnlBlueSide.add(getLbl_14());
			pnlBlueSide.add(getLbl_13());
			pnlBlueSide.add(getLbl_12());
			pnlBlueSide.add(getLbl_11());
			pnlBlueSide.add(getLbl_10());
			pnlBlueSide.add(getLbl_9());
			pnlBlueSide.add(getLbl_17());
			pnlBlueSide.add(getLabel_4());
			pnlBlueSide.add(getLabel_5());
			pnlBlueSide.add(getLabel_7());
			pnlBlueSide.add(getLabel_8());
			pnlBlueSide.add(getLabel_10());
			pnlBlueSide.add(getLabel_11());
			pnlBlueSide.add(getLabel_13());
			pnlBlueSide.add(getLbl_18());
			pnlBlueSide.add(getLbl_19());
			pnlBlueSide.add(getLbl_20());
			pnlBlueSide.add(getLbl_21());
			pnlBlueSide.add(getLbl_22());
			pnlBlueSide.add(getLbl_23());
			pnlBlueSide.add(getLbl_24());
			pnlBlueSide.add(getLbl_25());
		}
		return pnlBlueSide;
	}

	private JLabel getLbl_10() {
		if (lbl_10 == null) {
			lbl_10 = new JLabel("10");
			lbl_10.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_10.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_10.setBounds(180, 0, 30, 60);
		}
		return lbl_10;
	}

	private JLabel getLbl_9() {
		if (lbl_9 == null) {
			lbl_9 = new JLabel("9");
			lbl_9.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_9.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_9.setBounds(210, 0, 30, 60);
		}
		return lbl_9;
	}

	private JLabel getLbl_17() {
		if (lbl_17 == null) {
			lbl_17 = new JLabel("17");
			lbl_17.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_17.setOpaque(true);
			lbl_17.setBackground(new Color(0, 0, 255));
			lbl_17.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_17.setBounds(0, 60, 30, 60);
		}
		return lbl_17;
	}

	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("");
			label_4.setHorizontalAlignment(SwingConstants.CENTER);
			label_4.setOpaque(true);
			label_4.setBackground(new Color(0, 0, 255));
			label_4.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_4.setBounds(30, 60, 30, 60);
		}
		return label_4;
	}

	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("");
			label_5.setHorizontalAlignment(SwingConstants.CENTER);
			label_5.setOpaque(true);
			label_5.setBackground(new Color(0, 0, 255));
			label_5.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_5.setBounds(60, 60, 30, 60);
		}
		return label_5;
	}

	private JLabel getLabel_7() {
		if (label_7 == null) {
			label_7 = new JLabel("");
			label_7.setHorizontalAlignment(SwingConstants.CENTER);
			label_7.setOpaque(true);
			label_7.setBackground(new Color(0, 0, 255));
			label_7.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_7.setBounds(90, 60, 30, 60);
		}
		return label_7;
	}

	private JLabel getLabel_8() {
		if (label_8 == null) {
			label_8 = new JLabel("");
			label_8.setHorizontalAlignment(SwingConstants.CENTER);
			label_8.setOpaque(true);
			label_8.setBackground(new Color(0, 0, 255));
			label_8.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_8.setBounds(120, 60, 30, 60);
		}
		return label_8;
	}

	private JLabel getLabel_10() {
		if (label_10 == null) {
			label_10 = new JLabel("");
			label_10.setHorizontalAlignment(SwingConstants.CENTER);
			label_10.setOpaque(true);
			label_10.setBackground(new Color(0, 0, 255));
			label_10.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_10.setBounds(150, 60, 30, 60);
		}
		return label_10;
	}

	private JLabel getLabel_11() {
		if (label_11 == null) {
			label_11 = new JLabel("");
			label_11.setHorizontalAlignment(SwingConstants.CENTER);
			label_11.setOpaque(true);
			label_11.setBackground(new Color(0, 0, 255));
			label_11.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_11.setBounds(180, 60, 30, 60);
		}
		return label_11;
	}

	private JLabel getLabel_13() {
		if (label_13 == null) {
			label_13 = new JLabel("");
			label_13.setHorizontalAlignment(SwingConstants.CENTER);
			label_13.setOpaque(true);
			label_13.setBackground(new Color(0, 0, 255));
			label_13.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_13.setBounds(210, 60, 30, 60);
		}
		return label_13;
	}

	private JLabel getLbl_18() {
		if (lbl_18 == null) {
			lbl_18 = new JLabel("18");
			lbl_18.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_18.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_18.setBounds(0, 120, 30, 60);
		}
		return lbl_18;
	}

	private JLabel getLbl_19() {
		if (lbl_19 == null) {
			lbl_19 = new JLabel("19");
			lbl_19.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_19.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_19.setBounds(30, 120, 30, 60);
		}
		return lbl_19;
	}

	private JLabel getLbl_20() {
		if (lbl_20 == null) {
			lbl_20 = new JLabel("20");
			lbl_20.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_20.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_20.setBounds(60, 120, 30, 60);
		}
		return lbl_20;
	}

	private JLabel getLbl_21() {
		if (lbl_21 == null) {
			lbl_21 = new JLabel("21");
			lbl_21.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_21.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_21.setBounds(90, 120, 30, 60);
		}
		return lbl_21;
	}

	private JLabel getLbl_22() {
		if (lbl_22 == null) {
			lbl_22 = new JLabel("22");
			lbl_22.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_22.setBackground(new Color(0, 0, 255));
			lbl_22.setOpaque(true);
			lbl_22.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_22.setBounds(120, 120, 30, 60);
		}
		return lbl_22;
	}

	private JLabel getLbl_23() {
		if (lbl_23 == null) {
			lbl_23 = new JLabel("23");
			lbl_23.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_23.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_23.setBounds(150, 120, 30, 60);
		}
		return lbl_23;
	}

	private JLabel getLbl_24() {
		if (lbl_24 == null) {
			lbl_24 = new JLabel("24");
			lbl_24.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_24.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_24.setBounds(180, 120, 30, 60);
		}
		return lbl_24;
	}

	private JLabel getLbl_25() {
		if (lbl_25 == null) {
			lbl_25 = new JLabel("25");
			lbl_25.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_25.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_25.setBounds(210, 120, 30, 60);
		}
		return lbl_25;
	}

	private JPanel getPnlGreenSide() {
		if (pnlGreenSide == null) {
			pnlGreenSide = new JPanel();
			pnlGreenSide.setLayout(null);
			pnlGreenSide.setBounds(370, 220, 240, 180);
			pnlGreenSide.add(getLbl_59());
			pnlGreenSide.add(getLbl_58());
			pnlGreenSide.add(getLbl_57());
			pnlGreenSide.add(getLbl_56());
			pnlGreenSide.add(getLbl_55());
			pnlGreenSide.add(getLbl_54());
			pnlGreenSide.add(getLbl_53());
			pnlGreenSide.add(getLbl_52());
			pnlGreenSide.add(getLabel_31());
			pnlGreenSide.add(getLabel_32());
			pnlGreenSide.add(getLabel_33());
			pnlGreenSide.add(getLabel_34());
			pnlGreenSide.add(getLabel_35());
			pnlGreenSide.add(getLabel_36());
			pnlGreenSide.add(getLabel_37());
			pnlGreenSide.add(getLbl_51());
			pnlGreenSide.add(getLbl_43());
			pnlGreenSide.add(getLbl_44());
			pnlGreenSide.add(getLbl_45());
			pnlGreenSide.add(getLbl_46());
			pnlGreenSide.add(getLbl_47());
			pnlGreenSide.add(getLbl_48());
			pnlGreenSide.add(getLbl_49());
			pnlGreenSide.add(getLbl_50());
		}
		return pnlGreenSide;
	}

	private JLabel getLbl_59() {
		if (lbl_59 == null) {
			lbl_59 = new JLabel("59");
			lbl_59.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_59.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_59.setBounds(0, 0, 30, 60);
		}
		return lbl_59;
	}

	private JLabel getLbl_58() {
		if (lbl_58 == null) {
			lbl_58 = new JLabel("58");
			lbl_58.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_58.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_58.setBounds(30, 0, 30, 60);
		}
		return lbl_58;
	}

	private JLabel getLbl_57() {
		if (lbl_57 == null) {
			lbl_57 = new JLabel("57");
			lbl_57.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_57.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_57.setBounds(60, 0, 30, 60);
		}
		return lbl_57;
	}

	private JLabel getLbl_56() {
		if (lbl_56 == null) {
			lbl_56 = new JLabel("56");
			lbl_56.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_56.setOpaque(true);
			lbl_56.setBackground(new Color(50, 205, 50));
			lbl_56.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_56.setBounds(90, 0, 30, 60);
		}
		return lbl_56;
	}

	private JLabel getLbl_55() {
		if (lbl_55 == null) {
			lbl_55 = new JLabel("55");
			lbl_55.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_55.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_55.setBounds(120, 0, 30, 60);
		}
		return lbl_55;
	}

	private JLabel getLbl_54() {
		if (lbl_54 == null) {
			lbl_54 = new JLabel("54");
			lbl_54.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_54.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_54.setBounds(150, 0, 30, 60);
		}
		return lbl_54;
	}

	private JLabel getLbl_53() {
		if (lbl_53 == null) {
			lbl_53 = new JLabel("53");
			lbl_53.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_53.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_53.setBounds(180, 0, 30, 60);
		}
		return lbl_53;
	}

	private JLabel getLbl_52() {
		if (lbl_52 == null) {
			lbl_52 = new JLabel("52");
			lbl_52.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_52.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_52.setBounds(210, 0, 30, 60);
		}
		return lbl_52;
	}

	private JLabel getLabel_31() {
		if (label_31 == null) {
			label_31 = new JLabel("");
			label_31.setHorizontalAlignment(SwingConstants.CENTER);
			label_31.setBackground(new Color(50, 205, 50));
			label_31.setOpaque(true);
			label_31.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_31.setBounds(0, 60, 30, 60);
		}
		return label_31;
	}

	private JLabel getLabel_32() {
		if (label_32 == null) {
			label_32 = new JLabel("");
			label_32.setHorizontalAlignment(SwingConstants.CENTER);
			label_32.setBackground(new Color(50, 205, 50));
			label_32.setOpaque(true);
			label_32.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_32.setBounds(30, 60, 30, 60);
		}
		return label_32;
	}

	private JLabel getLabel_33() {
		if (label_33 == null) {
			label_33 = new JLabel("");
			label_33.setHorizontalAlignment(SwingConstants.CENTER);
			label_33.setBackground(new Color(50, 205, 50));
			label_33.setOpaque(true);
			label_33.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_33.setBounds(60, 60, 30, 60);
		}
		return label_33;
	}

	private JLabel getLabel_34() {
		if (label_34 == null) {
			label_34 = new JLabel("");
			label_34.setHorizontalAlignment(SwingConstants.CENTER);
			label_34.setBackground(new Color(50, 205, 50));
			label_34.setOpaque(true);
			label_34.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_34.setBounds(90, 60, 30, 60);
		}
		return label_34;
	}

	private JLabel getLabel_35() {
		if (label_35 == null) {
			label_35 = new JLabel("");
			label_35.setHorizontalAlignment(SwingConstants.CENTER);
			label_35.setBackground(new Color(50, 205, 50));
			label_35.setOpaque(true);
			label_35.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_35.setBounds(120, 60, 30, 60);
		}
		return label_35;
	}

	private JLabel getLabel_36() {
		if (label_36 == null) {
			label_36 = new JLabel("");
			label_36.setHorizontalAlignment(SwingConstants.CENTER);
			label_36.setBackground(new Color(50, 205, 50));
			label_36.setOpaque(true);
			label_36.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_36.setBounds(150, 60, 30, 60);
		}
		return label_36;
	}

	private JLabel getLabel_37() {
		if (label_37 == null) {
			label_37 = new JLabel("");
			label_37.setHorizontalAlignment(SwingConstants.CENTER);
			label_37.setBackground(new Color(50, 205, 50));
			label_37.setOpaque(true);
			label_37.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_37.setBounds(180, 60, 30, 60);
		}
		return label_37;
	}

	private JLabel getLbl_51() {
		if (lbl_51 == null) {
			lbl_51 = new JLabel("51");
			lbl_51.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_51.setBackground(new Color(50, 205, 50));
			lbl_51.setOpaque(true);
			lbl_51.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_51.setBounds(210, 60, 30, 60);
		}
		return lbl_51;
	}

	private JLabel getLbl_43() {
		if (lbl_43 == null) {
			lbl_43 = new JLabel("43");
			lbl_43.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_43.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_43.setBounds(0, 120, 30, 60);
		}
		return lbl_43;
	}

	private JLabel getLbl_44() {
		if (lbl_44 == null) {
			lbl_44 = new JLabel("44");
			lbl_44.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_44.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_44.setBounds(30, 120, 30, 60);
		}
		return lbl_44;
	}

	private JLabel getLbl_45() {
		if (lbl_45 == null) {
			lbl_45 = new JLabel("45");
			lbl_45.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_45.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_45.setBounds(60, 120, 30, 60);
		}
		return lbl_45;
	}

	private JLabel getLbl_46() {
		if (lbl_46 == null) {
			lbl_46 = new JLabel("46");
			lbl_46.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_46.setOpaque(true);
			lbl_46.setBackground(new Color(192, 192, 192));
			lbl_46.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_46.setBounds(90, 120, 30, 60);
		}
		return lbl_46;
	}

	private JLabel getLbl_47() {
		if (lbl_47 == null) {
			lbl_47 = new JLabel("47");
			lbl_47.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_47.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_47.setBounds(120, 120, 30, 60);
		}
		return lbl_47;
	}

	private JLabel getLbl_48() {
		if (lbl_48 == null) {
			lbl_48 = new JLabel("48");
			lbl_48.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_48.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_48.setBounds(150, 120, 30, 60);
		}
		return lbl_48;
	}

	private JLabel getLbl_49() {
		if (lbl_49 == null) {
			lbl_49 = new JLabel("49");
			lbl_49.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_49.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_49.setBounds(180, 120, 30, 60);
		}
		return lbl_49;
	}

	private JLabel getLbl_50() {
		if (lbl_50 == null) {
			lbl_50 = new JLabel("50");
			lbl_50.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_50.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_50.setBounds(210, 120, 30, 60);
		}
		return lbl_50;
	}

	private JPanel getPnlRedSide() {
		if (pnlRedSide == null) {
			pnlRedSide = new JPanel();
			pnlRedSide.setLayout(null);
			pnlRedSide.setBounds(220, 370, 180, 240);
			pnlRedSide.add(getLbl_33());
			pnlRedSide.add(getLbl_34());
			pnlRedSide.add(getLbl_35());
			pnlRedSide.add(getLbl_32());
			pnlRedSide.add(getLabel_50());
			pnlRedSide.add(getLbl_36());
			pnlRedSide.add(getLbl_30());
			pnlRedSide.add(getLabel_53());
			pnlRedSide.add(getLbl_38());
			pnlRedSide.add(getLbl_37());
			pnlRedSide.add(getLabel_56());
			pnlRedSide.add(getLbl_31());
			pnlRedSide.add(getLbl_26());
			pnlRedSide.add(getLbl_27());
			pnlRedSide.add(getLbl_28());
			pnlRedSide.add(getLbl_29());
			pnlRedSide.add(getLabel_62());
			pnlRedSide.add(getLabel_63());
			pnlRedSide.add(getLabel_64());
			pnlRedSide.add(getLabel_65());
			pnlRedSide.add(getLbl_42());
			pnlRedSide.add(getLbl_41());
			pnlRedSide.add(getLbl_40());
			pnlRedSide.add(getLbl_39());
		}
		return pnlRedSide;
	}

	private JLabel getLbl_33() {
		if (lbl_33 == null) {
			lbl_33 = new JLabel("33");
			lbl_33.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_33.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_33.setBounds(0, 210, 60, 30);
		}
		return lbl_33;
	}

	private JLabel getLbl_34() {
		if (lbl_34 == null) {
			lbl_34 = new JLabel("34");
			lbl_34.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_34.setBackground(new Color(255, 0, 0));
			lbl_34.setOpaque(true);
			lbl_34.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_34.setBounds(60, 210, 60, 30);
		}
		return lbl_34;
	}

	private JLabel getLbl_35() {
		if (lbl_35 == null) {
			lbl_35 = new JLabel("35");
			lbl_35.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_35.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_35.setBounds(120, 210, 60, 30);
		}
		return lbl_35;
	}

	private JLabel getLbl_32() {
		if (lbl_32 == null) {
			lbl_32 = new JLabel("32");
			lbl_32.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_32.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_32.setBounds(0, 180, 60, 30);
		}
		return lbl_32;
	}

	private JLabel getLabel_50() {
		if (label_50 == null) {
			label_50 = new JLabel("");
			label_50.setHorizontalAlignment(SwingConstants.CENTER);
			label_50.setBackground(new Color(255, 0, 0));
			label_50.setOpaque(true);
			label_50.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_50.setBounds(60, 180, 60, 30);
		}
		return label_50;
	}

	private JLabel getLbl_36() {
		if (lbl_36 == null) {
			lbl_36 = new JLabel("36");
			lbl_36.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_36.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_36.setBounds(120, 180, 60, 30);
		}
		return lbl_36;
	}

	private JLabel getLbl_30() {
		if (lbl_30 == null) {
			lbl_30 = new JLabel("30");
			lbl_30.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_30.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_30.setBounds(0, 120, 60, 30);
		}
		return lbl_30;
	}

	private JLabel getLabel_53() {
		if (label_53 == null) {
			label_53 = new JLabel("");
			label_53.setHorizontalAlignment(SwingConstants.CENTER);
			label_53.setBackground(new Color(255, 0, 0));
			label_53.setOpaque(true);
			label_53.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_53.setBounds(60, 120, 60, 30);
		}
		return label_53;
	}

	private JLabel getLbl_38() {
		if (lbl_38 == null) {
			lbl_38 = new JLabel("38");
			lbl_38.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_38.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_38.setBounds(120, 120, 60, 30);
		}
		return lbl_38;
	}

	private JLabel getLbl_37() {
		if (lbl_37 == null) {
			lbl_37 = new JLabel("37");
			lbl_37.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_37.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_37.setBounds(120, 150, 60, 30);
		}
		return lbl_37;
	}

	private JLabel getLabel_56() {
		if (label_56 == null) {
			label_56 = new JLabel("");
			label_56.setHorizontalAlignment(SwingConstants.CENTER);
			label_56.setBackground(new Color(255, 0, 0));
			label_56.setOpaque(true);
			label_56.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_56.setBounds(60, 150, 60, 30);
		}
		return label_56;
	}

	private JLabel getLbl_31() {
		if (lbl_31 == null) {
			lbl_31 = new JLabel("31");
			lbl_31.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_31.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_31.setBounds(0, 150, 60, 30);
		}
		return lbl_31;
	}

	private JLabel getLbl_26() {
		if (lbl_26 == null) {
			lbl_26 = new JLabel("26");
			lbl_26.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_26.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_26.setBounds(0, 0, 60, 30);
		}
		return lbl_26;
	}

	private JLabel getLbl_27() {
		if (lbl_27 == null) {
			lbl_27 = new JLabel("27");
			lbl_27.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_27.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_27.setBounds(0, 30, 60, 30);
		}
		return lbl_27;
	}

	private JLabel getLbl_28() {
		if (lbl_28 == null) {
			lbl_28 = new JLabel("28");
			lbl_28.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_28.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_28.setBounds(0, 60, 60, 30);
		}
		return lbl_28;
	}

	private JLabel getLbl_29() {
		if (lbl_29 == null) {
			lbl_29 = new JLabel("29");
			lbl_29.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_29.setOpaque(true);
			lbl_29.setBackground(new Color(192, 192, 192));
			lbl_29.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_29.setBounds(0, 90, 60, 30);
		}
		return lbl_29;
	}

	private JLabel getLabel_62() {
		if (label_62 == null) {
			label_62 = new JLabel("");
			label_62.setHorizontalAlignment(SwingConstants.CENTER);
			label_62.setBackground(new Color(255, 0, 0));
			label_62.setOpaque(true);
			label_62.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_62.setBounds(60, 90, 60, 30);
		}
		return label_62;
	}

	private JLabel getLabel_63() {
		if (label_63 == null) {
			label_63 = new JLabel("");
			label_63.setHorizontalAlignment(SwingConstants.CENTER);
			label_63.setBackground(new Color(255, 0, 0));
			label_63.setOpaque(true);
			label_63.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_63.setBounds(60, 60, 60, 30);
		}
		return label_63;
	}

	private JLabel getLabel_64() {
		if (label_64 == null) {
			label_64 = new JLabel("");
			label_64.setHorizontalAlignment(SwingConstants.CENTER);
			label_64.setBackground(new Color(255, 0, 0));
			label_64.setOpaque(true);
			label_64.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_64.setBounds(60, 30, 60, 30);
		}
		return label_64;
	}

	private JLabel getLabel_65() {
		if (label_65 == null) {
			label_65 = new JLabel("");
			label_65.setHorizontalAlignment(SwingConstants.CENTER);
			label_65.setBackground(new Color(255, 0, 0));
			label_65.setOpaque(true);
			label_65.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_65.setBounds(60, 0, 60, 30);
		}
		return label_65;
	}

	private JLabel getLbl_42() {
		if (lbl_42 == null) {
			lbl_42 = new JLabel("42");
			lbl_42.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_42.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_42.setBounds(120, 0, 60, 30);
		}
		return lbl_42;
	}

	private JLabel getLbl_41() {
		if (lbl_41 == null) {
			lbl_41 = new JLabel("41");
			lbl_41.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_41.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_41.setBounds(120, 30, 60, 30);
		}
		return lbl_41;
	}

	private JLabel getLbl_40() {
		if (lbl_40 == null) {
			lbl_40 = new JLabel("40");
			lbl_40.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_40.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_40.setBounds(120, 60, 60, 30);
		}
		return lbl_40;
	}

	private JLabel getLbl_39() {
		if (lbl_39 == null) {
			lbl_39 = new JLabel("39");
			lbl_39.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_39.setOpaque(true);
			lbl_39.setBackground(new Color(255, 0, 0));
			lbl_39.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_39.setBounds(120, 90, 60, 30);
		}
		return lbl_39;
	}

	private JPanel getPnlYellowSide() {
		if (pnlYellowSide == null) {
			pnlYellowSide = new JPanel();
			pnlYellowSide.setBorder(new LineBorder(new Color(0, 0, 0)));
			pnlYellowSide.setLayout(null);
			pnlYellowSide.setBounds(220, 10, 180, 240);
			pnlYellowSide.add(getLbl_8());
			pnlYellowSide.add(getLabel_71());
			pnlYellowSide.add(getLbl_60());
			pnlYellowSide.add(getLbl_7());
			pnlYellowSide.add(getLabel_74());
			pnlYellowSide.add(getLbl_61());
			pnlYellowSide.add(getLbl_5());
			pnlYellowSide.add(getLabel_77());
			pnlYellowSide.add(getLbl_63());
			pnlYellowSide.add(getLbl_62());
			pnlYellowSide.add(getLabel_80());
			pnlYellowSide.add(getLbl_6());
			pnlYellowSide.add(getLbl_1());
			pnlYellowSide.add(getLbl_2());
			pnlYellowSide.add(getLbl_3());
			pnlYellowSide.add(getLbl_4());
			pnlYellowSide.add(getLabel_86());
			pnlYellowSide.add(getLabel_87());
			pnlYellowSide.add(getLabel_88());
			pnlYellowSide.add(getLbl_68());
			pnlYellowSide.add(getLbl_67());
			pnlYellowSide.add(getLbl_66());
			pnlYellowSide.add(getLbl_65());
			pnlYellowSide.add(getLbl_64());
		}
		return pnlYellowSide;
	}

	private JLabel getLbl_8() {
		if (lbl_8 == null) {
			lbl_8 = new JLabel("8");
			lbl_8.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_8.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_8.setBounds(0, 210, 60, 30);
		}
		return lbl_8;
	}

	private JLabel getLabel_71() {
		if (label_71 == null) {
			label_71 = new JLabel("");
			label_71.setHorizontalAlignment(SwingConstants.CENTER);
			label_71.setBackground(new Color(255, 255, 0));
			label_71.setOpaque(true);
			label_71.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_71.setBounds(60, 210, 60, 30);
		}
		return label_71;
	}

	private JLabel getLbl_60() {
		if (lbl_60 == null) {
			lbl_60 = new JLabel("60");
			lbl_60.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_60.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_60.setBounds(120, 210, 60, 30);
		}
		return lbl_60;
	}

	private JLabel getLbl_7() {
		if (lbl_7 == null) {
			lbl_7 = new JLabel("7");
			lbl_7.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_7.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_7.setBounds(0, 180, 60, 30);
		}
		return lbl_7;
	}

	private JLabel getLabel_74() {
		if (label_74 == null) {
			label_74 = new JLabel("");
			label_74.setHorizontalAlignment(SwingConstants.CENTER);
			label_74.setOpaque(true);
			label_74.setBackground(new Color(255, 255, 0));
			label_74.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_74.setBounds(60, 180, 60, 30);
		}
		return label_74;
	}

	private JLabel getLbl_61() {
		if (lbl_61 == null) {
			lbl_61 = new JLabel("61");
			lbl_61.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_61.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_61.setBounds(120, 180, 60, 30);
		}
		return lbl_61;
	}

	private JLabel getLbl_5() {
		if (lbl_5 == null) {
			lbl_5 = new JLabel("5");
			lbl_5.setOpaque(true);
			lbl_5.setBackground(new Color(255, 255, 0));
			lbl_5.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_5.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_5.setBounds(0, 120, 60, 30);
		}
		return lbl_5;
	}

	private JLabel getLabel_77() {
		if (label_77 == null) {
			label_77 = new JLabel("");
			label_77.setHorizontalAlignment(SwingConstants.CENTER);
			label_77.setOpaque(true);
			label_77.setBackground(new Color(255, 255, 0));
			label_77.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_77.setBounds(60, 120, 60, 30);
		}
		return label_77;
	}

	private JLabel getLbl_63() {
		if (lbl_63 == null) {
			lbl_63 = new JLabel("63");
			lbl_63.setOpaque(true);
			lbl_63.setBackground(new Color(192, 192, 192));
			lbl_63.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_63.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_63.setBounds(120, 120, 60, 30);
		}
		return lbl_63;
	}

	private JLabel getLbl_62() {
		if (lbl_62 == null) {
			lbl_62 = new JLabel("62");
			lbl_62.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_62.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_62.setBounds(120, 150, 60, 30);
		}
		return lbl_62;
	}

	private JLabel getLabel_80() {
		if (label_80 == null) {
			label_80 = new JLabel("");
			label_80.setHorizontalAlignment(SwingConstants.CENTER);
			label_80.setOpaque(true);
			label_80.setBackground(new Color(255, 255, 0));
			label_80.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_80.setBounds(60, 150, 60, 30);
		}
		return label_80;
	}

	private JLabel getLbl_6() {
		if (lbl_6 == null) {
			lbl_6 = new JLabel("6");
			lbl_6.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_6.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_6.setBounds(0, 150, 60, 30);
		}
		return lbl_6;
	}

	private JLabel getLbl_1() {
		if (lbl_1 == null) {
			lbl_1 = new JLabel("1");
			lbl_1.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_1.setBounds(0, 0, 60, 30);
		}
		return lbl_1;
	}

	private JLabel getLbl_2() {
		if (lbl_2 == null) {
			lbl_2 = new JLabel("2");
			lbl_2.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_2.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_2.setBounds(0, 30, 60, 30);
		}
		return lbl_2;
	}

	private JLabel getLbl_3() {
		if (lbl_3 == null) {
			lbl_3 = new JLabel("3");
			lbl_3.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_3.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_3.setBounds(0, 60, 60, 30);
		}
		return lbl_3;
	}

	private JLabel getLbl_4() {
		if (lbl_4 == null) {
			lbl_4 = new JLabel("4");
			lbl_4.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_4.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_4.setBounds(0, 90, 60, 30);
		}
		return lbl_4;
	}

	private JLabel getLabel_86() {
		if (label_86 == null) {
			label_86 = new JLabel("");
			label_86.setHorizontalAlignment(SwingConstants.CENTER);
			label_86.setOpaque(true);
			label_86.setBackground(new Color(255, 255, 0));
			label_86.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_86.setBounds(60, 90, 60, 30);
		}
		return label_86;
	}

	private JLabel getLabel_87() {
		if (label_87 == null) {
			label_87 = new JLabel("");
			label_87.setHorizontalAlignment(SwingConstants.CENTER);
			label_87.setOpaque(true);
			label_87.setBackground(new Color(255, 255, 0));
			label_87.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_87.setBounds(60, 60, 60, 30);
		}
		return label_87;
	}

	private JLabel getLabel_88() {
		if (label_88 == null) {
			label_88 = new JLabel("");
			label_88.setHorizontalAlignment(SwingConstants.CENTER);
			label_88.setOpaque(true);
			label_88.setBackground(new Color(255, 255, 0));
			label_88.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_88.setBounds(60, 30, 60, 30);
		}
		return label_88;
	}

	private JLabel getLbl_68() {
		if (lbl_68 == null) {
			lbl_68 = new JLabel("68");
			lbl_68.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_68.setOpaque(true);
			lbl_68.setBackground(new Color(255, 255, 0));
			lbl_68.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_68.setBounds(60, 0, 60, 30);
		}
		return lbl_68;
	}

	private JLabel getLbl_67() {
		if (lbl_67 == null) {
			lbl_67 = new JLabel("67");
			lbl_67.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_67.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_67.setBounds(120, 0, 60, 30);
		}
		return lbl_67;
	}

	private JLabel getLbl_66() {
		if (lbl_66 == null) {
			lbl_66 = new JLabel("66");
			lbl_66.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_66.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_66.setBounds(120, 30, 60, 30);
		}
		return lbl_66;
	}

	private JLabel getLbl_65() {
		if (lbl_65 == null) {
			lbl_65 = new JLabel("65");
			lbl_65.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_65.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_65.setBounds(120, 60, 60, 30);
		}
		return lbl_65;
	}

	private JLabel getLbl_64() {
		if (lbl_64 == null) {
			lbl_64 = new JLabel("64");
			lbl_64.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_64.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbl_64.setBounds(120, 90, 60, 30);
		}
		return lbl_64;
	}

	private JLabel getLblYellowPlayerAvatar() {
		if (lblYellowPlayerAvatar == null) {
			lblYellowPlayerAvatar = new JLabel("");
			lblYellowPlayerAvatar.setBorder(new BevelBorder(
					BevelBorder.LOWERED, null, null, null, null));
			lblYellowPlayerAvatar.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Avatars/2.jpg")));
			lblYellowPlayerAvatar.setBounds(10, 30, 100, 120);
		}
		return lblYellowPlayerAvatar;
	}

	private JLabel getLblYellowPlayerName() {
		if (lblYellowPlayerName == null) {
			lblYellowPlayerName = new JLabel();
			lblYellowPlayerName.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblYellowPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
			lblYellowPlayerName.setBounds(10, 11, 100, 14);
		}
		return lblYellowPlayerName;
	}

	private JLabel getLblGreenPlayerAvatar() {
		if (lblGreenPlayerAvatar == null) {
			lblGreenPlayerAvatar = new JLabel("");
			lblGreenPlayerAvatar.setBorder(new BevelBorder(BevelBorder.LOWERED,
					null, null, null, null));
			lblGreenPlayerAvatar.setHorizontalAlignment(SwingConstants.CENTER);
			lblGreenPlayerAvatar.setBounds(100, 30, 100, 120);
		}
		return lblGreenPlayerAvatar;
	}

	private JLabel getLblGreenPlayerName() {
		if (lblGreenPlayerName == null) {
			lblGreenPlayerName = new JLabel("");
			lblGreenPlayerName.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblGreenPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
			lblGreenPlayerName.setBounds(100, 11, 100, 14);
		}
		return lblGreenPlayerName;
	}

	private JLabel getLblRedPlayerAvatar() {
		if (lblRedPlayerAvatar == null) {
			lblRedPlayerAvatar = new JLabel("");
			lblRedPlayerAvatar.setBorder(new BevelBorder(BevelBorder.LOWERED,
					null, null, null, null));
			lblRedPlayerAvatar.setHorizontalAlignment(SwingConstants.CENTER);
			lblRedPlayerAvatar.setBounds(100, 62, 100, 120);
		}
		return lblRedPlayerAvatar;
	}

	private JLabel getLblRedPlayerName() {
		if (lblRedPlayerName == null) {
			lblRedPlayerName = new JLabel("");
			lblRedPlayerName.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblRedPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
			lblRedPlayerName.setBounds(105, 185, 95, 14);
		}
		return lblRedPlayerName;
	}

	private JLabel getLblBluePlayerAvatar() {
		if (lblBluePlayerAvatar == null) {
			lblBluePlayerAvatar = new JLabel("");
			lblBluePlayerAvatar.setBorder(new BevelBorder(BevelBorder.LOWERED,
					null, null, null, null));
			lblBluePlayerAvatar.setHorizontalAlignment(SwingConstants.CENTER);
			lblBluePlayerAvatar.setBounds(10, 65, 100, 120);
		}
		return lblBluePlayerAvatar;
	}

	private JLabel getLblBluePlayerName() {
		if (lblBluePlayerName == null) {
			lblBluePlayerName = new JLabel("");
			lblBluePlayerName.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblBluePlayerName.setHorizontalAlignment(SwingConstants.CENTER);
			lblBluePlayerName.setBounds(10, 185, 100, 14);
		}
		return lblBluePlayerName;
	}

	private JLabel getLblDice() {
		if (lblDice == null) {
			lblDice = new JLabel("New label");
			lblDice.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Dice/1_40x40.png")));
			lblDice.setBounds(40, 40, 40, 40);
		}
		return lblDice;
	}

	private JLabel getLblBlueDice() {
		if (lblBlueDice == null) {
			lblBlueDice = new JLabel("");
			lblBlueDice.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Dice/1_40x40.png")));
			lblBlueDice.setBounds(10, 11, 40, 40);
		}
		return lblBlueDice;
	}

	private JLabel getLblRedDice() {
		if (lblRedDice == null) {
			lblRedDice = new JLabel("");
			lblRedDice.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Dice/1_40x40.png")));
			lblRedDice.setBounds(160, 11, 40, 40);
		}
		return lblRedDice;
	}

	private JLabel getLblGreenDice() {
		if (lblGreenDice == null) {
			lblGreenDice = new JLabel("");
			lblGreenDice.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Dice/1_40x40.png")));
			lblGreenDice.setBounds(160, 161, 40, 40);
		}
		return lblGreenDice;
	}

	private JLabel getLblYellowDice() {
		if (lblYellowDice == null) {
			lblYellowDice = new JLabel("");
			lblYellowDice.setIcon(new ImageIcon(LudoUI.class
					.getResource("/images/Dice/1_40x40.png")));
			lblYellowDice.setBounds(10, 159, 40, 40);
		}
		return lblYellowDice;
	}

	private JButton getButton() {
		if (button == null) {
			button = new JButton();
			button.setText("Quit");
			button.setBounds(538, 788, 86, 23);
		}
		return button;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setText((String) null);
			textField.setBounds(10, 791, 493, 20);
		}
		return textField;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 655, 493, 128);
			scrollPane.setViewportView(getTextPane());
		}
		return scrollPane;
	}

	private JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
			textPane.setEditable(false);
		}
		return textPane;
	}

	private JLabel getLblState() {
		if (lblState == null) {
			lblState = new JLabel("Estado");
			lblState.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblState.setBounds(10, 635, 622, 14);
		}
		return lblState;
	}

	@Override
	public void updateBoard(int nextTurn) {
		// TODO Auto-generated method stub

	}

	@Override
	public void lostGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public void receiveMessage(String sender, String message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void receivePrivateMessage(String sender, String message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void userLeaveGame(String player) {
		// TODO Auto-generated method stub

	}
}
