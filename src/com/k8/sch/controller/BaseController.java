/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.k8.sch.controller;

import java.util.List;
import java.util.Map;

/**
 *
 * @author hp
 */
public interface BaseController {
    public List<Map<String, String>> getData() throws Exception;
    public void insertData() throws Exception;
    public void updateData(String id) throws Exception;
    public void hapusData(String id) throws Exception;
}
