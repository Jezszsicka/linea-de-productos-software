package presentation;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class AvatarList extends javax.swing.JFrame {
	

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private ProfileUI profileUI;
	private JPanel pnlBackground;
	private JButton btnUpload;
	private JButton lblAvatar4;
	private JButton lblAvatar5;
	private JButton lblAvatar8;
	private JButton lblAvatar7;
	private JButton lblAvatar6;
	private JButton lblAvatar3;
	private JButton lblAvatar2;
	private JButton lblAvatar1;

	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public AvatarList(ProfileUI profileUI) {
		super();
		initGUI();
		this.profileUI = profileUI;
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().add(getPnlBackground(), BorderLayout.CENTER);
			pack();
			this.setSize(526, 355);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private JPanel getPnlBackground() {
		if(pnlBackground == null) {
			pnlBackground = new JPanel();
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
		}
		return pnlBackground;
	}
	
	private JButton getBtnUpload() {
		if(btnUpload == null) {
			btnUpload = new JButton();
			btnUpload.setText("Upload image");
			btnUpload.setBounds(396, 275, 97, 23);
			btnUpload.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnUploadMouseClicked(evt);
				}
			});
		}
		return btnUpload;
	}
	
	private void btnUploadMouseClicked(MouseEvent evt) {
		JFileChooser elegirFichero= new JFileChooser();
		int seleccion = elegirFichero.showOpenDialog(this);
		if (seleccion == JFileChooser.APPROVE_OPTION){
			   File fichero = elegirFichero.getSelectedFile();
			   try {
				BufferedReader buffer = new BufferedReader(new FileReader(fichero.getPath()));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private JButton getLblAvatar1() {
		if(lblAvatar1 == null) {
			lblAvatar1 = new JButton();
			lblAvatar1.setBounds(41, 25, 84, 98);
			lblAvatar1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("1.jpg")));
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
	
	private JButton getLblAvatar2() {
		if(lblAvatar2 == null) {
			lblAvatar2 = new JButton();
			lblAvatar2.setBounds(156, 25, 84, 98);
			lblAvatar2.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("2.jpg")));
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
	
	private JButton getLblAvatar3() {
		if(lblAvatar3 == null) {
			lblAvatar3 = new JButton();
			lblAvatar3.setBounds(271, 25, 84, 98);
			lblAvatar3.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("3.jpg")));
			lblAvatar3.setFocusable(false);
		}
		return lblAvatar3;
	}
	
	private JButton getLblAvatar4() {
		if(lblAvatar4 == null) {
			lblAvatar4 = new JButton();
			lblAvatar4.setBounds(386, 25, 84, 98);
			lblAvatar4.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar4.setFocusable(false);
		}
		return lblAvatar4;
	}
	
	private JButton getLblAvatar6() {
		if(lblAvatar6 == null) {
			lblAvatar6 = new JButton();
			lblAvatar6.setBounds(156, 156, 84, 98);
			lblAvatar6.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar6.setFocusable(false);
		}
		return lblAvatar6;
	}
	
	private JButton getLblAvatar7() {
		if(lblAvatar7 == null) {
			lblAvatar7 = new JButton();
			lblAvatar7.setBounds(271, 154, 84, 98);
			lblAvatar7.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar7.setFocusable(false);
		}
		return lblAvatar7;
	}
	
	private JButton getLblAvatar8() {
		if(lblAvatar8 == null) {
			lblAvatar8 = new JButton();
			lblAvatar8.setBounds(386, 152, 84, 98);
			lblAvatar8.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar8.setFocusable(false);
		}
		return lblAvatar8;
	}
	
	private JButton getLblAvatar5() {
		if(lblAvatar5 == null) {
			lblAvatar5 = new JButton();
			lblAvatar5.setBounds(41, 158, 84, 98);
			lblAvatar5.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			lblAvatar5.setFocusable(false);
		}
		return lblAvatar5;
	}
	
	private void lblAvatar1MouseEntered(MouseEvent evt) {
		lblAvatar1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	}
	
	private void lblAvatar1MouseExited(MouseEvent evt) {
		lblAvatar1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
	}
	
	private void lblAvatar1MousePressed(MouseEvent evt) {
		lblAvatar1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
	}
	
	private void lblAvatar2MouseEntered(MouseEvent evt) {
		lblAvatar2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	}
	
	private void lblAvatar2MouseExited(MouseEvent evt) {
		lblAvatar2.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
	}
	
	private void lblAvatar2MousePressed(MouseEvent evt) {
		lblAvatar2.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
	}
	
	private void lblAvatar2MouseClicked(MouseEvent evt) {
		changeAvatar(2);
	}
	
	private void changeAvatar(int avatar){
		profileUI.setAvatar(avatar);
		dispose();
	}
	
	private void lblAvatar1MouseClicked(MouseEvent evt) {
		changeAvatar(1);
	}

}
