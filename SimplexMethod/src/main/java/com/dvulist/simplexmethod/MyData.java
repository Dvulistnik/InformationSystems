/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvulist.simplexmethod;

import com.dvulist.simplexmethod.customui.PanelForConstrain;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSpinner;

/**
 *
 * @author user
 */
public class MyData {
    public final ArrayList<Double> targetFunctionVars = new ArrayList<>();
//    public final boolean isMax;
    
    public final ArrayList<ArrayList<Double>> rows = new ArrayList<>();
    public final ArrayList<Integer> X = new ArrayList<>();
    
    
    public MyData(JPanel firstPanel, JPanel secondPanel) {
        targetFunctionVars.addAll(Arrays.asList(-10d, -12d, -8d, 0d, 0d, 0d, 0d));
        rows.add(new ArrayList(Arrays.asList(3d, 4d, 2d, 1d, 0d, 0d, 1020d)));
        rows.add(new ArrayList(Arrays.asList(4d, 3d, 3d, 0d, 1d, 0d, 940d)));
        rows.add(new ArrayList(Arrays.asList(5d, 3d, 5d, 0d, 0d, 1d, 1010d)));
        
//        PanelForConstrain panelC1 = (PanelForConstrain) firstPanel.getComponent(0);
//        
//        for (JSpinner spinner : panelC1.getSpinners()) {
//            targetFunctionVars.add((Integer) spinner.getValue() * -1);
//        }
//        
//        isMax = panelC1.getComboBox().getSelectedItem().toString().equals("max");
//        
//        int count = 0;
//        for (Component component : secondPanel.getComponents()) {
//            if (component instanceof PanelForConstrain panelC) {
//                ArrayList<Integer> row = new ArrayList<>();
//                
//                switch((String) panelC.getComboBox().getSelectedItem()) {
//                    case "≤" -> {
//                        for (JSpinner spinner : panelC.getSpinners()) {
//                            row.add((Integer) spinner.getValue());
//                        }
//                        
//                        for (int i = 0; i < secondPanel.getComponentCount(); i++) {
//                            if (i == count) {
//                                row.add(1);
//                                continue;
//                            }
//                            
//                            row.add(0); 
//                        }
//                        
//                        targetFunctionVars.add(0);
//                    }
//                    case "≥" -> {
//                        for (JSpinner spinner : panelC.getSpinners()) {
//                            row.add(((Integer) spinner.getValue()) * -1);
//                        }
//                        
//                        for (int i = 0; i < secondPanel.getComponentCount(); i++) {
//                            if (i == count) {
//                                row.add(1);
//                                continue;
//                            }
//                            
//                            row.add(0); 
//                        }
//                        
//                        targetFunctionVars.add(0);
//                    }
//                    case "=" -> {
//                        for (JSpinner spinner : panelC.getSpinners()) {
//                            row.add((Integer) spinner.getValue());
//                        }
//                    }
//                }
//                
//                row.add((Integer) panelC.getLastSpinner().getValue());
//
//                rows.add(row);
//                count++;
//            }
//        }
//        
//        targetFunctionVars.add(0);

        for (int i = rows.size()+1; i < targetFunctionVars.size(); i++) {
            X.add(i);
        }
    }
    
    public void SimplexMaximizationMethod() {
        double minValue = Collections.min(targetFunctionVars);
        if (minValue >= 0) {
            System.out.println("");
            return;
        }
        int colIndex = targetFunctionVars.indexOf(minValue);
        
        ArrayList<Double> lastCol = new ArrayList<>();
        
        for (int i = 0; i < rows.size(); i++) {
            ArrayList<Double> row = rows.get(i);
            lastCol.add(row.getLast()/row.get(colIndex));
        }
        
        int rowIndex = lastCol.indexOf(Collections.min(lastCol)); // A slightly wrong decision
        double base = rows.get(rowIndex).get(colIndex);
        
        for (int i = 0; i < targetFunctionVars.size(); i++) {
            rows.get(rowIndex).set(i, rows.get(rowIndex).get(i)/base);
        }
        
        for (int i = 0; i < rows.size(); i++) {
            if (i == rowIndex)continue;
            
            double num = rows.get(i).get(colIndex);
            for (int j = 0; j < targetFunctionVars.size(); j++) {
                rows.get(i).set(j, rows.get(i).get(j) - rows.get(rowIndex).get(j) * num);
            }
        }
        
        double num = targetFunctionVars.get(colIndex);
        for (int i = 0; i < targetFunctionVars.size(); i++) {
                targetFunctionVars.set(i, targetFunctionVars.get(i) - rows.get(rowIndex).get(i) * num);
        }
        
        X.set(rowIndex, colIndex+1);
    }
}
