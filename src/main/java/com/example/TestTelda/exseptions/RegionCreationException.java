/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.TestTelda.exseptions;

/**
 *
 * @author kiry
 */
public class RegionCreationException extends NullPointerException  {
     /**
     * Исключение, которое выбрасывается в случае попытки добавить запросить в
     * базе регион с несуществующим ID
     */
    public RegionCreationException() {
        super("Данных для создания записи недостаточно");
    }
}
