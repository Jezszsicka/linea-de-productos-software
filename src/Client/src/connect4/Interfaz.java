package connect4;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


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
public class Interfaz extends javax.swing.JFrame {
	private JPanel pnlFondo;
	private JPanel pnlBoard;
	private JLabel lbl75;
	private JLabel lblConsejo;
	private JLabel lblEstado;
	private JButton btnSalir;
	private JPanel pnlMenu;
	private JButton btn1;
	private JLabel lbl11;
	private JLabel lbl12;
	private JLabel lbl13;
	private JLabel lbl14;
	private JLabel lbl15;
	private JLabel lbl16;
	private JLabel lbl26;
	private JLabel lbl25;
	private JLabel lbl24;
	private JLabel lbl23;
	private JLabel lbl22;
	private JLabel lbl21;
	private JButton btn2;
	private JButton btn3;
	private JLabel lbl31;
	private JLabel lbl32;
	private JLabel lbl33;
	private JLabel lbl34;
	private JLabel lbl35;
	private JLabel lbl36;
	private JLabel lbl46;
	private JLabel lbl45;
	private JLabel lbl44;
	private JLabel lbl43;
	private JLabel lbl42;
	private JLabel lbl41;
	private JButton btn4;
	private JButton btn5;
	private JLabel lbl51;
	private JLabel lbl52;
	private JLabel lbl53;
	private JLabel lbl54;
	private JLabel lbl55;
	private JLabel lbl56;
	private JLabel lbl66;
	private JLabel lbl65;
	private JLabel lbl64;
	private JLabel lbl63;
	private JLabel lbl62;
	private JLabel lbl61;
	private JButton btn6;
	private JButton btn7;
	private JLabel lbl71;
	private JLabel lbl72;
	private JLabel lbl73;
	private JLabel lbl74;
	private JLabel lbl76;
	private JLabel [][] InterfazTablero=new JLabel[6][7];
	private int jugador=1;
	private Tablero tablero=new Tablero();
	private Minimax juego=new Minimax(3);
	private boolean maquina=false;
	private boolean consejo=false;
	private boolean nuevo=false;
	private boolean empezar=true;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Interfaz inst = new Interfaz();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Interfaz() {
		super();
		initGUI();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			{
				pnlFondo = new JPanel();
				getContentPane().add(pnlFondo, BorderLayout.CENTER);
				pnlFondo.setLayout(null);
				{
					pnlBoard = new JPanel();
					pnlFondo.add(pnlBoard);
					pnlBoard.setLayout(null);
					pnlBoard.setBounds(14, 13, 611, 417);
					pnlBoard.setBackground(new java.awt.Color(0,0,0));
					{
						lbl76 = new JLabel();
						InterfazTablero[5][6]=lbl76;
						pnlBoard.add(lbl76);
						lbl76.setText("0");
						lbl76.setBackground(new java.awt.Color(0,0,0));
						lbl76.setBounds(519, 338, 85, 61);
						lbl76.setHorizontalAlignment(SwingConstants.CENTER);
						lbl76.setOpaque(true);
						lbl76.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl75 = new JLabel();
						InterfazTablero[4][6]=lbl75;
						pnlBoard.add(lbl75);
						lbl75.setText("0");
						lbl75.setBackground(new java.awt.Color(0,0,0));
						lbl75.setOpaque(true);
						lbl75.setBounds(519, 278, 85, 60);
						lbl75.setHorizontalAlignment(SwingConstants.CENTER);
						lbl75.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl74 = new JLabel();
						InterfazTablero[3][6]=lbl74;
						pnlBoard.add(lbl74);
						lbl74.setText("0");
						lbl74.setBackground(new java.awt.Color(0,0,0));
						lbl74.setOpaque(true);
						lbl74.setBounds(520, 220, 84, 60);
						lbl74.setHorizontalAlignment(SwingConstants.CENTER);
						lbl74.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl73 = new JLabel();
						InterfazTablero[2][6]=lbl73;
						pnlBoard.add(lbl73);
						lbl73.setText("0");
						lbl73.setBackground(new java.awt.Color(0,0,0));
						lbl73.setOpaque(true);
						lbl73.setBounds(520, 160, 84, 60);
						lbl73.setHorizontalAlignment(SwingConstants.CENTER);
						lbl73.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl72 = new JLabel();
						InterfazTablero[1][6]=lbl72;
						pnlBoard.add(lbl72);
						lbl72.setText("0");
						lbl72.setBackground(new java.awt.Color(0,0,0));
						lbl72.setOpaque(true);
						lbl72.setBounds(520, 100, 84, 60);
						lbl72.setHorizontalAlignment(SwingConstants.CENTER);
						lbl72.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl71 = new JLabel();
						InterfazTablero[0][6]=lbl71;
						pnlBoard.add(lbl71);
						lbl71.setBackground(new java.awt.Color(0,0,0));
						lbl71.setOpaque(true);
						lbl71.setBounds(520, 40, 84, 60);
						lbl71.setHorizontalAlignment(SwingConstants.CENTER);
						lbl71.setText("0");
						lbl71.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						btn7 = new JButton();
						pnlBoard.add(btn7);
						btn7.setText("Columna 7");
						btn7.setBounds(514, 17, 87, 23);
						btn7.setBackground(new java.awt.Color(0,0,0));
						btn7.setFocusable(false);
						btn7.setVisible(false);
						btn7.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								btn7MouseClicked(evt);
							}
						});
					}
					{
						btn6 = new JButton();
						pnlBoard.add(btn6);
						btn6.setText("Columna 6");
						btn6.setBounds(431, 17, 83, 23);
						btn6.setBackground(new java.awt.Color(0,0,0));
						btn6.setFocusable(false);
						btn6.setVisible(false);
						btn6.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								btn6MouseClicked(evt);
							}
						});
					}
					{
						lbl61 = new JLabel();
						InterfazTablero[0][5]=lbl61;
						pnlBoard.add(lbl61);
						lbl61.setText("0");
						lbl61.setBackground(new java.awt.Color(0,0,0));
						lbl61.setOpaque(true);
						lbl61.setBounds(436, 40, 84, 60);
						lbl61.setHorizontalAlignment(SwingConstants.CENTER);
						lbl61.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl62 = new JLabel();
						InterfazTablero[1][5]=lbl62;
						pnlBoard.add(lbl62);
						lbl62.setText("0");
						lbl62.setBackground(new java.awt.Color(0,0,0));
						lbl62.setOpaque(true);
						lbl62.setBounds(436, 100, 84, 60);
						lbl62.setHorizontalAlignment(SwingConstants.CENTER);
						lbl62.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl63 = new JLabel();
						InterfazTablero[2][5]=lbl63;
						pnlBoard.add(lbl63);
						lbl63.setText("0");
						lbl63.setBackground(new java.awt.Color(0,0,0));
						lbl63.setOpaque(true);
						lbl63.setBounds(436, 160, 84, 60);
						lbl63.setHorizontalAlignment(SwingConstants.CENTER);
						lbl63.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl64 = new JLabel();
						InterfazTablero[3][5]=lbl64;
						pnlBoard.add(lbl64);
						lbl64.setText("0");
						lbl64.setBackground(new java.awt.Color(0,0,0));
						lbl64.setOpaque(true);
						lbl64.setBounds(436, 219, 84, 60);
						lbl64.setHorizontalAlignment(SwingConstants.CENTER);
						lbl64.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl65 = new JLabel();
						InterfazTablero[4][5]=lbl65;
						pnlBoard.add(lbl65);
						lbl65.setText("0");
						lbl65.setBackground(new java.awt.Color(0,0,0));
						lbl65.setOpaque(true);
						lbl65.setBounds(435, 279, 84, 60);
						lbl65.setHorizontalAlignment(SwingConstants.CENTER);
						lbl65.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl66 = new JLabel();
						InterfazTablero[5][5]=lbl66;
						pnlBoard.add(lbl66);
						lbl66.setText("0");
						lbl66.setBackground(new java.awt.Color(0,0,0));
						lbl66.setOpaque(true);
						lbl66.setBounds(436, 339, 84, 60);
						lbl66.setHorizontalAlignment(SwingConstants.CENTER);
						lbl66.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl56 = new JLabel();
						InterfazTablero[5][4]=lbl56;
						pnlBoard.add(lbl56);
						lbl56.setText("0");
						lbl56.setBackground(new java.awt.Color(0,0,0));
						lbl56.setOpaque(true);
						lbl56.setBounds(352, 339, 84, 60);
						lbl56.setHorizontalAlignment(SwingConstants.CENTER);
						lbl56.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl55 = new JLabel();
						InterfazTablero[4][4]=lbl55;
						pnlBoard.add(lbl55);
						lbl55.setText("0");
						lbl55.setBackground(new java.awt.Color(0,0,0));
						lbl55.setOpaque(true);
						lbl55.setBounds(351, 281, 84, 60);
						lbl55.setHorizontalAlignment(SwingConstants.CENTER);
						lbl55.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl54 = new JLabel();
						InterfazTablero[3][4]=lbl54;
						pnlBoard.add(lbl54);
						lbl54.setText("0");
						lbl54.setBackground(new java.awt.Color(0,0,0));
						lbl54.setOpaque(true);
						lbl54.setBounds(352, 221, 84, 60);
						lbl54.setHorizontalAlignment(SwingConstants.CENTER);
						lbl54.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl53 = new JLabel();
						InterfazTablero[2][4]=lbl53;
						pnlBoard.add(lbl53);
						lbl53.setText("0");
						lbl53.setBackground(new java.awt.Color(0,0,0));
						lbl53.setOpaque(true);
						lbl53.setBounds(352, 161, 84, 60);
						lbl53.setHorizontalAlignment(SwingConstants.CENTER);
						lbl53.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl52 = new JLabel();
						InterfazTablero[1][4]=lbl52;
						pnlBoard.add(lbl52);
						lbl52.setText("0");
						lbl52.setBackground(new java.awt.Color(0,0,0));
						lbl52.setOpaque(true);
						lbl52.setBounds(352, 101, 84, 60);
						lbl52.setHorizontalAlignment(SwingConstants.CENTER);
						lbl52.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl51 = new JLabel();
						InterfazTablero[0][4]=lbl51;
						pnlBoard.add(lbl51);
						lbl51.setText("0");
						lbl51.setBackground(new java.awt.Color(0,0,0));
						lbl51.setOpaque(true);
						lbl51.setBounds(352, 41, 84, 60);
						lbl51.setHorizontalAlignment(SwingConstants.CENTER);
						lbl51.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						btn5 = new JButton();
						pnlBoard.add(btn5);
						btn5.setText("Columna 5");
						btn5.setBounds(348, 17, 83, 23);
						btn5.setBackground(new java.awt.Color(0,0,0));
						btn5.setFocusable(false);
						btn5.setVisible(false);
						btn5.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								btn5MouseClicked(evt);
							}
						});
					}
					{
						btn4 = new JButton();
						pnlBoard.add(btn4);
						btn4.setText("Columna 4");
						btn4.setBounds(265, 17, 83, 23);
						btn4.setBackground(new java.awt.Color(0,0,0));
						btn4.setFocusable(false);
						btn4.setVisible(false);
						btn4.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								btn4MouseClicked(evt);
							}
						});
					}
					{
						lbl41 = new JLabel();
						InterfazTablero[0][3]=lbl41;
						pnlBoard.add(lbl41);
						lbl41.setText("0");
						lbl41.setBackground(new java.awt.Color(0,0,0));
						lbl41.setOpaque(true);
						lbl41.setBounds(268, 41, 84, 60);
						lbl41.setHorizontalAlignment(SwingConstants.CENTER);
						lbl41.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl42 = new JLabel();
						InterfazTablero[1][3]=lbl42;
						pnlBoard.add(lbl42);
						lbl42.setText("0");
						lbl42.setBackground(new java.awt.Color(0,0,0));
						lbl42.setOpaque(true);
						lbl42.setBounds(268, 101, 84, 60);
						lbl42.setHorizontalAlignment(SwingConstants.CENTER);
						lbl42.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl43 = new JLabel();
						InterfazTablero[2][3]=lbl43;
						pnlBoard.add(lbl43);
						lbl43.setText("0");
						lbl43.setBackground(new java.awt.Color(0,0,0));
						lbl43.setOpaque(true);
						lbl43.setBounds(268, 161, 84, 60);
						lbl43.setHorizontalAlignment(SwingConstants.CENTER);
						lbl43.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl44 = new JLabel();
						InterfazTablero[3][3]=lbl44;
						pnlBoard.add(lbl44);
						lbl44.setText("0");
						lbl44.setBackground(new java.awt.Color(0,0,0));
						lbl44.setOpaque(true);
						lbl44.setBounds(268, 221, 84, 60);
						lbl44.setHorizontalAlignment(SwingConstants.CENTER);
						lbl44.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl45 = new JLabel();
						InterfazTablero[4][3]=lbl45;
						pnlBoard.add(lbl45);
						lbl45.setText("0");
						lbl45.setBackground(new java.awt.Color(0,0,0));
						lbl45.setOpaque(true);
						lbl45.setBounds(267, 281, 84, 60);
						lbl45.setHorizontalAlignment(SwingConstants.CENTER);
						lbl45.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl46 = new JLabel();
						InterfazTablero[5][3]=lbl46;
						pnlBoard.add(lbl46);
						lbl46.setText("0");
						lbl46.setBackground(new java.awt.Color(0,0,0));
						lbl46.setOpaque(true);
						lbl46.setBounds(268, 339, 84, 60);
						lbl46.setHorizontalAlignment(SwingConstants.CENTER);
						lbl46.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl36 = new JLabel();
						InterfazTablero[5][2]=lbl36;
						pnlBoard.add(lbl36);
						lbl36.setText("0");
						lbl36.setBackground(new java.awt.Color(0,0,0));
						lbl36.setOpaque(true);
						lbl36.setBounds(184, 339, 84, 60);
						lbl36.setHorizontalAlignment(SwingConstants.CENTER);
						lbl36.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl35 = new JLabel();
						InterfazTablero[4][2]=lbl35;
						pnlBoard.add(lbl35);
						lbl35.setText("0");
						lbl35.setBackground(new java.awt.Color(0,0,0));
						lbl35.setOpaque(true);
						lbl35.setBounds(184, 279, 84, 60);
						lbl35.setHorizontalAlignment(SwingConstants.CENTER);
						lbl35.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl34 = new JLabel();
						InterfazTablero[3][2]=lbl34;
						pnlBoard.add(lbl34);
						lbl34.setText("0");
						lbl34.setBackground(new java.awt.Color(0,0,0));
						lbl34.setOpaque(true);
						lbl34.setBounds(184, 219, 84, 60);
						lbl34.setHorizontalAlignment(SwingConstants.CENTER);
						lbl34.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl33 = new JLabel();
						InterfazTablero[2][2]=lbl33;
						pnlBoard.add(lbl33);
						lbl33.setText("0");
						lbl33.setBackground(new java.awt.Color(0,0,0));
						lbl33.setOpaque(true);
						lbl33.setBounds(184, 159, 84, 60);
						lbl33.setHorizontalAlignment(SwingConstants.CENTER);
						lbl33.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl32 = new JLabel();
						InterfazTablero[1][2]=lbl32;
						pnlBoard.add(lbl32);
						lbl32.setText("0");
						lbl32.setBackground(new java.awt.Color(0,0,0));
						lbl32.setOpaque(true);
						lbl32.setBounds(184, 100, 84, 60);
						lbl32.setHorizontalAlignment(SwingConstants.CENTER);
						lbl32.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl31 = new JLabel();
						InterfazTablero[0][2]=lbl31;
						pnlBoard.add(lbl31);
						lbl31.setText("0");
						lbl31.setBackground(new java.awt.Color(0,0,0));
						lbl31.setOpaque(true);
						lbl31.setBounds(184, 41, 84, 60);
						lbl31.setHorizontalAlignment(SwingConstants.CENTER);
						lbl31.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						btn3 = new JButton();
						pnlBoard.add(btn3);
						btn3.setText("Columna 3");
						btn3.setBounds(181, 17, 84, 23);
						btn3.setBackground(new java.awt.Color(0,0,0));
						btn3.setFocusable(false);
						btn3.setVisible(false);
						btn3.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								btn3MouseClicked(evt);
							}
						});
					}
					{
						btn2 = new JButton();
						pnlBoard.add(btn2);
						btn2.setText("Columna 2");
						btn2.setBounds(97, 17, 84, 23);
						btn2.setBackground(new java.awt.Color(0,0,0));
						btn2.setFocusable(false);
						btn2.setVisible(false);
						btn2.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								btn2MouseClicked(evt);
							}
						});
					}
					{
						lbl21 = new JLabel();
						InterfazTablero[0][1]=lbl21;
						pnlBoard.add(lbl21);
						lbl21.setText("0");
						lbl21.setBackground(new java.awt.Color(0,0,0));
						lbl21.setOpaque(true);
						lbl21.setBounds(100, 40, 84, 60);
						lbl21.setHorizontalAlignment(SwingConstants.CENTER);
						lbl21.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl22 = new JLabel();
						InterfazTablero[1][1]=lbl22;
						pnlBoard.add(lbl22);
						lbl22.setText("0");
						lbl22.setBackground(new java.awt.Color(0,0,0));
						lbl22.setOpaque(true);
						lbl22.setBounds(100, 100, 84, 60);
						lbl22.setHorizontalAlignment(SwingConstants.CENTER);
						lbl22.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl23 = new JLabel();
						InterfazTablero[2][1]=lbl23;
						pnlBoard.add(lbl23);
						lbl23.setText("0");
						lbl23.setBackground(new java.awt.Color(0,0,0));
						lbl23.setOpaque(true);
						lbl23.setBounds(100, 160, 84, 60);
						lbl23.setHorizontalAlignment(SwingConstants.CENTER);
						lbl23.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl24 = new JLabel();
						InterfazTablero[3][1]=lbl24;
						pnlBoard.add(lbl24);
						lbl24.setText("0");
						lbl24.setBackground(new java.awt.Color(0,0,0));
						lbl24.setOpaque(true);
						lbl24.setBounds(100, 219, 84, 60);
						lbl24.setHorizontalAlignment(SwingConstants.CENTER);
						lbl24.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl25 = new JLabel();
						InterfazTablero[4][1]=lbl25;
						pnlBoard.add(lbl25);
						lbl25.setText("0");
						lbl25.setBackground(new java.awt.Color(0,0,0));
						lbl25.setOpaque(true);
						lbl25.setBounds(100, 279, 84, 60);
						lbl25.setHorizontalAlignment(SwingConstants.CENTER);
						lbl25.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl26 = new JLabel();
						InterfazTablero[5][1]=lbl26;
						pnlBoard.add(lbl26);
						lbl26.setText("0");
						lbl26.setBackground(new java.awt.Color(0,0,0));
						lbl26.setOpaque(true);
						lbl26.setBounds(100, 339, 84, 60);
						lbl26.setHorizontalAlignment(SwingConstants.CENTER);
						lbl26.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl16 = new JLabel();
						InterfazTablero[5][0]=lbl16;
						pnlBoard.add(lbl16);
						lbl16.setText("0");
						lbl16.setBackground(new java.awt.Color(0,0,0));
						lbl16.setOpaque(true);
						lbl16.setBounds(16, 339, 84, 60);
						lbl16.setHorizontalAlignment(SwingConstants.CENTER);
						lbl16.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
						lbl16.setPreferredSize(new java.awt.Dimension(84, 60));
					}
					{
						lbl15 = new JLabel();
						InterfazTablero[4][0]=lbl15;
						pnlBoard.add(lbl15);
						lbl15.setText("0");
						lbl15.setBackground(new java.awt.Color(0,0,0));
						lbl15.setOpaque(true);
						lbl15.setBounds(16, 280, 84, 60);
						lbl15.setHorizontalAlignment(SwingConstants.CENTER);
						lbl15.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl14 = new JLabel();
						InterfazTablero[3][0]=lbl14;
						pnlBoard.add(lbl14);
						lbl14.setText("0");
						lbl14.setBackground(new java.awt.Color(0,0,0));
						lbl14.setOpaque(true);
						lbl14.setBounds(16, 220, 84, 60);
						lbl14.setHorizontalAlignment(SwingConstants.CENTER);
						lbl14.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl13 = new JLabel();
						InterfazTablero[2][0]=lbl13;
						pnlBoard.add(lbl13);
						lbl13.setText("0");
						lbl13.setBackground(new java.awt.Color(0,0,0));
						lbl13.setOpaque(true);
						lbl13.setBounds(16, 160, 84, 60);
						lbl13.setHorizontalAlignment(SwingConstants.CENTER);
						lbl13.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl12 = new JLabel();
						InterfazTablero[1][0]=lbl12;
						pnlBoard.add(lbl12);
						lbl12.setText("0");
						lbl12.setBackground(new java.awt.Color(0,0,0));
						lbl12.setOpaque(true);
						lbl12.setBounds(16, 100, 84, 60);
						lbl12.setHorizontalAlignment(SwingConstants.CENTER);
						lbl12.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						lbl11 = new JLabel();
						InterfazTablero[0][0]=lbl11;
						pnlBoard.add(lbl11);
						lbl11.setText("0");
						lbl11.setBackground(new java.awt.Color(0,0,0));
						lbl11.setOpaque(true);
						lbl11.setBounds(16, 40, 84, 60);
						lbl11.setHorizontalAlignment(SwingConstants.CENTER);
						lbl11.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Empty.jpg")));
					}
					{
						btn1 = new JButton();
						pnlBoard.add(btn1);
						btn1.setText("Columna 1");
						btn1.setBounds(13, 17, 84, 23);
						btn1.setBackground(new java.awt.Color(0,0,0));
						btn1.setFocusable(false);
						btn1.setVisible(false);
						btn1.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								btn1MouseClicked(evt);
							}
						});
					}
				}
				{
					pnlMenu = new JPanel();
					pnlFondo.add(pnlMenu);
					pnlMenu.setLayout(null);
					pnlMenu.setBounds(643, 14, 141, 417);
					pnlMenu.setBackground(new java.awt.Color(128,128,255));
					{
						btnSalir = new JButton();
						pnlMenu.add(btnSalir);
						btnSalir.setText("Salir");
						btnSalir.setBounds(21, 383, 97, 23);
						btnSalir.setFocusable(false);
						btnSalir.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								btnSalirMouseClicked(evt);
							}
						});
					}
				}
				{
					lblEstado = new JLabel();
					pnlFondo.add(lblEstado);
					lblEstado.setText("Pulse \"Empezar\" para comenzar a jugar");
					lblEstado.setBounds(24, 436, 298, 20);
				}
				{
					lblConsejo = new JLabel();
					pnlFondo.add(lblConsejo);
					lblConsejo.setBounds(643, 439, 124, 17);
					lblConsejo.setHorizontalAlignment(SwingConstants.CENTER);
				}
			}
			pack();
			this.setSize(800, 500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private int libre(int columna){
		for(int i=InterfazTablero.length-1;i>=0;i--){
			if(InterfazTablero[i][columna].getText().equals("0"))
				return i;
			}
		return -1;
	}
	
	private void btn1MouseClicked(MouseEvent evt) {
		ponerFicha(0);
	}
	
	private void btn2MouseClicked(MouseEvent evt) {
		ponerFicha(1);
	}
	
	private void btn3MouseClicked(MouseEvent evt) {
		ponerFicha(2);
	}
	
	private void btn4MouseClicked(MouseEvent evt) {
		ponerFicha(3);
	}
	
	private void btn5MouseClicked(MouseEvent evt) {
		ponerFicha(4);
	}
	
	private void btn6MouseClicked(MouseEvent evt) {
		ponerFicha(5);
	}
	
	private void btn7MouseClicked(MouseEvent evt) {
		ponerFicha(6);
	}
	
	private void ponerFicha(int columna){
		lblConsejo.setText(null);
		int fila=libre(columna);
		boolean ganador=false;
		if(fila!=-1){
			InterfazTablero[fila][columna].setText(String.valueOf(jugador));
			tablero.ponerFicha(columna,jugador);
			if(jugador==1){
				lblEstado.setText("Turno del jugador azul");
				InterfazTablero[fila][columna].setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Red.jpg")));
			}
			else{
				lblEstado.setText("Turno del jugador rojo");
				InterfazTablero[fila][columna].setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Blue.jpg")));
			}
			if(juego.ganador(1, tablero, columna)){
				ganador=true;
				desactivar(false);
				lblEstado.setText("El jugador rojo ha ganado");
				consejo=false;
				Ganador gana=new Ganador(this,"El jugado rojo ha ganado");
				gana.setVisible(true);
				gana.setLocationRelativeTo(null);
				disable();
			}else if(juego.ganador(2, tablero , columna)){
				desactivar(false);
				ganador=true;
				lblEstado.setText("El jugador azul ha ganado");
				consejo=false;
				Ganador gana=new Ganador(this,"El jugador azul ha ganado");
				gana.setVisible(true);
				gana.setLocationRelativeTo(null);
				disable();
			}else if(juego.hayEmpate(tablero)){
				if(juego.tresEnRaya(tablero.getTablero(),jugador)>juego.tresEnRaya(tablero.getTablero(),cambiarJugador(jugador)))
					lblEstado.setText("El jugador azul ha ganado");
				else if(juego.tresEnRaya(tablero.getTablero(),jugador)<juego.tresEnRaya(tablero.getTablero(),cambiarJugador(jugador)))
					lblEstado.setText("El jugador rojo ha ganado");
				else if(juego.dosEnRaya(tablero.getTablero(),jugador)>juego.dosEnRaya(tablero.getTablero(),cambiarJugador(jugador)))
					lblEstado.setText("El jugador azul ha ganado");
				else if(juego.tresEnRaya(tablero.getTablero(),jugador)<juego.tresEnRaya(tablero.getTablero(),cambiarJugador(jugador)))
					lblEstado.setText("El jugador rojo ha ganado");
				else lblEstado.setText("El juego ha terminado en empate");
				desactivar(false);
				ganador=true;
				Ganador gana=new Ganador(this,"El juego ha terminado en empate");
				gana.setVisible(true);
				gana.setLocationRelativeTo(null);
				disable();
				consejo=false;
			}
			jugador=cambiarJugador(jugador);
			
			if(maquina && !ganador){ 
				juegaMaquina();
				}
			}
		}
	
	
	private void juegaMaquina(){
		lblEstado.setText("Pensando...");
		int movimiento=juego.minimax(tablero,jugador);
		int fila=libre(movimiento);
		tablero.ponerFicha(movimiento,jugador);
		InterfazTablero[fila][movimiento].setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/ConnectFour/Blue.jpg")));
		InterfazTablero[fila][movimiento].setText(String.valueOf(jugador));
		jugador=cambiarJugador(jugador);
		lblEstado.setText("Turno del jugador rojo");
		if(juego.ganador(2, tablero , movimiento)){
			desactivar(false);
			lblEstado.setText("El jugador azul ha ganado");
			consejo=false;
			Ganador gana=new Ganador(this,"El jugador azul ha ganado");
			gana.setVisible(true);
			gana.setLocationRelativeTo(null);
			disable();
		}
	}
	
	private void desactivar(boolean opcion){
		btn1.setVisible(opcion);
		btn2.setVisible(opcion);
		btn3.setVisible(opcion);
		btn4.setVisible(opcion);
		btn5.setVisible(opcion);
		btn6.setVisible(opcion);
		btn7.setVisible(opcion);
	}
	private int cambiarJugador(int jugador){
		if(jugador==1)
			return 2;
		else return 1;
	}
	
	private void btnSalirMouseClicked(MouseEvent evt) {
		dispose();
	}
	
}
