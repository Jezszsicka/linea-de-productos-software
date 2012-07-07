package presentation;
import javax.swing.JPanel;

import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
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
public class Z extends javax.swing.JFrame {
	private ImagePanel pnlBackground;

	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public Z() {
		super();
		initGUI();
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			getContentPane().add(getPnlBackground());
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private ImagePanel getPnlBackground() {
		if(pnlBackground == null) {
			pnlBackground = new ImagePanel(new ImageIcon(getClass().getClassLoader()
					.getResource("images/fondo.png")).getImage());
			pnlBackground.setBounds(0, 0, 384, 262);
		}
		return pnlBackground;
	}

}
