/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.k8.sch.controller;

import com.k8.sch.config.Conection;
import com.k8.sch.helper.FormValidation;
import com.k8.sch.model.Rooms;
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
public class RoomsController implements BaseController {

    private String rooms_id;
    private int number;
    private String sql;

    public void setRooms_id(String rooms_id) {
        this.rooms_id = rooms_id;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    @Override
    public List<Map<String, String>> getData() throws Exception {
        sql = "SELECT * FROM rooms";
        PreparedStatement ps = Conection.openConection().prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        List<Map<String, String>> model = new ArrayList<Map<String, String>>();
        while(rs.next())
        {
            Map<String, String> item_model = new HashMap<String, String>();
            item_model.put("room_id", rs.getString("room_id"));
            item_model.put("number", String.valueOf(rs.getInt("number")));
            model.add(item_model);
        }
        return model;
    }
    public Rooms getModel() throws Exception
    {
        String[] colname = {"room", "number"};
        return new Rooms(getData(), colname);
    }

    @Override
    public void insertData() throws Exception {
        sql = "INSERT INTO `rooms`(`room_id`, `number`) VALUES (?,?)";
        PreparedStatement ps = Conection.openConection().prepareCall(sql);
        ps.setString(1, rooms_id);
        ps.setInt(2, number);
        ps.executeUpdate();
    }

    @Override
    public void updateData(String id) throws Exception {
         sql = "UPDATE `rooms` SET `room_id`=?, `number`=? WHERE room_id= ?";
        PreparedStatement ps = Conection.openConection().prepareCall(sql);
        ps.setString(1, rooms_id);
        ps.setInt(2, number);
        ps.setString(3, id);
        ps.executeUpdate();
    }

    @Override
    public void hapusData(String id) throws Exception {
       sql = "DELETE FROM `rooms` WHERE room_id= ?";
       PreparedStatement ps = Conection.openConection().prepareCall(sql);
       ps.setString(1, id);
       ps.executeUpdate(); 
    }
    
}
