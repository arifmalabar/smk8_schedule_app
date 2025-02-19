/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.k8.sch.helper;

import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author hp
 */
public class ClearForm {

    public static void clearTextField(JTextField field)
    {
        field.setText("");
    }
    public static void clearTextField(JTextField[] field)
    {
        for (JTextField j : field) {
            j.setText("");
        }
    }
    public static void clearOptionField(JComboBox[] field, int index)
    {
        for (JComboBox cb : field) {
            cb.setSelectedIndex(index);
        }
    }
    
}
