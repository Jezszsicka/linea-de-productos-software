package checkers;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import presentation.GameUI;

import logic.Controller;
import model.Game;
import ProductLine.UserNotInGameException;

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
public class CheckersUI extends javax.swing.JFrame implements GameUI{

	private HTMLEditorKit htmlEditor;
	private HTMLDocument chatText;

	private String destinatary;
	private String username;
	private JLabel lbl_31;
	private JLabel lblOpponentName;
	private JTextPane txtChat;
	private JScrollPane pnlChat;
	private JTextField txtMessage;
	private JButton btnQuit;
	private JLabel lbl_71;
	private JLabel lbl_72;
	private JLabel lbl_73;
	private JLabel lbl_74;
	private JLabel lbl_75;
	private JLabel lbl_76;
	private JLabel lbl_77;
	private JLabel lbl_70;
	private JLabel lbl_60;
	private JLabel lbl_61;
	private JLabel lbl_62;
	private JLabel lbl_63;
	private JLabel lbl_64;
	private JLabel lbl_65;
	private JLabel lbl_66;
	private JLabel lbl_67;
	private JLabel lbl_50;
	private JLabel lbl_51;
	private JLabel lbl_52;
	private JLabel lbl_53;
	private JLabel lbl_54;
	private JLabel lbl_56;
	private JLabel lbl_55;
	private JLabel lbl_57;
	private JLabel lbl_40;
	private JLabel lbl_41;
	private JLabel lbl_42;
	private JLabel lbl_43;
	private JLabel lbl_44;
	private JLabel lbl_45;
	private JLabel lbl_46;
	private JLabel lbl_47;
	private JLabel lbl_30;
	private JLabel lbl_32;
	private JLabel lbl_33;
	private JLabel lbl_34;
	private JLabel lbl_35;
	private JLabel lbl_36;
	private JLabel lbl_37;
	private JLabel lbl_20;
	private JLabel lbl_21;
	private JLabel lbl_22;
	private JLabel lbl_23;
	private JLabel lbl_24;
	private JLabel lbl_25;
	private JLabel lbl_26;
	private JLabel lbl_27;
	private JLabel lbl_10;
	private JLabel lbl_11;
	private JLabel lbl_12;
	private JLabel lbl_13;
	private JLabel lbl_14;
	private JLabel lbl_15;
	private JLabel lbl_16;
	private JLabel lbl_17;
	private JLabel lbl_07;
	private JLabel lbl_06;
	private JLabel lbl_05;
	private JLabel lbl_04;
	private JLabel lbl_03;
	private JLabel lbl_02;
	private JLabel lbl_01;
	private JLabel lbl_00;
	private JPanel pnlBoard;
	private JLabel lblAvatarBlack;
	private JPanel pnlBackground;
	private Game game;

	public CheckersUI(String username, Game game) {
		super();
		this.username = username;
		this.game = game;
		destinatary = "";
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		pack();
		this.setSize(650, 721);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().add(getPnlBackground());
	}

	private void txtMessageKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == 10 && txtMessage.getText().length() > 0)
			sendMessage();
	}

	private void sendMessage() {
		String message = txtMessage.getText();
		if (message.startsWith("\"")) {
			String[] splitMessage = message.split(" ");
			destinatary = splitMessage[0].substring(1);
			if (!destinatary.equalsIgnoreCase(username)) {
				String privateMessage = message.split(destinatary)[1];
				try {
					Controller.getInstance().sendGamePrivateMessage(
							game.getName(), username, destinatary,
							privateMessage);
					try {
						htmlEditor.insertHTML(chatText, chatText.getLength(),
								"<font color=\"red\"><b> >" + destinatary
										+ ":</b>" + privateMessage + "</font>",
								0, 0, null);
					} catch (BadLocationException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} catch (UserNotInGameException e1) {
					try {
						htmlEditor.insertHTML(chatText, chatText.getLength(),
								"<font color=\"gray\"><b>" + destinatary
										+ " is not in game</b></font>", 0, 0,
								null);
					} catch (BadLocationException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				try {
					htmlEditor
							.insertHTML(
									chatText,
									chatText.getLength(),
									"<font color=\"gray\"><b>You can't send a message to yourself</b></font>",
									0, 0, null);
				} catch (BadLocationException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			Controller.getInstance().sendGameMessage(game.getName(), message);
			try {
				htmlEditor.insertHTML(chatText, chatText.getLength(), "<b>"
						+ username + ":</b> " + message, 0, 0, null);
			} catch (BadLocationException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		txtMessage.setText(null);
	}

	public void receiveMessage(String sender, String message) {
		try {
			htmlEditor.insertHTML(chatText, chatText.getLength(), "<b>"
					+ sender + ":</b> " + message, 0, 0, null);
			txtChat.setCaretPosition(txtChat.getDocument().getLength());
		} catch (BadLocationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void receivePrivateMessage(String sender, String message) {
		destinatary = sender;
		try {
			htmlEditor.insertHTML(chatText, chatText.getLength(),
					"<font color=\"red\"><b> &lt;" + sender + ":</b>" + message
							+ "</font>", 0, 0, null);
		} catch (BadLocationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateBoard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lostGame() {
		// TODO Auto-generated method stub
		
	}
	private JPanel getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setLayout(null);
			pnlBackground.setBounds(0, 0, 634, 683);
			pnlBackground.add(getLblAvatarBlack());
			pnlBackground.add(getPnlBoard());
			pnlBackground.add(getBtnQuit());
			pnlBackground.add(getTxtMessage());
			pnlBackground.add(getPnlChat());
			pnlBackground.add(getLblOpponentName());
		}
		return pnlBackground;
	}
	private JLabel getLblAvatarBlack() {
		if (lblAvatarBlack == null) {
			lblAvatarBlack = new JLabel();
			lblAvatarBlack.setBounds(513, 11, 101, 124);
			lblAvatarBlack.setBorder(new SoftBevelBorder(BevelBorder.LOWERED,null,null,null,null));
		}
		return lblAvatarBlack;
	}
	private JPanel getPnlBoard() {
		if (pnlBoard == null) {
			pnlBoard = new JPanel();
			pnlBoard.setLayout(null);
			pnlBoard.setBounds(10, 11, 493, 492);
			pnlBoard.setBorder(BorderFactory.createTitledBorder(""));
			pnlBoard.add(getLbl_00());
			pnlBoard.add(getJLabel1());
			pnlBoard.add(getJLabel1x());
			pnlBoard.add(getJLabel2());
			pnlBoard.add(getJLabel3());
			pnlBoard.add(getJLabel4());
			pnlBoard.add(getJLabel5());
			pnlBoard.add(getLbl_07());
			pnlBoard.add(getJLabel6());
			pnlBoard.add(getJLabel7());
			pnlBoard.add(getJLabel8());
			pnlBoard.add(getJLabel9());
			pnlBoard.add(getJLabel10());
			pnlBoard.add(getJLabel11());
			pnlBoard.add(getJLabel12());
			pnlBoard.add(getJLabel13());
			pnlBoard.add(getJLabel14());
			pnlBoard.add(getJLabel15());
			pnlBoard.add(getJLabel16());
			pnlBoard.add(getJLabel17());
			pnlBoard.add(getJLabel18());
			pnlBoard.add(getJLabel19());
			pnlBoard.add(getJLabel20());
			pnlBoard.add(getJLabel21());
			pnlBoard.add(getJLabel22());
			pnlBoard.add(getJLabel23());
			pnlBoard.add(getJLabel24());
			pnlBoard.add(getJLabel25());
			pnlBoard.add(getJLabel26());
			pnlBoard.add(getJLabel27());
			pnlBoard.add(getJLabel28());
			pnlBoard.add(getJLabel29());
			pnlBoard.add(getJLabel30());
			pnlBoard.add(getJLabel31());
			pnlBoard.add(getJLabel32());
			pnlBoard.add(getJLabel33());
			pnlBoard.add(getJLabel34());
			pnlBoard.add(getJLabel35());
			pnlBoard.add(getJLabel36());
			pnlBoard.add(getJLabel37());
			pnlBoard.add(getJLabel38());
			pnlBoard.add(getJLabel39());
			pnlBoard.add(getJLabel40());
			pnlBoard.add(getJLabel41());
			pnlBoard.add(getJLabel42());
			pnlBoard.add(getJLabel43());
			pnlBoard.add(getJLabel44());
			pnlBoard.add(getJLabel45());
			pnlBoard.add(getJLabel46());
			pnlBoard.add(getJLabel47());
			pnlBoard.add(getJLabel48());
			pnlBoard.add(getJLabel49());
			pnlBoard.add(getJLabel50());
			pnlBoard.add(getJLabel51());
			pnlBoard.add(getJLabel52());
			pnlBoard.add(getJLabel53());
			pnlBoard.add(getJLabel54());
			pnlBoard.add(getJLabel55());
			pnlBoard.add(getJLabel56());
			pnlBoard.add(getJLabel57());
			pnlBoard.add(getJLabel58());
			pnlBoard.add(getJLabel59());
			pnlBoard.add(getJLabel60());
			pnlBoard.add(getJLabel61());
		}
		return pnlBoard;
	}
	private JLabel getLbl_00() {
		if(lbl_00 == null) {
			lbl_00 = new JLabel();
			lbl_00.setBounds(7, 7, 60, 60);
			lbl_00.setBackground(new java.awt.Color(255,255,255));
			lbl_00.setOpaque(true);
			lbl_00.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
		}
		return lbl_00;
	}
	private JLabel getJLabel1() {
		if(lbl_01 == null) {
			lbl_01 = new JLabel();
			lbl_01.setBounds(67, 7, 60, 60);
			lbl_01.setOpaque(true);
			lbl_01.setBackground(new java.awt.Color(0,0,0));
			lbl_01.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
		}
		return lbl_01;
	}
	private JLabel getJLabel1x() {
		if(lbl_02 == null) {
			lbl_02 = new JLabel();
			lbl_02.setOpaque(true);
			lbl_02.setBackground(new java.awt.Color(255,255,255));
			lbl_02.setBounds(127, 7, 60, 60);
			lbl_02.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
		}
		return lbl_02;
	}
	private JLabel getJLabel2() {
		if(lbl_03 == null) {
			lbl_03 = new JLabel();
			lbl_03.setOpaque(true);
			lbl_03.setBackground(new java.awt.Color(0,0,0));
			lbl_03.setBounds(187, 7, 60, 60);
			lbl_03.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
		}
		return lbl_03;
	}
	private JLabel getJLabel3() {
		if(lbl_04 == null) {
			lbl_04 = new JLabel();
			lbl_04.setOpaque(true);
			lbl_04.setBackground(new java.awt.Color(255,255,255));
			lbl_04.setBounds(247, 7, 60, 60);
			lbl_04.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
		}
		return lbl_04;
	}
	private JLabel getJLabel4() {
		if(lbl_05 == null) {
			lbl_05 = new JLabel();
			lbl_05.setOpaque(true);
			lbl_05.setBackground(new java.awt.Color(0,0,0));
			lbl_05.setBounds(307, 7, 60, 60);
			lbl_05.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
		}
		return lbl_05;
	}
	private JLabel getJLabel5() {
		if(lbl_06 == null) {
			lbl_06 = new JLabel();
			lbl_06.setOpaque(true);
			lbl_06.setBackground(new java.awt.Color(255,255,255));
			lbl_06.setBounds(367, 7, 60, 60);
			lbl_06.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
		}
		return lbl_06;
	}
	private JLabel getLbl_07() {
		if(lbl_07 == null) {
			lbl_07 = new JLabel();
			lbl_07.setBounds(427, 7, 60, 60);
			lbl_07.setBackground(new java.awt.Color(0,0,0));
			lbl_07.setOpaque(true);
			lbl_07.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
		}
		return lbl_07;
	}
	private JLabel getJLabel6() {
		if(lbl_17 == null) {
			lbl_17 = new JLabel();
			lbl_17.setOpaque(true);
			lbl_17.setBackground(new java.awt.Color(255,255,255));
			lbl_17.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_17.setBounds(427, 67, 60, 60);
		}
		return lbl_17;
	}
	private JLabel getJLabel7() {
		if(lbl_16 == null) {
			lbl_16 = new JLabel();
			lbl_16.setOpaque(true);
			lbl_16.setBackground(new java.awt.Color(0,0,0));
			lbl_16.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_16.setBounds(367, 67, 60, 60);
		}
		return lbl_16;
	}
	private JLabel getJLabel8() {
		if(lbl_15 == null) {
			lbl_15 = new JLabel();
			lbl_15.setOpaque(true);
			lbl_15.setBackground(new java.awt.Color(255,255,255));
			lbl_15.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_15.setBounds(307, 67, 60, 60);
		}
		return lbl_15;
	}
	private JLabel getJLabel9() {
		if(lbl_14 == null) {
			lbl_14 = new JLabel();
			lbl_14.setOpaque(true);
			lbl_14.setBackground(new java.awt.Color(0,0,0));
			lbl_14.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_14.setBounds(247, 67, 60, 60);
		}
		return lbl_14;
	}
	private JLabel getJLabel10() {
		if(lbl_13 == null) {
			lbl_13 = new JLabel();
			lbl_13.setOpaque(true);
			lbl_13.setBackground(new java.awt.Color(255,255,255));
			lbl_13.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_13.setBounds(187, 67, 60, 60);
		}
		return lbl_13;
	}
	private JLabel getJLabel11() {
		if(lbl_12 == null) {
			lbl_12 = new JLabel();
			lbl_12.setOpaque(true);
			lbl_12.setBackground(new java.awt.Color(0,0,0));
			lbl_12.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_12.setBounds(127, 67, 60, 60);
		}
		return lbl_12;
	}
	private JLabel getJLabel12() {
		if(lbl_11 == null) {
			lbl_11 = new JLabel();
			lbl_11.setOpaque(true);
			lbl_11.setBackground(new java.awt.Color(255,255,255));
			lbl_11.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_11.setBounds(67, 67, 60, 60);
		}
		return lbl_11;
	}
	private JLabel getJLabel13() {
		if(lbl_10 == null) {
			lbl_10 = new JLabel();
			lbl_10.setOpaque(true);
			lbl_10.setBackground(new java.awt.Color(0,0,0));
			lbl_10.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_10.setBounds(7, 67, 60, 60);
		}
		return lbl_10;
	}
	private JLabel getJLabel14() {
		if(lbl_27 == null) {
			lbl_27 = new JLabel();
			lbl_27.setOpaque(true);
			lbl_27.setBackground(new java.awt.Color(0,0,0));
			lbl_27.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_27.setBounds(427, 127, 60, 60);
		}
		return lbl_27;
	}
	private JLabel getJLabel15() {
		if(lbl_26 == null) {
			lbl_26 = new JLabel();
			lbl_26.setOpaque(true);
			lbl_26.setBackground(new java.awt.Color(255,255,255));
			lbl_26.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_26.setBounds(367, 127, 60, 60);
		}
		return lbl_26;
	}
	private JLabel getJLabel16() {
		if(lbl_25 == null) {
			lbl_25 = new JLabel();
			lbl_25.setOpaque(true);
			lbl_25.setBackground(new java.awt.Color(0,0,0));
			lbl_25.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_25.setBounds(307, 127, 60, 60);
		}
		return lbl_25;
	}
	private JLabel getJLabel17() {
		if(lbl_24 == null) {
			lbl_24 = new JLabel();
			lbl_24.setOpaque(true);
			lbl_24.setBackground(new java.awt.Color(255,255,255));
			lbl_24.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_24.setBounds(247, 127, 60, 60);
		}
		return lbl_24;
	}
	private JLabel getJLabel18() {
		if(lbl_23 == null) {
			lbl_23 = new JLabel();
			lbl_23.setOpaque(true);
			lbl_23.setBackground(new java.awt.Color(0,0,0));
			lbl_23.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_23.setBounds(187, 127, 60, 60);
		}
		return lbl_23;
	}
	private JLabel getJLabel19() {
		if(lbl_22 == null) {
			lbl_22 = new JLabel();
			lbl_22.setOpaque(true);
			lbl_22.setBackground(new java.awt.Color(255,255,255));
			lbl_22.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_22.setBounds(127, 127, 60, 60);
		}
		return lbl_22;
	}
	private JLabel getJLabel20() {
		if(lbl_21 == null) {
			lbl_21 = new JLabel();
			lbl_21.setOpaque(true);
			lbl_21.setBackground(new java.awt.Color(0,0,0));
			lbl_21.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_21.setBounds(67, 127, 60, 60);
		}
		return lbl_21;
	}
	private JLabel getJLabel21() {
		if(lbl_20 == null) {
			lbl_20 = new JLabel();
			lbl_20.setOpaque(true);
			lbl_20.setBackground(new java.awt.Color(255,255,255));
			lbl_20.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_20.setBounds(7, 127, 60, 60);
		}
		return lbl_20;
	}
	private JLabel getJLabel22() {
		if(lbl_37 == null) {
			lbl_37 = new JLabel();
			lbl_37.setOpaque(true);
			lbl_37.setBackground(new java.awt.Color(255,255,255));
			lbl_37.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_37.setBounds(427, 186, 60, 60);
		}
		return lbl_37;
	}
	private JLabel getJLabel23() {
		if(lbl_36 == null) {
			lbl_36 = new JLabel();
			lbl_36.setOpaque(true);
			lbl_36.setBackground(new java.awt.Color(0,0,0));
			lbl_36.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_36.setBounds(367, 186, 60, 60);
		}
		return lbl_36;
	}
	private JLabel getJLabel24() {
		if(lbl_35 == null) {
			lbl_35 = new JLabel();
			lbl_35.setOpaque(true);
			lbl_35.setBackground(new java.awt.Color(255,255,255));
			lbl_35.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_35.setBounds(307, 186, 60, 60);
		}
		return lbl_35;
	}
	private JLabel getJLabel25() {
		if(lbl_34 == null) {
			lbl_34 = new JLabel();
			lbl_34.setOpaque(true);
			lbl_34.setBackground(new java.awt.Color(0,0,0));
			lbl_34.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_34.setBounds(247, 186, 60, 60);
		}
		return lbl_34;
	}
	private JLabel getJLabel26() {
		if(lbl_33 == null) {
			lbl_33 = new JLabel();
			lbl_33.setOpaque(true);
			lbl_33.setBackground(new java.awt.Color(255,255,255));
			lbl_33.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_33.setBounds(187, 186, 60, 60);
		}
		return lbl_33;
	}
	private JLabel getJLabel27() {
		if(lbl_32 == null) {
			lbl_32 = new JLabel();
			lbl_32.setOpaque(true);
			lbl_32.setBackground(new java.awt.Color(0,0,0));
			lbl_32.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_32.setBounds(127, 186, 60, 60);
		}
		return lbl_32;
	}
	private JLabel getJLabel28() {
		if(lbl_31 == null) {
			lbl_31 = new JLabel();
			lbl_31.setOpaque(true);
			lbl_31.setBackground(new java.awt.Color(255,255,255));
			lbl_31.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_31.setBounds(67, 186, 60, 60);
		}
		return lbl_31;
	}
	private JLabel getJLabel29() {
		if(lbl_30 == null) {
			lbl_30 = new JLabel();
			lbl_30.setOpaque(true);
			lbl_30.setBackground(new java.awt.Color(0,0,0));
			lbl_30.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_30.setBounds(7, 186, 60, 60);
		}
		return lbl_30;
	}
	private JLabel getJLabel30() {
		if(lbl_47 == null) {
			lbl_47 = new JLabel();
			lbl_47.setOpaque(true);
			lbl_47.setBackground(new java.awt.Color(0,0,0));
			lbl_47.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_47.setBounds(427, 246, 60, 60);
		}
		return lbl_47;
	}
	private JLabel getJLabel31() {
		if(lbl_46 == null) {
			lbl_46 = new JLabel();
			lbl_46.setOpaque(true);
			lbl_46.setBackground(new java.awt.Color(255,255,255));
			lbl_46.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_46.setBounds(367, 246, 60, 60);
		}
		return lbl_46;
	}
	private JLabel getJLabel32() {
		if(lbl_45 == null) {
			lbl_45 = new JLabel();
			lbl_45.setOpaque(true);
			lbl_45.setBackground(new java.awt.Color(0,0,0));
			lbl_45.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_45.setBounds(307, 246, 60, 60);
		}
		return lbl_45;
	}
	private JLabel getJLabel33() {
		if(lbl_44 == null) {
			lbl_44 = new JLabel();
			lbl_44.setOpaque(true);
			lbl_44.setBackground(new java.awt.Color(255,255,255));
			lbl_44.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_44.setBounds(247, 246, 60, 60);
		}
		return lbl_44;
	}
	private JLabel getJLabel34() {
		if(lbl_43 == null) {
			lbl_43 = new JLabel();
			lbl_43.setOpaque(true);
			lbl_43.setBackground(new java.awt.Color(0,0,0));
			lbl_43.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_43.setBounds(187, 246, 60, 60);
		}
		return lbl_43;
	}
	private JLabel getJLabel35() {
		if(lbl_42 == null) {
			lbl_42 = new JLabel();
			lbl_42.setOpaque(true);
			lbl_42.setBackground(new java.awt.Color(255,255,255));
			lbl_42.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_42.setBounds(127, 246, 60, 60);
		}
		return lbl_42;
	}
	private JLabel getJLabel36() {
		if(lbl_41 == null) {
			lbl_41 = new JLabel();
			lbl_41.setOpaque(true);
			lbl_41.setBackground(new java.awt.Color(0,0,0));
			lbl_41.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_41.setBounds(67, 246, 60, 60);
		}
		return lbl_41;
	}
	private JLabel getJLabel37() {
		if(lbl_40 == null) {
			lbl_40 = new JLabel();
			lbl_40.setOpaque(true);
			lbl_40.setBackground(new java.awt.Color(255,255,255));
			lbl_40.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_40.setBounds(7, 246, 60, 60);
		}
		return lbl_40;
	}
	private JLabel getJLabel38() {
		if(lbl_57 == null) {
			lbl_57 = new JLabel();
			lbl_57.setOpaque(true);
			lbl_57.setBackground(new java.awt.Color(255,255,255));
			lbl_57.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_57.setBounds(427, 306, 60, 60);
		}
		return lbl_57;
	}
	private JLabel getJLabel39() {
		if(lbl_55 == null) {
			lbl_55 = new JLabel();
			lbl_55.setOpaque(true);
			lbl_55.setBackground(new java.awt.Color(255,255,255));
			lbl_55.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_55.setBounds(307, 306, 60, 60);
		}
		return lbl_55;
	}
	private JLabel getJLabel40() {
		if(lbl_56 == null) {
			lbl_56 = new JLabel();
			lbl_56.setOpaque(true);
			lbl_56.setBackground(new java.awt.Color(0,0,0));
			lbl_56.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_56.setBounds(367, 306, 60, 60);
		}
		return lbl_56;
	}
	private JLabel getJLabel41() {
		if(lbl_54 == null) {
			lbl_54 = new JLabel();
			lbl_54.setOpaque(true);
			lbl_54.setBackground(new java.awt.Color(0,0,0));
			lbl_54.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_54.setBounds(247, 306, 60, 60);
		}
		return lbl_54;
	}
	private JLabel getJLabel42() {
		if(lbl_53 == null) {
			lbl_53 = new JLabel();
			lbl_53.setOpaque(true);
			lbl_53.setBackground(new java.awt.Color(255,255,255));
			lbl_53.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_53.setBounds(187, 306, 60, 60);
		}
		return lbl_53;
	}
	private JLabel getJLabel43() {
		if(lbl_52 == null) {
			lbl_52 = new JLabel();
			lbl_52.setOpaque(true);
			lbl_52.setBackground(new java.awt.Color(0,0,0));
			lbl_52.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_52.setBounds(127, 306, 60, 60);
		}
		return lbl_52;
	}
	private JLabel getJLabel44() {
		if(lbl_51 == null) {
			lbl_51 = new JLabel();
			lbl_51.setOpaque(true);
			lbl_51.setBackground(new java.awt.Color(255,255,255));
			lbl_51.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_51.setBounds(67, 306, 60, 60);
		}
		return lbl_51;
	}
	private JLabel getJLabel45() {
		if(lbl_50 == null) {
			lbl_50 = new JLabel();
			lbl_50.setOpaque(true);
			lbl_50.setBackground(new java.awt.Color(0,0,0));
			lbl_50.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_50.setBounds(7, 306, 60, 60);
		}
		return lbl_50;
	}
	private JLabel getJLabel46() {
		if(lbl_67 == null) {
			lbl_67 = new JLabel();
			lbl_67.setOpaque(true);
			lbl_67.setBackground(new java.awt.Color(0,0,0));
			lbl_67.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_67.setBounds(427, 366, 60, 60);
		}
		return lbl_67;
	}
	private JLabel getJLabel47() {
		if(lbl_66 == null) {
			lbl_66 = new JLabel();
			lbl_66.setOpaque(true);
			lbl_66.setBackground(new java.awt.Color(255,255,255));
			lbl_66.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_66.setBounds(367, 366, 60, 60);
		}
		return lbl_66;
	}
	private JLabel getJLabel48() {
		if(lbl_65 == null) {
			lbl_65 = new JLabel();
			lbl_65.setOpaque(true);
			lbl_65.setBackground(new java.awt.Color(0,0,0));
			lbl_65.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_65.setBounds(307, 366, 60, 60);
		}
		return lbl_65;
	}
	private JLabel getJLabel49() {
		if(lbl_64 == null) {
			lbl_64 = new JLabel();
			lbl_64.setOpaque(true);
			lbl_64.setBackground(new java.awt.Color(255,255,255));
			lbl_64.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_64.setBounds(247, 366, 60, 60);
		}
		return lbl_64;
	}
	private JLabel getJLabel50() {
		if(lbl_63 == null) {
			lbl_63 = new JLabel();
			lbl_63.setOpaque(true);
			lbl_63.setBackground(new java.awt.Color(0,0,0));
			lbl_63.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_63.setBounds(187, 366, 60, 60);
		}
		return lbl_63;
	}
	private JLabel getJLabel51() {
		if(lbl_62 == null) {
			lbl_62 = new JLabel();
			lbl_62.setOpaque(true);
			lbl_62.setBackground(new java.awt.Color(255,255,255));
			lbl_62.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_62.setBounds(127, 366, 60, 60);
		}
		return lbl_62;
	}
	private JLabel getJLabel52() {
		if(lbl_61 == null) {
			lbl_61 = new JLabel();
			lbl_61.setOpaque(true);
			lbl_61.setBackground(new java.awt.Color(0,0,0));
			lbl_61.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_61.setBounds(67, 366, 60, 60);
		}
		return lbl_61;
	}
	private JLabel getJLabel53() {
		if(lbl_60 == null) {
			lbl_60 = new JLabel();
			lbl_60.setOpaque(true);
			lbl_60.setBackground(new java.awt.Color(255,255,255));
			lbl_60.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_60.setBounds(7, 366, 60, 60);
		}
		return lbl_60;
	}
	private JLabel getJLabel54() {
		if(lbl_70 == null) {
			lbl_70 = new JLabel();
			lbl_70.setOpaque(true);
			lbl_70.setBackground(new java.awt.Color(0,0,0));
			lbl_70.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_70.setBounds(7, 426, 60, 60);
		}
		return lbl_70;
	}
	private JLabel getJLabel55() {
		if(lbl_77 == null) {
			lbl_77 = new JLabel();
			lbl_77.setOpaque(true);
			lbl_77.setBackground(new java.awt.Color(255,255,255));
			lbl_77.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_77.setBounds(427, 426, 60, 60);
		}
		return lbl_77;
	}
	private JLabel getJLabel56() {
		if(lbl_76 == null) {
			lbl_76 = new JLabel();
			lbl_76.setOpaque(true);
			lbl_76.setBackground(new java.awt.Color(0,0,0));
			lbl_76.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_76.setBounds(367, 426, 60, 60);
		}
		return lbl_76;
	}
	private JLabel getJLabel57() {
		if(lbl_75 == null) {
			lbl_75 = new JLabel();
			lbl_75.setOpaque(true);
			lbl_75.setBackground(new java.awt.Color(255,255,255));
			lbl_75.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_75.setBounds(307, 426, 60, 60);
		}
		return lbl_75;
	}
	private JLabel getJLabel58() {
		if(lbl_74 == null) {
			lbl_74 = new JLabel();
			lbl_74.setOpaque(true);
			lbl_74.setBackground(new java.awt.Color(0,0,0));
			lbl_74.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_74.setBounds(247, 426, 60, 60);
		}
		return lbl_74;
	}
	private JLabel getJLabel59() {
		if(lbl_73 == null) {
			lbl_73 = new JLabel();
			lbl_73.setOpaque(true);
			lbl_73.setBackground(new java.awt.Color(255,255,255));
			lbl_73.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_73.setBounds(187, 426, 60, 60);
		}
		return lbl_73;
	}
	private JLabel getJLabel60() {
		if(lbl_72 == null) {
			lbl_72 = new JLabel();
			lbl_72.setOpaque(true);
			lbl_72.setBackground(new java.awt.Color(0,0,0));
			lbl_72.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_72.setBounds(127, 426, 60, 60);
		}
		return lbl_72;
	}
	private JLabel getJLabel61() {
		if(lbl_71 == null) {
			lbl_71 = new JLabel();
			lbl_71.setOpaque(true);
			lbl_71.setBackground(new java.awt.Color(255,255,255));
			lbl_71.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			lbl_71.setBounds(67, 426, 60, 60);
		}
		return lbl_71;
	}
	private JButton getBtnQuit() {
		if(btnQuit == null) {
			btnQuit = new JButton();
			btnQuit.setText("Quit");
			btnQuit.setBounds(519, 642, 86, 23);
		}
		return btnQuit;
	}
	private JTextField getTxtMessage() {
		if(txtMessage == null) {
			txtMessage = new JTextField();
			txtMessage.setText(null);
			txtMessage.setBounds(10, 643, 493, 20);
			txtMessage.setText(null);
			txtMessage.setText(null);
			txtMessage.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent evt) {
					txtMessageKeyPressed(evt);
				}
			});
		}
		return txtMessage;
	}
	private JScrollPane getPnlChat() {
		if(pnlChat == null) {
			pnlChat = new JScrollPane();
			pnlChat.setBounds(10, 509, 494, 128);
			pnlChat.setViewportView(getTxtChat());
		}
		return pnlChat;
	}
	private JTextPane getTxtChat() {
		if(txtChat == null) {
			
			htmlEditor = new HTMLEditorKit();
			
			chatText = new HTMLDocument();
			
			txtChat = new JTextPane();
			txtChat.setEditable(false);
			txtChat.setEditorKit(htmlEditor);
			txtChat.setDocument(chatText);
		}
		return txtChat;
	}
	private JLabel getLblOpponentName() {
		if(lblOpponentName == null) {
			lblOpponentName = new JLabel();
			lblOpponentName.setHorizontalAlignment(SwingConstants.CENTER);
			lblOpponentName.setFont(new java.awt.Font("Tahoma",1,11));
			lblOpponentName.setBorder(BorderFactory.createTitledBorder(""));
			lblOpponentName.setBounds(513, 141, 102, 16);
		}
		return lblOpponentName;
	}

}
