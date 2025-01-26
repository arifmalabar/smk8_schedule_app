/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.k8.sch.config;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;

/**
 *
 * @author hp
 */
public class Conection {
    public static Connection openConection() throws Exception
    {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUser("root");
        ds.setPassword("");
        ds.setURL("jdbc:mysql://localhost:3306/k8_jadwal");
        return ds.getConnection();
    }
}
