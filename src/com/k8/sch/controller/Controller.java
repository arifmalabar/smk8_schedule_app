/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.k8.sch.controller;

import com.k8.sch.config.Conection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hp
 */
public abstract class Controller {

    protected String selectData, insertData, updateData, deleteData;
    private PreparedStatement ps;
    protected ResultSet onGetData() throws Exception
    {
        ps = Conection.openConection().prepareCall(selectData);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    
}
