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
    private int colcount;

    public BaseModel(List<Map<String, String>> data, int colcount) {
        this.data = data;
        this.colcount = colcount;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return colcount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Map<String, String> item_data = data.get(rowIndex);
        String name = item_data.keySet().toArray()[columnIndex].toString();
        return item_data.get(name);
    }
    
}
