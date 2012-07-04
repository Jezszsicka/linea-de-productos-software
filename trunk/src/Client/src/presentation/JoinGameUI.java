package presentation;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import ProductLine.Game;
import ProductLine.GameType;
import ProductLine.Slot;
import ProductLine.SlotState;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import logic.Controller;
import model.Filter;

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
public class JoinGameUI extends javax.swing.JFrame {
	private JPanel pnlFondo;
	private JButton btnJoin;
	private JButton btnCancel;
	private JTable tblGames;
	private JScrollPane scrollGames;
	private JButton btnFilter;
	private JTextField txtGameSearch;
	private DefaultTableModel tblGamesModel;
	private JCheckBox checkCheckers;
	private JCheckBox checkTrivial;
	private JLabel Players;
	private JCheckBox check2Players;
	private JCheckBox check3orMore;
	private JPanel pnlFilter;
	private JLabel lblFilter;
	private JLabel lblGame;
	private Filter filter;

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JoinGameUI() {
		super();
		filter = new Filter();
		initGUI();
		setVisible(true);
		setLocationRelativeTo(null);
		refreshGames();
	}

	private void refreshGames() {
		List<Game> games = Controller.getInstance().listGames(
				txtGameSearch.getText(), filter);
		System.out.println(games.toString());
		clearList();
		for (Game game : games) {
			int freeSlots = 0;
			for (Slot slot : game.getSlots())
				if (slot.getType().equals(SlotState.Empty))
					freeSlots++;
			tblGamesModel.addRow(new String[] {
					game.getName(),
					String.valueOf(game.getTypeGame()),
					String.valueOf(game.getSlots().size() - freeSlots) + "/"
							+ game.getSlots().size() });
		}

	}

	private void clearList() {
		tblGamesModel = new presentation.TableModel(new String[][] {},
				new String[] { "Nombre", "Juego", "Jugadores" });
		tblGames.setModel(tblGamesModel);
		tblGames.setFocusable(false);
		tblGames.getTableHeader().setReorderingAllowed(false);
		tblGames.getTableHeader().setResizingAllowed(false);
		tblGames.getTableHeader().setFont(new java.awt.Font("Dialog", 3, 12));
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		tblGames.getColumnModel().getColumn(0).setCellRenderer(tcr);
		tblGames.getColumnModel().getColumn(1).setCellRenderer(tcr);
		tblGames.getColumnModel().getColumn(2).setCellRenderer(tcr);
		((DefaultTableCellRenderer) tblGames.getTableHeader()
				.getDefaultRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		tblGames.setOpaque(false);
	}

	private void initGUI() {
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				thisWindowClosing(evt);
			}
		});
		getContentPane().add(getPnlFondo());
		pack();
		this.setSize(635, 362);
	}

	private JPanel getPnlFondo() {
		if (pnlFondo == null) {
			pnlFondo = new JPanel();
			pnlFondo.setLayout(null);
			pnlFondo.setBounds(0, 0, 619, 324);
			pnlFondo.add(getBtnJoin());
			pnlFondo.add(getBtnCancel());
			pnlFondo.add(getJScrollPane1());
			pnlFondo.add(getTxtGameSearch());
			pnlFondo.add(getBtnFilter());
			pnlFondo.add(getPnlFilter());
		}
		return pnlFondo;
	}

	private JButton getBtnJoin() {
		if (btnJoin == null) {
			btnJoin = new JButton();
			btnJoin.setText("Join game");
			btnJoin.setBounds(528, 261, 81, 23);
			btnJoin.setFocusable(false);
			btnJoin.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnJoinMouseClicked(evt);
				}
			});
		}
		return btnJoin;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton();
			btnCancel.setText("Cancel");
			btnCancel.setBounds(528, 290, 81, 23);
			btnCancel.setFocusable(false);
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
		String game = (String) tblGamesModel.getValueAt(gameRow, 0);
		Controller.getInstance().joinGame(game);
	}

	private JTextField getTxtGameSearch() {
		if (txtGameSearch == null) {
			txtGameSearch = new JTextField();
			txtGameSearch.setBounds(15, 20, 251, 20);
			txtGameSearch.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent evt) {
					txtGameSearchKeyPressed(evt);
				}
			});
		}
		return txtGameSearch;
	}

	private JButton getBtnFilter() {
		if (btnFilter == null) {
			btnFilter = new JButton();
			btnFilter.setText("Buscar");
			btnFilter.setBounds(276, 20, 70, 21);
			btnFilter.setFocusable(false);
			btnFilter.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnFilterMouseClicked(evt);
				}
			});
		}
		return btnFilter;
	}

	private JScrollPane getJScrollPane1() {
		if (scrollGames == null) {
			scrollGames = new JScrollPane();
			scrollGames.setBounds(15, 57, 331, 256);
			scrollGames.setBorder(BorderFactory.createTitledBorder(""));
			scrollGames.setViewportView(getTblGames());
		}
		return scrollGames;
	}

	private JTable getTblGames() {
		if (tblGames == null) {
			tblGamesModel = new presentation.TableModel(new String[][] {},
					new String[] { "Nombre", "Juego", "Jugadores" });
			tblGames = new JTable();
			tblGames.setModel(tblGamesModel);
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.CENTER);
			tblGames.getColumnModel().getColumn(0).setCellRenderer(tcr);
			tblGames.getColumnModel().getColumn(1).setCellRenderer(tcr);
			tblGames.getColumnModel().getColumn(2).setCellRenderer(tcr);
			((DefaultTableCellRenderer) tblGames.getTableHeader()
					.getDefaultRenderer())
					.setHorizontalAlignment(SwingConstants.CENTER);
			getTblGames().getTableHeader().setVisible(true);
			tblGames.setPreferredSize(new java.awt.Dimension(406, 211));
			tblGames.setOpaque(false);
			tblGames.setFocusable(false);
			tblGames.getTableHeader().setReorderingAllowed(false);
			tblGames.getTableHeader().setResizingAllowed(false);
		}
		return tblGames;
	}

	private JCheckBox getCheck3orMore() {
		if (check3orMore == null) {
			check3orMore = new JCheckBox();
			check3orMore.setText("3 o más jugadores");
			check3orMore.setBounds(115, 103, 115, 23);
			check3orMore.setFocusable(false);
			check3orMore.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					check3orMoreMouseClicked(evt);
				}
			});
		}
		return check3orMore;
	}

	private JCheckBox getCheck2Players() {
		if (check2Players == null) {
			check2Players = new JCheckBox();
			check2Players.setText("2 jugadores");
			check2Players.setBounds(115, 77, 115, 23);
			check2Players.setFocusable(false);
			check2Players.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					check2PlayersMouseClicked(evt);
				}
			});
		}
		return check2Players;
	}

	private JLabel getPlayers() {
		if (Players == null) {
			Players = new JLabel();
			Players.setText("Players");
			Players.setFont(new java.awt.Font("Tahoma", 1, 11));
			Players.setBounds(114, 42, 112, 21);
			Players.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return Players;
	}

	private JCheckBox getCheckTrivial() {
		if (checkTrivial == null) {
			checkTrivial = new JCheckBox();
			checkTrivial.setText("Trivial");
			checkTrivial.setBounds(23, 103, 94, 23);
			checkTrivial.setFocusable(false);
			checkTrivial.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					checkTrivialMouseClicked(evt);
				}
			});
		}
		return checkTrivial;
	}

	private JCheckBox getCheckCheckers() {
		if (checkCheckers == null) {
			checkCheckers = new JCheckBox();
			checkCheckers.setText("Damas");
			checkCheckers.setBounds(23, 78, 92, 21);
			checkCheckers.setFocusable(false);
			checkCheckers.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					checkCheckersMouseClicked(evt);
				}
			});
		}
		return checkCheckers;
	}

	private JLabel getLblGame() {
		if (lblGame == null) {
			lblGame = new JLabel();
			lblGame.setText("Games");
			lblGame.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblGame.setBounds(2, 42, 102, 21);
			lblGame.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblGame;
	}

	private JLabel getLblFilter() {
		if (lblFilter == null) {
			lblFilter = new JLabel();
			lblFilter.setText("Filtro");
			lblFilter.setBounds(12, 5, 214, 19);
			lblFilter.setHorizontalAlignment(SwingConstants.CENTER);
			lblFilter.setFont(new java.awt.Font("Tahoma", 1, 11));
		}
		return lblFilter;
	}

	private JPanel getPnlFilter() {
		if (pnlFilter == null) {
			pnlFilter = new JPanel();
			pnlFilter.setLayout(null);
			pnlFilter.setBounds(371, 57, 238, 167);
			pnlFilter.setBorder(BorderFactory.createTitledBorder(""));
			pnlFilter.add(getLblFilter());
			pnlFilter.add(getLblGame());
			pnlFilter.add(getCheckCheckers());
			pnlFilter.add(getCheckTrivial());
			pnlFilter.add(getPlayers());
			pnlFilter.add(getCheck2Players());
			pnlFilter.add(getCheck3orMore());
		}
		return pnlFilter;
	}

	private void checkCheckersMouseClicked(MouseEvent evt) {
		if (checkCheckers.isSelected()) {
			filter.addGame(GameType.Checkers);
		} else {
			filter.removeGame(GameType.Checkers);
		}
	}

	private void checkTrivialMouseClicked(MouseEvent evt) {
		if (checkTrivial.isSelected()) {
			filter.addGame(GameType.Trivial);
		} else {
			filter.removeGame(GameType.Trivial);
		}
	}

	private void check2PlayersMouseClicked(MouseEvent evt) {
		if (check2Players.isSelected()) {
			filter.addPlayers(ProductLine.Players.TwoPlayers);
		} else {
			filter.removePlayers(ProductLine.Players.TwoPlayers);
		}
	}

	private void check3orMoreMouseClicked(MouseEvent evt) {
		if (check3orMore.isSelected()) {
			filter.addPlayers(ProductLine.Players.ThreeOrMore);
		} else {
			filter.removePlayers(ProductLine.Players.ThreeOrMore);
		}
	}

	private void txtGameSearchKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == 10)
			refreshGames();
	}

	private void btnFilterMouseClicked(MouseEvent evt) {
		refreshGames();
	}

}
