/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.k8.sch.helper;

import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class ConfirmDialog {

    public static int ConfirmDialog(String message) {
        return JOptionPane.showConfirmDialog(null, message);
    }
}
