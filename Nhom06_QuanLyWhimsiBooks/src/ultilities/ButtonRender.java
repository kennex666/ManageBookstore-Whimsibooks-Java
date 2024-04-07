/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ultilities;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author duong
 */
public class ButtonRender extends JButton implements TableCellRenderer {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private ImageIcon iconButton;
    private JButton jButton1 ;

    public ButtonRender() {
            
        JButton jButton1 = new javax.swing.JButton();

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/btn-delete-no-transparent.png"))); // NOI18N
        jButton1.setBorder(null);
        
        setBorder(null);
        setLayout(new FlowLayout());
        setBackground(new Color(0,0,0,0));
        add(jButton1);
        
    }
    
    public ButtonRender(ImageIcon x) {
            
        jButton1 = new javax.swing.JButton();

        jButton1.setIcon(x); // NOI18N
        jButton1.setBorder(null);
        
        setBorder(null);
        setLayout(new FlowLayout());
        setBackground(new Color(0,0,0,0));
        add(jButton1);
        
    }
    
    


    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        setText((value == null) ? "" : value.toString());

        return this;

    }

}