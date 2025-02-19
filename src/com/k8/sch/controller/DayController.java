/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.k8.sch.controller;

import com.k8.sch.config.Conection;
import com.k8.sch.model.Day;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hp
 */
public class DayController implements BaseController {
  
    private String day_name;
    private String sql;
    public DayController(String day_name) {
        this.day_name = day_name;
    }

    public DayController() {
    }
    
    public List<Map<String, String>> getData() throws Exception
    {
        sql = "SELECT * FROM `days`";
        PreparedStatement ps = Conection.openConection().prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        int no = 1;
        while(rs.next())
        {
            Map<String, String> item = new HashMap<String, String>();
            item.put("no", String.valueOf(no));
            item.put("day_name", rs.getString("day_name"));
            data.add(item);
            no++;
        }
        return data;
    }
    public Day getTableModel() throws Exception
    {
        System.out.println(getData().get(0).get("day_name"));
        String[] colname = {"no","nama_hari"};
        return new Day(getData(), colname);
    }
    @Override
    public void insertData() throws Exception {
        sql = "INSERT INTO `days`(`day_name`) VALUES (?)";
        PreparedStatement ps = Conection.openConection().prepareCall(sql);
        ps.setString(1, day_name);
        ps.executeUpdate();
    }

    @Override
    public void updateData(String id) throws Exception {
        sql = "UPDATE `days` SET `day_name`=? WHERE day_name=?";
        PreparedStatement ps = Conection.openConection().prepareCall(sql);
        ps.setString(1, day_name);
        ps.setString(2, id);
        ps.executeUpdate();
    }

    @Override
    public void hapusData(String id) throws Exception {
        sql = "DELETE FROM `days` WHERE day_name=?";
        PreparedStatement ps = Conection.openConection().prepareCall(sql);
        ps.setString(1, id);
        ps.executeUpdate();
    }
    
}
