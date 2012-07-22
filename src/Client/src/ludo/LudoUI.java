package ludo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;

public class LudoUI extends JFrame {
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
	private JLabel lblNewLabel;
	private JVertLabel label_3;
	private JLabel label_6;
	private JLabel label_9;
	private JLabel label_12;
	private JLabel label_15;
	private JPanel pnlBlueSide;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_16;
	private JLabel label_17;
	private JLabel label_18;
	private JLabel label_19;
	private JLabel label_20;
	private JLabel label_21;
	private JLabel label_22;
	private JPanel pnlGreenSide;
	private JLabel label_23;
	private JLabel label_24;
	private JLabel label_25;
	private JLabel label_26;
	private JLabel label_27;
	private JLabel label_28;
	private JLabel label_29;
	private JLabel label_30;
	private JLabel label_31;
	private JLabel label_32;
	private JLabel label_33;
	private JLabel label_34;
	private JLabel label_35;
	private JLabel label_36;
	private JLabel label_37;
	private JLabel label_38;
	private JLabel label_39;
	private JLabel label_40;
	private JLabel label_41;
	private JLabel label_42;
	private JLabel label_43;
	private JLabel label_44;
	private JLabel label_45;
	private JLabel label_46;
	private JPanel pnlRedSide;
	private JLabel lblNewLabel_1;
	private JLabel label_47;
	private JLabel label_48;
	private JLabel label_49;
	private JLabel label_50;
	private JLabel label_51;
	private JLabel label_52;
	private JLabel label_53;
	private JLabel label_54;
	private JLabel label_55;
	private JLabel label_56;
	private JLabel label_57;
	private JLabel label_58;
	private JLabel label_59;
	private JLabel label_60;
	private JLabel label_61;
	private JLabel label_62;
	private JLabel label_63;
	private JLabel label_64;
	private JLabel label_65;
	private JLabel label_66;
	private JLabel label_67;
	private JLabel label_68;
	private JLabel label_69;
	private JPanel pnlYellowSide;
	private JLabel label_70;
	private JLabel label_71;
	private JLabel label_72;
	private JLabel label_73;
	private JLabel label_74;
	private JLabel label_75;
	private JLabel label_76;
	private JLabel label_77;
	private JLabel label_78;
	private JLabel label_79;
	private JLabel label_80;
	private JLabel label_81;
	private JLabel label_82;
	private JLabel label_83;
	private JLabel label_84;
	private JLabel label_85;
	private JLabel label_86;
	private JLabel label_87;
	private JLabel label_88;
	private JLabel label_89;
	private JLabel label_90;
	private JLabel label_91;
	private JLabel label_92;
	private JLabel label_93;
	private JLabel lblYellowPlayerAvatar;
	private JLabel lblYellowPlayerName;
	private JLabel lblGreenPlayerAvatar;
	private JLabel lblGreenPlayerName;
	private JLabel lblRedPlayerAvatar;
	private JLabel lblRedPlayerName;
	private JLabel lblBluePlayerAvatar;
	private JLabel lblBluePlayerName;
	private JLabel lblDice;

	public LudoUI() {
		initGUI();
	}

	private void initGUI() {
		setResizable(false);
		getContentPane().setLayout(null);
		getContentPane().add(getPnlBackground());
	}

	private JPanel getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setBounds(0, 0, 706, 733);
			pnlBackground.setLayout(null);
			pnlBackground.add(getPnlBoard());
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
			pnlYellowPlayer.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlYellowPlayer.setBounds(10, 12, 210, 210);
			pnlYellowPlayer.setLayout(null);
			pnlYellowPlayer.add(getLblYellowPlayerAvatar());
			pnlYellowPlayer.add(getLblYellowPlayerName());
		}
		return pnlYellowPlayer;
	}

	private JPanel getPnlBluePlayer() {
		if (pnlBluePlayer == null) {
			pnlBluePlayer = new JPanel();
			pnlBluePlayer.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlBluePlayer.setBounds(10, 400, 210, 210);
			pnlBluePlayer.setLayout(null);
			pnlBluePlayer.add(getLblBluePlayerAvatar());
			pnlBluePlayer.add(getLblBluePlayerName());
		}
		return pnlBluePlayer;
	}

	private JPanel getPnlRedPlayer() {
		if (pnlRedPlayer == null) {
			pnlRedPlayer = new JPanel();
			pnlRedPlayer.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlRedPlayer.setBounds(400, 400, 210, 210);
			pnlRedPlayer.setLayout(null);
			pnlRedPlayer.add(getLblRedPlayerAvatar());
			pnlRedPlayer.add(getLblRedPlayerName());
		}
		return pnlRedPlayer;
	}

	private JPanel getPnlGreenPlayer() {
		if (pnlGreenPlayer == null) {
			pnlGreenPlayer = new JPanel();
			pnlGreenPlayer.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlGreenPlayer.setBounds(400, 12, 210, 210);
			pnlGreenPlayer.setLayout(null);
			pnlGreenPlayer.add(getLblGreenPlayerAvatar());
			pnlGreenPlayer.add(getLblGreenPlayerName());
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

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("16");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(0, 0, 30, 60);
			lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return lblNewLabel;
	}

	private JVertLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JVertLabel("15");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(30, 0, 30, 60);
			label_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return label_3;
	}

	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("14");
			label_6.setHorizontalAlignment(SwingConstants.CENTER);
			label_6.setBounds(60, 0, 30, 60);
			label_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return label_6;
	}

	private JLabel getLabel_9() {
		if (label_9 == null) {
			label_9 = new JLabel("13");
			label_9.setHorizontalAlignment(SwingConstants.CENTER);
			label_9.setBounds(90, 0, 30, 60);
			label_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return label_9;
	}

	private JLabel getLabel_12() {
		if (label_12 == null) {
			label_12 = new JLabel("12");
			label_12.setHorizontalAlignment(SwingConstants.CENTER);
			label_12.setOpaque(true);
			label_12.setBackground(new Color(192, 192, 192));
			label_12.setBounds(120, 0, 30, 60);
			label_12.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return label_12;
	}

	private JLabel getLabel_15() {
		if (label_15 == null) {
			label_15 = new JLabel("11");
			label_15.setHorizontalAlignment(SwingConstants.CENTER);
			label_15.setBounds(150, 0, 30, 60);
			label_15.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return label_15;
	}

	private JPanel getPnlBlueSide() {
		if (pnlBlueSide == null) {
			pnlBlueSide = new JPanel();
			pnlBlueSide.setBounds(10, 220, 240, 180);
			pnlBlueSide.setLayout(null);
			pnlBlueSide.add(getLblNewLabel());
			pnlBlueSide.add(getLabel_3());
			pnlBlueSide.add(getLabel_6());
			pnlBlueSide.add(getLabel_9());
			pnlBlueSide.add(getLabel_12());
			pnlBlueSide.add(getLabel_15());
			pnlBlueSide.add(getLabel());
			pnlBlueSide.add(getLabel_1());
			pnlBlueSide.add(getLabel_2());
			pnlBlueSide.add(getLabel_4());
			pnlBlueSide.add(getLabel_5());
			pnlBlueSide.add(getLabel_7());
			pnlBlueSide.add(getLabel_8());
			pnlBlueSide.add(getLabel_10());
			pnlBlueSide.add(getLabel_11());
			pnlBlueSide.add(getLabel_13());
			pnlBlueSide.add(getLabel_14());
			pnlBlueSide.add(getLabel_16());
			pnlBlueSide.add(getLabel_17());
			pnlBlueSide.add(getLabel_18());
			pnlBlueSide.add(getLabel_19());
			pnlBlueSide.add(getLabel_20());
			pnlBlueSide.add(getLabel_21());
			pnlBlueSide.add(getLabel_22());
		}
		return pnlBlueSide;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("10");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBorder(new LineBorder(new Color(0, 0, 0)));
			label.setBounds(180, 0, 30, 60);
		}
		return label;
	}

	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("9");
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_1.setBounds(210, 0, 30, 60);
		}
		return label_1;
	}

	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("17");
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			label_2.setOpaque(true);
			label_2.setBackground(new Color(0, 0, 255));
			label_2.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_2.setBounds(0, 60, 30, 60);
		}
		return label_2;
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

	private JLabel getLabel_14() {
		if (label_14 == null) {
			label_14 = new JLabel("18");
			label_14.setHorizontalAlignment(SwingConstants.CENTER);
			label_14.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_14.setBounds(0, 120, 30, 60);
		}
		return label_14;
	}

	private JLabel getLabel_16() {
		if (label_16 == null) {
			label_16 = new JLabel("19");
			label_16.setHorizontalAlignment(SwingConstants.CENTER);
			label_16.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_16.setBounds(30, 120, 30, 60);
		}
		return label_16;
	}

	private JLabel getLabel_17() {
		if (label_17 == null) {
			label_17 = new JLabel("20");
			label_17.setHorizontalAlignment(SwingConstants.CENTER);
			label_17.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_17.setBounds(60, 120, 30, 60);
		}
		return label_17;
	}

	private JLabel getLabel_18() {
		if (label_18 == null) {
			label_18 = new JLabel("21");
			label_18.setHorizontalAlignment(SwingConstants.CENTER);
			label_18.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_18.setBounds(90, 120, 30, 60);
		}
		return label_18;
	}

	private JLabel getLabel_19() {
		if (label_19 == null) {
			label_19 = new JLabel("22");
			label_19.setHorizontalAlignment(SwingConstants.CENTER);
			label_19.setBackground(new Color(0, 0, 255));
			label_19.setOpaque(true);
			label_19.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_19.setBounds(120, 120, 30, 60);
		}
		return label_19;
	}

	private JLabel getLabel_20() {
		if (label_20 == null) {
			label_20 = new JLabel("23");
			label_20.setHorizontalAlignment(SwingConstants.CENTER);
			label_20.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_20.setBounds(150, 120, 30, 60);
		}
		return label_20;
	}

	private JLabel getLabel_21() {
		if (label_21 == null) {
			label_21 = new JLabel("24");
			label_21.setHorizontalAlignment(SwingConstants.CENTER);
			label_21.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_21.setBounds(180, 120, 30, 60);
		}
		return label_21;
	}

	private JLabel getLabel_22() {
		if (label_22 == null) {
			label_22 = new JLabel("25");
			label_22.setHorizontalAlignment(SwingConstants.CENTER);
			label_22.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_22.setBounds(210, 120, 30, 60);
		}
		return label_22;
	}

	private JPanel getPnlGreenSide() {
		if (pnlGreenSide == null) {
			pnlGreenSide = new JPanel();
			pnlGreenSide.setLayout(null);
			pnlGreenSide.setBounds(370, 220, 240, 180);
			pnlGreenSide.add(getLabel_23());
			pnlGreenSide.add(getLabel_24());
			pnlGreenSide.add(getLabel_25());
			pnlGreenSide.add(getLabel_26());
			pnlGreenSide.add(getLabel_27());
			pnlGreenSide.add(getLabel_28());
			pnlGreenSide.add(getLabel_29());
			pnlGreenSide.add(getLabel_30());
			pnlGreenSide.add(getLabel_31());
			pnlGreenSide.add(getLabel_32());
			pnlGreenSide.add(getLabel_33());
			pnlGreenSide.add(getLabel_34());
			pnlGreenSide.add(getLabel_35());
			pnlGreenSide.add(getLabel_36());
			pnlGreenSide.add(getLabel_37());
			pnlGreenSide.add(getLabel_38());
			pnlGreenSide.add(getLabel_39());
			pnlGreenSide.add(getLabel_40());
			pnlGreenSide.add(getLabel_41());
			pnlGreenSide.add(getLabel_42());
			pnlGreenSide.add(getLabel_43());
			pnlGreenSide.add(getLabel_44());
			pnlGreenSide.add(getLabel_45());
			pnlGreenSide.add(getLabel_46());
		}
		return pnlGreenSide;
	}

	private JLabel getLabel_23() {
		if (label_23 == null) {
			label_23 = new JLabel("59");
			label_23.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_23.setBounds(0, 0, 30, 60);
		}
		return label_23;
	}

	private JLabel getLabel_24() {
		if (label_24 == null) {
			label_24 = new JLabel("58");
			label_24.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_24.setBounds(30, 0, 30, 60);
		}
		return label_24;
	}

	private JLabel getLabel_25() {
		if (label_25 == null) {
			label_25 = new JLabel("57");
			label_25.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_25.setBounds(60, 0, 30, 60);
		}
		return label_25;
	}

	private JLabel getLabel_26() {
		if (label_26 == null) {
			label_26 = new JLabel("56");
			label_26.setOpaque(true);
			label_26.setBackground(new Color(50, 205, 50));
			label_26.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_26.setBounds(90, 0, 30, 60);
		}
		return label_26;
	}

	private JLabel getLabel_27() {
		if (label_27 == null) {
			label_27 = new JLabel("55");
			label_27.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_27.setBounds(120, 0, 30, 60);
		}
		return label_27;
	}

	private JLabel getLabel_28() {
		if (label_28 == null) {
			label_28 = new JLabel("54");
			label_28.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_28.setBounds(150, 0, 30, 60);
		}
		return label_28;
	}

	private JLabel getLabel_29() {
		if (label_29 == null) {
			label_29 = new JLabel("53");
			label_29.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_29.setBounds(180, 0, 30, 60);
		}
		return label_29;
	}

	private JLabel getLabel_30() {
		if (label_30 == null) {
			label_30 = new JLabel("52");
			label_30.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_30.setBounds(210, 0, 30, 60);
		}
		return label_30;
	}

	private JLabel getLabel_31() {
		if (label_31 == null) {
			label_31 = new JLabel("");
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
			label_37.setBackground(new Color(50, 205, 50));
			label_37.setOpaque(true);
			label_37.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_37.setBounds(180, 60, 30, 60);
		}
		return label_37;
	}

	private JLabel getLabel_38() {
		if (label_38 == null) {
			label_38 = new JLabel("51");
			label_38.setBackground(new Color(50, 205, 50));
			label_38.setOpaque(true);
			label_38.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_38.setBounds(210, 60, 30, 60);
		}
		return label_38;
	}

	private JLabel getLabel_39() {
		if (label_39 == null) {
			label_39 = new JLabel("43");
			label_39.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_39.setBounds(0, 120, 30, 60);
		}
		return label_39;
	}

	private JLabel getLabel_40() {
		if (label_40 == null) {
			label_40 = new JLabel("44");
			label_40.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_40.setBounds(30, 120, 30, 60);
		}
		return label_40;
	}

	private JLabel getLabel_41() {
		if (label_41 == null) {
			label_41 = new JLabel("45");
			label_41.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_41.setBounds(60, 120, 30, 60);
		}
		return label_41;
	}

	private JLabel getLabel_42() {
		if (label_42 == null) {
			label_42 = new JLabel("46");
			label_42.setOpaque(true);
			label_42.setBackground(new Color(192, 192, 192));
			label_42.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_42.setBounds(90, 120, 30, 60);
		}
		return label_42;
	}

	private JLabel getLabel_43() {
		if (label_43 == null) {
			label_43 = new JLabel("47");
			label_43.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_43.setBounds(120, 120, 30, 60);
		}
		return label_43;
	}

	private JLabel getLabel_44() {
		if (label_44 == null) {
			label_44 = new JLabel("48");
			label_44.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_44.setBounds(150, 120, 30, 60);
		}
		return label_44;
	}

	private JLabel getLabel_45() {
		if (label_45 == null) {
			label_45 = new JLabel("49");
			label_45.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_45.setBounds(180, 120, 30, 60);
		}
		return label_45;
	}

	private JLabel getLabel_46() {
		if (label_46 == null) {
			label_46 = new JLabel("50");
			label_46.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_46.setBounds(210, 120, 30, 60);
		}
		return label_46;
	}

	private JPanel getPnlRedSide() {
		if (pnlRedSide == null) {
			pnlRedSide = new JPanel();
			pnlRedSide.setLayout(null);
			pnlRedSide.setBounds(220, 370, 180, 240);
			pnlRedSide.add(getLblNewLabel_1());
			pnlRedSide.add(getLabel_47());
			pnlRedSide.add(getLabel_48());
			pnlRedSide.add(getLabel_49());
			pnlRedSide.add(getLabel_50());
			pnlRedSide.add(getLabel_51());
			pnlRedSide.add(getLabel_52());
			pnlRedSide.add(getLabel_53());
			pnlRedSide.add(getLabel_54());
			pnlRedSide.add(getLabel_55());
			pnlRedSide.add(getLabel_56());
			pnlRedSide.add(getLabel_57());
			pnlRedSide.add(getLabel_58());
			pnlRedSide.add(getLabel_59());
			pnlRedSide.add(getLabel_60());
			pnlRedSide.add(getLabel_61());
			pnlRedSide.add(getLabel_62());
			pnlRedSide.add(getLabel_63());
			pnlRedSide.add(getLabel_64());
			pnlRedSide.add(getLabel_65());
			pnlRedSide.add(getLabel_66());
			pnlRedSide.add(getLabel_67());
			pnlRedSide.add(getLabel_68());
			pnlRedSide.add(getLabel_69());
		}
		return pnlRedSide;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("33");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblNewLabel_1.setBounds(0, 210, 60, 30);
		}
		return lblNewLabel_1;
	}

	private JLabel getLabel_47() {
		if (label_47 == null) {
			label_47 = new JLabel("34");
			label_47.setHorizontalAlignment(SwingConstants.CENTER);
			label_47.setBackground(new Color(255, 0, 0));
			label_47.setOpaque(true);
			label_47.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_47.setBounds(60, 210, 60, 30);
		}
		return label_47;
	}

	private JLabel getLabel_48() {
		if (label_48 == null) {
			label_48 = new JLabel("35");
			label_48.setHorizontalAlignment(SwingConstants.CENTER);
			label_48.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_48.setBounds(120, 210, 60, 30);
		}
		return label_48;
	}

	private JLabel getLabel_49() {
		if (label_49 == null) {
			label_49 = new JLabel("32");
			label_49.setHorizontalAlignment(SwingConstants.CENTER);
			label_49.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_49.setBounds(0, 180, 60, 30);
		}
		return label_49;
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

	private JLabel getLabel_51() {
		if (label_51 == null) {
			label_51 = new JLabel("36");
			label_51.setHorizontalAlignment(SwingConstants.CENTER);
			label_51.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_51.setBounds(120, 180, 60, 30);
		}
		return label_51;
	}

	private JLabel getLabel_52() {
		if (label_52 == null) {
			label_52 = new JLabel("30");
			label_52.setHorizontalAlignment(SwingConstants.CENTER);
			label_52.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_52.setBounds(0, 120, 60, 30);
		}
		return label_52;
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

	private JLabel getLabel_54() {
		if (label_54 == null) {
			label_54 = new JLabel("38");
			label_54.setHorizontalAlignment(SwingConstants.CENTER);
			label_54.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_54.setBounds(120, 120, 60, 30);
		}
		return label_54;
	}

	private JLabel getLabel_55() {
		if (label_55 == null) {
			label_55 = new JLabel("37");
			label_55.setHorizontalAlignment(SwingConstants.CENTER);
			label_55.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_55.setBounds(120, 150, 60, 30);
		}
		return label_55;
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

	private JLabel getLabel_57() {
		if (label_57 == null) {
			label_57 = new JLabel("31");
			label_57.setHorizontalAlignment(SwingConstants.CENTER);
			label_57.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_57.setBounds(0, 150, 60, 30);
		}
		return label_57;
	}

	private JLabel getLabel_58() {
		if (label_58 == null) {
			label_58 = new JLabel("26");
			label_58.setHorizontalAlignment(SwingConstants.CENTER);
			label_58.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_58.setBounds(0, 0, 60, 30);
		}
		return label_58;
	}

	private JLabel getLabel_59() {
		if (label_59 == null) {
			label_59 = new JLabel("27");
			label_59.setHorizontalAlignment(SwingConstants.CENTER);
			label_59.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_59.setBounds(0, 30, 60, 30);
		}
		return label_59;
	}

	private JLabel getLabel_60() {
		if (label_60 == null) {
			label_60 = new JLabel("28");
			label_60.setHorizontalAlignment(SwingConstants.CENTER);
			label_60.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_60.setBounds(0, 60, 60, 30);
		}
		return label_60;
	}

	private JLabel getLabel_61() {
		if (label_61 == null) {
			label_61 = new JLabel("29");
			label_61.setHorizontalAlignment(SwingConstants.CENTER);
			label_61.setOpaque(true);
			label_61.setBackground(new Color(192, 192, 192));
			label_61.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_61.setBounds(0, 90, 60, 30);
		}
		return label_61;
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

	private JLabel getLabel_66() {
		if (label_66 == null) {
			label_66 = new JLabel("42");
			label_66.setHorizontalAlignment(SwingConstants.CENTER);
			label_66.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_66.setBounds(120, 0, 60, 30);
		}
		return label_66;
	}

	private JLabel getLabel_67() {
		if (label_67 == null) {
			label_67 = new JLabel("41");
			label_67.setHorizontalAlignment(SwingConstants.CENTER);
			label_67.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_67.setBounds(120, 30, 60, 30);
		}
		return label_67;
	}

	private JLabel getLabel_68() {
		if (label_68 == null) {
			label_68 = new JLabel("40");
			label_68.setHorizontalAlignment(SwingConstants.CENTER);
			label_68.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_68.setBounds(120, 60, 60, 30);
		}
		return label_68;
	}

	private JLabel getLabel_69() {
		if (label_69 == null) {
			label_69 = new JLabel("39");
			label_69.setHorizontalAlignment(SwingConstants.CENTER);
			label_69.setOpaque(true);
			label_69.setBackground(new Color(255, 0, 0));
			label_69.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_69.setBounds(120, 90, 60, 30);
		}
		return label_69;
	}

	private JPanel getPnlYellowSide() {
		if (pnlYellowSide == null) {
			pnlYellowSide = new JPanel();
			pnlYellowSide.setLayout(null);
			pnlYellowSide.setBounds(220, 10, 180, 240);
			pnlYellowSide.add(getLabel_70());
			pnlYellowSide.add(getLabel_71());
			pnlYellowSide.add(getLabel_72());
			pnlYellowSide.add(getLabel_73());
			pnlYellowSide.add(getLabel_74());
			pnlYellowSide.add(getLabel_75());
			pnlYellowSide.add(getLabel_76());
			pnlYellowSide.add(getLabel_77());
			pnlYellowSide.add(getLabel_78());
			pnlYellowSide.add(getLabel_79());
			pnlYellowSide.add(getLabel_80());
			pnlYellowSide.add(getLabel_81());
			pnlYellowSide.add(getLabel_82());
			pnlYellowSide.add(getLabel_83());
			pnlYellowSide.add(getLabel_84());
			pnlYellowSide.add(getLabel_85());
			pnlYellowSide.add(getLabel_86());
			pnlYellowSide.add(getLabel_87());
			pnlYellowSide.add(getLabel_88());
			pnlYellowSide.add(getLabel_89());
			pnlYellowSide.add(getLabel_90());
			pnlYellowSide.add(getLabel_91());
			pnlYellowSide.add(getLabel_92());
			pnlYellowSide.add(getLabel_93());
		}
		return pnlYellowSide;
	}

	private JLabel getLabel_70() {
		if (label_70 == null) {
			label_70 = new JLabel("8");
			label_70.setHorizontalAlignment(SwingConstants.CENTER);
			label_70.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_70.setBounds(0, 210, 60, 30);
		}
		return label_70;
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

	private JLabel getLabel_72() {
		if (label_72 == null) {
			label_72 = new JLabel("60");
			label_72.setHorizontalAlignment(SwingConstants.CENTER);
			label_72.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_72.setBounds(120, 210, 60, 30);
		}
		return label_72;
	}

	private JLabel getLabel_73() {
		if (label_73 == null) {
			label_73 = new JLabel("7");
			label_73.setHorizontalAlignment(SwingConstants.CENTER);
			label_73.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_73.setBounds(0, 180, 60, 30);
		}
		return label_73;
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

	private JLabel getLabel_75() {
		if (label_75 == null) {
			label_75 = new JLabel("61");
			label_75.setHorizontalAlignment(SwingConstants.CENTER);
			label_75.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_75.setBounds(120, 180, 60, 30);
		}
		return label_75;
	}

	private JLabel getLabel_76() {
		if (label_76 == null) {
			label_76 = new JLabel("5");
			label_76.setOpaque(true);
			label_76.setBackground(new Color(255, 255, 0));
			label_76.setHorizontalAlignment(SwingConstants.CENTER);
			label_76.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_76.setBounds(0, 120, 60, 30);
		}
		return label_76;
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

	private JLabel getLabel_78() {
		if (label_78 == null) {
			label_78 = new JLabel("63");
			label_78.setOpaque(true);
			label_78.setBackground(new Color(192, 192, 192));
			label_78.setHorizontalAlignment(SwingConstants.CENTER);
			label_78.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_78.setBounds(120, 120, 60, 30);
		}
		return label_78;
	}

	private JLabel getLabel_79() {
		if (label_79 == null) {
			label_79 = new JLabel("62");
			label_79.setHorizontalAlignment(SwingConstants.CENTER);
			label_79.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_79.setBounds(120, 150, 60, 30);
		}
		return label_79;
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

	private JLabel getLabel_81() {
		if (label_81 == null) {
			label_81 = new JLabel("6");
			label_81.setHorizontalAlignment(SwingConstants.CENTER);
			label_81.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_81.setBounds(0, 150, 60, 30);
		}
		return label_81;
	}

	private JLabel getLabel_82() {
		if (label_82 == null) {
			label_82 = new JLabel("1");
			label_82.setHorizontalAlignment(SwingConstants.CENTER);
			label_82.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_82.setBounds(0, 0, 60, 30);
		}
		return label_82;
	}

	private JLabel getLabel_83() {
		if (label_83 == null) {
			label_83 = new JLabel("2");
			label_83.setHorizontalAlignment(SwingConstants.CENTER);
			label_83.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_83.setBounds(0, 30, 60, 30);
		}
		return label_83;
	}

	private JLabel getLabel_84() {
		if (label_84 == null) {
			label_84 = new JLabel("3");
			label_84.setHorizontalAlignment(SwingConstants.CENTER);
			label_84.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_84.setBounds(0, 60, 60, 30);
		}
		return label_84;
	}

	private JLabel getLabel_85() {
		if (label_85 == null) {
			label_85 = new JLabel("4");
			label_85.setHorizontalAlignment(SwingConstants.CENTER);
			label_85.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_85.setBounds(0, 90, 60, 30);
		}
		return label_85;
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

	private JLabel getLabel_89() {
		if (label_89 == null) {
			label_89 = new JLabel("68");
			label_89.setHorizontalAlignment(SwingConstants.CENTER);
			label_89.setOpaque(true);
			label_89.setBackground(new Color(255, 255, 0));
			label_89.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_89.setBounds(60, 0, 60, 30);
		}
		return label_89;
	}

	private JLabel getLabel_90() {
		if (label_90 == null) {
			label_90 = new JLabel("67");
			label_90.setHorizontalAlignment(SwingConstants.CENTER);
			label_90.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_90.setBounds(120, 0, 60, 30);
		}
		return label_90;
	}

	private JLabel getLabel_91() {
		if (label_91 == null) {
			label_91 = new JLabel("66");
			label_91.setHorizontalAlignment(SwingConstants.CENTER);
			label_91.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_91.setBounds(120, 30, 60, 30);
		}
		return label_91;
	}

	private JLabel getLabel_92() {
		if (label_92 == null) {
			label_92 = new JLabel("65");
			label_92.setHorizontalAlignment(SwingConstants.CENTER);
			label_92.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_92.setBounds(120, 60, 60, 30);
		}
		return label_92;
	}

	private JLabel getLabel_93() {
		if (label_93 == null) {
			label_93 = new JLabel("64");
			label_93.setHorizontalAlignment(SwingConstants.CENTER);
			label_93.setBorder(new LineBorder(new Color(0, 0, 0)));
			label_93.setBounds(120, 90, 60, 30);
		}
		return label_93;
	}

	private JLabel getLblYellowPlayerAvatar() {
		if (lblYellowPlayerAvatar == null) {
			lblYellowPlayerAvatar = new JLabel("PlayerAvatar");
			lblYellowPlayerAvatar.setHorizontalAlignment(SwingConstants.CENTER);
			lblYellowPlayerAvatar.setBounds(10, 46, 95, 102);
		}
		return lblYellowPlayerAvatar;
	}

	private JLabel getLblYellowPlayerName() {
		if (lblYellowPlayerName == null) {
			lblYellowPlayerName = new JLabel("playerGreenName");
			lblYellowPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
			lblYellowPlayerName.setBounds(10, 11, 95, 14);
		}
		return lblYellowPlayerName;
	}

	private JLabel getLblGreenPlayerAvatar() {
		if (lblGreenPlayerAvatar == null) {
			lblGreenPlayerAvatar = new JLabel("PlayerAvatar");
			lblGreenPlayerAvatar.setHorizontalAlignment(SwingConstants.CENTER);
			lblGreenPlayerAvatar.setBounds(105, 46, 95, 102);
		}
		return lblGreenPlayerAvatar;
	}

	private JLabel getLblGreenPlayerName() {
		if (lblGreenPlayerName == null) {
			lblGreenPlayerName = new JLabel("playerGreenName");
			lblGreenPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
			lblGreenPlayerName.setBounds(105, 11, 95, 14);
		}
		return lblGreenPlayerName;
	}

	private JLabel getLblRedPlayerAvatar() {
		if (lblRedPlayerAvatar == null) {
			lblRedPlayerAvatar = new JLabel("PlayerAvatar");
			lblRedPlayerAvatar.setHorizontalAlignment(SwingConstants.CENTER);
			lblRedPlayerAvatar.setBounds(105, 72, 95, 102);
		}
		return lblRedPlayerAvatar;
	}

	private JLabel getLblRedPlayerName() {
		if (lblRedPlayerName == null) {
			lblRedPlayerName = new JLabel("playerYellowName");
			lblRedPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
			lblRedPlayerName.setBounds(105, 185, 95, 14);
		}
		return lblRedPlayerName;
	}

	private JLabel getLblBluePlayerAvatar() {
		if (lblBluePlayerAvatar == null) {
			lblBluePlayerAvatar = new JLabel("PlayerAvatar");
			lblBluePlayerAvatar.setHorizontalAlignment(SwingConstants.CENTER);
			lblBluePlayerAvatar.setBounds(10, 72, 95, 102);
		}
		return lblBluePlayerAvatar;
	}

	private JLabel getLblBluePlayerName() {
		if (lblBluePlayerName == null) {
			lblBluePlayerName = new JLabel("playerYellowName");
			lblBluePlayerName.setHorizontalAlignment(SwingConstants.CENTER);
			lblBluePlayerName.setBounds(10, 185, 95, 14);
		}
		return lblBluePlayerName;
	}

	private JLabel getLblDice() {
		if (lblDice == null) {
			lblDice = new JLabel("New label");
			lblDice.setBounds(40, 40, 40, 40);
		}
		return lblDice;
	}
}
