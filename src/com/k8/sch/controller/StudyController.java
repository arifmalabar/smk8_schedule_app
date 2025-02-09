/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.k8.sch.controller;

import com.k8.sch.config.Conection;
import com.k8.sch.model.Study;
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
public class StudyController implements BaseController {

    private String kode_mapel;
    private String nama_mapel;
    private String sql;

    /*
        overloading contstructor
        Jika program tidak melakukan aksi apapun atau 
        program hanya memanggil method getData() tanpa melakukan
        set data pada atribut
    */
    public StudyController() {
    }
    /*
        panggil constructor ini jika melakukan set data pada atribut 
        atau program melakukan aksi pada method insertData(), updateData()
        dan deleteData()
    */
    public StudyController(String kode_mapel, String nama_mapel) {
        this.kode_mapel = kode_mapel;
        this.nama_mapel = nama_mapel;
    }

    @Override
    public List<Map<String, String>> getData() throws Exception {
        sql = "SELECT * FROM `study`";
        PreparedStatement ps = Conection.openConection().prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        while(rs.next())
        {
            Map<String, String> item = new HashMap<String, String>();
            item.put("study_id", rs.getString("study_id"));
            item.put("study_name", rs.getString("study_name"));
            data.add(item);
        }
        return data;
    }
    public Study getModel() throws Exception
    {
        String[] colname = {"study id", "study_name"};
        return new Study(getData(), colname);
    }

    @Override
    public void insertData() throws Exception {
        sql = "INSERT INTO `study`(`study_id`, `study_name`) VALUES (?,?)";
        PreparedStatement ps = Conection.openConection().prepareCall(sql);
        ps.setString(1, kode_mapel);
        ps.setString(2, nama_mapel);
        ps.executeUpdate();
    }

    @Override
    public void updateData(String id) throws Exception {
        sql = "UPDATE `study` SET `study_id`=?,`study_name`=? WHERE study_id=?";
        PreparedStatement ps = Conection.openConection().prepareCall(sql);
        ps.setString(1, kode_mapel);
        ps.setString(2, nama_mapel);
        ps.setString(3, id);
        ps.executeUpdate();
    }

    @Override
    public void hapusData(String id) throws Exception {
        sql = "DELETE FROM `study` WHERE study_id=?";
        PreparedStatement ps = Conection.openConection().prepareCall(sql);
        ps.setString(1, id);
        ps.executeUpdate();
    }
    
}
