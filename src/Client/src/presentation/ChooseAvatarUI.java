package presentation;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileFilter;

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

	private JFrame parentUI;
	private ImagePanel pnlBackground;
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

	/**
	 * Auto-generated main method to display this JFrame
	 */

	public ChooseAvatarUI(JFrame parentUI) {
		super();
		initGUI();
		this.parentUI = parentUI;
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().add(getPnlBackground(), BorderLayout.CENTER);
			pack();
			this.setSize(526, 404);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private ImagePanel getPnlBackground() {
		if (pnlBackground == null) {
			//pnlBackground = new ImagePanel(new ImageIcon(getClass().getClassLoader()
			//		.getResource("images/fondo.png")).getImage());
			pnlBackground = new ImagePanel("");
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
			btnUpload = new JButton();
			btnUpload.setText("Upload image");
			btnUpload.setBounds(389, 303, 97, 23);
			btnUpload.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnUploadMouseClicked(evt);
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
			if(parentUI instanceof ProfileUI){
				((ProfileUI)parentUI).setAvatar(file);
			}else{
				((RegisterUI)parentUI).setAvatar(file);
			}
			dispose();
			parentUI.setEnabled(true);
			parentUI.toFront();
		}
	}

	private JLabel getLblAvatar1() {
		if (lblAvatar1 == null) {
			lblAvatar1 = new JLabel();
			lblAvatar1.setBounds(31, 26, 100, 120);
			lblAvatar1.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar1.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/1.jpg")));
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
			lblAvatar2.setBounds(146, 26, 100, 120);
			lblAvatar2.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar2.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/2.jpg")));
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
			lblAvatar3.setBounds(261, 26, 100, 120);
			lblAvatar3.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar3.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("images/3.jpg")));
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
			lblAvatar4.setBounds(379, 26, 100, 120);
			lblAvatar4.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar4.setFocusable(false);
		}
		return lblAvatar4;
	}

	private JLabel getLblAvatar6() {
		if (lblAvatar6 == null) {
			lblAvatar6 = new JLabel();
			lblAvatar6.setBounds(146, 159, 100, 120);
			lblAvatar6.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar6.setFocusable(false);
		}
		return lblAvatar6;
	}

	private JLabel getLblAvatar7() {
		if (lblAvatar7 == null) {
			lblAvatar7 = new JLabel();
			lblAvatar7.setBounds(261, 159, 100, 120);
			lblAvatar7.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar7.setFocusable(false);
		}
		return lblAvatar7;
	}

	private JLabel getLblAvatar8() {
		if (lblAvatar8 == null) {
			lblAvatar8 = new JLabel();
			lblAvatar8.setBounds(379, 159, 100, 120);
			lblAvatar8.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar8.setFocusable(false);
		}
		return lblAvatar8;
	}

	private JLabel getLblAvatar5() {
		if (lblAvatar5 == null) {
			lblAvatar5 = new JLabel();
			lblAvatar5.setBounds(31, 159, 100, 120);
			lblAvatar5.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar5.setFocusable(false);
		}
		return lblAvatar5;
	}

	private void lblAvatar1MouseEntered(MouseEvent evt) {
		lblAvatar1.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.RAISED));
	}

	private void lblAvatar1MouseExited(MouseEvent evt) {
		lblAvatar1.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.LOWERED));
	}

	private void lblAvatar1MousePressed(MouseEvent evt) {
		lblAvatar1.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.LOWERED));
	}

	private void lblAvatar2MouseEntered(MouseEvent evt) {
		lblAvatar2.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.RAISED));
	}

	private void lblAvatar2MouseExited(MouseEvent evt) {
		lblAvatar2.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.LOWERED));
	}

	private void lblAvatar2MousePressed(MouseEvent evt) {
		lblAvatar2.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.LOWERED));
	}

	private void lblAvatar2MouseClicked(MouseEvent evt) {
		changeAvatar(2);
	}

	private void changeAvatar(int avatar) {
		File file = new File(getClass().getClassLoader()
				.getResource("images/" + avatar + ".jpg").getPath());
		if(parentUI instanceof ProfileUI){
			((ProfileUI)parentUI).setAvatar(file);
		}else{
			((RegisterUI)parentUI).setAvatar(file);
		}
		parentUI.setEnabled(true);
		dispose();
	}

	private void lblAvatar1MouseClicked(MouseEvent evt) {
		changeAvatar(1);
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton();
			btnCancel.setText("Cancel");
			btnCancel.setBounds(389, 332, 97, 23);
			btnCancel.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnCancelMouseClicked(evt);
				}
			});
		}
		return btnCancel;
	}

	private void btnCancelMouseClicked(MouseEvent evt) {
		dispose();
		parentUI.setEnabled(true);
		parentUI.toFront();
	}
	
	private void lblAvatar3MouseEntered(MouseEvent evt) {
		lblAvatar3.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.RAISED));
	}
	
	private void lblAvatar3MousePressed(MouseEvent evt) {
		lblAvatar3.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.LOWERED));
	}
	
	private void lblAvatar3MouseExited(MouseEvent evt) {
		lblAvatar3.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.LOWERED));
	}
	
	private void lblAvatar3MouseClicked(MouseEvent evt) {
		changeAvatar(3);
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
