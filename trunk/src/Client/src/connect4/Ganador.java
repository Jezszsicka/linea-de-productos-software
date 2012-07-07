package connect4;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
public class Ganador extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JPanel jPanel1;
	private JButton btnAceptar;
	private JLabel lblMsj;
	private Interfaz juego;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Ganador inst = new Ganador();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Ganador() {
		super();
		initGUI();
	}
	
	public Ganador(Interfaz juego,String ganador) {
		super();
		this.juego=juego;
		initGUI();
		lblMsj.setText("�Enorabuena! "+ganador);
		
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setLayout(null);
				jPanel1.setPreferredSize(new java.awt.Dimension(292, 120));
				{
					lblMsj = new JLabel();
					jPanel1.add(lblMsj);
					lblMsj.setBounds(24, 23, 245, 32);
					lblMsj.setText("Enorabuena! El jugador azul ha ganado");
					lblMsj.setHorizontalAlignment(SwingConstants.CENTER);
				}
				{
					btnAceptar = new JButton();
					jPanel1.add(btnAceptar);
					btnAceptar.setText("Aceptar");
					btnAceptar.setBounds(110, 72, 70, 22);
					btnAceptar.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							btnAceptarMouseClicked(evt);
						}
					});
				}
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void btnAceptarMouseClicked(MouseEvent evt) {
		juego.enable();
		dispose();
	}

}
