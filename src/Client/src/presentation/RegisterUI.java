package presentation;

import java.awt.BorderLayout;
import java.awt.Cursor;
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
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class RegisterUI extends javax.swing.JFrame {

	private JPanelRound pnlBackground;
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
		setTitle("Registrar usuario");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				RegisterUI.class.getResource("/images/icon.png")));
		this.setSize(518, 396);
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

	private JPanelRound getPnlBackground() {
		if (pnlBackground == null) {
			pnlBackground = new JPanelRound();
			pnlBackground.setArcw(0);
			pnlBackground.setArch(0);
			pnlBackground.setBackground(Color.BLACK);
			pnlBackground.setForeground(Color.WHITE);
			pnlBackground.setBounds(0, 0, 502, 360);
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
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnRegisterActionPerformed(arg0);
				}
			});
			btnRegister.setText(language.getString("btnRegister"));
			btnRegister.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					do_btnRegister_mouseClicked(arg0);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					btnRegisterMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnRegisterMouseExited(e);
				}
			});
			btnRegister.setBounds(80, 303, 89, 23);
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

				@Override
				public void mouseEntered(MouseEvent e) {
					btnCancelMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnCancelMouseExited(e);
				}
			});
			btnCancel.setBounds(324, 303, 89, 23);
			btnCancel.setFocusable(false);
		}
		return btnCancel;
	}

	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Usuario");
			lblUsername.setForeground(Color.WHITE);
			lblUsername.setText(language.getString("lblUsername"));
			lblUsername.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblUsername.setBounds(165, 35, 129, 25);
		}
		return lblUsername;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Contraseña");
			lblPassword.setForeground(Color.WHITE);
			lblPassword.setText(language.getString("lblPassword"));
			lblPassword.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblPassword.setBounds(165, 155, 129, 25);
		}
		return lblPassword;
	}

	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("E-mail");
			lblEmail.setForeground(Color.WHITE);
			lblEmail.setText(language.getString("lblEmail"));
			lblEmail.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblEmail.setBounds(165, 215, 129, 25);
		}
		return lblEmail;
	}

	private JTextField getTxtUsername() {
		if (txtUsername == null) {
			txtUsername = new JTextField();
			txtUsername.setCaretColor(Color.WHITE);
			txtUsername.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			txtUsername.setForeground(Color.WHITE);
			txtUsername.setBackground(Color.BLACK);
			txtUsername.setBounds(337, 35, 139, 25);
			txtUsername.setColumns(10);
		}
		return txtUsername;
	}

	private JPasswordField getTxtPassword() {
		if (txtPassword == null) {
			txtPassword = new JPasswordField();
			txtPassword.setCaretColor(Color.WHITE);
			txtPassword.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			txtPassword.setForeground(Color.WHITE);
			txtPassword.setBackground(Color.BLACK);
			txtPassword.setBounds(337, 155, 139, 25);
			txtPassword.setColumns(10);
		}
		return txtPassword;
	}

	private JTextField getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new JTextField();
			txtEmail.setCaretColor(Color.WHITE);
			txtEmail.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			txtEmail.setForeground(Color.WHITE);
			txtEmail.setBackground(Color.BLACK);
			txtEmail.setBounds(337, 215, 139, 25);
			txtEmail.setColumns(10);
		}
		return txtEmail;
	}

	private JPasswordField getTxtPasswordR() {
		if (txtPasswordR == null) {
			txtPasswordR = new JPasswordField();
			txtPasswordR.setCaretColor(Color.WHITE);
			txtPasswordR.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			txtPasswordR.setForeground(Color.WHITE);
			txtPasswordR.setBackground(Color.BLACK);
			txtPasswordR.setBounds(337, 185, 139, 25);
			txtPasswordR.setColumns(10);
		}
		return txtPasswordR;
	}

	private JTextField getTxtEmailR() {
		if (txtEmailR == null) {
			txtEmailR = new JTextField();
			txtEmailR.setCaretColor(Color.WHITE);
			txtEmailR.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			txtEmailR.setForeground(Color.WHITE);
			txtEmailR.setBackground(Color.BLACK);
			txtEmailR.setBounds(337, 245, 139, 25);
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
			lblName.setForeground(Color.WHITE);
			lblName.setText(language.getString("lblName"));
			lblName.setBounds(165, 65, 129, 25);
			lblName.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblName;
	}

	private JLabel getLblLastname() {
		if (lblLastname == null) {
			lblLastname = new JLabel("Apellidos");
			lblLastname.setForeground(Color.WHITE);
			lblLastname.setText(language.getString("lblLastname"));
			lblLastname.setBounds(165, 95, 129, 25);
			lblLastname.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblLastname;
	}

	private JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
			txtName.setCaretColor(Color.WHITE);
			txtName.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			txtName.setForeground(Color.WHITE);
			txtName.setBackground(Color.BLACK);
			txtName.setBounds(337, 65, 139, 25);
		}
		return txtName;
	}

	private JTextField getTxtLastname() {
		if (txtLastname == null) {
			txtLastname = new JTextField();
			txtLastname.setCaretColor(Color.WHITE);
			txtLastname.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			txtLastname.setForeground(Color.WHITE);
			txtLastname.setBackground(Color.BLACK);
			txtLastname.setBounds(337, 95, 139, 25);
		}
		return txtLastname;
	}

	private JLabel getLblCountry() {
		if (lblCountry == null) {
			lblCountry = new JLabel("Pais");
			lblCountry.setForeground(Color.WHITE);
			lblCountry.setText(language.getString("lblCountry"));
			lblCountry.setBounds(165, 125, 129, 25);
			lblCountry.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblCountry;
	}

	private JComboBox getSelectedCountry() {
		if (selectedCountry == null) {
			ImageIcon[] icons = {
					new ImageIcon(
							RegisterUI.class
									.getResource("/images/Flags/us_small.png")),
					new ImageIcon(
							RegisterUI.class
									.getResource("/images/Flags/es_small.png")),
					new ImageIcon(
							RegisterUI.class
									.getResource("/images/Flags/fr_small.png")),
					new ImageIcon(
							RegisterUI.class
									.getResource("/images/Flags/de_small.png")) };
			String[] description = new String[] {
					language.getString("UnitedStates"),
					language.getString("Spain"), language.getString("France"),
					language.getString("Germany") };
			Integer[] intArray = new Integer[description.length];
			for (int i = 0; i < icons.length; i++) {
				intArray[i] = new Integer(i);
				if (icons[i] != null) {
					icons[i].setDescription(description[i]);
				}
			}
			ComboBoxRenderer renderer = new ComboBoxRenderer(icons, description);
			renderer.setPreferredSize(new Dimension(139, 24));
			selectedCountry = new JComboBox(intArray);
			selectedCountry.setRenderer(renderer);
			selectedCountry.setBounds(337, 129, 139, 20);
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
			lblAvatar.setIcon(new ImageIcon(RegisterUI.class
					.getResource("/images/no_avatar_icon.png")));
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

				@Override
				public void mouseEntered(MouseEvent e) {
					btnAvatarMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnAvatarMouseExited(e);
				}
			});
		}
		return btnAvatar;
	}

	private JLabel getLblRepeatPassword() {
		if (lblRepeatPassword == null) {
			lblRepeatPassword = new JLabel("Confirmar contraseña");
			lblRepeatPassword.setForeground(Color.WHITE);
			lblRepeatPassword.setText(language.getString("lblConfirmPassword"));
			lblRepeatPassword.setBounds(165, 185, 129, 25);
			lblRepeatPassword.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblRepeatPassword;
	}

	private JLabel getLblRepeatEmail() {
		if (lblRepeatEmail == null) {
			lblRepeatEmail = new JLabel("Confirmar e-mail");
			lblRepeatEmail.setForeground(Color.WHITE);
			lblRepeatEmail.setText(language.getString("lblConfirmEmail"));
			lblRepeatEmail.setBounds(165, 245, 129, 25);
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

	private void setHandCursor() {
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	private void setDefaultCursor() {
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	protected void btnAvatarMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnAvatarMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void btnRegisterMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnRegisterMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void btnCancelMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnCancelMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void btnRegisterActionPerformed(ActionEvent arg0) {
	}
}
