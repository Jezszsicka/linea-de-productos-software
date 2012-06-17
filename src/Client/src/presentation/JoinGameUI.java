package presentation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import ProductLine.Game;



import logic.Controller;



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
@SuppressWarnings("serial")
public class JoinGameUI extends javax.swing.JFrame {
	private JPanel pnlFondo;
	private JButton btnJoin;
	private JButton btnCancel;
	private JTable tblGames;
	private JScrollPane scrollGames;
	private JButton btnFilter;
	private JTextField txtGameSearch;
	private DefaultTableModel tblGamesModel;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

		
	public JoinGameUI() {
		super();
		initGUI();
		setVisible(true);
		setLocationRelativeTo(null);
		refreshGames();
	}
	
	private void refreshGames() {
		List<Game> games = Controller.getInstance().listGames();
		for(Game game : games){
			tblGamesModel.addRow(new String[]{game.getName(), String.valueOf(game.getTypeGame()), String.valueOf(game.getSlots().size())+"/"+game.getSlots().size()});
		}
		
	}

	private void initGUI() {
		try {
			this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			getContentPane().setLayout(null);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			getContentPane().add(getPnlFondo());
			pack();
			this.setSize(538, 362);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private JPanel getPnlFondo() {
		if(pnlFondo == null) {
			pnlFondo = new JPanel();
			pnlFondo.setLayout(null);
			pnlFondo.setBounds(0, 0, 522, 324);
			pnlFondo.add(getBtnJoin());
			pnlFondo.add(getBtnCancel());
			pnlFondo.add(getJScrollPane1());
			pnlFondo.add(getTxtGameSearch());
			pnlFondo.add(getBtnFilter());
		}
		return pnlFondo;
	}
	
	private JButton getBtnJoin() {
		if(btnJoin == null) {
			btnJoin = new JButton();
			btnJoin.setText("Join game");
			btnJoin.setBounds(431, 249, 81, 23);
			btnJoin.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnJoinMouseClicked(evt);
				}
			});
		}
		return btnJoin;
	}
	
	private JButton getBtnCancel() {
		if(btnCancel == null) {
			btnCancel = new JButton();
			btnCancel.setText("Cancel");
			btnCancel.setBounds(431, 278, 81, 23);
			btnCancel.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnCancelMouseClicked(evt);
				}
			});
		}
		return btnCancel;
	}
	
	private void btnCancelMouseClicked(MouseEvent evt) {
		Controller.getInstance().closeJoinGameUI();
	}
	
	private void thisWindowClosing(WindowEvent evt) {
		Controller.getInstance().closeJoinGameUI();
	}
	
	private void btnJoinMouseClicked(MouseEvent evt) {
		int gameRow = tblGames.getSelectedRow();
		String game =(String) tblGamesModel.getValueAt(gameRow, 0);
		Controller.getInstance().joinGame(game);
	}

	private JTextField getTxtGameSearch() {
		if(txtGameSearch == null) {
			txtGameSearch = new JTextField();
			txtGameSearch.setBounds(15, 20, 192, 20);
		}
		return txtGameSearch;
	}
	
	private JButton getBtnFilter() {
		if(btnFilter == null) {
			btnFilter = new JButton();
			btnFilter.setText("Filtro");
			btnFilter.setBounds(284, 20, 68, 21);
		}
		return btnFilter;
	}
	
	private JScrollPane getJScrollPane1() {
		if(scrollGames == null) {
			scrollGames = new JScrollPane();
			scrollGames.setBounds(15, 57, 406, 244);
			scrollGames.setBorder(BorderFactory.createTitledBorder(""));
			scrollGames.setViewportView(getTblGames());
		}
		return scrollGames;
	}
	
	private JTable getTblGames() {
		if(tblGames == null) {
			tblGamesModel = 
					new presentation.TableModel(new String[][] {},new String[] { "Nombre","Juego","Jugadores"});
			tblGames = new JTable();
			tblGames.setModel(tblGamesModel);
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.CENTER);
			tblGames.getColumnModel().getColumn(0).setCellRenderer(tcr);
			tblGames.getColumnModel().getColumn(1).setCellRenderer(tcr);
			tblGames.getColumnModel().getColumn(2).setCellRenderer(tcr);
			((DefaultTableCellRenderer)tblGames.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
			getTblGames().getTableHeader().setVisible(true);
			tblGames.setPreferredSize(new java.awt.Dimension(406, 211));
			tblGames.setOpaque(false);
			tblGames.setFocusable(false);
			tblGames.getTableHeader().setReorderingAllowed(false);
			tblGames.getTableHeader().setResizingAllowed(false);
		}
		return tblGames;
	}

}
