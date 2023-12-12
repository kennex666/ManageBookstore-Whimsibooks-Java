package utilities;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class DetaiCellBtn extends DefaultTableCellRenderer {
    private final Icon detailIcon;

    public DetaiCellBtn() {
        String iconPath = "/img/icon/icon-eye.png";
        this.detailIcon = new ImageIcon(getClass().getResource(iconPath));
        setHorizontalAlignment(JLabel.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        if (column == 10) {
            setIcon(detailIcon);
            setText("");
        }

        return this;
    }
}
