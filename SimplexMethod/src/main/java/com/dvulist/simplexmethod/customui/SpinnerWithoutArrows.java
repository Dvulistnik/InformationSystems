/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvulist.simplexmethod.customui;

import java.awt.Component;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.plaf.basic.BasicSpinnerUI;

/**
 *
 * @author user
 */
public class SpinnerWithoutArrows extends JSpinner {
    public SpinnerWithoutArrows() {
        super();
        setUI(new BasicSpinnerUI() {
            @Override
            protected Component createNextButton() {
                return null;
            }

            @Override
            protected Component createPreviousButton() {
                return null;
            }
        });
    }
}
