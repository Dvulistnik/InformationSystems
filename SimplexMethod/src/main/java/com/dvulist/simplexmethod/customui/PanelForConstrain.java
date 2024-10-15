/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvulist.simplexmethod.customui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

/**
 *
 * @author user
 */
public class PanelForConstrain extends JPanel {
    private final ArrayList<JSpinner> _spinners = new ArrayList<>();
    private final JComboBox _comboBox;
    private JSpinner _lastSpinner = null;
    
    public PanelForConstrain(int numOfVar, boolean key) {
        super(new FlowLayout(FlowLayout.LEFT, 5, 5));
        
        for (int i = 0; i < numOfVar; i++) {
            JSpinner spinner = new SpinnerWithoutArrows();
            spinner.setPreferredSize(new Dimension(70, 20));
            this.add(spinner);
            this.add(new JLabel("X" + (i + 1) + " + "));
            
            _spinners.add(spinner);
        }
        
        this.remove(this.getComponentCount()-1);
        this.add(new JLabel("X" + numOfVar));
        
        JComboBox<String> comboBox;
        if (key) {
            comboBox = new JComboBox<>(new String[]{"≤", "≥", "="});
            this.add(comboBox);
            
            SpinnerWithoutArrows spinner = new SpinnerWithoutArrows();
            spinner.setPreferredSize(new Dimension(70, 20));
            this.add(spinner);
            
            _lastSpinner = spinner;
        }
        else {
            comboBox = new JComboBox<>(new String[]{"max", "min"});
            
            this.add(new JLabel("→"));
            this.add(comboBox);
        }
        
        _comboBox = comboBox;
    }
    
    public ArrayList<JSpinner> getSpinners() {
        return _spinners;
    }
    public JComboBox getComboBox() {
        return _comboBox;
    }
    public JSpinner getLastSpinner() {
        return _lastSpinner;
    }
}
