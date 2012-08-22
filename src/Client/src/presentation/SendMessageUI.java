package presentation;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

import ProductLine.MessageType;

import logic.Controller;
import exceptions.WrongInputException;
import java.awt.Color;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class SendMessageUI extends javax.swing.JFrame {

	private JPanelRound pnlBackground;
	private JLabel lblTo;
	private JTextField txtSubject;
	private JLabel lblSubject;
	private JTextField txtReceiver;
	private JButton btnCancel;
	private JButton btnSend;
	private JTextPane txtMessage;
	private JScrollPane pnlMessageScroll;

	private JFrame parentUI;
	private MessageType type;

	/**
	 * @wbp.parser.constructor
	 */
	public SendMessageUI(JFrame parent) {
		initGUI();
		this.parentUI = parent;
		this.type = MessageType.Normal;
		parent.setVisible(false);
	}

	public SendMessageUI(JFrame parent, String friend) {
		initGUI();
		this.parentUI = parent;
		this.type = MessageType.Invitation;
		parent.setEnabled(false);
		txtSubject.setText("Petición de amistad");
		txtSubject.setEditable(false);
		txtReceiver.setText(friend);
		txtReceiver.setEditable(false);

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

	private JPanelRound getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanelRound();
			pnlBackground.setArcw(0);
			pnlBackground.setArch(0);
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
			pnlMessageScroll.setBorder(null);
			pnlMessageScroll.setBounds(10, 77, 461, 167);
			pnlMessageScroll.setViewportView(getTxtMessage());
		}
		return pnlMessageScroll;
	}

	private JTextPane getTxtMessage() {
		if (txtMessage == null) {
			txtMessage = new JTextPane();
			txtMessage.setCaretColor(Color.WHITE);
			txtMessage.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			txtMessage.setBackground(Color.BLACK);
			txtMessage.setForeground(Color.WHITE);
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

				@Override
				public void mouseEntered(MouseEvent e) {
					btnCancelMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnCancelMouseExited(e);
				}
			});
		}
		return btnCancel;
	}

	private JLabel getLblTo() {
		if (lblTo == null) {
			lblTo = new JLabel();
			lblTo.setForeground(Color.WHITE);
			lblTo.setText("Para:");
			lblTo.setBounds(10, 12, 45, 25);
			lblTo.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblTo;
	}

	private JTextField getTxtReceiver() {
		if (txtReceiver == null) {
			txtReceiver = new JTextField();
			txtReceiver.setForeground(Color.WHITE);
			txtReceiver.setCaretColor(Color.WHITE);
			txtReceiver.setBackground(Color.BLACK);
			txtReceiver.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			txtReceiver.setBounds(76, 11, 395, 25);
		}
		return txtReceiver;
	}

	private JLabel getLblSubject() {
		if (lblSubject == null) {
			lblSubject = new JLabel();
			lblSubject.setForeground(Color.WHITE);
			lblSubject.setBounds(10, 42, 45, 25);
			lblSubject.setText("Asunto:");
			lblSubject.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblSubject;
	}

	private JTextField getTxtSubject() {
		if (txtSubject == null) {
			txtSubject = new JTextField();
			txtSubject.setBackground(Color.BLACK);
			txtSubject.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			txtSubject.setForeground(Color.WHITE);
			txtSubject.setBounds(76, 42, 395, 25);
		}
		return txtSubject;
	}

	private void btnCancelMouseClicked(MouseEvent evt) {
		parentUI.setVisible(true);
		parentUI.setEnabled(true);
		dispose();
	}

	private void btnSendMouseClicked(MouseEvent evt) {
		String to = txtReceiver.getText();
		String subject = txtSubject.getText();
		String content = txtMessage.getText();
		if (txtSubject.getText().isEmpty()) {

			int option = JOptionPane.showConfirmDialog(this,
					"¿Quieres mandar el mensaje sin asunto? ", "Asunto vacío",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				try {
					Controller.getInstance().sendMessage(to, subject, content,
							type);
					if (type == MessageType.Normal)
						parentUI.setVisible(true);
					else
						parentUI.setEnabled(true);
					dispose();
				} catch (WrongInputException e) {
					JOptionPane.showMessageDialog(parentUI, e.getMessage(),
							e.getError(), JOptionPane.ERROR_MESSAGE);
				}
			}
		} else {
			try {
				Controller.getInstance()
						.sendMessage(to, subject, content, type);
				if (type == MessageType.Normal)
					parentUI.setVisible(true);
				else
					parentUI.setEnabled(true);
				dispose();
			} catch (WrongInputException e) {
				JOptionPane.showMessageDialog(parentUI, e.getMessage(),
						e.getError(), JOptionPane.ERROR_MESSAGE);
			}

		}
	}

	private void thisWindowClosing(WindowEvent evt) {
		parentUI.setVisible(true);
		dispose();
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

	protected void btnCancelMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnCancelMouseExited(MouseEvent e) {
		setDefaultCursor();
	}
}
