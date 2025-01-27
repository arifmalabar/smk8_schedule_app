/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.k8.sch.model;

import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author hp
 */
public class BaseModel extends AbstractTableModel {
    private List<Map<String, String>> data;
    private String[] colname;  
    private int colcount;

    public BaseModel(List<Map<String, String>> data, int colcount) {
        this.data = data;
        this.colcount = colcount;
    }

    public BaseModel(List<Map<String, String>> data, String[] colname) {
        this.data = data;
        this.colname = colname;
    }
    

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        if(colcount == 0)
        {
            return colname.length;
        } else {
            return colcount;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colname[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Map<String, String> item_data = data.get(rowIndex);
        String name = item_data.keySet().toArray()[columnIndex].toString();
        return item_data.get(name);
    }
    
}
