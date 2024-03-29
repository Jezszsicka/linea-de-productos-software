package presentation;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileFilter;

import logic.LanguageManager;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class ChooseAvatarUI extends javax.swing.JFrame {

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JFrame parent;
	private JPanelRound pnlBackground;
	private JButton btnUpload;
	private JLabel lblAvatar4;
	private JButton btnCancel;
	private JLabel lblAvatar5;
	private JLabel lblAvatar8;
	private JLabel lblAvatar7;
	private JLabel lblAvatar6;
	private JLabel lblAvatar3;
	private JLabel lblAvatar2;
	private JLabel lblAvatar1;
	private LanguageManager language;

	public ChooseAvatarUI(JFrame parentUI) {
		super();
		setTitle("Seleccionar avatar");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				ChooseAvatarUI.class.getResource("/images/icon.png")));
		this.parent = parentUI;
		this.language = LanguageManager.language();
		initGUI();
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private void initGUI() {
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				thisWindowClosing(evt);
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(getPnlBackground());
		setSize(526, 404);
	}

	private JPanelRound getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanelRound();
			pnlBackground.setArch(0);
			pnlBackground.setArcw(0);
			pnlBackground.setBounds(0, 0, 510, 366);
			pnlBackground.setLayout(null);
			pnlBackground.add(getBtnUpload());
			pnlBackground.add(getLblAvatar1());
			pnlBackground.add(getLblAvatar2());
			pnlBackground.add(getLblAvatar3());
			pnlBackground.add(getLblAvatar4());
			pnlBackground.add(getLblAvatar5());
			pnlBackground.add(getLblAvatar6());
			pnlBackground.add(getLblAvatar7());
			pnlBackground.add(getLblAvatar8());
			pnlBackground.add(getBtnCancel());
		}
		return pnlBackground;
	}

	private JButton getBtnUpload() {
		if (btnUpload == null) {
			btnUpload = new JButton("Subir imagen");
			btnUpload.setFocusable(false);
			btnUpload.setText(language.getString("btnUpload"));
			btnUpload.setBounds(382, 303, 104, 23);
			btnUpload.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnUploadMouseClicked(evt);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					btnUploadMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnUploadMouseExited(e);
				}
			});
		}
		return btnUpload;
	}

	private void btnUploadMouseClicked(MouseEvent evt) {
		JFileChooser fileChooser = new JFileChooser();
		FileFilter filter = new ExtensionFileFilter(
				"Image file (*.jpg,*.jpeg,*.png)", new String[] { "jpg",
						"jpeg", "png" });
		fileChooser.setFileFilter(filter);

		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			if (parent instanceof ProfileUI) {
				((ProfileUI) parent).setAvatar(file);
			} else {
				((RegisterUI) parent).setAvatar(file);
			}
			dispose();
			parent.setEnabled(true);
			parent.toFront();
		}
	}

	private JLabel getLblAvatar1() {
		if (lblAvatar1 == null) {
			lblAvatar1 = new JLabel();
			lblAvatar1.setBounds(32, 22, 104, 124);
			lblAvatar1.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar1.setIcon(new ImageIcon(ChooseAvatarUI.class
					.getResource("/images/Avatars/1.jpg")));
			lblAvatar1.setFocusable(false);
			lblAvatar1.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lblAvatar1MouseClicked(evt);
				}

				public void mousePressed(MouseEvent evt) {
					lblAvatar1MousePressed(evt);
				}

				public void mouseExited(MouseEvent evt) {
					lblAvatar1MouseExited(evt);
				}

				public void mouseEntered(MouseEvent evt) {
					lblAvatar1MouseEntered(evt);
				}
			});
		}
		return lblAvatar1;
	}

	private JLabel getLblAvatar2() {
		if (lblAvatar2 == null) {
			lblAvatar2 = new JLabel();
			lblAvatar2.setBounds(146, 22, 104, 124);
			lblAvatar2.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar2.setIcon(new ImageIcon(ChooseAvatarUI.class
					.getResource("/images/Avatars/2.jpg")));
			lblAvatar2.setFocusable(false);
			lblAvatar2.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lblAvatar2MouseClicked(evt);
				}

				public void mousePressed(MouseEvent evt) {
					lblAvatar2MousePressed(evt);
				}

				public void mouseExited(MouseEvent evt) {
					lblAvatar2MouseExited(evt);
				}

				public void mouseEntered(MouseEvent evt) {
					lblAvatar2MouseEntered(evt);
				}
			});
		}
		return lblAvatar2;
	}

	private JLabel getLblAvatar3() {
		if (lblAvatar3 == null) {
			lblAvatar3 = new JLabel();
			lblAvatar3.setBounds(260, 22, 104, 124);
			lblAvatar3.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar3.setIcon(new ImageIcon(ChooseAvatarUI.class
					.getResource("/images/Avatars/3.jpg")));
			lblAvatar3.setFocusable(false);
			lblAvatar3.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					lblAvatar3MouseClicked(evt);
				}

				public void mouseExited(MouseEvent evt) {
					lblAvatar3MouseExited(evt);
				}

				public void mousePressed(MouseEvent evt) {
					lblAvatar3MousePressed(evt);
				}

				public void mouseEntered(MouseEvent evt) {
					lblAvatar3MouseEntered(evt);
				}
			});
		}
		return lblAvatar3;
	}

	private JLabel getLblAvatar4() {
		if (lblAvatar4 == null) {
			lblAvatar4 = new JLabel();
			lblAvatar4.setIcon(new ImageIcon(ChooseAvatarUI.class
					.getResource("/images/Avatars/4.jpg")));
			lblAvatar4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					lblAvatar4MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblAvatar4MouseExited(e);
				}

				@Override
				public void mouseClicked(MouseEvent arg0) {
					lblAvatar4MouseClicked(arg0);
				}
			});
			lblAvatar4.setBounds(374, 22, 104, 124);
			lblAvatar4.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar4.setFocusable(false);
		}
		return lblAvatar4;
	}

	private JLabel getLblAvatar6() {
		if (lblAvatar6 == null) {
			lblAvatar6 = new JLabel();
			lblAvatar6.setIcon(new ImageIcon(ChooseAvatarUI.class
					.getResource("/images/Avatars/6.jpg")));
			lblAvatar6.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					lblAvatar6MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblAvatar6MouseExited(e);
				}

				@Override
				public void mouseClicked(MouseEvent arg0) {
					lblAvatar6MouseClicked(arg0);
				}
			});
			lblAvatar6.setBounds(146, 157, 104, 124);
			lblAvatar6.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar6.setFocusable(false);
		}
		return lblAvatar6;
	}

	private JLabel getLblAvatar7() {
		if (lblAvatar7 == null) {
			lblAvatar7 = new JLabel();
			lblAvatar7.setIcon(new ImageIcon(ChooseAvatarUI.class
					.getResource("/images/Avatars/7.jpg")));
			lblAvatar7.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					lblAvatar7MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblAvatar7MouseExited(e);
				}

				@Override
				public void mouseClicked(MouseEvent arg0) {
					lblAvatar7MouseClicked(arg0);
				}
			});
			lblAvatar7.setBounds(260, 157, 104, 124);
			lblAvatar7.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar7.setFocusable(false);
		}
		return lblAvatar7;
	}

	private JLabel getLblAvatar8() {
		if (lblAvatar8 == null) {
			lblAvatar8 = new JLabel();
			lblAvatar8.setIcon(new ImageIcon(ChooseAvatarUI.class
					.getResource("/images/Avatars/8.jpg")));
			lblAvatar8.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					lblAvatar8MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblAvatar8MouseExited(e);
				}

				@Override
				public void mouseClicked(MouseEvent arg0) {
					lblAvatar8MouseClicked(arg0);
				}
			});
			lblAvatar8.setBounds(374, 157, 104, 124);
			lblAvatar8.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar8.setFocusable(false);
		}
		return lblAvatar8;
	}

	private JLabel getLblAvatar5() {
		if (lblAvatar5 == null) {
			lblAvatar5 = new JLabel();
			lblAvatar5.setIcon(new ImageIcon(ChooseAvatarUI.class
					.getResource("/images/Avatars/5.jpg")));
			lblAvatar5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					lblAvatar5MouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblAvatar5MouseExited(e);
				}

				@Override
				public void mouseClicked(MouseEvent arg0) {
					lblAvatar5MouseClicked(arg0);
				}
			});
			lblAvatar5.setBounds(32, 157, 104, 124);
			lblAvatar5.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar5.setFocusable(false);
		}
		return lblAvatar5;
	}

	private void lblAvatar1MouseEntered(MouseEvent evt) {
		lblAvatar1.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.RAISED));
		setHandCursor();
	}

	private void lblAvatar1MouseExited(MouseEvent evt) {
		lblAvatar1.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.LOWERED));
		setDefaultCursor();
	}

	private void lblAvatar1MousePressed(MouseEvent evt) {
		lblAvatar1.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.LOWERED));
	}

	private void lblAvatar2MouseEntered(MouseEvent evt) {
		lblAvatar2.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.RAISED));
		setHandCursor();
	}

	private void lblAvatar2MouseExited(MouseEvent evt) {
		lblAvatar2.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.LOWERED));
		setDefaultCursor();
	}

	private void lblAvatar2MousePressed(MouseEvent evt) {
		lblAvatar2.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.LOWERED));
		setHandCursor();
	}

	private void lblAvatar2MouseClicked(MouseEvent evt) {
		changeAvatar(2);
		setDefaultCursor();
	}

	private void changeAvatar(int avatar) {
		File file = new File(ChooseAvatarUI.class.getResource(
				"/images/Avatars/" + avatar + ".jpg").getPath());
		if (parent instanceof ProfileUI) {
			((ProfileUI) parent).setAvatar(file);
		} else {
			((RegisterUI) parent).setAvatar(file);
		}
		parent.setEnabled(true);
		dispose();
	}

	private void lblAvatar1MouseClicked(MouseEvent evt) {
		changeAvatar(1);
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancelar");
			btnCancel.setFocusable(false);
			btnCancel.setText(language.getString("btnCancel"));
			btnCancel.setBounds(382, 332, 104, 23);
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

	private void btnCancelMouseClicked(MouseEvent evt) {
		dispose();
		parent.setEnabled(true);
		parent.toFront();
	}

	private void lblAvatar3MouseEntered(MouseEvent evt) {
		lblAvatar3.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.RAISED));
		setHandCursor();
	}

	private void lblAvatar3MousePressed(MouseEvent evt) {
		lblAvatar3.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.LOWERED));
	}

	private void lblAvatar3MouseExited(MouseEvent evt) {
		lblAvatar3.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.LOWERED));
		setDefaultCursor();
	}

	private void lblAvatar3MouseClicked(MouseEvent evt) {
		changeAvatar(3);
	}

	private void thisWindowClosing(WindowEvent evt) {
		parent.setEnabled(true);
		dispose();
	}

	private void setHandCursor() {
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	private void setDefaultCursor() {
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	protected void btnUploadMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnUploadMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void btnCancelMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnCancelMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void lblAvatar4MouseEntered(MouseEvent e) {
		lblAvatar4.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.RAISED));
		setHandCursor();
	}

	protected void lblAvatar4MouseExited(MouseEvent e) {
		lblAvatar4.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.LOWERED));
		setDefaultCursor();
	}

	protected void lblAvatar5MouseEntered(MouseEvent e) {
		lblAvatar5.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.RAISED));
		setHandCursor();
	}

	protected void lblAvatar5MouseExited(MouseEvent e) {
		lblAvatar5.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.LOWERED));
		setDefaultCursor();
	}

	protected void lblAvatar6MouseEntered(MouseEvent e) {
		lblAvatar6.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.RAISED));
		setHandCursor();
	}

	protected void lblAvatar6MouseExited(MouseEvent e) {
		lblAvatar6.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.LOWERED));
		setDefaultCursor();
	}

	protected void lblAvatar7MouseEntered(MouseEvent e) {
		lblAvatar7.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.RAISED));
		setHandCursor();
	}

	protected void lblAvatar7MouseExited(MouseEvent e) {
		lblAvatar7.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.LOWERED));
		setDefaultCursor();
	}

	protected void lblAvatar8MouseEntered(MouseEvent e) {
		lblAvatar8.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.RAISED));
		setHandCursor();
	}

	protected void lblAvatar8MouseExited(MouseEvent e) {
		lblAvatar8.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.LOWERED));
		setDefaultCursor();
	}

	protected void lblAvatar5MouseClicked(MouseEvent arg0) {
		changeAvatar(5);
	}

	protected void lblAvatar4MouseClicked(MouseEvent arg0) {
		changeAvatar(4);
	}

	protected void lblAvatar8MouseClicked(MouseEvent arg0) {
		changeAvatar(8);
	}

	protected void lblAvatar6MouseClicked(MouseEvent arg0) {
		changeAvatar(6);
	}

	protected void lblAvatar7MouseClicked(MouseEvent arg0) {
		changeAvatar(7);
	}
}

class ExtensionFileFilter extends FileFilter {
	String description;

	String extensions[];

	public ExtensionFileFilter(String description, String extension) {
		this(description, new String[] { extension });
	}

	public ExtensionFileFilter(String description, String extensions[]) {
		if (description == null) {
			this.description = extensions[0];
		} else {
			this.description = description;
		}
		this.extensions = (String[]) extensions.clone();
		toLower(this.extensions);
	}

	private void toLower(String array[]) {
		for (int i = 0, n = array.length; i < n; i++) {
			array[i] = array[i].toLowerCase();
		}
	}

	public String getDescription() {
		return description;
	}

	public boolean accept(File file) {
		if (file.isDirectory()) {
			return true;
		} else {
			String path = file.getAbsolutePath().toLowerCase();
			for (int i = 0, n = extensions.length; i < n; i++) {
				String extension = extensions[i];
				if ((path.endsWith(extension) && (path.charAt(path.length()
						- extension.length() - 1)) == '.')) {
					return true;
				}
			}
		}
		return false;
	}
}
