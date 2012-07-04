package presentation;

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

import model.Message;

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
public class ReadMessageUI extends javax.swing.JFrame {
	private MessagesUI messagesUI;
	private JPanel pnlBackground;
	private JButton btnDelete;
	private JButton btnBack;
	private JTextPane txtMessage;
	private JScrollPane pnlMessageScroll;
	private JLabel lblFrom;
	private JLabel txtFrom;
	private JLabel lblSubject;
	private JLabel txtSubject;

	public ReadMessageUI(Message message, MessagesUI messagesUI) {
		super();
		initGUI();
		txtFrom.setText(message.getFrom());
		txtSubject.setText(message.getSubject());
		txtMessage.setText(message.getContent());
		this.messagesUI = messagesUI;
		messagesUI.setVisible(false);
	}

	private void initGUI() {
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getPnlBackground());
		pack();
		this.setSize(500, 350);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
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
			txtSubject.setBounds(76, 42, 395, 20);
			txtSubject.setBorder(BorderFactory.createTitledBorder(""));
		}
		return txtSubject;
	}

	private JLabel getLblSubject() {
		if (lblSubject == null) {
			lblSubject = new JLabel();
			lblSubject.setText("Asunto:");
			lblSubject.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblSubject.setBounds(10, 42, 45, 20);
		}
		return lblSubject;
	}

	private JLabel getTxtFrom() {
		if (txtFrom == null) {
			txtFrom = new JLabel();
			txtFrom.setBounds(76, 16, 395, 20);
			txtFrom.setBorder(BorderFactory.createTitledBorder(""));
		}
		return txtFrom;
	}

	private JLabel getLblFrom() {
		if (lblFrom == null) {
			lblFrom = new JLabel();
			lblFrom.setText("De:");
			lblFrom.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblFrom.setBounds(10, 17, 45, 18);
		}
		return lblFrom;
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
			txtMessage.setEditable(false);
		}
		return txtMessage;
	}

	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton();
			btnBack.setText("Volver");
			btnBack.setBounds(398, 283, 76, 23);
			btnBack.setFocusable(false);
			btnBack.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnBackMouseClicked(evt);
				}
			});
		}
		return btnBack;
	}

	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton();
			btnDelete.setText("Delete");
			btnDelete.setBounds(398, 254, 76, 23);
			btnDelete.setFocusable(false);
		}
		return btnDelete;
	}

	private void btnBackMouseClicked(MouseEvent evt) {
		messagesUI.setVisible(true);
		dispose();
	}

	private void thisWindowClosing(WindowEvent evt) {
		messagesUI.setVisible(true);
		dispose();
	}

}
