/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.k8.sch.main;

import com.k8.sch.config.Conection;
import com.k8.sch.gui.LoadingBox;
import com.k8.sch.gui.LoginGUI;
import com.k8.sch.helper.Loading;
import com.k8.sch.helper.MessageBox;
import java.sql.Connection;
import javax.swing.SwingWorker;

/**
 *
 * @author hp
 */
public class MainApp {
    public static void main(String[] args) {
        new Loading().execute();
        
    }
}
