/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.k8.sch.exception;

/**
 *
 * @author hp
 */
public class ValidationErrorException extends Exception {

    public ValidationErrorException(String message) {
        super(message);
    }
    
}
