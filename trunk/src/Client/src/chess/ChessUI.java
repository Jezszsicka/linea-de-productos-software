package chess;
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
public class ChessUI extends javax.swing.JFrame implements GameUI{
	private JPanel pnlBackground;
	private JLabel lbl00;
	private JTextPane txtChat;
	private JScrollPane pnlChat;
	private JTextField txtMessage;
	private JButton btnQuit;
	private JPanel pnlBoard;
	private JLabel lblAvatarBlack;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel10;
	private JLabel jLabel9;
	private JLabel jLabel8;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JLabel lbl07;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JLabel lbl01;

	private HTMLEditorKit htmlEditor;
	private HTMLDocument chatText;

	private String destinatary;
	private String username;
	private JLabel jLabel20;
	private JLabel jLabel21;
	private JLabel lblOpponentName;
	private JLabel jLabel61;
	private JLabel jLabel60;
	private JLabel jLabel59;
	private JLabel jLabel58;
	private JLabel jLabel57;
	private JLabel jLabel56;
	private JLabel jLabel55;
	private JLabel jLabel54;
	private JLabel jLabel53;
	private JLabel jLabel52;
	private JLabel jLabel51;
	private JLabel jLabel50;
	private JLabel jLabel49;
	private JLabel jLabel48;
	private JLabel jLabel47;
	private JLabel jLabel46;
	private JLabel jLabel45;
	private JLabel jLabel44;
	private JLabel jLabel43;
	private JLabel jLabel42;
	private JLabel jLabel41;
	private JLabel jLabel40;
	private JLabel jLabel39;
	private JLabel jLabel38;
	private JLabel jLabel37;
	private JLabel jLabel36;
	private JLabel jLabel35;
	private JLabel jLabel34;
	private JLabel jLabel33;
	private JLabel jLabel32;
	private JLabel jLabel31;
	private JLabel jLabel30;
	private JLabel jLabel29;
	private JLabel jLabel28;
	private JLabel jLabel27;
	private JLabel jLabel26;
	private JLabel jLabel25;
	private JLabel jLabel24;
	private JLabel jLabel23;
	private JLabel jLabel22;
	private JLabel jLabel19;
	private JLabel jLabel18;
	private JLabel jLabel17;
	private JLabel jLabel16;
	private JLabel jLabel15;
	private JLabel jLabel14;
	private JLabel jLabel13;
	private JLabel jLabel12;
	private JLabel jLabel11;
	private Game game;

	public ChessUI(String username, Game game) {
		super();
		this.username = username;
		this.game = game;
		destinatary = "";
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getPnlBackground());
		pack();
		this.setSize(650, 721);
		setLocationRelativeTo(null);
		setVisible(true);
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
			lblAvatarBlack.setBorder(new SoftBevelBorder(BevelBorder.LOWERED,
					null, null, null, null));
		}
		return lblAvatarBlack;
	}

	private JPanel getPnlBoard() {
		if (pnlBoard == null) {
			pnlBoard = new JPanel();
			pnlBoard.setLayout(null);
			pnlBoard.setBounds(10, 11, 493, 492);
			pnlBoard.setBorder(BorderFactory.createTitledBorder(""));
			pnlBoard.add(getLbl00());
			pnlBoard.add(getJLabel1());
			pnlBoard.add(getJLabel1x());
			pnlBoard.add(getJLabel2());
			pnlBoard.add(getJLabel3());
			pnlBoard.add(getJLabel4());
			pnlBoard.add(getJLabel5());
			pnlBoard.add(getLbl07());
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
			txtMessage.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent evt) {
					txtMessageKeyPressed(evt);
				}
			});
		}
		return txtMessage;
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
			txtChat = new JTextPane();
			txtChat.setEditable(false);
			htmlEditor = new HTMLEditorKit();
			chatText = new HTMLDocument();
			txtChat.setEditorKit(htmlEditor);
			txtChat.setDocument(chatText);
		}
		return txtChat;
	}
	
	private JLabel getLbl00() {
		if(lbl00 == null) {
			lbl00 = new JLabel();
			lbl00.setBounds(7, 7, 60, 60);
			lbl00.setBackground(new java.awt.Color(255,255,255));
			lbl00.setOpaque(true);
			lbl00.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
		}
		return lbl00;
	}
	
	private JLabel getJLabel1() {
		if(lbl01 == null) {
			lbl01 = new JLabel();
			lbl01.setBounds(67, 7, 60, 60);
			lbl01.setOpaque(true);
			lbl01.setBackground(new java.awt.Color(0,0,0));
			lbl01.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
		}
		return lbl01;
	}
	
	private JLabel getJLabel1x() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setOpaque(true);
			jLabel1.setBackground(new java.awt.Color(255,255,255));
			jLabel1.setBounds(127, 7, 60, 60);
			jLabel1.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
		}
		return jLabel1;
	}
	
	private JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setOpaque(true);
			jLabel2.setBackground(new java.awt.Color(0,0,0));
			jLabel2.setBounds(187, 7, 60, 60);
			jLabel2.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
		}
		return jLabel2;
	}
	
	private JLabel getJLabel3() {
		if(jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setOpaque(true);
			jLabel3.setBackground(new java.awt.Color(255,255,255));
			jLabel3.setBounds(247, 7, 60, 60);
			jLabel3.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
		}
		return jLabel3;
	}
	
	private JLabel getJLabel4() {
		if(jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setOpaque(true);
			jLabel4.setBackground(new java.awt.Color(0,0,0));
			jLabel4.setBounds(307, 7, 60, 60);
			jLabel4.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
		}
		return jLabel4;
	}
	
	private JLabel getJLabel5() {
		if(jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setOpaque(true);
			jLabel5.setBackground(new java.awt.Color(255,255,255));
			jLabel5.setBounds(367, 7, 60, 60);
			jLabel5.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
		}
		return jLabel5;
	}
	
	private JLabel getLbl07() {
		if(lbl07 == null) {
			lbl07 = new JLabel();
			lbl07.setBounds(427, 7, 60, 60);
			lbl07.setBackground(new java.awt.Color(0,0,0));
			lbl07.setOpaque(true);
			lbl07.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
		}
		return lbl07;
	}
	
	private JLabel getJLabel6() {
		if(jLabel6 == null) {
			jLabel6 = new JLabel();
			jLabel6.setOpaque(true);
			jLabel6.setBackground(new java.awt.Color(255,255,255));
			jLabel6.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel6.setBounds(427, 67, 60, 60);
		}
		return jLabel6;
	}
	
	private JLabel getJLabel7() {
		if(jLabel7 == null) {
			jLabel7 = new JLabel();
			jLabel7.setOpaque(true);
			jLabel7.setBackground(new java.awt.Color(0,0,0));
			jLabel7.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel7.setBounds(367, 67, 60, 60);
		}
		return jLabel7;
	}
	
	private JLabel getJLabel8() {
		if(jLabel8 == null) {
			jLabel8 = new JLabel();
			jLabel8.setOpaque(true);
			jLabel8.setBackground(new java.awt.Color(255,255,255));
			jLabel8.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel8.setBounds(307, 67, 60, 60);
		}
		return jLabel8;
	}
	
	private JLabel getJLabel9() {
		if(jLabel9 == null) {
			jLabel9 = new JLabel();
			jLabel9.setOpaque(true);
			jLabel9.setBackground(new java.awt.Color(0,0,0));
			jLabel9.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel9.setBounds(247, 67, 60, 60);
		}
		return jLabel9;
	}
	
	private JLabel getJLabel10() {
		if(jLabel10 == null) {
			jLabel10 = new JLabel();
			jLabel10.setOpaque(true);
			jLabel10.setBackground(new java.awt.Color(255,255,255));
			jLabel10.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel10.setBounds(187, 67, 60, 60);
		}
		return jLabel10;
	}
	
	private JLabel getJLabel11() {
		if(jLabel11 == null) {
			jLabel11 = new JLabel();
			jLabel11.setOpaque(true);
			jLabel11.setBackground(new java.awt.Color(0,0,0));
			jLabel11.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel11.setBounds(127, 67, 60, 60);
		}
		return jLabel11;
	}
	
	private JLabel getJLabel12() {
		if(jLabel12 == null) {
			jLabel12 = new JLabel();
			jLabel12.setOpaque(true);
			jLabel12.setBackground(new java.awt.Color(255,255,255));
			jLabel12.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel12.setBounds(67, 67, 60, 60);
		}
		return jLabel12;
	}
	
	private JLabel getJLabel13() {
		if(jLabel13 == null) {
			jLabel13 = new JLabel();
			jLabel13.setOpaque(true);
			jLabel13.setBackground(new java.awt.Color(0,0,0));
			jLabel13.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel13.setBounds(7, 67, 60, 60);
		}
		return jLabel13;
	}
	
	private JLabel getJLabel14() {
		if(jLabel14 == null) {
			jLabel14 = new JLabel();
			jLabel14.setOpaque(true);
			jLabel14.setBackground(new java.awt.Color(0,0,0));
			jLabel14.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel14.setBounds(427, 127, 60, 60);
		}
		return jLabel14;
	}
	
	private JLabel getJLabel15() {
		if(jLabel15 == null) {
			jLabel15 = new JLabel();
			jLabel15.setOpaque(true);
			jLabel15.setBackground(new java.awt.Color(255,255,255));
			jLabel15.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel15.setBounds(367, 127, 60, 60);
		}
		return jLabel15;
	}
	
	private JLabel getJLabel16() {
		if(jLabel16 == null) {
			jLabel16 = new JLabel();
			jLabel16.setOpaque(true);
			jLabel16.setBackground(new java.awt.Color(0,0,0));
			jLabel16.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel16.setBounds(307, 127, 60, 60);
		}
		return jLabel16;
	}
	
	private JLabel getJLabel17() {
		if(jLabel17 == null) {
			jLabel17 = new JLabel();
			jLabel17.setOpaque(true);
			jLabel17.setBackground(new java.awt.Color(255,255,255));
			jLabel17.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel17.setBounds(247, 127, 60, 60);
		}
		return jLabel17;
	}
	
	private JLabel getJLabel18() {
		if(jLabel18 == null) {
			jLabel18 = new JLabel();
			jLabel18.setOpaque(true);
			jLabel18.setBackground(new java.awt.Color(0,0,0));
			jLabel18.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel18.setBounds(187, 127, 60, 60);
		}
		return jLabel18;
	}
	
	private JLabel getJLabel19() {
		if(jLabel19 == null) {
			jLabel19 = new JLabel();
			jLabel19.setOpaque(true);
			jLabel19.setBackground(new java.awt.Color(255,255,255));
			jLabel19.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel19.setBounds(127, 127, 60, 60);
		}
		return jLabel19;
	}
	
	private JLabel getJLabel20() {
		if(jLabel20 == null) {
			jLabel20 = new JLabel();
			jLabel20.setOpaque(true);
			jLabel20.setBackground(new java.awt.Color(0,0,0));
			jLabel20.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel20.setBounds(67, 127, 60, 60);
		}
		return jLabel20;
	}
	
	private JLabel getJLabel21() {
		if(jLabel21 == null) {
			jLabel21 = new JLabel();
			jLabel21.setOpaque(true);
			jLabel21.setBackground(new java.awt.Color(255,255,255));
			jLabel21.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel21.setBounds(7, 127, 60, 60);
		}
		return jLabel21;
	}
	
	private JLabel getJLabel22() {
		if(jLabel22 == null) {
			jLabel22 = new JLabel();
			jLabel22.setOpaque(true);
			jLabel22.setBackground(new java.awt.Color(255,255,255));
			jLabel22.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel22.setBounds(427, 186, 60, 60);
		}
		return jLabel22;
	}
	
	private JLabel getJLabel23() {
		if(jLabel23 == null) {
			jLabel23 = new JLabel();
			jLabel23.setOpaque(true);
			jLabel23.setBackground(new java.awt.Color(0,0,0));
			jLabel23.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel23.setBounds(367, 186, 60, 60);
		}
		return jLabel23;
	}
	
	private JLabel getJLabel24() {
		if(jLabel24 == null) {
			jLabel24 = new JLabel();
			jLabel24.setOpaque(true);
			jLabel24.setBackground(new java.awt.Color(255,255,255));
			jLabel24.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel24.setBounds(307, 186, 60, 60);
		}
		return jLabel24;
	}
	
	private JLabel getJLabel25() {
		if(jLabel25 == null) {
			jLabel25 = new JLabel();
			jLabel25.setOpaque(true);
			jLabel25.setBackground(new java.awt.Color(0,0,0));
			jLabel25.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel25.setBounds(247, 186, 60, 60);
		}
		return jLabel25;
	}
	
	private JLabel getJLabel26() {
		if(jLabel26 == null) {
			jLabel26 = new JLabel();
			jLabel26.setOpaque(true);
			jLabel26.setBackground(new java.awt.Color(255,255,255));
			jLabel26.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel26.setBounds(187, 186, 60, 60);
		}
		return jLabel26;
	}
	
	private JLabel getJLabel27() {
		if(jLabel27 == null) {
			jLabel27 = new JLabel();
			jLabel27.setOpaque(true);
			jLabel27.setBackground(new java.awt.Color(0,0,0));
			jLabel27.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel27.setBounds(127, 186, 60, 60);
		}
		return jLabel27;
	}
	
	private JLabel getJLabel28() {
		if(jLabel28 == null) {
			jLabel28 = new JLabel();
			jLabel28.setOpaque(true);
			jLabel28.setBackground(new java.awt.Color(255,255,255));
			jLabel28.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel28.setBounds(67, 186, 60, 60);
		}
		return jLabel28;
	}
	
	private JLabel getJLabel29() {
		if(jLabel29 == null) {
			jLabel29 = new JLabel();
			jLabel29.setOpaque(true);
			jLabel29.setBackground(new java.awt.Color(0,0,0));
			jLabel29.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel29.setBounds(7, 186, 60, 60);
		}
		return jLabel29;
	}
	
	private JLabel getJLabel30() {
		if(jLabel30 == null) {
			jLabel30 = new JLabel();
			jLabel30.setOpaque(true);
			jLabel30.setBackground(new java.awt.Color(0,0,0));
			jLabel30.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel30.setBounds(427, 246, 60, 60);
		}
		return jLabel30;
	}
	
	private JLabel getJLabel31() {
		if(jLabel31 == null) {
			jLabel31 = new JLabel();
			jLabel31.setOpaque(true);
			jLabel31.setBackground(new java.awt.Color(255,255,255));
			jLabel31.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel31.setBounds(367, 246, 60, 60);
		}
		return jLabel31;
	}
	
	private JLabel getJLabel32() {
		if(jLabel32 == null) {
			jLabel32 = new JLabel();
			jLabel32.setOpaque(true);
			jLabel32.setBackground(new java.awt.Color(0,0,0));
			jLabel32.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel32.setBounds(307, 246, 60, 60);
		}
		return jLabel32;
	}
	
	private JLabel getJLabel33() {
		if(jLabel33 == null) {
			jLabel33 = new JLabel();
			jLabel33.setOpaque(true);
			jLabel33.setBackground(new java.awt.Color(255,255,255));
			jLabel33.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel33.setBounds(247, 246, 60, 60);
		}
		return jLabel33;
	}
	
	private JLabel getJLabel34() {
		if(jLabel34 == null) {
			jLabel34 = new JLabel();
			jLabel34.setOpaque(true);
			jLabel34.setBackground(new java.awt.Color(0,0,0));
			jLabel34.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel34.setBounds(187, 246, 60, 60);
		}
		return jLabel34;
	}
	
	private JLabel getJLabel35() {
		if(jLabel35 == null) {
			jLabel35 = new JLabel();
			jLabel35.setOpaque(true);
			jLabel35.setBackground(new java.awt.Color(255,255,255));
			jLabel35.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel35.setBounds(127, 246, 60, 60);
		}
		return jLabel35;
	}
	
	private JLabel getJLabel36() {
		if(jLabel36 == null) {
			jLabel36 = new JLabel();
			jLabel36.setOpaque(true);
			jLabel36.setBackground(new java.awt.Color(0,0,0));
			jLabel36.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel36.setBounds(67, 246, 60, 60);
		}
		return jLabel36;
	}
	
	private JLabel getJLabel37() {
		if(jLabel37 == null) {
			jLabel37 = new JLabel();
			jLabel37.setOpaque(true);
			jLabel37.setBackground(new java.awt.Color(255,255,255));
			jLabel37.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel37.setBounds(7, 246, 60, 60);
		}
		return jLabel37;
	}
	
	private JLabel getJLabel38() {
		if(jLabel38 == null) {
			jLabel38 = new JLabel();
			jLabel38.setOpaque(true);
			jLabel38.setBackground(new java.awt.Color(255,255,255));
			jLabel38.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel38.setBounds(427, 306, 60, 60);
		}
		return jLabel38;
	}
	
	private JLabel getJLabel39() {
		if(jLabel39 == null) {
			jLabel39 = new JLabel();
			jLabel39.setOpaque(true);
			jLabel39.setBackground(new java.awt.Color(255,255,255));
			jLabel39.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel39.setBounds(307, 306, 60, 60);
		}
		return jLabel39;
	}
	
	private JLabel getJLabel40() {
		if(jLabel40 == null) {
			jLabel40 = new JLabel();
			jLabel40.setOpaque(true);
			jLabel40.setBackground(new java.awt.Color(0,0,0));
			jLabel40.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel40.setBounds(367, 306, 60, 60);
		}
		return jLabel40;
	}
	
	private JLabel getJLabel41() {
		if(jLabel41 == null) {
			jLabel41 = new JLabel();
			jLabel41.setOpaque(true);
			jLabel41.setBackground(new java.awt.Color(0,0,0));
			jLabel41.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel41.setBounds(247, 306, 60, 60);
		}
		return jLabel41;
	}
	
	private JLabel getJLabel42() {
		if(jLabel42 == null) {
			jLabel42 = new JLabel();
			jLabel42.setOpaque(true);
			jLabel42.setBackground(new java.awt.Color(255,255,255));
			jLabel42.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel42.setBounds(187, 306, 60, 60);
		}
		return jLabel42;
	}
	
	private JLabel getJLabel43() {
		if(jLabel43 == null) {
			jLabel43 = new JLabel();
			jLabel43.setOpaque(true);
			jLabel43.setBackground(new java.awt.Color(0,0,0));
			jLabel43.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel43.setBounds(127, 306, 60, 60);
		}
		return jLabel43;
	}
	
	private JLabel getJLabel44() {
		if(jLabel44 == null) {
			jLabel44 = new JLabel();
			jLabel44.setOpaque(true);
			jLabel44.setBackground(new java.awt.Color(255,255,255));
			jLabel44.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel44.setBounds(67, 306, 60, 60);
		}
		return jLabel44;
	}
	
	private JLabel getJLabel45() {
		if(jLabel45 == null) {
			jLabel45 = new JLabel();
			jLabel45.setOpaque(true);
			jLabel45.setBackground(new java.awt.Color(0,0,0));
			jLabel45.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel45.setBounds(7, 306, 60, 60);
		}
		return jLabel45;
	}
	
	private JLabel getJLabel46() {
		if(jLabel46 == null) {
			jLabel46 = new JLabel();
			jLabel46.setOpaque(true);
			jLabel46.setBackground(new java.awt.Color(0,0,0));
			jLabel46.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel46.setBounds(427, 366, 60, 60);
		}
		return jLabel46;
	}
	
	private JLabel getJLabel47() {
		if(jLabel47 == null) {
			jLabel47 = new JLabel();
			jLabel47.setOpaque(true);
			jLabel47.setBackground(new java.awt.Color(255,255,255));
			jLabel47.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel47.setBounds(367, 366, 60, 60);
		}
		return jLabel47;
	}
	
	private JLabel getJLabel48() {
		if(jLabel48 == null) {
			jLabel48 = new JLabel();
			jLabel48.setOpaque(true);
			jLabel48.setBackground(new java.awt.Color(0,0,0));
			jLabel48.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel48.setBounds(307, 366, 60, 60);
		}
		return jLabel48;
	}
	
	private JLabel getJLabel49() {
		if(jLabel49 == null) {
			jLabel49 = new JLabel();
			jLabel49.setOpaque(true);
			jLabel49.setBackground(new java.awt.Color(255,255,255));
			jLabel49.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel49.setBounds(247, 366, 60, 60);
		}
		return jLabel49;
	}
	
	private JLabel getJLabel50() {
		if(jLabel50 == null) {
			jLabel50 = new JLabel();
			jLabel50.setOpaque(true);
			jLabel50.setBackground(new java.awt.Color(0,0,0));
			jLabel50.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel50.setBounds(187, 366, 60, 60);
		}
		return jLabel50;
	}
	
	private JLabel getJLabel51() {
		if(jLabel51 == null) {
			jLabel51 = new JLabel();
			jLabel51.setOpaque(true);
			jLabel51.setBackground(new java.awt.Color(255,255,255));
			jLabel51.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel51.setBounds(127, 366, 60, 60);
		}
		return jLabel51;
	}
	
	private JLabel getJLabel52() {
		if(jLabel52 == null) {
			jLabel52 = new JLabel();
			jLabel52.setOpaque(true);
			jLabel52.setBackground(new java.awt.Color(0,0,0));
			jLabel52.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel52.setBounds(67, 366, 60, 60);
		}
		return jLabel52;
	}
	
	private JLabel getJLabel53() {
		if(jLabel53 == null) {
			jLabel53 = new JLabel();
			jLabel53.setOpaque(true);
			jLabel53.setBackground(new java.awt.Color(255,255,255));
			jLabel53.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel53.setBounds(7, 366, 60, 60);
		}
		return jLabel53;
	}
	
	private JLabel getJLabel54() {
		if(jLabel54 == null) {
			jLabel54 = new JLabel();
			jLabel54.setOpaque(true);
			jLabel54.setBackground(new java.awt.Color(0,0,0));
			jLabel54.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel54.setBounds(7, 426, 60, 60);
		}
		return jLabel54;
	}
	
	private JLabel getJLabel55() {
		if(jLabel55 == null) {
			jLabel55 = new JLabel();
			jLabel55.setOpaque(true);
			jLabel55.setBackground(new java.awt.Color(255,255,255));
			jLabel55.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel55.setBounds(427, 426, 60, 60);
		}
		return jLabel55;
	}
	
	private JLabel getJLabel56() {
		if(jLabel56 == null) {
			jLabel56 = new JLabel();
			jLabel56.setOpaque(true);
			jLabel56.setBackground(new java.awt.Color(0,0,0));
			jLabel56.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel56.setBounds(367, 426, 60, 60);
		}
		return jLabel56;
	}
	
	private JLabel getJLabel57() {
		if(jLabel57 == null) {
			jLabel57 = new JLabel();
			jLabel57.setOpaque(true);
			jLabel57.setBackground(new java.awt.Color(255,255,255));
			jLabel57.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel57.setBounds(307, 426, 60, 60);
		}
		return jLabel57;
	}
	
	private JLabel getJLabel58() {
		if(jLabel58 == null) {
			jLabel58 = new JLabel();
			jLabel58.setOpaque(true);
			jLabel58.setBackground(new java.awt.Color(0,0,0));
			jLabel58.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel58.setBounds(247, 426, 60, 60);
		}
		return jLabel58;
	}
	
	private JLabel getJLabel59() {
		if(jLabel59 == null) {
			jLabel59 = new JLabel();
			jLabel59.setOpaque(true);
			jLabel59.setBackground(new java.awt.Color(255,255,255));
			jLabel59.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel59.setBounds(187, 426, 60, 60);
		}
		return jLabel59;
	}
	
	private JLabel getJLabel60() {
		if(jLabel60 == null) {
			jLabel60 = new JLabel();
			jLabel60.setOpaque(true);
			jLabel60.setBackground(new java.awt.Color(0,0,0));
			jLabel60.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel60.setBounds(127, 426, 60, 60);
		}
		return jLabel60;
	}
	
	private JLabel getJLabel61() {
		if(jLabel61 == null) {
			jLabel61 = new JLabel();
			jLabel61.setOpaque(true);
			jLabel61.setBackground(new java.awt.Color(255,255,255));
			jLabel61.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
			jLabel61.setBounds(67, 426, 60, 60);
		}
		return jLabel61;
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
