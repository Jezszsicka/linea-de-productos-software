package presentation;

import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel{
	
	private static final long serialVersionUID = 1L;
	public TableModel(String [][] celdas, String [] columnas){
		super(celdas,columnas);
	}
	
	public boolean isCellEditable(int rowIndex, int colIndex){
		return false;
	}
	
	
}
