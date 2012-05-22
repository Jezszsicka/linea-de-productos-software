package presentation;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import ProductLine.RoleType;
import ProductLine.User;
import domain.Controller;
import domain.LanguageManager;

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
public class RegisterUI extends javax.swing.JFrame {

	private JPanel pnlBackground;
	private JLabel lblLastname;
	private JLabel lblName;
	private JButton btnRegister;
	private JButton btnCancel;
	private JTextField txtName;
	private JLabel lblRepeatEmail;
	private JLabel lblRepeatPassword;
	private JButton btnAvatar;
	private JLabel lblAvatar;
	private JComboBox<String> selectedCountry;
	private JLabel lblCountry;
	private JTextField txtLastname;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblEmail;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JTextField txtEmail;
	private JPasswordField txtPasswordR;
	private JTextField txtEmailR;

	private byte[] avatar;
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

	public RegisterUI() {
		super();
		language = LanguageManager.language();
		initGUI();
	}

	private void initGUI() {
		this.setSize(518, 370);
		getContentPane().add(getPnlBackground(), "Center");
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				thisWindowClosing(evt);
			}
		});
	}

	private JPanel getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanel();
			pnlBackground.setBounds(0, 0, 502, 332);
			pnlBackground.setLayout(null);
			pnlBackground.add(getBtnRegister());
			pnlBackground.add(getBtnCancel());
			pnlBackground.add(getLblUsername());
			pnlBackground.add(getLblPassword());
			pnlBackground.add(getLblEmail());
			pnlBackground.add(getTxtUsername());
			pnlBackground.add(getTxtPassword());
			pnlBackground.add(getTxtEmail());
			pnlBackground.add(getTxtPasswordR());
			pnlBackground.add(getTxtEmailR());
			pnlBackground.add(getLblName());
			pnlBackground.add(getLblLastname());
			pnlBackground.add(getTxtName());
			pnlBackground.add(getTxtLastname());
			pnlBackground.add(getLblCountry());
			pnlBackground.add(getSelectedCountry());
			pnlBackground.add(getLblAvatar());
			pnlBackground.add(getBtnAvatar());
			pnlBackground.add(getLblRepeatPassword());
			pnlBackground.add(getLblRepeatEmail());
		}
		return pnlBackground;
	}

	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton(language.getString("RegisterUI.btnRegister"));
			btnRegister.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					do_btnRegister_mouseClicked(arg0);
				}
			});
			btnRegister.setBounds(82, 285, 89, 23);
			btnRegister.setFocusable(false);
		}
		return btnRegister;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton(language.getString("RegisterUI.btnCancel"));
			btnCancel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					do_btnCancel_mouseClicked(e);
				}
			});
			btnCancel.setBounds(320, 285, 89, 23);
			btnCancel.setFocusable(false);
		}
		return btnCancel;
	}

	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username");
			lblUsername.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblUsername.setBounds(165, 34, 106, 15);
			lblUsername.setText("Nickname");
			lblUsername.setSize(106, 20);
		}
		return lblUsername;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblPassword.setBounds(165, 148, 106, 15);
			lblPassword.setSize(106, 20);
		}
		return lblPassword;
	}

	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email");
			lblEmail.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblEmail.setBounds(165, 209, 106, 15);
			lblEmail.setSize(106, 20);
		}
		return lblEmail;
	}

	private JTextField getTxtUsername() {
		if (txtUsername == null) {
			txtUsername = new JTextField();
			txtUsername.setBounds(306, 34, 120, 20);
			txtUsername.setColumns(10);
		}
		return txtUsername;
	}

	private JPasswordField getTxtPassword() {
		if (txtPassword == null) {
			txtPassword = new JPasswordField();
			txtPassword.setBounds(306, 148, 120, 20);
			txtPassword.setColumns(10);
		}
		return txtPassword;
	}

	private JTextField getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new JTextField();
			txtEmail.setBounds(306, 209, 120, 20);
			txtEmail.setColumns(10);
		}
		return txtEmail;
	}

	private JPasswordField getTxtPasswordR() {
		if (txtPasswordR == null) {
			txtPasswordR = new JPasswordField();
			txtPasswordR.setBounds(306, 178, 120, 20);
			txtPasswordR.setColumns(10);
		}
		return txtPasswordR;
	}

	private JTextField getTxtEmailR() {
		if (txtEmailR == null) {
			txtEmailR = new JTextField();
			txtEmailR.setBounds(306, 240, 120, 20);
			txtEmailR.setColumns(10);
		}
		return txtEmailR;
	}

	protected void do_btnCancel_mouseClicked(MouseEvent e) {
		Controller.getInstance().closeRegisterUI();
	}

	protected void do_btnRegister_mouseClicked(MouseEvent arg0) {
		String username = txtUsername.getText();
		String name = txtName.getText();
		String lastName = txtLastname.getText();
		String password = new String(txtPassword.getPassword());
		String retypedPassword = new String(txtPasswordR.getPassword());
		String email = txtEmail.getText();
		String retypedEmail = txtEmailR.getText();
		int country = selectedCountry.getSelectedIndex();
		User user = new User (username, name, lastName, password, email,RoleType.Player,
				country, avatar,null,null);
		Controller.getInstance().registerUser(user, retypedPassword,
				retypedEmail);
	}

	private void thisWindowClosing(WindowEvent evt) {
		Controller.getInstance().closeRegisterUI();
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel();
			lblName.setText(language.getString("RegisterUI.lblName"));
			lblName.setBounds(165, 60, 106, 15);
			lblName.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblName.setSize(106, 20);
		}
		return lblName;
	}

	private JLabel getLblLastname() {
		if (lblLastname == null) {
			lblLastname = new JLabel();
			lblLastname.setText(language.getString("RegisterUI.lblLastname"));
			lblLastname.setBounds(165, 86, 106, 14);
			lblLastname.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblLastname.setSize(106, 20);
		}
		return lblLastname;
	}

	private JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
			txtName.setBounds(306, 60, 120, 20);
		}
		return txtName;
	}

	private JTextField getTxtLastname() {
		if (txtLastname == null) {
			txtLastname = new JTextField();
			txtLastname.setBounds(306, 86, 120, 20);
		}
		return txtLastname;
	}

	private JLabel getLblCountry() {
		if (lblCountry == null) {
			lblCountry = new JLabel();
			lblCountry.setText("Country");
			lblCountry.setBounds(165, 117, 106, 15);
			lblCountry.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblCountry.setSize(106, 20);
		}
		return lblCountry;
	}

	private JComboBox<String> getSelectedCountry() {
		if (selectedCountry == null) {
			ComboBoxModel<String> countryModel = new DefaultComboBoxModel<String>(
					new String[] { "Spain", "United Kingdom", "France",
							"United States", "Germany" });
			selectedCountry = new JComboBox<String>();
			selectedCountry.setModel(countryModel);
			selectedCountry.setBounds(306, 117, 120, 20);
			selectedCountry.setFocusable(false);
		}
		return selectedCountry;
	}

	private JLabel getLblAvatar() {
		if (lblAvatar == null) {
			lblAvatar = new JLabel();
			lblAvatar.setBounds(14, 34, 100, 120);
			lblAvatar.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
		}
		return lblAvatar;
	}

	private JButton getBtnAvatar() {
		if (btnAvatar == null) {
			btnAvatar = new JButton();
			btnAvatar.setText("Select avatar");
			btnAvatar.setBounds(14, 165, 97, 23);
			btnAvatar.setFocusable(false);
			btnAvatar.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnAvatarMouseClicked(evt);
				}
			});
		}
		return btnAvatar;
	}

	private JLabel getLblRepeatPassword() {
		if (lblRepeatPassword == null) {
			lblRepeatPassword = new JLabel();
			lblRepeatPassword.setText("Repeat password");
			lblRepeatPassword.setBounds(165, 178, 106, 14);
			lblRepeatPassword.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblRepeatPassword.setSize(106, 20);
		}
		return lblRepeatPassword;
	}

	private JLabel getLblRepeatEmail() {
		if (lblRepeatEmail == null) {
			lblRepeatEmail = new JLabel();
			lblRepeatEmail.setText("Repeat email");
			lblRepeatEmail.setBounds(165, 240, 106, 14);
			lblRepeatEmail.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblRepeatEmail.setSize(106, 20);
		}
		return lblRepeatEmail;
	}

	private void btnAvatarMouseClicked(MouseEvent evt) {
		new ChooseAvatarUI(this);
	}

	public void setAvatar(File file) {
		try {
			this.avatar = Files.readAllBytes(file.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(avatar);
		Image image = icon.getImage().getScaledInstance(100, 120,
				Image.SCALE_SMOOTH);
		ImageIcon imageIconResize = new ImageIcon(image);
		int resizeWidth = imageIconResize.getIconWidth();
		int resizeHeight = imageIconResize.getIconHeight();
		BufferedImage bi = new BufferedImage(resizeWidth, resizeHeight,
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = bi.createGraphics();
		g2d.drawImage(image, 0, 0, null);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.createImageOutputStream(baos);
			ImageIO.write(bi, "JPG", baos);
			baos.flush();
			avatar = baos.toByteArray();
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lblAvatar.setIcon(new ImageIcon(avatar));
	}
}
