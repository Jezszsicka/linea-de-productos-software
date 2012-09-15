package presentation;

import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ComboBoxRenderer extends JLabel implements ListCellRenderer {
	private Font uhOhFont;
	private ImageIcon[] images;
	private String[] descriptions;

	public ComboBoxRenderer(ImageIcon[] images, String[] descriptions) {
		this.images = images;
		this.descriptions = descriptions;
		setOpaque(true);
		setHorizontalAlignment(CENTER);
		setVerticalAlignment(CENTER);
	}

	/*
	 * This method finds the image and text corresponding to the selected value
	 * and returns the label, set up to display the text and image.
	 */
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		// Get the selected index. (The index param isn't
		// always valid, so just use the value.)
		int selectedIndex = ((Integer) value).intValue();

		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}

		
		ImageIcon icon = images[selectedIndex];
		String description = descriptions[selectedIndex];
		setIcon(icon);
		setText(description);
		setFont(list.getFont());
		setHorizontalAlignment(SwingConstants.LEFT);
		
		return this;
	}

	// Set the font and text when no image was found.
	protected void setUhOhText(String uhOhText, Font normalFont) {
		if (uhOhFont == null) { // lazily create this font
			uhOhFont = normalFont.deriveFont(Font.ITALIC);
		}
		setFont(uhOhFont);
		setText(uhOhText);
	}
}