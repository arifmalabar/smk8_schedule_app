/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.k8.sch.controller;

import com.k8.sch.config.Conection;
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
public class StudyPeriodController {
    public List<Map<String, String>> getData() throws Exception{
        String sql = "SELECT * FROM `study_period`";
        PreparedStatement ps = Conection.openConection().prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        while(rs.next())
        {
            Map<String, String> item = new HashMap<String, String>();
            item.put("year", rs.getString("year"));
            item.put("stud_period", rs.getString("stud_period"));
            data.add(item);
        }
        return data;
    }
}
