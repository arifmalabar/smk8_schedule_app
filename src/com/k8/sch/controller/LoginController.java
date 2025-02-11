/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.k8.sch.controller;

import com.k8.sch.config.Conection;
import com.k8.sch.gui.LoginGUI;
import com.k8.sch.gui.MainGUI;
import com.k8.sch.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class LoginController {
    private String username;
    private String password;
    private final String sql = "SELECT * FROM `user` WHERE `email` = ? AND `password` = ?";
    public User userData;
    
    public LoginController() {
    }

    public LoginController(String username, String password) {
        this.username = username;
        this.password = password;
    }
   
    public void doLogin() throws Exception
    {
        PreparedStatement ps = Conection.openConection().prepareCall(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if(rs.first())
        {
            User.user_id = rs.getString("user_id");
            User.email = rs.getString("email");
            User.name = rs.getString("name");
            User.password = rs.getString("password");
            new MainGUI().show();
        } else {
            throw new Exception("Username dan password anda salah");
        }
    }
    
}
