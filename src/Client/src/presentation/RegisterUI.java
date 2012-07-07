package presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import logic.Controller;
import logic.LanguageManager;
import model.User;
import ProductLine.RoleType;

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
	private JComboBox selectedCountry;
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
		getContentPane().add(getPnlBackground(), BorderLayout.CENTER);
		setLocationRelativeTo(null);
		BorderLayout thisLayout = new BorderLayout();
		getContentPane().setLayout(thisLayout);
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
			btnRegister = new JButton("Registrar");
			btnRegister.setText(language.getString("btnRegister"));
			btnRegister.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					do_btnRegister_mouseClicked(arg0);
				}
			});
			btnRegister.setBounds(82, 292, 89, 23);
			btnRegister.setFocusable(false);
		}
		return btnRegister;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancelar");
			btnCancel.setText(language.getString("btnCancel"));
			btnCancel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					do_btnCancel_mouseClicked(e);
				}
			});
			btnCancel.setBounds(320, 292, 89, 23);
			btnCancel.setFocusable(false);
		}
		return btnCancel;
	}

	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Usuario");
			lblUsername.setText(language.getString("lblUsername"));
			lblUsername.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblUsername.setBounds(165, 34, 129, 20);
		}
		return lblUsername;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Contraseña");
			lblPassword.setText(language.getString("lblPassword"));
			lblPassword.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblPassword.setBounds(165, 154, 129, 20);
		}
		return lblPassword;
	}

	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("E-mail");
			lblEmail.setText(language.getString("lblEmail"));
			lblEmail.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblEmail.setBounds(165, 215, 129, 20);
		}
		return lblEmail;
	}

	private JTextField getTxtUsername() {
		if (txtUsername == null) {
			txtUsername = new JTextField();
			txtUsername.setBounds(337, 34, 120, 20);
			txtUsername.setColumns(10);
		}
		return txtUsername;
	}

	private JPasswordField getTxtPassword() {
		if (txtPassword == null) {
			txtPassword = new JPasswordField();
			txtPassword.setBounds(337, 154, 120, 20);
			txtPassword.setColumns(10);
		}
		return txtPassword;
	}

	private JTextField getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new JTextField();
			txtEmail.setBounds(337, 215, 120, 20);
			txtEmail.setColumns(10);
		}
		return txtEmail;
	}

	private JPasswordField getTxtPasswordR() {
		if (txtPasswordR == null) {
			txtPasswordR = new JPasswordField();
			txtPasswordR.setBounds(337, 184, 120, 20);
			txtPasswordR.setColumns(10);
		}
		return txtPasswordR;
	}

	private JTextField getTxtEmailR() {
		if (txtEmailR == null) {
			txtEmailR = new JTextField();
			txtEmailR.setBounds(337, 246, 120, 20);
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
		User user = new User(username, name, lastName, password, email,
				RoleType.Player, country, avatar);
		Controller.getInstance().registerUser(user, retypedPassword,
				retypedEmail);
	}

	private void thisWindowClosing(WindowEvent evt) {
		Controller.getInstance().closeRegisterUI();
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Nombre");
			lblName.setText(language.getString("lblName"));
			lblName.setBounds(165, 60, 129, 20);
			lblName.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblName;
	}

	private JLabel getLblLastname() {
		if (lblLastname == null) {
			lblLastname = new JLabel("Apellidos");
			lblLastname.setText(language.getString("lblLastname"));
			lblLastname.setBounds(165, 86, 129, 20);
			lblLastname.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblLastname;
	}

	private JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
			txtName.setBounds(337, 60, 120, 20);
		}
		return txtName;
	}

	private JTextField getTxtLastname() {
		if (txtLastname == null) {
			txtLastname = new JTextField();
			txtLastname.setBounds(337, 86, 120, 20);
		}
		return txtLastname;
	}

	private JLabel getLblCountry() {
		if (lblCountry == null) {
			lblCountry = new JLabel("Pais");
			lblCountry.setText(language.getString("lblCountry"));
			lblCountry.setBounds(165, 119, 129, 20);
			lblCountry.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblCountry;
	}

	private JComboBox getSelectedCountry() {
		if (selectedCountry == null) {
			ImageIcon[] icons = {
					new ImageIcon(getClass().getClassLoader().getResource(
							"images/Flags/us_small.png")),
					new ImageIcon(getClass().getClassLoader().getResource(
							"images/Flags/es_small.png")),
					new ImageIcon(getClass().getClassLoader().getResource(
							"images/Flags/fr_small.png")),
					new ImageIcon(getClass().getClassLoader().getResource(
							"images/Flags/de_small.png")) };
			String[] description = new String[] { language.getString("UnitedStates"), language.getString("Spain"),language.getString("France"),language.getString("Germany") };
			Integer[] intArray = new Integer[description.length];
			for (int i = 0; i < icons.length; i++) {
				intArray[i] = new Integer(i);
				if (icons[i] != null) {
					icons[i].setDescription(description[i]);
				}
			}
			ComboBoxRenderer renderer = new ComboBoxRenderer(icons, description);
			renderer.setPreferredSize(new Dimension(120, 24));
			selectedCountry = new JComboBox(intArray);
			selectedCountry.setRenderer(renderer);
			selectedCountry.setBounds(337, 117, 120, 20);
			selectedCountry.setFocusable(false);
			selectedCountry.setSize(120, 24);

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
			btnAvatar = new JButton("Seleccionar avatar");
			btnAvatar.setText(language.getString("btnSelectAvatar"));
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
			lblRepeatPassword = new JLabel("Confirmar contraseña");
			lblRepeatPassword.setText(language.getString("lblConfirmPassword"));
			lblRepeatPassword.setBounds(165, 184, 129, 20);
			lblRepeatPassword.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblRepeatPassword;
	}

	private JLabel getLblRepeatEmail() {
		if (lblRepeatEmail == null) {
			lblRepeatEmail = new JLabel("Confirmar e-mail");
			lblRepeatEmail.setText(language.getString("lblConfirmEmail"));
			lblRepeatEmail.setBounds(165, 246, 129, 20);
			lblRepeatEmail.setFont(new java.awt.Font("Tahoma", 1, 11));
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
			e.printStackTrace();
		}
		lblAvatar.setIcon(new ImageIcon(avatar));
	}
}
