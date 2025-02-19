/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.k8.sch.helper;

import com.k8.sch.config.Conection;
import com.k8.sch.gui.LoadingBox;
import java.sql.Connection;
import javax.swing.SwingWorker;

/**
 *
 * @author hp
 */
public class Loading extends SwingWorker<Connection, Void>{
    private LoadingBox loading;

    public Loading() {
        loading  = new LoadingBox();
        loading.show();
    }
    
    @Override
    protected Connection doInBackground() throws Exception {
        return Conection.openConection();
    }
    @Override
    protected void done() {
        try {
            loading.hide();
            new MessageBox("Berhasil konek ke database");
            loading.hide();
        } catch (Exception e) {
            loading.hide();
            new MessageBox(e.getMessage());
        }
        
    }
}
