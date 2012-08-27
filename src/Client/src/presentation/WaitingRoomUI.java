package presentation;

import java.awt.Color;
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
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import logic.Controller;
import logic.LanguageManager;
import model.User;
import ProductLine.UserNotLoggedException;
import java.awt.Toolkit;

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
	private User user;
	private JTabbedPane tabPanel;
	private JPanel pnlUsers;
	private JLabel lblAvatar;
	private JPanelRound pnlBackground;
	private JLabel btnProfile;
	private JLabel btnJoinGame;
	private JButton btnSend;
	private JLabel btnCreateGame;
	private JButton btnExit;
	private JTextField txtMessage;
	private JScrollPane pnlChat;
	private JTextPane txtChat;
	private String destinatary;
	private HTMLEditorKit htmlEditor;
	private HTMLDocument chatText;
	private LanguageManager language;
	private JScrollPane scrollPnlFriends;
	private JPanel pnlFriends;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				WaitingRoomUI.class.getResource("/images/icon.png")));
		setTitle("Sala de espera");
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
					.getResource("/images/no_avatar_icon.png")));
		} else {
			lblAvatar.setIcon(new ImageIcon(user.getAvatar()));
		}
		destinatary = "";
		refreshUsersList();
		refreshFriendList();
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

	private JPanelRound getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanelRound();
			pnlBackground.setArcw(0);
			pnlBackground.setArch(0);
			pnlBackground.setBounds(0, 0, 714, 489);
			pnlBackground.setLayout(null);
			pnlBackground.add(getBtnSend());
			pnlBackground.add(getBtnExit());
			pnlBackground.add(getTxtMessage());
			pnlBackground.add(getPnlChat());
			pnlBackground.add(getLblAvatar());
			pnlBackground.add(getJTabbedPane1());
			pnlBackground.add(getBtnCreateGame());
			pnlBackground.add(getBtnJoinGame());
			pnlBackground.add(getBtnProfile());
			pnlBackground.add(getBtnMessages());
		}
		return pnlBackground;
	}

	private JButton getBtnSend() {
		if (btnSend == null) {
			btnSend = new JButton("Enviar");
			btnSend.setBounds(411, 451, 64, 23);
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

	private JLabel getBtnCreateGame() {
		if (btnCreateGame == null) {
			btnCreateGame = new JLabel("Crear partida");
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
			btnCreateGame.setIcon(new ImageIcon(WaitingRoomUI.class
					.getResource("/images/createIcon.png")));
			btnCreateGame.setBounds(151, 15, 60, 60);
			btnCreateGame.setText(language.getString("btnCreateGame"));
			btnCreateGame.setFocusable(false);
		}
		return btnCreateGame;
	}

	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("Exit");
			btnExit.setBounds(615, 451, 89, 23);
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
			txtMessage.setForeground(Color.WHITE);
			txtMessage.setBackground(Color.BLACK);
			txtMessage.setCaretColor(Color.WHITE);
			txtMessage.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			txtMessage.setBounds(23, 450, 380, 25);
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
			pnlChat.setOpaque(false);
			pnlChat.setBackground(Color.BLACK);
			pnlChat.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
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
			txtChat.setForeground(Color.WHITE);
			txtChat.setBackground(Color.BLACK);
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

	private JLabel getBtnJoinGame() {
		if (btnJoinGame == null) {
			btnJoinGame = new JLabel();
			btnJoinGame.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					btnJoinGameMouseClicked(arg0);
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
			btnJoinGame.setIcon(new ImageIcon(WaitingRoomUI.class
					.getResource("/images/joinIcon.png")));
			btnJoinGame.setBounds(221, 15, 60, 60);
			btnJoinGame.setText("Join game");
			btnJoinGame.setFocusable(false);
		}
		return btnJoinGame;
	}

	private JLabel getBtnProfile() {
		if (btnProfile == null) {
			btnProfile = new JLabel();
			btnProfile.setBounds(633, 15, 60, 60);
			btnProfile.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					btnProfileMouseClicked(e);
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
			btnProfile.setHorizontalAlignment(SwingConstants.CENTER);
			btnProfile.setFocusable(false);
			btnProfile.setIcon(new ImageIcon(WaitingRoomUI.class
					.getResource("/images/profile_icon.png")));
		}
		return btnProfile;
	}

	private JLabel getLblAvatar() {
		if (lblAvatar == null) {
			lblAvatar = new JLabel();
			lblAvatar.setHorizontalAlignment(SwingConstants.CENTER);
			lblAvatar.setBounds(23, 15, 100, 120);
			lblAvatar.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
		}
		return lblAvatar;
	}

	private JPanel getPnlUsers() {
		if (pnlUsers == null) {
			pnlUsers = new JPanel();
			pnlUsers.setBackground(Color.BLACK);
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
		Controller.getInstance().showGamesListUI();
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
			htmlEditor.insertHTML(chatText, chatText.getLength(),
					"<font color=\"white\"><b>" + sender + ":</b> " + message
							+ "</font>", 0, 0, null);
			txtChat.setCaretPosition(txtChat.getDocument().getLength());
		} catch (BadLocationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void userLogged(String user) {
		try {
			htmlEditor.insertHTML(
					chatText,
					chatText.getLength(),
					"<font color=\"white\"><b>" + user + " "
							+ language.getString("userJoinGameMessage")
							+ "</b></font> ", 0, 0, null);
		} catch (BadLocationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		refreshUsersList();
		refreshFriendList();
	}

	public void userLeave(String user) {
		try {
			htmlEditor.insertHTML(
					chatText,
					chatText.getLength(),
					"<font color=\"white\"><b>" + user + " "
							+ language.getString("userLeaveGameMessage")
							+ "</b></font> ", 0, 0, null);
		} catch (BadLocationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		refreshUsersList();
		refreshFriendList();
	}

	private void refreshUsersList() {
		int size = 0;
		pnlUsers.removeAll();
		for (int i = 0; i < users.size(); i++) {
			JPanel pnlUser = new JPanelRound();
			pnlUser.setLayout(null);
			pnlUser.setBounds(margin, margin + i * pnlUserHeight + i * margin,
					pnlUsers.getWidth() - 2 * margin, pnlUserHeight);
			// pnlUser.setBorder(new LineBorder(Color.BLACK, 1, false));
			pnlUsers.add(pnlUser);

			JLabel userAvatarLabel = new JLabel();
			if (users.get(i).getAvatar().length == 0) {
				ImageIcon image = new ImageIcon(
						WaitingRoomUI.class
								.getResource("/images/no_avatar_icon.png"));
				image = new ImageIcon(image.getImage().getScaledInstance(
						userIconLabelWidth, userIconLabelHeight,
						Image.SCALE_SMOOTH));
				userAvatarLabel.setIcon(image);
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
			userNameLabel.setForeground(Color.white);
			pnlUser.add(userNameLabel);
			size += margin + pnlUserHeight;
			pnlUser.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					userClicked(evt, userNameLabel.getText());
				}

				@Override
				public void mouseEntered(MouseEvent evt) {
					setHandCursor();
					JPanel userPanel = (JPanel) evt.getComponent();
					userPanel.setBorder(new LineBorder(Color.BLACK, 2, false));
				}

				@Override
				public void mouseExited(MouseEvent evt) {
					setDefaultCursor();
					JPanel userPanel = (JPanel) evt.getComponent();
					userPanel.setBorder(new LineBorder(Color.BLACK, 1, false));
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

	private User isOnline(String username) {
		for (User user : users)
			if (user.getUsername().equalsIgnoreCase(username))
				return user;
		return null;
	}

	public void refreshFriendList() {
		int size = 0;
		pnlFriends.removeAll();

		for (int i = 0; i < user.getFriends().size(); i++) {
			String friendName = user.getFriends().get(i);
			JPanelRound pnlUser = new JPanelRound();
			pnlUser.setLayout(null);
			pnlUser.setBounds(margin, margin + i * pnlUserHeight + i * margin,
					pnlUsers.getWidth() - 2 * margin, pnlUserHeight);
			pnlUser.setBorder(new LineBorder(Color.BLACK, 1, false));
			pnlFriends.add(pnlUser);

			User friend = isOnline(friendName);
			JLabel userAvatarLabel = new JLabel();

			if (friend != null) {
				if (friend.getAvatar().length == 0) {
					ImageIcon image = new ImageIcon(
							WaitingRoomUI.class
									.getResource("/images/no_avatar_icon.png"));
					image = new ImageIcon(image.getImage().getScaledInstance(
							userIconLabelWidth, userIconLabelHeight,
							Image.SCALE_SMOOTH));
					userAvatarLabel.setIcon(image);
				} else {
					ImageIcon image = new ImageIcon(friend.getAvatar());
					image = new ImageIcon(image.getImage().getScaledInstance(
							userIconLabelWidth, userIconLabelHeight,
							Image.SCALE_SMOOTH));
					userAvatarLabel.setIcon(image);
				}
			} else {
				ImageIcon image = new ImageIcon(
						WaitingRoomUI.class
								.getResource("/images/no_avatar_icon.png"));
				image = new ImageIcon(image.getImage().getScaledInstance(
						userIconLabelWidth, userIconLabelHeight,
						Image.SCALE_SMOOTH));
				userAvatarLabel.setIcon(image);
				pnlUser.setColorPrimario(Color.GRAY);
				pnlUser.setColorContorno(Color.DARK_GRAY);
			}

			userAvatarLabel.setBounds(margin, margin, userIconLabelWidth,
					userIconLabelHeight);
			userAvatarLabel.setBorder(BorderFactory
					.createLineBorder(Color.BLACK));
			pnlUser.add(userAvatarLabel);
			final JLabel userNameLabel = new JLabel();
			userNameLabel.setText(friendName);
			userNameLabel.setBounds(60, margin, userNameLabelWidth,
					userNameLabelHeight);
			userNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
			userNameLabel.setHorizontalTextPosition(SwingConstants.LEFT);
			userNameLabel.setFont(new Font("Courier New", Font.BOLD, 15));
			userNameLabel.setForeground(Color.WHITE);
			pnlUser.add(userNameLabel);
			size += margin + pnlUserHeight;

			pnlUser.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					userClicked(evt, userNameLabel.getText());
				}

				@Override
				public void mouseEntered(MouseEvent evt) {
					setHandCursor();
					JPanel userPanel = (JPanel) evt.getComponent();
					userPanel.setBorder(new LineBorder(Color.BLACK, 2, false));
				}

				@Override
				public void mouseExited(MouseEvent evt) {
					setDefaultCursor();
					JPanel userPanel = (JPanel) evt.getComponent();
					userPanel.setBorder(new LineBorder(Color.BLACK, 1, false));
				}
			});
		}

		size += margin;
		if (size > scrollPnlFriends.getHeight()) {
			scrollPnlFriends.setBounds(scrollPnlFriends.getX(),
					scrollPnlFriends.getY(), scrollPnlFriends.getWidth() + 20,
					scrollPnlFriends.getHeight());
		}
		pnlFriends.setPreferredSize(new Dimension(pnlFriends.getWidth(), size));
		pnlFriends.setSize(pnlFriends.getWidth(), size);
		pnlFriends.repaint();
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
				htmlEditor.insertHTML(chatText, chatText.getLength(),
						"<font color=\"white\"><b>" + user.getUsername()
								+ ":</b> " + message + "</font>", 0, 0, null);
			} catch (BadLocationException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		txtMessage.setText(null);
		txtChat.setCaretPosition(txtChat.getDocument().getLength());
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
			tabPanel.setBackground(Color.BLACK);
			tabPanel.setForeground(Color.BLACK);
			tabPanel.setBounds(554, 146, 150, 288);
			tabPanel.addTab(language.getString("tabUsers"), null,
					getJScrollPane1(), null);
			tabPanel.addTab(language.getString("tabFriends"), null,
					getScrollPnlFriends(), null);
		}
		return tabPanel;
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

	private void userClicked(MouseEvent evt, String username) {

		User user = null;
		for (User aux : users)
			if (aux.getUsername().equals(username)) {
				user = aux;
				break;
			}
		if (user == null)
			user = Controller.getInstance().userInfo(username);
		new UserInfoUI(this, user, isFriend(user.getUsername()));

	}

	private boolean isFriend(String username) {
		List<String> friends = user.getFriends();
		for (String friend : friends) {
			if (friend.equalsIgnoreCase(username)) {
				return true;
			}
		}

		return false;
	}

	private JLabel getBtnMessages() {
		if (btnMessages == null) {
			btnMessages = new JLabel();
			btnMessages.setBounds(562, 15, 60, 60);
			btnMessages.setHorizontalAlignment(SwingConstants.CENTER);
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

	private JScrollPane getScrollPnlFriends() {
		if (scrollPnlFriends == null) {
			scrollPnlFriends = new JScrollPane();
			scrollPnlFriends.setBorder(new EmptyBorder(0, 0, 0, 0));
			scrollPnlFriends.setViewportView(getPnlFriends());
		}
		return scrollPnlFriends;
	}

	private JPanel getPnlFriends() {
		if (pnlFriends == null) {
			pnlFriends = new JPanel();
			pnlFriends.setBackground(Color.BLACK);
			pnlFriends.setLayout(null);
		}
		return pnlFriends;
	}
}
