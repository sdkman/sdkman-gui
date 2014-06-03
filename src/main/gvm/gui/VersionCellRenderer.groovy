package gvm.gui

import javax.swing.JLabel
import javax.swing.JList
import javax.swing.ListCellRenderer
import java.awt.Component

class VersionCellRenderer extends JLabel implements ListCellRenderer<Object> {

    public Component getListCellRendererComponent(
            JList<?> list,           // the list
            Object value,            // value to display
            int index,               // cell index
            boolean isSelected,      // is the cell selected
            boolean cellHasFocus)    // does the cell have focus
    {
        setText(value?.name);
        return this;
    }
}