package presentation;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import logic.Controller;
import ProductLine.Message;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class MessagesUI extends javax.swing.JFrame {
	private JPanelRound pnlBackground;
	private JTable tblMessages;
	private JButton btnRead;
	private JLabel lblMessages;
	private JScrollPane messagesScroll;
	private JButton btnDelete;
	private JButton btnSend;
	private JButton btnBack;
	private DefaultTableModel tblMessagesModel;
	private List<Message> messages;

	public MessagesUI(List<Message> messages) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				MessagesUI.class.getResource("/images/icon.png")));
		setTitle("Buzón de mensajes");
		this.messages = messages;

		initGUI();
		for (Message message : messages) {
			tblMessagesModel.addRow(new String[] { message.getSender(),
					message.getSubject() });
		}
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void initGUI() {
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				thisWindowClosing(evt);
			}
		});
		getContentPane().add(getPnlBackground());
		this.setSize(489, 323);
	}

	private JPanelRound getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanelRound();
			pnlBackground.setArcw(0);
			pnlBackground.setArch(0);
			pnlBackground.setLayout(null);
			pnlBackground.setBounds(0, 0, 473, 285);
			pnlBackground.add(getBtnBack());
			pnlBackground.add(getBtnSend());
			pnlBackground.add(getBtnDelete());
			pnlBackground.add(getJScrollPane1());
			pnlBackground.add(getLblMessages());
			pnlBackground.add(getBtnRead());
		}
		return pnlBackground;
	}

	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton();
			btnBack.setText("Volver");
			btnBack.setBounds(385, 256, 78, 23);
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

	private JButton getBtnSend() {
		if (btnSend == null) {
			btnSend = new JButton();
			btnSend.setBounds(10, 256, 105, 23);
			btnSend.setText("Enviar mensaje");
			btnSend.setFocusable(false);
			btnSend.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnSendMouseClicked(evt);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					btnSendMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnSendMouseExited(e);
				}
			});
		}
		return btnSend;
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
			btnDelete.setBounds(260, 256, 74, 23);
			btnDelete.setFocusable(false);
		}
		return btnDelete;
	}

	private JScrollPane getJScrollPane1() {
		if (messagesScroll == null) {
			messagesScroll = new JScrollPane();
			messagesScroll
					.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			messagesScroll.setBounds(10, 33, 453, 212);
			messagesScroll.setBorder(new LineBorder(
					new java.awt.Color(0, 0, 0), 1, false));
			messagesScroll.setViewportView(getTblMessages());
		}
		return messagesScroll;
	}

	private JLabel getLblMessages() {
		if (lblMessages == null) {
			lblMessages = new JLabel();
			lblMessages.setForeground(Color.WHITE);
			lblMessages.setText("Messages");
			lblMessages.setBounds(10, 11, 62, 16);
			lblMessages.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblMessages;
	}

	private JButton getBtnRead() {
		if (btnRead == null) {
			btnRead = new JButton();
			btnRead.setText("Leer");
			btnRead.setBounds(144, 256, 73, 23);
			btnRead.setFocusable(false);
			btnRead.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnReadMouseClicked(evt);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					btnReadMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnReadMouseExited(e);
				}
			});
		}
		return btnRead;
	}

	private JTable getTblMessages() {
		if (tblMessages == null) {
			tblMessagesModel = new presentation.TableModel(new String[][] {},
					new String[] { "De: ", "Asunto" });
			tblMessages = new JTable();
			tblMessages.setModel(tblMessagesModel);
			tblMessages.getColumnModel().getColumn(0).setPreferredWidth(125);
			tblMessages.getColumnModel().getColumn(1).setPreferredWidth(325);
			tblMessages.setOpaque(false);
			tblMessages.setFocusable(false);
			tblMessages.getTableHeader().setReorderingAllowed(false);
			tblMessages.getTableHeader().setResizingAllowed(false);
			tblMessages.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					tblMessagesMouseClicked(evt);
				}
			});
		}
		return tblMessages;
	}

	private void thisWindowClosing(WindowEvent evt) {
		Controller.getInstance().closeMessagesUI();
	}

	private void setHandCursor() {
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	private void setDefaultCursor() {
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	protected void btnSendMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnSendMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void btnReadMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnReadMouseExited(MouseEvent e) {
		setDefaultCursor();
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

	private void btnSendMouseClicked(MouseEvent evt) {
		new SendMessageUI(this);
	}

	private void btnBackMouseClicked(MouseEvent evt) {
		Controller.getInstance().closeMessagesUI();
	}

	private void tblMessagesMouseClicked(MouseEvent evt) {
		if (evt.getClickCount() == 2) {
			int row = tblMessages.getSelectedRow();
			new ReadMessageUI(messages.get(row), this);
		}
	}

	private void btnReadMouseClicked(MouseEvent evt) {
		int row = tblMessages.getSelectedRow();
		new ReadMessageUI(messages.get(row), this);
	}

	protected void btnDeleteMouseClicked(MouseEvent evt) {
		int row = tblMessages.getSelectedRow();
		Controller.getInstance().deleteMessage(messages.get(row));
		tblMessagesModel.removeRow(row);
	}

	public void removeMessage() {
		int row = tblMessages.getSelectedRow();
		Controller.getInstance().deleteMessage(messages.get(row));
		tblMessagesModel.removeRow(row);
	}

}
