/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteria.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Matthew
 */
public class CustomButton extends JButton {
    private boolean toggle = false;
    
    public CustomButton(String txt) {
        setBackground(new java.awt.Color(84, 113, 106));
        setForeground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setFocusPainted(false);
        setHideActionText(true);
        setText(txt);
        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                setBackground(new java.awt.Color(116, 141, 129));
            }
            
            public void mouseExited(MouseEvent evt) {
                if (toggle) {
                    setBackground(new java.awt.Color(116, 141, 129));
                } else {
                    setBackground(new java.awt.Color(84, 113, 106));
                }
            }
        });
    }
    
    @Override
    public JToolTip createToolTip() {
        JToolTip tip = super.createToolTip();
        tip.setBackground(new Color(41,41,41));
        tip.setForeground(Color.WHITE);
        tip.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        return tip;
    }
    
    public void setToggle(boolean x) {
        toggle = x;
        if (toggle) {
            setBackground(new java.awt.Color(116, 141, 129));
        } else {
            setBackground(new java.awt.Color(84, 113, 106));
        }
    }
}
