package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
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
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import ProductLine.User;
import ProductLine.UserNotLoggedException;
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
public class WaitingRoomUI extends javax.swing.JFrame {

	private static final int pnlUserHeight = 55;
	private static final int userNameLabelWidth = 80;
	private static final int userNameLabelHeight = 45;
	private static final int userIconLabelWidth = 45;
	private static final int userIconLabelHeight = 45;
	private static final int margin = 5;
	private List<User> users;
	private JScrollPane scrollPnlUsers;

	private JPanel pnlButtons;
	private User user;

	private JPanel pnlFriends;
	private JTabbedPane jTabbedPane1;
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
		initGUI();
		this.user = user;
		this.users = users;
		if (user.getAvatar().length == 0) {
			lblAvatar.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/1.jpg")));
		} else {
			lblAvatar.setIcon(new ImageIcon(user.getAvatar()));
		}
		destinatary = "";
		refreshUsersList();
	}

	private void initGUI() {
		this.setSize(734, 527);
		this.setBounds(0, 0, 734, 527);
		getContentPane().add(getPnlBackground(), BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setVisible(true);
		BorderLayout thisLayout = new BorderLayout();
		getContentPane().setLayout(thisLayout);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				thisWindowClosing(evt);
			}
		});
	}

	private JPanel getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setBounds(0, 0, 684, 462);
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
			btnSend = new JButton("Send");
			btnSend.setBounds(413, 447, 64, 23);
			btnSend.setFocusable(false);
			btnSend.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnSendMouseClicked(evt);
				}
			});
		}
		return btnSend;
	}

	private JButton getBtnCreateGame() {
		if (btnCreateGame == null) {
			btnCreateGame = new JButton("Create game");
			btnCreateGame.setBounds(11, 6, 66, 53);
			btnCreateGame.setFocusable(false);
			btnCreateGame.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					btnCreateGameMouseClicked(e);
				}
			});
		}
		return btnCreateGame;
	}

	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("Exit");
			btnExit.setBounds(607, 447, 89, 23);
			btnExit.setFocusable(false);
			btnExit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					btnExitMouseClicked(e);
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
			pnlChat.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			pnlChat.setBounds(24, 146, 451, 289);
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
			});
		}
		return btnJoinGame;
	}

	private JButton getBtnProfile() {
		if (btnProfile == null) {
			btnProfile = new JButton();
			btnProfile.setBounds(470, 6, 56, 58);
			btnProfile.setFocusable(false);
			btnProfile.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/profile_icon.png")));
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
			});
		}
		return btnProfile;
	}

	private JLabel getLblAvatar() {
		if (lblAvatar == null) {
			lblAvatar = new JLabel();
			lblAvatar.setBounds(23, 15, 82, 89);
			lblAvatar.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/2.jpg")));
			lblAvatar.setSize(100, 120);
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
				"Are you sure you want to exit?", "Are you sure?",
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
				"Are you sure you want to exit?", "Are you sure?",
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
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void receiveMessage(String sender, String message) {
		try {
			htmlEditor.insertHTML(chatText, chatText.getLength(), "<b>"
					+ sender + ":</b> " + message, 0, 0, null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void userLogged(User user) {
		users.add(user);
		try {
			htmlEditor
					.insertHTML(chatText, chatText.getLength(),
							"<b>" + user.getUsername() + " has joined</b> ", 0,
							0, null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		refreshUsersList();
	}

	public void userLeave(String user) {
		for (int i = 0; i < user.length(); i++) {
			if (user.equals(users.get(i).getUsername())) {
				users.remove(i);
				break;
			}
		}
		try {
			htmlEditor.insertHTML(chatText, chatText.getLength(), "<b>" + user
					+ " has left</b> ", 0, 0, null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
			pnlUser.setBounds(margin, margin+i*pnlUserHeight+i*margin, pnlUsers.getWidth()-2*margin, pnlUserHeight);
			pnlUser.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			pnlUsers.add(pnlUser);
			
			JLabel userAvatarLabel = new JLabel();
			if (users.get(i).getAvatar().length == 0) {
				userAvatarLabel.setIcon(new ImageIcon(getClass()
						.getClassLoader().getResource("images/1.jpg")));
			} else {
				ImageIcon image = new ImageIcon(users.get(i).getAvatar());
				image = new ImageIcon(image.getImage().getScaledInstance(
						userIconLabelWidth, userIconLabelHeight,
						Image.SCALE_SMOOTH));
				userAvatarLabel.setIcon(image);
			}
			userAvatarLabel.setBounds(margin, margin, userIconLabelWidth, userIconLabelHeight);
			userAvatarLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			pnlUser.add(userAvatarLabel);
			JLabel userNameLabel = new JLabel();
			userNameLabel.setText(users.get(i).getUsername());
			userNameLabel.setBounds(60, margin, userNameLabelWidth, userNameLabelHeight);
			userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
			userNameLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			userNameLabel.setFont(new Font("Courier New", Font.BOLD, 15));
			pnlUser.add(userNameLabel);
			size += margin + pnlUserHeight;
		}
		size += margin;
		if(size > scrollPnlUsers.getHeight()){
			scrollPnlUsers.setBounds(scrollPnlUsers.getX(), scrollPnlUsers.getY(), scrollPnlUsers.getWidth()+20, scrollPnlUsers.getHeight());
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
					Controller.getInstance().sendPrivateMessage(
							user.getUsername(), destinatary, privateMessage);
					try {
						htmlEditor.insertHTML(chatText, chatText.getLength(),
								"<font color=\"red\"><b> >" + destinatary
										+ ":</b>" + privateMessage + "</font>",
								0, 0, null);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (UserNotLoggedException e1) {
					try {
						htmlEditor.insertHTML(chatText, chatText.getLength(),
								"<font color=\"gray\"><b>" + destinatary
										+ " is offline</b></font>", 0, 0, null);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}else{
				try {
					htmlEditor.insertHTML(chatText, chatText.getLength(),
							"<font color=\"gray\"><b>You can't send a message to yourself</b></font>", 0, 0, null);
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			Controller.getInstance().sendGeneralMessage(message);
			try {
				htmlEditor.insertHTML(chatText, chatText.getLength(), "<b>"
						+ user.getUsername() + ":</b> " + message, 0, 0, null);
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		txtMessage.setText(null);
	}

	private JPanel getPnlButtons() {
		if (pnlButtons == null) {
			pnlButtons = new JPanel();
			pnlButtons.setLayout(null);
			pnlButtons.setBounds(156, 15, 540, 70);
			pnlButtons.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
					false));
			pnlButtons.add(getBtnCreateGame());
			pnlButtons.add(getBtnJoinGame());
			pnlButtons.add(getBtnProfile());
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
		if (evt.getKeyChar() == '"'){
			if(!destinatary.isEmpty()){
				txtMessage.setText("\""+destinatary+" ");
				evt.consume();
			}
		}
	}
	
	private void txtMessageKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == 10 && txtMessage.getText().length() > 0)
			sendMessage();
	}
	
	private JTabbedPane getJTabbedPane1() {
		if(jTabbedPane1 == null) {
			jTabbedPane1 = new JTabbedPane();
			jTabbedPane1.setBounds(546, 146, 150, 288);
			jTabbedPane1.addTab("Users", null, getJScrollPane1(), null);
			jTabbedPane1.addTab("Friends", null, getPnlFriends(), null);
		}
		return jTabbedPane1;
	}
	
	private JPanel getPnlFriends() {
		if(pnlFriends == null) {
			pnlFriends = new JPanel();
			pnlFriends.setLayout(null);
		}
		return pnlFriends;
	}
	
	private JScrollPane getJScrollPane1() {
		if(scrollPnlUsers == null) {
			scrollPnlUsers = new JScrollPane();
			scrollPnlUsers.setPreferredSize(new java.awt.Dimension(143, 260));
			scrollPnlUsers.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			scrollPnlUsers.setViewportView(getPnlUsers());
		}
		return scrollPnlUsers;
	}

}
