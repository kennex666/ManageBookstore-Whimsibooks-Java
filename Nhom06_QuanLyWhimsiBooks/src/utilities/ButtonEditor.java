/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;

/**
 *
 * @author duong
 */
public class ButtonEditor extends DefaultCellEditor {

    private String label;

    public ButtonEditor(JCheckBox checkBox) {

        super(checkBox);

    }
}