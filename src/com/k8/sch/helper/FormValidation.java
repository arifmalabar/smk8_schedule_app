/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.k8.sch.helper;

import com.k8.sch.exception.ValidationErrorException;

/**
 *
 * @author hp
 */
public class FormValidation {
    public static void checkEmptyField(String string, String message) throws ValidationErrorException{
        if(string.equals("")){
            throw new ValidationErrorException(message);
        } 
    }
    public static void checkZeroField(int number, String message) throws ValidationErrorException{
        if(number == 0){
            throw new ValidationErrorException(message);
        }
    }
    public static void checkEqualsField(String string, String compare, String message) throws ValidationErrorException{
        if(!(string.trim().equals(compare))){
            throw new ValidationErrorException(message);
        }   
    }
}
