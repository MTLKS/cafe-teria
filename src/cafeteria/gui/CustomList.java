/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteria.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author Matthew
 */
public class CustomList extends JList {
    public CustomList() {
        setBackground(new Color(17, 17, 17));
        setFont(new Font("Tahoma", 0, 14));
        setForeground(new Color(255, 255, 255));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setSelectionBackground(new Color(116, 141, 129));
        setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        UIManager.put("List.focusCellHighlightBorder", new EmptyBorder(1, 1, 1, 1));
    }  
}
