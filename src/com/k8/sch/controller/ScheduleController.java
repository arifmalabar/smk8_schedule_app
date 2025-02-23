/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.k8.sch.controller;

import com.k8.sch.config.Conection;
import com.k8.sch.exception.GuruKosongException;
import com.k8.sch.exception.JadwalNotFoundException;
import com.k8.sch.helper.MessageBox;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Year;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class ScheduleController implements BaseController {

    private String schedule_id, dayname;
    private String room_id, study_id;
    private int hour, NIP;
    private int from_time, to_time;
    private Year year;
    
    private String sql;

    public void setSchedule_id(String schedule_id) {
        this.schedule_id = schedule_id;
    }

    public void setDayname(String dayname) {
        this.dayname = dayname;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public void setStudy_id(String study_id) {
        this.study_id = study_id;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setFrom_time(int from_time) {
        this.from_time = from_time;
    }

    public void setTo_time(int to_time) {
        this.to_time = to_time;
    }

    public void setNIP(int NIP) {
        this.NIP = NIP;
    }

    public void setYear(Year year) {
        this.year = year;
    }
    
    @Override
    public List<Map<String, String>> getData() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertData() throws Exception {
        if(!(isRoomUsed())){
            throw new JadwalNotFoundException("Ruangan sudah digunakan di jam lain");
        } else if(!(isGuruKosong())){
            throw new GuruKosongException("Guru mengajar di jam lain");
        } else {
            sql = "INSERT INTO `schedule`(`schedule_id`, `hour`, `day_name`, `room_id`, `year`, `NIP`, `study_id`) VALUES ('[value-1]','[value-2]','[value-3]','[value-4]','[value-5]','[value-6]','[value-7]')";
        }
    }
    
    private boolean isRoomUsed() throws Exception
    {
        sql = "SELECT * FROM `schedule` WHERE hour= ? AND room_id = ?";
        PreparedStatement ps = Conection.openConection().prepareCall(sql);
        ps.setInt(1, hour);
        ps.setString(2, room_id);
        ResultSet rs = ps.executeQuery();
        if(rs.first()){
            return false; //jika ruangan digunakan
        } else {
            return true; //jika ruangan tidak digunakan
        }
    }
    private boolean isGuruKosong() throws Exception
    {
        sql = "SELECT * FROM `schedule` WHERE NIP=? AND day_name=? AND hour=?";
        PreparedStatement ps = Conection.openConection().prepareCall(sql);
        ps.setInt(1, NIP);
        ps.setString(2, dayname);
        ps.setInt(3, hour);
        ResultSet rs = ps.executeQuery();
        if(rs.first()){
            return false;
        } else {
            return true;
        }
    }
    
    @Override
    public void updateData(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hapusData(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
