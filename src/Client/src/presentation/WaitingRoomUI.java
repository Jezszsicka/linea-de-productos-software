package presentation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import logic.Controller;
import logic.LanguageManager;
import model.User;
import ProductLine.GameType;
import ProductLine.Ranking;
import ProductLine.UserNotLoggedException;

@SuppressWarnings("serial")
public class WaitingRoomUI extends javax.swing.JFrame {

	private static final int pnlUserHeight = 55;
	private static final int userNameLabelWidth = 80;
	private static final int userNameLabelHeight = 45;
	private static final int userIconLabelWidth = 38;
	private static final int userIconLabelHeight = 45;
	private static final int margin = 5;
	private List<User> users;
	private JScrollPane scrollPnlUsers;
	private JLabel btnMessages;
	private JButton btnTopPlayers;

	private JPanel pnlButtons;
	private User user;

	private JPanel pnlFriends;
	private JTabbedPane tabPanel;
	private JPanel pnlUsers;
	private JLabel lblAvatar;
	private JPanel pnlBackground;
	private JButton btnProfile;
	private JButton btnJoinGame;
	private JButton btnSend;
	private JButton btnCreateGame;
	private JButton btnExit;
	private JTextField txtMessage;
	private JScrollPane pnlChat;
	private JTextPane txtChat;
	private String destinatary;
	private HTMLEditorKit htmlEditor;
	private HTMLDocument chatText;
	private LanguageManager language;

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WaitingRoomUI(User user, List<User> users) {
		super();
		setBounds(new Rectangle(0, 0, 710, 517));
		getContentPane().setBounds(new Rectangle(0, 0, 710, 517));
		setSize(new Dimension(710, 517));
		getContentPane().setPreferredSize(new Dimension(710, 517));
		getContentPane().setSize(new Dimension(710, 517));
		setPreferredSize(new Dimension(710, 517));
		language = LanguageManager.language();
		initGUI();
		this.user = user;
		this.users = users;
		if (user.getAvatar().length == 0) {
			lblAvatar.setIcon(new ImageIcon(WaitingRoomUI.class
					.getResource("/images/Avatars/1.jpg")));
		} else {
			lblAvatar.setIcon(new ImageIcon(user.getAvatar()));
		}
		destinatary = "";
		refreshUsersList();
	}

	private void initGUI() {
		this.setBounds(0, 0, 720, 517);
		getContentPane().setLayout(null);
		getContentPane().add(getPnlBackground());
		setLocationRelativeTo(null);
		setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				thisWindowClosing(evt);
			}
		});
	}

	private JPanel getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setBounds(0, 0, 714, 489);
			pnlBackground.setLayout(null);
			pnlBackground.add(getBtnSend());
			pnlBackground.add(getBtnExit());
			pnlBackground.add(getTxtMessage());
			pnlBackground.add(getPnlChat());
			pnlBackground.add(getLblAvatar());
			pnlBackground.add(getJTabbedPane1());
			pnlBackground.add(getPnlButtons());
		}
		return pnlBackground;
	}

	private JButton getBtnSend() {
		if (btnSend == null) {
			btnSend = new JButton("Enviar");
			btnSend.setBounds(413, 447, 64, 23);
			btnSend.setText(language.getString("btnSend"));
			btnSend.setFocusable(false);
			btnSend.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnSendMouseClicked(evt);
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnSendMouseEntered(arg0);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnSendMouseExited(e);
				}
			});
		}
		return btnSend;
	}

	private JButton getBtnCreateGame() {
		if (btnCreateGame == null) {
			btnCreateGame = new JButton("Crear partida");
			btnCreateGame.setBounds(11, 6, 66, 53);
			btnCreateGame.setText(language.getString("btnCreateGame"));
			btnCreateGame.setFocusable(false);
			btnCreateGame.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					btnCreateGameMouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					btnCreateGameMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnCreateGameMouseExited(e);
				}
			});
		}
		return btnCreateGame;
	}

	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("Exit");
			btnExit.setBounds(615, 447, 89, 23);
			btnExit.setText(language.getString("btnExit"));
			btnExit.setFocusable(false);
			btnExit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					btnExitMouseClicked(e);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					btnExitMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnExitMouseExited(e);
				}
			});
		}
		return btnExit;
	}

	private JTextField getTxtMessage() {
		if (txtMessage == null) {
			txtMessage = new JTextField();
			txtMessage.setBounds(23, 450, 380, 20);
			txtMessage.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent evt) {
					txtMessageKeyPressed(evt);
				}

				public void keyTyped(KeyEvent evt) {
					txtMessageKeyTyped(evt);
				}
			});
		}
		return txtMessage;
	}

	private JScrollPane getPnlChat() {
		if (pnlChat == null) {
			pnlChat = new JScrollPane();
			pnlChat.setBounds(24, 146, 451, 289);
			pnlChat.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			pnlChat.setAutoscrolls(true);
			pnlChat.setViewportView(getTxtChat());
		}
		return pnlChat;
	}

	private JTextPane getTxtChat() {
		if (txtChat == null) {
			txtChat = new JTextPane();
			txtChat.setInheritsPopupMenu(true);
			txtChat.setBounds(500, 54, 147, 291);
			txtChat.setEditable(false);
			txtChat.setContentType("text/html");
			htmlEditor = new HTMLEditorKit();
			chatText = new HTMLDocument();
			txtChat.setEditorKit(htmlEditor);
			txtChat.setDocument(chatText);
		}
		return txtChat;
	}

	private JButton getBtnJoinGame() {
		if (btnJoinGame == null) {
			btnJoinGame = new JButton();
			btnJoinGame.setText("Join game");
			btnJoinGame.setBounds(103, 6, 66, 53);
			btnJoinGame.setFocusable(false);
			btnJoinGame.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnJoinGameMouseClicked(evt);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					btnJoinGameMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnJoinGameMouseExited(e);
				}
			});
		}
		return btnJoinGame;
	}

	private JButton getBtnProfile() {
		if (btnProfile == null) {
			btnProfile = new JButton();
			btnProfile.setBounds(482, 6, 56, 58);
			btnProfile.setFocusable(false);
			btnProfile.setIcon(new ImageIcon(WaitingRoomUI.class
					.getResource("/images/profile_icon.png")));
			btnProfile.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.RAISED));
			btnProfile.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent evt) {
					btnProfileMouseReleased(evt);
				}

				public void mousePressed(MouseEvent evt) {
					btnProfileMousePressed(evt);
				}

				public void mouseClicked(MouseEvent evt) {
					btnProfileMouseClicked(evt);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					btnProfileMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnProfileMouseExited(e);
				}
			});
		}
		return btnProfile;
	}

	private JLabel getLblAvatar() {
		if (lblAvatar == null) {
			lblAvatar = new JLabel();
			lblAvatar.setBounds(23, 15, 100, 120);
			lblAvatar.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
		}
		return lblAvatar;
	}

	private JPanel getPnlUsers() {
		if (pnlUsers == null) {
			pnlUsers = new JPanel();
			pnlUsers.setLayout(null);
		}
		return pnlUsers;
	}

	private void btnProfileMouseClicked(MouseEvent evt) {
		Controller.getInstance().showProfileUI();
	}

	private void thisWindowClosing(WindowEvent evt) {
		int option = JOptionPane.showConfirmDialog(this,
				language.getString("ExitDialogMessage"),
				language.getString("ExitDialogTitle"),
				JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION) {
			Controller.getInstance().logoutUser();
			dispose();
		}
	}

	protected void btnCreateGameMouseClicked(MouseEvent evt) {
		Controller.getInstance().showCreateGameUI();
	}

	protected void btnExitMouseClicked(MouseEvent evt) {
		int option = JOptionPane.showConfirmDialog(this,
				language.getString("ExitDialogMessage"),
				language.getString("ExitDialogTitle"),
				JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION) {
			Controller.getInstance().logoutUser();
			dispose();
		}
	}

	private void btnSendMouseClicked(MouseEvent evt) {
		sendMessage();
	}

	private void btnJoinGameMouseClicked(MouseEvent evt) {
		Controller.getInstance().showJoinGameUI();
	}

	public void receivePrivateMessage(String sender, String message) {
		destinatary = sender;
		try {
			htmlEditor.insertHTML(chatText, chatText.getLength(),
					"<font color=\"red\"><b> &lt;" + sender + ":</b>" + message
							+ "</font>", 0, 0, null);
			txtChat.setCaretPosition(txtChat.getDocument().getLength());
		} catch (BadLocationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

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

	public void userLogged(String username) {
		try {
			htmlEditor.insertHTML(chatText, chatText.getLength(), "<b>"
					+ username + " has joined</b> ", 0, 0, null);
		} catch (BadLocationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		refreshUsersList();
	}

	public void userLeave(String user) {
		try {
			htmlEditor.insertHTML(chatText, chatText.getLength(), "<b>" + user
					+ " has left</b> ", 0, 0, null);
		} catch (BadLocationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		refreshUsersList();
	}

	private void refreshUsersList() {
		int size = 0;
		pnlUsers.removeAll();
		for (int i = 0; i < users.size(); i++) {
			JPanel pnlUser = new JPanel();
			pnlUser.setLayout(null);
			pnlUser.setBounds(margin, margin + i * pnlUserHeight + i * margin,
					pnlUsers.getWidth() - 2 * margin, pnlUserHeight);
			pnlUser.setBorder(new LineBorder(Color.BLACK, 1, false));
			pnlUsers.add(pnlUser);

			JLabel userAvatarLabel = new JLabel();
			if (users.get(i).getAvatar().length == 0) {
				userAvatarLabel.setIcon(new ImageIcon(WaitingRoomUI.class
						.getResource("/images/Avatars/1.jpg")));
			} else {
				ImageIcon image = new ImageIcon(users.get(i).getAvatar());
				image = new ImageIcon(image.getImage().getScaledInstance(
						userIconLabelWidth, userIconLabelHeight,
						Image.SCALE_SMOOTH));
				userAvatarLabel.setIcon(image);
			}
			userAvatarLabel.setBounds(margin, margin, userIconLabelWidth,
					userIconLabelHeight);
			userAvatarLabel.setBorder(BorderFactory
					.createLineBorder(Color.BLACK));
			pnlUser.add(userAvatarLabel);
			final JLabel userNameLabel = new JLabel();
			userNameLabel.setText(users.get(i).getUsername());
			userNameLabel.setBounds(60, margin, userNameLabelWidth,
					userNameLabelHeight);
			userNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
			userNameLabel.setHorizontalTextPosition(SwingConstants.LEFT);
			userNameLabel.setFont(new Font("Courier New", Font.BOLD, 15));
			pnlUser.add(userNameLabel);
			size += margin + pnlUserHeight;
			pnlUser.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					userClicked(evt, userNameLabel.getText());
				}
			});
		}
		size += margin;
		if (size > scrollPnlUsers.getHeight()) {
			scrollPnlUsers.setBounds(scrollPnlUsers.getX(),
					scrollPnlUsers.getY(), scrollPnlUsers.getWidth() + 20,
					scrollPnlUsers.getHeight());
		}
		pnlUsers.setPreferredSize(new Dimension(pnlUsers.getWidth(), size));
		pnlUsers.setSize(pnlUsers.getWidth(), size);
		pnlUsers.repaint();
	}

	private void sendMessage() {
		String message = txtMessage.getText();
		if (message.startsWith("\"")) {
			String[] splitMessage = message.split(" ");
			destinatary = splitMessage[0].substring(1);
			if (!destinatary.equalsIgnoreCase(user.getUsername())) {
				String privateMessage = message.split(destinatary)[1];
				try {
					Controller.getInstance().sendPrivateMessage(destinatary,
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
				} catch (UserNotLoggedException e1) {
					try {
						htmlEditor.insertHTML(chatText, chatText.getLength(),
								"<font color=\"gray\"><b>" + destinatary
										+ " is offline</b></font>", 0, 0, null);
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
			Controller.getInstance().sendGeneralMessage(message);
			try {
				htmlEditor.insertHTML(chatText, chatText.getLength(), "<b>"
						+ user.getUsername() + ":</b> " + message, 0, 0, null);
			} catch (BadLocationException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		txtMessage.setText(null);
		txtChat.setCaretPosition(txtChat.getDocument().getLength());
	}

	private JPanel getPnlButtons() {
		if (pnlButtons == null) {
			pnlButtons = new JPanel();
			pnlButtons.setBounds(156, 15, 548, 70);
			pnlButtons.setLayout(null);
			pnlButtons.setBorder(BorderFactory.createTitledBorder(""));
			pnlButtons.add(getBtnCreateGame());
			pnlButtons.add(getBtnJoinGame());
			pnlButtons.add(getBtnProfile());
			pnlButtons.add(getBtnTopPlayers());
			pnlButtons.add(getBtnMessages());
		}
		return pnlButtons;
	}

	private void btnProfileMousePressed(MouseEvent evt) {
	}

	private void btnProfileMouseReleased(MouseEvent evt) {
		btnProfile.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.RAISED));
	}

	public void setAvatar(byte[] avatar) {
		lblAvatar.setIcon(new ImageIcon(avatar));
	}

	private void txtMessageKeyTyped(KeyEvent evt) {
		if (evt.getKeyChar() == '"' && txtMessage.getText().isEmpty()) {
			if (!destinatary.isEmpty()) {
				txtMessage.setText("\"" + destinatary + " ");
				evt.consume();
			}
		}
	}

	private void txtMessageKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == 10 && txtMessage.getText().length() > 0)
			sendMessage();
	}

	private JTabbedPane getJTabbedPane1() {
		if (tabPanel == null) {
			tabPanel = new JTabbedPane();
			tabPanel.setBounds(554, 146, 150, 288);
			tabPanel.addTab(language.getString("tabUsers"), null,
					getJScrollPane1(), null);
			tabPanel.addTab(language.getString("tabFriends"), null,
					getPnlFriends(), null);
		}
		return tabPanel;
	}

	private JPanel getPnlFriends() {
		if (pnlFriends == null) {
			pnlFriends = new JPanel();
			pnlFriends.setLayout(null);
		}
		return pnlFriends;
	}

	private JScrollPane getJScrollPane1() {
		if (scrollPnlUsers == null) {
			scrollPnlUsers = new JScrollPane();
			scrollPnlUsers.setPreferredSize(new java.awt.Dimension(143, 260));
			scrollPnlUsers.setBorder(BorderFactory
					.createEmptyBorder(0, 0, 0, 0));
			scrollPnlUsers.setForeground(new java.awt.Color(0, 0, 0));
			scrollPnlUsers.setViewportView(getPnlUsers());
		}
		return scrollPnlUsers;
	}

	public void languageChanged() {
		btnSend.setText(language.getString("btnSend"));
		btnExit.setText(language.getString("btnExit"));
		tabPanel.setTitleAt(0, language.getString("tabUsers"));
		tabPanel.setTitleAt(1, language.getString("tabFriends"));
	}

	private JButton getBtnTopPlayers() {
		if (btnTopPlayers == null) {
			btnTopPlayers = new JButton();
			btnTopPlayers.setText("Top Players");
			btnTopPlayers.setBounds(418, 6, 56, 58);
			btnTopPlayers.setFocusable(false);
		}
		return btnTopPlayers;
	}

	private void userClicked(MouseEvent evt, String username) {
		if (evt.getClickCount() == 2) {
			User user = null;
			for (User aux : users)
				if (aux.getUsername().equals(username)) {
					user = aux;
					break;
				}
			new UserInfoUI(this, user);
		} else {
			JPanel userPanel = (JPanel) evt.getComponent();
			for (Component aux : evt.getComponent().getParent().getComponents())
				if (aux != evt.getComponent())
					((JPanel) aux).setBorder(new LineBorder(Color.BLACK, 1,
							false));

			userPanel.setBorder(new LineBorder(Color.BLACK, 2, false));

		}
	}

	private JLabel getBtnMessages() {
		if (btnMessages == null) {
			btnMessages = new JLabel();
			btnMessages.setText("Messages");
			btnMessages.setBounds(338, 7, 57, 56);
			btnMessages.setFocusable(false);
			btnMessages.setIcon(new ImageIcon(WaitingRoomUI.class
					.getResource("/images/mailIcon.png")));
			btnMessages.addMouseListener(new MouseAdapter() {
				public void mouseExited(MouseEvent evt) {
					btnMessagesMouseExited(evt);
				}

				public void mouseEntered(MouseEvent evt) {
					btnMessagesMouseEntered(evt);
				}

				public void mouseClicked(MouseEvent evt) {
					btnMessagesMouseClicked(evt);
				}
			});
		}
		return btnMessages;
	}

	private void btnMessagesMouseClicked(MouseEvent evt) {
		Controller.getInstance().showMessagesUI();
	}

	private void setHandCursor() {
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	private void setDefaultCursor() {
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	private void btnMessagesMouseEntered(MouseEvent evt) {
		setHandCursor();
	}

	private void btnMessagesMouseExited(MouseEvent evt) {
		setDefaultCursor();
	}

	protected void btnSendMouseEntered(MouseEvent arg0) {
		setHandCursor();
	}

	protected void btnSendMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void btnProfileMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnProfileMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void btnExitMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnExitMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void btnCreateGameMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnCreateGameMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void btnJoinGameMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnJoinGameMouseExited(MouseEvent e) {
		setDefaultCursor();
	}
}
