package presentation;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

import logic.Controller;

import ProductLine.Message;
import ProductLine.MessageType;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class ReadMessageUI extends javax.swing.JFrame {
	private MessagesUI messagesUI;
	private JPanelRound pnlBackground;
	private JButton btnDelete;
	private JButton btnBack;
	private JTextPane txtMessage;
	private JScrollPane pnlMessageScroll;
	private JLabel lblFrom;
	private JLabel txtFrom;
	private JLabel lblSubject;
	private JLabel txtSubject;
	private MessageType type;
	private Message message;

	public ReadMessageUI(Message message, MessagesUI messagesUI) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				ReadMessageUI.class.getResource("/images/icon.png")));
		setTitle("Leer mensaje");
		initGUI();
		txtFrom.setText(message.getSender());
		txtSubject.setText(message.getSubject());
		txtMessage.setText(message.getContent());
		this.messagesUI = messagesUI;
		this.message = message;
		messagesUI.setVisible(false);
		type = message.getType();

		if (type == MessageType.Invitation) {
			btnDelete.setText("Aceptar");
			btnBack.setText("Rechazar");
		}

		if (!message.isSeen())
			Controller.getInstance().markMessageAsRead(message);
	}

	private void initGUI() {
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getPnlBackground());
		this.setSize(500, 350);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				thisWindowClosing(evt);
			}
		});
	}

	private JPanelRound getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanelRound();
			pnlBackground.setArch(0);
			pnlBackground.setArcw(0);
			pnlBackground.setLayout(null);
			pnlBackground.setBounds(0, 0, 484, 312);
			pnlBackground.add(getTxtSubject());
			pnlBackground.add(getLblSubject());
			pnlBackground.add(getTxtFrom());
			pnlBackground.add(getLblFrom());
			pnlBackground.add(getPnlMessageScroll());
			pnlBackground.add(getBtnBack());
			pnlBackground.add(getBtnDelete());
		}
		return pnlBackground;
	}

	private JLabel getTxtSubject() {
		if (txtSubject == null) {
			txtSubject = new JLabel();
			txtSubject.setBackground(Color.BLACK);
			txtSubject.setOpaque(true);
			txtSubject.setForeground(Color.WHITE);
			txtSubject.setBounds(76, 42, 395, 25);
			txtSubject.setBorder(BorderFactory.createTitledBorder(""));
		}
		return txtSubject;
	}

	private JLabel getLblSubject() {
		if (lblSubject == null) {
			lblSubject = new JLabel();
			lblSubject.setForeground(Color.WHITE);
			lblSubject.setText("Asunto:");
			lblSubject.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblSubject.setBounds(10, 42, 45, 25);
		}
		return lblSubject;
	}

	private JLabel getTxtFrom() {
		if (txtFrom == null) {
			txtFrom = new JLabel();
			txtFrom.setOpaque(true);
			txtFrom.setBackground(Color.BLACK);
			txtFrom.setForeground(Color.WHITE);
			txtFrom.setBounds(76, 11, 395, 25);
			txtFrom.setBorder(BorderFactory.createTitledBorder(""));
		}
		return txtFrom;
	}

	private JLabel getLblFrom() {
		if (lblFrom == null) {
			lblFrom = new JLabel();
			lblFrom.setForeground(Color.WHITE);
			lblFrom.setText("De:");
			lblFrom.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblFrom.setBounds(10, 11, 45, 25);
		}
		return lblFrom;
	}

	private JScrollPane getPnlMessageScroll() {
		if (pnlMessageScroll == null) {
			pnlMessageScroll = new JScrollPane();
			pnlMessageScroll.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlMessageScroll.setBounds(10, 77, 461, 167);
			pnlMessageScroll.setViewportView(getTxtMessage());
		}
		return pnlMessageScroll;
	}

	private JTextPane getTxtMessage() {
		if (txtMessage == null) {
			txtMessage = new JTextPane();
			txtMessage.setForeground(Color.WHITE);
			txtMessage.setBackground(Color.BLACK);
			txtMessage.setPreferredSize(new java.awt.Dimension(458, 166));
			txtMessage.setEditable(false);
		}
		return txtMessage;
	}

	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton();
			btnBack.setText("Volver");
			btnBack.setBounds(386, 283, 88, 23);
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

	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton();
			btnDelete.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnDeleteMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnDeleteMouseExited(e);
				}

				@Override
				public void mouseClicked(MouseEvent arg0) {
					btnDeleteMouseClicked(arg0);
				}
			});
			btnDelete.setText("Eliminar");
			btnDelete.setBounds(386, 254, 88, 23);
			btnDelete.setFocusable(false);
		}
		return btnDelete;
	}

	private void setHandCursor() {
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	private void setDefaultCursor() {
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	protected void btnDeleteMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnDeleteMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void btnBackMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnBackMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void btnDeleteMouseClicked(MouseEvent evt) {
		if (type == MessageType.Invitation) {

			Controller.getInstance().friendRequestResponse(message.getSender(),
					true);
		}
		messagesUI.setVisible(true);
		messagesUI.removeMessage();
		dispose();
	}

	private void btnBackMouseClicked(MouseEvent evt) {
		if (type == MessageType.Invitation) {

			Controller.getInstance().friendRequestResponse(message.getSender(),
					false);
			Controller.getInstance().deleteMessage(message);
			messagesUI.removeMessage();
		}
		messagesUI.setVisible(true);

		dispose();
	}

	private void thisWindowClosing(WindowEvent evt) {
		messagesUI.setVisible(true);
		dispose();
	}

}
