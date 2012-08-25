package presentation;

import java.awt.Cursor;
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
import java.awt.Color;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class GamesListUI extends javax.swing.JFrame {
	private JPanelRound pnlFondo;
	private JButton btnJoin;
	private JButton btnCancel;
	private JTable tblGames;
	private JScrollPane scrollGames;
	private JButton btnFilter;
	private JTextField txtGameSearch;
	private DefaultTableModel tblGamesModel;
	private JCheckBox checkCheckers;
	private JCheckBox checkGoose;
	private JLabel Players;
	private JCheckBox check2Players;
	private JCheckBox check3orMore;
	private JPanel pnlFilter;
	private JLabel lblFilter;
	private JLabel lblGame;
	private Filter filter;
	private JCheckBox checkChess;
	private JCheckBox checkLudo;
	private JCheckBox checkConnect4;

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public GamesListUI() {
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
		setSize(635, 362);
	}

	private JPanelRound getPnlFondo() {
		if (pnlFondo == null) {
			pnlFondo = new JPanelRound();
			pnlFondo.setArcw(0);
			pnlFondo.setArch(0);
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

				@Override
				public void mouseEntered(MouseEvent e) {
					btnJoinMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnJoinMouseExited(e);
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

				@Override
				public void mouseEntered(MouseEvent e) {
					btnCancelMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnCancelMouseExited(e);
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
			txtGameSearch.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			txtGameSearch.setBackground(Color.BLACK);
			txtGameSearch.setCaretColor(Color.WHITE);
			txtGameSearch.setForeground(Color.WHITE);
			txtGameSearch.setBounds(15, 20, 251, 25);
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
			btnFilter.setBounds(276, 22, 70, 21);
			btnFilter.setFocusable(false);
			btnFilter.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnFilterMouseClicked(evt);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					btnFilterMouseEntered(e);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnFilterMouseExited(e);
				}
			});
		}
		return btnFilter;
	}

	private JScrollPane getJScrollPane1() {
		if (scrollGames == null) {
			scrollGames = new JScrollPane();
			scrollGames.setBackground(Color.BLACK);
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
			tblGames.setBackground(Color.BLACK);
			tblGames.setForeground(Color.WHITE);
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
			check3orMore.setForeground(Color.WHITE);
			check3orMore.setBackground(Color.BLACK);
			check3orMore.setText("3 o más jugadores");
			check3orMore.setBounds(111, 77, 115, 23);
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
			check2Players.setForeground(Color.WHITE);
			check2Players.setBackground(Color.BLACK);
			check2Players.setText("2 jugadores");
			check2Players.setBounds(111, 52, 115, 23);
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
			Players.setForeground(Color.WHITE);
			Players.setText("Players");
			Players.setFont(new java.awt.Font("Tahoma", 1, 11));
			Players.setBounds(114, 28, 112, 21);
			Players.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return Players;
	}

	private JCheckBox getCheckGoose() {
		if (checkGoose == null) {
			checkGoose = new JCheckBox();
			checkGoose.setForeground(Color.WHITE);
			checkGoose.setBackground(Color.BLACK);
			checkGoose.setText("Oca");
			checkGoose.setBounds(23, 77, 81, 23);
			checkGoose.setFocusable(false);
			checkGoose.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					checkGooseMouseClicked(evt);
				}
			});
		}
		return checkGoose;
	}

	private JCheckBox getCheckCheckers() {
		if (checkCheckers == null) {
			checkCheckers = new JCheckBox();
			checkCheckers.setBackground(Color.BLACK);
			checkCheckers.setForeground(Color.WHITE);
			checkCheckers.setText("Damas");
			checkCheckers.setBounds(23, 53, 81, 21);
			checkCheckers.setFocusable(false);
			checkCheckers.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					checkCheckersMouseClicked(evt);
				}
			});
		}
		return checkCheckers;
	}

	private JCheckBox getCheckChess() {
		if (checkChess == null) {
			checkChess = new JCheckBox("Ajedrez");
			checkChess.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					checkChessMouseClicked(arg0);
				}
			});
			checkChess.setBackground(Color.BLACK);
			checkChess.setForeground(Color.WHITE);
			checkChess.setBounds(23, 103, 81, 23);
		}
		return checkChess;
	}

	private JCheckBox getCheckLudo() {
		if (checkLudo == null) {
			checkLudo = new JCheckBox("Parchís");
			checkLudo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					checkLudoMouseClicked(e);
				}
			});
			checkLudo.setBackground(Color.BLACK);
			checkLudo.setForeground(Color.WHITE);
			checkLudo.setBounds(23, 129, 81, 23);
		}
		return checkLudo;
	}

	private JCheckBox getCheckConnect4() {
		if (checkConnect4 == null) {
			checkConnect4 = new JCheckBox("Conecta 4");
			checkConnect4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					checkConnect4MouseClicked(e);
				}
			});
			checkConnect4.setBackground(Color.BLACK);
			checkConnect4.setForeground(Color.WHITE);
			checkConnect4.setBounds(23, 155, 81, 23);
		}
		return checkConnect4;
	}

	private JLabel getLblGame() {
		if (lblGame == null) {
			lblGame = new JLabel();
			lblGame.setForeground(Color.WHITE);
			lblGame.setText("Games");
			lblGame.setFont(new java.awt.Font("Tahoma", 1, 11));
			lblGame.setBounds(2, 28, 102, 21);
			lblGame.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblGame;
	}

	private JLabel getLblFilter() {
		if (lblFilter == null) {
			lblFilter = new JLabel();
			lblFilter.setForeground(Color.WHITE);
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
			pnlFilter.setBackground(Color.BLACK);
			pnlFilter.setLayout(null);
			pnlFilter.setBounds(371, 20, 238, 200);
			pnlFilter.setBorder(BorderFactory.createTitledBorder(""));
			pnlFilter.add(getLblFilter());
			pnlFilter.add(getLblGame());
			pnlFilter.add(getCheckCheckers());
			pnlFilter.add(getCheckGoose());
			pnlFilter.add(getPlayers());
			pnlFilter.add(getCheck2Players());
			pnlFilter.add(getCheck3orMore());
			pnlFilter.add(getCheckChess());
			pnlFilter.add(getCheckLudo());
			pnlFilter.add(getCheckConnect4());
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

	private void checkGooseMouseClicked(MouseEvent evt) {
		if (checkGoose.isSelected()) {
			filter.addGame(GameType.Goose);
		} else {
			filter.removeGame(GameType.Goose);
		}
	}

	protected void checkChessMouseClicked(MouseEvent arg0) {
		if (checkChess.isSelected()) {
			filter.addGame(GameType.Chess);
		} else {
			filter.removeGame(GameType.Chess);
		}
	}

	protected void checkLudoMouseClicked(MouseEvent e) {
		if (checkLudo.isSelected()) {
			filter.addGame(GameType.Ludo);
		} else {
			filter.removeGame(GameType.Ludo);
		}
	}

	protected void checkConnect4MouseClicked(MouseEvent e) {
		if (checkConnect4.isSelected()) {
			filter.addGame(GameType.Connect4);
		} else {
			filter.removeGame(GameType.Connect4);
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

	private void setHandCursor() {
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	private void setDefaultCursor() {
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	protected void btnFilterMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnFilterMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void btnJoinMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnJoinMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

	protected void btnCancelMouseEntered(MouseEvent e) {
		setHandCursor();
	}

	protected void btnCancelMouseExited(MouseEvent e) {
		setDefaultCursor();
	}

}
