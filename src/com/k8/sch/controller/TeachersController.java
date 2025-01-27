/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.k8.sch.controller;

import com.k8.sch.config.Conection;
import com.k8.sch.model.BaseModel;
import com.k8.sch.model.Teachers;
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
public class TeachersController implements BaseController {

    private int nip, jk;
    private String nama, phone;
    private String sql;

    public void setNip(int nip) {
        this.nip = nip;
    }

    public void setJk(int jk) {
        this.jk = jk;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public List<Map<String, String>> getData() throws Exception {
        sql = "SELECT nip, name, phone, gender FROM teachers";
        PreparedStatement ps = Conection.openConection().prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        List<Map<String, String>> model = new ArrayList<Map<String, String>>();
        while(rs.next())
        {
            Map<String, String> item_model = new HashMap<String, String>();
            item_model.put("nip", String.valueOf(rs.getInt("nip")));
            item_model.put("name", rs.getString("name"));
            item_model.put("phone", rs.getString("phone"));
            if(rs.getInt("gender") == 0)
            {
                item_model.put("gender", "pria");
            } else {
                item_model.put("gender", "wanita");
            }
            model.add(item_model);
        }
        return model;
    }
    public Teachers getModel() throws Exception
    {
        String[] colname = {"NIP", "name", "phone", "gender"};
        Teachers tc = new Teachers(getData(), colname);
        return tc;
    }

    @Override
    public void insertData() throws Exception {
        sql = "INSERT INTO `teachers`(`NIP`, `name`, `phone`, `gender`) VALUES (?,?,?,?)";
        PreparedStatement ps = Conection.openConection().prepareCall(sql);
        ps.setInt(1, nip);
        ps.setString(2, nama);
        ps.setString(3, phone);
        ps.setInt(4, jk);
        ps.executeUpdate();
    }

    @Override
    public void updateData(String id) throws Exception {
        sql = "UPDATE `teachers` SET `NIP`=?,`name`=?,`phone`=?,`gender`=? WHERE NIP = ?";
        PreparedStatement ps = Conection.openConection().prepareCall(sql);
        ps.setInt(1, nip);
        ps.setString(2, nama);
        ps.setString(3, phone);
        ps.setInt(4, jk);
        ps.setInt(5, Integer.parseInt(id));
        ps.executeUpdate();
    }

    @Override
    public void hapusData(String id) throws Exception {
        sql = "DELETE FROM `teachers` WHERE NIP = ?";
        PreparedStatement ps = Conection.openConection().prepareCall(sql);
        ps.setInt(1, Integer.parseInt(id));
        ps.executeUpdate();
    }
    
    
}
