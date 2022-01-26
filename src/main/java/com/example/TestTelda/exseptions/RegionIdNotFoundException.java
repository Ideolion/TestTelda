/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.TestTelda.exseptions;

/**
 *
 * @author kiry
 */
public class RegionIdNotFoundException extends RuntimeException{
    
    public RegionIdNotFoundException()
    {
        super("Регион с указанным id не найден");
    }
    
}
