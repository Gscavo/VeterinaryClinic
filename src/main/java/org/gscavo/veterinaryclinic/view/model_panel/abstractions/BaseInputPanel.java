/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.gscavo.veterinaryclinic.view.model_panel.abstractions;

import org.gscavo.veterinaryclinic.controller.abstractions.BaseController;

/**
 *
 * @author gscavo
 */
public interface BaseInputPanel<T> {
    public static String DATA_PROPERTY_KEY = "data";
    
    public T getData();

    public void setData(T data);

    public BaseController<?> getMainController();
}
