/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.k8.sch.controller;

import com.k8.sch.config.Conection;
import com.k8.sch.model.Times;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hp
 */
public class TimesController implements BaseController {

    private int hours;
    private Time begin_times, end_times;
    private String sql;

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setBegin_times(Time begin_times) {
        this.begin_times = begin_times;
    }

    public void setEnd_times(Time end_times) {
        this.end_times = end_times;
    }
    public void test()
    {
        System.out.println(begin_times);
    }
    @Override
    public List<Map<String, String>> getData() throws Exception {
        sql = "SELECT * FROM `hours`";
        PreparedStatement st = Conection.openConection().prepareCall(sql);
        ResultSet rs = st.executeQuery();
        List<Map<String, String>> model = new ArrayList<Map<String, String>>();
        while(rs.next())
        {
            Map<String, String> item = new HashMap<String, String>();
            item.put("hour", String.valueOf(rs.getString("hour")));
            item.put("begin_times", String.valueOf(rs.getTime("begin_times")));
            item.put("end_times", String.valueOf(rs.getTime("end_times")));
            model.add(item);
        }
        return model;
    }
    public Times getModel() throws Exception 
    {
        String[] colname = {"jam akhir", "jam ke", "jam awal"};
        return new Times(getData(), colname);
    }

    @Override
    public void insertData() throws Exception {
        sql = "INSERT INTO `hours`(`hour`, `begin_times`, `end_times`) VALUES (?,?,?)";
        PreparedStatement st = Conection.openConection().prepareCall(sql);
        st.setInt(1, hours);
        st.setTime(2, begin_times);
        st.setTime(3, end_times);
        st.executeUpdate();
    }

    @Override
    public void updateData(String id) throws Exception {
        sql = "UPDATE `hours` SET `hour`=?,`begin_times`=?,`end_times`=? WHERE `hour`=?";
        PreparedStatement st = Conection.openConection().prepareCall(sql);
        st.setInt(1, hours);
        st.setTime(2, begin_times);
        st.setTime(3, end_times);
        st.setInt(4, Integer.parseInt(id));
        st.executeUpdate();
    }

    @Override
    public void hapusData(String id) throws Exception {
        sql = "DELETE FROM `hours` WHERE hour=?";
        PreparedStatement st = Conection.openConection().prepareCall(sql);
        st.setInt(1, Integer.parseInt(id));
        st.executeUpdate();
    }
    
}
