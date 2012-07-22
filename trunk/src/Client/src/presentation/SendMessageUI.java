package presentation;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import exceptions.WrongInputException;

import ProductLine.MessageType;

import logic.Controller;
import model.Message;

@SuppressWarnings("serial")
public class SendMessageUI extends javax.swing.JFrame {
	private MessagesUI messagesUI;
	private JPanel pnlBackground;
	private JLabel lblTo;
	private JTextField txtSubject;
	private JLabel lblSubject;
	private JTextField txtReceiver;
	private JButton btnCancel;
	private JButton btnSend;
	private JTextPane txtMessage;
	private JScrollPane pnlMessageScroll;

	public SendMessageUI(MessagesUI messagesUI) {
		super();
		initGUI();
		this.messagesUI = messagesUI;
		messagesUI.setVisible(false);
	}

	private void initGUI() {
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getPnlBackground());
		this.setSize(497, 352);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				thisWindowClosing(evt);
			}
		});
	}

	private JPanel getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setLayout(null);
			pnlBackground.setBounds(0, 0, 481, 314);
			pnlBackground.add(getPnlMessageScroll());
			pnlBackground.add(getBtnSend());
			pnlBackground.add(getBtnCancel());
			pnlBackground.add(getLblTo());
			pnlBackground.add(getTxtReceiver());
			pnlBackground.add(getLblSubject());
			pnlBackground.add(getTxtSubject());
		}
		return pnlBackground;
	}

	private JScrollPane getPnlMessageScroll() {
		if (pnlMessageScroll == null) {
			pnlMessageScroll = new JScrollPane();
			pnlMessageScroll.setBounds(10, 77, 461, 167);
			pnlMessageScroll.setViewportView(getTxtMessage());
		}
		return pnlMessageScroll;
	}

	private JTextPane getTxtMessage() {
		if (txtMessage == null) {
			txtMessage = new JTextPane();
			txtMessage.setPreferredSize(new java.awt.Dimension(458, 166));
		}
		return txtMessage;
	}

	private JButton getBtnSend() {
		if (btnSend == null) {
			btnSend = new JButton();
			btnSend.setText("Enviar");
			btnSend.setBounds(396, 251, 75, 23);
			btnSend.setFocusable(false);
			btnSend.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnSendMouseClicked(evt);
				}
			});
		}
		return btnSend;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton();
			btnCancel.setText("Cancelar");
			btnCancel.setBounds(396, 280, 75, 23);
			btnCancel.setFocusable(false);
			btnCancel.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnCancelMouseClicked(evt);
				}
			});
		}
		return btnCancel;
	}

	private JLabel getLblTo() {
		if (lblTo == null) {
			lblTo = new JLabel();
			lblTo.setText("Para:");
			lblTo.setBounds(10, 17, 45, 18);
			lblTo.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblTo;
	}

	private JTextField getTxtReceiver() {
		if (txtReceiver == null) {
			txtReceiver = new JTextField();
			txtReceiver.setBounds(76, 16, 395, 20);
		}
		return txtReceiver;
	}

	private JLabel getLblSubject() {
		if (lblSubject == null) {
			lblSubject = new JLabel();
			lblSubject.setBounds(10, 42, 45, 20);
			lblSubject.setText("Asunto:");
			lblSubject.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblSubject;
	}

	private JTextField getTxtSubject() {
		if (txtSubject == null) {
			txtSubject = new JTextField();
			txtSubject.setBounds(76, 42, 395, 20);
		}
		return txtSubject;
	}

	private void btnCancelMouseClicked(MouseEvent evt) {
		messagesUI.setVisible(true);
		dispose();
	}

	private void btnSendMouseClicked(MouseEvent evt) {
		String to = txtReceiver.getText();
		String subject = txtSubject.getText();
		String content = txtMessage.getText();
		int option = JOptionPane.showConfirmDialog(this,
				"¿Quieres mandar el mensaje sin asunto? ", "Asunto vacío",
				JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION) {
			try {
				Controller.getInstance().sendMessage(to, subject, content);
				messagesUI.setVisible(true);
				dispose();
			} catch (WrongInputException e) {
				JOptionPane.showMessageDialog(messagesUI, e.getMessage(),
						e.getError(), JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void thisWindowClosing(WindowEvent evt) {
		messagesUI.setVisible(true);
		dispose();
	}

}
