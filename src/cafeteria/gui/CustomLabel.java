/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteria.gui;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Matthew
 */
public class CustomLabel extends JLabel {
    public CustomLabel(String name) {
        setFont(new Font("Tahoma", 1, 12));
        setForeground(new Color(204, 204, 204));
        setText(name);
        setHorizontalAlignment(CENTER);
    }
}
